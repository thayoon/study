package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());    // 출입 기록의 수
        TreeSet<String> map = new TreeSet<>(Comparator.reverseOrder());    // 출입 기록, 역순 정렬

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String log = st.nextToken();

            if(log.equals("enter")) {
                // 출입한 경우 데이터 추가
                map.add(name);
            } else {
                // 퇴근한 경우 데이터 삭제
                map.remove(name);
            }
        }

        for (String names : map) {
            System.out.println(names);
        }
    }
}
