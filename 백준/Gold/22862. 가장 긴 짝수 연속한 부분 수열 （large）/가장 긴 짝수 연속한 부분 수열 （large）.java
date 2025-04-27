import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int maxLen = 0;
        int kCnt = 0;
        int s = 0, e = 0;
        while (s < N && e < N) {
            if (arr[e] % 2 != 0) {  //홀수라면
                if (kCnt < K) {
                    e++;
                    kCnt++;
                } else {  //K 횟수 다씀
                    if (arr[s] % 2 != 0) {  //시작점이 홀수라면
                        kCnt--;
                    }
                    s++;
                }
            } else {    //짝수라면
                e++;
            }
            maxLen = Math.max(maxLen, e - s - kCnt);
        }
        System.out.println(maxLen);


    }

}
