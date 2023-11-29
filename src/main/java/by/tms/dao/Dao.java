package by.tms.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T, ID> {

    T save(T entity);
    Optional<T> findById(ID id);
    List<T> findAll();
    void remove(T entity);
    void removeById(ID id);
    void update(T entity);
}
