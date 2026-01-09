import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parent, size;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // 컴퓨터 수
        M = Integer.parseInt(br.readLine());    // 연결된 컴퓨터 쌍의 개수
        parent = new int[N + 1];
        size = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            union(s, e);
        }
        int maxSize = 1;
        for (int i = 1; i <= N; i++) {
            if (find(i) == i) { // 루트만
                maxSize = Math.max(maxSize, size[i]);
            }
        }
        System.out.println(maxSize - 1);


    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra == rb) {
            return;
        }
        if (size[ra] < size[rb]) {
            int temp = ra;
            ra = rb;
            rb = temp;
        }
        parent[rb] = ra;
        size[ra] += size[rb];
    }

}
