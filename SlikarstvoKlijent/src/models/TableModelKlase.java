/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import controller.ClientController;
import domain.Klasa;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tina
 */
public class TableModelKlase extends AbstractTableModel implements Runnable{

    private ArrayList<Klasa> lista;
    private String[] kolone = {"ID", "Naziv", "Opis", "Broj clanova", "Kategorija"};
    private String parametar = "";
    
    public TableModelKlase() {
        try {
            lista = ClientController.getInstance().getAllKlasa();
        } catch (Exception ex) {
            Logger.getLogger(TableModelKlase.class.getName()).log(Level.SEVERE, null, ex);
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
        Klasa k = lista.get(row);
        
        switch (column) {
            case 0:
                return k.getKlasaID();
            case 1:
                return k.getNazivKlase();
            case 2:
                return k.getOpis();
            case 3:
                return k.getBrojPolaznika();  
            case 4:
                return k.getKategorija(); 
            default:
                return null;
        }
    }

    public Klasa getSelectedKlasa(int row) {
        return lista.get(row);
    }
    
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(10000);
                refreshTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TableModelKlase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }    
    
    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllKlasa();
            if (!parametar.equals("")) {
                ArrayList<Klasa> novaLista = new ArrayList<>();
                for (Klasa k : lista) {
                    if (k.getNazivKlase().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(k);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
