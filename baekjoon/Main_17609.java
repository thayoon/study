package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
             char[] str = br.readLine().toCharArray();
             sb.append(palindrome(str, 0, str.length-1, 0)).append("\n");

//            StringBuilder str = new StringBuilder(br.readLine());
//            int ans = 2;
//            if(str.toString().contentEquals(str.reverse())) {
//                ans = 0;
//            } else {
//                int left = 0;
//                int right = str.length()-1;
//                while(left < right) {
//                    if(str.charAt(left) != str.charAt(right)) {
//                        StringBuilder delLeft = new StringBuilder(str).deleteCharAt(left);
//                        StringBuilder delRight = new StringBuilder(str).deleteCharAt(right);
//
//                        if(delLeft.toString().contentEquals(delLeft.reverse()) || delRight.toString().contentEquals(delRight.reverse())) {
//                            ans = 1;
//                        }
//                        break;
//                    }
//                    left++;
//                    right--;
//                }
//            }
//            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    public static int palindrome(char[] str, int left, int right, int rm) {
        if(rm >= 2) return 2;

        while(left < right) {
            if(str[left] == str[right]) {
                left++;
                right--;
            }else {
                return Math.min(palindrome(str, left+1, right, rm+1), palindrome(str, left, right-1, rm+1));
            }
        }

        return rm;
    }
}
