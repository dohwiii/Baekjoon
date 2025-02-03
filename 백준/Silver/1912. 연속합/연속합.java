import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = -1001;
        int sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int current = Integer.parseInt(st.nextToken());
            sum = Math.max(sum + current, current);
            max = Math.max(max, sum);
        }

        System.out.println(max);

    }
}