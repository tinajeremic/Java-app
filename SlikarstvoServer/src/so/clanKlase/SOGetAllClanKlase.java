/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.clanKlase;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.ClanKlase;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Tina
 */
public class SOGetAllClanKlase extends AbstractSO{

    private ArrayList<ClanKlase> lista;
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof ClanKlase)) {
            throw new Exception("Prosledjeni objekat nije instanca klase ClanKlase!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> clanoviKlase = DBBroker.getInstance().select(ado);
        lista = (ArrayList<ClanKlase>) (ArrayList<?>) clanoviKlase;
    }
    
    public ArrayList<ClanKlase> getLista() {
        return lista;
    }
}
