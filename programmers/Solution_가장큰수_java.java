import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        // int[] -> String[]
        String[] arr = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        
        // descending order
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        // start index 0, if all elements are 0, return "0"
        if (arr[0].equals("0")) {
            return "0";
        }
        
        // return concatenated string
        StringBuilder sb = new StringBuilder();
        for(String str : arr) {
            sb.append(str);
        }
        return sb.toString();
    }
}