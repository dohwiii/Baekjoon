import java.util.*;

class Solution {
    static int N;
    static Map<String, List<Integer>> cache = new HashMap<>();
    static Map<Integer, Map<Integer, List<Integer>>> dp = new HashMap<>();

    public int[] solution(int[][] dice) {
        N = dice.length;
        int[] answer = new int[N / 2];
        boolean[] used = new boolean[N + 1];
        int[] A = new int[N / 2];
        int[] B = new int[N / 2];
        double[] maxRate = {0.0};

        combiAndProcess(1, 0, dice, A, B, used, maxRate, answer);
        return answer;
    }

    public void combiAndProcess(int start, int depth, int[][] dice, int[] A, int[] B, boolean[] used, double[] maxRate, int[] answer) {
        if (depth == N / 2) {
            int bIndex = 0;
            for (int i = 1; i <= N; i++) {
                if (!used[i]) {
                    B[bIndex++] = i;
                }
            }
            List<Integer> aSums = calculateAllSum(A, dice);
            List<Integer> bSums = calculateAllSum(B, dice);
            double winRate = calculateWinRate(aSums, bSums);
            if (winRate > maxRate[0]) {
                maxRate[0] = winRate;
                System.arraycopy(A, 0, answer, 0, A.length);
            }
            return;
        }

        for (int i = start; i <= N; i++) {
            if (!used[i]) {
                used[i] = true;
                A[depth] = i;
                combiAndProcess(i + 1, depth + 1, dice, A, B, used, maxRate, answer);
                used[i] = false;
            }
        }
    }

    public List<Integer> calculateAllSum(int[] arr, int[][] dice) {
        String key = Arrays.toString(arr);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        List<Integer> sums = new ArrayList<>();
        calculateSums(0, 0, dice, arr, sums);
        Collections.sort(sums);
        cache.put(key, sums);
        return sums;
    }

    public double calculateWinRate(List<Integer> aSums, List<Integer> bSums) {
        int totalCases = aSums.size() * bSums.size();
        int winCases = 0;

        int aIndex = 0;
        for (int bSum : bSums) {
            while (aIndex < aSums.size() && aSums.get(aIndex) <= bSum) {
                aIndex++;
            }
            winCases += aSums.size() - aIndex;
        }
        return (double) winCases / totalCases;
    }

    public void calculateSums(int depth, int sum, int[][] dice, int[] diceArr, List<Integer> sums) {
        if (depth == diceArr.length) {
            sums.add(sum);
            return;
        }
        for (int face : dice[diceArr[depth] - 1]) {
            calculateSums(depth + 1, sum + face, dice, diceArr, sums);
        }
    }
}