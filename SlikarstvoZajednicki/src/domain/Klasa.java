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
public class Klasa extends AbstractDomainObject{

    private Long klasaID;
    private String nazivKlase;
    private String opis;
    private int brojPolaznika;
    private Kategorija kategorija;
    private ArrayList<ClanKlase> clanoviKlase;

    public Klasa() {
        
    }

    public Klasa(Long klasaID, String nazivKlase, String opis, int brojPolaznika, Kategorija kategorija, ArrayList<ClanKlase> clanoviKlase) {
        this.klasaID = klasaID;
        this.nazivKlase = nazivKlase;
        this.opis = opis;
        this.brojPolaznika = brojPolaznika;
        this.kategorija = kategorija;      
        this.clanoviKlase = clanoviKlase;
        
    }

    @Override
    public String toString() {
        return nazivKlase + " (Kategorija: " + kategorija.getNazivKategorije() + ")";
    }       
    
    @Override
    public String nazivTabele() {
        return " klasa ";
    }

    @Override
    public String alijas() {
        return " kl ";
    }

    @Override
    public String join() {
        return " JOIN KATEGORIJA K ON (K.KATEGORIJAID = KL.KATEGORIJAID) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Kategorija k = new Kategorija(rs.getLong("KategorijaID"),
                    rs.getString("NazivKategorije"), rs.getString("OpisKategorije"));
            
            Klasa kl = new Klasa(rs.getLong("klasaID"), rs.getString("nazivKlase"), 
                    rs.getString("opisKlase"), rs.getInt("brojPolaznika"), k, null);
            
            
            
            lista.add(kl);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (nazivKlase, opisKlase, brojPolaznika, kategorijaID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " klasaID = " + klasaID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + nazivKlase + "', '" + opis + "', "
                + " " + brojPolaznika + ", " + kategorija.getKategorijaID() + " ";
    }

    @Override
    public String vrednostiZaUpdate() {
         return " nazivKlase = '" + nazivKlase + "', opisKlase = '" + opis + "', "
                + "brojPolaznika = " + brojPolaznika + ", kategorijaID = '" + 
                kategorija.getKategorijaID()+ "' ";
    }

    @Override
    public String uslov() {
        return "";
    }

    public Long getKlasaID() {
        return klasaID;
    }

    public void setKlasaID(Long klasaID) {
        this.klasaID = klasaID;
    }

    public String getNazivKlase() {
        return nazivKlase;
    }

    public void setNazivKlase(String nazivKlase) {
        this.nazivKlase = nazivKlase;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getBrojPolaznika() {
        return brojPolaznika;
    }

    public void setBrojPolaznika(int brojPolaznika) {
        this.brojPolaznika = brojPolaznika;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }

    public ArrayList<ClanKlase> getClanoviKlase() {
        return clanoviKlase;
    }

    public void setClanoviKlase(ArrayList<ClanKlase> clanoviKlase) {
        this.clanoviKlase = clanoviKlase;
    }
    
    
}
