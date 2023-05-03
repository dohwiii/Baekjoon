import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine()); //시험장 개수
        long[] applicants = new long[(int)N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            applicants[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        long sum = 0;
        for (int i = 0; i < N; i++) {
            long students = applicants[i];

            //총감독관 1명으로 감당가능
            if (students - B <= 0)
            {
                sum += 1;
            }
            //총감독관과 부감독관 있어야함
            else if (students - B > 0) {
                long remainders = students - B;
                //부감독관 1명으로 감당가능 => 총감독 1명 + 부감독 1명
                if (C >= remainders) {
                    sum += 2;
                }
                //부감독관 1명으로 감당 불가능
                else if (C < remainders)
                {
                    if (remainders % C == 0) {
                        sum += remainders / C + 1;

                    }
                    else if (remainders % C != 0) {
                        sum += remainders / C + 1 + 1;

                    }
                }
            }
        }
        System.out.println(sum);
    }
}
