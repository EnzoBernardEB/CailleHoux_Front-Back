package fr.ecommerce.caillehoux.domaineService.product;

import fr.ecommerce.caillehoux.entity.product.Order;
import fr.ecommerce.caillehoux.exception.StockException;

import java.util.List;

public interface OrderService {
    public List<Order> getAllOrders();
    public Order create(Order order);
    public void update(Order order) throws StockException;
}
