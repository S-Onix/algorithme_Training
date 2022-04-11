package programmers;

import java.util.*;

class OpenChat {
    public String[] solution(String[] record) {
        HashMap<String,String> userInfo = new HashMap<>();

        for(String message : record) {
            String [] st = message.split(" ");

            String oper = st[0];
            String userId = st[1];

            if(oper.equals("Enter") || oper.equals("Change")){
                userInfo.put(userId, st[2]);
            }
        }

        ArrayList<String> resultMsg = new ArrayList<>();
        for(String message : record) {

            String [] st = message.split(" ");
            String oper = st[0];

            if(oper.equals("Change")) continue;

            if(oper.equals("Enter")){
                String msg = userInfo.get(st[1]) + "님이 들어왔습니다.";
                resultMsg.add(msg);
            }else {
                String msg = userInfo.get(st[1]) + "님이 나갔습니다.";
                resultMsg.add(msg);
            }
        }

        String[] answer = new String[resultMsg.size()];
        for(int i = 0; i < resultMsg.size(); i++) {
            answer[i] = resultMsg.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        String [] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        OpenChat op = new OpenChat();
        String [] result = op.solution(record);

        for(String msg : result){
            System.out.println(msg);
        }
    }
}