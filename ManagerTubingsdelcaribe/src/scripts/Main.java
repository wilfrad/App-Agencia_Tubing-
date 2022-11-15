package scripts;

import connection.ControllerConnection;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        ControllerConnection.conect(ControllerConnection.getConnection());
        
    }
    
    private void initialize() {
        
    }
}
