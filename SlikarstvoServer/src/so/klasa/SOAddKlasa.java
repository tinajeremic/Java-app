/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.klasa;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.ClanKlase;
import domain.Klasa;
import so.AbstractSO;
import java.sql.*;

/**
 *
 * @author Tina
 */
public class SOAddKlasa extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Klasa)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Klasa!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
       
        PreparedStatement ps = DBBroker.getInstance().insert(ado);
        
        ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();
        Long klasaID = tableKeys.getLong(1);
        
        Klasa k = (Klasa) ado;
        k.setKlasaID(klasaID);

        for (ClanKlase clanKlase : k.getClanoviKlase()) {
            clanKlase.setKlasa(k);
            DBBroker.getInstance().insert(clanKlase);                 
        }
    }
    
}
