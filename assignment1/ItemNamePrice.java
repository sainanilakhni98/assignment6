package com.nagarro.assignment1;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Scanner;
public class ItemNamePrice {
    public static void namePriceInput(Item item,Scanner sc){
        System.out.print("Please enter the item name : ");
        item.setName(sc.nextLine());                                        //set the value of item name
        AtomicBoolean flag= new AtomicBoolean(true);

        do {
            try {
                System.out.print("Please enter the item price : ");        //Take item price from user
                item.setPrice(sc.nextDouble());
                flag.set(false);
            } catch (Exception e) {                                 // Error If user not supply proper value
                System.out.println("Please Enter valid price (Price Must be Number) example:[100,353.2]");
                sc.nextLine();
                continue;
            }
        }while (flag.get());
    }
}
