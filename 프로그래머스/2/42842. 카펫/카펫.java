class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow; // 전체 카펫 넓이

        for (int height = 3; height <= (int) Math.sqrt(total); height++) {
            if (total % height == 0) {
                int width = total / height;

                if ((width - 2) * (height - 2) == yellow) {
                    return new int[]{width, height}; // 가로 길이가 더 크거나 같으므로 바로 반환
                }
            }
        }
        
        return new int[0]; // 문제가 없는 이상 여기로 올 수 없음
    }
}
