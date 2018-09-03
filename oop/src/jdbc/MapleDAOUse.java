package jdbc;

public class MapleDAOUse {

  public static void main(String[] args) {
    MapleDAO mapleDAO = new MapleDAO();
    //mapleDAO.create();
    //mapleDAO.create("아차산", 50000, 5);
    mapleDAO.list();
    //mapleDAO.read(1);
    //mapleDAO.update(1, "설악산", 55000, 3);
    //mapleDAO.delete(1);
  }

}
