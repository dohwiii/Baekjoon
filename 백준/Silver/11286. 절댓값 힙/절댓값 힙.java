import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                int o1_abs = Math.abs(o1);
                int o2_abs = Math.abs(o2);

                if (o1_abs == o2_abs) { //o1 o2 같다면 음수값 우선 정렬
                    return o1 > o2 ? 1 : -1;
                }
                else
                {
                    return o1_abs - o2_abs;
                }
            }
        });

        for (int i = 0; i < N; i++)
        {
            int x = arr[i];

            if (x != 0)
            {
                heap.add(x);
            }
            else
            {
                if (!heap.isEmpty()) {
                    bw.write(heap.poll()+"\n");
                }
                else
                {
                    bw.write("0\n");
                }

            }


        }
        bw.flush();
        bw.close();

    }
}
