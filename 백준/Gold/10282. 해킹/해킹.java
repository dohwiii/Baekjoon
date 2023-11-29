
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, D, C;
    static List<Hack>[] list;
    static int[] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //컴퓨터 개수
            D = Integer.parseInt(st.nextToken()); //의존성 개수
            C = Integer.parseInt(st.nextToken()); //해킹당한 컴퓨터 번호

            time = new int[N + 1];
            list = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                list[i] = new ArrayList<>();
            }

            Arrays.fill(time, Integer.MAX_VALUE);
            time[C] = 0;

            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                list[b].add(new Hack(a, s));
            }
            hacking(C);

            int hacked = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= N; i++) {
                if (time[i] != Integer.MAX_VALUE) {
                    hacked++;
                    max = Math.max(max, time[i]);
                }
            }

            System.out.println(hacked + " " + max);
        }


    }

    public static void hacking(int start) {
        PriorityQueue<Hack> pqueue = new PriorityQueue<>();
        pqueue.add(new Hack(start, 0));

        while (!pqueue.isEmpty()) {
            Hack now = pqueue.poll();

            for (Hack next : list[now.com]) {
                if (time[next.com] > now.sec + next.sec) {
                    time[next.com] = now.sec + next.sec;
                    pqueue.add(new Hack(next.com, now.sec + next.sec));
                }
            }
        }

    }

}

class Hack implements Comparable<Hack>{
    int com, sec;

    public Hack(int com, int s) {
        this.com = com;
        this.sec = s;
    }

    @Override
    public int compareTo(Hack o) {
        return this.sec - o.sec;
    }
}
