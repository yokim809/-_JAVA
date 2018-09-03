package jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataDAO {
  Connection con = null;              // DBMS 연결
  PreparedStatement pstmt = null; // SQL 실행
  ResultSet rs = null;                   // SELECT 결과를 저장
  StringBuffer sql = null;              // SQL 문장
  int count = 0;                         // 처리된 레코드 갯수

  String className = "org.gjt.mm.mysql.Driver"; // MySQL 연결 Drvier 
  String url = "jdbc:mysql://localhost:3306/javadb?useUnicode=true&characterEncoding=euckr"; 
  String user = "root"; 
  String password = "1234";
  
  /**
   * @param name 이름
   * @param java 자바점수
   * @param html html점수
   * @param css3 css3점수
   * @param tot 총점
   * @param avg 평균
   */
  public int create(DataVO dataVO) {
    try {
      Class.forName(className); // 문자열로 된 클래스명을 메모리에 상주
      con = DriverManager.getConnection(url, user, password); // DBMS에 연결
      sql = new StringBuffer();
      sql.append(" INSERT INTO data(name, java, html, css3, tot, avg)");
      sql.append(" VALUES(?, ?, ?, ?, ?, ?)");

      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
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
      Class.forName(className); // 문자열로 된 클래스명을 메모리에 상주
      con = DriverManager.getConnection(url, user, password); // DBMS에 연결
      sql = new StringBuffer();
      sql.append(" SELECT datano, name, java, html, css3, tot, avg");
      sql.append(" FROM data");
      sql.append(" ORDER BY datano ASC");

      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      rs = pstmt.executeQuery(); // SELECT

      // true일 경우 순환, 레코드가 있는지 검사
      // next() 최초 호출시는 첫번째 레코드로 이동
      // next() 두번재 호출부터는 다음 레코드로 이동하여 마지막 레코드까지 이동
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
   * @param datano 조회할 번호
   */
  public DataVO read(int datano) {
    DataVO dataVO = null;
    
    try {
      Class.forName(className); // 문자열로 된 클래스명을 메모리에 상주
      con = DriverManager.getConnection(url, user, password); // DBMS에 연결
      sql = new StringBuffer();
      sql.append(" SELECT datano, name, java, html, css3, tot, avg");
      sql.append(" FROM data");
      sql.append(" WHERE datano = ?");

      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      pstmt.setInt(1, datano);
      rs = pstmt.executeQuery(); // SELECT

      // true일 경우 순환, 레코드가 있는지 검사
      // next() 최초 호출시는 첫번째 레코드로 이동
      // next() 두번재 호출부터는 다음 레코드로 이동하여 마지막 레코드까지 이동
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
      Class.forName(className); // 문자열로 된 클래스명을 메모리에 상주
      con = DriverManager.getConnection(url, user, password); // DBMS에 연결
      sql = new StringBuffer();
      sql.append(" UPDATE data");
      sql.append(" SET name = ?, java = ?, html = ?, css3 = ?, tot = ?, avg = ?");
      sql.append(" WHERE datano = ?");
      
      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      pstmt.setString(1, dataVO.getName());
      pstmt.setInt(2, dataVO.getJava());
      pstmt.setInt(3, dataVO.getHtml());
      pstmt.setInt(4, dataVO.getCss3());
      pstmt.setInt(5, dataVO.getTot());
      pstmt.setInt(6, dataVO.getAvg());
      pstmt.setInt(7, dataVO.getDatano());
      
      count = pstmt.executeUpdate(); // INSERT, UPDATE, DELETE SQL 실행

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
      Class.forName(className); // 문자열로 된 클래스명을 메모리에 상주
      con = DriverManager.getConnection(url, user, password); // DBMS에 연결
      sql = new StringBuffer();
      sql.append(" DELETE FROM data");
      sql.append(" WHERE datano = ?");
      
      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      pstmt.setInt(1, datano);
      
      count = pstmt.executeUpdate(); // INSERT, UPDATE, DELETE SQL 실행

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
