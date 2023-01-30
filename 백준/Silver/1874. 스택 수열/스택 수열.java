import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        boolean result = true;

        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }
        int num = 1;
        for (int i = 0; i < n; i++)
        {
            int su = arr[i];
            if (su >= num)
            {
                while (su >= num)
                {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }
            else
            {
                int pop = stack.pop();

                if (pop > su)
                {
                    System.out.println("NO");
                    result = false;
                    break;
                } else
                    sb.append("-\n");
            }
        }

        if (result)
        {
            System.out.println(sb.toString());
        }
    }

}

