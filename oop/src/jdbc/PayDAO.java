package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class PayDAO {
  DecimalFormat df = new DecimalFormat("�� #,###,###,### ��");
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
      sql.append(" INSERT INTO pay(name, basic, year, sudang, salary, rdate)");
      sql.append(" VALUES('�迵��', 1500000, 2, 500000, (basic + sudang), now())");

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

  public void create(String name, int basic, int year, int sudang) {
    try {
      Class.forName(className); // ���ڿ��� �� Ŭ�������� �޸𸮿� ����
      con = DriverManager.getConnection(url, user, password); // DBMS�� ����
      sql = new StringBuffer();
      sql.append(" INSERT INTO pay(name, basic, year, sudang, salary, rdate)");
      sql.append(" VALUES(?, ?, ?, ?, (basic + sudang), now())");

      pstmt = con.prepareStatement(sql.toString()); // SQL ���� ��ü ����
      pstmt.setString(1, name);
      pstmt.setInt(2, basic);
      pstmt.setInt(3, year);
      pstmt.setInt(4, sudang);
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
      sql.append(" SELECT payno, name, basic, year, sudang, salary, rdate");
      sql.append(" FROM pay");
      sql.append(" ORDER BY payno ASC");

      pstmt = con.prepareStatement(sql.toString()); // SQL ���� ��ü ����
      rs = pstmt.executeQuery(); // SELECT

      // true�� ��� ��ȯ, ���ڵ尡 �ִ��� �˻�
      // next() ���� ȣ��ô� ù��° ���ڵ�� �̵�
      // next() �ι��� ȣ����ʹ� ���� ���ڵ�� �̵��Ͽ� ������ ���ڵ���� �̵�
      while(rs.next()) {
        System.out.println("����: " + rs.getString("name"));
        System.out.println("�⺻��: " + df.format(rs.getInt("basic")) );
        System.out.println("���: " + rs.getInt("year") + "��");
        System.out.println("����: " + df.format(rs.getInt("sudang")));
        System.out.println("�޿�: " + df.format(rs.getInt("salary")));
        System.out.println("��ϳ�¥: "+ rs.getString("rdate").substring(0, 10));
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
   * 
   * @param payno
   */
  public void read(int payno) {
    try {
      Class.forName(className); // ���ڿ��� �� Ŭ�������� �޸𸮿� ����
      con = DriverManager.getConnection(url, user, password); // DBMS�� ����
      sql = new StringBuffer();
      sql.append(" SELECT payno, name, basic, year, sudang, salary, rdate");
      sql.append(" FROM pay");
      sql.append(" WHERE payno = ?");

      pstmt = con.prepareStatement(sql.toString()); // SQL ���� ��ü ����
      pstmt.setInt(1, payno);
      rs = pstmt.executeQuery(); // SELECT
      // true�� ��� ��ȯ, ���ڵ尡 �ִ��� �˻�
      // next() ���� ȣ��ô� ù��° ���ڵ�� �̵�
      // next() �ι��� ȣ����ʹ� ���� ���ڵ�� �̵��Ͽ� ������ ���ڵ���� �̵�
      if(rs.next()) {
        System.out.println("����: " + rs.getString("name"));
        System.out.println("�⺻��: " + df.format(rs.getInt("basic")) );
        System.out.println("���: " + rs.getInt("year") + "��");
        System.out.println("����: " + df.format(rs.getInt("sudang")));
        System.out.println("�޿�: " + df.format(rs.getInt("salary")));
        System.out.println("��ϳ�¥: "+ rs.getString("rdate").substring(0, 10));
        System.out.println("����������������������������������������������������");
      } else {
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
   * @param payno
   * @param name
   * @param basic
   * @param year
   * @param sudang
   */
  public void update(int payno, String name, int basic, int year, int sudang) {
    try {
      Class.forName(className); // ���ڿ��� �� Ŭ�������� �޸𸮿� ����
      con = DriverManager.getConnection(url, user, password); // DBMS�� ����
      sql = new StringBuffer();
      sql.append(" UPDATE pay");
      sql.append(" SET name = ?, basic = ?, year = ?, sudang = ?, salary = (basic + sudang)");
      sql.append(" WHERE payno = ?");

      pstmt = con.prepareStatement(sql.toString()); // SQL ���� ��ü ����
      pstmt.setString(1, name);
      pstmt.setInt(2, basic);
      pstmt.setInt(3, year);
      pstmt.setInt(4, sudang);
      pstmt.setInt(5, payno);

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

  /**
   * 
   * @param payno
   */
  public void delete(int payno) {
    try {
      Class.forName(className); // ���ڿ��� �� Ŭ�������� �޸𸮿� ����
      con = DriverManager.getConnection(url, user, password); // DBMS�� ����
      sql = new StringBuffer();
      sql.append(" DELETE FROM pay");
      sql.append(" WHERE payno = ?;");

      pstmt = con.prepareStatement(sql.toString()); // SQL ���� ��ü ����
      pstmt.setInt(1, payno);

      count = pstmt.executeUpdate();

      if(count == 1) {
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
