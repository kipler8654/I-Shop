package ua.ishop.trofimov.dao;

import ua.ishop.trofimov.model.Product;

import java.util.List;

public interface ProductDao {

    void save(Product product);

    List<Product> getProducts();

    Product findProductByName(String name);

    Product getProductById(long id);

    void updateProduct(Product product);

    void deleteProductById(long id);
}
