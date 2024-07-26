import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] list;
    static int[] population;
    static boolean[] visited;
    static List<Integer> groupB;
    static List<Integer> groupA;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());   //구역 개수
        population = new int[N + 1];
        visited = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int near = Integer.parseInt(st.nextToken());
            for (int j = 0; j < near; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        for (int i = 1; i <= N - 1; i++) {
            combination(1, i);
        }
        int result = minDiff == Integer.MAX_VALUE ? -1 : minDiff;
        bw.write(result + " ");
        bw.close();
    }

    public static void combination(int start, int depth) {
        if (depth == 0) {
            groupA = new ArrayList<>();
            groupB = new ArrayList<>();

            for (int i = 1; i <= N; i++) {
                if (visited[i]) {
                    groupA.add(i);
                }
                else {
                    groupB.add(i);
                }
            }
            //연결되었는지 확인
            if (isConnected(groupA) && isConnected(groupB)) {
                int sumA = 0;
                int sumB = 0;
                for (int a : groupA) {
                    sumA += population[a];
                }
                for (int b : groupB) {
                    sumB += population[b];
                }
                minDiff = Math.min(minDiff, Math.abs(sumA - sumB));
            }
            return;
        }
        for (int i = start; i <= N; i++) {
            visited[i] = true;
            combination(i + 1, depth - 1);
            visited[i] = false;
        }
    }

    public static boolean isConnected(List<Integer> group) {
        boolean[] connected = new boolean[N + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(group.get(0));
        connected[group.get(0)] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : list[now]) {
                if (connected[next]) {
                    continue;
                }
                if (!group.contains(next)) {
                    continue;
                }
                connected[next] = true;
                queue.offer(next);
            }
        }
        for (int num : group) {
            if (!connected[num]) {
                return false;
            }
        }
        return true;
    }

}
