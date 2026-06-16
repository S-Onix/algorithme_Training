package programmers;

import java.util.StringTokenizer;

public class LinuxCommendLine {
    public int solution(String[] commands) {
        int count = 0;
        for (String command : commands) {
            // 여기에 코드를 작성하세요
            /**
             * 리눅스 커맨드 문자열 배열이 주어질 때, 유효한 커맨드의 수를 반환
             *
             * 유효한 커맨드 조건:
             *
             * 첫 번째 토큰은 영소문자로만 구성 >> regex 소문자 검사
             * 옵션은 - 로 시작하고 뒤에 영소문자 1개 이상 >> 두번째 토큰 이상부터 - 여부 확인
             * 인자는 '영소문자', '숫자', '.' , '/' 만 허용
             * 토큰은 공백으로 구분
             * 순서가 보장되야함 command > option > argument
             * */
            String state = "command";
            String [] tokens = command.split(" ");
            boolean isValid = true;

            for(String token : tokens) {

                if(token.isEmpty()) {
                    isValid = false;
                    break;
                }

                if(state.equals("command")) {
                    if(token.matches("[a-z]+")){
                        state = "option";
                    }else {isValid = false; break;}
                }else if (token.charAt(0) == '-') {
                    if(state.equals("argument")) {isValid = false; break;}
                    if(token.matches("-[a-z]+")){
                        state = "option";
                    }else {isValid = false; break;}
                }else {
                    if(!token.matches("[a-z0-9./]+")) {isValid = false; break;}
                    state = "argument";
                }
            }

            if(isValid) count++;

        }
        return count;
    }
}
