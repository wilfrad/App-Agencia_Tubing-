package connection;

public class FuncSql extends Consult{
    private String funcName;
    
    public FuncSql (String nombreFuncion, String[] parametros) {
        this.funcName = nombreFuncion;
        this.parameters = parametros;
    }
    
    public String getFuncName () {
        return this.funcName;
    }
}
