package Yogesh;
import java.util.Scanner;
import java.io.*;
public class Assignment1_EffectiveCost{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double tax=0;

        while(true){
            try {
//                sc.next();
                System.out.print("Please enter the item name : ");
                String name = sc.nextLine();

                System.out.print("Please enter the item price : ");
                double price = sc.nextDouble();
                sc.nextLine();
                while(true){
                    System.out.print("Please enter the item type (Row/Manufactured/Imported) : ");

                    String type = sc.nextLine();
                    if(type.equalsIgnoreCase("Row")) {
                        tax = (price * 0.125);
                        break;
                    }
                    else if (type.equalsIgnoreCase("Manufactured")) {
                        tax = (price * 0.125) + 0.02 * (price + price * 0.125);
                        break;
                    }
                    else if (type.equalsIgnoreCase("Imported")) {
                        double surcharge;
                        tax = (price * 0.10);
                        if ((price + tax) <= 100)
                            tax = tax + 5;
                        else if ((price + tax) > 100 && (price + tax) <= 200)
                            tax = tax + 10;
                        else
                            tax = tax + ((price + tax) * 0.05);
                        break;
                    }else {
                        System.out.println("Please choose correct type");
                        continue ;
                    }
                }
                System.out.println("Name of item is : " + name);
                System.out.println("Price of the item is : " + price);
                System.out.println("Sales tax liability per item is : " + tax);
                System.out.println("Final price of the item is : " + (price + tax));

                System.out.println("Do you want to enter details of any other items (Y/N)");
                String input = sc.nextLine();
                if (input.equalsIgnoreCase("y"))
                    continue;
                else
                    break;
            }
            catch(Exception e)
            {
                System.out.println("Error Occur due to invalid input " +e);
            }
        }

    }
}
