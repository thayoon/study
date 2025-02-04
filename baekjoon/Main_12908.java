package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_12908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int xs = Integer.parseInt(st.nextToken());
        int ys = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int xe = Integer.parseInt(st.nextToken());
        int ye = Integer.parseInt(st.nextToken());

        // 0: 시작점, 1~6: 텔레포트, 7: 도착점
        int[][] spot = new int[8][2];
        spot[0][0] = xs;
        spot[0][1] = ys;
        spot[7][0] = xe;
        spot[7][1] = ye;

        long[][] dist = new long[8][8];
        for (int i = 0; i < 8; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][7] = dist[7][0] = Math.abs(xs-xe) + Math.abs(ys-ye); // 맨해튼 거리(상하좌우 이동 거리)

        // 텔레포트 초기화
        for (int i = 1; i < 7; i += 2) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                spot[i][j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < 2; j++) {
                spot[i+1][j] = Integer.parseInt(st.nextToken());
            }

            // 맨해튼 거리와 텔레포트 이동(10) 비교 후 작은 거리 값
            dist[i][i+1] = dist[i+1][i] = Math.min(Math.abs(spot[i][0] - spot[i+1][0])+Math.abs(spot[i][1]-spot[i+1][1]), 10);
        }

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                // 현재 이동 값과 맨해튼 거릿값 중 최솟값 갱신
                dist[i][j] = Math.min(dist[i][j], Math.abs(spot[i][0]-spot[j][0]) + Math.abs(spot[i][1]-spot[j][1]));
            }
        }

        // Floyd–warshall
        for(int k = 0; k < 8; k++) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        System.out.println(dist[0][7]);
    }
}
