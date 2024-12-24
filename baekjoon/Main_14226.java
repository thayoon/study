package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_14226 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1])); // 화면 이모티콘
        boolean[][] visited = new boolean[2001][2001]; // 화면 이모티콘 수, 클립보드 수 방문 배열
        visited[1][0] = true;
        q.offer(new int[] {1, 0, 0}); // 화면, 시간, 클립보드
        int min = 2*S;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int cnt = now[0]; // 화면에 있는 이모티콘 수
            int time = now[1]; // 연산 시간
            int clip = now[2]; // 클립보드에 있는 이모티콘 수

            if(cnt == S) {
                min = time;
                break;
            }
            //클립보드가 비어있는 상태에는 붙여넣기 안됨
            if(!visited[cnt][cnt]) {
                // 복사하기
                visited[cnt][cnt] = true;
                q.offer(new int[] {cnt, time+1, cnt});
            }
            if(clip != 0 && cnt+clip < 2001 && !visited[cnt+clip][clip]) {
                // 붙여넣기
                visited[cnt+clip][clip] = true;
                q.offer(new int[] {cnt+clip, time+1, clip});
            }
            if(cnt > 0 && !visited[cnt-1][clip]) {
                // 화면에 있는 이모티콘 삭제
                visited[cnt-1][clip] = true;
                q.offer(new int[] {cnt-1, time+1, clip});
            }
        }

        System.out.println(min);
    }
}
