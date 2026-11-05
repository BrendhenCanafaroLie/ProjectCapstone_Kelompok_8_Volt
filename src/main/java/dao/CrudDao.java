package dao;

import java.util.List;

/** ABSTRAKSI: kontrak CRUD generik yang diimplementasi DAO. */
public interface CrudDao<T, ID> {
    int insert(T obj);
    void update(T obj);
    void delete(ID id);
    T findById(ID id);
    List<T> findAll();
}
