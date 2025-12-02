package ios.ordermanagementsystem.Repository;

import ios.ordermanagementsystem.Model.UnitOfMeasure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FileUnitOfMeasureRepository extends InFileRepository<UnitOfMeasure>
        implements UnitOfMeasureRepository {

    public FileUnitOfMeasureRepository() {
        // JSON file: src/main/resources/data/unitOfMeasure.json
        super(UnitOfMeasure.class, "unitOfMeasure.json",
                UnitOfMeasure::getId, UnitOfMeasure::setId);
    }

    @Override
    public List<UnitOfMeasure> findAll() {
        return findAllInternal();
    }

    @Override
    public UnitOfMeasure findById(String id) {
        return findByIdInternal(id);
    }

    @Override
    public UnitOfMeasure save(UnitOfMeasure unit) {
        return saveInternal(unit);
    }

    @Override
    public void update(UnitOfMeasure unit) {
        updateInternal(unit);
    }

    @Override
    public void deleteById(String id) {
        deleteByIdInternal(id);
    }

    @Override
    public void delete(String id) {

    }
}
