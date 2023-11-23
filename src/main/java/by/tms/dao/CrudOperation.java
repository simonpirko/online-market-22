package by.tms.dao;

import java.util.Optional;

/*
    @author Ilya Moiseenko on 22.11.23
*/

public interface CrudOperation<T> {

    void save(T entity);
    Optional<T> findById(Long id, Class<T> clazz);
    void remove(T entity);
    void update(T updatedEntity);
}
