public class DevEnvironment {
 
  public static void main(String[] args) {
    String[] dev = new String[5];
    dev[0] = "JAVA";
    dev[1] = "HTML5";
    dev[2] = "CSS3";
    dev[3] = "Javascript";
    dev[4] = "JSP";
    
    System.out.println(dev[0]);
    System.out.println(dev[1]);
    System.out.println(dev[2]);
    System.out.println(dev[3]);
    System.out.println(dev[4]);
    System.out.println("배열의 크기: " + dev.length);
    System.out.println("-------------------");
    
    int num = 0;
    
    int[] years = new int[5];
    years[0] = 2013;
    years[1] = 2014;
    years[2] = 2015;
    years[3] = 2016;
    years[4] = 2017;
    
    while(true) {
      System.out.println(years[num]); 
      if(num == 4) {
        break;
      }
      num = num+1;
    }
    
  }
 
}
  