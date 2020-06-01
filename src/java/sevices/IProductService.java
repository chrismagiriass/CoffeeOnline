
package sevices;

import entities.Product;
import java.util.List;


public interface IProductService {
    Product findById(Integer id);
    
    List<Product> findAllProducts();
    
    void saveProduct(Product p);
    
    void updateProduct(Product p);
    
    void deleteProductById(Integer id);
    
}
