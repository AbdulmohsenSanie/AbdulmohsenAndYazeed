package CS102Project;

import interfaces.StoreInterface;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 5. Use the Java Collection Framework to store the products in the grocery
 * store. Implement methods to add, remove, and search for products in the
 * store.
 */
public class Store implements StoreInterface {

    private static String keys = "PT-00001";
    private TreeMap<String, Product> products;
    private static int productNum = 1;

    public Store() {
        this.products = new TreeMap<>();
    }

    public void addProduct(Product p) {
        products.put(keys, p);
        productNum++;
        keys = String.format("PT-%05d", productNum); //Five digits after - .

    }

    //remove a product by its name.
    public void removeProduct(String name) {
        String removeKey = "";
        boolean remove = false;
        for (Map.Entry map : products.entrySet()) {
            if (((Product) (map.getValue())).getName().equalsIgnoreCase(name)) {
                removeKey = (String) map.getKey();
                remove = true;
                break;
            }
        }
        products.remove(removeKey);
        if (remove) {
            System.out.println("The product " + name + " has been removed.");
        } else {
            System.out.println("The product " + name + " is not on the list.");
        }

    }

    //Search by the name of the product.
    public void searchProduct(String name) {
        String searchKey = "";
        boolean found = false;
        for (Map.Entry map : products.entrySet()) {
            if (((Product) (map.getValue())).getName().equalsIgnoreCase(name)) {
                searchKey = (String) map.getKey();
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("The product key is " + searchKey + "\n"
                    + products.get(searchKey));
        } else {
            System.out.println("Product is not on the list");
        }
    }

    public TreeMap<String, Product> getProducts() {
        return products;
    }

    public void setProducts(TreeMap<String, Product> products) {
        this.products = products;
    }
/*
Implement file I/O to read in the initial inventory levels for each product from a
    text file.  Update the inventory levels as sales are made.
    */
    /*
    Text file is assumed to be of this form, Product name: inventory level. (Milk: 23.)
    */
    //The user should enter the name of the file.
    public void updateInventory(String name) throws FileNotFoundException {
        File file = new File(name + ".txt"); 
        if (!file.exists())
            throw new IllegalArgumentException("File was not found.");
        else {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\\: |\\.");
                                           HashMap<String, Integer> updating = new HashMap<>();
                                           HashSet<Product> newItems = new HashSet<>();
            while (scanner.hasNext()) {
                                                           boolean found = false;
                String item = scanner.next().trim();
                int amount = scanner.nextInt();
                
                for (Map.Entry map: products.entrySet()) {
                   if(((Product)map.getValue()).getName().equalsIgnoreCase(item)) {
                       updating.put((String) map.getKey(), amount);
                       found = true; break;
                        } 
                }
                      //If item is not in the store, it will be added to the newItems map, which will be added as a new product in the store.
                      if (!found)
                       newItems.add(new Product(item, 0.00, amount));
            }
            //Updating the inventory level of the products in the store.
            for(Map.Entry update: updating.entrySet()) {
                products.get(update.getKey()).setInventoryLevel((int) update.getValue());
            }
            //Adding the new Products that was not in the store.
            for (Product p: newItems) {
                addProduct(p);
            }
         
        }
    }
    @Override
    public String toString() {
        return "Store{" + "products=" + products + '}';
    }
}
