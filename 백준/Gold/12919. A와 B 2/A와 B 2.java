import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static boolean possible = false;
    static String S, T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        solve(T);
        System.out.println(possible ? 1 : 0);
    }

    public static void solve(String str) {
        if (str.length() == S.length()) {
            if (str.equals(S)) {
                possible = true;
            }
            return;
        }

        if (str.charAt(str.length() - 1) == 'A') {  //맨 뒤가 A라면
            solve(str.substring(0, str.length() - 1));
        }
        if (str.charAt(0) == 'B') { //맨 앞이 B라면
            StringBuilder temp = new StringBuilder(str).reverse();
            solve((temp.substring(0, temp.length() - 1)));
        }


    }

}