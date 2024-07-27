import java.io.*;
import java.util.*;

public class Main {
    static int A, B, C;
    static Set<Integer> set = new HashSet<>();
    static boolean[][][] visited;
    static boolean[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[A + 1][B + 1][C + 1];
        ans = new boolean[C + 1];

        bfs();
        for (int i = 0; i <= C; i++) {
            if (ans[i]) {
                bw.write(i + " ");
            }
        }
        bw.flush();
        bw.close();
    }

    public static void bfs() {
        Queue<Bottle> queue = new ArrayDeque<>();
        queue.offer(new Bottle(0, 0, C));
        visited[0][0][C] = true;

        while (!queue.isEmpty()) {
            Bottle now = queue.poll();
            if (now.A == 0) {
                ans[now.C] = true;
            }
            int quantity;
            int nA, nB, nC;

            if (now.A > 0) {
                quantity = now.A;
                if (now.B + quantity > B) { //A->B
                    nA = quantity - (B - now.B);
                    nB = B;
                    nC = now.C;

                } else {
                    nA = 0;
                    nB = now.B + quantity;
                    nC = now.C;
                }
                if (!visited[nA][nB][nC]) {
                    queue.offer(new Bottle(nA, nB, nC));
                    visited[nA][nB][nC] = true;
                }
                //A->C
                nA = 0;
                nB = now.B;
                nC = now.C + quantity;
                if (!visited[nA][nB][nC]) {
                    queue.offer(new Bottle(nA, nB, nC));
                    visited[nA][nB][nC] = true;
                }
            }
            if (now.B > 0) {
                quantity = now.B;
                if (now.A + quantity > A) { //B->A
                    nA = A;
                    nB = quantity - (A - now.A);
                    nC = now.C;

                } else {
                    nA = now.A + quantity;
                    nB = 0;
                    nC = now.C;
                }
                if (!visited[nA][nB][nC]) {
                    queue.offer(new Bottle(nA, nB, nC));
                    visited[nA][nB][nC] = true;
                }
                //B->C
                nA = now.A;
                nB = 0;
                nC = now.C + quantity;
                if (!visited[nA][nB][nC]) {
                    queue.offer(new Bottle(nA, nB, nC));
                    visited[nA][nB][nC] = true;
                }
            }
            if (now.C > 0) {
                quantity = now.C;
                if (now.A + quantity > A) { //C가 A에게 줌
                    nA = A;
                    nB = now.B;
                    nC = quantity - (A - now.A);

                } else {
                    nA = now.A + quantity;
                    nB = now.B;
                    nC = 0;
                }
                if (!visited[nA][nB][nC]) {
                    queue.offer(new Bottle(nA, nB, nC));
                    visited[nA][nB][nC] = true;
                }
                if (now.B + quantity > B) { //C->B
                    nA = now.A;
                    nB = B;
                    nC = quantity - (B - now.B);
                } else {
                    nA = now.A;
                    nB = now.B + quantity;
                    nC = 0;
                }
                if (!visited[nA][nB][nC]) {
                    queue.offer(new Bottle(nA, nB, nC));
                    visited[nA][nB][nC] = true;
                }
            }
        }
    }
}

class Bottle {
    int A, B, C;

    public Bottle(int A, int B, int C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }
}