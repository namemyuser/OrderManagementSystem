package ios.ordermanagementsystem.Service;

import ios.ordermanagementsystem.Model.UnitOfMeasure;
import ios.ordermanagementsystem.Repository.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitOfMeasureService {

    private final UnitOfMeasureRepository repository;

    public UnitOfMeasureService(UnitOfMeasureRepository repository) {
        this.repository = repository;
    }

    public UnitOfMeasure addUnit(UnitOfMeasure unit) {
        return repository.save(unit);
    }

    public UnitOfMeasure getUnit(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<UnitOfMeasure> getAllUnits() {
        return repository.findAll();
    }

    public void removeUnit(Long id) {
        repository.deleteById(id);
    }
}
