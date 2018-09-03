package jdbc;
 
public class StringTest {
 
  public static void main(String[] args) {
    String str1 = "java";
    String str2 = new String("java");
    String str3 = new String("�մ���");
    String str4 = new String("�Ʒι�");
    String str5 = new String("����");
    
    System.out.println("1) " + str1);
    System.out.println("2) " + str2);
    
    System.out.println("3) " + str1.hashCode());
    System.out.println("4) " + str2.hashCode());
    System.out.println("5) " + "java".hashCode());
    
    if (str1 == "java") {
      System.out.println("6) java");
    }
    
    // new�� �̿��ϸ� ��ü�� �����ϸ� '==' �����ڷ� �� �񱳸� ���ϰ� ���� ����
    if (str2 == "java") { 
      System.out.println("7) java");
    } else {
      System.out.println("7) java�� �ƴմϴ�.");
    }
    
    if (str2.equals("java")) {
      System.out.println("8) java");
    }
    
    System.out.println("--------------------------");
    String dev = "";
    System.out.println("9) " + dev.hashCode());
    
    dev = dev + "java";
    System.out.println("10) " + dev.hashCode());
    
    dev = dev + "jsp";
    System.out.println("11) " + dev.hashCode());
 
    dev = dev + "spring";
    System.out.println("12) " + dev.hashCode());
    System.out.println(dev);
    System.out.println("--------------------------");
    
    StringBuffer sb = new StringBuffer();
    sb.append("");
    System.out.println("13) " + sb.hashCode());
    sb.append("java");
    System.out.println("14) " + sb.hashCode());
    sb.append("jsp");
    System.out.println("15) " + sb.hashCode());
    sb.append("spring");
    System.out.println("16) " + sb.hashCode());    
    System.out.println(sb.toString());
  }
 
}