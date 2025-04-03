import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime(i)) {
                primeList.add(i);
            }
        }
        int answer = 0;
        if (N == 1) {
            answer = 0;
        } else {
            answer = solve(primeList);
        }
        

        System.out.println(answer);


    }

    public static int solve(List<Integer> primeList) {
        int s = 0, e = 0;
        int[] arr = primeList.stream().mapToInt(i -> i).toArray();
        long sum = arr[0];
        int ans = 0;

        while (s <= e && e < arr.length) {
            if (sum <= N) {
                if (sum == N) {
                    ans++;
                }
                e++;
                if (e >= arr.length) {
                    break;
                }
                sum += arr[e];
            } else {
                sum -= arr[s];
                s++;
            }
        }
        return ans;
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


}