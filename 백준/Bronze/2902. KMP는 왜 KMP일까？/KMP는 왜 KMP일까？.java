import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] arr = input.split("-");
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s.charAt(0));
        }
        System.out.println(sb);

    }

}