package main;

import util.Database;
import view.MainFrame;
import view.Tampilan;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Tampilan.pasang();   // Look and Feel FlatLaf
            try {
                Database.tes();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Tidak dapat terhubung ke database volt.\nPeriksa MySQL & file db.properties.\n\n" + e.getMessage(),
                        "Koneksi Database Gagal", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
            new MainFrame().setVisible(true);
        });
    }
}
