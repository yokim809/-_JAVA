package jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieDAO {
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
   *  등록
   */
  public int  create(MovieVO movieVO) {
    try {
      Class.forName(className); // 문자열로 된 클래스명을 메모리에 상주
      con = DriverManager.getConnection(url, user, password); // DBMS에 연결
      sql = new StringBuffer();
      sql.append("INSERT INTO movie(title, good, name, rdate)");
      sql.append("VALUES(?, ?, ?, now())");

      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      pstmt.setString(1, movieVO.getTitle());
      pstmt.setDouble(2, movieVO.getGood());
      pstmt.setString(3, movieVO.getName());
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

  public ArrayList<MovieVO>  list() {
    ArrayList<MovieVO> list = new ArrayList<MovieVO>();
    try {
      Class.forName(className); // 문자열로 된 클래스명을 메모리에 상주
      con = DriverManager.getConnection(url, user, password); // DBMS에 연결
      sql = new StringBuffer();
      sql.append(" SELECT movieno, title, good, name, rdate");
      sql.append(" FROM movie");
      sql.append(" ORDER BY movieno DESC");

      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      rs = pstmt.executeQuery(); // SELECT

      // true일 경우 순환, 레코드가 있는지 검사
      // next() 최초 호출시는 첫번째 레코드로 이동
      // next() 두번재 호출부터는 다음 레코드로 이동하여 마지막 레코드까지 이동
      while(rs.next()) {
        MovieVO movieVO = new MovieVO();

        movieVO.setMovieno(rs.getInt("movieno"));
        movieVO.setTitle(rs.getString("title"));
        movieVO.setName(rs.getString("name"));
        movieVO.setGood(rs.getDouble("good"));
        movieVO.setRdate(rs.getString("rdate").substring(0, 10));

        list.add(movieVO); 
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
   * 조회
   * @param movieno 조회할 번호
   */
  public MovieVO read(int movieno) {
    MovieVO movieVO = null; //메소드는 맨앞에 선언

    try {
      Class.forName(className); // 문자열로 된 클래스명을 메모리에 상주
      con = DriverManager.getConnection(url, user, password); // DBMS에 연결
      sql = new StringBuffer();
      sql.append(" SELECT movieno, title, good, name, rdate");
      sql.append(" FROM movie");
      sql.append(" WHERE movieno = ?");

      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      pstmt.setInt(1, movieno);
      rs = pstmt.executeQuery(); // SELECT

      // true일 경우 실행, 레코드가 있는지 검사
      // next() 최초 호출시는 첫번째 레코드로 이동
      // next() 두번재 호출부터는 다음 레코드로 이동하여 마지막 레코드까지 이동
      if (rs.next()) {
        movieVO = new MovieVO();
        movieVO.setMovieno(rs.getInt("movieno"));
        movieVO.setTitle(rs.getString("title"));
        movieVO.setName(rs.getString("name"));
        movieVO.setGood(rs.getDouble("good"));
        movieVO.setRdate(rs.getString("rdate").substring(0, 10));
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
    return movieVO;

  }

  /**
   *  등록
   * @param movieno 영화번호
   * @param title 영화명
   * @param good 평점
   * @param name 주연
   */
  public int  update(MovieVO movieVO) {
    try {
      Class.forName(className); // 문자열로 된 클래스명을 메모리에 상주
      con = DriverManager.getConnection(url, user, password); // DBMS에 연결
      sql = new StringBuffer();
      sql.append(" UPDATE movie");
      sql.append(" SET title = ?, good = ?, name = ?");
      sql.append(" WHERE movieno = ?");

      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      pstmt.setString(1, movieVO.getTitle());
      pstmt.setDouble(2, movieVO.getGood());
      pstmt.setString(3, movieVO.getName());
      pstmt.setInt(4, movieVO.getMovieno());

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

  public int delete(int movieno) {
    try {
      Class.forName(className); // 문자열로 된 클래스명을 메모리에 상주
      con = DriverManager.getConnection(url, user, password); // DBMS에 연결
      sql = new StringBuffer();
      sql.append(" DELETE FROM movie");
      sql.append(" WHERE movieno = ?");

      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      pstmt.setInt(1, movieno);

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