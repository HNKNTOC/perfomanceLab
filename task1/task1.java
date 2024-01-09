import java.util.*;

public class task1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        System.out.print("Enter number n: ");
        int n = scan.nextInt();
        System.out.print("Enter number m: ");
        int m = scan.nextInt();

        int current = 1;

        System.out.print("Path: ");
        do {
            System.out.print(current);
            current = (current + m - 2) % n + 1;
        }while (current != 1);


        scan.close();
    }
}