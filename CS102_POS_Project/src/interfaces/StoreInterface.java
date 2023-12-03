package interfaces;

import CS102Project.Product;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.TreeMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PCD
 */
public interface StoreInterface {
   
    public void addProduct(Product p);
    public void removeProduct(String name);
    public void searchProduct(String name);

    public TreeMap<String, Product> getProducts();

    public void setProducts(TreeMap<String, Product> products);
    public void updateInventory(String name) throws FileNotFoundException ; 
    
}
