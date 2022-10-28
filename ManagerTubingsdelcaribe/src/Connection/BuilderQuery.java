package Connection;

public class BuilderQuery {
    public static String[] insert (Consult _Consult) {
        String[] query = {"insert into " + _Consult.getTableName()+ " (" + _Consult.getColumns() + ") values ",
            "(",")"};
        return query;
    }
    
    public static String[] update (Consult _Consult) {
        String[] query = {"upadate " + _Consult.getTableName()+ " set " + _Consult.getColumns(), 
            where(_Consult.getIdentify())};
        return query;
    }
    
    public static String[] select (Consult _Consult) {
        String[] query = {"select " + _Consult.getColumns() + " from " + _Consult.getTableName(), 
            where(_Consult.getIdentify())};
        return query;
    }
    
    public static String[] delete (Consult _Consult) {
        String[] query = {"delete from " + _Consult.getTableName()+ " ", 
            where(_Consult.getIdentify())};
        return query;
    }
    
    public static String call (Consult _Consult) {
        String query = "call " + _Consult.getFuncName()+ "(" + _Consult.getData() + ")";
        return query;
    }
    
    private static String where (String[] input) {
        String where = " where " + input[0] + " = " + input[1];
        return where;
    }
}
