
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        int cup = 0, people = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'S') {
                if ((cup == 0 && people == 0)) {
                    cup += 2;
                    people++;
                }
                else {
                    cup++;
                    people++;
                }
            }
            else if (arr[i] == 'L') {
                if (cup == 0 && people == 0) {
                    cup += 2;
                    people += 2;
                }
                else {
                    if (cup >= people) {
                        cup++;
                        people += 2;
                    }
                    else {
                        cup++;
                        people += 2;
                    }
                }
                i++;
            }
        }

        System.out.println(Math.min(cup, people));


    }
}