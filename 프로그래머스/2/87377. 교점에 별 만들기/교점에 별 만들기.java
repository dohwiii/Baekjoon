import java.util.*;

class Solution {
    static Set<Pos> set = new HashSet<>();
    
    public String[] solution(int[][] line) {
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        for(int i=0; i<line.length - 1; i++) {
            int[] standard = line[i];
            for(int j=i+1; j<line.length; j++) {
                int[] compare = line[j];
                findIntersection(standard[0], standard[1], standard[2], compare[0], compare[1], compare[2]);
            }
        }
        for(Pos now : set) {
            minX = Math.min(minX, now.x);   //가장 작은 X
            maxX = Math.max(maxX, now.x);
            minY = Math.min(minY, now.y);
            maxY = Math.max(maxY, now.y);   //가장 큰 Y
        }
        int width = maxX - minX + 1;
        int height = maxY - minY + 1;
        char[][] map = new char[height][width];
        for(char[] row : map) {
            Arrays.fill(row, '.');
        }
        String[] answer = new String[height];
        
        for(Pos p : set) {
            int x = p.x - minX;
            int y = maxY - p.y;
            map[y][x] = '*';
        }
        for (int i = 0; i < height; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < width; j++) {
                sb.append(map[i][j]);
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
    public void findIntersection(int a1, int b1, int c1, int a2, int b2, int c2) {
        long denominator = (long) a1 * b2 - (long) b1 * a2; //분모
        
        if(denominator == 0) {  //평행
            return;
        }
        
        long xNumerator = (long) b1 * c2 - (long) c1 * b2;
        long yNumerator = (long) c1 * a2 - (long) a1 * c2;
        
        //정수 여부
        if(xNumerator % denominator == 0 && yNumerator % denominator == 0) {
            int x = (int) (xNumerator / denominator);
            int y = (int) (yNumerator / denominator);
            set.add(new Pos(x, y));
        }
    }
    static class Pos {
        int x, y;
        public Pos(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
}