import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        long max = 0;
        Arrays.sort(arr);
        int[] sum2 = new int[N * N];
        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum2[index++] = arr[i] + arr[j];
            }
        }
        Arrays.sort(sum2);

        for (int i = N - 1; i >= 0; i--) {
            int d = arr[i];
            for (int j = 0; j < N; j++) {
                int need = d - arr[j];  //sum2에 존재하는지 검사
                if (Arrays.binarySearch(sum2, need) >= 0) {
                    System.out.println(d);
                    return;
                }
            }
        }

    }
}