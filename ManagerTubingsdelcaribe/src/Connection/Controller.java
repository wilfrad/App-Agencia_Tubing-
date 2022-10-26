package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Controller {
    private String messageError;
    boolean correct = false;
    
    public static Connection getConnection() {
        Connection newConnection;
        try {
            newConnection = DriverManager.getConnection(serverInfo.url, serverInfo.user, serverInfo.psd);
        } catch (SQLException ex) {
            return null;
        }
        
        return newConnection;
    }
    
    public void send(Connection _Connection) {
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
    
    public void close(Connection _Connection){
        if (_Connection != null) {
            try {
                if (!_Connection.isClosed())
                    _Connection.close();
            } catch (SQLException ex) {
                messageError = ex.getMessage();
            }
        }
    }
    
    public boolean conected(Connection _Connection){
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
    
    public String getErrorMessage() {
        return messageError;
    }
}
