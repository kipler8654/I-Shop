package ua.ishop.trofimov.factory;

import org.apache.log4j.Logger;
import ua.ishop.trofimov.dao.ProductDao;
import ua.ishop.trofimov.dao.impl.ProductDaoPostgresImpl;

public class ProductDaoFactory {
    private static final Logger logger = Logger.getLogger(ProductDaoFactory.class);

    private static ProductDao instance;

    private ProductDaoFactory() {
    }

    public static synchronized ProductDao getInstance() {
        if (instance == null) {
            instance = new ProductDaoPostgresImpl();
        }
        return instance;
    }
}
