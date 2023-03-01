
import javax.xml.crypto.Data;
import java.io.*;
import java.util.*;

public class Main
{
    static ArrayList<Integer> list;
    static HashSet<Integer> set;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        DFS(A, P); //DFS(74);

    }

    public static int Multiple(int num, int P)
    {
        double sum = 0;

        while (num != 0)
        {
            sum = sum + Math.pow(num % 10, P);
            num = num / 10;
        }

        return (int)sum;
    }

    public static void DFS(int num, int P)
    {
        if (list.contains(num))
        {
            System.out.println(list.indexOf(num));
            return;
        }
        list.add(num);
        DFS(Multiple(num, P), P);
    }
}

