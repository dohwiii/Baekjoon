import java.util.*;

class Solution {
    static int N;
    static boolean[] visited;
    static Map<int[], List<Integer>> map;
    static double maxWinRate;
    static int[] answer;
    
    public int[] solution(int[][] dice) {
        N = dice.length;
        map = new HashMap<>();
        visited = new boolean[N];
        answer = new int[N/2];
        
        selectDice(0, 0, dice);
        
        return answer;
    }
    public void selectDice(int start, int depth, int[][] dice) {
        if(depth == N/2) {
            int[] A = new int[N/2];
            int[] B = new int[N/2];
            int aIndex = 0, bIndex = 0;
            for(int i=0; i<N; i++) {
                if(visited[i]) {
                    A[aIndex++] = i;
                }
                else {
                    B[bIndex++] = i;
                }
            }
            List<Integer> aSums = gameStart(A, dice);
            List<Integer> bSums = gameStart(B, dice);
            double winRate = calcWinRate(aSums, bSums);
            if(maxWinRate < winRate) {
                maxWinRate = winRate;
                answer = Arrays.stream(A).map(i -> i+1).toArray();
            }
            return;
        }
        for(int i=start; i<N; i++) {
            visited[i] = true;
            selectDice(i + 1, depth + 1, dice);
            visited[i] = false;
        }
    }
    public List<Integer> gameStart(int[] arr, int[][] dice) {
        int[] cloneArr = arr.clone();
        if(map.containsKey(cloneArr)) {
            return map.get(cloneArr);
        }
        List<Integer> sums = new ArrayList<>();
        calculateSum(0, 0, arr, dice, sums);
        Collections.sort(sums); //합 정렬
        map.put(cloneArr, sums);
        return sums;
    }
    public void calculateSum(int depth, int sum, int[] diceArr, int[][] dice, List<Integer> sumList) {
        if(depth == diceArr.length) {
            sumList.add(sum);
            return;
        }
        for(int num : dice[diceArr[depth]]) {
            calculateSum(depth + 1, sum + num, diceArr, dice, sumList);
        }
    }
    public double calcWinRate(List<Integer> aList, List<Integer> bList) {
        int totalCase = aList.size() * bList.size();
        int winCase = 0;
        int aIndex = 0;
        
        for(int b : bList) {
            while(aIndex < aList.size() && aList.get(aIndex) <= b) {
                aIndex++;
            }
            winCase += aList.size() - aIndex;
        }
        return (double) winCase / totalCase;
    }
}