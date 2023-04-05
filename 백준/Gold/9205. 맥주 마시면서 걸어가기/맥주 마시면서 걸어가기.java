import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String[] arr;
    static ArrayList<int[]>[] list;
    static int[] dist;
    static Queue<Integer> queue;
    static boolean[] visited;
    static ArrayList<Pos>[] list2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); //테스트 개수

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); //편의점 개수
            list = new ArrayList[N + 2];
            list2 = new ArrayList[N + 2];
            dist = new int[N + 2];
            queue = new LinkedList<>();
            visited = new boolean[N + 2];

            for (int j = 0; j < N + 2; j++) {
                dist[j] = j;
            }
            for (int j = 0; j < N + 2; j++) {
                list[j] = new ArrayList<>();
                list2[j] = new ArrayList<>();
            }
            for (int j = 0; j < N + 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list[j].add(new int[]{x, y});
            }
            for (int j = 0; j < N + 1; j++)  //0,1,2
            {
                int[] start = list[j].get(0);
                for (int k = j + 1; k < N + 2; k++) //1,2,3
                {
                    int[] end = list[k].get(0);
                    int diffX = Math.abs(end[0] - start[0]);
                    int diffY = Math.abs(end[1] - start[1]);
                    int sum = diffX + diffY;
                    list2[j].add(new Pos(k, sum));
                    list2[k].add(new Pos(j, sum));
                }
            }
            queue.add(0);
            visited[0] = true;
            boolean arrive = false;

            while (!queue.isEmpty()) {
                int now = queue.poll();
                if (now == N + 1) {
                    System.out.println("happy");
                    arrive = true;
                    break;
                }

                for (Pos next : list2[now]) {
                    if (!visited[next.e] && next.v <= 1000) {
                        queue.add(next.e);
                        visited[next.e] = true;
                    }
                }
            }
            if (!arrive) {
                System.out.println("sad");
            }

        }
    }

}

class Pos{
    int s, e, v;

    public Pos(int e, int v) {
        this.e = e;
        this.v = v;
    }

    public Pos(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }
}