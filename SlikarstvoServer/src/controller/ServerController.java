/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Administrator;
import domain.ClanKlase;
import domain.Kategorija;
import domain.Klasa;
import domain.Polaznik;
import java.util.ArrayList;
import so.clanKlase.SOGetAllClanKlase;
import so.kategorija.SOGetAllKategorija;
import so.klasa.SOAddKlasa;
import so.klasa.SODeleteKlasa;
import so.klasa.SOGetAllKlasa;
import so.klasa.SOGetAllKlasaPolaznik;
import so.klasa.SOUpdateKlasa;
import so.login.SOLogin;
import so.polaznik.SOAddPolaznik;
import so.polaznik.SODeletePolaznik;
import so.polaznik.SOGetAllPolaznik;
import so.polaznik.SOUpdatePolaznik;

/**
 *
 * @author Tina
 */
public class ServerController {
    
    private static ServerController instance;

    public ServerController() {
    }

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    public Administrator login(Administrator administrator) throws Exception {
        SOLogin so = new SOLogin();
        so.templateExecute(administrator);
        return so.getUlogovani();
    }

    public Object getAllKategorija() throws Exception {
        SOGetAllKategorija so = new SOGetAllKategorija();
        so.templateExecute(new Kategorija());
        return so.getLista();
    }

    public void addPolaznik(Polaznik polaznik) throws Exception {
        (new SOAddPolaznik()).templateExecute(polaznik);
    }

    public ArrayList<Polaznik> getAllPolaznik() throws Exception {
        SOGetAllPolaznik so = new SOGetAllPolaznik();
        so.templateExecute(new Polaznik());
        return so.getLista();
    }

    public void deletePolaznik(Polaznik polaznik) throws Exception {
        (new SODeletePolaznik()).templateExecute(polaznik);
    }

    public void updatePolaznik(Polaznik polaznik) throws Exception {
        (new SOUpdatePolaznik()).templateExecute(polaznik);
    }

    public ArrayList<ClanKlase> getAllClanKlase(Klasa k) throws Exception {
        SOGetAllClanKlase so = new SOGetAllClanKlase();
        
        ClanKlase ck = new ClanKlase();
        ck.setKlasa(k);
        
        so.templateExecute(ck);
        return so.getLista();
    }
    
   
  

    public void addKlasa(Klasa klasa) throws Exception {             
        
        (new SOAddKlasa()).templateExecute(klasa);
    }

    public ArrayList<Klasa> getAllKlasa() throws Exception {
        SOGetAllKlasa so = new SOGetAllKlasa();
        so.templateExecute(new Klasa());
        return so.getLista();
    }

    public void deleteKlasa(Klasa klasa) throws Exception {
        (new SODeleteKlasa()).templateExecute(klasa);
    }

    public void updateKlasa(Klasa klasa) throws Exception {
        (new SOUpdateKlasa()).templateExecute(klasa);
    }

    /*public ArrayList<Klasa> getAllKlasePolaznik(Polaznik polaznik) throws Exception {
    ArrayList<Klasa> sveKlase = getAllKlasa(); // Dobijanje svih klasa
    ArrayList<ClanKlase> sviClanovi = new ArrayList<>();

    // Dobijanje svih članova klasa
    for (Klasa klasa : sveKlase) {
        sviClanovi.addAll(getAllClanKlase(klasa));
    }

    ArrayList<Klasa> klasePolaznika = new ArrayList<>();

    // Pronalaženje klasa za datog polaznika
    for (ClanKlase clan : sviClanovi) {
        if (clan.getPolaznik().equals(polaznik)) {
            klasePolaznika.add(clan.getKlasa());
        }
    }

    return klasePolaznika;
}*/

    
    
}
