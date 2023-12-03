/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import CS102Project.Cart;
import CS102Project.Sale;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author PCD
 */
public interface SaleInterface {
    
    public LocalDate getDate();
    public void setDate(LocalDate date);
  
    public double getTotalDiscount();
    public void setTotalDiscount(double totalDiscount);

    public double getTotalPriceBeforeDiscount();
    public void setTotalPriceBeforeDiscount(double totalPriceBeforeDiscount);
    
    public double getTotalPrice();
    public void setTotalPrice(double totalPrice);

    public String getName();
    public void setName(String name);

    public Cart getCart();
    public void setCart(Cart cart);

   public void checkOut(Cart cart);
}