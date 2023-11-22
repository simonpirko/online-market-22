package by.tms.dao;

import java.util.Optional;

/*
    @author Ilya Moiseenko on 22.11.23
*/

public interface CrudOperation<T> {

    void save(T productCategory);
    Optional<T> findById(Long id);
    void remove(T productCategory);
    void update(T updated);
}
