import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //애플파이 개수
        int K = Integer.parseInt(st.nextToken());   //먹으려는 애플파이 개수
        long[] taste = new long[N + N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            taste[i] = Integer.parseInt(st.nextToken());

            taste[i + N] = taste[i];    //이어붙이기
        }
        long sum = 0;
        for (int i = 0; i < K; i++) {
            sum += taste[i];
        }
        long temp = sum;
        for (int i = 1; i < 2 * N - K + 1; i++) {
            int end = i + K - 1;
            temp = temp - taste[i - 1] + taste[end];
            sum = Math.max(sum, temp);
        }
        System.out.println(sum);


    }
}