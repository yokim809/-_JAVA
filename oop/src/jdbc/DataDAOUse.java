package jdbc;

public class DataDAOUse {

  public static void main(String[] args) {
    DataDAO dataDAO = new DataDAO();
    //dataDAO.create();
    //dataDAO.create("�迵��", 80, 80, 80, 240, 80);
    dataDAO.list();
    //dataDAO.read(3);
    //dataDAO.update(3, "�迵��", 80, 80, 80, 240, 80);
    //dataDAO.delete(1);
  }

}
