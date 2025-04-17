package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17615 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String balls = br.readLine();

        int min = Integer.MAX_VALUE;
        int red = 0;
        int blue = 0;

        for (int i = 0; i < N; i++) {
            if(balls.charAt(i) == 'R') {
                red++;
            } else {
                blue++;
            }
        }
        
        // 1. 오른쪽으로 R 모으기
        min = Math.min(min, red-moveRight(N, balls, 'R'));

        // 2. 왼쪽으로 R 모으기
        min = Math.min(min, red-moveLeft(N, balls, 'R'));

        // 3. 오른쪽으로 B 모으기
        min = Math.min(min, blue-moveRight(N, balls, 'B'));

        // 4. 왼쪽으로 B 모으기
        min = Math.min(min, blue-moveLeft(N, balls, 'B'));

        System.out.println(min);
    }

    public static int moveRight(int N, String balls, char ball) {
        int cnt = 0;
        for (int i = N-1; i >= 0; i--) {
            if(balls.charAt(i) == ball) {
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }

    public static int moveLeft(int N, String balls, char ball) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if(balls.charAt(i) == ball) {
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }

}
