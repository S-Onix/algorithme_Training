package algorithm_problem.Brute_Force;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Robot {

    //테스트케이스
    private static int tc;

    //맵
    private static int mapSizeX, mapSizeY;
    private static int[][] map;

    //로봇 방향 북,동,남,서
    private static int RobotX, RobotY;
    private static String[] direction = {"N", "E", "S", "W"};
    private static String[] inputRobotOperation;

    //돌림판의 방향
    private static int rotateCount;
    private static Deque<Integer> dq;
    private static String[] rotateValue;
    private static final int CLOCKWISE = 1;
    private static final int REVERSEWISE = 2;

    //결과
    private static int score;


    public static void initMap() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dq = new ArrayDeque<Integer>();
        score = 0;

        //맵크기, 로봇초기위치 설정
        String[] s = br.readLine().split(" ");
        mapSizeX = Integer.parseInt(s[0]);
        mapSizeY = Integer.parseInt(s[1]);
        RobotX = (Integer.parseInt(s[2]) -1);
        RobotY = (Integer.parseInt(s[3]) - 1);

        //맵 선언
        map = new int[mapSizeX][mapSizeY];


        //맵 내용
        for (int i = 0; i < map[0].length; i++) {
            String mapS[] = br.readLine().split(" ");
            for (int j = 0; j < map.length; j++) {
                map[j][i] = Integer.parseInt(mapS[j]);
            }
        }

        printMap(map);

        rotateCount = Integer.parseInt(br.readLine());
        rotateValue = br.readLine().split(" ");
        for (int i = 0; i < rotateCount; i++) {
            dq.add(Integer.parseInt(rotateValue[i]));
        }


    }

    public static void clockwiseRotate(int count) {
        for (int i = 0; i < count; i++) {
            dq.addFirst(dq.pollLast());
        }
    }

    public static void reversewiseRotate(int count) {
        for (int i = 0; i < count; i++) {
            dq.addLast(dq.pollFirst());
        }
    }

    public static void printMap(int[][] array) {
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print("( X : " + j + " " + "Y: " + i  + " ) " +array[j][i] + " ");
            }
            System.out.println();
        }
    }

    public static void solve() throws Exception {
        score = map[RobotX][RobotY];
        map[RobotX][RobotY] = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rotateTime = Integer.parseInt(br.readLine());

        for (int i = 0; i < rotateTime; i++) {
            inputRobotOperation = br.readLine().split(" ");
            operateRobot(inputRobotOperation[0], Integer.parseInt(inputRobotOperation[1]), Integer.parseInt(inputRobotOperation[2]));
        }

    }

    public static void operateRobot(String inputDirection, int isClockwise, int times) {
        int moveCount = 0;

        if (isClockwise == CLOCKWISE) {
            clockwiseRotate(times);
            moveCount = dq.getFirst();
            moveRobot(inputDirection, moveCount);
        }
        else if (isClockwise == REVERSEWISE) {
            reversewiseRotate(times);
            moveCount = dq.getFirst();
            moveRobot(inputDirection, moveCount);
        }
    }

    public static void moveRobot(String tempDirection, int moveTime){
        //이전위치 저장
        int tempX = RobotX;
        int tempY = RobotY;

        //북동남서
        if (tempDirection.equals(direction[0])) {
            while (moveTime > 0) {
                moveTime--;
                if((RobotY - 1) >= 0) {
                    tempY = RobotY;
                    if (map[RobotX][RobotY - 1] != -1) {
                        score += map[RobotX][--RobotY];
                        map[RobotX][RobotY] = 0;
                    } else {
                        RobotX = tempX;
                        RobotY = tempY;
                        break;
                    }
                }
            }
        } else if (tempDirection.equals(direction[1])) {
            while (moveTime > 0) {
                moveTime--;
                if (RobotX + 1 <= mapSizeX - 1) {
                    tempX = RobotX;
                    if (map[RobotX + 1][RobotY] != -1) {
                        score += map[++RobotX][RobotY];
                        map[RobotX][RobotY] = 0;
                    } else {
                        RobotX = tempX;
                        RobotY = tempY;
                        break;
                    }
                }
            }
        } else if (tempDirection.equals(direction[2])) {
            while (moveTime > 0) {
                moveTime--;
                if (RobotY + 1 <= mapSizeY -1) {
                    tempY = RobotY;
                    if(map[RobotX][RobotY+1] != -1){
                        score += map[RobotX][++RobotY];
                        map[RobotX][RobotY] = 0;
                    }else{
                        RobotX = tempX;
                        RobotY = tempY;
                        break;
                    }
                }
            }
        } else if (tempDirection.equals(direction[3])) {
            while (moveTime > 0) {
                moveTime--;

                if (RobotX - 1 >= 0) {
                    tempX = RobotX;
                    if (map[RobotX-1][RobotY] != -1) {
                        score += map[--RobotX][RobotY];
                        map[RobotX][RobotY] = 0;
                    }else{
                        RobotX = tempX;
                        RobotY = tempY;
                        break;
                    }
                }
            }
        } else {
            System.out.println("잘못된입력");
        }

    }

    public static void start() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());
        int tcCount = 0;
        int [] scoreArray = new int[tc];
        int [] robotXArray = new int[tc];
        int [] robotYArray = new int[tc];

        do {
            tc--;
            initMap();
            solve();
            scoreArray[tcCount] = score;
            robotXArray[tcCount] = RobotX;
            robotYArray[tcCount] = RobotY;
            dq.clear();
            tcCount++;
        } while (tc > 0);

        for(int i = 0; i < scoreArray.length; i++){
            System.out.println("#"+ (i+1)+ " " + scoreArray[i] + " " + (robotXArray[i]+1) + " " + (robotYArray[i]+1));
        }

    }

    public static void main(String[] args) throws Exception {
        start();
    }
}