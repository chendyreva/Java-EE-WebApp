package com.shop.controllers;

import com.shop.cart.CartService;
import com.shop.cart.LineItem;
import com.shop.persist.Product;

import javax.ejb.EJB;


import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class CartController implements Serializable {

    @EJB
    private CartService cartService;

    public List<LineItem> getAllLineItems() {
        return cartService.getAllLineItems();
    }

    public void addToCart(Product product) {
        cartService.addProductQty(product, "", 1);
    }

    public void removeFromCart(Product product) {
        cartService.removeProductQty(product, "", 1);
    }

}
