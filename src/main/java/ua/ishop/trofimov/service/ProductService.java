package ua.ishop.trofimov.service;

import ua.ishop.trofimov.model.Product;
import ua.ishop.trofimov.model.User;

import java.util.List;

public interface ProductService {

    void save(Product product);

    List<Product> getProducts();

    Product findProductByName(String name);
    Product getProductById(long id);
    void updateProduct(Product product);
    void deleteProductById(long id);

}