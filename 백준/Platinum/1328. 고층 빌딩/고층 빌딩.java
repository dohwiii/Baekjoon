import java.io.*;
import java.util.*;

public class Main {
    static final long mod = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        long[][][] D = new long[N + 1][N + 1][N + 1];

        D[1][1][1] = 1; //빌딩 하나

        for (int i = 2; i <= N; i++)
        {
            for (int j = 1; j <= L; j++)
            {
                for (int k = 1; k <= R; k++)
                {
                    D[i][j][k] = (D[i - 1][j - 1][k] + D[i - 1][j][k - 1] + D[i - 1][j][k] * (i - 2)) % mod;

                }

            }
        }
        System.out.println(D[N][L][R]);
    }
}