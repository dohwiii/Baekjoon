import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(bf.readLine());
        int count = 0;

        while(n!=1)
        {
            if (n % 2 == 0)
            {
                n = n / 2;
                count++;
            }
            else
            {
                n = n + 1;
                count++;
            }
        }
        System.out.println(count);
    }
}
