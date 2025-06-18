import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str.equals("end")) {
                break;
            }
            boolean isVowel = false;    //조건 1 모음 하나 반드시 포함
            boolean isNotPossible = false;
            int consonant = 0, vowel = 0;
            char[] arr = str.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                    isVowel = true;
                    vowel++;
                    consonant = 0;  // 초기화
                }
                else {  // 모음
                    consonant++;
                    vowel = 0;  // 초기화
                }
                if (consonant >= 3 || vowel >= 3) { //조건 2
                    isNotPossible = true;
                    break;
                }
                if (i < arr.length - 1) {   //마지막 인덱스 제외
                    if (arr[i] != 'e' && arr[i] != 'o') {
                        if (arr[i] == arr[i + 1]) {
                            isNotPossible = true;
                            break;
                        }
                    }
                }

            }
            sb.append("<" + str + ">");
            if (!isVowel || isNotPossible) {    //안됨
                sb.append(" is not acceptable.\n");
            }
            else {
                sb.append(" is acceptable.\n");
            }

        }
        System.out.println(sb);
    }
}