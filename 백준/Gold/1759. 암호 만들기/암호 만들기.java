import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static char[] ans, ch;
    static boolean[] visited;
    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    static ArrayList<String> ansList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken()); //암호 길이
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ans = new char[L];
        ch = new char[C];
        visited = new boolean[C];

        for (int i = 0; i < C; i++) {
            ch[i] = st.nextToken().charAt(0); //암호 문자 종류
        }
        Arrays.sort(ch);
        combi(0, 0);
        Collections.sort(ansList);
        ArrayList<String> newList = new ArrayList<>();
        for (String str : ansList) {
            if (!newList.contains(str)) {
                newList.add(str);
            }
        }
        for (String str : newList) {
            System.out.println(str);
        }

    }

    public static void combi(int index, int depth) {
        if (depth == L) {
            int cnt = 0; //모음 개수
            int elseCnt = 0;
            for (int i = 0; i < L; i++) {
                if (ans[i] == 'a' || ans[i] == 'e' || ans[i] == 'i' || ans[i] == 'o' || ans[i] == 'u') {
                    cnt++;
                }
                else {
                    elseCnt++;
                }
            }
            if (cnt >= 1 && elseCnt >= 2) {
                String str = "";
                for (int i = 0; i < L; i++) {
                    str += ans[i];
                }
                ansList.add(str);
            }
            return;
        }
        for (int i = index; i < C; i++) {
            if (!visited[i]) {
                ans[depth] = ch[i];
                visited[i] = true;
                combi(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}