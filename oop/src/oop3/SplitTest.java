package oop3;

public class SplitTest {

  public static void main(String[] args) {
    String[] list = "봄,여름,가을,겨울".split(",");
    System.out.println(list.length);
    
    for(int i=0;i<list.length;i++) { // index 0 ~ 3
      System.out.println(list[i]);  
    }
    
    System.out.println("-----------------------------------");
    
    list = "봄, ,가을,겨울".split(",");
    System.out.println(list.length);
    
    for(int i=0;i<list.length;i++) { // index 0 ~ 3
      System.out.println("-->" + list[i]);  
    }
    
    System.out.println("-----------------------------------");
    
    //2차 그룹화
    String menu = "라면,만두,김밥/김치 찌게,참치 찌게,부대 찌게";
    String[] group = menu.split("/");   //1차 분할
    
    for(int i=0;i<group.length;i++) {
      System.out.println(group[i]);
      
      String[] item =group[i].split(",");   //2차 분할
        for(int j=0; j < item.length;j++) {
          System.out.println((j+1) + ". "+ item[j]);
        }
    }
  }

}
