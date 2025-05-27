import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Gift implements Comparable<Gift> {
        int price, satis;

        public Gift(int price, int satis) {
            this.price = price;
            this.satis = satis;
        }

        @Override
        public int compareTo(Gift g) {
            return this.price - g.price;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        Gift[] arr = new Gift[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            //가격, 만족도
            int p = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            arr[i] = new Gift(p, s);
        }
        Arrays.sort(arr);   //가격 기준으로 오름차순 정렬
        int s = 0, e = 0;
        long maxV = 0;
        long satisfaction = 0;

        while (s < N && e < N) {
            if (arr[e].price - arr[s].price < D) {
                satisfaction += arr[e].satis;
                e++;
            }
            else if (arr[e].price - arr[s].price >= D) {
                satisfaction -= arr[s].satis;
                s++;
            }
            maxV = Math.max(maxV, satisfaction);
        }
        System.out.println(maxV);


    }
}