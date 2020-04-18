package com.shop.controllers;

import com.shop.cart.CartService;
import com.shop.cart.LineItem;
import com.shop.persist.Product;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class CartController implements Serializable {

    @Inject
    private CartService cartService;

    @Transactional
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
