import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<N; j++) {
                int now = str.charAt(j) - '0';
                if(now == 1) {
                    map[i][j] = true;
                }
            } 
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j]) {
                    pq.offer(dfs(i, j, 1));
                }
            }
        }

        sb.append(pq.size()).append("\n");
        while(!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int dfs(int x, int y, int cnt) {
        map[x][y] = false;
        for(int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny]) {
                cnt = dfs(nx, ny, cnt+1);
            }
        }
        return cnt;
    }
}
