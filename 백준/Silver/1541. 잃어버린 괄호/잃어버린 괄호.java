import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = br.readLine();
        String[] strSplit = str.split("-");
        ArrayList<Integer> list = new ArrayList<>();
        
        for (String s : strSplit) {
            String[] plusSplit = s.split("\\+");
            int sum = 0;
            if (plusSplit.length > 0) {
                for (String s2 : plusSplit) {
                    int x = Integer.parseInt(s2);
                    sum += x;
                }
            }
            else
                sum = Integer.parseInt(s);
            list.add(sum);
        }
        int result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            result -= list.get(i);
        }
        System.out.println(result);
    }
}