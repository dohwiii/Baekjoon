import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[N + 1];
        dp[0] = false;
        dp[1] = true;
        int[] stone = {1, 3, 4};    //1, 3, 4개 가져갈 수 있음

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                int remain = i - stone[j];  //CY 턴
                if (remain < 0) {
                    break;
                }
                if (!dp[remain]) {   //CY 패라면
                    dp[i] = true;   //SK 승
                    break;
                }
            }
        }
        if (dp[N]) {
            System.out.println("SK");
        }
        else {
            System.out.println("CY");
        }


    }
}
