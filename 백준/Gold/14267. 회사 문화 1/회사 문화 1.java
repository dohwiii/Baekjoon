
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N, M;
    static long[] scores;
    static int[] parents;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //회사의 직원 수
        M = Integer.parseInt(st.nextToken());   //최초의 칭찬 횟수
        parents = new int[N + 1];
        scores = new long[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            parents[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            scores[e] += c;
        }
        for (int i = 2; i <= N; i++) {
            scores[i] += scores[parents[i]];
        }

        for (int i = 1; i <= N; i++) {
            bw.write(scores[i] + " ");
        }
        bw.flush();


    }

}
