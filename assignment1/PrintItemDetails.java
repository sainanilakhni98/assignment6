package com.nagarro.assignment1;

public class PrintItemDetails {
    public static void show(Item item, double tax){
        /* This method display all item details */

        double quantity = item.getQuantity();
        double totalPrice = item.getPrice()*quantity;
        double totalTax = tax*quantity;
        double totalPriceAfterTax = totalPrice+totalTax;

        System.out.println("----------------------Detail of Item is----------------------------");
        System.out.println("Name of item is : " + item.getName());
        System.out.println("Price of the item is : " + totalPrice);
        System.out.println("Sales tax liability per item is : " + totalTax);
        System.out.println("Final price of the item is : " + totalPriceAfterTax);
        System.out.println("--------------------------------------------------------------------");

    }
}