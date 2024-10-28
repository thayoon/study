import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken()); // 회의실 수
        int M = Integer.parseInt(st.nextToken()); // 예약 회의 수
        
        TreeMap<String, List<int[]>> roomMeet = new TreeMap<>(); // 회의실 이름 오름차순 정렬
        for (int i = 0; i < N; i++) {
            String room = br.readLine();
            roomMeet.put(room, new ArrayList<>()); // key: 회의실 이름, value: 빈 리스트 초기화
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            String r = st.nextToken(); // 회의실 이름
            int s = Integer.parseInt(st.nextToken()); // 시작 시각
            int t = Integer.parseInt(st.nextToken()); // 종료 시각

            roomMeet.get(r).add(new int[]{s, t});
        }

        int index = 0; // 출력용 인덱스
        for (Map.Entry<String, List<int[]>> entry : roomMeet.entrySet()) {
            String room = entry.getKey();
            List<int[]> meetings = entry.getValue();

            boolean[] time = new boolean[18]; // 9~17시
            // 예약된 회의 시간 기록
            for (int[] meet : meetings) {
                int s = meet[0];
                int t = meet[1];
                for (int i = s; i < t; i++) {
                    time[i] = true; // 예약된 시간
                }
            }

            List<String> able = new ArrayList<>();
            int t = 9;
            while (t < 18) {
                // 사용 가능한 시작 시각 찾기
                while (t < 18 && time[t]) {
                    t++; // 예약된 시간이므로 다음 시간으로 이동
                }
                
                if (t >= 18) break; // 18시를 넘어가면 종료

                // 사용 가능한 시각 시작
                int start = t;

                // 다음 예약된 시각 찾기
                while (t < 18 && !time[t]) {
                    t++; // 예약되지 않은 시간 계속 진행
                }

                // 사용 가능한 시간 추가
                int end = t;
                if(start == 9) {
                    able.add("09-" + end);
                } else {
                    able.add(start + "-" + end);   
                }
            }

            sb.append("Room ").append(room).append(":").append("\n");
            if (able.isEmpty()) {
                sb.append("Not available").append("\n");
            } else {
                sb.append(able.size()).append(" available:").append("\n");
                for (String times : able) {
                    sb.append(times).append("\n");
                }
            }
            index++;
            if(index < N) {
                sb.append("-----").append("\n");   
            }
        }
        System.out.println(sb.toString());
    }
}
