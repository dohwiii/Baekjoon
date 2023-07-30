import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '<') { //왼쪽 이동
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                }
                else if (str.charAt(j) == '>') { //오른쪽 이동
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                }
                else if (str.charAt(j) == '-') { //백스페이스
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                }
                else { //문자
                    left.push(str.charAt(j));
                }
            }
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
            while (!right.isEmpty()) {
                bw.write(right.pop());
            }
            bw.flush();
            System.out.println();
        }

    }
}