import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.Key;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());   //블랙
        int W = Integer.parseInt(st.nextToken());   //화이트
        char[] road = br.readLine().toCharArray();

        int bCnt = 0, wCnt = 0;
        int s = 0, e = 0;
        int maxLen = 0;
        while (s < N && e < N) {
            if (road[e] == 'B') {
                if (bCnt < B) { //아직 추가 가능
                    bCnt++;
                    e++;
                }
                else {
                    if (road[s] == 'W') {
                        wCnt--;
                    }
                    else {
                        bCnt--;
                    }
                    s++;
                }
            }
            else if (road[e] == 'W') {
                wCnt++;
                e++;
            }
            if (wCnt >= W && bCnt <= B) {
                maxLen = Math.max(maxLen, e - s);
            }
        }
        System.out.println(maxLen);


    }
}