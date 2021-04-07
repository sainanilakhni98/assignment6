package com.nagarro.assignment1;

public class PrintItemDetails {
    public static void show(Item item, double tax){
        /* This method display all item details */

        double quantity = item.getQuantity();
        double TotalPrice = item.getPrice()*quantity;
        double TotalTax = tax*quantity;
        double TotalPriceAfterTax = TotalPrice+TotalTax;

        System.out.println("----------------------Detail of Item is----------------------------");
        System.out.println("Name of item is : " + item.getName());
        System.out.println("Price of the item is : " + TotalPrice);
        System.out.println("Sales tax liability per item is : " + TotalTax);
        System.out.println("Final price of the item is : " + TotalPriceAfterTax);
        System.out.println("--------------------------------------------------------------------");

    }
}