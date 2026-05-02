import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        int opcion=0;
        do{
            imprimirMenu();
            Scanner scn= new Scanner(System.in);
            opcion= scn.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Elegiste opción 1");
                    anadirRefugiada();break;
                case 2:
                    System.out.println("Elegiste opción 2");
                    eliminarRefugiada();break;
                case 3:
                    System.out.println("Elegiste opción 3");
                    listarRefugiadas();break;
                case 4:
                    System.out.println("Elegiste opción 4");
                    atencionPsicologica();break;
                case 5:
                    System.out.println("Elegiste opción 5");
                    asistenciaJuridica();break;
                default:
                    System.out.println("No existe esa opcion");break;
            }
        }
        while(opcion!=0);


        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/refugio",
                "root",
                ""
        );

        System.out.println("Conectado!");

        String sql = "INSERT INTO usuarias (nombre, apellido, telefono, email, creado_en) VALUES (?, ?, ?, ?, NOW())";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "Ana");
        ps.setString(2, "García");
        ps.setString(3, "123456789");
        ps.setString(4, "ana@email.com");

        ps.executeUpdate();

        System.out.println("✅ Usuaria insertada correctamente");

        ps.close();
        conn.close();
    }
    public static void imprimirMenu(){
        System.out.println("1.Añadir refugiada");
        System.out.println("2.Eliminar refugiada");
        System.out.println("3.Listar refugiadas");
        System.out.println("4.Atención psicológica");
        System.out.println("5.Asistencia jurídica");
        System.out.println("Elige tu opcion");
    }
    public static void anadirRefugiada(){
        String nombre, apellido, telefono, email;
        Scanner scn= new Scanner(System.in);
        System.out.println("Introduce el nombre");
        nombre=scn.nextLine();
        System.out.println("Introduce el apellido");
        apellido=scn.nextLine();
        System.out.println("Introduce el telefono");
        telefono=scn.nextLine();
        System.out.println("Introduce el email");
        email= scn.next();
        System.out.println("Has introducido los siguientes datos: " +nombre+ " "+apellido+" "+telefono+ " "+email+ ".");

    }
    public static void eliminarRefugiada(){
        String nombre, apellido, telefono, email;
        int id;
        Scanner scn= new Scanner(System.in);
        System.out.println("Introduce los datos de la refugiada que quieres eliminar");
        nombre=scn.next();
        apellido=scn.next();
        telefono=scn.next();
        email=scn.next();
        id=scn.nextInt();
    }
    public static void listarRefugiadas(){
        String nombre, apellido, telefono, email;
        int id;
        System.out.println("Esta es la lista de las refugiadas del centro");
    }
    public static void atencionPsicologica(){
        System.out.println("Número de teléfono 24h. 655633622");
    }
    public static void asistenciaJuridica(){
        System.out.println("Número de teléfono 24h. 644677688");
    }
}


