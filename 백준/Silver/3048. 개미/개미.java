import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String A;
    static String B;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ALength = Integer.parseInt(st.nextToken());
        int BLength = Integer.parseInt(st.nextToken());

        A = br.readLine();
        B = br.readLine();
        int T = Integer.parseInt(br.readLine()); //T초

        StringBuffer sbf = new StringBuffer(A);
        String reverse = sbf.reverse().toString();

        String str = reverse + B;
        StringBuilder sb = new StringBuilder(str);

        while (T-- > 0) {
            for (int i = 0; i < ALength + BLength - 1; i++) {
                char target1 = sb.charAt(i);
                char target2 = sb.charAt(i + 1);

                //연속으로 이어진 글자가 서로 반대방향이라면
                if (isContainA(target1) && isContainB(target2)) {
                    int target1Index = sb.indexOf(String.valueOf(target1));
                    int target2Index = sb.indexOf(String.valueOf(target2));

                    sb.setCharAt(target1Index, target2);
                    sb.setCharAt(target2Index, target1);
                    i++;
                }

            }

        }
        System.out.println(sb);

    }

    public static boolean isContainA(char target) {
        String targetStr = String.valueOf(target);
        if (A.contains(targetStr)) {
            return true;
        }
        return false;
    }

    public static boolean isContainB(char target) {
        String targetStr = String.valueOf(target);
        if (B.contains(targetStr)) {
            return true;
        }
        return false;
    }
}