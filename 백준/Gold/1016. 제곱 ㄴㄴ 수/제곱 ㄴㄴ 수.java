import java.io.*;
import java.sql.Time;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] check = new boolean[(int) (max - min + 1)];
        int count = 0;

        for (long i = 2; i * i <= max; i++) {
            
            long pow = i * i;
            long start_index = min / pow;
            if (min % pow != 0) {
                start_index++;
            }
            for (long j = start_index; j * pow <= max; j++) {
                check[(int) (j * pow - min)] = true;

            }


        }
        for (int i = 0; i < max - min + 1; i++)
        {
            if (!check[i]) {
                count++;
            }

        }




        System.out.println(count);





    }

}

