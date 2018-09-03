package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class PayDAO {
  DecimalFormat df = new DecimalFormat("￦ #,###,###,### 원");
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
      sql.append(" INSERT INTO pay(name, basic, year, sudang, salary, rdate)");
      sql.append(" VALUES('김영욱', 1500000, 2, 500000, (basic + sudang), now())");

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

  public void create(String name, int basic, int year, int sudang) {
    try {
      Class.forName(className); // 문자열로 된 클래스명을 메모리에 상주
      con = DriverManager.getConnection(url, user, password); // DBMS에 연결
      sql = new StringBuffer();
      sql.append(" INSERT INTO pay(name, basic, year, sudang, salary, rdate)");
      sql.append(" VALUES(?, ?, ?, ?, (basic + sudang), now())");

      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      pstmt.setString(1, name);
      pstmt.setInt(2, basic);
      pstmt.setInt(3, year);
      pstmt.setInt(4, sudang);
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
      sql.append(" SELECT payno, name, basic, year, sudang, salary, rdate");
      sql.append(" FROM pay");
      sql.append(" ORDER BY payno ASC");

      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      rs = pstmt.executeQuery(); // SELECT

      // true일 경우 순환, 레코드가 있는지 검사
      // next() 최초 호출시는 첫번째 레코드로 이동
      // next() 두번재 호출부터는 다음 레코드로 이동하여 마지막 레코드까지 이동
      while(rs.next()) {
        System.out.println("성명: " + rs.getString("name"));
        System.out.println("기본급: " + df.format(rs.getInt("basic")) );
        System.out.println("경력: " + rs.getInt("year") + "년");
        System.out.println("수당: " + df.format(rs.getInt("sudang")));
        System.out.println("급여: " + df.format(rs.getInt("salary")));
        System.out.println("등록날짜: "+ rs.getString("rdate").substring(0, 10));
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
   * 
   * @param payno
   */
  public void read(int payno) {
    try {
      Class.forName(className); // 문자열로 된 클래스명을 메모리에 상주
      con = DriverManager.getConnection(url, user, password); // DBMS에 연결
      sql = new StringBuffer();
      sql.append(" SELECT payno, name, basic, year, sudang, salary, rdate");
      sql.append(" FROM pay");
      sql.append(" WHERE payno = ?");

      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      pstmt.setInt(1, payno);
      rs = pstmt.executeQuery(); // SELECT
      // true일 경우 순환, 레코드가 있는지 검사
      // next() 최초 호출시는 첫번째 레코드로 이동
      // next() 두번재 호출부터는 다음 레코드로 이동하여 마지막 레코드까지 이동
      if(rs.next()) {
        System.out.println("성명: " + rs.getString("name"));
        System.out.println("기본급: " + df.format(rs.getInt("basic")) );
        System.out.println("경력: " + rs.getInt("year") + "년");
        System.out.println("수당: " + df.format(rs.getInt("sudang")));
        System.out.println("급여: " + df.format(rs.getInt("salary")));
        System.out.println("등록날짜: "+ rs.getString("rdate").substring(0, 10));
        System.out.println("──────────────────────────");
      } else {
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
   * @param payno
   * @param name
   * @param basic
   * @param year
   * @param sudang
   */
  public void update(int payno, String name, int basic, int year, int sudang) {
    try {
      Class.forName(className); // 문자열로 된 클래스명을 메모리에 상주
      con = DriverManager.getConnection(url, user, password); // DBMS에 연결
      sql = new StringBuffer();
      sql.append(" UPDATE pay");
      sql.append(" SET name = ?, basic = ?, year = ?, sudang = ?, salary = (basic + sudang)");
      sql.append(" WHERE payno = ?");

      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      pstmt.setString(1, name);
      pstmt.setInt(2, basic);
      pstmt.setInt(3, year);
      pstmt.setInt(4, sudang);
      pstmt.setInt(5, payno);

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

  /**
   * 
   * @param payno
   */
  public void delete(int payno) {
    try {
      Class.forName(className); // 문자열로 된 클래스명을 메모리에 상주
      con = DriverManager.getConnection(url, user, password); // DBMS에 연결
      sql = new StringBuffer();
      sql.append(" DELETE FROM pay");
      sql.append(" WHERE payno = ?;");

      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      pstmt.setInt(1, payno);

      count = pstmt.executeUpdate();

      if(count == 1) {
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
