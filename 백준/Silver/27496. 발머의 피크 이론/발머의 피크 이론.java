import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //테스트까지 남은 시간
        int L = Integer.parseInt(st.nextToken());   //알코올 지속시간
        double[] alcohol = new double[N + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        long sum = 0;
        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int input = Integer.parseInt(st.nextToken());
            queue.offer(input);

            sum += input;
            if (queue.size() > L) {
                sum -= queue.poll();
            }

            if (sum >= 129 && sum <= 138) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}