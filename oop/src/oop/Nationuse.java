package oop;

public class Nationuse {

  public static void main(String[] args) {
    Nation nation = new Nation();
    String country = nation.getNation("KOR");
  //String country = "�ѱ�";
    System.out.println(country);
    
    country = nation.getNation("JAP");
    System.out.println(country);
    
    country = nation.getNation("CHN");
    System.out.println(country);
    
    country = nation.getNation("USA");
    System.out.println(country);
    
    
    
    int gdpUSD = nation.getGDP("KOR");
    System.out.println(gdpUSD);
    
    System.out.println(nation.getGDP("JAP"));
    
    //���� ��ü, �޼ҵ带 1ȸ�� ȣ���ϴ� ���
    System.out.println(new Nation().getGDP("CHN"));
    
    //���� ��ü, �޼ҵ带 1ȸ�� ȣ���ϴ� ���
    gdpUSD = new Nation().getGDP("DEU");
    System.out.println(gdpUSD);
    
    System.out.println();
    System.out.println(nation.getMinWage("KOR"));
    System.out.println(nation.getMinWage("JAP"));
    System.out.println(nation.getMinWage("CHN"));
    System.out.println(nation.getMinWage("USA"));
    System.out.println(nation.getMinWage("CAN"));
    
    
  }
  

}
