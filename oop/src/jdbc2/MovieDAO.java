package jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieDAO {
  Connection con = null;              // DBMS ����
  PreparedStatement pstmt = null; // SQL ����
  ResultSet rs = null;                   // SELECT ����� ����
  StringBuffer sql = null;              // SQL ����
  int count = 0;                         // ó���� ���ڵ� ����

  String className = "org.gjt.mm.mysql.Driver"; // MySQL ���� Drvier 
  String url = "jdbc:mysql://localhost:3306/javadb?useUnicode=true&characterEncoding=euckr"; 
  String user = "root"; 
  String password = "1234";

  /**
   *  ���
   */
  public int  create(MovieVO movieVO) {
    try {
      Class.forName(className); // ���ڿ��� �� Ŭ�������� �޸𸮿� ����
      con = DriverManager.getConnection(url, user, password); // DBMS�� ����
      sql = new StringBuffer();
      sql.append("INSERT INTO movie(title, good, name, rdate)");
      sql.append("VALUES(?, ?, ?, now())");

      pstmt = con.prepareStatement(sql.toString()); // SQL ���� ��ü ����
      pstmt.setString(1, movieVO.getTitle());
      pstmt.setDouble(2, movieVO.getGood());
      pstmt.setString(3, movieVO.getName());
      count = pstmt.executeUpdate(); // INSERT, UPDATE, DELETE SQL ����

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally{

      try{
        if (pstmt != null){ pstmt.close(); }
      } catch(Exception e){ }

      try{
        if (con != null){ con.close(); }
      } catch(Exception e){ }
    }

    return count;
  }

  public ArrayList<MovieVO>  list() {
    ArrayList<MovieVO> list = new ArrayList<MovieVO>();
    try {
      Class.forName(className); // ���ڿ��� �� Ŭ�������� �޸𸮿� ����
      con = DriverManager.getConnection(url, user, password); // DBMS�� ����
      sql = new StringBuffer();
      sql.append(" SELECT movieno, title, good, name, rdate");
      sql.append(" FROM movie");
      sql.append(" ORDER BY movieno DESC");

      pstmt = con.prepareStatement(sql.toString()); // SQL ���� ��ü ����
      rs = pstmt.executeQuery(); // SELECT

      // true�� ��� ��ȯ, ���ڵ尡 �ִ��� �˻�
      // next() ���� ȣ��ô� ù��° ���ڵ�� �̵�
      // next() �ι��� ȣ����ʹ� ���� ���ڵ�� �̵��Ͽ� ������ ���ڵ���� �̵�
      while(rs.next()) {
        MovieVO movieVO = new MovieVO();

        movieVO.setMovieno(rs.getInt("movieno"));
        movieVO.setTitle(rs.getString("title"));
        movieVO.setName(rs.getString("name"));
        movieVO.setGood(rs.getDouble("good"));
        movieVO.setRdate(rs.getString("rdate").substring(0, 10));

        list.add(movieVO); 
      }

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally{
      try{
        if (rs != null){ rs.close(); }
      } catch(Exception e){ }
      try{
        if (pstmt != null){ pstmt.close(); }
      } catch(Exception e){ }

      try{
        if (con != null){ con.close(); }
      } catch(Exception e){ }
    }
    return list;

  }

  /**
   * ��ȸ
   * @param movieno ��ȸ�� ��ȣ
   */
  public MovieVO read(int movieno) {
    MovieVO movieVO = null; //�޼ҵ�� �Ǿտ� ����

    try {
      Class.forName(className); // ���ڿ��� �� Ŭ�������� �޸𸮿� ����
      con = DriverManager.getConnection(url, user, password); // DBMS�� ����
      sql = new StringBuffer();
      sql.append(" SELECT movieno, title, good, name, rdate");
      sql.append(" FROM movie");
      sql.append(" WHERE movieno = ?");

      pstmt = con.prepareStatement(sql.toString()); // SQL ���� ��ü ����
      pstmt.setInt(1, movieno);
      rs = pstmt.executeQuery(); // SELECT

      // true�� ��� ����, ���ڵ尡 �ִ��� �˻�
      // next() ���� ȣ��ô� ù��° ���ڵ�� �̵�
      // next() �ι��� ȣ����ʹ� ���� ���ڵ�� �̵��Ͽ� ������ ���ڵ���� �̵�
      if (rs.next()) {
        movieVO = new MovieVO();
        movieVO.setMovieno(rs.getInt("movieno"));
        movieVO.setTitle(rs.getString("title"));
        movieVO.setName(rs.getString("name"));
        movieVO.setGood(rs.getDouble("good"));
        movieVO.setRdate(rs.getString("rdate").substring(0, 10));
      }

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally{
      try{
        if (rs != null){ rs.close(); }
      } catch(Exception e){ }
      try{
        if (pstmt != null){ pstmt.close(); }
      } catch(Exception e){ }

      try{
        if (con != null){ con.close(); }
      } catch(Exception e){ }
    }
    return movieVO;

  }

  /**
   *  ���
   * @param movieno ��ȭ��ȣ
   * @param title ��ȭ��
   * @param good ����
   * @param name �ֿ�
   */
  public int  update(MovieVO movieVO) {
    try {
      Class.forName(className); // ���ڿ��� �� Ŭ�������� �޸𸮿� ����
      con = DriverManager.getConnection(url, user, password); // DBMS�� ����
      sql = new StringBuffer();
      sql.append(" UPDATE movie");
      sql.append(" SET title = ?, good = ?, name = ?");
      sql.append(" WHERE movieno = ?");

      pstmt = con.prepareStatement(sql.toString()); // SQL ���� ��ü ����
      pstmt.setString(1, movieVO.getTitle());
      pstmt.setDouble(2, movieVO.getGood());
      pstmt.setString(3, movieVO.getName());
      pstmt.setInt(4, movieVO.getMovieno());

      count = pstmt.executeUpdate(); // INSERT, UPDATE, DELETE SQL ����

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally{
      try{
        if (pstmt != null){ pstmt.close(); }
      } catch(Exception e){ }

      try{
        if (con != null){ con.close(); }
      } catch(Exception e){ }
    }
    return count;
  }

  public int delete(int movieno) {
    try {
      Class.forName(className); // ���ڿ��� �� Ŭ�������� �޸𸮿� ����
      con = DriverManager.getConnection(url, user, password); // DBMS�� ����
      sql = new StringBuffer();
      sql.append(" DELETE FROM movie");
      sql.append(" WHERE movieno = ?");

      pstmt = con.prepareStatement(sql.toString()); // SQL ���� ��ü ����
      pstmt.setInt(1, movieno);

      count = pstmt.executeUpdate(); // INSERT, UPDATE, DELETE SQL ����

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally{

      try{
        if (pstmt != null){ pstmt.close(); }
      } catch(Exception e){ }

      try{
        if (con != null){ con.close(); }
      } catch(Exception e){ }
    }
    return count;
  }
}