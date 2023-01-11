import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); //횟수

        for (int i = 0; i < n; i++)
        {
            String str = bf.readLine(); //문자열 입력

            if (str.length() >= 6 && str.length() <= 9)
            {
                System.out.println("yes");
            }
            else
                System.out.println("no");
        }
    }
}
