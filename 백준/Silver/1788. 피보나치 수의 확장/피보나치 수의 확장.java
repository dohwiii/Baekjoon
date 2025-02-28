import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000_000;

    // Fast Doubling 알고리즘: {F(n), F(n+1)}을 반환
    static long[] fib(long n) {
        if (n == 0) {
            return new long[]{0, 1};
        }
        long[] half = fib(n / 2);
        long a = half[0]; // F(k)
        long b = half[1]; // F(k+1)

        long c = (a * ((2 * b % MOD - a + MOD) % MOD)) % MOD;  // F(2k)
        long d = (a * a % MOD + b * b % MOD) % MOD;            // F(2k+1)

        if (n % 2 == 0) {
            return new long[]{c, d}; // {F(n), F(n+1)}
        } else {
            return new long[]{d, (c + d) % MOD}; // {F(n), F(n+1)}
        }
    }

    public static void main(String[] args) throws Exception {
        // 빠른 입출력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        
        // n = 0인 경우 처리
        if (n == 0) {
            System.out.println(0);
            System.out.println(0);
            return;
        }

        // 음수일 경우, abs(n)으로 피보나치 수를 계산
        long m = Math.abs((long)n);
        long[] result = fib(m);
        long fibVal = result[0] % MOD; // F(m) mod MOD

        // 부호 결정: F(-n) = (-1)^(n+1) * F(n)
        int sign;
        if (n > 0) {
            sign = 1;
        } else {
            sign = (m % 2 == 0) ? -1 : 1;
        }

        // 결과 출력
        System.out.println(sign);
        System.out.println(fibVal);
    }
}