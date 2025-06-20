import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        char[] bomb = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char c : arr) {
            sb.append(c);
            boolean isMatch = true;
            if (sb.length() >= bomb.length) {
                for (int i = 0; i < bomb.length; i++) {
                    if (sb.charAt(sb.length() - bomb.length + i) != bomb[i]) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) {
                    sb.delete(sb.length() - bomb.length, sb.length());
                }
            }
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        }
        else {
            System.out.println(sb);
        }
    }
}