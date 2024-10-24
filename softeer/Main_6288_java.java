import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // 가격 기준 내림차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[1], o1[1]));
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // M
            int P = Integer.parseInt(st.nextToken()); // P
            pq.offer(new int[] {M, P});
        }

        int total = 0; // 현재 총 무게
        int cost = 0; // 현재 무게당 가격
        while (!pq.isEmpty() && total < W) {
            int[] now = pq.poll();
            
            // 현재 총 무게 + 현재 무게 < 배낭 무게
            if(total + now[0] < W) {
                cost += now[0] * now[1];
                total += now[0];
            } else {
                int remain = W - total;
                cost += remain * now[1];
                break;
            }
        }
        System.out.println(cost);
    }
}
