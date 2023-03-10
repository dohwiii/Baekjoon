import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<Node>[] list = new ArrayList[N + 1];
        ArrayList<Node>[] reverselist = new ArrayList[N + 1];
        int[] degree = new int[N + 1];
        int[] timeBuilding = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
            reverselist[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            list[x].add(new Node(y, time));
            reverselist[y].add(new Node(x, time));
            degree[y]++;

        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int[] answer = new int[N + 1];

        while (!queue.isEmpty())
        {
            int now = queue.poll();
            for (Node node : list[now])
            {
                int target = node.target;
                int value = node.value;

                degree[target]--;
                answer[target] = Math.max(answer[now] + value, answer[target]);
                if (degree[target] == 0) {
                    queue.add(target);
                }
            }
        }
        Queue<Integer> queue2 = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        queue2.add(end);
        visited[end] = true;
        int count = 0;
        while (!queue2.isEmpty())
        {
            int now = queue2.poll();
            for (Node node : reverselist[now])
            {
                int target = node.target;
                int value = node.value;
                if (answer[now] == value + answer[target])
                {
                    count++;
                    if (!visited[target]) {
                        visited[target] = true;
                        queue2.add(target);
                    }


                }
            }
        }
        System.out.println(answer[end]);
        System.out.println(count);



    }

}
class Node
{
    int target;
    int value;

    public Node(int target, int value) {
        this.target = target;
        this.value = value;
    }
}