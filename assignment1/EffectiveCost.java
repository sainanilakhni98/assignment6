// In this Assignment, our task is to calculate total price (initial price + tax) for the item

package com.nagarro.assignment1;
import java.util.Scanner;                       //Scanner class is use for taking input from keyboard.

/* The EffectiveCost class have main method, inside this main method we create the object of
 * the other classes and use their Functionality */
public class EffectiveCost{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double tax = 0d;                                       // declare tax variable with zero
        System.out.println("--------Welcome to our effective cost Calculator after applying the tax rules-------");
        String input;
        Item item = new Item();

        do {
            ItemNamePrice.namePriceInput(item, sc);                 //call namePriceInput Function for name and price input from user

            ItemQuantity.quantityInput(item,sc);                //call quantityInput Function for quantity input from user

            tax=ItemType.typeRelatedTax(item);                     /* call typeRelatedTax Function for type input from user
                                                                and get the value of tax for the item */

            PrintItemDetails.show(item,tax);                      //call show Fucntion for printing Item details

            System.out.println("Do you want to enter details of any other items (Y/N)");
            input = sc.nextLine();                             //Take input from user
            if(input.equalsIgnoreCase("n")){
                System.out.println("-------------Thank You---------Exit successfully--------------------");
            }
        } while (input.equalsIgnoreCase("y"));      //If user enter y then loap will continue else program finished
    }
}


