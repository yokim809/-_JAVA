
public class IfExam14 {

  public static void main(String[] args) {
    int java = Integer.parseInt(args[0]);
    int jsp = Integer.parseInt(args[1]);
    int spring = Integer.parseInt(args[2]);
    String result = "";
    int total =0;
    int average = 0;
    
    total = java + jsp + spring;
    average = total/3;
    
    if(java >=80 || jsp >=80 || spring >= 80) {
      if(average>=60) {
        result ="합격"; 
      } else {
     result = "평균 점수 미달입니다.";
      }
    } else {
      result = "재심사";
    }

    System.out.println("결과: " + result);
    
  }

}
