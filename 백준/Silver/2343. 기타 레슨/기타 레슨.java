import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int N, M;
    static int start, end;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //레슨 수
        M = Integer.parseInt(st.nextToken()); //블루레이 개수

        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
            if (start < arr[i]) {
                start = arr[i];
            }
            end = end + arr[i];
        }
        while (start <= end) {
            int sum = 0;
            int count = 0;
            int mid = (start + end) / 2;

            for (int i = 0; i < N; i++) {
                if (sum + arr[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum = sum + arr[i];
            }
            if (sum != 0) {
                count++;
            }
            if (count > M) {
                start = mid + 1;

            } else
                end = mid - 1;


        }
        System.out.println(start);
    }

}
