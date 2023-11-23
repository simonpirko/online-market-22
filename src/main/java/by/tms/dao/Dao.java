package by.tms.dao;

import java.util.List;
import java.util.Optional;

public interface Dao <T>{
        boolean save(T value);
        boolean remove(long id);
        boolean remove(T value);
        List<T> findAll();
        T findById(long id);

}
