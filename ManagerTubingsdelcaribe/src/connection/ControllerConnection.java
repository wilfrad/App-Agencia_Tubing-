package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControllerConnection {
    private static String messageError;
    private static boolean conected = false;
    
    public static Connection getConnection() {
        Connection _Connection;
        try {
            _Connection = DriverManager.getConnection(ServerInfo.url, ServerInfo.user, ServerInfo.pass);
        } catch (SQLException sqle) {
            messageError = sqle.getMessage();
            return null;
        }
        return _Connection;
    }
    
    public static boolean conect(Connection _Connection){
        boolean isCorrect = false;
        try {
            PreparedStatement stmt = _Connection.prepareStatement(ServerInfo.queryToConect);
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
    
    public static boolean send(Connection _Connection, Consult _Consult, String action) {
        try {
            PreparedStatement queryStmt = _Connection.prepareStatement(Query.build(_Consult, action));
            queryStmt = setStatementValues(queryStmt, _Consult.getParameters());
            if (action.equalsIgnoreCase("select") || _Consult instanceof FuncSql)
                queryStmt.executeUpdate();
            else queryStmt.executeQuery();
            queryStmt.close();
            _Connection.close();
            return true;
        } catch (SQLException ex) {
            messageError = ex.getMessage();
        }
        
        return false;
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
