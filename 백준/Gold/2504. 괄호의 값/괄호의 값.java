import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int cnt = 1;
        boolean isPossible = true;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
                cnt *= 2;
            }
            else if (str.charAt(i) == '[') {
                stack.push('[');
                cnt *= 3;
            }
            else
            {
                if (str.charAt(i) == ')') {
                    //스택이 비었거나 이전에 '('이 아니라면
                    if (stack.isEmpty() || stack.peek() != '(') {
                        isPossible = false;
                        break;
                    }
                    if (str.charAt(i - 1) == '(') {
                        result += cnt;
                    }
                    stack.pop();
                    cnt = cnt / 2;
                }
                else if (str.charAt(i) == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        isPossible = false;
                        break;
                    }
                    if (str.charAt(i - 1) == '[')
                    {
                        result += cnt;
                    }
                    stack.pop();
                    cnt = cnt / 3;
                }
                else
                {
                    isPossible = false;
                    break;
                }
            }
        }
        if (!isPossible || !stack.isEmpty()) {
            System.out.println(0);
        }
        else {
            System.out.println(result);
        }

    }
}