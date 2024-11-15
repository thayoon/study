package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수빈이의 현재 점
        int K = Integer.parseInt(st.nextToken()); // 동생 점

        int[] map = new int[100001];
        Arrays.fill(map, 100001);   // 점 도착 누적 시간 초기화

        Queue<int[]> pq = new PriorityQueue<>((o1, o2)-> Integer.compare(o1[1], o2[1])); // 누적 시간 오름차순
        map[N] = 0; // 시작 점 0초
        pq.offer(new int[] {N, map[N]});

        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            int cur = now[0]; // 현재 점
            int time = now[1]; // 현재 누적 시간

            if(cur == K) break; // 동생 점 도착

            if(time > map[cur]) continue; // 현재 누적 시간이 기존 누적 시간보다 크다면 continue

            // 걷기 X-1, 기존 누적 시간 보다 빠른 시간이라면 갱신
            if(cur-1 >= 0 && time+1 < map[cur-1]) {
                map[cur-1] = time + 1; // 걷기 1초
                pq.offer(new int[] {cur-1, time+1});
            }
            // 걷기 X+1, 기존 누적 시간 보다 빠른 시간이라면 갱신
            if(cur+1 <= 100000 && time+1 < map[cur+1]) {
                map[cur+1] = time + 1; // 걷기 1초
                pq.offer(new int[] {cur+1, time+1});
            }
            // 순간이동 2*X, 기존 누적 시간보다 빠른 시간이라면 갱신
            if(2*cur <= 100000 && time < map[2*cur]) {
                map[2*cur] = time; // 순간이동 0초
                pq.offer(new int[] {2*cur, time});
            }
        }

        System.out.println(map[K]);
    }
}
