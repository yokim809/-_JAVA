package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
  
  public void  create() {
    try {
      Class.forName(className); // ���ڿ��� �� Ŭ�������� �޸𸮿� ����
      con = DriverManager.getConnection(url, user, password); // DBMS�� ����
      sql = new StringBuffer();
      sql.append("INSERT INTO movie(title, good, name, rdate)");
      sql.append("VALUES('��Ÿ����', 10.0, '�޸� �Ƶ���', now())");

      pstmt = con.prepareStatement(sql.toString()); // SQL ���� ��ü ����
      count = pstmt.executeUpdate(); // INSERT, UPDATE, DELETE SQL ����

      if(count == 1) {
        System.out.println("��� ó�� ����");
      } else {
        System.out.println("��� ó�� ����");
      }

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

  }

  /**
   *  ���
   * @param title ��ȭ��
   * @param good ����
   * @param name �ֿ�
   */
  public void  create(String title, double good, String name) {
    try {
      Class.forName(className); // ���ڿ��� �� Ŭ�������� �޸𸮿� ����
      con = DriverManager.getConnection(url, user, password); // DBMS�� ����
      sql = new StringBuffer();
      sql.append("INSERT INTO movie(title, good, name, rdate)");
      sql.append("VALUES(?, ?, ?, now())");

      pstmt = con.prepareStatement(sql.toString()); // SQL ���� ��ü ����
      pstmt.setString(1, title);
      pstmt.setDouble(2, good);
      pstmt.setString(3, name);
      count = pstmt.executeUpdate(); // INSERT, UPDATE, DELETE SQL ����

      if(count == 1) {
        System.out.println("��� ó�� ����");
      } else {
        System.out.println("��� ó�� ����");
      }

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
  }
  
  public void  list() {
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
        System.out.print(rs.getInt("movieno")+ ". " );
        System.out.print(rs.getString("title") + ": ");
        System.out.print(rs.getString("name"));
        System.out.print("(" + rs.getDouble("good") +") ");
        System.out.print(rs.getString("rdate").substring(0, 10));
        System.out.println();
        System.out.println("����������������������������������������������������");
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

  }
  
  /**
   * ��ȸ
   * @param movieno ��ȸ�� ��ȣ
   */
  public void  read(int movieno) {
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
        System.out.print(rs.getInt("movieno")+ ". " );
        System.out.print(rs.getString("title") + ": ");
        System.out.print(rs.getString("name"));
        System.out.print("(" + rs.getDouble("good") +") ");
        System.out.print(rs.getString("rdate").substring(0, 10));
        System.out.println();
        System.out.println("����������������������������������������������������");
      }
      else {
        System.out.println("��ȸ�Ͻ� ��ȣ�� �����Ͱ� �����ϴ�.");
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

  }

  /**
   *  ���
   * @param movieno ��ȭ��ȣ
   * @param title ��ȭ��
   * @param good ����
   * @param name �ֿ�
   */
  public void  update(int movieno, String title, double good, String name) {
    try {
      Class.forName(className); // ���ڿ��� �� Ŭ�������� �޸𸮿� ����
      con = DriverManager.getConnection(url, user, password); // DBMS�� ����
      sql = new StringBuffer();
      sql.append(" UPDATE movie");
      sql.append(" SET title = ?, good = ?, name = ?");
      sql.append(" WHERE movieno = ?");
      
      pstmt = con.prepareStatement(sql.toString()); // SQL ���� ��ü ����
      pstmt.setString(1, title);
      pstmt.setDouble(2, good);
      pstmt.setString(3, name);
      pstmt.setInt(4, movieno);
      
      count = pstmt.executeUpdate(); // INSERT, UPDATE, DELETE SQL ����

      if(count == 1) {
        System.out.println("���� ó�� ����");
      } else {
        System.out.println("���� ó�� ����");
      }

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
  }
  
  public void delete(int movieno) {
    try {
      Class.forName(className); // ���ڿ��� �� Ŭ�������� �޸𸮿� ����
      con = DriverManager.getConnection(url, user, password); // DBMS�� ����
      sql = new StringBuffer();
      sql.append(" DELETE FROM movie");
      sql.append(" WHERE movieno = ?");
      
      pstmt = con.prepareStatement(sql.toString()); // SQL ���� ��ü ����
      pstmt.setInt(1, movieno);
      
      int cnt = pstmt.executeUpdate(); // INSERT, UPDATE, DELETE SQL ����

      if(cnt == 1) {
        System.out.println("���� ����");
      } else {
        System.out.println("���� ����");
      }

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
  }
}