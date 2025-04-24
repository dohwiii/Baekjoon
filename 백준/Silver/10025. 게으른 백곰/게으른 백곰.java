import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final int MAX = 2_000_002;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] ice = new int[MAX + 1];
        int maxX = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            ice[x] += g;
            maxX = Math.max(maxX, x);
        }

        int range = 2 * K + 1;
        long sum = 0;

        // 초기 구간 합 계산
        for (int i = 0; i < range && i <= MAX; i++) {
            sum += ice[i];
        }

        long answer = sum;

        // 슬라이딩 윈도우로 오른쪽 이동하며 최대값 갱신
        for (int i = range; i <= maxX; i++) {
            sum = sum - ice[i - range] + ice[i];
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}