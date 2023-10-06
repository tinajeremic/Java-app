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
public class SOAddPolaznik extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Polaznik)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Polaznik!");
        }
        
        Polaznik polaznik = (Polaznik) ado;
        
        if (polaznik.getKategorija().getNazivKategorije().equals("Mladji")) {
            if (polaznik.getGodine() < 7 || polaznik.getGodine() > 13) {
                throw new Exception("Mladji polaznik mora imati izmedju 7 i 13 godina!");
            }
        }
        
        if (polaznik.getKategorija().getNazivKategorije().equals("Srednji")) {
            if (polaznik.getGodine() < 14 || polaznik.getGodine() > 18) {
                throw new Exception("Srednji polaznik mora imati izmedju 13 i 18 godina!");
            }
        }
        
        if (polaznik.getKategorija().getNazivKategorije().equals("Odrasli")) {
            if (polaznik.getGodine() < 18) {
                throw new Exception("Odrasli polaznik mora imati 18 i vise godina!");
            }
        }
        
        ArrayList<Polaznik> polaznici = (ArrayList<Polaznik>) (ArrayList<?>) DBBroker.getInstance().select(ado);
        
        for (Polaznik postojeciPolaznik : polaznici) {
            if (postojeciPolaznik.getKontaktTelefon().equals(polaznik.getKontaktTelefon())) {
                throw new Exception("Vec postoji polaznik sa unetim brojem telefona!");
            }
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().insert(ado);
    }
    
}
