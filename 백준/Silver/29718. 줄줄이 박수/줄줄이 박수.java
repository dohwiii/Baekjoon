import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //행
        int M = Integer.parseInt(st.nextToken());   //열
        int[][] cheer = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cheer[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] sumArr = new int[M];

        for (int i = 0; i < M; i++) {   //4
            int sum = 0;
            for (int j = 0; j < N; j++) {   //3
                sum += cheer[j][i];
            }
            sumArr[i] = sum;
        }
        int K = Integer.parseInt(br.readLine());    //열의 개수
        int result = 0;

        for (int i = 0; i < K; i++) {
            result += sumArr[i];
        }
        int temp = result;
        for (int i = 1; i < M - K + 1; i++) {
            int end = i + K - 1;
            temp = temp - sumArr[i - 1] + sumArr[end];
            result = Math.max(result, temp);
        }
        System.out.println(result);

    }
}