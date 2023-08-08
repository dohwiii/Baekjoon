import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') {
                stack.push(c);
            }
            else if (c == ')') {
                stack.pop();
                if (str.charAt(i - 1) == '(') { //바로 앞에 열린 괄호가 있다면 그동안 쌓인 ( 개수 카운트
                    result += stack.size();
                }
                else { //바로 앞 괄호가 ')'라면 하나의 쇠막대기가 끝난 것
                    result += 1;
                }
            }
        }
        System.out.println(result);
    }
}