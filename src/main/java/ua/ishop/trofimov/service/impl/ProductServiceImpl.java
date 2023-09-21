package ua.ishop.trofimov.service.impl;

import org.apache.log4j.Logger;
import ua.ishop.trofimov.dao.ProductDao;
import ua.ishop.trofimov.factory.ProductDaoFactory;
import ua.ishop.trofimov.model.Product;
import ua.ishop.trofimov.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private static final Logger logger = Logger.getLogger(ProductServiceImpl.class);
    private static final ProductDao productDao = ProductDaoFactory.getInstance();

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return productDao.getProducts();
    }

    @Override
    public Product findProductByName(String name) {
        return productDao.findProductByName(name);
    }

    @Override
    public Product getProductById(long id) {
        return productDao.getProductById(id);
    }

    @Override
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    @Override
    public void deleteProductById(long id) {
        productDao.deleteProductById(id);
    }
}
