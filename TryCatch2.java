package Yogesh;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class TryCatch2 {
    public static void main(String[] args){
        PrintWriter pw;
        try{
            pw=new PrintWriter("yogesh.txt");
            pw.println("Saved");
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found " + e);
        }
        System.out.println("File saved Successfully");
    }
}
