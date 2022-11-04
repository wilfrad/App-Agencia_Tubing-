package Connection;

import java.util.Arrays;
import java.util.List;

public class Query {
    private static Consult _Consult;
    public static String build (Consult input, String action) {
        String query = "";
        _Consult = input;
        try {
            switch (action.toLowerCase()) {
                case "insert":
                    query = insert();
                case "update":
                    query = update();
                case "select":
                    query = select();
                case "delete":
                    query = delete();
                default:
                    query = call();
            }
        } catch (NullPointerException npe) {
            query = null;
        }
        return query;
    }
    
    private static String insert () {
        String[] query = {"insert into " + _Consult.getTableName()+ " (" + _Consult.getColumns() + ") values ",
            "(", subByChar(_Consult.getParameters()),")"};
        return Arrays.toString(query);
    }
    
    private static String update () {
        String[] query = {"upadate " + _Consult.getTableName()+ " set " + _Consult.getColumns(), 
            where(_Consult.getIdentify())};
        return Arrays.toString(query);
    }
    
    private static String select () {
        String[] query = {"select " + _Consult.getColumns() + " from " + _Consult.getTableName(), 
            where(_Consult.getIdentify())};
        return Arrays.toString(query);
    }
    
    private static String delete () {
        String[] query = {"delete from " + _Consult.getTableName()+ " ", 
            where(_Consult.getIdentify())};
        return Arrays.toString(query);
    }
    
    private static String call () {
        String[] query = {"call ",_Consult.getFuncName(),"(",subByChar(_Consult.getParameters()), ")"};
        return Arrays.toString(query);
    }
    
    private static String where (String[] input) {
        String where = " where " + input[0] + " = " + input[1];
        return where;
    }
    
    private static String subByChar (String data) {
        List<String> listParams = Arrays.asList(data.split(","));
        listParams.stream()
            .forEach(item -> item = "?");
        String result = String.join(",", listParams);
        return result;
    }
}
