
import java.io.*;
import java.nio.Buffer;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N, X;
    static int[] visited;
    static int max = Integer.MIN_VALUE;
    static int maxCount;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //블로그 시작 일수
        X = Integer.parseInt(st.nextToken());   //연속 X일
        visited = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visited[i] = Integer.parseInt(st.nextToken());
        }
        solve();
        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(maxCount);
        }

    }

    public static void solve() {
        int cnt = 0;
        for (int i = 0; i < X; i++) {
            cnt += visited[i];
        }
        max = cnt;
        maxCount = 1;
        //i는 start
        for (int i = 1; i < N - X + 1; i++) {
            int end = i + X - 1;
            cnt += visited[end];

            cnt -= visited[i - 1];  //이전위치 빼주기

            if (cnt > max) {
                max = cnt;
                maxCount = 1;
            } else if (cnt == max) {
                maxCount++;
            }

//            if (max == cnt) {
//                if (map.get(max) != null) {
//                    int value = map.get(max);
//                    value++;
//                    map.put(max, value);
//                } else {
//                    map.put(max, 1);
//                }
//            }

        }

    }
}