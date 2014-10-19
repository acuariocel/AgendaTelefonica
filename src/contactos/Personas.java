package contactos;

import java.sql.*;

public class Personas {

    Conexion con;

    public Personas() {
        con = new Conexion();
    }

    /*Añade un nuevo registro*/
    public boolean NuevaPersona(String name, String ap, String am, String mail, int edad) {
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("insert into "
                    + "persona(nombres, appPaterno, appMaterno, mail, edad) "
                    + " values(?,?,?,?,?)");
            pstm.setString(1, name);
            pstm.setString(2, ap);
            pstm.setString(3, am);
            pstm.setString(4, mail);
            pstm.setInt(5, edad);
            pstm.execute();
            pstm.close();
            return true;
        } catch (SQLException e) {
           return false;
        }
    }

    public boolean updatePersona(int id, String name, String paterno, String materno, String mail,int edad,String celular) {
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("update persona "
                    + "set nombres = ? ,"
                    + "appPaterno = ? ,"
                    + "appMaterno = ? ,"
                    + "mail = ? ,"
                    + "edad = ? ,"
                    + "celular= ? " 
                    + "where id = ? ");
            pstm.setString(1, name);
            pstm.setString(2, paterno);
            pstm.setString(3, materno);
            pstm.setString(4, mail);
            pstm.setInt(5, edad); 
            pstm.setString(6, celular);
            pstm.setInt(7, id);//modifice
            pstm.execute();
            pstm.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean deletePersona(String cod) {
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("delete from persona where id = ?");
            pstm.setString(1, cod);
            pstm.execute();
            pstm.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    /*obtenemos todos los datos de la tabla*/
    public Object[][] obtenerPersonas() {
        int numePerson;
        //obtenemos la cantidad de registros existentes en la tabla
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(*) as total FROM persona ");
            ResultSet res = pstm.executeQuery();
            res.next();
            numePerson = res.getInt("total");
            res.close();
        } catch (SQLException e) {
            return null;
        }

        Object[][] personas = new Object[numePerson][7];
        //realizamos la consulta sql y llenamos los datos en "Object"
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT "
                    + "*"
                    + " FROM persona"
                    + " ORDER BY id ");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                String estCodigo = res.getString("id");
                String estNombre = res.getString("nombres");
                String estpaterno = res.getString("appPaterno");
                String estmaterno = res.getString("appMaterno");
                String estmail = res.getString("mail");
                String edad = res.getString("edad");
                String celular = res.getString("celular");
                personas[i][0] = estCodigo;
                personas[i][1] = estNombre;
                personas[i][2] = estpaterno;
                personas[i][3] = estmaterno;
                personas[i][4] = estmail;
                personas[i][5] = edad;
                personas[i][6] = celular;
                i++;
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return personas;
    }
}
