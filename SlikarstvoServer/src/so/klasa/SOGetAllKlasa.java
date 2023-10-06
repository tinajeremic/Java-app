/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.klasa;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Klasa;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Tina
 */
public class SOGetAllKlasa extends AbstractSO{

    private ArrayList<Klasa> lista;
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Klasa)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Klasa!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> klase = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Klasa>) (ArrayList<?>) klase;
    }

    public ArrayList<Klasa> getLista() {
        return lista;
    }
    
    
}
