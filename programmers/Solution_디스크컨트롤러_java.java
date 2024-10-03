import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 작업 요청 시점 오름차순 정렬
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        
        // 소요 시간 기준 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int answer = 0; // 총 작업 시간
        int idx = 0;    // 현재 작업 처리 개수
        int cnt = jobs.length;  // 총 작업 개수
        int sec = 0;    // 현재 초
        
        while (idx < cnt || !pq.isEmpty()) {
            // 현재 시간 이하에 들어온 요청 pq에 담기
            while(idx < cnt && jobs[idx][0] <= sec) {
                pq.offer(jobs[idx]);
                idx++;
            }
            // 작업이 남아있다면
            if(!pq.isEmpty()) {
                int[] now = pq.poll();
                sec += now[1];  // 작업 수행 시간
                answer += sec-now[0];   // 작업 요청에서 종료까지 : 현재 시간 - 요청 시간
            } else {
                // 작업이 없다면 다음 요청 시간으로 이동
                sec = jobs[idx][0];
            }
        }
        
        return answer/cnt;
    }
}