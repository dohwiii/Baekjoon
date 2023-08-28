
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[] visited;
    static int minDiff;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N];
        minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combi(0, 0);
        System.out.println(minDiff);


    }

    public static void combi(int index, int depth) {
        if (depth == N / 2) {
            int[] arr = new int[N / 2];
            int[] arr2 = new int[N / 2];
            int cnt = 0;
            int cnt2 = 0;

            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    arr[cnt] = i;
                    cnt++;
                } else {
                    arr2[cnt2] = i;
                    cnt2++;
                }
            }
            minDiff = Math.min(minDiff, calc(arr, arr2));
            return;

        }
        for (int i = index; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combi(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static int calc(int[] arr, int[] arr2) {
        int sum = 0;
        int sum2 = 0;
        for (int i = 0; i < arr.length - 1; i++) { //0
            int fix = arr[i];
            for (int j = i + 1; j < arr.length; j++) { //1
                int value = arr[j];
                sum += map[fix][value] + map[value][fix];
            }
        }
        for (int i = 0; i < arr2.length - 1; i++) { //0
            int fix = arr2[i];
            for (int j = i + 1; j < arr2.length; j++) { //1
                int value = arr2[j];
                sum2 += map[fix][value] + map[value][fix];
            }
        }
        return Math.abs(sum - sum2);
    }
}
