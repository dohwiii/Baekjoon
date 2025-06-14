import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class TrieNode {
        TrieNode[] children = new TrieNode[10]; //0~9
        boolean isEnd = false;
    }

    static boolean insert(TrieNode root, String number) {
        TrieNode curr = root;
        for (char ch : number.toCharArray()) {
            int idx = ch - '0';
            if (curr.isEnd) {
                return false;
            }
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;

        for (TrieNode child : curr.children) {
            if (child != null) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] numbers = new String[N];

            for (int i = 0; i < N; i++) {
                numbers[i] = br.readLine();
            }

            TrieNode root = new TrieNode();
            boolean isConsistent = true;
            for (String num : numbers) {
                if (!insert(root, num)) {
                    isConsistent = false;
                    break;
                }
            }

            sb.append(isConsistent ? "YES\n" : "NO\n");


        }
        System.out.println(sb);

    }

}