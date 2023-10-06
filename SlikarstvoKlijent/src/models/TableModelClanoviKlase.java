/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import controller.ClientController;
import domain.ClanKlase;
import domain.Klasa;
import domain.Polaznik;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tina
 */
public class TableModelClanoviKlase extends AbstractTableModel{
    
    private ArrayList<ClanKlase> lista;
    private String[] kolone = {"Rb", "Polaznik", "Napomena"};
    private int rb = 0;
    
    public TableModelClanoviKlase() {
        lista = new ArrayList<>();
    }
    
    public TableModelClanoviKlase(Klasa k) {
        try {
            lista = ClientController.getInstance().getAllClanKlase(k);
        } catch (Exception ex) {
            Logger.getLogger(TableModelClanoviKlase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }    
    
    @Override
    public Object getValueAt(int row, int column) {
        ClanKlase clank = lista.get(row);
        
        switch (column) {
            case 0:
                return clank.getRbClana();
            case 1:
                return clank.getPolaznik();
            case 2:
                return clank.getNapomena();

            default:
                return null;
        }
        
    }

    public boolean postojiPolaznik(Polaznik p) {
        for (ClanKlase clanKlase : lista) {
            if (clanKlase.getPolaznik().getPolaznikID().equals(p.getPolaznikID())) {
                return true;
            }
        }
        return false;
    }

    public void dodajClanaKlase(ClanKlase clan) {
        rb = lista.size();
        clan.setRbClana(++rb);
        lista.add(clan);
        fireTableDataChanged();
        System.out.println(lista);
    }

    public void obrisiClana(int row) {
        lista.remove(row);

        rb = 0;
        for (ClanKlase clanKlase : lista) {
            clanKlase.setRbClana(++rb);
        }

        fireTableDataChanged();
        System.out.println(lista);
    }

    public ArrayList<ClanKlase> getLista() {
        System.out.println(lista);
        return lista;
    }

    public ClanKlase getClanKlaseAtRow(int row) {
        return lista.get(row);
    }
    
    
}
