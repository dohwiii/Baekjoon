import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static String[] dna;
    static StringBuilder sb = new StringBuilder();
    static int diff = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dna = new String[N];

        for (int i = 0; i < N; i++) {
            dna[i] = br.readLine();
        }
        for (int i = 0; i < M; i++) {
            solve(i, 0, new int[4]);
        }
        System.out.println(sb);
        System.out.println(diff);

    }

    public static int getIndex(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'C': {
                return 1;
            }
            case 'G': {
                return 2;
            }
            case 'T': {
                return 3;
            }
        }
        return -1;
    }

    public static void solve(int index, int depth, int[] cnt) {
        if (depth == N) {
            int max = 0;
            int maxAlpIndex = 0;
            for (int i = 0; i < 4; i++) {
                if (cnt[i] > max) {
                    max = cnt[i];
                    maxAlpIndex = i;
                }
            }
            diff += (N - max);
            char maxAlp = ' ';
            if (maxAlpIndex == 0) {
                maxAlp = 'A';
            } else if (maxAlpIndex == 1) {
                maxAlp = 'C';
            } else if (maxAlpIndex == 2) {
                maxAlp = 'G';
            } else {
                maxAlp = 'T';
            }
            sb.append(maxAlp);
            return;
        }
        int idx = getIndex(dna[depth].charAt(index));
        cnt[idx]++;
        solve(index, depth + 1, cnt);
    }

}