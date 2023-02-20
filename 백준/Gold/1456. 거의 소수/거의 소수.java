import java.io.*;
import java.sql.Time;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long[] arr = new long[10000001];

        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = 2; i <= Math.sqrt(arr.length); i++)
        {
            if (arr[i] == 0) {
                continue;
            }
            for (int j = i + i; j < arr.length; j += i)
            {
                arr[j] = 0; //배수 지우기
            }
        }
        int count = 0;

        for (int k = 2; k < 10000001; k++) {
            if (arr[k] != 0)
            {
                long target = arr[k];

                while ((double)arr[k] <= (double)M/(double)target)
                {
                    if ((double)arr[k] >= (double)N/(double)target)
                    {
                        count++;
                    }
                    target = target * arr[k];
                }
            }

        }
        System.out.println(count);


    }


}

