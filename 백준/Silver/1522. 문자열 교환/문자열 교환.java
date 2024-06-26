import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int aCnt = 0;   //a의 개수
        int bCnt = 0;   //b의 개수
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a') {
                aCnt++;
            }
        }
        for (int i = 0; i < aCnt; i++) {
            if (input.charAt(i) == 'b') {
                bCnt++;
            }
        }
        int tempB = bCnt;
        String str = input + input;
        for (int i = 1; i < str.length() - aCnt + 1; i++) {
            int end = i + aCnt - 1;
            if (str.charAt(i - 1) == 'b') {
                tempB--;
            }
            if (str.charAt(end) == 'b') {
                tempB++;
            }
            bCnt = Math.min(bCnt, tempB);
        }
        System.out.println(bCnt);

    }
}