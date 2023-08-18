import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static double[] moneys = {25, 10, 5, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int C = Integer.parseInt(br.readLine()); //거스름돈
            double dollar = C; //1달러는 100센트
            int[] remains = new int[moneys.length];

            for (int i = 0; i < moneys.length; i++) {
                if (dollar >= moneys[i]) {
                    remains[i] = (int) (dollar / moneys[i]);
                    dollar = dollar % moneys[i];
                }
            }
            System.out.println(remains[0] + " " + remains[1] + " " + remains[2] + " " + remains[3]);
        }


    }
}