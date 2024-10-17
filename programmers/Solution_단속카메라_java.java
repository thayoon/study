import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        // 진출 시점 기준 오름차순 정렬
        Arrays.sort(routes, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0]-o2[0];
            }
            return o1[1]-o2[1];
        });
        
        int end = routes[0][1]; // 현재 진출 시각
        for(int i=1; i<routes.length; i++) {
            // i번째 진입 시작 시각이 현재 진출 시각보다 크다면 단속카메라 설치
            if(end < routes[i][0]) {
                answer++;
                end = routes[i][1];    // 진출 시각 갱신
            }
        }
        return answer;
    }
}