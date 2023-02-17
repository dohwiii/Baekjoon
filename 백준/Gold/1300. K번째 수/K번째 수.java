import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine()); 

        int start = 1;
        int end = K;
        int ans = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;

            for (int i = 1; i <= N; i++) {
                sum = sum + Math.min(mid / i, N);

            }
            if (sum < K) {
                start = mid + 1;
            } else if (sum >= K)
            {
                ans = mid;
                end = mid - 1;
            }


        }
        System.out.println(ans);

    }  


}
