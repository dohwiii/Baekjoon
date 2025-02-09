import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(1);
            return;
        } else if (N == 2) {
            System.out.println(2);
            return;
        }
        int val1 = 1;
        int val2 = 2;
        int sum = 0;

        for (int i = 3; i <= N; i++) {
            sum = (val1 + val2) % 15746;
            val1 = val2;
            val2 = sum;
        }
        System.out.println(sum);

    }

}
