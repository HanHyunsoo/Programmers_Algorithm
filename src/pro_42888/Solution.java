package pro_42888;

import java.util.*;

public class Solution {

    public static String[] solution(String[] record) {
        Map<String, String> chatRoom = new HashMap<>();

        // 첫번째 반복 : 해당 유저의 닉네임 최신화
        for (String command : record) {
            String[] requests = command.split(" ");

            switch (requests[0]) {
                // Leave일 때 실제로 정보를 삭제하면 안됨
                case "Enter":
                case "Change":
                    chatRoom.put(requests[1], requests[2]);
                    break;
            }
        }

        List<String> answerList = new ArrayList<>();

        // 두번째 반복 : answer 배열 구성
        for (String command : record) {
            String[] requests = command.split(" ");

            switch (requests[0]) {
                case "Enter":
                    answerList.add(chatRoom.get(requests[1]) + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    answerList.add(chatRoom.get(requests[1]) + "님이 나갔습니다.");
                    break;
            }
        }

        return answerList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"})));
    }
}