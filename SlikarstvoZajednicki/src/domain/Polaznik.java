/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Tina
 */
public class Polaznik extends AbstractDomainObject{

    private Long polaznikID;
    private String imePolaznika;
    private String prezimePolaznika;
    private String pol;
    private int godine;
    private String kontaktTelefon;
    private Kategorija kategorija;   

    public Polaznik() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Polaznik other = (Polaznik) obj;
        return Objects.equals(this.polaznikID, other.polaznikID);
    }
    

    
    
    

    public Polaznik(Long ucesnikID, String imeUcesnika, String prezimeUcesnika, String pol, int godine, String kontaktTelefon, Kategorija kategorija) {
        this.polaznikID = ucesnikID;
        this.imePolaznika = imeUcesnika;
        this.prezimePolaznika = prezimeUcesnika;
        this.pol = pol;
        this.godine = godine;
        this.kontaktTelefon = kontaktTelefon;
        this.kategorija = kategorija;
    }

    @Override
    public String toString() {
        return imePolaznika + " " + prezimePolaznika;
    }
    
    
    
    @Override
    public String nazivTabele() {
        return " polaznik ";
    }

    @Override
    public String alijas() {
        return " p ";
    }

    @Override
    public String join() {
        return " JOIN KATEGORIJA K ON (K.KATEGORIJAID = P.KATEGORIJAID) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            
            Kategorija k = new Kategorija(rs.getLong("KategorijaID"),
                    rs.getString("NazivKategorije"), rs.getString("OpisKategorije"));
            
            Polaznik p = new Polaznik(rs.getLong("polaznikID"), rs.getString("imePolaznika"), 
                    rs.getString("prezimePolaznika"), rs.getString("pol"), 
                    rs.getInt("godine"), rs.getString("kontaktTelefon"), k);

            lista.add(p);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (imePolaznika, prezimePolaznika, pol, godine, kontaktTelefon, kategorijaID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " polaznikID = " + polaznikID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + imePolaznika + "', '" + prezimePolaznika + "', "
                + "'" + pol + "', " + godine + ", '" + kontaktTelefon + "', " 
                + kategorija.getKategorijaID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return " pol = '" + pol + "', godine = '" + godine + "', "
                + "KontaktTelefon = '" + kontaktTelefon + "', KategorijaID = " +
                kategorija.getKategorijaID();
    }

    @Override
    public String uslov() {
        return "";
    }

    public Long getPolaznikID() {
        return polaznikID;
    }

    public void setPolaznikID(Long polaznikID) {
        this.polaznikID = polaznikID;
    }

    public String getImePolaznika() {
        return imePolaznika;
    }

    public void setImePolaznika(String imePolaznika) {
        this.imePolaznika = imePolaznika;
    }

    public String getPrezimePolaznika() {
        return prezimePolaznika;
    }

    public void setPrezimePolaznika(String prezimePolaznika) {
        this.prezimePolaznika = prezimePolaznika;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public int getGodine() {
        return godine;
    }

    public void setGodine(int godine) {
        this.godine = godine;
    }

    public String getKontaktTelefon() {
        return kontaktTelefon;
    }

    public void setKontaktTelefon(String kontaktTelefon) {
        this.kontaktTelefon = kontaktTelefon;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }
    
}
