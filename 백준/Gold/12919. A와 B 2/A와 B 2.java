import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static boolean possible = false;
    static String S, T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        dfs(T);
        System.out.println(possible ? 1 : 0);
    }

    public static void dfs(String curr) {
        if (curr.length() == S.length()) {
            if (curr.equals(S)) possible = true;
            return;
        }

        if (possible) return; // 이미 찾았으면 더 안 봐도 됨

        // case 1: 마지막이 A면 A를 제거
        if (curr.charAt(curr.length() - 1) == 'A') {
            dfs(curr.substring(0, curr.length() - 1));
        }

        // case 2: 첫 번째가 B면 뒤집고 A 제거한 경우
        if (curr.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(curr).reverse();
            sb.deleteCharAt(sb.length() - 1);
            dfs(sb.toString());
        }
    }
}