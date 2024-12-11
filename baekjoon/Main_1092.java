package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1092 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        Integer[] crain = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crain[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        List<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(crain, Collections.reverseOrder());
        box.sort(Collections.reverseOrder());

        if(crain[0] < box.get(0)) {
            System.out.println(-1);
            return;
        }
        int min = 0; // 최소 시간
        while(!box.isEmpty()) {
            int index = 0; // 박스 인덱스
            for (int i = 0; i < N; i++) {
                if(index == box.size()) break; // 모든 박스 옮긴 경우
                else if(box.get(index) <= crain[i]) {
                    box.remove(index); // 크레인으로 이동
                } else { // 박스 무게 크레인 초과
                    index++; // 다음 박스와
                    i--; // 현재 크레인 비교
                }
            }
            min++;
        }

        System.out.println(min);
    }
}
