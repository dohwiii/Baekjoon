class Solution {
    public int solution(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int answer = n; // worst case: no compression
        // try each possible unit size
        for (int size = 1; size <= n / 2; size++) {
            StringBuilder compressed = new StringBuilder();
            String prev = s.substring(0, size);
            int count = 1;
            for (int i = size; i < n; i += size) {
                int end = Math.min(i + size, n);
                String curr = s.substring(i, end);
                if (prev.equals(curr)) {
                    count++;
                } else {
                    if (count > 1) compressed.append(count);
                    compressed.append(prev);
                    prev = curr;
                    count = 1;
                }
            }
            // last group
            if (count > 1) compressed.append(count);
            compressed.append(prev);
            answer = Math.min(answer, compressed.length());
        }
        return answer;
    }
}
