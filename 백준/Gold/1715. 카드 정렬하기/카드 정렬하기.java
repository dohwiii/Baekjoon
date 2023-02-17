import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] card = new int[N];
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(br.readLine());
            queue.add(card[i]);
        }
        int sum1 = 0;

        while (queue.size() != 1)
        {

            int num1 = queue.poll();
            int num2 = queue.poll();
            sum1 = sum1 + num1 + num2;
            queue.add(num1 + num2);


        }
        System.out.println(sum1);


    }

}
