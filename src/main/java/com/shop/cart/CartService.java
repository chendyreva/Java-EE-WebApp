package com.shop.cart;

import com.shop.persist.Product;


import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SessionScoped
@Named
public class CartService  implements Serializable {
    private Map<LineItem, Integer> lineItems;

    public CartService() {
        lineItems = new HashMap<>();
    }

    public void addProductQty(Product product, String color, int qty) {
        LineItem lineItem = new LineItem(product, color);
//        lineItems.compute(LineItem, (li, q) -> q = qty);
        lineItems.put(lineItem, lineItems.getOrDefault(lineItem, 0) + qty);

    }
    public void removeProductQty(Product product, String color, int qty) {
        LineItem lineItem = new LineItem(product, color);
        int currentQty = lineItems.getOrDefault(lineItem, 0);
        if (currentQty - qty > 0) {
            lineItems.put(lineItem, currentQty - qty);
        } else {
            lineItems.remove(lineItem);
        }
    }

    public List<LineItem> getAllLineItems() {
        lineItems.forEach(LineItem::setQty);
        return new ArrayList<>(lineItems.keySet());
    }
}
