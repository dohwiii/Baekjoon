import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] arr = str.toCharArray();
        int maxLen = 0;

        //팰린드롬이 아니라면
        if (!isPalindrome(arr, 0, arr.length - 1)) {
            System.out.println(arr.length);
            return;
        }
        //같은 문자라면
        boolean isSame = true;
        char c = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (c != arr[i]) {
                isSame = false;
            }
        }
        if (isSame) {
            System.out.println(-1);
            return;
        }
        //팰린드롬이지만 맨 앞/뒤 한글자 제거 -> 팰린드롬이 아니라면 길이 n-1
        if (!isPalindrome(arr, 1, arr.length - 1) || !isPalindrome(arr, 0, arr.length - 2)) {
            System.out.println(arr.length - 1);
        }


    }

    private static boolean isPalindrome(char[] arr, int s, int e) {
        while (s < e) {
            if (arr[s] != arr[e]) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}