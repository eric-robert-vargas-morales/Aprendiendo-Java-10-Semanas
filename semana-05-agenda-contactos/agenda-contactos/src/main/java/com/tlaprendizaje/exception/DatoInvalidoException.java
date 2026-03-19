package exception;

public class DatoInvalidoException extends RuntimeException{
    private String campo;

    public DatoInvalidoException(String campo, String motivo){
        super("Dato invalido en '" + campo + "': " + motivo);
        this.campo = campo;

    }

    public String getCampo(){
        return campo;
    }

}
