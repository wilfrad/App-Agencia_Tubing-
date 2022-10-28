package Connection;

import java.util.Arrays;

public class Consult {
    private String action, tableName, funcName;
    private String[] identify, columns, parameters;
    
    public Consult (String accion, String nombreFuncion, String[] parametros) {
        this.funcName = nombreFuncion;
        this.parameters = parametros;
    }
    
    public Consult (String identify, String tableName, String[] columns, String[] parameters) {
        this.identify = new String[] {columns[0],identify};
        this.tableName = tableName;
        this.columns = Arrays.copyOfRange(columns, 1, columns.length);;
        this.parameters = parameters;
    }
    
    public void setAction (String action) {
        this.action = action;
    }
    
    public String getAction () {
        return this.action;
    }
    
    public String[] getIdentify () {
        return this.identify;
    }
    
    public String getTableName () {
        return this.tableName;
    }
    
    public String getFuncName () {
        return this.funcName;
    }
    
    public String getColumns () {
        return data(columns);
    }
    
    public String getData () {
        return data(parameters);
    }
    
    public String data (String[] input) {
        if (input.length <= 0) {
            StringBuilder builder = new StringBuilder();
            for (String item : input)
                builder.append(item + ",");
            builder.deleteCharAt(builder.length() -1);
            String result = builder.toString();
            return result;
        }
        
        return null;
    }
}
