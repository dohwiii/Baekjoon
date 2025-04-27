import java.io.*;
import java.security.Key;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        char[] arr = str.toCharArray();

        int len = arr.length;
        int maxLen = 0;
        int s = 0, e = 0;
        int[] freq = new int[27];
        int distinct = 0;

        while (s < len && e < len) {
            int ch = arr[e] - 'a';
            if (freq[ch] == 0) {    //아직 추가하지 않은 알파벳
                if (distinct < N) { //추가 횟수 남아있음
                    freq[ch]++;
                    distinct++;
                    e++;
                }
                else {  //추가 못함
                    freq[arr[s] - 'a']--;
                    if (freq[arr[s] - 'a'] == 0) {  //시작 알파벳 문장에서 싹 빠졌다면
                        distinct--;
                    }
                    s++;

                }
            }
            else {  //이미 추가한 알파벳
                freq[ch]++;
                e++;
            }
            maxLen = Math.max(maxLen, e - s);

        }
        System.out.println(maxLen);


    }

}
