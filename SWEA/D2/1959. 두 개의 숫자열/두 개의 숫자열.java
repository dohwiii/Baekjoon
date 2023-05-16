import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); //배열 크기
            int M = Integer.parseInt(st.nextToken()); //배열 크기
            int[] A = new int[N];
            int[] B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }
            int bigger = Math.max(A.length, B.length);
            int smaller = Math.min(A.length, B.length);
            int result = Integer.MIN_VALUE;
            for (int j = 0; j < bigger - smaller + 1; j++) {
                int sum = multiply(A, B, j);
                result = Math.max(result, sum);
            }
            System.out.println("#" + (i + 1) + " " + result);
        }
    }
    public static int multiply(int[] A, int[] B, int start) {
        int minLength = Math.min(A.length, B.length);
        int sum = 0;

        if (A.length <= B.length) {
            for (int i = 0; i < minLength; i++) {
                sum += A[i] * B[start + i];
            }
        }
        else
        {
            for (int i = 0; i < minLength; i++) {
                sum += A[start + i] * B[i];
            }
        }
        return sum;
    }
}