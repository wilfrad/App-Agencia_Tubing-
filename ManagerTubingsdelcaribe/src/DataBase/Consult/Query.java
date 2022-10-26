package DataBase.Consult;

public class Query {
    public static String crear (Consulta _Consulta) {
        String query = "insert into " + _Consulta.getNombreTabla() + "(" + _Consulta.getDatos("columnas") + ")"
                +   "values " + "(" + _Consulta.getDatos("parametros") + ");";
        return query;
    }
    
    public static String actualizar (Consulta _Consulta, String condicion) {
        String query = "upadate " + _Consulta.getNombreTabla() + " set " + _Consulta.getDatos("todo");
        query = condicion(_Consulta.getNombreTabla(), condicion);
        return query;
    }
    
    public static String buscar (Consulta _Consulta, String condicion) {
        String query = "select " + _Consulta.getDatos("columnas") + " from " + _Consulta.getNombreTabla();
        query = condicion(_Consulta.getNombreTabla(), condicion);
        return query;
    }
    
    public static String eliminir (Consulta _Consulta, String condicion) {
        String query = "delete from " + _Consulta.getNombreTabla();
        query = condicion(_Consulta.getNombreTabla(), condicion);
        return query;
    }
    
    public static String procesoAlmacenado (Consulta _Consulta) {
        String query = "call " + _Consulta.getNombreFuncion() + "(" + _Consulta.getDatos("parametros") + ");";
        return query;
    }
    
    private static String condicion (String objetivo, String parametro) {
        if (parametro.equals("")) {
            return ";";
        }
        String where = "\n where " + objetivo + ".id = " + parametro;
        return where;
    }
}
