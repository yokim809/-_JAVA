
public class IfExam3 {

  public static void main(String[] args) {
    int su = Integer.parseInt(args[0]);
    String str = "";
    
    if(su>=0 && su<=9) {
      str = "1의 자리";
    } else if(su>=10 && su<=99) {
      str = "10의 자리";
    } else if(su>=100 && su<=999) {
      str = "100의 자리";
    }  else if(su>=1000) {
      str = "1000의 자리 이상";
    } else {
      str = "음수";
    }
    
   System.out.println("정수:" + su);
   System.out.println(str);
  }

}
