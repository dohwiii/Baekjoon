import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 수열 크기
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> lis = new ArrayList<>(); // LIS 배열

        for (int num : arr) {
            int idx = lowerBound(lis, num); // 이분 탐색으로 삽입 위치 찾기

            if (idx == lis.size()) {
                lis.add(num); // 가장 큰 숫자라면 추가
            } else {
                lis.set(idx, num); // 기존 LIS 배열 업데이트 (더 작은 값으로 덮어쓰기)
            }
        }

        System.out.println(lis.size()); // LIS 길이 출력
    }

    // 📌 직접 구현한 이분 탐색 메서드 (Lower Bound)
    public static int lowerBound(List<Integer> lis, int target) {
        int left = 0, right = lis.size();

        while (left < right) {
            int mid = left + (right - left) / 2; // 중간 위치 계산

            if (lis.get(mid) >= target) {
                right = mid; // target보다 크거나 같은 값이면 오른쪽 범위를 줄임
            } else {
                left = mid + 1; // target보다 작은 값이면 왼쪽 범위를 증가
            }
        }

        return left; // target이 들어갈 위치 반환
    }
}