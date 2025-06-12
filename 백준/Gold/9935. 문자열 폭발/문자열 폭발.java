import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        int bombLen = bomb.length();
        char[] bombArr = bomb.toCharArray();

        // 문자들을 차례로 쌓는 스택 역할
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            sb.append(c);

            // 스택 끝에서 폭발 문자열과 비교
            if (sb.length() >= bombLen) {
                boolean isMatch = true;
                for (int i = 0; i < bombLen; i++) {
                    if (sb.charAt(sb.length() - bombLen + i) != bombArr[i]) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) {
                    sb.delete(sb.length() - bombLen, sb.length());
                }
            }
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}