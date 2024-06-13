
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder(str);

        int startIndex = 0;
        int cnt = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.') {
                if (cnt % 2 != 0) {  //불가능
                    System.out.println(-1);
                    System.exit(0);
                }
                else {  //cnt가 짝수
                    while (cnt != 0) {
                        if (cnt / 4 > 0) {
                            sb.replace(i - cnt, i - cnt + 4, "AAAA");
                            cnt = cnt - 4;
                        }
                        else if (cnt / 2 > 0) {
                            sb.replace(i - cnt, (i - cnt + 2), "BB");
                            cnt = cnt - 2;
                        }
                    }
                }
            } else if (str.charAt(i) == 'X') {
                //X를 만났을 때
                cnt++;
                if (i == str.length() - 1) {    //마지막 인덱스가 'X'
                    if (cnt % 2 == 0) {
                        while (cnt != 0) {
                            if (cnt / 4 > 0) {
                                sb.replace(Math.abs(cnt - i - 1), Math.abs(cnt - i - 1) + 4, "AAAA");
                                cnt = cnt - 4;
                            }
                            else if (cnt / 2 > 0) {
                                sb.replace(Math.abs(cnt - i - 1), (Math.abs(cnt - i - 1) + 2), "BB");
                                cnt = cnt - 2;
                            }
                        }
                    }
                    else {
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println(sb);

    }
}