package by.tms.dao.variationDao;

/*
    @author Ilya Moiseenko on 22.11.23
*/

import by.tms.dao.Dao;
import by.tms.entity.product.Variation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class VariationDao implements Dao<Variation, Long> {

    @Override
    public Variation save(Variation variation) {
        return null;
    }


    @Override
    public Optional<Variation> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Variation> findAll() {
        return null;
    }

    @Override
    public void remove(Variation variation) {

    }


    @Override
    public void removeById(Long id) {

    }

    @Override
    public void update(Variation variation) {

    }
}
