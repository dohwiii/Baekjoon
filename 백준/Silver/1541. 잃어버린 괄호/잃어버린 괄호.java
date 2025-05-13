import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        long result = 0;
        String[] minusSplit = str.split("-");
        String[] first = minusSplit[0].split("\\+");
        for (String s : first) {
            result += Integer.parseInt(s);
        }

        for (int i = 1; i < minusSplit.length; i++) {
            String[] plus = minusSplit[i].split("\\+");
            int sum = 0;
            for (String num : plus) {
                sum += Integer.parseInt(num);
            }
            result -= sum;
        }
        System.out.println(result);


    }
}