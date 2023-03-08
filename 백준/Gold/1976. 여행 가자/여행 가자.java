import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parent;
    static int[][] city;
    static int[] route;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        city = new int[N + 1][N + 1];
        route = new int[M + 1];

        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 1; i <= N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++)
            {
                city[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= M; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (city[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        for (int i = 1; i <= N; i++)
        {
            parent[i] = find(parent[i]);

        }
        int index = find(route[1]); //3
        for (int i = 2; i < route.length; i++) {
            if (index != find(route[i])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

//        int count = 0;
//        for (int i = 1; i < M; i++)
//        {
//            if (parent[route[i]] == parent[route[i + 1]]) {
//                count++;
//            }
//
//        }
//        if (count + 1 == M) {
//
//            System.out.println("YES");
//        }



    }

    public static void union(int a, int b) {
        a = find(Math.max(a, b));
        b = find(Math.min(a, b));

        if (a != b) {
            parent[b] = a;
        }
    }

    public static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        else
            return parent[a] = find(parent[a]);
    }
}