import java.io.*;
import java.sql.Time;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long num = gcd(N, M);

        while (num > 0) {
            bw.write("1");
            num--;
            
        }
        bw.flush();
        bw.close();
        
    }

    public static long gcd(long x, long y)
    {
        if (y == 0) {
            return x;
        }
        else
        {
            return gcd(y, x % y);
        }

    }

}

