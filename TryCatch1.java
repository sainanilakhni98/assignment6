package Yogesh;

public class TryCatch1{
    public static void main(String[] args){
        try{
            int arr[]={1,2,3,4,5,6};
            System.out.println(arr[10]);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Index Error "+ e);
        }
        System.out.println("Rest of the code");
    }
}
