package com.nagarro.assignment1;

import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

/** The ItemType class provide method to calculate tax based on the item type*/
public class ItemType {
    public static double typeRelatedTax(Item item) {
        Scanner sc = new Scanner(System. in );
        double tax;

        AtomicBoolean flag = new AtomicBoolean(false);
        do {
            System.out.print("Please enter the item type (Raw/Manufactured/Imported) : ");
            item.setType(sc.nextLine());                             //Take type of item from user
            tax = 0;
            flag.set(false);
            switch (item.getType().toLowerCase(Locale.ROOT)){
                case "raw":
                    tax = (item.getPrice() * 0.125);
                    break;
                case "manufactured":
                    /* Executed when item type is Manufactured */
                    tax = (item.getPrice() * 0.125) + 0.02 * (item.getPrice() + (item.getPrice() * 0.125));
                    break;
                case "imported":
                    tax = (item.getPrice() * 0.10);
                    if ((item.getPrice() + tax) <= 100) {
                        tax = tax + 5;
                    }
                    else if ((item.getPrice() + tax) > 100 && (item.getPrice() + tax) <= 200) {
                        tax = tax + 10;
                    }
                    else {
                        tax = tax + ((item.getPrice() + tax) * 0.05);
                    }
                    break;
                default:
                    flag.set(true);
                    System.out.println("Please choose correct type");
            }
        }while (flag.get());
        return tax;
    }
}