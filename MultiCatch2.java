package Yogesh;

public class MultiCatch2 {
    public static void main(String[] args) {
        try {
            String s = null;
            System.out.println(s.length());
        } catch (ArithmeticException e) {
            System.out.println();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException");
        } catch (Exception e){
            System.out.println("Parent Exception occurs");
        }
        System.out.println("Rest of the code");
    }
}
