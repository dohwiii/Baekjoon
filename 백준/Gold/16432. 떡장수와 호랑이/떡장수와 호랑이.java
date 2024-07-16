import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] list;
    static int[] answer;
    static boolean[][] memo;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());    // 일수
        list = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        answer = new int[N + 1];
        memo = new boolean[N + 1][10]; // 메모이제이션 배열 초기화

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            for (int j = 0; j < M; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        if (dfs(1, 0)) {
            for (int i = 1; i <= N; i++) {
                bw.write(answer[i] + "\n");
            }
        } else {
            bw.write("-1\n");
        }

        bw.flush();
    }

    public static boolean dfs(int day, int lastRice) {
        if (day == N + 1) {
            return true;
        }

        // 메모이제이션 체크
        if (memo[day][lastRice]) {
            return false;
        }

        for (int next : list[day]) {
            if (next != lastRice) {
                answer[day] = next;
                if (dfs(day + 1, next)) {
                    return true;
                }
            }
        }

        // 메모이제이션 저장
        memo[day][lastRice] = true;
        return false;
    }
}
