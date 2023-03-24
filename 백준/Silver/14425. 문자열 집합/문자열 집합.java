import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Node root = new Node();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            Node now = root;
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (now.node[c - 'a'] == null) {
                    now.node[c - 'a'] = new Node();
                }
                now = now.node[c - 'a'];
                if (j == str.length() - 1) {
                    now.isEnd = true;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            Node now = root;
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (now.node[c - 'a'] == null) {
                    break;
                }
                now = now.node[c - 'a'];
                if (j == str.length() - 1 && now.isEnd == true) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}
class Node
{
    Node[] node = new Node[26];
    boolean isEnd;
}