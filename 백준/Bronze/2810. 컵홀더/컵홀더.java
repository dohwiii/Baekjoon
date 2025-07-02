import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] seats = br.readLine().toCharArray();

        int cupHolder = 1;
        int index = 0;
        while (index < N) {
            char curr = seats[index];

            if (curr == 'L') {  //커플석
                index += 2;
                cupHolder++;
            }
            else {  //싱글석
                index++;
                cupHolder++;
            }
        }
        System.out.println(Math.min(N, cupHolder));
    }
}