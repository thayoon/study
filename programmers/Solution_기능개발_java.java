import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();

//         Quque 사용
//         Queue<Integer> q = new ArrayDeque<>();
        
//         for(int i=0; i<progresses.length; i++) {
//             q.offer((int)Math.ceil((100 - progresses[i]) / (double)speeds[i]));  // 기능 개발 소요일
//         }
        
//         list.add(1); // 첫 번째 기능 개발 완료
//         int day = q.poll();  // 현재 소요일, 첫 번째 기능 개발 완료일
        
//         while(!q.isEmpty()) {
//             int now = q.poll();  // 지금 기능의 개발 소요일
            
//             if(day >= now) { // 현재 소요일이 지금 기능 개발 소요일보다 이상이라면 현내날짜에 배포 가능
//                 list.set(list.size()-1, list.get(list.size()-1)+1);
//             } else { // 현재 소요일이 지금 기능 개발 소요일보다 이하라면 새로운 기능 개발 시작
//                 list.add(1);
//                 day = now;
//             }
//         }

//      list 사용
        int day = (int)Math.ceil((100 - progresses[0]) / (double)speeds[0]);  // 첫 째날, 현재 소요일
        list.add(1);  // 기능 개발 완료
        
        for(int i=1; i<progresses.length; i++) {
            int now = (int)Math.ceil((100 - progresses[i]) / (double)speeds[i]);  // i번째 작업의 개발 소요일
            if(now <= day) {  // i번째 작업의 개발 소요일보다 현재 소요일이 이하라면 배포 가능
                list.set(list.size()-1, list.get(list.size()-1)+1);
            } else {
                list.add(1);  // 다음 배포일
                day = now;  // 소요일 갱신
            }
        }
        
        return list;
    }
}