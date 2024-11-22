import java.util.*;

class Solution {
    static int N;
    static boolean[] visited;
    static boolean[] visitedNum;
    static Map<String, ArrayList<Integer>> map = new HashMap<>();
    
    public int[] solution(int[][] dice) {
        N = dice.length;    //주사위 개수
        int[] answer = new int[(int)N/2];
        visited = new boolean[N+1];
        visitedNum = new boolean[N+1];
        int[] current = new int[(int) N/2];
        
        ArrayList<int[]> combinations = new ArrayList<>();
        combi(1, 0, dice, current, combinations);
        double maxRate = 0.0;
        
        for(int[] A : combinations) {
            int[] B = new int[(int) N/2];
            int index = 0;
            boolean[] used = new boolean[N+1];
            for(int a : A) {
                used[a] = true;
            }
            for(int i=1; i<=N; i++) {
                if(!used[i]) {
                    B[index++] = i;
                }
            }
            // System.out.println(Arrays.toString(A));
            // System.out.println(Arrays.toString(B));
            // System.out.println();
            List<Integer> aSums = calculateAllSum(A, dice);
            List<Integer> bSums = calculateAllSum(B, dice);
            
            double winRate = calculateWinRate(aSums, bSums);
            if(winRate > maxRate) {
                maxRate = winRate;
                answer = A;
            }
        }
        
        return answer;
    }
    public void combi(int start, int depth, int[][] dice, int[] current, ArrayList<int[]> combinations) {
        if(depth == N/2) {
            combinations.add(current.clone());
            return;
        }
        for(int i=start; i<=N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                current[depth] = i; 
                combi(i + 1, depth + 1, dice, current, combinations);
                visited[i] = false;
            }
        }
    }
    public List<Integer> calculateAllSum(int[] arr, int[][] dice) {
        List<Integer> sums = new ArrayList<>();
        calculateSums(0, 0, dice, arr, sums);
        Collections.sort(sums);
        return sums;
    }
    public double calculateWinRate(List<Integer> aSums, List<Integer> bSums) {
        int totalCase = aSums.size() * bSums.size();
        int winCases = 0;
        
        for(int bSum : bSums) {
            int index = findFirstGreater(aSums, bSum);
            winCases += aSums.size() - index;
        }
        return (double) winCases / totalCase;
    }
    public int findFirstGreater(List<Integer> sortedList, int value) {
        int left = 0, right = sortedList.size();
        
        while(left < right) {
            int mid = (left + right) / 2;
            if(sortedList.get(mid) > value) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
    //주사위 굴리기
    public void calculateSums(int depth, int sum, int[][] dice, int[] diceArr, List<Integer> sums) {
        if(depth == N/2) {
            sums.add(sum);
            return;
        }
        for(int a : dice[diceArr[depth] - 1]) {
            calculateSums(depth + 1, sum + a, dice, diceArr, sums);
        }
        
    }
}