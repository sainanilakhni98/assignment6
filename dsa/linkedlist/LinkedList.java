package com.nagarro.dsa.linkedlist;

import java.util.Scanner;

// This class contain main function and call the functions.
public class LinkedList {
    public static void main(String[] args) {
        LinkedListOpertions list = new LinkedListOpertions();
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        int choice;
        do{
            System.out.println("1. Insert");
            System.out.println("2. Insert at position");
            System.out.println("3. Delete");
            System.out.println("4. Delete at position");
            System.out.println("5. Center Element");
            System.out.println("6. Reverse");
            System.out.println("7. Size");
            System.out.println("8. Iterator");
            System.out.println("9. Traverse");
                try{
                System.out.println("Enter a Choice");
                choice = sc.nextInt();
                    switch (choice){
                        case 1:
                            list.insert();
                            break;
                        case 2:
                            list.insertAtPosition();
                            break;
                        case 3:
                            list.delete();
                            break;
                        case 4:
                            list.deleteAtPosition();
                            break;
                        case 5:
                            list.center();
                            break;
                        case 6:
                            list.reverse();
                            break;
                        case 7:
                            System.out.println("Size of the Linked list is " +list.countNode());
                            break;
                        case 8:
//                    list.iterator();
                            break;
                        case 9:
                            list.traverse();
                            break;

                        default:
                            System.out.println("Please Enter the correct choice");
                    }
                }
                catch (Exception e){
                    System.out.println("Please enter number between 1 to 9");
                    sc.nextLine();
                    continue;
                }
            sc.nextLine();
            System.out.println("you want to continue(y/n)");
            String key = sc.nextLine();
            if(key.equalsIgnoreCase("y"))
                flag=true;
            else
                flag=false;
        }while (flag);
    }

}
