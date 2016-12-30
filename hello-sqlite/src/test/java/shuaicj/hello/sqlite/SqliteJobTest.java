package shuaicj.hello.sqlite;

import org.junit.AfterClass;
import org.junit.Test;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.CountDownLatch;

/**
 * Description.
 *
 * @author shuaicj 2016/12/29
 */
public class SqliteJobTest {

    private static final String DB_NAME = "sqlite.db";
    private static final String DB_NAME_2 = "sqlite2.db";
    private static final String DB_ALIAS = "d2";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection newConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:" + DB_NAME);
    }

    private void initTable(String table) throws SQLException {
        Connection conn = newConnection();
        Statement statement = conn.createStatement();
        statement.execute("create table if not exists " + table + " (id integer, name string)");
        statement.close();
        conn.close();
    }

    private Connection newConnectionForMultiDb() throws SQLException {
        Connection conn = newConnection();
        Statement statement = conn.createStatement();
        statement.execute(String.format("attach database '%s' as %s", DB_NAME_2, DB_ALIAS));
        statement.close();
        return conn;
    }

    private void initTableForMultiDb(String table) throws SQLException {
        Connection conn = newConnectionForMultiDb();
        Statement statement = conn.createStatement();
        statement.execute("create table if not exists " + table + " (id integer, name string)");
        statement.execute("create table if not exists " + DB_ALIAS + "." + table + " (id integer, name string)");
        statement.close();
        conn.close();
    }

    @Test
    public void nothing() {}

//    @Test
    public void oneConnectionOneTable() throws SQLException, InterruptedException {
        String table = "person";
        initTable(table);
//        initTable(table);
        int num = 10;
        Connection conn = newConnection();
        CountDownLatch latch = new CountDownLatch(num);
        for (int i = 0; i < num; i++) {
            new Thread(new SqliteJob(conn, latch, i < num / 2, table)).start();
        }
        latch.await();
        conn.close();
    }

//    @Test
    public void oneConnectionMultiTable() throws SQLException, InterruptedException {
        String table1 = "person1";
        String table2 = "person2";
//        initTableForMultiDb(table1);
//        initTableForMultiDb(table2);
        initTable(table1);
        initTable(table2);
        int num = 10;
        Connection conn = newConnection();
        CountDownLatch latch = new CountDownLatch(num);
        for (int i = 0; i < num; i++) {
            boolean readonly = i < num / 2;
            new Thread(new SqliteJob(conn, latch, readonly, readonly ? table1 : table2)).start();
        }
        latch.await();
        conn.close();
    }

//    @Test
    public void multiConnectionOneTable() throws SQLException, InterruptedException {
        String table = "person";
        initTable(table);
        int num = 10;
        CountDownLatch latch = new CountDownLatch(num);
        Connection[] connections = new Connection[num];
        for (int i = 0; i < num; i++) {
            connections[i] = newConnection();
        }
        for (int i = 0; i < num; i++) {
            new Thread(new SqliteJob(connections[i], latch, i < num / 2, table)).start();
        }
        latch.await();
        for (int i = 0; i < num; i++) {
            connections[i].close();
        }
    }

//    @Test
    public void multiConnectionMultiTable() throws SQLException, InterruptedException {
        String table1 = "person1";
        String table2 = "person2";
        initTable(table1);
        initTable(table2);
        int num = 10;
        CountDownLatch latch = new CountDownLatch(num);
        Connection[] connections = new Connection[num];
        for (int i = 0; i < num; i++) {
            connections[i] = newConnection();
        }
        for (int i = 0; i < num; i++) {
            boolean readonly = i < num / 2;
            new Thread(new SqliteJob(connections[i], latch, readonly, readonly ? table1 : table2)).start();
        }
        latch.await();
        for (int i = 0; i < num; i++) {
            connections[i].close();
        }
    }

//    @Test
    public void oneConnectionMultiDbRR() throws SQLException, InterruptedException {
        oneConnectionMultiDb(true, true);
    }

//    @Test
    public void oneConnectionMultiDbRW() throws SQLException, InterruptedException {
        oneConnectionMultiDb(true, false);
    }

//    @Test
    public void oneConnectionMultiDbWW() throws SQLException, InterruptedException {
        oneConnectionMultiDb(false, false);
    }

//    @Test
    public void oneConnectionMultiDbWR() throws SQLException, InterruptedException {
        oneConnectionMultiDb(false, true);
    }

    private void oneConnectionMultiDb(boolean readonly1, boolean readonly2) throws SQLException, InterruptedException {
        String table = "person";
        String table2 = DB_ALIAS + ".person";
        initTableForMultiDb(table);
        int num = 10;
        Connection conn = newConnectionForMultiDb();
        CountDownLatch latch = new CountDownLatch(num);
        for (int i = 0; i < num; i++) {
            if (i < num / 2) {
                new Thread(new SqliteJob(conn, latch, readonly1, table)).start();
            } else {
                new Thread(new SqliteJob(conn, latch, readonly2, table2)).start();
            }
        }
        latch.await();
        conn.close();
    }

    @AfterClass
    public static void deleteDbFile() {
        new File(DB_NAME).delete();
        new File(DB_NAME_2).delete();
    }
}