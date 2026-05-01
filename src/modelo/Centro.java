import modelo.Refugiada;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {}
public class Centro {
    private int id;
    private String nombre;
    private int telefono;
    private int plazasLibres;
    private boolean admiteMascotas;
    private Refugiada[] listaRefugiadas;

    public Centro(int id, String nombre, int telefono, int plazasLibres, boolean admiteMascotas){
        this.id = id;
        this.nombre =nombre;
        this.telefono = telefono;
        this.plazasLibres = plazasLibres;
        this.admiteMascotas = admiteMascotas;
        this.listaRefugiadas = new Refugiada[50];
}
public boolean tienePlazas(){
        return this.plazasLibres > 0;

}

public void mostrarResumen(){
        System.out.println("modelo.Centro: "+ nombre + " | Plazas: " + plazasLibres + " | Mascotas: " + (admiteMascotas ? "Si" : "No" ));
}
}
