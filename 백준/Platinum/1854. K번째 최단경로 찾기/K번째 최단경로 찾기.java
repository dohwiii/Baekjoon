
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K;
    static List<Travel>[] list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken()); //도시 개수
        M = Integer.parseInt(st.nextToken()); //도로 개수
        K = Integer.parseInt(st.nextToken()); //K번째 최단경로
        list = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()); //a->b 소요시간

            list[a].add(new Travel(b, c));
        }
        travel(2);
        System.out.println(sb.toString());
    }

    public static void travel(int destination) {
        //1번 도시 -> i번 도시 가는 K번째 최단경로의 소요시간
        PriorityQueue<Integer>[] distQueue = new PriorityQueue[N + 1];
        Comparator<Integer> cp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1 : -1;
            }
        };

        for (int i = 0; i <= N; i++) {
            distQueue[i] = new PriorityQueue<>(K, cp);
        }
        PriorityQueue<Travel> pq = new PriorityQueue<>();
        pq.add(new Travel(1, 0));
        distQueue[1].add(0);

        while (!pq.isEmpty()) {
            Travel now = pq.poll(); //현재 도시

            for (Travel next : list[now.city]) {

                if (distQueue[next.city].size() < K) { //아직 K번째에 도달하지 않았다면
                    distQueue[next.city].add(now.time + next.time);
                    pq.add(new Travel(next.city, now.time + next.time));

                } else if (distQueue[next.city].peek() > now.time + next.time) {
                    distQueue[next.city].poll();
                    distQueue[next.city].add(now.time + next.time);
                    pq.add(new Travel(next.city, now.time + next.time));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (distQueue[i].size() == K) { //K번째 최단거리가 있다면
                sb.append(distQueue[i].peek()).append("\n");
            } else {
                sb.append("-1" + "\n");
            }

        }
    }

}

class Travel implements Comparable<Travel> {
    int city, time;

    public Travel(int end, int time) {
        this.city = end;
        this.time = time;
    }

    @Override
    public int compareTo(Travel o) {
        return this.time - o.time;
    }
}