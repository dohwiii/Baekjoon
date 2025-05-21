import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str;
        while (true) {
            str = br.readLine();
            if (str == null || str.equals("")) {
                break;
            }
            int X = Integer.parseInt(str) * 10_000_000;    //센티미터
            int N = Integer.parseInt(br.readLine());
            boolean isPossible = false;
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {   //나노미터
                arr[i] = Integer.parseInt(br.readLine());
            }
            //1 센티미터 = 10_000_000 나노미터
            Arrays.sort(arr);   //오름차순 정렬
            int s = 0, e = N - 1;
            while (s < e) {
                long sum = arr[s] + arr[e];
                if (sum == X) {
                    isPossible = true;
                    sb.append("yes ").append(arr[s] + " " + arr[e]).append("\n");
                    break;
                } else if (sum < X) {
                    s++;
                } else if (sum > X) {
                    e--;
                }
            }
            if (isPossible) {
                continue;
            }
            sb.append("danger\n");

        }

        System.out.println(sb);







    }
}