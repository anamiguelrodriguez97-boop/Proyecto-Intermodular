import modelo.Refugiada;

import java.time.LocalDate;
import java.util.Date;

public class Main {
    public void main(String[] args){

        Refugiada r = new Refugiada("Maria", "Dominguez", "maria@gmail.com", "666666666", LocalDate.of(1997, 3, 9), 1);
        System.out.println("La refugiada tiene " + r.getEdad() + " años.");
}

}
