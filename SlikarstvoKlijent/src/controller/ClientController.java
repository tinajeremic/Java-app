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
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import session.Session;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

/**
 *
 * @author Tina
 */
public class ClientController {
    
    private static ClientController instance;

    public ClientController() {
    }

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    public Administrator login(Administrator administrator) throws Exception {
        return (Administrator) sendRequest(Operation.LOGIN, administrator);
    }

    private Object sendRequest(int operation, Object data) throws Exception {
        
        Request request = new Request(operation, data);

        ObjectOutputStream out = new ObjectOutputStream(Session.getInstance().getSocket().getOutputStream());
        out.writeObject(request);

        ObjectInputStream in = new ObjectInputStream(Session.getInstance().getSocket().getInputStream());
        Response response = (Response) in.readObject();

        if (response.getResponseStatus().equals(ResponseStatus.Error)) {
            throw response.getException();
        } else {
            return response.getData();
        }
        
    }

    public ArrayList<Kategorija> getAllKategorija() throws Exception {
        return (ArrayList<Kategorija>) sendRequest(Operation.GET_ALL_KATEGORIJA, null);
    }

    public void addPolaznik(Polaznik polaznik) throws Exception {
        sendRequest(Operation.ADD_POLAZNIK, polaznik);
    }

    public ArrayList<Polaznik> getAllPolaznik() throws Exception {
        return (ArrayList<Polaznik>) sendRequest(Operation.GET_ALL_POLAZNIK, null);
    }

    public void deleteClan(Polaznik polaznik) throws Exception {
        sendRequest(Operation.DELETE_POLAZNIK, polaznik);
    }

    public void updateClan(Polaznik polaznik) throws Exception {
        sendRequest(Operation.UPDATE_POLAZNIK, polaznik);
    }

    public ArrayList<ClanKlase> getAllClanKlase(Klasa k) throws Exception {
        return (ArrayList<ClanKlase>) sendRequest(Operation.GET_ALL_CLAN_KLASE, k);
    }

    public void addKlasa(Klasa klasa) throws Exception {
      
        
        sendRequest(Operation.ADD_KLASA, klasa);
    }

    public ArrayList<Klasa> getAllKlasa() throws Exception {
        return (ArrayList<Klasa>) sendRequest(Operation.GET_ALL_KLASA, null);
    }

    public void deleteKlasa(Klasa klasa) throws Exception {
        sendRequest(Operation.DELETE_KLASA, klasa);
    }

    public void updateKlasa(Klasa klasa) throws Exception {
        sendRequest(Operation.UPDATE_KLASA, klasa);
    }

    

    /*public ArrayList<Klasa> getAllKlasaPolaznik(Polaznik p) throws Exception {
        return (ArrayList<Klasa>) sendRequest(Operation.GET_ALL_KLASA_POLAZNIK, p);
    }*/
    
    
}
