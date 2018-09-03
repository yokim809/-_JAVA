package oop3;

public class DataProcess {
  public void swap(Data data) {
    System.out.println("DataProcess: "+ data.hashCode()); //DataProcess: 2018699554
    int temp = data.su1;
    data.su1 = data.su2; //  su1 은 su2 변수의 값으로 덮어써짐.
    data.su2 = temp;    //  su2 은 temp 변수의 값으로 덮어써짐.
  }
}
