package oop;

public class Nation {

  public String getNation(String code) {
    String str="";
    
    if(code.equals("KOR") == true) {
      str = "한국";
    } else if (code.equals("JAP") == true) {
      str = "일본"; 
    } else if (code.equals("CHN") == true) {
      str = "중국"; 
    } else {
      str = "미지원 국가";
    }
    
    return str;
    
    
    
  } 
  
  public int getGDP(String code) {
    int gdp = 0;
    
    if(code.equals("KOR") == true) {
      gdp = 29743;
    } else if (code.equals("JAP") == true) {
      gdp = 38464; 
    } else if (code.equals("CHN") == true) {
      gdp = 8830; 
    } else if (code.equals("DEU") == true) {
      gdp = 44481; 
    }
    
    return gdp;
  
  } 
  
  public int getMinWage(String code) {
    int wage = 0;
    
    if(code.equals("KOR") == true) {
      wage = 6470;
    } else if (code.equals("JAP") == true) {
      wage = 8430; 
    } else if (code.equals("CHN") == true) {
      wage = 1799; 
    } else if (code.equals("USA") == true) {
      wage = 11000; 
    } else if (code.equals("CAN") == true) {
      wage = 11000; 
    }
    
    return wage;
  
  } 
  
  
}
