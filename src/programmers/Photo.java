package programmers;

public class Photo {
    static int cnt = 0;
    static boolean [] use = new boolean[8];
    static Character [] friends = {'A','C','F','J','M','N','R','T'};

    public boolean isAllPass(String [] data, String photoStand) {
        for(int i = 0 ; i < data.length; i++) {
            if(!isPass(data[i], photoStand)) return false;
        }
        return true;
    }

    public boolean isPass(String data, String photoStand) {
        int position1 = photoStand.indexOf(data.charAt(0));
        int position2 = photoStand.indexOf(data.charAt(2));

        char oper = data.charAt(3);
        int gap = data.charAt(4) - '0';

        if(oper == '='){
            if(!(Math.abs(position1- position2) == gap + 1)) return false;
        }else if(oper == '>'){
            if(!(Math.abs(position1- position2) > gap + 1)) return false;
        }else if(oper == '<'){
            if(!(Math.abs(position1- position2) < gap + 1)) return false;
        }

        return true;
    }

    public void reculSolve(int K, String [] data, String photoStand) {
        if(K == 8) {
            if(isAllPass(data, photoStand)) cnt++;
            return;
        }else {
            for(int cand = 0; cand < 8; cand++){
                if(use[cand]) continue;
                use[cand] = true;
                reculSolve(K+1, data, photoStand + friends[cand]);
                use[cand] = false;
            }
        }
    }

    public int solution(int n, String[] data) {
        cnt = 0;

        reculSolve(0, data, "");
        return cnt;
    }
}
