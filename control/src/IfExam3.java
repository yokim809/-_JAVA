
public class IfExam3 {

  public static void main(String[] args) {
    int su = Integer.parseInt(args[0]);
    String str = "";
    
    if(su>=0 && su<=9) {
      str = "1�� �ڸ�";
    } else if(su>=10 && su<=99) {
      str = "10�� �ڸ�";
    } else if(su>=100 && su<=999) {
      str = "100�� �ڸ�";
    }  else if(su>=1000) {
      str = "1000�� �ڸ� �̻�";
    } else {
      str = "����";
    }
    
   System.out.println("����:" + su);
   System.out.println(str);
  }

}
