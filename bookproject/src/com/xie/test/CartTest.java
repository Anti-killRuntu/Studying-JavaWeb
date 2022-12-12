package com.xie.test;

import com.xie.bean.Cart;
import com.xie.bean.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author xie
 * @create 2022-11-14
 */
public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"java",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"mysql",1,new BigDecimal(999),new BigDecimal(999)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"java",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"mysql",1,new BigDecimal(999),new BigDecimal(999)));

        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"java",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"mysql",1,new BigDecimal(999),new BigDecimal(999)));

        cart.deleteItem(1);
        cart.clear();

        System.out.println(cart);
    }

    @Test
    public void updateItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"java",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"mysql",1,new BigDecimal(999),new BigDecimal(999)));

        cart.deleteItem(1);
        cart.clear();
        cart.addItem(new CartItem(1,"java",1,new BigDecimal(100),new BigDecimal(100)));

        cart.updateItem(1,1024);

        System.out.println(cart);
    }
}