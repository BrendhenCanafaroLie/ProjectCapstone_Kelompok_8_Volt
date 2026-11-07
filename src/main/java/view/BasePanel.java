package view;

import view.auth.LayarMasuk;

import util.AppException;
import javax.swing.JPanel;

/**
 * INHERITANCE: semua panel (JPanel Form) mewarisi ini.
 * Tidak mengatur layout/border supaya desain sepenuhnya ditentukan di NetBeans Designer.
 * Panel dibuat transparan agar kartu/latar dari induknya (BaseMenuPanel / LayarMasuk) terlihat.
 */
public abstract class BasePanel extends JPanel implements Refreshable {

    protected BasePanel() { setOpaque(false); }

    /** Jalankan aksi; error aplikasi/database tampil sebagai dialog, bukan crash. */
    protected void jalankan(Runnable aksi) {
        try {
            aksi.run();
        } catch (AppException e) {
            Ui.error(this, e.getMessage());
        } catch (RuntimeException e) {
            e.printStackTrace();
            Ui.error(this, "Terjadi kesalahan: " + e.getMessage());
        }
    }
}
