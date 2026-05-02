import java.sql.*;
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
                    servicios();break;
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
        System.out.println("4.Servicios");
    }
    public static void anadirRefugiada() throws SQLException {
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

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/refugio",
                "root",
                ""
        );

        String sql = "INSERT INTO usuarias (nombre, apellido, telefono, email, creado_en) VALUES (?, ?, ?, ?, NOW())";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nombre);
        ps.setString(2, apellido);
        ps.setString(3, telefono);
        ps.setString(4, email);

        ps.executeUpdate();
        ps.close();

    }
    public static void eliminarRefugiada() throws SQLException {
        int id;
        Scanner scn= new Scanner(System.in);
        System.out.println("Introduce el id de la refugiada que quieres eliminar");
        id=scn.nextInt();

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/refugio",
                "root",
                ""
        );
        String sql = "DELETE FROM usuarias WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("✅ Refugiada eliminada correctamente");
            } else {
                System.out.println("⚠️ No existe una refugiada con ese ID");
            }


    }
    public static void listarRefugiadas() throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/refugio",
                "root",
                ""
        );

        String sql = "SELECT id, nombre, apellido, telefono, email, creado_en FROM usuarias";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

            System.out.println("📋 LISTADO DE REFUGIADAS:");
            System.out.println("----------------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                String creado = rs.getString("creado_en");

                System.out.println(
                        id + " | " +
                                nombre + " " + apellido + " | " +
                                telefono + " | " +
                                email + " | " +
                                creado
                );
            }

        String nombre, apellido, telefono, email;
        int id;
        System.out.println("Esta es la lista de las refugiadas del centro");
    }
    public static void servicios(){
        System.out.println("Número de teléfono atención psicológica 24h. 655633622");
        System.out.println("Número de teléfono asistencia jurídica 24h. 644677688");
    }
}



