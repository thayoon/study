package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_24023 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int s = 1;
        int bit = 0;

        st = new StringTokenizer(br.readLine());
        for (int e = 1; e <= N; e++) {
            int cur = Integer.parseInt(st.nextToken());

            if((cur | K) != K) {
                // K를 만드는데 기여할 수 있는 값인지 판별
                // 기여할 수 없는 경우 bit 초기화, 구간 시작점을 끝점+1로 변경
                bit = 0;
                s = e+1;
            } else {
                bit |= cur;
                if(bit == K) {
                    System.out.println(s+" "+e);
                    return;
                }
            }
        }

        System.out.println(-1);
    }
}
