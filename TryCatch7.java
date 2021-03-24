package Yogesh;

public class TryCatch7 {
    public static void main(String[] args) {
        try{
            int data=50/0;
        }
        catch (Exception e)
        {
            System.out.println("Error is "+e);
        }
        System.out.println("Code Finished");
    }
}
