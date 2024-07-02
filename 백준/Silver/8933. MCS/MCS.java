import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static char[] W;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = st.nextToken().toCharArray();
            int answer = findMaxMCS();
            System.gc();
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }

    public static int findMaxMCS(){
        HashMap<Long, Integer> mcs = new HashMap<>();
        int[] count = new int[4];
        for(int i = 0; i < N; i++){
            if(W[i] == 'A') count[0]++;
            else if(W[i] == 'T') count[1]++;
            else if(W[i] == 'G') count[2]++;
            else if(W[i] == 'C') count[3]++;
        }
        long hash = hashCalculate(count);
        mcs.put(hash, 1);

        for(int i = 1; i < W.length-N+1; i++){
            int idx = 0;
            if(W[i-1] == 'A') idx = 0;
            else if(W[i-1] == 'T') idx = 1;
            else if(W[i-1] == 'G') idx = 2;
            else if(W[i-1] == 'C') idx = 3;
            count[idx]--;

            if(W[i+N-1] == 'A') count[0]++;
            else if(W[i+N-1] == 'T') count[1]++;
            else if(W[i+N-1] == 'G') count[2]++;
            else if(W[i+N-1] == 'C') count[3]++;

            hash = hashCalculate(count);
            mcs.put(hash, mcs.getOrDefault(hash, 0)+1);
        }

        int max = Integer.MIN_VALUE;
        for (Integer value : mcs.values()) max = Math.max(max, value);
        return max;
    }

    static long hashCalculate(int[] count){
        long hash = 0;
        hash += 601*601*601*count[0];
        hash += 601*601*count[1];
        hash += 601*count[2];
        hash += count[3];
        return hash;
    }
}