package Connection;

public class Consult {
    private String tableName, funcName;
    private String[] identify, columns, parameters;
    
    public Consult (String nombreFuncion, String[] parametros) {
        this.funcName = nombreFuncion;
        this.parameters = parametros;
    }
    
    public Consult (String identify, String tableName, String[] columns, String[] parameters) {
        this.identify = new String[] {columns[0],identify};
        this.tableName = tableName;
        this.columns = columns;
        this.parameters = parameters;
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
        return dataToString(columns);
    }
    
    public String getParameters () {
        return dataToString(parameters);
    }
    
    private String dataToString (String[] input) {
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
