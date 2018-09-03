package oop3;

public class SplitTest {

  public static void main(String[] args) {
    String[] list = "��,����,����,�ܿ�".split(",");
    System.out.println(list.length);
    
    for(int i=0;i<list.length;i++) { // index 0 ~ 3
      System.out.println(list[i]);  
    }
    
    System.out.println("-----------------------------------");
    
    list = "��, ,����,�ܿ�".split(",");
    System.out.println(list.length);
    
    for(int i=0;i<list.length;i++) { // index 0 ~ 3
      System.out.println("-->" + list[i]);  
    }
    
    System.out.println("-----------------------------------");
    
    //2�� �׷�ȭ
    String menu = "���,����,���/��ġ ���,��ġ ���,�δ� ���";
    String[] group = menu.split("/");   //1�� ����
    
    for(int i=0;i<group.length;i++) {
      System.out.println(group[i]);
      
      String[] item =group[i].split(",");   //2�� ����
        for(int j=0; j < item.length;j++) {
          System.out.println((j+1) + ". "+ item[j]);
        }
    }
  }

}
