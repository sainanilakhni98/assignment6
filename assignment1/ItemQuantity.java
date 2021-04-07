package com.nagarro.assignment1;

import java.util.Scanner;

public class ItemQuantity {
    public static void quantityInput(Item item, Scanner sc){
        boolean flag = true;

        do {
            try {                                      // Take item quantity from user
                System.out.print("Please Enter the Item Quantity : ");
                item.setQuantity(sc.nextDouble());
                sc.nextLine();
                flag = false;
            } catch (Exception e) {                      // Error If user not supply proper value
                System.out.println("Please Enter the valid Quantity (Quantity must be number) Example:[1,2.5]");
                sc.nextLine();
                continue;
            }
        }while (flag);
    }
}
