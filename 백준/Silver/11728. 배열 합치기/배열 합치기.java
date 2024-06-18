
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(st.nextToken());   //배열 A 크기
        M = Integer.parseInt(st.nextToken());   //배열 B 크기

        A = new int[N];
        B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        int[] arr = new int[N + M];
        System.arraycopy(A, 0, arr, 0, A.length);
        System.arraycopy(B, 0, arr, A.length, B.length);
        Arrays.sort(arr);
        for (int i = 0; i < N + M; i++) {
            bw.write(arr[i] + " ");
        }
        bw.flush();
    }

}