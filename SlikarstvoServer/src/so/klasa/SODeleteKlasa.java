/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.klasa;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Klasa;
import so.AbstractSO;

/**
 *
 * @author Tina
 */
public class SODeleteKlasa extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Klasa)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Klasa!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().delete(ado);
    }
    
}
