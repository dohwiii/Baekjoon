import java.io.*;
import java.sql.Time;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int result = x * y / gcd(x, y);
            System.out.println(result);
        }





    }

    public static int gcd(int x, int y)
    {
        int a = x;
        int b = y;

        while (!(b % a == 0))
        {
            int result = b % a;
            b = a;
            a = result;


        }
        return a;

    }

}

