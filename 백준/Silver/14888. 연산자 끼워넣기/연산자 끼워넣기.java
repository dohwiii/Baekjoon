import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] operator;
    static int[] num;
    static long min = Long.MAX_VALUE;
    static long max = Long.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        operator = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        dfs(operator[0], operator[1], operator[2], operator[3], num[0], 1);
        System.out.println(max);
        System.out.println(min);

    }

    public static void dfs(int plus, int minus, int multi, int divide, long sum, int index) {

        if (plus == 0 && minus == 0 && multi == 0 && divide == 0) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        if (plus > 0) {
            dfs(plus - 1, minus, multi, divide, sum + num[index], index + 1);
        }
        if (minus > 0) {
            dfs(plus, minus - 1, multi, divide, sum - num[index], index + 1);
        }
        if (multi > 0) {
            dfs(plus, minus, multi - 1, divide, sum * num[index], index + 1);
        }
        if (divide > 0) {
            long result = sum;
            if (sum < 0) {
                result = -1 * sum;
                result = (long) result / num[index];
                result = result * -1;
            } else {
                result = (long) sum / num[index];
            }
            dfs(plus, minus, multi, divide - 1, result, index + 1);
        }
    }
}