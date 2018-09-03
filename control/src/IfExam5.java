
public class IfExam5 {

  public static void main(String[] args) {
    int year = Integer.parseInt(args[0]);
    String grade = "";
    String pay = "";
    
    if (year >=0 && year <=5) {
      grade = "초급" ;
      pay = "2300 ~ 4500";
    } else if (year >=6 && year <=8) {
      grade = "중급";
      pay = "4500 ~ 5500";
    } else if (year >=9 && year <=11) {
      grade = "고급";
      pay = "5500 ~ 6500";
    } else if (year >= 12) {
      grade = "특급";
      pay = "6500 ~ 7500";
    }
    
    System.out.println("경력: " + year +" 년");
    System.out.println("등급: " + grade +" 기술자");
    System.out.println("연봉: " + pay);
    
    
    
    
    
    
    

  }


}
