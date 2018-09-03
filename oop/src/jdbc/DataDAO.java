package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
  
  public void create() {
    try {
      Class.forName(className); // 문자열로 된 클래스명을 메모리에 상주
      con = DriverManager.getConnection(url, user, password); // DBMS에 연결
      sql = new StringBuffer();
      sql.append("INSERT INTO data(name, java, html, css3, tot, avg)");
      sql.append("VALUES('김영욱', 80, 80, 80, 240, 80)");

      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      count = pstmt.executeUpdate();

      if(count == 1) {
        System.out.println("등록 처리 성공");
      } else {
        System.out.println("등록 처리 실패");
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
   * @param name 이름
   * @param java 자바점수
   * @param html html점수
   * @param css3 css3점수
   * @param tot 총점
   * @param avg 평균
   */
  public void create(String name, int java, int html, int css3, int tot, int avg) {
    try {
      Class.forName(className); // 문자열로 된 클래스명을 메모리에 상주
      con = DriverManager.getConnection(url, user, password); // DBMS에 연결
      sql = new StringBuffer();
      sql.append(" INSERT INTO data(name, java, html, css3, tot, avg)");
      sql.append(" VALUES(?, ?, ?, ?, ?, ?)");

      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      pstmt.setString(1, name);
      pstmt.setInt(2, java);
      pstmt.setInt(3, html);
      pstmt.setInt(4, css3);
      pstmt.setInt(5, tot);
      pstmt.setInt(6, avg);
      count = pstmt.executeUpdate();

      if(count == 1) {
        System.out.println("등록 처리 성공");
      } else {
        System.out.println("등록 처리 실패");
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
        System.out.print(rs.getInt("datano")+ ". ");
        System.out.print(rs.getString("name") + ": ");
        System.out.print(rs.getInt("java") + ",");
        System.out.print(rs.getInt("html") + ", ");
        System.out.print(rs.getInt("css3") +" ");
        System.out.print("총점: " + rs.getInt("tot"));
        System.out.print(", 평균: " + rs.getInt("avg"));
        System.out.println();
        System.out.println("──────────────────────────");
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
   * @param datano 조회할 번호
   */
  public void read(int datano) {
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
        System.out.print(rs.getInt("datano")+ ". ");
        System.out.print(rs.getString("name") + ": ");
        System.out.print(rs.getInt("java") + ",");
        System.out.print(rs.getInt("html") + ", ");
        System.out.print(rs.getInt("css3") +" ");
        System.out.print("총점: " + rs.getInt("tot"));
        System.out.print(", 평균: " + rs.getInt("avg"));
        System.out.println();
        System.out.println("──────────────────────────");
      }
      else {
        System.out.println("조회하신 번호에 데이터가 없습니다.");
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
      Class.forName(className); // 문자열로 된 클래스명을 메모리에 상주
      con = DriverManager.getConnection(url, user, password); // DBMS에 연결
      sql = new StringBuffer();
      sql.append(" UPDATE data");
      sql.append(" SET name = ?, java = ?, html = ?, css3 = ?, tot = ?, avg = ?");
      sql.append(" WHERE datano = ?");
      
      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      pstmt.setString(1, name);
      pstmt.setInt(2, java);
      pstmt.setInt(3, html);
      pstmt.setInt(4, css3);
      pstmt.setInt(5, tot);
      pstmt.setInt(6, avg);
      pstmt.setInt(7, datano);
      
      count = pstmt.executeUpdate(); // INSERT, UPDATE, DELETE SQL 실행

      if(count == 1) {
        System.out.println("수정 처리 성공");
      } else {
        System.out.println("수정 처리 실패");
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
      Class.forName(className); // 문자열로 된 클래스명을 메모리에 상주
      con = DriverManager.getConnection(url, user, password); // DBMS에 연결
      sql = new StringBuffer();
      sql.append(" DELETE FROM data");
      sql.append(" WHERE datano = ?");
      
      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      pstmt.setInt(1, datano);
      
      int cnt = pstmt.executeUpdate(); // INSERT, UPDATE, DELETE SQL 실행

      if(cnt == 1) {
        System.out.println("삭제 성공");
      } else {
        System.out.println("삭제 실패");
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
