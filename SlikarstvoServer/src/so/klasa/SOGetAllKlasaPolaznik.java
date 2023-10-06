/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.klasa;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.ClanKlase;
import domain.Klasa;
import domain.Polaznik;
import java.util.ArrayList;
import so.AbstractSO;
import so.clanKlase.SOGetAllClanKlase;

/**
 *
 * @author Tina
 */
public class SOGetAllKlasaPolaznik extends AbstractSO{

    private ArrayList<Klasa> lista;
    
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Klasa)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Klasa!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> klasePolaznika = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Klasa>) (ArrayList<?>) klasePolaznika;
        
    }
    

    public ArrayList<Klasa> getLista() {
        return lista;
    }
    
    
}
