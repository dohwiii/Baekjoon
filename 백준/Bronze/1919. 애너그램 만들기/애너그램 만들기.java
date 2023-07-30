import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int diff = 0;
        int same = 0;
        boolean[] visited = new boolean[str2.length()];

        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            boolean isSame = false;

            for (int j = 0; j < str2.length(); j++) {
                char c2 = str2.charAt(j);
                if ((c1 == c2) && !visited[j])
                {
                    isSame = true;
                    visited[j] = true;
                    same++;
                    break;
                }
            }
            if (!isSame) {
                diff++;
            }
        }
        System.out.println(diff + (str2.length() - same));
    }
}