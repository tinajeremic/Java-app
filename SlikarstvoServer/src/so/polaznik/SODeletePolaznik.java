/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.polaznik;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Polaznik;
import so.AbstractSO;

/**
 *
 * @author Tina
 */
public class SODeletePolaznik extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Polaznik)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Clan!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().delete(ado);
    }
    
}
