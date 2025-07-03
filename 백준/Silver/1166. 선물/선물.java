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
        double answer = 0;

        while (low <= high) {
            double mid = (low + high) / 2.0;

            // 각 차원에서 들어가는 박스 개수 = floor(길이 / mid)
            long cntL = (long) (L / mid);
            long cntW = (long) (W / mid);
            long cntH = (long) (H / mid);

            // 곱이 너무 커지면 double로 계산해도 안전
            double total = (double) cntL * cntW * cntH;

            if (total >= N) {
                answer = Math.max(answer, mid);
                if (low == mid) {   // double 정밀도 한계로 더 이상 좁힐 수 없으면 종료
                    answer = mid;
                    break;
                }
                low = mid;
            }
            else {
                if (high == mid) {  // 역시 더 이상 좁힐 수 없으면 종료
                    answer = mid;
                    break;
                }
                high = mid;
            }
        }
        System.out.println(answer);
    }
}