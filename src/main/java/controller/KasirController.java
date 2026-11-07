package controller;

import dao.PembayaranDao;
import dao.TagihanDao;
import model.Pembayaran;
import model.Pengguna;
import model.Tagihan;
import util.AppException;
import util.Konstanta;
import java.util.List;

public class KasirController extends BaseController {
    private final Pengguna kasir;
    private final TagihanDao tagihanDao = new TagihanDao();
    private final PembayaranDao pembayaranDao = new PembayaranDao();

    public KasirController(Pengguna kasir) { this.kasir = kasir; }

    public List<Tagihan> tagihanBelumLunas(String kataKunci) {
        return tagihanDao.findBelumLunas(kataKunci);
    }

    /** Alur: pilih tagihan -> cek belum lunas -> metode (tunai/digital) -> bayar sekali lunas -> struk. */
    public Pembayaran bayar(Tagihan t, String metode) {
        if (t == null) throw new AppException("Pilih tagihan terlebih dahulu.");
        if (!Konstanta.METODE_TUNAI.equals(metode) && !Konstanta.METODE_DIGITAL.equals(metode)) {
            throw new AppException("Metode Pembayaran Tidak Ada Atau Tidak Valid");
        }
        return pembayaranDao.bayar(t.getId(), kasir.getId(), metode);
    }

    public List<Pembayaran> riwayat() { return pembayaranDao.findByKasir(kasir.getId()); }
}
