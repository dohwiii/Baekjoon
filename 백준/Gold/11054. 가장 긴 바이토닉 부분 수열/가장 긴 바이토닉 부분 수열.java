import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] dp_inc = new int[N];
        int[] dp_dec = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] lis = getLIS(arr);
        int[] lds = getLIS(reverseArray(arr));

        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            maxLength = Math.max(maxLength, lis[i] + lds[N - i - 1] - 1);
        }
        System.out.println(maxLength);
    }

    public static int[] getLIS(int[] arr) {
        int N = arr.length;
        int[] lisLength = new int[N];
        int[] dp = new int[N];
        int length = 0;

        for (int i = 0; i < N; i++) {
            int index = lowerBound(dp, arr[i], length);
            dp[index] = arr[i];

            if(index == length) {
                length++;
            }
            lisLength[i] = index + 1;

        }
        return lisLength;

    }

    private static int lowerBound(int[] dp, int num, int len) {
        int left = 0, right = len;

        while (left < right) {
            int mid = (left + right) / 2;
            if (dp[mid] >= num) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static int[] reverseArray(int[] arr) {
        int N = arr.length;
        int[] rev = new int[N];
        int index = N - 1;
        for (int i = 0; i < N; i++) {
            rev[i] = arr[N - i - 1];
        }
        return rev;
    }

}
