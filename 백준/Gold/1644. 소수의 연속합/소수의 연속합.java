import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int numOfPrimeNumbers;
    static int[] primeNumbers = new int[400000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        findPrimeNumbers();
        int answer = solve();

        System.out.println(answer);


    }
    public static void findPrimeNumbers() {
        boolean[] isNoPrime = new boolean[N + 1];  // 소수가 아닌 수를 true로 표시
        int prevPrimeNumber = primeNumbers[numOfPrimeNumbers++] = 2;  // 2는 소수니까 먼저 추가

        for (int i = 3; i <= N; i += 2) {  // 홀수만 검사
            if (isNoPrime[i]) continue;  // 이미 소수가 아니라고 체크된 수는 패스

            // 현재 소수 i를 배열에 추가
            primeNumbers[numOfPrimeNumbers++] = prevPrimeNumber = i;

            // i의 배수들을 소수가 아니라고 표시
            for (int j = i * 2; j <= N; j += i) {
                isNoPrime[j] = true;
            }
        }

    }

    public static int solve() {
        int s = 0, e = 0, ans = 0;
        long sum = 0;

        while (true) {
            if (sum >= N) {
                if (sum == N) ans++;
                sum -= primeNumbers[s++];
            } else {
                if (e == numOfPrimeNumbers) break;
                sum += primeNumbers[e++];
            }
        }
        return ans;
    }

}