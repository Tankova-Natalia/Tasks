public class Task1{
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int t = 0;
        do {
            System.out.println(t+1);
            t = (t + m - 1) % n;
        } while (t != 0);
    }
}