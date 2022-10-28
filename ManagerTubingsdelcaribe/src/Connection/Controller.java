package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Controller {
    private static String messageError;
    private static boolean correct = false;
    
    public static Connection getConnection() {
        Connection newConnection;
        try {
            newConnection = DriverManager.getConnection(ServerInfo.url, ServerInfo.user, ServerInfo.psd);
        } catch (SQLException ex) {
            return null;
        }
        
        return newConnection;
    }
    
    public static void send(Connection _Connection, Consult _Consult) {
        try {
            PreparedStatement stmt = _Connection.prepareStatement("");
            
            stmt.setString(1, "value1"); //overwrite in "?" to query
            stmt.executeUpdate(); // insert - update - delete
            
            stmt.executeQuery(); //select or multi result
            
            stmt.close();
        } catch (SQLException ex) {
            messageError = ex.getMessage();
        }
    }
    
    public static void close(Connection _Connection){
        if (_Connection != null) {
            try {
                if (!_Connection.isClosed())
                    _Connection.close();
            } catch (SQLException ex) {
                messageError = ex.getMessage();
            }
        }
    }
    
    public static boolean conected(Connection _Connection){
        boolean isCorrect = false;
        if (_Connection != null) {
            try {
                if (!_Connection.isClosed())
                    return isCorrect;
            } catch (SQLException ex) {
                messageError = ex.getMessage();
                return isCorrect;
            }
        }
        return isCorrect;
    }
    
    public static String getErrorMessage() {
        return messageError;
    }
}
