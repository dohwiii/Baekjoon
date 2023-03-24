
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K;
    static long[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //수의 개수
        M = Integer.parseInt(st.nextToken()); //변경이 일어나는 횟수
        K = Integer.parseInt(st.nextToken()); //구간의 합을 구하는 횟수
        int k = 1;
        while (Math.pow(2, k) < N) {
            k++;
        }
        int treeSize = (int) Math.pow(2, k) * 2;
        tree = new long[treeSize];
        int startIndex = (int) Math.pow(2, k);

        for (int i = startIndex; i < N + startIndex; i++) {

            tree[i] = Long.parseLong(br.readLine());
        }
        setTree(treeSize - 1);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1)
            {
                int index = (int) (b + (Math.pow(2, k) - 1));
                changeVal(index, c);
            }
            if (a == 2)
            {
                int start = (int) (b + (Math.pow(2, k) - 1));
                long end = (int) (c + (Math.pow(2, k) - 1));
                System.out.println(sumVal(start, (int)end));
            }
        }



    }

    public static void setTree(int index) {
        while (index != 1) {
            tree[index / 2] = tree[index / 2] + tree[index];
            index--;
        }
    }

    public static void changeVal(int index, long val) {
        long diff = val - tree[index]; //6-tree[10](3) = 3

        while (index > 0)
        {
            tree[index] = tree[index] + diff;
            index = index / 2;
        }
    }

    public static long sumVal(int s, int e)
    {
        long sum = 0;
        int start = s;
        int end = e;
        while (start <= end) {

            if (start % 2 == 1) {
                sum = sum + tree[start];
            }
            if (end % 2 == 0) {
                sum = sum + tree[end];
            }
            start = (start + 1) / 2;
            end = (end - 1) / 2;

        }
        return sum;
    }
}