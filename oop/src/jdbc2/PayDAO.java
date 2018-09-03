package jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

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

  public int create(PayVO payVO) {
    try {
      Class.forName(className); // ���ڿ��� �� Ŭ�������� �޸𸮿� ����
      con = DriverManager.getConnection(url, user, password); // DBMS�� ����
      sql = new StringBuffer();
      sql.append(" INSERT INTO pay(name, basic, year, sudang, salary, rdate)");
      sql.append(" VALUES(?, ?, ?, ?, (basic + sudang), now())");

      pstmt = con.prepareStatement(sql.toString()); // SQL ���� ��ü ����
      pstmt.setString(1, payVO.getName());
      pstmt.setInt(2, payVO.getBasic());
      pstmt.setInt(3, payVO.getYear());
      pstmt.setInt(4, payVO.getSudang());
      count = pstmt.executeUpdate();

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

  public ArrayList<PayVO> list() {
    ArrayList<PayVO> list = new ArrayList<PayVO>();
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
        PayVO payVO = new PayVO();
        payVO.setName(rs.getString("name"));
        payVO.setBasic(rs.getInt("basic"));
        payVO.setYear(rs.getInt("year"));
        payVO.setSudang(rs.getInt("sudang"));
        payVO.setSalary(rs.getInt("salary"));
        payVO.setRdate( rs.getString("rdate"));
        
        list.add(payVO);
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
   * 
   * @param payno
   */
  public PayVO read(int payno) {
    PayVO payVO = null;
    
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
        payVO = new PayVO();
        payVO.setName(rs.getString("name"));
        payVO.setBasic(rs.getInt("basic"));
        payVO.setYear(rs.getInt("year"));
        payVO.setSudang(rs.getInt("sudang"));
        payVO.setSalary(rs.getInt("salary"));
        payVO.setRdate( rs.getString("rdate"));
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
    return payVO;
  }

  /**
   * 
   * @param payno
   * @param name
   * @param basic
   * @param year
   * @param sudang
   */
  public int update(PayVO payVO) {
    try {
      Class.forName(className); // ���ڿ��� �� Ŭ�������� �޸𸮿� ����
      con = DriverManager.getConnection(url, user, password); // DBMS�� ����
      sql = new StringBuffer();
      sql.append(" UPDATE pay");
      sql.append(" SET name = ?, basic = ?, year = ?, sudang = ?, salary = (basic + sudang)");
      sql.append(" WHERE payno = ?");

      pstmt = con.prepareStatement(sql.toString()); // SQL ���� ��ü ����
      pstmt.setString(1, payVO.getName());
      pstmt.setInt(2, payVO.getBasic());
      pstmt.setInt(3, payVO.getYear());
      pstmt.setInt(4, payVO.getSudang());
      pstmt.setInt(5, payVO.getPayno());

      count = pstmt.executeUpdate();

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

  /**
   * 
   * @param payno
   */
  public int delete(int payno) {
    try {
      Class.forName(className); // ���ڿ��� �� Ŭ�������� �޸𸮿� ����
      con = DriverManager.getConnection(url, user, password); // DBMS�� ����
      sql = new StringBuffer();
      sql.append(" DELETE FROM pay");
      sql.append(" WHERE payno = ?;");

      pstmt = con.prepareStatement(sql.toString()); // SQL ���� ��ü ����
      pstmt.setInt(1, payno);

      count = pstmt.executeUpdate();

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
