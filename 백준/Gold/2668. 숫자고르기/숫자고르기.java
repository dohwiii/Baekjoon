import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] secondRow;
    static boolean[] visited;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        secondRow = new int[N + 1];
        visited = new boolean[N + 1];
        result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            secondRow[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                List<Integer> cycle = new ArrayList<>();
                findCycle(i, cycle);
                if (!cycle.isEmpty()) {
                    result.addAll(cycle);
                }
            }
        }

        Collections.sort(result);
        bw.write(result.size() + "\n");
        for (int num : result) {
            bw.write(num + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void findCycle(int start, List<Integer> cycle) {
        boolean[] inStack = new boolean[N + 1];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.peek();
            if (visited[node]) {
                stack.pop();
                continue;
            }
            visited[node] = true;
            inStack[node] = true;

            int next = secondRow[node];
            if (!visited[next]) {
                stack.push(next);
            } else if (inStack[next]) {
                // Cycle detected
                while (!stack.isEmpty()) {
                    int cycleNode = stack.pop();
                    cycle.add(cycleNode);
                    if (cycleNode == next) {
                        break;
                    }
                }
                return;
            }
        }
    }
}
