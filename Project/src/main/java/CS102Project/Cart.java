package CS102Project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
Create a second class called "Cart"
* that represents the items that a customer has selected for purchase.
*/
public class Cart {
    private TreeMap<Product, Integer> items; //The value is the quantity of the product in the cart.

     public Cart() {
         this.items = new TreeMap<Product, Integer>();
    }
    
    public TreeMap<Product, Integer> getItems() {
        return items;
    }

    public void setItems(TreeMap<Product, Integer> items) {
        this.items = items;
    }
    
    public void addToCart(Product p) {
        if (p.getInventoryLevel() == 0)
            System.out.println("This item currently isn't available.");
        else {
            if (items.containsKey(p))
                items.put(p, items.get(p) + 1);
            else
        items.put(p, 1);
            
        p.decreaseInventory();
        }
    }
    
    public void removeFromCart(Product p) {
        items.remove(p);
    }
    
  public boolean cartIsEmpty() {
        return items.isEmpty();
    }

    @Override
    public String toString() {
        return "Items in the cart: " + items;
    }

   

}
