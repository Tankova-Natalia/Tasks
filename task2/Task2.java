import java.io.*;

public class Task2{
    public static void main(String[] args) {
        File file1 = new File(args[0]);
        //File file1 = new File("input1.txt");
        File file2 = new File(args[1]);
        //File file2 = new File("input2.txt");
        float a, b, r, r2;
        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1));
             BufferedReader reader2 = new BufferedReader(new FileReader(file2))) {
            String[] pair;
            pair = reader1.readLine().split(" ");
            a = Float.parseFloat(pair[0]);
            b = Float.parseFloat(pair[1]);
            r = Float.parseFloat(reader1.readLine());
            r2 = r * r;
            String line;
            while ((line = reader2.readLine()) != null){
                pair = line.split(" ");
                float x = Float.parseFloat(pair[0]);
                float y = Float.parseFloat(pair[1]);
                float res = (x - a) * (x - a) + (y - b) * (y - b);
                if (res == r2) {
                    System.out.println(0);
                } else if (res < r2) {
                    System.out.println(1);
                } else {
                    System.out.println(2);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}