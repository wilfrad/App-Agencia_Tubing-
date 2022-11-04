package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Controller {
    private static String messageError;
    private static boolean conected = false;
    
    public static Connection getConnection() {
        Connection _Connection;
        try {
            _Connection = DriverManager.getConnection(ServerInfo.url, ServerInfo.user, ServerInfo.pass);
        } catch (SQLException ex) {
            return null;
        }
        return _Connection;
    }
    
    public static boolean conect(Connection _Connection){
        boolean isCorrect = false;
        String query = "select id from unusable";
        try {
            PreparedStatement stmt = _Connection.prepareStatement(query);
            stmt.executeQuery();
            stmt.close();
            _Connection.close();
            if (!_Connection.isClosed()) {
                isCorrect = true;
                conected = isCorrect;
            }
        } catch (SQLException ex) {
            messageError = ex.getMessage();
        }
        return isCorrect;
    }
    
    public static void send(Connection _Connection, Consult _Consult, String action) {
        if (conected)
            try {
                PreparedStatement query = _Connection.prepareStatement(Query.build(_Consult, action));
                query = setStatementValues(query, _Consult.getParameters());
                if (action.equalsIgnoreCase("select") || action.equalsIgnoreCase("call"))
                    query.executeUpdate();
                else query.executeQuery();
                query.close();
                _Connection.close();
            } catch (SQLException ex) {
                messageError = ex.getMessage();
            }
    }
    
    public boolean getStatus () {
        return conected;
    }
    
    public static String getErrorMessage() {
        return messageError;
    }
    
    private static PreparedStatement setStatementValues(PreparedStatement stmt, String values){
        String[] result = values.split(",");
        try {
            for (int i = 0; i < result.length; i++) {
                stmt.setString(i, result[i]);
            }
        } catch (SQLException sq) {
            messageError = sq.getMessage();
            return null;
        }
        return stmt;
    }
}
