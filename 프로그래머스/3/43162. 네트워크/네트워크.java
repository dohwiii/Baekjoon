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
            for(int j=0; j<n; j++) {
                if(i != j && computers[i][j] == 1) {  // 연결되어 있다면
                    union(i, j);
                }
            }
        }
        for(int i=0; i<n; i++) {
            parent[i] = find(i);
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            set.add(parent[i]);
        }
        
        return set.size();
    }
    private int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }
    private void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        
        if(pa != pb) {
            parent[pb] = pa;
        }

    }
}
