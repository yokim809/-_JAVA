
public class ifTest {

  public static void main(String[] args) {
    int age = 19;
    String vote = (age >= 19) ? "투표가능":"투표 불가능"; // 3항 연산자
    System.out.println(vote);
    
    int tot = 80;
    if(tot >= 80) {
      System.out.println("합격");
      System.out.println("노트북");
    }
    
    int su = 1;
    System.out.println("정수:" + su);
    
    if(su%2 ==0) {
      System.out.println("짝수"); // true
    }  else {
      System.out.println("홀수"); // false
    }
    String month ="";
      if(su == 1) {
        month = "January";
      } else if(su == 2) {
        month = "February";      
      } else if(su ==3) {
        month = "March";
      } else {
        month = "1~3을 입력해주세요.";
      }
 
      System.out.println(month);
  
      String korean = "'";
        if(month.equals("January")){  // month == "January" 와 같은 맥락
          korean = "1월 신정";
        } else if (month.equals("February")) { // month == "February" 와 같은 맥락
          korean = "2월 설날";
        } else if (month.equals("March")) {
          korean = "3월 꽃";
        } else {
          korean = "해당자료 없음";
        }
        
        System.out.println(korean);
        
        int test = 85;
        if(test >= 60) {
          System.out.println("합격입니다.");
          
          if(test >=80) {
            System.out.println("-> 프로젝트 투입");  //85~
          } else {
            System.out.println("-> 추가교육 실시"); //60~84
          }
          
        } else {
          System.out.println("불합격입니다."); //~59
        }
        
        String grade ="";
        if(test >= 90) {
          grade = "A";
        } else if(test >= 80 && test <=89) { // && ->and
          grade = "B";
        } else if(test >= 70 && test <=79) { // && ->and
          grade = "C";
        } else if(test >= 60 && test <=69) { // && ->and
          grade = "D";
        } else {
          grade = "F";
        }
        
        System.out.println("grade:" + grade);
        
        int season = 7;
        if(season ==6 || season == 7 || season ==8) { // || ->or
          System.out.println("여름입니다.");
        }
  
  }
}

