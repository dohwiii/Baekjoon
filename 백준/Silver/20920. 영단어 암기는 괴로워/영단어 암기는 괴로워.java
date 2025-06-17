import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Dict implements Comparable<Dict> {
        String word;
        int cnt;

        public Dict(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Dict o) {
            if (this.cnt == o.cnt) {
                if (this.word.length() == o.word.length()) {
                    return this.word.compareTo(o.word);
                } else {
                    return o.word.length() - this.word.length();
                }
            }
            return o.cnt - this.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        int max = 0;

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            int len = word.length();
            if (len < M) {
                continue;
            }
            //M 이상
            map.put(word, map.getOrDefault(word, 0) + 1);
            max = Math.max(max, map.get(word));
        }

        StringBuilder sb = new StringBuilder();
        Dict[] arr = new Dict[map.size()];
        int index = 0;
        for (String key : map.keySet()) {
            arr[index++] = new Dict(key, map.get(key));
        }
        Arrays.sort(arr);
        for (int i = 0; i < index; i++) {
            sb.append(arr[i].word + "\n");
        }

        System.out.println(sb);

    }

}