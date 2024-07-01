
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    //N개의 줄
        int[][] arr = new int[N][3];
        int[][] maxArr = new int[N][3];
        int[][] minArr = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        maxArr[0][0] = minArr[0][0] = arr[0][0];
        maxArr[0][1] = minArr[0][1] = arr[0][1];
        maxArr[0][2] = minArr[0][2] = arr[0][2];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                int now = arr[i][j];
                if (j == 0) {
                    maxArr[i][j] = Math.max(maxArr[i - 1][j] + now, maxArr[i - 1][j + 1] + now);
                    minArr[i][j] = Math.min(minArr[i - 1][j] + now, minArr[i - 1][j + 1] + now);

                } else if (j == 1) {
                    maxArr[i][j] = Math.max(Math.max(maxArr[i - 1][j - 1] + now, maxArr[i - 1][j] + now), maxArr[i - 1][j + 1] + now);
                    minArr[i][j] = Math.min(Math.min(minArr[i - 1][j - 1] + now, minArr[i - 1][j] + now), minArr[i - 1][j + 1] + now);

                } else {
                    maxArr[i][j] = Math.max(maxArr[i - 1][j] + now, maxArr[i - 1][j - 1] + now);
                    minArr[i][j] = Math.min(minArr[i - 1][j] + now, minArr[i - 1][j - 1] + now);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (max < maxArr[N - 1][i]) {
                max = maxArr[N - 1][i];
            }
            if (min > minArr[N - 1][i]) {
                min = minArr[N - 1][i];
            }
        }
        System.out.println(max + " " + min);

    }
}
