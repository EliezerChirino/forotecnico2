import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class  conexion {
     Connection con;
    public conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/productos","root","");
        } catch (Exception e) {
            System.err.println("Error:" +e);
        }
    }
    public void consultarProductos() {
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM nombre_de_la_tabla");

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                String codigo = rs.getString("codigo");
                int stock = rs.getInt("stock");
                double precio = rs.getDouble("precio");

                System.out.println("Nombre: " + nombre);
                System.out.println("Descripción: " + descripcion);
                System.out.println("Código: " + codigo);
                System.out.println("Stock: " + stock);
                System.out.println("Precio: " + precio);
                System.out.println("-----------------------");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        conexion cn = new conexion();
        cn.consultarProductos();
    }
}

