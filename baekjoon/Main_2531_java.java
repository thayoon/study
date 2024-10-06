package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 접시 수
        int d = Integer.parseInt(st.nextToken());   // 초밥 가짓수
        int k = Integer.parseInt(st.nextToken());   // 연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken());   // 쿠폰 번호

        int[] belt = new int[N+k-1];    // belt 위 회전초밥
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < k-1; i++) { // 회전하기 때문에 N부터 k-1까지 초기화
            belt[N+i] = belt[i];
        }

        int[] type = new int[d+1];  // 초밥의 가짓수, 1부터 시작
        type[c] = 1;    // 쿠폰 초밥을 먹었다고 가정
        int max = 1;    // 초밥 가짓수, 쿠폰 초밥을 먹었으므로 +1 초기화

        // 슬라이딩 윈도우
        for (int i = 0; i < k; i++) {   // 초기값 세팅
            if(type[belt[i]] == 0) max++;   // i번째 초밥을 안먹은 상태라면 max값 +1
            type[belt[i]]++;
        }

        int cnt = max;  // 슬라이딩하면서 값 변경
        for (int i = k; i < N+k-1; i++) {
            int j = i-k;
            type[belt[j]]--;    // 윈도우 전 칸 초밥 빼기
            if(type[belt[j]] == 0) cnt--;   // 윈도우 전 칸이 0이라면 가짓수 빼기
            if(type[belt[i]] == 0) cnt++;   // 새로 들어온 윈도우 칸이 처음 먹는 초밥이라면 가짓수 더하기
            type[belt[i]]++;    // 초밥 먹기
            max = Math.max(max, cnt);
        }

        System.out.println(max);

    }
}
