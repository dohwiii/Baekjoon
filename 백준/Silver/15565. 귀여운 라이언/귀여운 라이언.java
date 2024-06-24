
import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] dolls;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dolls = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dolls[i] = Integer.parseInt(st.nextToken());
            if (dolls[i] == 1) {    //라이언
                list.add(i);    //라이언 인형의 인덱스를 저장

            }
        }
        System.out.println(solve());

    }
    public static int solve() {
        //list에는 0, 4, 6, 9 저장
        int size = 0;
        if (list.size() < K) {
            return -1;
        }
        size += list.get(K - 1) - list.get(0) + 1;

        for (int i = 1; i < list.size() - K + 1; i++) {
            int end = i + K - 1;
            size = Math.min(size, list.get(end) - list.get(i) + 1);
        }
        return size;
    }

}
