import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n0 = 0;
        List<Integer> n0list = new ArrayList();

        while(true)
        {
            n0 = sc.nextInt();
            if (n0 == 0)
                break;

            n0list.add(n0);
        }
        int n0arrSize = n0list.size();
        int[] n0arr = new int[n0arrSize];
        for (int i = 0; i < n0arrSize; i++) { //List -> arr

            n0arr[i] = n0list.get(i).intValue();
        }
        String[] s = new String[n0arrSize];
        int[] n4 = new int[n0arrSize];

        for (int i = 0; i < n0arrSize; i++)
        {
            int n1 = 3 * n0arr[i];
            int n2 = 0;

            if(n1%2==0)
                s[i] = "even";
            else
                s[i] = "odd";

            if(n1%2==0) //짝수
            {
                n2= n1/2;
            }
            else //홀수
                n2 = (n1 + 1) / 2;

            int n3 = 3 * n2;
            n4[i] = n3 / 9;
        }

        for (int i = 0; i < n0arrSize; i++) {
            System.out.println(i + 1 + ". " + s[i] + " " + n4[i]);
        }
    }
}
