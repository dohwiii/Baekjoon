import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        long[][] dp = new long[str1.length() + 1][str2.length() + 1]; //6x6
        char[] A = str1.toCharArray();
        char[] B = str2.toCharArray();

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else
                {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        long ansLength = dp[str1.length()][str2.length()];
        Stack<Character> stack = new Stack<>();
        int i = str1.length();
        int j = str2.length(); //5

        while (i >= 1 && j >= 1)
        {
            if (A[i - 1] == B[j - 1]) {
                stack.push(A[i - 1]);
                i = i - 1;
                j = j - 1;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i = i - 1;
                } else {
                    j = j - 1;
                }
            }

        }
        if (ansLength > 0) {
            System.out.println(ansLength);
            while (!stack.isEmpty()) {
                System.out.print(stack.pop());
            }
        }
        else
            System.out.println(ansLength);

    }
}