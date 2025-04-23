import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        // 값의 범위가 1..100000 이므로 크기 100001
        int[] last = new int[100001];
        // 등장 전에는 “나온 적이 없다” 라는 표시로 -1 세팅
        for (int i = 1; i <= 100000; i++) {
            last[i] = -1;
        }

        long ans = 0;
        // l: 현재 윈도우의 시작 인덱스
        int l = 0;
        for (int r = 0; r < N; r++) {
            int x = a[r];
            // x가 이전에 last[x] 위치에 나왔었다면,
            // 윈도우 시작을 그 다음 위치로 뛰어올라가야 중복이 해소된다
            if (last[x] >= l) {
                l = last[x] + 1;
            }
            // r을 끝으로 하는 유효한 구간 수는 (r - l + 1)
            ans += (r - l + 1);
            // x의 마지막 등장 위치 갱신
            last[x] = r;
        }

        System.out.println(ans);
    }
}