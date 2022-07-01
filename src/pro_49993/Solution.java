package pro_49993;

public class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skillTree : skill_trees) {
            StringBuilder sb = new StringBuilder();

            for (String subStr : skillTree.split("")) {
                if (skill.contains(subStr)) {
                    sb.append(subStr);
                }
            }

            if (skill.indexOf(sb.toString()) == 0) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}
