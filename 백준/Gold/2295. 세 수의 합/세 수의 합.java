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
        Arrays.sort(arr);

        for (int i = N - 1; i >= 0; i--) {
            int d = arr[i];
            for (int j = 0; j < N; j++) {
                for (int k = j; k < N; k++) {
                    int sum = d - arr[j] - arr[k];
                    if (sum < 0) {
                        break;
                    }
                    if (Arrays.binarySearch(arr, sum) >= 0) {
                        System.out.println(d);
                        return;
                    }
                }
            }
        }

    }
}