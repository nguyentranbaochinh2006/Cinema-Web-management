package DB;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author FPT University - PRJ30X
 */
public class DBContext {
    protected Connection connection;
    public DBContext() {
    try {
        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("../ConnectDB.properties");
        
        // KIỂM TRA FILE PROPERTIES
        if (inputStream == null) {
            throw new RuntimeException("LỖI: Không tìm thấy file ConnectDB.properties!");
        }
        
        properties.load(inputStream);
        String user = properties.getProperty("userID");
        String pass = properties.getProperty("password");
        String url = properties.getProperty("url");
        
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        connection = DriverManager.getConnection(url, user, pass);
        
    } catch (Exception ex) {
        // ÉP LỖI PHUN RA TRÌNH DUYỆT
        throw new RuntimeException("KẾT NỐI THẤT BẠI! Chi tiết: " + ex.getMessage(), ex);
    }
}
}
