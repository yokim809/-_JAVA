package oop2;
 
public class ExceptionUse{
  // MaxException만 전달 가능
  // public void use(int year) throws MaxException  {
  
  // 모든 Exception 전달 가능
  public void use(int year) throws Exception  {
    if ( year == 0) {
      throw new ZeroException();// 특정 조건에 맞는 Exception을 생성
    }
    else if (year < 2017 || year > 2023) {
      // year >= 2017 && year <= 2023가 아닐경우  Exception을 생성
      throw new PeriodException();  // 기간을 벗어났음으로 예외 발생
    } 
  }
 
  //PeriodException만 전달
  public void use2(int year) throws PeriodException  {
    if (year < 2017 || year > 2023) {
      throw new PeriodException(year); // 초기값 전달
    }
  }
}
 
 