import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Arrays;

public class task2 {
    public static void main(String[] args) {
        String file1_path = args[0];
        String file2_path = args[1];

        float circle_center[] = new float[2];
        float circle_radius = 0;
        float points_coordinates[][];

        try (BufferedReader reader = new BufferedReader(new FileReader(file1_path))) {
            String line;
            int numLine = 1;
            String[] circle_center_str = new String[2];
            
            while ((line = reader.readLine()) != null) {
                switch (numLine) {
                    case (1):
                        circle_center_str = line.split(" ");
                        break;
                    case (2):
                        circle_radius = Float.parseFloat(line);
                        break;
                    default:
                        break;
                }
                numLine++;
            }

            for (int i = 0; i < circle_center_str.length; i++) {
                circle_center[i] = Float.parseFloat(circle_center_str[i]);
            }
        } catch (IOException e) {
            System.out.println("Input Output error");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file2_path))) {
            String line;
            String[] circle_center_str = new String[2];

            LineNumberReader count = new LineNumberReader(new FileReader(file2_path));

            while (count.skip(Long.MAX_VALUE) > 0) {}
            int count_lines = count.getLineNumber();

            points_coordinates = new float[count_lines][2];
            String[][] points_coordinates_str = new String[count_lines][2];

            int num_current_line = 0;
            while ((line = reader.readLine()) != null) {
                points_coordinates_str[num_current_line] = line.split(" ");
                num_current_line++;
            }

            for (int i = 0; i < count_lines; i++) {
                for (int j = 0; j < 2; j++) {
                    points_coordinates[i][j] = Float.parseFloat(points_coordinates_str[i][j]);
                }
            }

            //Solution code
            float a = circle_center[0];
            float b = circle_center[1];
            for (int i = 0; i < points_coordinates.length; i++) {
                float x = points_coordinates[i][0];
                float y = points_coordinates[i][1];

                float formula = (float)Math.sqrt(Math.pow((x - a), 2) + Math.pow((y - b), 2));

                if (formula == circle_radius) {
                    System.out.println(0);
                } else if (formula < circle_radius) {
                    System.out.println(1);
                } else if (formula > circle_radius) {
                    System.out.println(2);
                }
            }

        } catch (IOException e) {
            System.out.println("Input Output error");
        }
    }
}
