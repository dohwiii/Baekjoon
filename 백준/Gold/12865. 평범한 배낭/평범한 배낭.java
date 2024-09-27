
import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static Bag[] bags;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());   //넣을 수 있는 최대 무게
        bags = new Bag[N];
        dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            bags[i] = new Bag(w, k);
        }

        for (int i = 1; i <= N; i++) {
            //현재 물건의 무게와 가치
            Bag now = bags[i - 1];
            int weight = now.weight;
            int value = now.value;

            for (int w = K; w >= weight; w--) {
                if (dp[w] < dp[w - weight] + value) {
                    dp[w] = dp[w - weight] + value;
                }
            }
        }
        System.out.println(dp[K]);
    }


}
class Bag {
    int weight, value;

    public Bag(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}