/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.polaznik;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Polaznik;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Tina
 */
public class SOGetAllPolaznik extends AbstractSO{

    private ArrayList<Polaznik> lista;
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Polaznik)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Clan!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> polaznici = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Polaznik>) (ArrayList<?>) polaznici;
    }
    
    public ArrayList<Polaznik> getLista() {
        return lista;
    }
}
