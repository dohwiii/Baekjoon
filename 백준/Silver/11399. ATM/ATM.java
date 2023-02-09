import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] S = new int[N];
        int sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < N; i++)
        {
            int target = arr[i];
            int j = i - 1;

            while (j >= 0 && target < arr[j])
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = target;

        }
        S[0] = arr[0];
        for (int i = 1; i < N; i++)
        {
            S[i] = S[i - 1] + arr[i];
            sum += S[i];
        }
        sum = sum + S[0];
        System.out.println(sum);


    }
}
