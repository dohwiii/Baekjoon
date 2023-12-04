
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static Vertex[] vertex; //정점
    static List<Edge>[] list;
    static double[] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        vertex = new Vertex[102];
        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            vertex[i] = new Vertex(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), i);

        }

        N = Integer.parseInt(br.readLine()); //대포의 개수
        vertex[N + 1] = new Vertex(vertex[1].x, vertex[1].y, N + 1); //도착점 재지정

        list = new ArrayList[N + 2];
        time = new double[N + 2];
        for (int i = 0; i <= N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            vertex[i] = new Vertex(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), i);
        }
        Arrays.fill(time, Integer.MAX_VALUE);
        for (int i = 0; i < N + 1; i++) {
            for (int j = i + 1; j < N + 2; j++) {
                double distance = getDist(vertex[i], vertex[j]); //두 점 사이 거리 계산
                list[i].add(new Edge(j, distance, 0));
                list[j].add(new Edge(i, distance, 0));
            }
        }
        solve();
        System.out.println(time[N + 1]);

    }

    public static void solve() {
        PriorityQueue<Edge> pqueue = new PriorityQueue<>();
        time[0] = 0;
        pqueue.add(new Edge(0, 0, 0));

        while (!pqueue.isEmpty()) {
            Edge now = pqueue.poll();
            if (time[now.target] < now.sec) {
                continue;
            }

            for (Edge next : list[now.target]) {
                if (now.target > 0 && now.target < N + 1) { //대포(출발지, 도착지 제외)
                    if (next.dist >= 50) { //대포거리
                        double sec = now.sec + 2 + ((next.dist - 50) / 5.0);
                        if (time[next.target] > sec) {
                            time[next.target] = sec;
                            pqueue.add(new Edge(next.target, 0, sec));
                        }
                    } else { //걸어가는 것보다 대포로 50m 간 다음 그 위치에서 걸어가는게 더 빠를 경우
                        double sec = now.sec + 2 + ((50 - next.dist) / 5.0);

                        if (time[next.target] > sec) {
                            time[next.target] = sec;
                            pqueue.add(new Edge(next.target, 0, sec));
                        }
                    }
                }
                //only 걸어감
                double sec = now.sec + (next.dist) / 5.0;
                if (time[next.target] > sec) {
                    time[next.target] = sec;
                    pqueue.add(new Edge(next.target, 0, sec));
                }
            }
        }

    }

    public static double getDist(Vertex s, Vertex e) {
        double x1 = s.x;
        double y1 = s.y;
        double x2 = e.x;
        double y2 = e.y;

        double r1 = Math.pow((x2 - x1), 2);
        double r2 = Math.pow((y2 - y1), 2);

        return Math.sqrt(r1 + r2);
    }
}

//간선
class Edge implements Comparable<Edge>{
    int target;
    double dist, sec;

    public Edge(int target, double dist, double sec) {
        this.target = target;
        this.dist = dist;
        this.sec = sec;
    }

    @Override
    public int compareTo(Edge o) {
        return Double.compare(this.sec, o.sec);
    }

}

//정점
class Vertex {
    double x, y;
    int index;

    public Vertex(double x, double y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
    }
}