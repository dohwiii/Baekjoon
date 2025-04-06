import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] sushi;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int s = 1, e = 1;
        long sum = 1;
        int ans = 0;

        while (s <= e && e <= N) {
            if (sum > N) {
                sum -= s;
                s++;
            }
            else {
                if (sum == N) {
                    ans++;
                }
                e++;
                sum += e;
            }


        }
        if (N == 1) {
            ans = 1;
        }
        System.out.println(ans);

    }

}