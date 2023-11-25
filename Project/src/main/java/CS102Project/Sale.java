package CS102Project;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
Create a third class called "Sale" that represents a single transaction
* at the grocery store. Each sale should have fields to store the customer's name,
* the items in their cart, the total price of the sale, and any discounts applied. */
public class Sale {
    private String name;
    private Cart cart;
    private double totalPrice;
    private double totalPriceBeforeDiscount;
    private double totalDiscount;
    private LocalDate date;
    private static ArrayList<Sale> list = new ArrayList<>(); //This includes a list of all the sales that has been made with the date of the sale.
    
    
    

    public Sale(String name, Cart cart, int year, int month, int day) {
        this.setName(name);
        this.setCart(cart);
      //Calculating the total price of the sale.
       for(Map.Entry map: cart.getItems().entrySet()){
           this.totalPrice += ((Product)map.getKey()).getPrice();
           this.totalPriceBeforeDiscount += ((Product)map.getKey()).getPriceBeforeDiscount();
       }
       if (totalPriceBeforeDiscount > 0)
        this.totalDiscount = ((totalPriceBeforeDiscount - totalPrice) /totalPriceBeforeDiscount) * 100;
       else 
           this.totalDiscount = 0;
       
        this.setDate(LocalDate.of(year, month, day));
        list.add(this);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public static ArrayList<Sale> getList() {
        return list;
    }

    public static void setList(ArrayList<Sale> list) {
        Sale.list = list;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public double getTotalPriceBeforeDiscount() {
        return totalPriceBeforeDiscount;
    }

    public void setTotalPriceBeforeDiscount(double totalPriceBeforeDiscount) {
        this.totalPriceBeforeDiscount = totalPriceBeforeDiscount;
    }
    

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
    
    //Use recursion to simulate the customer checkout process.
   public void checkOut(Cart cart) {   
        if (!cart.cartIsEmpty())
        {
            System.out.print(cart.getItems().firstKey());
            System.out.println("Quantity: " + cart.getItems().firstEntry().getValue());
            System.out.println();
                  //  The item should now be removed from the cart.
            cart.getItems().pollFirstEntry();
        checkOut(cart);
        }
    }  
   
   //Enter two dates. The method will generate a sales report between these two dates.
   public static void salesReport(int firstYear, int firstMonth, int firstDay, int secondYear, int secondMonth, int secondDay) {
       LocalDate first = LocalDate.of(firstYear, firstMonth, firstDay);
       LocalDate second = LocalDate.of(secondYear, secondMonth, secondDay);
       double revenue = 0;
       HashMap<Product, Integer> saledProducts = new HashMap<>();// The map will include all products that have been sold and its quantity in this time period.
       String mostSold = null;
       for (int i = 0; i < list.size(); i++) {
           if (list.get(i).getDate().isAfter(first) && list.get(i).getDate().isBefore(second)) {
               revenue+= list.get(i).getTotalPrice();
               for(Map.Entry map: list.get(i).getCart().getItems().entrySet()) {
                   if (saledProducts.containsKey(map.getKey())) { //Modifying the sales number of that product.
                       saledProducts.put((Product)map.getKey(), (int)saledProducts.get(map.getKey()) + (int)map.getValue());
                   }
                   else // The Product will be added to the list.
                       saledProducts.put((Product)map.getKey(), (int)map.getValue());
               }
           }   
       }
       int highestValue = 0;
       for (Map.Entry map: saledProducts.entrySet()) {
           if ((int)map.getValue() > highestValue) {
               highestValue = (int)map.getValue();
               mostSold = ((Product)map.getKey()).getName();
           }
               
       }
       System.out.println("Sales report from: " + first + " to: " + second);
       System.out.printf("Total revenue: %5.2f$\n" , revenue);
       if (!(mostSold == null))
       System.out.println("Most Item sold: " + mostSold);
   }

    @Override
    public String toString() {
        return String.format("Customer's name:%s.\n%s.\nTotal price before discount:%5.2f.\nTotal price after discount:%5.2f.\nDiscount:%2.2f%%."
        , name, cart,totalPriceBeforeDiscount, totalPrice,totalDiscount);
    }
}
