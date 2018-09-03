package oop2;
 
public class ExceptionUse{
  // MaxException�� ���� ����
  // public void use(int year) throws MaxException  {
  
  // ��� Exception ���� ����
  public void use(int year) throws Exception  {
    if ( year == 0) {
      throw new ZeroException();// Ư�� ���ǿ� �´� Exception�� ����
    }
    else if (year < 2017 || year > 2023) {
      // year >= 2017 && year <= 2023�� �ƴҰ��  Exception�� ����
      throw new PeriodException();  // �Ⱓ�� ��������� ���� �߻�
    } 
  }
 
  //PeriodException�� ����
  public void use2(int year) throws PeriodException  {
    if (year < 2017 || year > 2023) {
      throw new PeriodException(year); // �ʱⰪ ����
    }
  }
}
 
 