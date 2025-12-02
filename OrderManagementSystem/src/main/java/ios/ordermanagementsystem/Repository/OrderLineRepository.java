package ios.ordermanagementsystem.Repository;

import ios.ordermanagementsystem.Model.OrderLine;

import java.util.List;

public interface OrderLineRepository {

    List<OrderLine> findAll();

    OrderLine findById(String id);

    OrderLine save(OrderLine orderLine);

    void update(OrderLine orderLine);

    void deleteById(String id);

}
