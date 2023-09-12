
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static Node[] nodes;
    static boolean[] visited;
    static int visitedCnt;
    static List<Integer> similarInOrderList, inOrderList;
    static int lastNode;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //노드의 개수
        nodes = new Node[N + 1];
        inOrderList = new ArrayList<>();
        similarInOrderList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            nodes[now] = new Node(left, right);
        }
        //유사 중위 순회의 끝은 중위 순회할 때 마지막 노드
        inOrder(1);
        lastNode = inOrderList.get(N - 1); //중위 순회의 마지막 노드

        visited = new boolean[N + 1];
        visited[0] = true;
        similarInOrder(1);

    }
    public static void similarInOrder(int cur)
    {
        similarInOrderList.add(cur);
        if (!visited[cur]) {
            visited[cur] = true; //방문처리
            visitedCnt++; //방문한 노드 개수
        }
        Node curNode = nodes[cur];
        int left = curNode.left;
        int right = curNode.right;

        if (left != -1) { //왼쪽 자식 노드가 있다면
            similarInOrder(curNode.left);
            similarInOrderList.add(cur);
        }
        if (right != -1) { //오른쪽 자식 노드가 있다면
            similarInOrder(curNode.right);
            similarInOrderList.add(cur);
        }
        //모든 노드를 방문하고 중위순회의 마지막 노드와 일치한다면
        if (visitedCnt == N && cur == lastNode) {
            System.out.println(similarInOrderList.size() - 1);
            System.exit(0);
        }
    }

    //중위순회
    public static void inOrder(int cur) {
        Node curNode = nodes[cur];
        int left = curNode.left;
        int right = curNode.right;

        if (left != -1) {
            inOrder(left);
        }
        inOrderList.add(cur);

        if (right != -1) {
            inOrder(curNode.right);
        }

    }
}


class Node {
    int left, right;

    public Node(int left, int right) {
        this.left = left;
        this.right = right;
    }
}