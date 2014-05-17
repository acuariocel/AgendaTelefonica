package contactos;

import java.sql.*;

public class persona {

    conectate con;

    public persona() {
        con = new conectate();
    }

    /*Añade un nuevo registro*/
    public void NuevaPersona(String name, String ap, String am, String mail, String edad) {
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("insert into "
                    + "persona(nombres, appPaterno, appMaterno, mail) "
                    + " values(?,?,?,?,?)");
            pstm.setString(1, name);
            pstm.setString(2, ap);
            pstm.setString(3, am);
            pstm.setString(4, mail);
            pstm.setString(5, edad);
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updatePersona(String id, String name, String paterno, String materno, String mail,String edad) {
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("update persona "
                    + "set nombres = ? ,"
                    + "appPaterno = ? ,"
                    + "appMaterno = ? ,"
                    + "mail = ? ,"
                    + "edad = ? "//agrege 
                    + "where id = ? ");
            pstm.setString(1, name);
            pstm.setString(2, paterno);
            pstm.setString(3, materno);
            pstm.setString(4, mail);
            pstm.setString(5, edad);//agrege 
            pstm.setString(6, String.valueOf(id));//modifice
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deletePersona(String cod) {
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("delete from persona where id = ?");
            pstm.setString(1, cod);
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /*obtenemos todos los datos de la tabla*/
    public Object[][] getDatos() {
        int registros = 0;
        //obtenemos la cantidad de registros existentes en la tabla
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM persona ");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        Object[][] data = new String[registros][6];
        //realizamos la consulta sql y llenamos los datos en "Object"
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT "
                    + " id, nombres, appPaterno, appMaterno, mail, edad "
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
                data[i][0] = estCodigo;
                data[i][1] = estNombre;
                data[i][2] = estpaterno;
                data[i][3] = estmaterno;
                data[i][4] = estmail;
                data[i][5] = edad;
                i++;
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }
}
