import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<String> ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            ans = new ArrayList<>();

            solve(2, new StringBuilder("1"));
            Collections.sort(ans);
            for (String a : ans) {
                sb.append(a + "\n");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void solve(int depth, StringBuilder result) {
        if (depth == N + 1) {
            String r = result.toString().replace("0", "");;
            List<Character> oper = new ArrayList<>();
            for (char c : r.toCharArray()) {
                if (c == '+' || c == '-') {
                    oper.add(c);
                }
            }
            String[] arr = r.split("[+|-]");
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                list.add(Integer.parseInt(arr[i]));
            }
            int index = 0;
            int sum = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                int b = list.get(i);
                Character operator = oper.get(index);
                if (operator == '+') {
                    sum += b;
                }
                else {
                    sum -= b;
                }
                index++;
            }
            if (sum == 0) {
                String re = result.toString();
                re = re.replace("0", " ");
                ans.add(re);
            }

            return;
        }
        //더하기
        solve(depth + 1, new StringBuilder(result).append("+").append(depth));
        //빼기
        solve(depth + 1, new StringBuilder(result).append("-").append(depth));
        //공백
        solve(depth + 1, new StringBuilder(result).append("0").append(depth));
    }

}