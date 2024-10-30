import java.io.*;
import java.util.*;

public class Main {
    static int n, m, max;
    static int[][] map;
    static int[][] friend;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 나무 격자 땅 크기
        m = Integer.parseInt(st.nextToken()); // 친구 수

        map = new int[n][n]; // 나무 격자 땅
        friend = new int[m][2]; // 친구 위치 좌표 배열
        max = 0; // 열매 수확 수
        visited = new boolean[n][n]; // 방문 처리 배열
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            friend[i][0] = Integer.parseInt(st.nextToken())-1;
            friend[i][1] = Integer.parseInt(st.nextToken())-1;
            max += map[friend[i][0]][friend[i][1]]; // 0초 수확량
            visited[friend[i][0]][friend[i][1]] = true; // 0초 좌표 방문 처리
        }

        dfs(friend[0][0], friend[0][1], 0, max, 0);

        System.out.println(max);
    }

    public static void dfs(int x, int y, int time, int fruit, int cnt) { 
        if(time == 3) {
            if(cnt+1 < m) { // m명의 친구까지 dfs 진행
                dfs(friend[cnt+1][0], friend[cnt+1][1], 0, fruit, cnt+1);
            } else {
              max = Math.max(max, fruit); // 최대 수확량 갱신
            }
            return;
        } 
        for(int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && nx<n && ny>=0 && ny<n && !visited[nx][ny]) {
                visited[nx][ny] = true;

                dfs(nx, ny, time+1, fruit+map[nx][ny], cnt);

                visited[nx][ny] = false;
            }
        }
    }
}
