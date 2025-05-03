import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == C) {  //한 개 조합
                System.out.println(1);
                return;
            }
        }
        Arrays.sort(arr);
        int s = 0, e = N - 1;
        while (s < e) {
            long sum = arr[s] + arr[e];
            if (sum == C) { //두 개 조합
                System.out.println(1);
                return;
            }
            else if (sum > C) { //초과했다면
                e--;
            }
            else {  //두 개만으로 부족한 경우
                int diff = C - arr[s] - arr[e];

                if (diff != arr[s] && diff != arr[e] && Arrays.binarySearch(arr, s + 1, e + 1, diff) > 0) {
                    System.out.println(1);
                    return;
                }
                s++;
            }
        }

        System.out.println(0);


    }
}