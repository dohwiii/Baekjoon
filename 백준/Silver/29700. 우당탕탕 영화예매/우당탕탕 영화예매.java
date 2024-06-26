import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());   //세로줄 수
        int M = Integer.parseInt(st.nextToken());   //가로줄 수
        int K = Integer.parseInt(st.nextToken());   //동아리원 수
        int cnt = 0;

        //'0' - 빈 좌석
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M - K + 1; j++) {   //시작점
                boolean isPossible = true;
                for (int k = j; k < j + K; k++) {
                    if (str.charAt(k) == '1') {
                        isPossible = false;
                    }
                }
                if (isPossible) {
                    cnt++;  //경우의 수 증가
                }
            }

        }
        System.out.println(cnt);

    }
}