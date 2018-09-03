package jdbc;

public class PayDAOUse {

  public static void main(String[] args) {
    PayDAO payDAO = new PayDAO();
    //payDAO.create();
    // payDAO.create("김영욱2", 200000, 2, 50000);
    payDAO.list();
   // payDAO.read(3);
    //payDAO.update(2, "아로미", 5000000, 2, 300000);
    // payDAO.delete(1);
  }



}
