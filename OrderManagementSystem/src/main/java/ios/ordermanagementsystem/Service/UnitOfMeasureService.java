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
    public void addUnit(UnitOfMeasure unit) { repository.save(unit); }
    public UnitOfMeasure getUnit(String id) { return repository.findById(id); }
    public List<UnitOfMeasure> getAllUnits() { return repository.findAll(); }
    public void removeUnit(String id) { repository.deleteById(id); }
}
