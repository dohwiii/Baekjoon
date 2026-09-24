import java.util.*;
import java.io.*;

class Solution {
    // 컴퓨터는 0 ~ n-1
    static int[] parent;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        parent = new int[n];
        
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(computers[i][j] == 1) {  // 연결되어 있다면
                    if(union(i, j)) {
                        answer++;
                    }
                }
            }
        }

        return n - answer;
    }
    private int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }
    private boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        
        if(pa != pb) {
            parent[pb] = pa;
            return true;
        }
        return false;

    }
}
