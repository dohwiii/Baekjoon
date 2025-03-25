import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;
        StringBuilder sb = new StringBuilder();

        while (!(line = br.readLine()).equals("0 0.00")) {
            st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int m = (int) (Double.parseDouble(st.nextToken()) * 100 + 0.5); // 정수 변환
            
            int[] dp = new int[m + 1];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int p = (int) (Double.parseDouble(st.nextToken()) * 100 + 0.5);

                // 무제한 배낭: 0~m까지 순차적으로 dp 갱신
                for (int j = p; j <= m; j++) {
                    dp[j] = Math.max(dp[j], dp[j - p] + c);
                }
            }
            sb.append(dp[m]).append("\n");
        }
        System.out.print(sb);
    }
}
