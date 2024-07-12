import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] list;
    static boolean[] visited;
    static boolean isPossible;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new List[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        for (int i = 0; i < N; i++) {
            isPossible = false;
            visited = new boolean[N];
            solve(i, 1);
            if (isPossible) {
                System.out.println(1);
                break;
            }
        }

        if (!isPossible) {
            System.out.println(0);
        }

    }

    public static void solve(int x, int depth) {
        if (visited[x]) {
            return;
        }
        if (depth == 5) {
            isPossible = true;
            return;
        }
        visited[x] = true;

        for (int temp : list[x]) {
            if (!visited[temp]) {
                solve(temp, depth + 1);
            }
        }
        visited[x] = false;
    }
}
