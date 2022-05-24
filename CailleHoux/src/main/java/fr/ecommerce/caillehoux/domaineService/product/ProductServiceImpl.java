package fr.ecommerce.caillehoux.domaineService.product;

import fr.ecommerce.caillehoux.entity.product.Product;
import fr.ecommerce.caillehoux.exception.ResourceNotFoundException;
import fr.ecommerce.caillehoux.exception.StockException;
import fr.ecommerce.caillehoux.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service("products")
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {

        Optional<Product> result = productRepository.findById(id);

        if (result.isPresent()) {
            return result.get();
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean isProductAvailable(Product product, int quantity) {
        if (product.getQuantity() > this.productRepository.getById(product.getId()).getQuantity())
            return false;
        return true;
    }

    @Override
    public void removeProduct(long productId, int quantity) throws StockException, ResourceNotFoundException {
        Optional<Product> targetProduct = this.productRepository.findById(productId);
        if (targetProduct.isPresent()) {
            long newQuantity =  targetProduct.get().getQuantity() - quantity;
            if (newQuantity < 0) {
                throw new StockException("Pas de stock wesh");
            } else {
                targetProduct.get().setQuantity(newQuantity);
                this.save(targetProduct.get());
            }
        } else {
            throw new ResourceNotFoundException();

        }
    }
}
