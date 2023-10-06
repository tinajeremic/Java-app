/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tina
 */
public class ClanKlase extends AbstractDomainObject{
    
    private Klasa klasa;
    private int rbClana;
    private String napomena;
    private Polaznik polaznik;

    public ClanKlase() {
    }

    public ClanKlase(Klasa klasa, int rbClana, String napomena, Polaznik polaznik) {
        this.klasa = klasa;
        this.rbClana = rbClana;
        this.napomena = napomena;
        this.polaznik = polaznik;
    }

    
    
    public Klasa getKlasa() {
        return klasa;
    }

    public void setKlasa(Klasa klasa) {
        this.klasa = klasa;
    }

    public int getRbClana() {
        return rbClana;
    }

    public void setRbClana(int rbClana) {
        this.rbClana = rbClana;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public Polaznik getPolaznik() {
        return polaznik;
    }

    public void setPolaznik(Polaznik polaznik) {
        this.polaznik = polaznik;
    }

    @Override
    public String nazivTabele() {
        return " clanklase "; 
    }

    @Override
    public String alijas() {
        return " ckl ";
    }

    @Override
    public String join() {
        return " JOIN KLASA KL ON (KL.KLASAID = CKL.KLASAID) "
                + "JOIN POLAZNIK P ON (P.POLAZNIKID = CKL.POLAZNIKID) "
                + "JOIN KATEGORIJA K ON (K.KATEGORIJAID = P.KATEGORIJAID) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
         ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Kategorija k = new Kategorija(rs.getLong("KategorijaID"),
                    rs.getString("NazivKategorije"), rs.getString("OpisKategorije"));
            
            Klasa kl = new Klasa(rs.getLong("klasaID"), rs.getString("nazivKlase"), 
                    rs.getString("opisKlase"), rs.getInt("brojPolaznika"), k, null);
            
            Polaznik p = new Polaznik(rs.getLong("polaznikID"), rs.getString("imePolaznika"), 
                    rs.getString("prezimePolaznika"), rs.getString("pol"), 
                    rs.getInt("godine"), rs.getString("kontaktTelefon"), k);
            
            ClanKlase ckl = new ClanKlase(kl, rs.getInt("rbClana"), 
                    rs.getString("napomena"), p);

            lista.add(ckl);
        }

        rs.close();        
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (klasaID, rbClana, napomena, polaznikID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " klasaID = " + klasa.getKlasaID();
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + klasa.getKlasaID() + " ,  " + rbClana + " , "
                + "'" + napomena + "',  " + polaznik.getPolaznikID()+ " ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        if (klasa != null) {
        return " WHERE KL.KLASAID = " + klasa.getKlasaID();
    } else {
        return " WHERE KL.KLASAID IS NULL"; 
    }
    }

    @Override
    public String toString() {
        return "ClanKlase{" + "klasa=" + klasa + ", rbClana=" + rbClana + ", napomena=" + napomena + ", polaznik=" + polaznik + '}';
    }

   
    
    
}
