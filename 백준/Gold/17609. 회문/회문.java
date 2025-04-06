import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            String str = br.readLine();
            int ans = solve(str);
            sb.append(ans + "\n");
        }
        System.out.println(sb);



    }
    public static int solve(String str) {
        int s = 0, e = str.length() - 1;
        char[] arr = str.toCharArray();

        while (s < e) {
            if (arr[s] == arr[e]) {
                s++;
                e--;
            } else {
                // 유사회문 확인: s+1~e 또는 s~e-1 중 하나라도 회문이면 유사회문
                if (isPalindrome(arr, s + 1, e) || isPalindrome(arr, s, e - 1)) {
                    return 1;
                } else {
                    return 2;
                }
            }
        }
        return 0; // 끝까지 왔다면 회문
    }

    public static boolean isPalindrome(char[] arr, int s, int e) {
        while (s < e) {
            if (arr[s] != arr[e]) return false;
            s++;
            e--;
        }
        return true;
    }
}