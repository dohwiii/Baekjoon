import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] trees;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine()); //나무 개수
        trees = new int[N];
        boolean isPossible = true;
        int sum = 0;
        int even = 0;
        int odd = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken()); //나무 도달해야하는 높이
            sum += trees[i]; //총합
            even += trees[i] / 2;
            odd += trees[i] % 2;
        }
        if (sum % 3 != 0 || even < odd) {
            isPossible = false;
        }
        if (isPossible) {
            sb.append("YES");
        }else {
            sb.append("NO");
        }

        System.out.println(sb);

    }
}
