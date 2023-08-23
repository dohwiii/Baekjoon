import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //사람의 수
        ATM[] arr = new ATM[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = new ATM(i, Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 1; i < N; i++) {
            arr[i].time = arr[i].time + arr[i - 1].time;
        }
        for (int i = 0; i < N; i++) {
            sum += arr[i].time;
        }
        System.out.println(sum);

    }
}
class ATM implements Comparable<ATM>
{
    int num, time;

    public ATM(int num, int time) {
        this.num = num;
        this.time = time;
    }

    @Override
    public int compareTo(ATM o) {
        return this.time - o.time;
    }
}
