import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        int row = maps.length;
        int col = maps[0].length;

        // bfs
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[row][col];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        visited[0][0] = true;
        q.offer(new int[] {0, 0});

        while(!q.isEmpty()) {
            int now[] = q.poll();
            int x = now[0];
            int y = now[1];

            for(int i=0; i<4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx<0 || nx>=row || ny<0 || ny>=col) continue;
                if(visited[nx][ny] || maps[nx][ny] == 0) continue;

                q.offer(new int[] {nx, ny});
                maps[nx][ny] = maps[x][y] + 1;
                visited[nx][ny] = true;
            }
        }

        if(visited[row-1][col-1]) return maps[row-1][col-1];
        else return -1;
    }
}