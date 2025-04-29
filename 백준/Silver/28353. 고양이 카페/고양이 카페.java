import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //N마리 고양이
        int K = Integer.parseInt(st.nextToken());   //최대 무게
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);   //오름차순
        int s = 0, e = N - 1;
        int cnt = 0;
        while (s < e) {
            long weight = arr[s] + arr[e];
            if (weight <= K) {
                s++;
                e--;
                cnt++;
            }
            else {
                e--;
            }
        }
        System.out.println(cnt);




    }
}