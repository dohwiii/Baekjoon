import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());   //최대 K번 원소를 삭제할 수 있음
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int s = 0, e = 0;
        int deletedCnt = 0;
        int[] cnt = new int[1_000_001]; //등장 횟수
        int maxLen = 0;

        while (s < N && e < N) {
            if (arr[e] % 2 != 0) {  //홀수
                if (deletedCnt >= K) {    //더 삭제할 수 없음
                    if (arr[s] % 2 == 0) {
                        s++;
                    }
                    else {
                        cnt[arr[s]]--;
                        deletedCnt--;
                        s++;
                    }

                }
                else {  //삭제 가능
                    deletedCnt++;
                    cnt[arr[e]]++;
                    e++;
                }
            }
            else {  //짝수라면
                e++;
            }
            maxLen = Math.max(maxLen, e - s - deletedCnt);
        }

        System.out.println(maxLen);






    }
}