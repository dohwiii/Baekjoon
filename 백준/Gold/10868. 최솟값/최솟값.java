
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static long[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //노드의 개수
        M = Integer.parseInt(st.nextToken()); //질의 개수
        int k = 1;
        while ((int) Math.pow(2, k) < N) {
            k++;
        }
        int treeSize = (int) Math.pow(2, (k + 1));
        tree = new long[treeSize]; //32
        int leftNodeStartIndex = treeSize / 2 - 1; //15

        for (int i = 0; i < tree.length; i++) {
            tree[i] = Integer.MAX_VALUE;
        }
        for (int i = leftNodeStartIndex+1; i <= leftNodeStartIndex + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }
        setTree(tree.length - 1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            s = s + leftNodeStartIndex;
            e = e + leftNodeStartIndex;
            System.out.println(getMin(s, e));

        }
        br.close();

    }

    public static long getMin(int s, int e)
    {
        long min = Long.MAX_VALUE;

        while (s <= e) {
            if (s % 2 == 1) {
                min = Math.min(min, tree[s]);
            }

            if (e % 2 == 0) {
                min = Math.min(min, tree[e]);
            }
            s = (s + 1) / 2;
            e = (e - 1) / 2;

        }
        return min;

    }
    public static void setTree(int index) {
        while (index != 1) {
            tree[index / 2] = Math.min(tree[index / 2], tree[index]);
            index--;
        }
    }
}