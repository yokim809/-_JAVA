
public class IfExam13 {

  public static void main(String[] args) {
    int java = Integer.parseInt(args[0]);
    int jsp = Integer.parseInt(args[1]);
    int spring = Integer.parseInt(args[2]);
    String result = "";
    
    if(java >=80 || jsp >=80 || spring >= 80) {
     result = "�հ�";
    } else {
      result = "��ɻ�";
    }

    System.out.println("���: " + result);
    
  }

}
