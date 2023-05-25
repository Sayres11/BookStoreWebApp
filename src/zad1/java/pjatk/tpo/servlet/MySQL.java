package pjatk.tpo.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {
    protected static Connection initializeDatabase()
            throws SQLException, ClassNotFoundException
    {
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql:// localhost:3306/";
        String dbName = "books";
        String dbUsername = "root";
        String dbPassword = "root";

        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbURL + dbName,
                dbUsername,
                dbPassword);
        return con;
    }
   // CREATE DATABASE books;

/*    CREATE TABLE `book` (
      `idbook` int NOT NULL,
      `bookname` varchar(45) DEFAULT NULL,
      `bookauthor` varchar(45) DEFAULT NULL,
      `bookcost` int DEFAULT NULL,
       PRIMARY KEY (`idbook`))
       */

   /* INSERT INTO `books`.`book` (`idbook`, `bookname`, `bookauthor`, `bookcost`) VALUES ('1', 'Program', 'Tomasz', '100');
    INSERT INTO `books`.`book` (`idbook`, `bookname`, `bookauthor`, `bookcost`) VALUES ('2', 'Biology', 'Werner', '70');
    INSERT INTO `books`.`book` (`idbook`, `bookname`, `bookauthor`, `bookcost`) VALUES ('3', 'Java', 'Tomasz', '50');
    INSERT INTO `books`.`book` (`idbook`, `bookname`, `bookauthor`, `bookcost`) VALUES ('4', 'UML Diagram', 'idk', '70');
    INSERT INTO `books`.`book` (`idbook`, `bookname`, `bookauthor`, `bookcost`) VALUES ('5', 'SQL for noobs', 'Steve', '7000');
    INSERT INTO `books`.`book` (`idbook`, `bookname`, `bookauthor`, `bookcost`) VALUES ('6', 'Spring framefork', 'Pivotal', '60');*/
}
