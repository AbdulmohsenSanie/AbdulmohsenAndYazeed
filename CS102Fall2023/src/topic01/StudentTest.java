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
public class StudentTest {
    public static void main(String[] args) {
        //Declare an object student1 from the class Student
        Student student1;
        //create the object
        student1 = new Student();
        student1.firstName = "Mohammed";
        student1.lastName = "Salah";
        student1.id = "ST-10000";
        student1.age = 23;
        student1.printInfo();
        
        Student student2 = new Student();
        student2.firstName ="kamal";
        student2.lastName = "Hamdi";
        student2.id ="ST-10001";
        student2.age = 24;
        student2.printInfo();
        
    }
    
}
