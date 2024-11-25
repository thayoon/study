package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트 데이터 개수
        TreeMap<Integer, Integer> tm;

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine()); // 연산 개수
            tm = new TreeMap<>();

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                String oper = st.nextToken(); // 삽입, 삭제 연산 종류
                int num = Integer.parseInt(st.nextToken()); // 삽입 삭제 연산 정수

                if(oper.equals("I")) {
                    tm.put(num, tm.getOrDefault(num, 0)+1);
                } else if(!tm.isEmpty() && oper.equals("D")) {
                    if(num == 1) { // 최댓값 삭제
                        int max = tm.lastKey();
                        if(tm.get(max) == 1) tm.remove(max);
                        else tm.put(max, tm.get(max)-1);
                    } else { // 최솟값 삭제
                        int min = tm.firstKey();
                        if(tm.get(min) == 1) tm.remove(min);
                        else tm.put(min, tm.get(min)-1);
                    }
                }
            }
            if(tm.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(tm.lastKey()).append(" ").append(tm.firstKey()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
