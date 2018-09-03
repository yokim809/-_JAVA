package oop3;

public class DataTest {

  public static void main(String[] args) {
// Ŭ���� ��ü = �޸��Ҵ� ������
    Data    data =    new       Data();
    data.su1 = 2016;
    data.su2 = 2017;
    
    System.out.println("DataTest: "+ data.hashCode()); //DataTest: 2018699554
    System.out.println("su1: " + data.su1); // 2016
    System.out.println("su2: " + data.su2); // 2017
    System.out.println("===============");
    
    DataProcess dp = new DataProcess();
    dp.swap(data);

    System.out.println("su1: " + data.su1); // 2017
    System.out.println("su2: " + data.su2); // 2016
    System.out.println("===============");
  
    //�����ڸ� �̿��Ͽ� Data class ��ü�� ����
    Data data2 = new Data(10,20);
    dp.swap(data2);
    System.out.println("su1: " + data2.su1); 
    System.out.println("su2: " + data2.su2); 
    System.out.println("===============");
  }

}
