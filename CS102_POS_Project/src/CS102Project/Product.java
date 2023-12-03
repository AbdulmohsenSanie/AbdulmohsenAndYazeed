package CS102Project;

import interfaces.Discountable;
import interfaces.ProductInterface;
import java.util.Objects;

/**
 * Start by defining a class called "Product" that represents a single item for
 * sale in the grocery store. Each product should have fields to store its name,
 * price, and inventory level.
 */
public class Product implements ProductInterface ,Discountable, Comparable<Product> {

    private String name;
    private double price;
    private int inventoryLevel;
    private double discount;
    private double priceBeforeDiscount;

    //Constructor without the discount field. discount will be 0 by default.
    public Product(String name, double price, int inventoryLevel) {
        this.setName(name);
        this.setPrice(price);
        this.setInventoryLevel(inventoryLevel);
        this.setDiscount(0);
        this.setPriceBeforeDiscount(price);
    }
    
     public Product(String name, double price, int inventoryLevel, double discount) {
        this.setName(name);
        this.setPrice(price);
        this.setInventoryLevel(inventoryLevel);
        this.setDiscount(discount);
        this.setPriceBeforeDiscount(price);
    }

    public double getPriceBeforeDiscount() {
        return priceBeforeDiscount;
    }

    public void setPriceBeforeDiscount(double priceBeforeDiscount) {
        if(priceBeforeDiscount>=0)
        this.priceBeforeDiscount = priceBeforeDiscount;
        else throw new IllegalArgumentException("Price can't be negative.");
    }
    

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        if ((discount >= 0) && (discount <= 100)) {
        this.discount = discount;
        calculateDiscount();
        }
        else throw new IllegalArgumentException("Discount percentage can't be negative or more than 100%.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Price can't be negative.");
        }
    }

    public int getInventoryLevel() {
        return inventoryLevel;
    }

    public void setInventoryLevel(int inventoryLevel) {
        if (inventoryLevel >= 0) {
            this.inventoryLevel = inventoryLevel;
        } else {
            throw new IllegalArgumentException("InventoryLevel can't be negative.");
        }
    }
    
    public void decreaseInventory() {
        this.setInventoryLevel(inventoryLevel - 1);
    }

    @Override
    public void calculateDiscount() {   
        if (discount > 0)
 this.setPrice(price - (price * (discount/100)));
    }

   

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        return Objects.equals(this.name, other.name);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
    

    @Override
    public String toString() {
        return String.format("Product Name: %s.\nActual price:%5.2f$.\nPrice after discount:%3.2f$.\nDiscount:%2.2f%%.\nInventory level:%3d\n"
                ,name, priceBeforeDiscount, price, discount, inventoryLevel);
    }

    @Override
    public int compareTo(Product o) {
        return this.getName().compareTo(o.getName());
    }

    
}
