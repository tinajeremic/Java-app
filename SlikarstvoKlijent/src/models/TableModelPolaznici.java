/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import controller.ClientController;
import domain.Polaznik;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tina
 */
public class TableModelPolaznici extends AbstractTableModel implements Runnable{

    private ArrayList<Polaznik> lista;
    private String[] kolone = {"ID", "Ime", "Prezime", "Pol", "Kategorija"};
    private String parametar = "";
    
    public TableModelPolaznici() {
        try {
            lista = ClientController.getInstance().getAllPolaznik();
        } catch (Exception ex) {
            Logger.getLogger(TableModelPolaznici.class.getName()).log(Level.SEVERE, null, ex);
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
        Polaznik p = lista.get(row);

        switch (column) {
            case 0:
                return p.getPolaznikID();
            case 1:
                return p.getImePolaznika();
            case 2:
                return p.getPrezimePolaznika();
            case 3:
                return p.getPol();
            case 4:
                return p.getKategorija();

            default:
                return null;
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }   
    
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(10000);
                refreshTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TableModelPolaznici.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllPolaznik();
            if (!parametar.equals("")) {
                ArrayList<Polaznik> novaLista = new ArrayList<>();
                for (Polaznik p : lista) {
                    if (p.getImePolaznika().toLowerCase().contains(parametar.toLowerCase())
                            || p.getPrezimePolaznika().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(p);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Polaznik getSelectedPolaznik(int row) {
        return lista.get(row);
    }

    public void setParametar2(String parametar) {
        System.out.println("Selected category: " + parametar);
        this.parametar = parametar;
        refreshTable2();
    }

    private void refreshTable2() {
        try {
        lista = ClientController.getInstance().getAllPolaznik();
        if (!parametar.equals("")) {
            ArrayList<Polaznik> novaLista = new ArrayList<>();
            for (Polaznik p : lista) {                
                if (p.getKategorija().toString().toLowerCase().contains(parametar.toLowerCase())) {
                    novaLista.add(p);
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
