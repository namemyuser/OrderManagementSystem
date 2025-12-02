package ios.ordermanagementsystem.Repository;

import ios.ordermanagementsystem.Model.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();

    Product findById(String id);

    Product save(Product product);

    void update(Product product);

    void deleteById(String id);

}
