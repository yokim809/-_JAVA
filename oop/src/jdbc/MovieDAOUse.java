package jdbc;

public class MovieDAOUse {

  public static void main(String[] args) {
    MovieDAO movieDAO = new MovieDAO();
    //movieDAO.create();
    //movieDAO.create("커터", 7.9, "리암 니슨");
    //movieDAO.read(5);
    //movieDAO.update(1, "위자", 7.5, "엘리자베스 리저");
    //movieDAO.delete(4);
    movieDAO.list();
  }

}
