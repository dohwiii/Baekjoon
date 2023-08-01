
import java.io.*;
import java.util.*;

public class Main {

    static int[] switchArr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        switchArr = new int[N];
        for (int i = 0; i < N; i++) {
            switchArr[i] = Integer.parseInt(st.nextToken());
        }
        int student = Integer.parseInt(br.readLine());
        for (int i = 0; i < student; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            turnSwitch(gender, number);
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i : switchArr) {
            sb.append(i + " ");
            cnt++;
            if (cnt % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());

    }

    public static void turnSwitch(int gender, int number) {
        //남자
        if (gender == 1) {
            for (int i = 0; i < switchArr.length; i++) {
                int switchNum = i + 1;
                if (switchNum % number == 0) {
                    if (switchArr[i] == 0) {
                        switchArr[i] = 1;
                    } else if (switchArr[i] == 1) {
                        switchArr[i] = 0;
                    }
                }
            }
        }
        //여자
        if (gender == 2) {
            int num = number - 1;
            int near = 0;

            while (num - near >= 0 && num + near < switchArr.length) {
                if (switchArr[num - near] == switchArr[num + near]) {
                    if (switchArr[num - near] == 0) {
                        switchArr[num - near] = 1;
                        switchArr[num + near] = 1;
                    } else if (switchArr[num - near] == 1) {
                        switchArr[num - near] = 0;
                        switchArr[num + near] = 0;
                    }
                    near++;
                }
                else
                    break;
            }

        }
    }

}