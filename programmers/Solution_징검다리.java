import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        
        int left = 1;
        int right = distance;
        
        while(left<=right) {
            int mid = (left+right)/2; // 거리 사이 최소 거리 설정
            
            int prev = 0; // 이전 바위 위치
            int remove = 0; // 삭제한 바위 수
            
            for(int i=0; i<rocks.length; i++) {
                if(rocks[i]-prev < mid) { // 설정한 최소 거리보다 작다면 바위 삭제
                    remove++;
                    if(remove>n) break;
                } else { // 최소 거리보다 크다면 이전 바위 갱신
                  prev = rocks[i];  
                }
            }
            // 도착지점과 마지막 바위 사이 거리가 최소 거리보다 작다면 바위 삭제
            if(distance-prev < mid) remove++;
            
            if(remove>n) { // 삭제한 바위 수가 n보다 크다면
                right = mid-1; // 더 작은 최소 거리 갱신
            } else {
                answer = mid; // 최소 거리를 유지할 수 있으므로 답 갱신
                left = mid+1; // 더 큰 최소 거리를 탐색하기 위해 최소 거리 갱신
            }
        }
        return answer;
    }
}