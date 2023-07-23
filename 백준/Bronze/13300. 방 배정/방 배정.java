import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int room = 0;
        int[][] student = new int[7][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());//성별
            int Y = Integer.parseInt(st.nextToken()); //학년

            student[Y][S]++;
        }
        for (int j = 1; j < 7; j++) {
            for (int k = 0; k < 2; k++) {
                if (student[j][k] != 0) {
                    if (student[j][k] % K == 0) {
                        room += student[j][k] / K;
                    }
                    else {
                        room += student[j][k] / K + 1;
                    }
                }
            }
        }
        System.out.println(room);

    }
}