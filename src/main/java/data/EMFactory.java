package data;

import javax.persistence.*;
import java.sql.SQLException;

public class EMFactory {

    public static EntityManagerFactory getEMF() throws SQLException {

               return Persistence.createEntityManagerFactory("florianDB");
    }

}
