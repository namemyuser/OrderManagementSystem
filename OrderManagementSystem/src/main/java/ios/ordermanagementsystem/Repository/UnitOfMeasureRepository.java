package ios.ordermanagementsystem.Repository;

import ios.ordermanagementsystem.Model.UnitOfMeasure;

import java.util.List;

public interface UnitOfMeasureRepository {

    List<UnitOfMeasure> findAll();

    UnitOfMeasure findById(String id);

    UnitOfMeasure save(UnitOfMeasure unit);

    void update(UnitOfMeasure unit);

    void deleteById(String id);

    void delete(String id);
}
