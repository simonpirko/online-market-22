package by.tms.dao.variationOptionDao;

/*
    @author Ilya Moiseenko on 22.11.23
*/

import by.tms.dao.Dao;
import by.tms.entity.catalogProduct.VariationOption;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class VariationOptionDao implements Dao<VariationOption, Long> {
    @Override
    public VariationOption save(VariationOption variationOption) {
        return null;
    }

    @Override
    public Optional<VariationOption> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<VariationOption> findAll() {
        return null;
    }

    @Override
    public void remove(VariationOption variationOption) {

    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public void update(VariationOption variationOption) {

    }
}
