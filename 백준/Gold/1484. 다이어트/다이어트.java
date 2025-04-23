import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        boolean found = false;

        int s = 1;
        int e = 2;

        while (s < e) {
            long diff = (long) e * e - (long) s * s;

            if (diff == G) {
                sb.append(e).append("\n");
                found = true;
                e++;
            }
            else if (diff < G) {
                e++;
            }
            else {
                s++;
            }
        }

        if (found) {
            System.out.print(sb);
        } else {
            System.out.println(-1);
        }
    }
}