package jdbc;

public class MovieDAOUse {

  public static void main(String[] args) {
    MovieDAO movieDAO = new MovieDAO();
    //movieDAO.create();
    //movieDAO.create("Ŀ��", 7.9, "���� �Ͻ�");
    //movieDAO.read(5);
    //movieDAO.update(1, "����", 7.5, "�����ں��� ����");
    //movieDAO.delete(4);
    movieDAO.list();
  }

}
