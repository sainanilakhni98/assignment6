package Yogesh;

public class MultiCatch{
    public static void main(String[] args) {
        try{
            int a[]=new int[5];
            a[4]=30/2;
            System.out.println("Array Element of Index 4 is " + a[4]);
        }
        catch (ArithmeticException e)
        {
            System.out.println("Arithmetic Exception Occurs");
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("ArrayIndexOutOfBounds Excwptions occurs");
        }
        catch (Exception e)
        {
            System.out.println("Parent Exception Occurs");
        }
        System.out.println("rest of the code");
    }
}
