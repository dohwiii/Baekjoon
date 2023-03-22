import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int deleteNode, rootNode;
    static int count;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N];
        visited = new boolean[N];
        rootNode = 0;
        count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x == -1) {
                rootNode = i;
                continue;
            }
            list[i].add(x);
            list[x].add(i);
        }
        deleteNode = Integer.parseInt(br.readLine()); //4

        if (rootNode == deleteNode) {
            System.out.println(0);
        }
        else
        {
            DFS(rootNode);
            System.out.println(count);
        }
    }
    public static void DFS(int node)
    {
        int cNode = 0;
        visited[node] = true;
        for (int i : list[node])
        {
            if (!visited[i] && i != deleteNode)
            {
                cNode++;
                DFS(i);
            }
        }
        if (cNode == 0) {
            count++;
        }
    }

}