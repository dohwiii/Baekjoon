import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder str = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        char[] arr = new char[N];
        char[] arrT = new char[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().charAt(0);
            str.append(arr[i]);
        }
        int s = 0, e = N - 1;

        while (s <= e) {
            char A = arr[s];
            char B = arr[e];

            if (A == B) {   //같을 때
                int left = s, right = e;
                boolean takeLeft = false;
                while (arr[left] == arr[right] && left < right) {
                    left++;
                    right--;
                }
                if (left >= right) {
                    takeLeft = true;
                } else {
                    takeLeft = (arr[left] < arr[right]);
                }
                if (takeLeft) { //왼쪽부터
                    sb.append(arr[s++]);
                } else {
                    sb.append(arr[e--]);
                }

            } else if (A < B) {    //B가 사전순 더 뒤
                sb.append(A);
                s++;
            } else {  //A가 더 후순위
                sb.append(B);
                e--;
            }
        }

        for (int i = 0; i < sb.length(); i++) {
            System.out.print(sb.charAt(i));
            if ((i + 1) % 80 == 0 || i == sb.length() - 1) {
                System.out.println();
            }
        }
    }
}