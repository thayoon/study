import java.io.*;
import java.util.*;

public class Main {
    static int n, m, cnt;
    static int[][] map;
    static int[][] checkPoint;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 격자 크기
        m = Integer.parseInt(st.nextToken()); // 방문해야 하는 칸 수

        map = new int[n][n]; // 격자 배열
        checkPoint = new int[m][2]; // 방문해야 하는 지점 좌표
        visited = new boolean[n][n]; // 방문 처리
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            checkPoint[i][0] = Integer.parseInt(st.nextToken())-1;
            checkPoint[i][1] = Integer.parseInt(st.nextToken())-1;
        }

        visited[checkPoint[0][0]][checkPoint[0][1]] = true;
        dfs(checkPoint[0][0], checkPoint[0][1], 1);

        System.out.println(cnt);
    }

    public static void dfs(int x, int y, int point) {
        if(point == m) { // 모든 지점을 방문한 경우
            cnt++;
            return;
        }
        
        int nextX = checkPoint[point][0]; // 다음 방문 지점 좌표
        int nextY = checkPoint[point][1]; // 다음 방문 지점 좌표
        
        for(int i=0; i<4; i++) { // 상하좌우 이동
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && nx<n && ny>=0 && ny<n && !visited[nx][ny] && map[nx][ny] != 1) { // 이동 가능한 좌표라면
                visited[x][y] = true;
                if(nx == nextX && ny == nextY) {
                    dfs(nx, ny, point+1); // 다음 방문 지점이라면 point+1
                } else {
                    dfs(nx, ny, point);
                }
                visited[x][y] = false; // backtracking
            }
        }
    }
}
