package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataDAO {
  Connection con = null;              // DBMS ����
  PreparedStatement pstmt = null; // SQL ����
  ResultSet rs = null;                   // SELECT ����� ����
  StringBuffer sql = null;              // SQL ����
  int count = 0;                         // ó���� ���ڵ� ����

  String className = "org.gjt.mm.mysql.Driver"; // MySQL ���� Drvier 
  String url = "jdbc:mysql://localhost:3306/javadb?useUnicode=true&characterEncoding=euckr"; 
  String user = "root"; 
  String password = "1234";
  
  public void create() {
    try {
      Class.forName(className); // ���ڿ��� �� Ŭ�������� �޸𸮿� ����
      con = DriverManager.getConnection(url, user, password); // DBMS�� ����
      sql = new StringBuffer();
      sql.append("INSERT INTO data(name, java, html, css3, tot, avg)");
      sql.append("VALUES('�迵��', 80, 80, 80, 240, 80)");

      pstmt = con.prepareStatement(sql.toString()); // SQL ���� ��ü ����
      count = pstmt.executeUpdate();

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
   * @param name �̸�
   * @param java �ڹ�����
   * @param html html����
   * @param css3 css3����
   * @param tot ����
   * @param avg ���
   */
  public void create(String name, int java, int html, int css3, int tot, int avg) {
    try {
      Class.forName(className); // ���ڿ��� �� Ŭ�������� �޸𸮿� ����
      con = DriverManager.getConnection(url, user, password); // DBMS�� ����
      sql = new StringBuffer();
      sql.append(" INSERT INTO data(name, java, html, css3, tot, avg)");
      sql.append(" VALUES(?, ?, ?, ?, ?, ?)");

      pstmt = con.prepareStatement(sql.toString()); // SQL ���� ��ü ����
      pstmt.setString(1, name);
      pstmt.setInt(2, java);
      pstmt.setInt(3, html);
      pstmt.setInt(4, css3);
      pstmt.setInt(5, tot);
      pstmt.setInt(6, avg);
      count = pstmt.executeUpdate();

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
  
  public void list() {
    try {
      Class.forName(className); // ���ڿ��� �� Ŭ�������� �޸𸮿� ����
      con = DriverManager.getConnection(url, user, password); // DBMS�� ����
      sql = new StringBuffer();
      sql.append(" SELECT datano, name, java, html, css3, tot, avg");
      sql.append(" FROM data");
      sql.append(" ORDER BY datano ASC");

      pstmt = con.prepareStatement(sql.toString()); // SQL ���� ��ü ����
      rs = pstmt.executeQuery(); // SELECT

      // true�� ��� ��ȯ, ���ڵ尡 �ִ��� �˻�
      // next() ���� ȣ��ô� ù��° ���ڵ�� �̵�
      // next() �ι��� ȣ����ʹ� ���� ���ڵ�� �̵��Ͽ� ������ ���ڵ���� �̵�
      while(rs.next()) {
        System.out.print(rs.getInt("datano")+ ". ");
        System.out.print(rs.getString("name") + ": ");
        System.out.print(rs.getInt("java") + ",");
        System.out.print(rs.getInt("html") + ", ");
        System.out.print(rs.getInt("css3") +" ");
        System.out.print("����: " + rs.getInt("tot"));
        System.out.print(", ���: " + rs.getInt("avg"));
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
   * @param datano ��ȸ�� ��ȣ
   */
  public void read(int datano) {
    try {
      Class.forName(className); // ���ڿ��� �� Ŭ�������� �޸𸮿� ����
      con = DriverManager.getConnection(url, user, password); // DBMS�� ����
      sql = new StringBuffer();
      sql.append(" SELECT datano, name, java, html, css3, tot, avg");
      sql.append(" FROM data");
      sql.append(" WHERE datano = ?");

      pstmt = con.prepareStatement(sql.toString()); // SQL ���� ��ü ����
      pstmt.setInt(1, datano);
      rs = pstmt.executeQuery(); // SELECT

      // true�� ��� ��ȯ, ���ڵ尡 �ִ��� �˻�
      // next() ���� ȣ��ô� ù��° ���ڵ�� �̵�
      // next() �ι��� ȣ����ʹ� ���� ���ڵ�� �̵��Ͽ� ������ ���ڵ���� �̵�
      if(rs.next()) {
        System.out.print(rs.getInt("datano")+ ". ");
        System.out.print(rs.getString("name") + ": ");
        System.out.print(rs.getInt("java") + ",");
        System.out.print(rs.getInt("html") + ", ");
        System.out.print(rs.getInt("css3") +" ");
        System.out.print("����: " + rs.getInt("tot"));
        System.out.print(", ���: " + rs.getInt("avg"));
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
   * 
   * @param datano
   * @param name
   * @param java
   * @param html
   * @param css3
   * @param tot
   * @param avg
   */
  public void  update(int datano, String name, int java, int html, int css3, int tot, int avg) {
    try {
      Class.forName(className); // ���ڿ��� �� Ŭ�������� �޸𸮿� ����
      con = DriverManager.getConnection(url, user, password); // DBMS�� ����
      sql = new StringBuffer();
      sql.append(" UPDATE data");
      sql.append(" SET name = ?, java = ?, html = ?, css3 = ?, tot = ?, avg = ?");
      sql.append(" WHERE datano = ?");
      
      pstmt = con.prepareStatement(sql.toString()); // SQL ���� ��ü ����
      pstmt.setString(1, name);
      pstmt.setInt(2, java);
      pstmt.setInt(3, html);
      pstmt.setInt(4, css3);
      pstmt.setInt(5, tot);
      pstmt.setInt(6, avg);
      pstmt.setInt(7, datano);
      
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
  
  public void delete(int datano) {
    try {
      Class.forName(className); // ���ڿ��� �� Ŭ�������� �޸𸮿� ����
      con = DriverManager.getConnection(url, user, password); // DBMS�� ����
      sql = new StringBuffer();
      sql.append(" DELETE FROM data");
      sql.append(" WHERE datano = ?");
      
      pstmt = con.prepareStatement(sql.toString()); // SQL ���� ��ü ����
      pstmt.setInt(1, datano);
      
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
