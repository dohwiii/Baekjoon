import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int answer = 0;
        int nCols = relation[0].length;

        Queue<BitSet> queue = new PriorityQueue<>(Comparator.comparing(BitSet::cardinality));
        addAllCases(queue, nCols);

        while (!queue.isEmpty()) {
            BitSet colCase = queue.remove();

            if (isCandidateKey(relation, colCase)) {
                queue.removeIf(bs -> contains(bs, colCase));
                answer += 1;
            }
        }

        return answer;
    }

    private boolean isCandidateKey(String[][] relation, BitSet colCase) {
        String[] combinedKeys = combineKeys(relation, colCase);
        Set<String> keys = new HashSet<>();
        for (String key : combinedKeys) {
            if (!keys.add(key)) {
                return false;
            }
        }
        return true;
    }

    private String[] combineKeys(String[][] relation, BitSet colCase) {
        int nRows = relation.length;
        int nCols = relation[0].length;

        String[] keys = new String[nRows];
        for (int r = 0; r < nRows; r++) {
            keys[r] = "";
        }

        for (int c = 0; c < nCols; c++) {
            if (!colCase.get(c)) {
                continue;
            }

            for (int r = 0; r < nRows; r++) {
                keys[r] += relation[r][c] + "_";
            }
        }
        return keys;
    }

    private boolean contains(BitSet parent, BitSet colCase) {
        BitSet bs = (BitSet) colCase.clone();
        bs.and(parent);
        return bs.equals(colCase);
    }

    private void addAllCases(Collection<BitSet> list, int nCols) {
        int end = 1 << nCols;
        for (int i = 1; i < end; i++) {
            BitSet c = BitSet.valueOf(new long[] { i });
            list.add(c);
        }
    }
}