package jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
  
  /**
   * @param name �̸�
   * @param java �ڹ�����
   * @param html html����
   * @param css3 css3����
   * @param tot ����
   * @param avg ���
   */
  public int create(DataVO dataVO) {
    try {
      Class.forName(className); // ���ڿ��� �� Ŭ�������� �޸𸮿� ����
      con = DriverManager.getConnection(url, user, password); // DBMS�� ����
      sql = new StringBuffer();
      sql.append(" INSERT INTO data(name, java, html, css3, tot, avg)");
      sql.append(" VALUES(?, ?, ?, ?, ?, ?)");

      pstmt = con.prepareStatement(sql.toString()); // SQL ���� ��ü ����
      pstmt.setString(1, dataVO.getName());
      pstmt.setInt(2, dataVO.getJava());
      pstmt.setInt(3, dataVO.getHtml());
      pstmt.setInt(4, dataVO.getCss3());
      pstmt.setInt(5, dataVO.getTot());
      pstmt.setInt(6, dataVO.getAvg());
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
  
  public ArrayList<DataVO> list() {
    ArrayList<DataVO> list = new ArrayList<DataVO>();
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
        DataVO dataVO = new DataVO();
        dataVO.setDatano(rs.getInt("datano"));
        dataVO.setName(rs.getString("name"));
        dataVO.setJava(rs.getInt("java"));
        dataVO.setHtml(rs.getInt("html"));
        dataVO.setCss3(rs.getInt("css3"));
        dataVO.setTot(rs.getInt("tot"));
        dataVO.setAvg(rs.getInt("avg"));

        list.add(dataVO);
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
   * @param datano ��ȸ�� ��ȣ
   */
  public DataVO read(int datano) {
    DataVO dataVO = null;
    
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
        dataVO = new DataVO();
        dataVO.setDatano(rs.getInt("datano"));
        dataVO.setName(rs.getString("name"));
        dataVO.setJava(rs.getInt("java"));
        dataVO.setHtml(rs.getInt("html"));
        dataVO.setCss3(rs.getInt("css3"));
        dataVO.setTot(rs.getInt("tot"));
        dataVO.setAvg(rs.getInt("avg"));
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
    return dataVO;
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
  public int update(DataVO dataVO) {
    try {
      Class.forName(className); // ���ڿ��� �� Ŭ�������� �޸𸮿� ����
      con = DriverManager.getConnection(url, user, password); // DBMS�� ����
      sql = new StringBuffer();
      sql.append(" UPDATE data");
      sql.append(" SET name = ?, java = ?, html = ?, css3 = ?, tot = ?, avg = ?");
      sql.append(" WHERE datano = ?");
      
      pstmt = con.prepareStatement(sql.toString()); // SQL ���� ��ü ����
      pstmt.setString(1, dataVO.getName());
      pstmt.setInt(2, dataVO.getJava());
      pstmt.setInt(3, dataVO.getHtml());
      pstmt.setInt(4, dataVO.getCss3());
      pstmt.setInt(5, dataVO.getTot());
      pstmt.setInt(6, dataVO.getAvg());
      pstmt.setInt(7, dataVO.getDatano());
      
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
  
  public int delete(int datano) {
    try {
      Class.forName(className); // ���ڿ��� �� Ŭ�������� �޸𸮿� ����
      con = DriverManager.getConnection(url, user, password); // DBMS�� ����
      sql = new StringBuffer();
      sql.append(" DELETE FROM data");
      sql.append(" WHERE datano = ?");
      
      pstmt = con.prepareStatement(sql.toString()); // SQL ���� ��ü ����
      pstmt.setInt(1, datano);
      
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
