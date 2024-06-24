
import java.io.*;
import java.util.*;

public class Main {
    static int N, K, B;
    static int[] buckets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //양동이 개수
        K = Integer.parseInt(st.nextToken());   //좌우로 K만큼 떨어짐
        buckets = new int[1_000_001];
        List<IcePos> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int ice = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());
            buckets[pos] = ice;
            list.add(new IcePos(ice, pos));
        }
        list.sort(new Comparator<IcePos>() {
            @Override
            public int compare(IcePos o1, IcePos o2) {
                return o1.pos - o2.pos;
            }
        });
        int maxPos = list.get(list.size() - 1).pos; //가장 마지막에 있는 위치
        int maxIce = 0;

        if (2 * K > 1_000_000) {
            for (int i = 0; i <= 1_000_000; i++) {
                maxIce += buckets[i];
            }
            int result = maxIce;

            for (int i = 1; i <= maxPos - 1_000_000; i++) {
                int end = i + 1_000_000;
                result -= buckets[i - 1];
                result += buckets[end];

                maxIce = Math.max(maxIce, result);
            }
        } else {
            for (int i = 0; i <= K + K; i++) {
                maxIce += buckets[i];
            }
            int result = maxIce;

            for (int i = 1; i <= maxPos - 2 * K; i++) {
                int end = i + 2 * K;
                result -= buckets[i - 1];
                result += buckets[end];

                maxIce = Math.max(maxIce, result);
            }
        }

        System.out.println(maxIce);

    }
}

class IcePos {
    int ice, pos;

    public IcePos(int ice, int pos) {
        this.ice = ice;
        this.pos = pos;
    }

}
