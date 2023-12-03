/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import CS102Project.Product;
import java.util.TreeMap;

/**
 *
 * @author PCD
 */
public interface CartInterface {
    public TreeMap<Product, Integer> getItems();
    public void setItems(TreeMap<Product, Integer> items);
    
    public void addToCart(Product p);
        
    
    public void removeFromCart(Product p);
    
    public boolean cartIsEmpty();
    }
    

