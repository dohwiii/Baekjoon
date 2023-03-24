
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[26][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = st.nextToken().charAt(0) - 'A';
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (left == '.') {
                arr[node][0] = -1;
            }
            else
                arr[node][0] = left - 'A';

            if (right == '.') {
                arr[node][1] = -1;
            }
            else
                arr[node][1] = right - 'A';
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 2; j++) {

            }
        }
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);

    }
    public static void preOrder(int now) {
        if (now == -1) {
            return;
        }
        System.out.print((char)(now + 'A'));
        preOrder(arr[now][0]);
        preOrder(arr[now][1]);
    }
    public static void inOrder(int now) {
        if (now == -1) {
            return;
        }
        inOrder(arr[now][0]);
        System.out.print((char)(now + 'A'));
        inOrder(arr[now][1]);
    }
    public static void postOrder(int now) {
        if (now == -1) {
            return;
        }
        postOrder(arr[now][0]);
        postOrder(arr[now][1]);
        System.out.print((char)(now + 'A'));
    }
}