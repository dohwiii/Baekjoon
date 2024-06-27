import java.io.*;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //테스트까지 남은 시간
        int L = Integer.parseInt(st.nextToken());   //알코올 지속시간
        int[] alcohol = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int input = Integer.parseInt(st.nextToken());
            alcohol[i] = alcohol[i - 1] + input;
        }
        int cnt = 0;

        // 알코올 농도 체크
        for (int i = 1; i <= N; i++) {
            int density = alcohol[i];
            if (i > L) {
                density = alcohol[i] - alcohol[i - L];

            }
            if (density >= 129 && density <= 138) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}