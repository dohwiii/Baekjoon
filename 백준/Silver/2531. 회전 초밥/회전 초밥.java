import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, d, k, c;
    static int[] sushi;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 접시의 수
        d = Integer.parseInt(st.nextToken());   // 초밥의 가짓수
        k = Integer.parseInt(st.nextToken());   // 연속해서 먹는 접시의 수
        c = Integer.parseInt(st.nextToken());   // 쿠폰 번호
        sushi = new int[N];

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        solve();
        System.out.println(max);
    }

    public static void solve() {
        int[] cnt = new int[d + 1]; // 먹은 초밥 카운트
        int type = 0;   // 초밥 종류

        // 초기 윈도우 설정
        for (int i = 0; i < k; i++) {
            if (cnt[sushi[i]] == 0) {
                type++;
            }
            cnt[sushi[i]]++;
        }

        // 쿠폰 초밥을 포함하여 최대 종류 계산
        max = (cnt[c] == 0) ? type + 1 : type;

        // 슬라이딩 윈도우 시작
        for (int i = 1; i < N; i++) {
            int end = (i + k - 1) % N;

            // 새로 추가된 초밥 처리
            if (cnt[sushi[end]] == 0) {
                type++;
            }
            cnt[sushi[end]]++;

            // 윈도우에서 제거되는 초밥 처리
            cnt[sushi[i - 1]]--;
            if (cnt[sushi[i - 1]] == 0) {
                type--;
            }

            // 쿠폰 초밥을 포함하여 최대 종류 계산
            if (cnt[c] == 0) {
                max = Math.max(max, type + 1);
            } else {
                max = Math.max(max, type);
            }
        }
    }
}
