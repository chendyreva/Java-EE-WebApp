package com.shop.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="CartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(CartServlet.class);

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("*/cart.jsp").forward(req, resp);

        resp.setHeader("Content-type", "text/html; charset=Utf8");

    }
}