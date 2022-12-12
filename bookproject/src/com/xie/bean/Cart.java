package com.xie.bean;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xie
 * @create 2022-11-14
 */
public class Cart {
//    private Integer totalCount;
//    private BigDecimal totalPrice;
    /**
     * key 商品编号
     * value 商品项
     */
    private Map<Integer,CartItem> items = new LinkedHashMap<>();

    /**
     * 添加商品
     * @return
     */
    public void addItem(CartItem cartItem){
        //查看购物车是否有此商品
        CartItem item = items.get(cartItem.getId());
        if (item == null){
            //没有商品 添加
            items.put(cartItem.getId(),cartItem);
        }else {
            //有该商品 修改数量跟总金额
            item.setCount(item.getCount() + 1);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }
    /**
     * 删除商品
     * @return
     */
    public void deleteItem(Integer id){
        items.remove(id);
    }

    /**
     * 清空商品
     * @return
     */
    public void clear(){
        items.clear();

    }
    /**
     * 修改商品数量
     * @return
     */
    public void updateItem(Integer id,Integer count){
        //查看购物车是否有此商品
        CartItem item = items.get(id);
        if (item != null){
            item.setCount(count);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }

    }

    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (CartItem item : items.values()) {
            totalCount +=item.getCount();
        }
        return totalCount;
    }


    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (CartItem item : items.values()) {
            totalPrice = totalPrice.add(item.getTotalPrice());
        }
        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", item=" + items +
                '}';
    }
}
