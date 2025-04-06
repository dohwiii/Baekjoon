import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] sushi;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());   //초밥 가짓수
        int k = Integer.parseInt(st.nextToken());   //연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken());   //쿠폰 번호
        sushi = new int[N];
        int[] cnt = new int[d + 1];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int type = 0;
        int max = 0;
        for (int i = 0; i < k; i++) {
            if (cnt[sushi[i]] == 0) {
                type++;
            }
            cnt[sushi[i]]++;
        }
        max = (cnt[c] == 0) ? type + 1 : type;
        for (int i = 1; i < N; i++) {
            int end = (i + k - 1) % N;
            cnt[sushi[i - 1]]--;
            if (cnt[sushi[i - 1]] == 0) {
                type--;
            }
            if (cnt[sushi[end]] == 0) {
                type++;
            }
            cnt[sushi[end]]++;
            if (cnt[c] == 0) {
                cnt[c]++;
                type++;
            }
            max = Math.max(max, type);
        }
        System.out.println(max);

    }

}