package pro_12899;

public class Solution {
    public static String solution(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            if (n % 3 == 0) {
                sb.append(4);
                n--;
            } else if (n % 3 == 1) {
                sb.append(1);
            } else {
                sb.append(2);
            }

            n /= 3;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(10));
    }
}
