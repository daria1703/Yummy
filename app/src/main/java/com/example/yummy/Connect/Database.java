package com.example.yummy.Connect;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Database {

    private static Connection connection;

    private final String host = "195.150.230.210";
    private final String database = "2021_zaucha_patryk";
    private final int port = 5434;
    private final String user = "2021_zaucha_patryk";
    private final String pass = "1234";
    private String url = "jdbc:postgresql://%s:%d/%s";
    public boolean status;

    public Database() {
        this.url = String.format(this.url, this.host, this.port, this.database);
        connect();
        //this.disconnect();
        System.out.println("connection status:" + status);
    }

    private void connect() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection(url, user, pass);
                    status = true;
                    System.out.println("connected:" + status);

                } catch (Exception e) {
                    status = false;
                    System.out.print(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
            this.status = false;
        }
    }

    public Connection getExtraConnection(){
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return c;
    }

    List<String[]> usersData;

    public List<UserData> getUsersData() throws SQLException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    usersData = getTableContent("users");

                } catch (Exception e) {
                    status = false;
                    System.out.print(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
            this.status = false;
        }

        List<UserData> users = new ArrayList<>();
        UserData user;

        for (String[] row: usersData) {
            user = new UserData(Integer.parseInt(row[0]), row[1], row[2], row[3], row[4]);
            users.add(user);
        }

        return users;

    }

    public List<String[]> getTableContent(String tableName) throws SQLException {
        DatabaseMetaData md = connection.getMetaData();
        ResultSet rs = md.getColumns(null, "%", tableName, null);

        // znalezienie nazwy schematu, w którym jest tabela
        rs.next();
        String schemaName = rs.getString(2);

        String query = "SELECT * FROM " + schemaName + "." + tableName;
        Statement stmt = connection.createStatement();
        rs = stmt.executeQuery(query);

        List<String> columns = getColumnNames(tableName);


        int width = columns.size();

        String[] line;
        List<String[]> data = new ArrayList<>();

        int i;
        while(rs.next()){
            i = 0;
            line = new String[width];
            for (String item: columns){
                line[i++] = rs.getString(item);
            }
            data.add(line);
        }

        return data;
    }

    public List<String> getColumnNames(String tableName) throws SQLException {

        DatabaseMetaData md = connection.getMetaData();
        ResultSet rs = md.getColumns(null, null, tableName, "%");
        List<String> columns = new ArrayList<>();
        while (rs.next()) {
            columns.add(rs.getString(4));
        }

        return columns;
    }

    public static boolean addUser(final String fullName, final String nick, final String email, final String password) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String query = "INSERT INTO yummy.users (full_name, nick, email, password)" +
                        "VALUES ('" + fullName + "', '" + nick + "', '" + email + "', '" + password + "');";
                Statement stmt = null;
                try {
                    connection.createStatement().execute(query);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}