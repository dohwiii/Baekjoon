import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());    //게임 진행 횟수

        for (int t = 0; t < T; t++) {
            char[] word = br.readLine().toCharArray();
            int K = Integer.parseInt(br.readLine());
            
            int[] cntArr = new int[26]; //알파벳 빈도 체크배열
            int[] prevK = new int[26];
            int[] next = new int[word.length];
            int[] prev = new int[26];
            int max = -1;
            int min = Integer.MAX_VALUE;

            if (K == 1) {
                bw.write("1 1\n");
                continue;
            }

            for (int i = 0; i < word.length; i++) {
                int index = word[i] - 'a';
                cntArr[index]++;

                if (cntArr[index] == 1) {   //처음 나오는 알파벳
                    prevK[index] = i;
                } else if (cntArr[index] >= 2) {
                    next[prev[index]] = i;  //지금 알파벳의 이전 위치의 인덱스 값 현재로 갱신
                }
                prev[index] = i;    //현재 위치로 갱신

                //K개를 포함한다면
                if (cntArr[index] == K) {
                    max = Math.max(max, i - prevK[index] + 1);
                    min = Math.min(min, i - prevK[index] + 1);
                }
                else if (cntArr[index] > K) {
                    prevK[index] = next[prevK[index]];
                    max = Math.max(max, i - prevK[index] + 1);
                    min = Math.min(min, i - prevK[index] + 1);
                }
            }
            if (max == -1 || min == Integer.MAX_VALUE) {
                bw.write("-1");
                bw.write("\n");
                continue;
            }
            bw.write(min + " " + max);
            bw.write("\n");

        }

        bw.flush();

    }
}