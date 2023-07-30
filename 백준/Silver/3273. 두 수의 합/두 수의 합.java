import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int X = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int answer = 0;
        int start = 0;
        int end = N - 1;

        while (start < end) {

            int sum = arr[start] + arr[end];

            if (sum == X) {
                answer++;
                start++;
                end--;
            }
            else if (sum > X) {
                end--;
            }
            else if (sum < X) {
                start++;
            }
        }
        System.out.println(answer);
    }

}