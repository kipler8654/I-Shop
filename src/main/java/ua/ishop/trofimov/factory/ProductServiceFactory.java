package ua.ishop.trofimov.factory;

import org.apache.log4j.Logger;
import ua.ishop.trofimov.service.ProductService;
import ua.ishop.trofimov.service.impl.ProductServiceImpl;

public class ProductServiceFactory {
    private static final Logger logger = Logger.getLogger(ProductServiceFactory.class);
    private static ProductService instance;

    private ProductServiceFactory() {
    }

    public static synchronized ProductService getInstance() {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }
}
