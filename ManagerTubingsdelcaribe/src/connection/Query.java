package connection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Query {
    private static ScriptSql _ScriptSql;
    private static FuncSql _FuncSql;
    private static String querySql = "";
    private static HashMap<String, Runnable> builds = initBuilds();
    
    public static String build (Consult _Consult, String action) {
        if (_Consult instanceof ScriptSql) 
            _ScriptSql = (ScriptSql) _Consult;
        else 
            _FuncSql = (FuncSql) _Consult;
        builds.get(action).run();
        return querySql;
    }
    
    private static HashMap initBuilds () {
        HashMap<String, Runnable> storage = new HashMap();
        storage.put("inset", () -> insert());
        storage.put("update", () -> update());
        storage.put("select", () -> select());
        storage.put("delete", () -> delete());
        storage.put("call", () -> call());
        return storage;
    }
    
    private static void insert () {
        String[] query = {"insert into " + _ScriptSql.getTableName()+ " (" + _ScriptSql.getColumns() + ") values ",
            "(", substituteByChar(_ScriptSql.getParameters()),")"};
        querySql = Arrays.toString(query);
    }
    
    private static void update () {
        String[] query = {"upadate " + _ScriptSql.getTableName()+ " set " + _ScriptSql.getColumns(), 
            where(_ScriptSql.getIdentify())};
        querySql = Arrays.toString(query);
    }
    
    private static void select () {
        String[] query = {"select " + _ScriptSql.getColumns() + " from " + _ScriptSql.getTableName(), 
            where(_ScriptSql.getIdentify())};
        querySql = Arrays.toString(query);
    }
    
    private static void delete () {
        String[] query = {"delete from " + _ScriptSql.getTableName()+ " ", 
            where(_ScriptSql.getIdentify())};
        querySql = Arrays.toString(query);
    }
    
    private static void call () {
        String[] query = {"call ",_FuncSql.getFuncName()," (",substituteByChar(_FuncSql.getParameters()), ") "};
        querySql = Arrays.toString(query);
    }
    
    private static String where (String[] input) {
        String where = " where " + input[0] + " = " + input[1];
        return where;
    }
    
    private static String substituteByChar (String data) {
        List<String> listParams = Arrays.asList(data.split(","));
        listParams.stream()
            .forEach(item -> item = "?");
        String result = String.join(",", listParams);
        return result;
    }
}
