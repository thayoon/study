import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long low = times[0]; // 최소 시간
        long high = (long) n * times[times.length-1]; // 최대 시간
        long answer = high;
        
        while(low <= high) {
            long mid = (low+high)/2;
            long cnt = 0; // mid 시간 내 심사 가능 수
            
            for(int time : times) {
                cnt += mid/time; // 각 심사관이 mid 시간 동안 몇 명을 심시할 수 있는지 계산
                if(cnt >= n) break;
            }
            
            if(cnt >= n) { // n명 이상 심사 가능하면 최대 시간 갱신
                answer = mid;
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return answer;
    }
}