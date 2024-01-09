import java.io.*;
import java.util.Scanner;

public class task4 {
    public static void main(String[] args) throws IOException{
        int count = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line;
            while ((line = reader.readLine()) != null) {
                count++;
            }

            Scanner scanner = new Scanner(new File(args[0]));
            int[] nums = new int[count];
            int sum = 0;

            for (int i = 0; i < nums.length; i++) {
                nums[i] = scanner.nextInt();
                sum += nums[i];
            }

            int average = sum / nums.length;
            int moves = 0;

            for (int i = 0; i < nums.length; i++) {
                moves += Math.abs(nums[i] - average);
            }

            System.out.println(moves);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}

