import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int N = nums.length;
        int answer = N/2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int pon : nums) {
            map.put(pon, map.getOrDefault(pon, 0)+1);
        }
        return map.size() > N/2 ? N/2 : map.size();
        // return Math.min(map.size(), N/2);
    }
}