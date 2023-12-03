/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CS102Project;

/**
 *
 * @author PCD
 */
public class main {
    public static void main(String[] args) {
        Product p1 = new Product("potato",20,5);
        Product p2 = new Product("burrito",30,2);
        Product p3 = new Product("chicken",15,10);
        Product p4 = new Product("macaroni",5,200);
        Cart cart = new Cart();
        cart.addToCart(p4);
        cart.addToCart(p4);
        cart.addToCart(p2);
        cart.addToCart(p2);
        cart.addToCart(p2);
        cart.addToCart(p1);
        cart.addToCart(p4);
        Sale sale = new Sale("sale1", cart,2023,8,8);
        System.out.println(sale);
        
        
    }
    
}
