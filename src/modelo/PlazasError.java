package modelo;

public class PlazasError extends Exception {

    public PlazasError() {
        super("No hay plazas disponibles en el centro");
    }

    public PlazasError(String mensaje) {
        super(mensaje);
    }
}