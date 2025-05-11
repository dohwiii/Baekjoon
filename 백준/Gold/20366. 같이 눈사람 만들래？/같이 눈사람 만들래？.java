import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static class Pair {
        long sum;
        int i, j;

        public Pair(long sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int M = N * (N - 1) / 2;    //2개씩 뽑을 때 나올 수 있는 조합 개수
        Pair[] pairSum = new Pair[M];
        long[] sumArr = new long[M];
        int index = 0;
        //합 쌍 구하기
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                pairSum[index++] = new Pair(arr[i] + arr[j], i, j);
            }
        }
        //sum 기준으로 오름차순
        Arrays.sort(pairSum, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Long.compare(o1.sum, o2.sum);
            }
        });

        for (int i = 0; i < M; i++) {
            sumArr[i] = pairSum[i].sum;
        }
        long minDiff = 1_000_000_000;

        for (int i = 0; i < M; i++) {
            Pair p = pairSum[i];

            for (int j = i + 1; j < M; j++) {
                Pair q = pairSum[j];
                if (p.i == q.i || p.i == q.j || p.j == q.i || p.j == q.j) {
                    continue;
                }
                long result = Math.abs(p.sum - q.sum);
                minDiff = Math.min(minDiff, result);
                break;
            }
        }

        System.out.println(minDiff);


    }
}