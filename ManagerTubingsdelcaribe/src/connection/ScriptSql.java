package connection;

public class ScriptSql extends Consult{
    private String tableName;
    private String[] identify, columns;
    public ScriptSql (String identify, String tableName, String[] columns, String[] parameters) {
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
    
    public String getColumns () {
        return dataToString(columns);
    }
}
