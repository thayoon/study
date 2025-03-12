package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17392 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 약속 개수
        int M = Integer.parseInt(st.nextToken()); // 방학 일수

        int[] H = new int[N]; // 각 약속 기대 행복 값
        st = new StringTokenizer(br.readLine());

        int plan = N; // 총 행복일, 각 약속마다 1일을 차지하므로 N부터 시작
        for (int i = 0; i < N; i++) {
            H[i] = Integer.parseInt(st.nextToken());
            plan += H[i]; // 약속으로 인한 추가 행복일 누적 (H1+1) + (H2+1) + ... + (Hn+1)
        }
        int sad = M-plan; // 남은 방학기간 동안 우울한 날의 수
        int min = 0; // 총 우울함
        if (sad > 0) { // 우울한 날이 있다면
            int section = N+1; // 약속+1 구간
            if(section >= sad) { // 구간이 우울한 날보다 많다면
                min = sad; // 각 구간에 하루만 우울한 날 배치 = sad
            } else {
                // 우울한 날을 (N+1)개의 구간에 균등 분배
                int x = sad / section; // 각 구간에 들어갈 우울한 날 개수
                int remain = sad % section; // 균등 배분 후 남는 우울한 날 개수 -> remain개의 구간이 1일 더 가짐

                min = (x+1)*(x+1)*remain; // remain 개의 구간에는 (x+1)날의 우울감(제곱합)
                min += section * (x*(x+1)*(2*x+1))/6; // 나머지 구간은 x개의 우울한 날 배치 (구간*제곱합)
            }
        }
        System.out.println(min);
    }
}
