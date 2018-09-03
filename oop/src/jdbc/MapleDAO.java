package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class MapleDAO {
  DecimalFormat df = new DecimalFormat("￦#,###,###,###원");
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
      sql.append(" INSERT INTO maple(mountain, mapledate, price, count, total, rdate)");
      sql.append(" VALUES('내장산', now(), 50000, 4, (price * count), now())");

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
   * 
   * @param mountain
   * @param price
   * @param count
   */
  public void create(String mountain, int price, int count) {
    try {
      Class.forName(className); // 문자열로 된 클래스명을 메모리에 상주
      con = DriverManager.getConnection(url, user, password); // DBMS에 연결
      sql = new StringBuffer();
      sql.append(" INSERT INTO maple(mountain, mapledate, price, count, total, rdate)");
      sql.append(" VALUES(?, now(), ?, ?, (price * count), now())");

      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      pstmt.setString(1, mountain);
      pstmt.setInt(2, price);
      pstmt.setInt(3, count);
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
      sql.append(" SELECT mapleno, mountain, mapledate, price, count, total, rdate");
      sql.append(" FROM maple");
      sql.append(" ORDER BY mapleno ASC");

      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      rs = pstmt.executeQuery(); // SELECT

      // true일 경우 순환, 레코드가 있는지 검사
      // next() 최초 호출시는 첫번째 레코드로 이동
      // next() 두번재 호출부터는 다음 레코드로 이동하여 마지막 레코드까지 이동
      while(rs.next()) {
        System.out.println("목적지: " + rs.getString("mountain"));
        System.out.println("날짜: " + rs.getString("mapledate").substring(5,7) +"월" + rs.getString("rdate").substring(8, 10) + "일");
        System.out.println("회비: " + df.format(rs.getInt("price")));
        System.out.println("인원수: " + rs.getString("count") + "명");
        System.out.println("총금액: " + df.format(rs.getInt("total")));
        System.out.println("등록 날짜: " +rs.getString("rdate").substring(0, 10));
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
  
  public void read(int mapleno) {
    try {
      Class.forName(className); // 문자열로 된 클래스명을 메모리에 상주
      con = DriverManager.getConnection(url, user, password); // DBMS에 연결
      sql = new StringBuffer();
      sql.append(" SELECT mapleno, mountain, mapledate, price, count, total, rdate");
      sql.append(" FROM maple");
      sql.append(" WHERE mapleno = ?");

      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      pstmt.setInt(1, mapleno);
      rs = pstmt.executeQuery(); // SELECT

      // true일 경우 순환, 레코드가 있는지 검사
      // next() 최초 호출시는 첫번째 레코드로 이동
      // next() 두번재 호출부터는 다음 레코드로 이동하여 마지막 레코드까지 이동
      while(rs.next()) {
        System.out.println("목적지: " + rs.getString("mountain"));
        System.out.println("날짜: " + rs.getString("mapledate").substring(5,7) +"월" + rs.getString("rdate").substring(8, 10) + "일");
        System.out.println("회비: " + df.format(rs.getInt("price")));
        System.out.println("인원수: " + rs.getString("count") + "명");
        System.out.println("총금액: " + df.format(rs.getInt("total")));
        System.out.println("등록 날짜: " +rs.getString("rdate").substring(0, 10));
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
  
  public void update(int mapleno, String mountain, int price, int count) {
    try {
      Class.forName(className); // 문자열로 된 클래스명을 메모리에 상주
      con = DriverManager.getConnection(url, user, password); // DBMS에 연결
      sql = new StringBuffer();
      sql.append(" UPDATE maple");
      sql.append(" SET mountain = ?, price = ?, count = ?, total = (price * count)");
      sql.append(" WHERE mapleno = ?");

      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      pstmt.setString(1, mountain);
      pstmt.setInt(2, price);
      pstmt.setInt(3, count);
      pstmt.setInt(4, mapleno);
      count = pstmt.executeUpdate();

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
  
  public void delete(int mapleno) {
    try {
      Class.forName(className); // 문자열로 된 클래스명을 메모리에 상주
      con = DriverManager.getConnection(url, user, password); // DBMS에 연결
      sql = new StringBuffer();
      sql.append(" DELETE FROM maple");
      sql.append(" WHERE mapleno = ?");

      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      pstmt.setInt(1, mapleno);
      count = pstmt.executeUpdate();

      if(count == 1) {
        System.out.println("삭제 처리 성공");
      } else {
        System.out.println("삭제 처리 실패");
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
