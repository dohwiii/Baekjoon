import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int index = 1;

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] P = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                P[i] = Integer.parseInt(st.nextToken());
            }
            int count = 0;

            for (int i = 1; i < N - 1; i++) {
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;

                for (int j = i - 1; j <= i + 1; j++) {
                    min = Math.min(min, P[j]);
                    max = Math.max(max, P[j]);
                }
                if (P[i] != max && P[i] != min) {
                    count++;
                }
            }
            System.out.println("#" + index + " " + count);
            index++;
        }

    }
}