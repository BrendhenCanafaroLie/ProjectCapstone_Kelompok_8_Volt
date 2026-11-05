package dao;

import model.Golongan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GolonganDao extends BaseDao implements CrudDao<Golongan, Integer> {

    private Golongan map(ResultSet rs) throws SQLException {
        return new Golongan(rs.getInt("id_golongan"), rs.getString("kode_golongan"), rs.getInt("daya_va"),
                rs.getBigDecimal("tarif_per_kwh"), rs.getBigDecimal("biaya_beban"));
    }

    @Override public int insert(Golongan g) {
        String sql = "INSERT INTO golongan(kode_golongan,daya_va,tarif_per_kwh,biaya_beban) VALUES(?,?,?,?)";
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, g.getKode());
            ps.setInt(2, g.getDayaVa());
            ps.setBigDecimal(3, g.getTarifPerKwh());
            ps.setBigDecimal(4, g.getBiayaBeban());
            ps.executeUpdate();
            try (ResultSet k = ps.getGeneratedKeys()) { return k.next() ? k.getInt(1) : 0; }
        } catch (SQLException e) { throw gagal("Gagal menambah golongan", e); }
    }

    @Override public void update(Golongan g) {
        String sql = "UPDATE golongan SET kode_golongan=?,daya_va=?,tarif_per_kwh=?,biaya_beban=? WHERE id_golongan=?";
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, g.getKode());
            ps.setInt(2, g.getDayaVa());
            ps.setBigDecimal(3, g.getTarifPerKwh());
            ps.setBigDecimal(4, g.getBiayaBeban());
            ps.setInt(5, g.getId());
            ps.executeUpdate();
        } catch (SQLException e) { throw gagal("Gagal memperbarui golongan", e); }
    }

    @Override public void delete(Integer id) {
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement("DELETE FROM golongan WHERE id_golongan=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) { throw gagal("Gagal menghapus golongan (mungkin masih dipakai pelanggan)", e); }
    }

    @Override public Golongan findById(Integer id) {
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement("SELECT * FROM golongan WHERE id_golongan=?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) { return rs.next() ? map(rs) : null; }
        } catch (SQLException e) { throw gagal("Gagal membaca golongan", e); }
    }

    @Override public List<Golongan> findAll() {
        List<Golongan> list = new ArrayList<>();
        try (Connection c = conn(); Statement st = c.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM golongan ORDER BY daya_va, kode_golongan")) {
            while (rs.next()) list.add(map(rs));
            return list;
        } catch (SQLException e) { throw gagal("Gagal membaca golongan", e); }
    }
}
