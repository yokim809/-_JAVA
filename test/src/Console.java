
public class Console {

  public static void main(String[] args) {

//    System.out.println(1+1+1);  // 3
//    System.out.println("1" + "1" + "1");   // 111
//    System.out.println(Integer.parseInt("1") + Integer.parseInt("1"));  //2
    
    String name = args[0]; //¿Õ´«ÀÌ
    int java = Integer.parseInt(args[1]);
    int jsp = Integer.parseInt(args[2]);
    int spring = Integer.parseInt(args[3]);
    
    int tot = java + jsp + spring;
    int avg = tot / 3;
    
    System.out.println(name);
    System.out.println(tot +" / " + avg);
  }

}
