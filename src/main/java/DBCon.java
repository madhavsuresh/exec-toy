import java.sql.*;

public class DBCon {
  public Connection connect() {
    Connection conn = null;
    try {
      conn =
          DriverManager.getConnection(
              "jdbc:postgresql://localhost/vaultdb_",
              "madhav" /* user */,
              "password" /* password */);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return conn;
  }

  public static void main(String[] args) {
    DBCon con = new DBCon();
    Connection c = con.connect();
    try {
      Statement stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM left_deep_joins_1024");
      ResultSetMetaData rsmd = rs.getMetaData();
      // ResultSetMetaData is 1 indexed
      for (int i = 1; i <= rsmd.getColumnCount(); i++) {
        System.out.println(
                "Col: " + rsmd.getColumnName(i) + " type:" + rsmd.getColumnTypeName(i));
      }
      while (rs.next()){
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());

    }
  }
}
