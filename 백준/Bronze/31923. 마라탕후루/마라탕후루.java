
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, P, Q;
    static int[] strawberry, shinemuscat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(st.nextToken());   //탕후루 꼬치의 개수
        P = Integer.parseInt(st.nextToken());   //로봇이 1분마다 꽂는 딸기의 수
        Q = Integer.parseInt(st.nextToken());   //샤인머스캣 수

        strawberry = new int[N];
        shinemuscat = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            strawberry[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            shinemuscat[i] = Integer.parseInt(st.nextToken());
        }

        bw.write("YES\n");
        for (int i = 0; i < N; i++) {
            int result = solve(strawberry[i], shinemuscat[i]);
            if (result == -1) {
                System.out.println("NO");
                System.exit(0);
            }
            bw.write(result + " ");
        }
        bw.flush();

    }

    public static int solve(int straw, int shine) {
        int cnt = 0;

        while (straw != shine) {
            straw += P;
            shine += Q;
            cnt++;
            if (cnt > 10000) {
                cnt = -1;
                break;
            }
            if (straw == shine) {
                break;
            }
        }
        return cnt;
    }

}