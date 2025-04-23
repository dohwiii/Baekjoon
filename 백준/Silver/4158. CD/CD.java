import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                break;
            }
            int[] A = new int[N];
            int[] B = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(br.readLine());
            }
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(br.readLine());
            }
//            st = new StringTokenizer(br.readLine());
//            int z1 = Integer.parseInt(st.nextToken());
//            int z2 = Integer.parseInt(st.nextToken());
//            if (z1 == 0 && z2 == 0) {
//                break;
//            }
            int ans = 0;
            int p1 = 0, p2 = 0;
            while (p1 < N && p2 < M) {
                if (A[p1] == B[p2]) {
                    p1++;
                    p2++;
                    ans++;
                } else {
                    if (A[p1] > B[p2]) {
                        p2++;
                    } else {
                        p1++;
                    }
                }
            }
            sb.append(ans + "\n");
        }
        System.out.println(sb);

    }


}