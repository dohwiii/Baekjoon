import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        for (int i = 0; i < N - 1; i++) {

            while (queue.size() > 1)
            {
                queue.remove();
                queue.add(queue.poll());

            }
        }
        System.out.println(queue.peek());




    }
}
