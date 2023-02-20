import java.io.*;
import java.sql.Time;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[10000001];
        int count = 0;

        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(arr.length); i++)
        {
            if (arr[i] == 0) {
                continue;
            }
            for (int j = i + i; j < arr.length; j+=i)
            {
                arr[j] = 0;

            }

        }
        Arrays.sort(arr);

        for (int i = 2; i < 10000001; i++)
        {
            if (arr[i] >= N)
            {
                if (isPalindrome(arr[i])) {
                    System.out.println(arr[i]);
                    break;
                }

            }
        }

    }

    public static boolean isPalindrome(int x)
    {
        String str = String.valueOf(x);
        char[] charArray = str.toCharArray();
        int start = 0;
        int end = charArray.length - 1;

        while (start <= end)
        {
            if (charArray[start] != charArray[end]) {
                return false;
            }
            start++;
            end--;

        }
        return true;
    }

}

