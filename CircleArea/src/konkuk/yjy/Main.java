package konkuk.yjy;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    private static final String studentName = "양종열";
    private static final String studentId = "201311225";
    private static Scanner scanner = new Scanner(System.in);

    private static void showInfo() {
        System.out.println(studentId+", "+studentName);
        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
        String todayString = dateFormat.format(today);
        System.out.println(todayString);
    }

    public static void main(String[] args) {
        // write your code here
        showInfo();
        try {
            File file = new File("/Users/carrot/IdeaProjects/CircleArea/src/konkuk/yjy/test.txt");
            Scanner scan = new Scanner(file);
            Scanner scanner = new Scanner(System.in);
            boolean answerCheck[];

            //1. ArrayList 생성
            ArrayList<Word> dic = new ArrayList<>();
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String str = "";
            String eng, kor;
            int lineCount = 0;

            //파일 끝까지 스캔.
            while(scan.hasNextLine ()) {
                str = scan.nextLine();

                eng = str.split(":")[0];
                kor = str.split(":")[1];

                eng = eng.trim();
                kor = kor.trim();

                hashMap.put(eng, kor);

                int splitcount = 0;
                for (int i=0; i<kor.length(); i++) {
                    if (kor.charAt(i)=='/') splitcount++;
                }


                //ArrayList dic에 Word 객체를 add.
                Word word = new Word(eng, kor.split("/")[0]);
                dic.add(word);
                hashMap.put(kor.split("/")[0], eng);
                lineCount++;

                for (int i=1; i<=splitcount; i++) {
                    word = new Word(eng, kor.split("/")[i]);
                    hashMap.put(kor.split("/")[i], eng);
                    dic.add(word);
                    lineCount++;
                }
            }

            //정답 answerCheck 배열 초기화
            answerCheck = new boolean[lineCount];
            Arrays.fill(answerCheck, false);


            while(true) {
                System.out.println("1. 문제 풀기");
                System.out.println("2. 단어 검색");
                System.out.println("3. Exit");

                int menu = scanner.nextInt();

                if (menu == 1) {
                    //2. ArrayList 정답 체크

                    //int[]Q1에 문제 순서 셔플
                    Random r = new Random();
                    int[] Q1 = new int[lineCount];
                    for (int i = 0; i < lineCount; i++) {
                        Q1[i] = r.nextInt(lineCount);
                        for (int j = 0; j < i; j++) {
                            if (Q1[i] == Q1[j]) {
                                i--;
                                break;
                            }
                        }
                    }

                    //객관식 문항 4개, Word의 index를 담는 배열.
                    int[] example = new int[4];
                    int tempIndex, answerIndex;
                    Word correctWord;
                    int userAnswer;
                    for (int i = 0; i < Q1.length; i++) {

                        //정답 단어
                        correctWord = dic.get(Q1[i]);

                        //example[0] 채우기 (정답)
                        example[0] = Q1[i];
                        //example[1]~example[3] 채우기
                        for (int j = 1; j < 4; j++) {
                            example[j] = Q1[r.nextInt(lineCount)];

                            //중복 제거
                            for (int k = 0; k < j; k++) {
                                if (example[j] == example[k]) {
                                    j--;
                                }
                            }

                        }

                        //셔플 (정답 example[0]의 위치만 조정)
                        tempIndex = example[0];
                        answerIndex = r.nextInt(3) + 1;

                        example[0] = example[answerIndex];
                        example[answerIndex] = tempIndex;

                        //문제, 보기 출력
                        System.out.println(correctWord.getKor() + " 을(를) 영어로?");
                        for (int j = 0; j < 4; j++) {
                            System.out.println((j + 1) + " : " + dic.get(example[j]).getEng());
                        }

                        //정답 확인
                        Scanner answerScan = new Scanner(System.in);
                        userAnswer = answerScan.nextInt();

                        if (example[userAnswer - 1] == example[answerIndex]) {
                            System.out.println("정답입니다!");
                        } else {
                            System.out.println("틀렸습니다!");
                        }

                    }
                } else if (menu == 2) {
                    System.out.print("검색하려는 단어를 입력하세요 : ");
                    String word = scanner.next();
                    String result = hashMap.get(word);

                    if (result == null)
                        System.out.println("단어가 없습니다.");
                    else
                        System.out.println(result);
                }
                else {
                    break;
                }

                System.out.println();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

