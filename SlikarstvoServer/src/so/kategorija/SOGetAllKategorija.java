/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.kategorija;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Kategorija;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Tina
 */
public class SOGetAllKategorija extends AbstractSO{

    private ArrayList<Kategorija> lista;
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Kategorija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Kategorija!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> kategorije = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Kategorija>) (ArrayList<?>) kategorije;
    }

    public ArrayList<Kategorija> getLista() {
        return lista;
    }
    
    
}
