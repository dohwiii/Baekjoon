import java.util.*;

class Solution {
    static Set<List<Long>> intersection;
    static long xMin, xMax, yMin, yMax;
    public String[] solution(int[][] line) {
        intersection = new HashSet<>();
        xMin = Long.MAX_VALUE; yMin = Long.MAX_VALUE;
        xMax = Long.MIN_VALUE; yMax = Long.MIN_VALUE;

        for(int i=0; i<line.length-1; i++){
            for(int j=i+1; j<line.length; j++){
                getIntersection(line[i], line[j]);
            }
        }

        String[] answer = new String[(int) (yMax - yMin) + 1];
        for(int i=0; i<answer.length; i++){
            answer[i] = ".".repeat((int)(xMax - xMin) + 1);
        }

        for(List<Long> star : intersection){
            long x = star.get(0), y = star.get(1);
            answer[(int)(yMax-y)] = answer[(int)(yMax-y)].substring(0, (int)(x-xMin)) + "*" + answer[(int)(yMax-y)].substring((int)(x-xMin)+1);
        }

        return answer;
    }

    public void getIntersection(int[] line1, int[] line2){
        double A, B, C, D, E, F;
        A = line1[0]; B = line1[1]; E = line1[2];
        C = line2[0]; D = line2[1]; F = line2[2];

        double slope  = A*D - B*C;
        if(slope == 0)  return;    

        double x = (B*F - E*D) / slope, y = (E*C - A*F) / slope;
        long ix = (long) x, iy = (long) y;
        if(x == ix && y == iy){
            intersection.add((List<Long>)Arrays.asList(new Long[] {ix, iy}));
            xMin = Math.min(xMin, ix); xMax = Math.max(xMax, ix);
            yMin = Math.min(yMin, iy); yMax = Math.max(yMax, iy);
        }
        return;
    }
}