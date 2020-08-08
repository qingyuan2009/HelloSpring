package exe014.dataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestC3P0 {
    public static void main(String[] args) {
        TestAdd();
    }

    public static void TestAdd() {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = C3P0Utils.getConnection();
            String sql = "insert into examstudent (type, idcard,examcard,studentname,location,grade) values (?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);

            ps.setInt(1, 3);
            ps.setInt(2, 123456);
            ps.setInt(3, 765);
            ps.setString(4, "James");
            ps.setString(5, "Australia");
            ps.setInt(6, 77);

            int row = ps.executeUpdate();
            if (row > 0) {
                System.out.println("插入成功");

            } else {
                System.out.println("插入失败");
            }

        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            C3P0Utils.release(con, ps, null);
        }
    }
}