package oop3;

public class DataProcess {
  public void swap(Data data) {
    System.out.println("DataProcess: "+ data.hashCode()); //DataProcess: 2018699554
    int temp = data.su1;
    data.su1 = data.su2; //  su1 �� su2 ������ ������ �������.
    data.su2 = temp;    //  su2 �� temp ������ ������ �������.
  }
}
