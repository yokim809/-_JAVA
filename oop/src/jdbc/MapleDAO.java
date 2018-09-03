package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class MapleDAO {
  DecimalFormat df = new DecimalFormat("��#,###,###,###��");
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
      sql.append(" INSERT INTO maple(mountain, mapledate, price, count, total, rdate)");
      sql.append(" VALUES('�����', now(), 50000, 4, (price * count), now())");

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
   * 
   * @param mountain
   * @param price
   * @param count
   */
  public void create(String mountain, int price, int count) {
    try {
      Class.forName(className); // ���ڿ��� �� Ŭ�������� �޸𸮿� ����
      con = DriverManager.getConnection(url, user, password); // DBMS�� ����
      sql = new StringBuffer();
      sql.append(" INSERT INTO maple(mountain, mapledate, price, count, total, rdate)");
      sql.append(" VALUES(?, now(), ?, ?, (price * count), now())");

      pstmt = con.prepareStatement(sql.toString()); // SQL ���� ��ü ����
      pstmt.setString(1, mountain);
      pstmt.setInt(2, price);
      pstmt.setInt(3, count);
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
      sql.append(" SELECT mapleno, mountain, mapledate, price, count, total, rdate");
      sql.append(" FROM maple");
      sql.append(" ORDER BY mapleno ASC");

      pstmt = con.prepareStatement(sql.toString()); // SQL ���� ��ü ����
      rs = pstmt.executeQuery(); // SELECT

      // true�� ��� ��ȯ, ���ڵ尡 �ִ��� �˻�
      // next() ���� ȣ��ô� ù��° ���ڵ�� �̵�
      // next() �ι��� ȣ����ʹ� ���� ���ڵ�� �̵��Ͽ� ������ ���ڵ���� �̵�
      while(rs.next()) {
        System.out.println("������: " + rs.getString("mountain"));
        System.out.println("��¥: " + rs.getString("mapledate").substring(5,7) +"��" + rs.getString("rdate").substring(8, 10) + "��");
        System.out.println("ȸ��: " + df.format(rs.getInt("price")));
        System.out.println("�ο���: " + rs.getString("count") + "��");
        System.out.println("�ѱݾ�: " + df.format(rs.getInt("total")));
        System.out.println("��� ��¥: " +rs.getString("rdate").substring(0, 10));
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
  
  public void read(int mapleno) {
    try {
      Class.forName(className); // ���ڿ��� �� Ŭ�������� �޸𸮿� ����
      con = DriverManager.getConnection(url, user, password); // DBMS�� ����
      sql = new StringBuffer();
      sql.append(" SELECT mapleno, mountain, mapledate, price, count, total, rdate");
      sql.append(" FROM maple");
      sql.append(" WHERE mapleno = ?");

      pstmt = con.prepareStatement(sql.toString()); // SQL ���� ��ü ����
      pstmt.setInt(1, mapleno);
      rs = pstmt.executeQuery(); // SELECT

      // true�� ��� ��ȯ, ���ڵ尡 �ִ��� �˻�
      // next() ���� ȣ��ô� ù��° ���ڵ�� �̵�
      // next() �ι��� ȣ����ʹ� ���� ���ڵ�� �̵��Ͽ� ������ ���ڵ���� �̵�
      while(rs.next()) {
        System.out.println("������: " + rs.getString("mountain"));
        System.out.println("��¥: " + rs.getString("mapledate").substring(5,7) +"��" + rs.getString("rdate").substring(8, 10) + "��");
        System.out.println("ȸ��: " + df.format(rs.getInt("price")));
        System.out.println("�ο���: " + rs.getString("count") + "��");
        System.out.println("�ѱݾ�: " + df.format(rs.getInt("total")));
        System.out.println("��� ��¥: " +rs.getString("rdate").substring(0, 10));
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
  
  public void update(int mapleno, String mountain, int price, int count) {
    try {
      Class.forName(className); // ���ڿ��� �� Ŭ�������� �޸𸮿� ����
      con = DriverManager.getConnection(url, user, password); // DBMS�� ����
      sql = new StringBuffer();
      sql.append(" UPDATE maple");
      sql.append(" SET mountain = ?, price = ?, count = ?, total = (price * count)");
      sql.append(" WHERE mapleno = ?");

      pstmt = con.prepareStatement(sql.toString()); // SQL ���� ��ü ����
      pstmt.setString(1, mountain);
      pstmt.setInt(2, price);
      pstmt.setInt(3, count);
      pstmt.setInt(4, mapleno);
      count = pstmt.executeUpdate();

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
  
  public void delete(int mapleno) {
    try {
      Class.forName(className); // ���ڿ��� �� Ŭ�������� �޸𸮿� ����
      con = DriverManager.getConnection(url, user, password); // DBMS�� ����
      sql = new StringBuffer();
      sql.append(" DELETE FROM maple");
      sql.append(" WHERE mapleno = ?");

      pstmt = con.prepareStatement(sql.toString()); // SQL ���� ��ü ����
      pstmt.setInt(1, mapleno);
      count = pstmt.executeUpdate();

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

}
