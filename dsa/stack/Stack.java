package com.nagarro.dsa.stack;

import java.util.Scanner;

// This class contain main function and call the functions.
public class Stack {
    public static void main(String[] args) {
        StackOperations stack = new StackOperations();
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean flag = false;

        do{
            try{
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Contains");
            System.out.println("5. Size");
            System.out.println("6. Reverse");
            System.out.println("7. Traverse");
            System.out.println("Enter a Choice");
            choice = sc.nextInt();

            switch (choice){
                case 1:stack.push();
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.peek();
                    break;
                case 4:
                    stack.contains();
                    break;
                case 5:
                    stack.size();
                    break;
                case 6:
                    stack.reverse();
                    break;
                case 7:
                    stack.traverse();
                    break;
                default:
                    System.out.println("Please Enter the correct choice");
            }}
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
