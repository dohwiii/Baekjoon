import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    //모든 자리수의 합
                    int o1Sum = 0, o2Sum = 0;
                    for (int i = 0; i < o1.length(); i++) {
                        if (Character.isDigit(o1.charAt(i))) {
                            o1Sum += o1.charAt(i) - '0';
                        }
                        if (Character.isDigit(o2.charAt(i))) {
                            o2Sum += o2.charAt(i) - '0';
                        }
                    }
                    if (o1Sum == o2Sum) {
                        //사전 순으로 비교
                        return o1.compareTo(o2);
                    }
                    return o1Sum - o2Sum;
                }
                return o1.length() - o2.length();
            }

        });
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s + "\n");
        }
        System.out.println(sb);

    }

    public static void solve() {

    }
}