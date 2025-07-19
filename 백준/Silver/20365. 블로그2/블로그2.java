import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        char[] arr = str.toCharArray();
        char prev = arr[0];
        int red = 0, blue = 0;
        if (prev == 'R') {
            red = 1;
        }
        else {
            blue = 1;
        }

        for (int i = 1; i < N; i++) {
            if (prev != arr[i]) {   //이전과 색이 다르다면
                if (arr[i] == 'R') {
                    red++;
                }
                else {
                    blue++;
                }
                prev = arr[i];
            }

        }
        int paint = 1;
        if (red >= blue) {
            paint += blue;
        }
        else {
            paint += red;
        }
        System.out.println(paint);
    }
}