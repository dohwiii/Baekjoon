import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] ice = new int[4_000_002];
        int maxX = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());   //얼음 양
            int x = Integer.parseInt(st.nextToken());   //좌표
            ice[x] = g; //x좌표에 있는 얼음
            maxX = Math.max(maxX, x);
        }
        int size = 2 * K + 1;
        long sum = 0;

        for (int i = 0; i < size; i++) {
            sum += ice[i];
        }
        long maxIce = sum;
        if (N > 1) {
            for (int i = 1; i < maxX - size + 1; i++) {
                int end = i + size - 1;
                sum -= ice[i - 1];
                sum += ice[end];
                maxIce = Math.max(maxIce, sum);
            }
        }
        else {
            maxIce = maxX;
        }


        System.out.println(maxIce);


    }

}