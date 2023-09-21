package ua.ishop.trofimov.controller.Products;
import org.apache.log4j.Logger;

import ua.ishop.trofimov.factory.ProductServiceFactory;
import ua.ishop.trofimov.model.Product;
import ua.ishop.trofimov.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/product")
public class AllProductServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(AllProductServlet.class);
    private static final ProductService productService = ProductServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.getProducts();

        req.setAttribute("allProducts", products);
        req.getRequestDispatcher("/products.jsp").forward(req, resp);
    }


}