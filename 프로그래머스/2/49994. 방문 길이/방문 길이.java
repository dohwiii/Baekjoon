import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
        Set<String> visited = new HashSet<>();
        int x = 0, y = 0;
        
        for (char dir : dirs.toCharArray()) {
            int nx = x, ny = y;
            
            switch (dir) {
                case 'U': ny++; break;
                case 'D': ny--; break;
                case 'R': nx++; break;
                case 'L': nx--; break;
            }
            
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;
            
            // 배열을 문자열로 변환하여 경로 저장
            String path1 = Arrays.toString(new int[]{x, y, nx, ny});
            String path2 = Arrays.toString(new int[]{nx, ny, x, y});
            
            if (!visited.contains(path1) && !visited.contains(path2)) {
                visited.add(path1);
                visited.add(path2);
            }
            
            x = nx;
            y = ny;
        }
        
        return visited.size() / 2;
    }
}
