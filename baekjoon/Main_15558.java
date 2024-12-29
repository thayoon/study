package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15558 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[2][N];

        for (int i = 0; i < 2; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                if(str.charAt(j) == '1') {
                    map[i][j] = true;
                }
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[2][N];
        visited[0][0] = true;
        q.offer(new int[] {0, 0}); // x, y
        int time = 0;

        while (time < N) {
            if(q.isEmpty()) break;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] now = q.poll();
                int x = now[0];
                int y = now[1];

                if (y+k >= N) { // N번 칸 보다 더 큰 칸으로 이동하는 경우
                    System.out.println(1);
                    return;
                }

                if(!visited[x][y+1] && map[x][y+1]) { // 한 칸 앞
                    visited[x][y+1] = true;
                    q.offer(new int[] {x, y+1});
                }

                if(time < y-1 && !visited[x][y-1] && map[x][y-1]) { // 한 칸 뒤
                    visited[x][y-1] = true;
                    q.offer(new int[] {x, y-1});
                }

                if(!visited[1-x][y+k] && map[1-x][y+k]) { // 반대편 줄 +k 점프
                    visited[1-x][y+k] = true;
                    q.offer(new int[] {1-x, y+k});
                }
            }

            // 현재 시간 증가
            time++;
        }

        System.out.println(0);
    }
}
