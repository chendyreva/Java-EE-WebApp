package com.shop.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.shop.persist.Product;
import com.shop.persist.ProductRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;



public class ProductServlet extends HttpServlet {



    private Logger logger = LoggerFactory.getLogger(ProductServlet.class);

    private ProductRepositoryImpl productRepository;

    @Override
    public void init() throws ServletException {
        this.productRepository = (ProductRepositoryImpl) getServletContext().getAttribute("productRepository");

        if (productRepository == null) {
            throw new ServletException("ProductRepository not created");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getServletPath().equals("/")) {
            req.setAttribute("products", productRepository.findAll());
            getServletContext().getRequestDispatcher("/catalog.xhtml").forward(req, resp);
        } else if (req.getServletPath().equals("/create")) {
            showCreateProductPage(req, resp);
        } else if (req.getServletPath().equals("/edit")) {
            showEditProductPage(req, resp);
        } else if (req.getServletPath().equals("/delete")) {
            deleteProduct(req, resp);
        }
        resp.setHeader("Content-type", "text/html; charset=Utf8");
    }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            if (req.getServletPath().equals("/update")) {
                updateProduct(req, resp);
            } else if (req.getServletPath().equals("/create")) {
                createProduct(req, resp);
            } else {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        }

        private void createProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            try {
                productRepository.insert(new Product(
                        -1L,
                        req.getParameter("name"),
                        req.getParameter("description"),
                        new BigDecimal(req.getParameter("price"))
                ));
                resp.sendRedirect(getServletContext().getContextPath());
            } catch (NumberFormatException ex) {
                logger.error("", ex);
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        }

        private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            try {
                productRepository.update(new Product(
                        Long.parseLong(req.getParameter("id")),
                        req.getParameter("name"),
                        req.getParameter("description"),
                        new BigDecimal(req.getParameter("price"))
                ));
                resp.sendRedirect(getServletContext().getContextPath());
            } catch (NumberFormatException ex) {
                logger.error("", ex);
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        }

        private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            try {
                productRepository.delete(Long.parseLong(req.getParameter("id")));
                resp.sendRedirect(getServletContext().getContextPath());
            } catch (NumberFormatException ex) {
                logger.error("", ex);
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        }

        private void showEditProductPage(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
            long id;
            try {
                id = Long.parseLong(req.getParameter("id"));
            } catch (Exception ex) {
                logger.error("", ex);
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }
            Product product;
            product = productRepository.findById(id);
            req.setAttribute("product", product);
            req.setAttribute("action", "update");
            getServletContext().getRequestDispatcher("/catalog.xhtml").forward(req, resp);
        }

        private void showCreateProductPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
        {
            req.setAttribute("product", new Product());
            req.setAttribute("action", "create");
            getServletContext().getRequestDispatcher("/product.xhtml").forward(req, resp);
        }

    }

