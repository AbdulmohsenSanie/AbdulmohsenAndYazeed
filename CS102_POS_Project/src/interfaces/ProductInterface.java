/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author PCD
 */
public interface ProductInterface {
 
    public void setDiscount(double discount);
    public double getDiscount();
    
    public void setName(String name);
    public String getName();
    
    public void setPrice(double price);
    public double getPrice();
    
    public void setInventoryLevel(int inventoryLevel);
    public int getInventoryLevel();
    
    public void decreaseInventory();
    
    public void calculateDiscount();
}
