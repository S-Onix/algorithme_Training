package programmers;

public class BracketConverter {
    public String solution(String p) {
        String answer = splitStr(p);
        return answer;
    }

    public String splitStr(String w) {
        int leftCnt=0;
        int rightCnt = 0;
        String u = "";
        String v = "";

        if(w.length() == 0) {
            return "";
        }

        for(int i=0 ; i < w.length(); i++){
            if(w.charAt(i) == '('){
                leftCnt++;
            }else {
                rightCnt++;
            }

            if(leftCnt == rightCnt) {
                u = w.substring(0, i+1);
                v = w.substring(i+1, w.length());

                if(isCorrectStr(u)){
                    u += splitStr(v);
                    return u;
                }else {
                    String result ="(";
                    result += splitStr(v);
                    result += ")";
                    u = u.substring(1, u.length()-1);

                    for(int j = 0; j < u.length(); j++) {
                        if(u.charAt(j) == '('){
                            result += ")";
                        }else {
                            result += "(";
                        }
                    }
                    return result;
                }
            }
        }
        return "";

    }

    public boolean isCorrectStr(String u) {
        int check = 0;
        for(int j = 0; j < u.length(); j++) {
            if(u.charAt(j) == '('){
                check++;
            }else {
                check--;
            }

            if(check < 0) return false;
        }
        return true;
    }
}
