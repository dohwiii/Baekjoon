import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static String[] arr;
    static ArrayList<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new String[N];
        list = new ArrayList<>();
        recursion("");
    }

    public static void recursion(String str)
    {
        if (str.length() == N) {
            System.out.println(str);
            System.exit(0);

        }
        for (int i = 1; i <= 3; i++) {
            if (isGoodSequence(str + i)) {
                recursion(str + i);
            }
        }

    }
    public static boolean isGoodSequence(String str) {

        for (int i = 1; i <= str.length() / 2; i++) {
            String front = str.substring(str.length() - i * 2, str.length() - i);
            String back = str.substring(str.length() - i, str.length());
            if (front.equals(back)) {
                return false;
            }
        }
        return true;
    }

}