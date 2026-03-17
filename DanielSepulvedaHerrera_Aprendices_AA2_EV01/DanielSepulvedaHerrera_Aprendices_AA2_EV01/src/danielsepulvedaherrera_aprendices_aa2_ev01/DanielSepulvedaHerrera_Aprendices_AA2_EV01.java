package danielsepulvedaherrera_aprendices_aa2_ev01;

//importaciones

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DanielSepulvedaHerrera_Aprendices_AA2_EV01 {

    public static void main(String[] args) {
        String usuario="root";
        String password="4334";
        String url="jdbc:mysql://localhost:3306/Prueba";
        
        Connection conexion;
        Statement st;
        ResultSet rs;
        
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.getLogger(DanielSepulvedaHerrera_Aprendices_AA2_EV01.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
            
            conexion=DriverManager.getConnection(url, usuario, password);
            st=conexion.createStatement();
            
            //Muestra los datos que hay en la tabla
            
            rs=st.executeQuery("select * from Usuarios");
            rs.next();
            do{
                System.out.println(rs.getInt("idUsuario")+" : "+rs.getString("nombre")+" "+rs.getString("apellido"));
            }while(rs.next()); 
          
            //Ingresa datos en la tabla Usuarios
            
            st.executeUpdate("insert into Usuarios values(2, 'Pedro', 'Hernandez', 'Pedro4455@hotmail.com', '2233CH', 'Cliente')");
            rs=st.executeQuery("select * from Usuarios");
            rs.next();
            do{
                System.out.println(rs.getInt("idUsuario")+" : "+rs.getString("nombre")+" "+rs.getString("apellido"));
            }while(rs.next()); 
            
            //Actualiza un datos en la tabla Usuarios
            
            st.executeUpdate("update Usuarios set nombre='Marcos' where idUsuario = 2");
            rs=st.executeQuery("select * from Usuarios");
            rs.next();
            do{
                System.out.println(rs.getInt("idUsuario")+" : "+rs.getString("nombre")+" "+rs.getString("apellido"));
            }while(rs.next()); 
            
            //Borra un dato de la tabla Usuarios
            
            st.executeUpdate("delete from Usuarios where idUsuario=2");
            rs=st.executeQuery("select * from Usuarios");
            rs.next();
            do{
                System.out.println(rs.getInt("idUsuario")+" : "+rs.getString("nombre")+" "+rs.getString("apellido"));
            }while(rs.next()); 
            
        } catch (SQLException ex) {
            Logger.getLogger(DanielSepulvedaHerrera_Aprendices_AA2_EV01.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
