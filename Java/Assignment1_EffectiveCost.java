// In this Assignment, our task is to calculate total price (initial price + tax) for the item

package Java;
import java.util.Scanner;   // import Scanner class for User Input
import java.io.*;
public class Assignment1_EffectiveCost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);                //creating object of main method
        double tax = 0;                                     // declare tax variable with zero
        System.out.println("--------Welcome to our effective cost Calculator after applying the tax rules-------");
        while (true) {
            Demo demo = new Demo();                         // Creating Object of a class Demo
            System.out.print("Please enter the item name : ");
            demo.setItemName(sc.nextLine());
            int f=1;// Take item name from user
            while (f==1) {
                try {                                      //Take item price from user
                    System.out.print("Please enter the item price : ");
                    demo.setItemPrice(sc.nextDouble());
                    f=0;
                    }
                catch (Exception e) {                      // Error If user not supply proper value
                    System.out.println("Please Enter valid price (Price Must be Number) example:[100,353.2]");
                    sc.nextLine();
                    continue;
                }
            }
            int flag=1;
            while(flag==1){
                try{                                      // Take item quantity from user
                    System.out.print("Please Enter the Item Quantity : ");
                    demo.setItemQuantity(sc.nextDouble());
                    sc.nextLine();
                    flag=0;
                }
                catch (Exception e) {                      // Error If user not supply proper value
                    System.out.println("Please Enter the valid Quantity (Quantity must be number) Example:[1,2.5]");
                    sc.nextLine();
                    continue;
                }
            }
            while (true) {
                System.out.print("Please enter the item type (Row/Manufactured/Imported) : ");

                        demo.setItemType(sc.nextLine());    //Take type of item from user

                        //Check type of item in if else case
                        if (demo.getItemType().equalsIgnoreCase("Row")) {    //if type is row
                            tax = (demo.getItemPrice() * 0.125);
                            break;
                        } else if (demo.getItemType().equalsIgnoreCase("Manufactured")) {      // if type is Manufactured
                            tax = (demo.getItemPrice() * 0.125) + 0.02 * (demo.getItemPrice() + demo.getItemPrice() * 0.125);
                            break;
                        } else if (demo.getItemType().equalsIgnoreCase("Imported")) {    //if type is Imported
                            double surcharge;
                            tax = (demo.getItemPrice() * 0.10);
                            if ((demo.getItemPrice() + tax) <= 100)
                                tax = tax + 5;
                            else if ((demo.getItemPrice() + tax) > 100 && (demo.getItemPrice() + tax) <= 200)
                                tax = tax + 10;
                            else
                                tax = tax + ((demo.getItemPrice() + tax) * 0.05);
                            break;
                        } else {
                            System.out.println("Please choose correct type");
                            continue;
                        }
                    }
                    Double quantity = demo.getItemQuantity();
                    Double TotalPrice = demo.getItemPrice()*quantity;
                    Double TotalTax = tax*quantity;
                    Double TotalPriceAfterTax = TotalPrice+TotalTax;
                    System.out.println("----------------------Detail of Item is----------------------------");
                    System.out.println("Name of item is : " + demo.getItemName());
                    System.out.println("Price of the item is : " + TotalPrice);
                    System.out.println("Sales tax liability per item is : " + TotalTax);
                    System.out.println("Final price of the item is : " + TotalPriceAfterTax);
                    System.out.println("--------------------------------------------------------------------");


                    System.out.println("Do you want to enter details of any other items (Y/N)");
                    String input = sc.nextLine();
                    if (input.equalsIgnoreCase("y"))  //If user press y then continue
                        continue;
                    else                                         // else break program finished
                        System.out.println("-------Thank You-------Exit Successfully-------------------------");
                    System.exit(0);
                }
            }
        }


