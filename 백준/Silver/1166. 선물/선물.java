import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, L, W, H;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        double L = Double.parseDouble(st.nextToken());
        double W = Double.parseDouble(st.nextToken());
        double H = Double.parseDouble(st.nextToken());

        // A는 0 ≤ A ≤ min(L, W, H)
        double low = 0, high = Math.min(L, Math.min(W, H));

        // 1e-9 오차를 위해 100회 정도 반복
        for (int it = 0; it < 100; it++) {
            double mid = (low + high) / 2;

            // 각 차원에서 들어가는 박스 개수 = floor(길이 / mid)
            long cntL = (long)(L / mid);
            long cntW = (long)(W / mid);
            long cntH = (long)(H / mid);

            // 곱이 너무 커지면 double로 계산해도 안전
            double total = (double)cntL * cntW * cntH;

            if (total >= N) {
                // mid 크기를 올려봐도 N개 이상 들어가므로
                low = mid;
            } else {
                // mid가 너무 크면 N개 미만
                high = mid;
            }
        }
        System.out.println(String.format("%.10f", low));
    }
}