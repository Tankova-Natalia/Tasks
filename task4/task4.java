import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        File file = new File(args[0]);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            List<Integer> list = new ArrayList<>();
            int min = Integer.parseInt(reader.readLine().trim());
            int max = min;
            list.add(min);
            String line;
            while ((line = reader.readLine())!=null){
                int i = Integer.parseInt(line.trim());
                list.add(i);
                if (i < min)
                    min = i;
                if (i > max)
                    max = i;
            }
            double mid = (max+min * 1.)/2;
            double minDiff = max - min;
            int idx = -1;
            for (int i = 0; i < list.size(); i++){
                double t = Math.abs(list.get(i) - mid);
                if (t < minDiff){
                    minDiff = t;
                    idx = i;
                }
            }
            int midEl = list.get(idx);
            int c = 0;
            for (int i : list){
                c += Math.abs(i - midEl);
            }
            System.out.println(c);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}