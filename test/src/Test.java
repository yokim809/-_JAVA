
public class Test {

  public static void main(String[] args) {
    //boolean sw = "true";
    boolean sw = true;
    System.out.println("sw");
    System.out.println(sw);
    
    sw = false;
    System.out.println(sw);
    System.out.println("sw="+sw); // 문자열 연결
    
    System.out.println("---------------------");
    //char chr = "A";
    char chr = 'A';
    System.out.println("chr="+chr);
    
    //char chr = '한'; // 중복 선언 안 됨
    chr = '한';
    chr = '韓';
    
    System.out.println(); //줄바꿈
    String movie = "부산행";
    System.out.println("movie="+movie);
    
    movie = "컨저링 2";
    String star = "★";
        
    System.out.println(movie + "("+star+star+star+star+star+")"); 
    
    System.out.println("---------------------");
    int payment  = 2000000;
    long pay = payment;    //long(8Byte) <- int(4Byte)
    //int new_pay = pay;    //int(4Byte) <- long(8Byte) ERROR
    
    System.out.println("급여1:" + pay);
    System.out.println("급여2:" + pay + 500000);
    System.out.println("급여3:" + (pay + 500000));
    System.out.println("연봉:" + (pay * 13));
    
    System.out.println("---------------------");
    
    //float f = 1.0; // ERROR
    float f = 1.0f; // 1.0 뒤의 f는 4byte를 의미 
    double d = 1.5; // 8byte
    
    System.out.println("100의 100%:" + (100 * 100/100));
    System.out.println("100의 50%:" + (100 * 50/100));
    System.out.println("100의 50%:" + (100 * (50/100)));
    // 정수 / 정수 = 정수, 소수점 사라짐.
    System.out.println();
    System.out.println("100의 100%:" + (100 * 1));
    System.out.println("100의 100%:" + (100 * 1.0));
    System.out.println("100의 50%:" +  (100 * 0.5));
    System.out.println("100의 95%:" +  (100 * 0.95));
    System.out.println("100의 10%:" +  (100 * 0.1));
    System.out.println("100의 1.96%:" +  (100 * 0.0196));
    System.out.println("100의 1.64%:" +  (100 * 0.0164f));
    System.out.println("100의 1.28%:" +  (100 * 0.0128));
    System.out.println("100의 0.15%:" +  (100 * 0.0015));
    System.out.println("100의 0.075%:" +  (100 * 0.00075));
    
    
    
    
  
  }

}
