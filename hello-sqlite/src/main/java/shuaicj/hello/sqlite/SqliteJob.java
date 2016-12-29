package shuaicj.hello.sqlite;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.CountDownLatch;

/**
 * Description.
 *
 * @author shuaicj 2016/12/29
 */
public class SqliteJob implements Runnable {

    private Connection conn;
    private CountDownLatch latch;
    private boolean readonly;
    private String table;
    private String sql;

    public SqliteJob(Connection conn, CountDownLatch latch, boolean readonly, String table) {
        this.conn = conn;
        this.latch = latch;
        this.readonly = readonly;
        this.table = table;
        if (readonly) {
            sql = "select count(*) as num from " + table;
        } else {
            sql = "insert into " + table + " values(1, 'leo')";
        }
    }

    @Override
    public void run() {
        int max = 10000;
        for (int i = 0; i < max; i++) {
            try (Statement statement = conn.createStatement()) {
                if (readonly) {
                    ResultSet rs = statement.executeQuery(sql);
                    int num = rs.getInt("num");
                    System.out.println(String.format("[%s] [read %s] count(*): %d", Thread.currentThread().getName(), table, num));
                } else {
                    int num = statement.executeUpdate(sql);
                    System.out.println(String.format("[%s] [insert %s] affected: %d", Thread.currentThread().getName(), table, num));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        latch.countDown();
    }

}
