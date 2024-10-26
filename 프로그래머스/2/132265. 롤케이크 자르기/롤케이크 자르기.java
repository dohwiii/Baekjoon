import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int n = topping.length;
        
        // 오른쪽에서의 고유 토핑 개수를 저장할 배열
        int[] rightUniqueCount = new int[n];
        Set<Integer> rightSet = new HashSet<>();
        
        // 오른쪽 고유 토핑 개수 계산 (뒤에서부터 누적)
        for (int i = n - 1; i >= 0; i--) {
            rightSet.add(topping[i]);
            rightUniqueCount[i] = rightSet.size();
        }
        
        // 왼쪽에서 고유 토핑 수를 관리하는 Set
        Set<Integer> leftSet = new HashSet<>();
        
        // 왼쪽에서부터 순회하면서 공평하게 나눌 수 있는 지점 확인
        for (int i = 0; i < n - 1; i++) {
            leftSet.add(topping[i]);
            
            // 왼쪽과 오른쪽의 고유 토핑 개수가 같으면 카운트 증가
            if (leftSet.size() == rightUniqueCount[i + 1]) {
                answer++;
            }
        }
        
        return answer;
    }
}
