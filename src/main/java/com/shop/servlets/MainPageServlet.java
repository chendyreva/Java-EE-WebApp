package com.shop.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name ="MainPageServlet", urlPatterns = "/main")
public class MainPageServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(MainPageServlet.class);

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/main.xhtml").forward(req, resp);

        PrintWriter out = resp.getWriter();
        resp.getWriter().println("<h2>Catalog</h2>");
        resp.getWriter().println("<h2>Product</h2>");
        resp.getWriter().println("<h2>Cart</h2>");
        resp.getWriter().println("<h2>Order</h2>");

        resp.setHeader("Content-type", "text/html; charset=Utf8");

    }
}