package controller;

import dao.*;
import model.*;
import util.AppException;
import util.Konstanta;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

public class PetugasController extends BaseController {
    private final Pengguna petugas;
    private final PelangganDao pelangganDao = new PelangganDao();
    private final TagihanDao tagihanDao = new TagihanDao();
    private final PengaduanDao pengaduanDao = new PengaduanDao();
    private final GolonganDao golonganDao = new GolonganDao();

    public PetugasController(Pengguna petugas) { this.petugas = petugas; }

    public List<Pelanggan> daftarPelanggan() { return pelangganDao.findByStatus(Konstanta.AKUN_AKTIF); }

    public BigDecimal saranMeterAwal(Pelanggan p) {
        BigDecimal m = tagihanDao.meterAkhirTerakhir(p.getId());
        return m == null ? BigDecimal.ZERO : m;
    }

    /**
     * Alur: cek periode -> validasi meter -> hitung kWh & total -> simpan -> tampilkan hasil.
     * total_biaya = kWh x tarif_per_kwh + biaya_beban (golongan pelanggan). Dihitung di sini karena tidak ada trigger.
     */
    public Tagihan buatTagihan(Pelanggan p, String bulan, String tahun, String awal, String akhir,
                               String jatuhTempo) {
        if (p == null) throw new AppException("Pilih pelanggan terlebih dahulu.");
        int b = bilangan(bulan, "Bulan");
        int t = bilangan(tahun, "Tahun");
        if (b < 1 || b > 12) throw new AppException("Bulan harus 1-12.");
        if (t < 2000 || t > 2100) throw new AppException("Tahun harus 2000-2100.");
        if (tagihanDao.periodeAda(p.getId(), b, t)) throw new AppException("Tagihan Periode Ini Sudah Ada");
        BigDecimal ma = angka(awal, "Meter awal");
        BigDecimal mk = angka(akhir, "Meter akhir");
        if (ma.signum() < 0 || mk.compareTo(ma) < 0) throw new AppException("Nominal tidak valid: meter akhir harus >= meter awal.");
        LocalDate jt = tanggal(jatuhTempo, "Jatuh tempo");

        Golongan g = golonganDao.findById(p.getIdGolongan());
        if (g == null) throw new AppException("Golongan tarif pelanggan tidak ditemukan.");
        BigDecimal kwh = mk.subtract(ma);
        BigDecimal total = kwh.multiply(g.getTarifPerKwh()).add(g.getBiayaBeban()).setScale(2, RoundingMode.HALF_UP);

        Tagihan tg = new Tagihan();
        tg.setIdPelanggan(p.getId()); tg.setBulan(b); tg.setTahun(t);
        tg.setMeterAwal(ma); tg.setMeterAkhir(mk); tg.setKwh(kwh); tg.setTotal(total);
        tg.setJatuhTempo(jt); tg.setIdPetugas(petugas.getId());
        // Database mewajibkan kasir penanggung jawab: ditentukan otomatis (beban tagihan belum lunas terendah).
        Integer kasir = tagihanDao.kasirBebanTerendah();
        if (kasir == null) throw new AppException("Belum ada akun kasir. Buat akun kasir terlebih dahulu (menu Admin).");
        tg.setIdKasir(kasir);
        return tagihanDao.findById(tagihanDao.insert(tg));
    }

    public List<Pengaduan> daftarPengaduan() { return pengaduanDao.findAll(); }

    public void perbaruiStatus(Pengaduan a, String status) {
        if (a == null) throw new AppException("Pilih pengaduan terlebih dahulu.");
        if (!Konstanta.ADUAN_DIAJUKAN.equals(status) && !Konstanta.ADUAN_DIPROSES.equals(status)
                && !Konstanta.ADUAN_SELESAI.equals(status)) {
            throw new AppException("Status pengaduan tidak valid.");
        }
        if (status.equals(a.getStatus())) {
            throw new AppException("Pengaduan ini sudah berstatus \"" + status + "\". Pilih status yang berbeda.");
        }
        pengaduanDao.updateStatus(a.getId(), status, petugas.getId());
    }
}
