package DataBase.Consult;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Consulta {
    private String accion;
    private String nombreTabla;
    private String nombreFuncion;
    private String[] columnas;
    private final String[] parametros;
    
    public Consulta (String accion, String nombreFuncion, String[] parametros) {
        this.nombreFuncion = nombreFuncion;
        this.parametros = parametros;
    }
    
    public Consulta (String accion, String nombreTabla, String[] columnas, String[] parametros) {
        this.nombreTabla = nombreTabla;
        this.columnas = columnas;
        this.parametros = parametros;
    }
    
    public void setAccion (String accion) {
        this.accion = accion;
    }
    
    public String getAccion () {
        return this.accion;
    }
    
    public String getNombreTabla () {
        return this.nombreTabla;
    }
    
    public String getNombreFuncion () {
        return this.nombreFuncion;
    }
    
    public String getDatos (String referencia) {
        String formato;
        
        if (referencia.equals("columnas")) {
            formato = formatoCadena(columnas);
            return formato;
        }
        
        if (referencia.equals("parametros")) {
            formato = formatoCadena(parametros);
            return formato;
        }
        
        formato = formatoCadena(columnas, parametros);
        return formato;
    }
    
    private String formatoCadena (String[] entradaPrimaria) {
        
        Stream<String> formato1 = Arrays.asList(entradaPrimaria).stream();
        String cadenaFormateada;
        
        cadenaFormateada = formato1.collect(Collectors.joining(","));
        
        return cadenaFormateada;
    }
    
    private String formatoCadena (String[] entradaPrimaria, String[] entradaSecundaria) {
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < entradaPrimaria.length; i++) {
            builder.append(entradaPrimaria[i] + " = " + entradaSecundaria[i] + ",");
        }
        
        builder.deleteCharAt(builder.length() -1);
        
        return builder.toString();
    }
}
