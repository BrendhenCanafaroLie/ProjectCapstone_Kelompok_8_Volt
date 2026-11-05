package controller;

import dao.PelangganDao;
import dao.PembayaranDao;
import dao.PengaduanDao;
import dao.TagihanDao;
import model.*;
import util.AppException;
import util.Konstanta;
import util.PasswordUtil;
import java.math.BigDecimal;
import java.util.List;

public class PelangganController extends BaseController {
    private Pelanggan pelanggan;
    private final PelangganDao pelangganDao = new PelangganDao();
    private final TagihanDao tagihanDao = new TagihanDao();
    private final PembayaranDao pembayaranDao = new PembayaranDao();
    private final PengaduanDao pengaduanDao = new PengaduanDao();

    public PelangganController(Pelanggan pelanggan) { this.pelanggan = pelanggan; }

    public Pelanggan profil() { return pelanggan; }

    public void perbaruiProfil(String alamat, String telp, String passwordBaru) {
        isi(alamat, "Alamat"); isi(telp, "No. telepon"); telepon(telp.trim());
        String hash = null;
        if (passwordBaru != null && !passwordBaru.isEmpty()) {
            PasswordUtil.validasi(passwordBaru);
            hash = passwordBaru;
        }
        pelangganDao.updateProfil(pelanggan.getId(), alamat.trim(), telp.trim(), hash);
        pelanggan = pelangganDao.findById(pelanggan.getId());
    }

    public List<Tagihan> tagihanSaya() { return tagihanDao.findByPelanggan(pelanggan.getId()); }

    /** Pembayaran online: hanya metode digital, id_kasir = NULL, sekali bayar langsung lunas. */
    public Pembayaran bayarOnline(Tagihan t) {
        if (t == null) throw new AppException("Pilih tagihan terlebih dahulu.");
        if (t.getIdPelanggan() != pelanggan.getId()) throw new AppException("Tagihan bukan milik Anda.");
        if (!Konstanta.belumLunas(t.getStatus())) throw new AppException("Tagihan Sudah Lunas");
        return pembayaranDao.bayar(t.getId(), null, Konstanta.METODE_DIGITAL);
    }

    public void laporGangguan(String lokasi, String deskripsi, Double lintang, Double bujur) {
        if (lintang == null || bujur == null) throw new AppException("Lintang dan bujur wajib diisi (klik Ambil Lokasi).");
        if (lintang < -90 || lintang > 90 || bujur < -180 || bujur > 180)
            throw new AppException("Koordinat tidak valid.");
        Pengaduan a = new Pengaduan();
        a.setLintang(lintang);
        a.setBujur(bujur);
        a.setLokasi(isi(lokasi, "Lokasi"));
        a.setDeskripsi(isi(deskripsi, "Deskripsi"));
        a.setIdPelanggan(pelanggan.getId());
        pengaduanDao.insert(a);
    }

    public List<Pengaduan> pengaduanSaya() { return pengaduanDao.findByPelanggan(pelanggan.getId()); }

    public String pesanStatus(Pengaduan a) {
        return Konstanta.ADUAN_SELESAI.equals(a.getStatus())
                ? "Laporan Gangguan Telah Di Tangani, Terima Kasih Atas Laporannya"
                : "Pengaduan Masih Dalam Proses, Terima Kasih Atas Kesabarannya";
    }
}
