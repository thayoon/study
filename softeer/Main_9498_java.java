package softeer;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String parenthesis = br.readLine();
        int openBrackets = 0;
        
        for(int i=0; i<parenthesis.length(); i++) {
            // (인 경우
            if(parenthesis.charAt(i) == '(') {
                sb.append("(");
                openBrackets++; // 열린 괄호 하나 추가
            } else {
                // )인 경우
                openBrackets--;  // 닫힌 괄호에 맞춰 하나 감소
                sb.append("1)");  // 기본적으로 "1)" 추가
                
                if (openBrackets > 0 || i != parenthesis.length()-1) {
                     // 아직 열린 괄호가 남아있거나 마지막이 아니라면 "+" 추가
                    sb.append("+");
                }
            }
        }

        System.out.println(sb.toString());
    }
}
