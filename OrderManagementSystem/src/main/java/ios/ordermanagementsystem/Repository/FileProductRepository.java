package ios.ordermanagementsystem.Repository;

import ios.ordermanagementsystem.Model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FileProductRepository extends InFileRepository<Product>
        implements ProductRepository {

    public FileProductRepository() {
        // JSON file: src/main/resources/data/product.json
        super(Product.class, "product.json",
                Product::getId, Product::setId);
    }

    @Override
    public List<Product> findAll() {
        return findAllInternal();
    }

    @Override
    public Product findById(String id) {
        return findByIdInternal(id);
    }

    @Override
    public Product save(Product product) {
        return saveInternal(product);
    }

    @Override
    public void update(Product product) {
        updateInternal(product);
    }

    @Override
    public void deleteById(String id) {
        deleteByIdInternal(id);
    }
}
