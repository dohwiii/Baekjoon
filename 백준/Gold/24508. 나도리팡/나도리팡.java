import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long T = Long.parseLong(st.nextToken());

        long S = 0;
        long[] A = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
            S += A[i];
        }

        // 1) 총합이 K의 배수가 아니면 불가능
        if (S % K != 0) {
            System.out.println("NO");
            return;
        }

        // 2) 필요한 폭발 횟수
        long M = S / K;

        // 3) 큰 A_i부터 M개 골라 부족분 계산
        Arrays.sort(A);
        // A 내림차순: 뒤쪽부터 M개
        long sumTop = 0;
        for (int i = 0; i < M; i++) {
            sumTop += A[N - 1 - i];
        }
        long need = M * K - sumTop;

        // 4) 비교
        System.out.println(need <= T ? "YES" : "NO");
    }
}