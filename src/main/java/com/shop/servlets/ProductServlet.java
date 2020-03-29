package com.shop.servlets;

import com.shop.persist.Product;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name ="ProductServlet", urlPatterns = "/product")
public class ProductServlet<P> extends HttpServlet {

    private static final long serialVersionUID = 1L;

    //private Logger logger = LoggerFactory.getLogger(ProductServlet.class);

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Inside servlet");

        String type = req.getParameter("type");
        if(type.equals("getDetails")) {
            Product prodList = new Product(0, type, type, null);
            prodList.getProduct();
            req.setAttribute("ProdList", prodList.getProduct());
            req.getRequestDispatcher("/product.jsp").forward(req, resp);
        }
        resp.setHeader("Content-type", "text/html; charset=Utf8");

    }
}