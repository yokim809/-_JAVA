package jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

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

  /**
   * 
   * @param mountain
   * @param price
   * @param count
   */
  public int create(MapleVO mapleVO) {
    try {
      Class.forName(className); // 문자열로 된 클래스명을 메모리에 상주
      con = DriverManager.getConnection(url, user, password); // DBMS에 연결
      sql = new StringBuffer();
      sql.append(" INSERT INTO maple(mountain, mapledate, price, count, total, rdate)");
      sql.append(" VALUES(?, now(), ?, ?, (price * count), now())");

      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      pstmt.setString(1, mapleVO.getMountain());
      pstmt.setInt(2, mapleVO.getPrice());
      pstmt.setInt(3, mapleVO.getCount());
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

  public ArrayList<MapleVO> list() {
    ArrayList<MapleVO> list = new ArrayList <MapleVO>();
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
        MapleVO mapleVO = new MapleVO();

        mapleVO.setMountain(rs.getString("mountain"));
        mapleVO.setMapledate(rs.getString("mapledate"));
        mapleVO.setPrice(rs.getInt("price"));
        mapleVO.setCount(rs.getInt("count"));
        mapleVO.setTotal(rs.getInt("total"));
        mapleVO.setRdate(rs.getString("rdate"));

        list.add(mapleVO);
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

  public MapleVO read(int mapleno) {
    MapleVO mapleVO = null;
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
        mapleVO = new MapleVO();
        mapleVO.setMountain(rs.getString("mountain"));
        mapleVO.setMapledate(rs.getString("mapledate"));
        mapleVO.setPrice(rs.getInt("price"));
        mapleVO.setCount(rs.getInt("count"));
        mapleVO.setTotal(rs.getInt("total"));
        mapleVO.setRdate(rs.getString("rdate"));
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
    return mapleVO;
  }

  public int update(MapleVO mapleVO) {
    try {
      Class.forName(className); // 문자열로 된 클래스명을 메모리에 상주
      con = DriverManager.getConnection(url, user, password); // DBMS에 연결
      sql = new StringBuffer();
      sql.append(" UPDATE maple");
      sql.append(" SET mountain = ?, price = ?, count = ?, total = (price * count)");
      sql.append(" WHERE mapleno = ?");

      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      pstmt.setString(1, mapleVO.getMountain());
      pstmt.setInt(2, mapleVO.getPrice());
      pstmt.setInt(3, mapleVO.getCount());
      pstmt.setInt(4, mapleVO.getMapleno());
      
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

  public int delete(int mapleno) {
    try {
      Class.forName(className); // 문자열로 된 클래스명을 메모리에 상주
      con = DriverManager.getConnection(url, user, password); // DBMS에 연결
      sql = new StringBuffer();
      sql.append(" DELETE FROM maple");
      sql.append(" WHERE mapleno = ?");

      pstmt = con.prepareStatement(sql.toString()); // SQL 실행 객체 생성
      pstmt.setInt(1, mapleno);
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
