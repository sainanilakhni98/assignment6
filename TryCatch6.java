package Yogesh;

import java.util.Scanner;

public class TryCatch6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first Value");
        int i=sc.nextInt();
        System.out.println("Enter the second value");
        int j=sc.nextInt();
        int data;
        try{
            data=i/j;
            System.out.println("Division is "+data);
        }
        catch(Exception e)
        {
            System.out.println("Can't divide by zero");
        }
        System.out.println("Code finished");
    }
}
