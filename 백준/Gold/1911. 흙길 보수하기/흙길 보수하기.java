import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, L;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());   //널빤지 길이
        int[][] puddles = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            puddles[i][0] = Integer.parseInt(st.nextToken());
            puddles[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(puddles, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int lastPos = -1;    //널빤지의 마지막 위치
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            int[] temp = puddles[i];
            if (lastPos < temp[0]) {    //새로운 널빤지 설치
                int len = temp[1] - temp[0];    //길이
                int need = (int) Math.ceil(len / (double) L);    //필요한 널빤지 개수
                lastPos = temp[0] + L * need - 1;
                cnt += need;
            } else if (lastPos < temp[1] - 1) {  //전 웅덩이에 설치한 널빤지를 사용할 수 있음
                int len = temp[1] - (lastPos + 1);
//                int need = (int) Math.ceil(len / L);    //필요한 널빤지 개수
                int need = (len + L - 1) / L;
                lastPos = lastPos + L * need;
                cnt += need;
            }

        }
        System.out.println(cnt);

    }

}