import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int[] rock = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        long sum = 0;

        for (int i = 0; i < M; i++) {
            rock[i] = Integer.parseInt(st.nextToken());
            sum += rock[i];
        }
        int K = Integer.parseInt(br.readLine());
        double totalP = 0.0;

        for (int i = 0; i < M; i++) {
            int rockNum = rock[i];
            double possible = 1.0;
            long tempS = sum; //12

            for (int j = 0; j < K; j++)
            {
                possible = possible * (rockNum / (double) tempS);
                rockNum--;
                tempS--;
            }
            totalP = totalP + possible;
        }
        System.out.println(totalP);

    }
}