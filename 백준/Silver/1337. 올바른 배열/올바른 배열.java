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
        int min = 5;
        int s = 0, e = 0;
        while (e < N) {
            int diff = arr[e] - arr[s];
            if (diff < 5) {
                int len = e - s + 1;
                min = Math.min(min, 5 - len);
                e++;
            } else {
                s++;
            }

        }
        System.out.println(min);


    }
}