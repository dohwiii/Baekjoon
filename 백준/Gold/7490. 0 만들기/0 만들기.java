import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static List<String> result = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            result.clear();
            dfs(2, 1, 1, "1");
            Collections.sort(result);
            for (String s : result) sb.append(s).append("\n");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int num, int sum, int prev, String expr) {
        if (num > N) {
            if (sum == 0) result.add(expr);
            return;
        }

        // 1. '+' 연산
        dfs(num + 1, sum + num, num, expr + "+" + num);

        // 2. '-' 연산
        dfs(num + 1, sum - num, -num, expr + "-" + num);

        // 3. 공백: 숫자 이어붙이기
        int joined = prev >= 0 ? prev * 10 + num : prev * 10 - num;
        int newSum = sum - prev + joined;
        dfs(num + 1, newSum, joined, expr + " " + num);
    }
}