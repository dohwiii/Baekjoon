import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //학생 수
        int K = Integer.parseInt(st.nextToken());   //등수 차이
        int[] len = new int[N];
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            len[i] = name.length();
        }

        long friends = 0;

        for (int i = 0; i <= K; i++) {
            if (hm.containsKey(len[i])) {
                hm.put(len[i], hm.get(len[i]) + 1);
            } else {
                hm.put(len[i], 1);
            }
        }
        int l = 0;
        int r = K + 1;

        while (l < N) {
            if (hm.get(len[l]) > 1) {
                friends += hm.get(len[l]) - 1;
            }
            if (r < N) {
                if (hm.containsKey(len[r])) {
                    hm.put(len[r], hm.get(len[r]) + 1);
                } else {
                    hm.put(len[r], 1);
                }
                r++;
            }
            hm.put(len[l], hm.get(len[l]) - 1);
            l++;
        }


        System.out.println(friends);
    }
}