/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topic01;

/**
 *
 * @author 222110063
 */
public class Student {
    
    //declare the attributes of the class
    String firstName;
    String lastName;
    String id;
    int age;
    
    
    //declare the methods of the class
    public void printInfo(){
        System.out.println("First Name: "+ firstName);
        System.out.println("Last Name: "+ lastName);
        System.out.println("ID: "+ id);
        System.out.println("Age: "+ age);
        System.out.println("");
}
}
