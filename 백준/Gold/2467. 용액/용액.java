import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0, e = N - 1;
        int min = 2_000_000_000;
        int[] answer = new int[2];
        while (s < e) {
            int sum = arr[s] + arr[e];
            int abs = Math.abs(sum);
            if (min > abs) {
                answer[0] = arr[s];
                answer[1] = arr[e];
                min = abs;
            }
            if (sum == 0) {
                answer[0] = arr[s];
                answer[1] = arr[e];
                break;
            }
            else if (sum > 0) {
                e--;
            }
            else {
                s++;
            }

        }
        System.out.println(answer[0] + " " + answer[1]);


    }

}