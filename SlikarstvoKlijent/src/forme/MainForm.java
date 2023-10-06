/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import controller.ClientController;
import formsPolaznik.FormNoviPolaznik;
import formsPolaznik.FormPretragaPolaznika;
import domain.Administrator;
import domain.ClanKlase;
import domain.Kategorija;
import domain.Klasa;
import domain.Polaznik;
import formsKlasa.FormPretragaKlasa;
import formsPolaznik.FormDetaljiPolaznik;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.TableModelClanoviKlase;
import models.TableModelPolaznici;

import session.Session;

/**
 *
 * @author Tina
 */
public class MainForm extends javax.swing.JFrame {

    Administrator ulogovani;    
    int brojClanova = 0;
    
    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        setLocationRelativeTo(null);
        this.ulogovani = Session.getInstance().getUlogovani();
        lblAdmin.setText("Ulogovani administrator: " + ulogovani);
        setTitle("RAJACKI");
        popuniKategorije();
                
        TableModelPolaznici model = new TableModelPolaznici();
        Thread th = new Thread(model);
        th.start();
        tblPolaznici.setModel(model);        
        tblClanoviKlase.setModel(new TableModelClanoviKlase());
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblAdmin = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        cmbKategorija = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtOpis = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNapomena = new javax.swing.JTextArea();
        btnDodajClana = new javax.swing.JButton();
        btnObrisiClana = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblClanoviKlase = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPolaznici = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        btnIzracunaj = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lblBrojClanova = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miNoviPolaznik = new javax.swing.JMenuItem();
        miPretragaPolaznika = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        miPretragaKlasa = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        miLogout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        lblAdmin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAdmin.setForeground(new java.awt.Color(255, 255, 255));
        lblAdmin.setText("Admin:");

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "UNOS KLASE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semibold", 3, 18), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Naziv klase:");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Kategorija:");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Opis klase:");

        cmbKategorija.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbKategorija.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbKategorijaItemStateChanged(evt);
            }
        });

        txtOpis.setColumns(20);
        txtOpis.setRows(5);
        jScrollPane1.setViewportView(txtOpis);

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "UNOS CLANA KLASE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semibold", 3, 18), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Polaznik:");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Napomena:");

        txtNapomena.setColumns(20);
        txtNapomena.setRows(5);
        jScrollPane2.setViewportView(txtNapomena);

        btnDodajClana.setBackground(new java.awt.Color(51, 102, 0));
        btnDodajClana.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        btnDodajClana.setForeground(new java.awt.Color(255, 255, 255));
        btnDodajClana.setText("Dodaj clana");
        btnDodajClana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajClanaActionPerformed(evt);
            }
        });

        btnObrisiClana.setBackground(new java.awt.Color(153, 0, 0));
        btnObrisiClana.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        btnObrisiClana.setForeground(new java.awt.Color(255, 255, 255));
        btnObrisiClana.setText("Obrisi clana");
        btnObrisiClana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiClanaActionPerformed(evt);
            }
        });

        tblClanoviKlase.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblClanoviKlase);

        tblPolaznici.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tblPolaznici);

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Polaznici koji ce postati aktivni clanovi ove klase:");

        btnIzracunaj.setBackground(new java.awt.Color(0, 204, 204));
        btnIzracunaj.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        btnIzracunaj.setForeground(new java.awt.Color(255, 255, 255));
        btnIzracunaj.setText("Izracunaj broj clanova");
        btnIzracunaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzracunajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnIzracunaj)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(493, 493, 493))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnDodajClana)
                                            .addComponent(btnObrisiClana)))
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(btnDodajClana)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnObrisiClana))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel5))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnIzracunaj)))
                .addContainerGap(274, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNaziv)
                    .addComponent(cmbKategorija, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbKategorija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSave.setBackground(new java.awt.Color(204, 255, 204));
        btnSave.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        btnSave.setForeground(new java.awt.Color(51, 0, 102));
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 3, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 153));
        jLabel7.setText("Broj clanova: ");

        lblBrojClanova.setFont(new java.awt.Font("Segoe UI Semibold", 3, 16)); // NOI18N
        lblBrojClanova.setForeground(new java.awt.Color(0, 0, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBrojClanova, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lblBrojClanova, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 204, 204));
        jMenuBar1.setBorder(null);
        jMenuBar1.setForeground(new java.awt.Color(102, 0, 102));

        jMenu1.setBackground(new java.awt.Color(204, 204, 255));
        jMenu1.setText("POLAZNIK");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        miNoviPolaznik.setText("Novi polaznik");
        miNoviPolaznik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNoviPolaznikActionPerformed(evt);
            }
        });
        jMenu1.add(miNoviPolaznik);

        miPretragaPolaznika.setText("Pretraga polaznika");
        miPretragaPolaznika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPretragaPolaznikaActionPerformed(evt);
            }
        });
        jMenu1.add(miPretragaPolaznika);

        jMenuBar1.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(255, 204, 204));
        jMenu2.setText("KLASA");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        miPretragaKlasa.setText("Pretraga klasa");
        miPretragaKlasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPretragaKlasaActionPerformed(evt);
            }
        });
        jMenu2.add(miPretragaKlasa);

        jMenuBar1.add(jMenu2);

        jMenu3.setBackground(new java.awt.Color(153, 51, 0));
        jMenu3.setText("LOG OUT");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        miLogout.setText("Log out");
        miLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLogoutActionPerformed(evt);
            }
        });
        jMenu3.add(miLogout);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miNoviPolaznikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNoviPolaznikActionPerformed
        new FormNoviPolaznik(this, true).setVisible(true);
    }//GEN-LAST:event_miNoviPolaznikActionPerformed

    private void miPretragaPolaznikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPretragaPolaznikaActionPerformed
        new FormPretragaPolaznika(this, true).setVisible(true);
    }//GEN-LAST:event_miPretragaPolaznikaActionPerformed

    private void btnDodajClanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajClanaActionPerformed
        
        if(txtNapomena.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Morate uneti i napomenu.");
            return;
        }
        
        String napomena = txtNapomena.getText();
        System.out.println("napomena: " + napomena);
        
        int row = tblPolaznici.getSelectedRow();
        
        if (row >= 0) {
            Polaznik p = ((TableModelPolaznici) tblPolaznici.getModel()).getSelectedPolaznik(row);         
            
            ClanKlase clan = new ClanKlase(null, -1, napomena, p);
            System.out.println(clan);
            
            TableModelClanoviKlase tm = (TableModelClanoviKlase) tblClanoviKlase.getModel();
            
            if (tm.postojiPolaznik(p)) {
            JOptionPane.showMessageDialog(this, "Vec ste uneli ovog polaznika!");
            return;
            }
            
            tm.dodajClanaKlase(clan);
            txtNapomena.setText("");
            
        }                                
        
    }//GEN-LAST:event_btnDodajClanaActionPerformed

    private void btnObrisiClanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiClanaActionPerformed
       
        int row = tblClanoviKlase.getSelectedRow();
        
        if (row >= 0) {
            TableModelClanoviKlase tm = (TableModelClanoviKlase) tblClanoviKlase.getModel();
            tm.obrisiClana(row);
                        

        }
    }//GEN-LAST:event_btnObrisiClanaActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
        try {
            if(txtNaziv.getText().isEmpty() || txtOpis.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Morate nazvati i opisati klasu koju kreirate!");
                return;
            }
            
            if (brojClanova == 0) {
                JOptionPane.showMessageDialog(this, "Morate izracunati broj clanova!");
                return;
            }
            
            String naziv = txtNaziv.getText();
            String opis = txtOpis.getText();
            Kategorija kategorija = (Kategorija) cmbKategorija.getSelectedItem();
            
            TableModelClanoviKlase tm = (TableModelClanoviKlase) tblClanoviKlase.getModel();
            
            Klasa k = new Klasa(null, naziv, opis, brojClanova, kategorija, tm.getLista());
                                    
            ClientController.getInstance().addKlasa(k);
            resetujFormu();
            JOptionPane.showMessageDialog(this, "KREIRALI STE KLASU");
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            
        }
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnIzracunajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzracunajActionPerformed
        
        int result = JOptionPane.showOptionDialog(this, "Da li je ovo konacna struktura koju unosite?", "Računavanje broja članova",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        
        if (result == JOptionPane.YES_OPTION){
        TableModelClanoviKlase tm = (TableModelClanoviKlase) tblClanoviKlase.getModel();
        int brojRedova = tm.getRowCount();
        brojClanova = brojRedova;
        lblBrojClanova.setText(Integer.toString(brojClanova));
        }
        
    }//GEN-LAST:event_btnIzracunajActionPerformed

    private void miPretragaKlasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPretragaKlasaActionPerformed
        new FormPretragaKlasa(this, true).setVisible(true);
    }//GEN-LAST:event_miPretragaKlasaActionPerformed

    private void miLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLogoutActionPerformed
        
        int result = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da "
                + "se odjavite sa sistema?", "Konfirmacija", JOptionPane.YES_NO_OPTION);
        
        if (result == JOptionPane.NO_OPTION) {
            return;
        }
        
        if (result == JOptionPane.YES_OPTION) {
            new LoginForm().setVisible(true);
            this.dispose();
        }
        
    }//GEN-LAST:event_miLogoutActionPerformed

    private void cmbKategorijaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbKategorijaItemStateChanged
        
       
        
    }//GEN-LAST:event_cmbKategorijaItemStateChanged

   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajClana;
    private javax.swing.JButton btnIzracunaj;
    private javax.swing.JButton btnObrisiClana;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cmbKategorija;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblBrojClanova;
    private javax.swing.JMenuItem miLogout;
    private javax.swing.JMenuItem miNoviPolaznik;
    private javax.swing.JMenuItem miPretragaKlasa;
    private javax.swing.JMenuItem miPretragaPolaznika;
    private javax.swing.JTable tblClanoviKlase;
    private javax.swing.JTable tblPolaznici;
    private javax.swing.JTextArea txtNapomena;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextArea txtOpis;
    // End of variables declaration//GEN-END:variables

    private void popuniKategorije() {
        try {
            ArrayList<Kategorija> kategorije = ClientController.getInstance().getAllKategorija();

            cmbKategorija.removeAllItems();

            for (Kategorija kategorija : kategorije) {
                cmbKategorija.addItem(kategorija);
            }

        } catch (Exception ex) {
            Logger.getLogger(FormNoviPolaznik.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void refreshTable() {
        TableModelPolaznici tm = (TableModelPolaznici) tblPolaznici.getModel();
        tm.refreshTable();
    }

    private void resetujFormu() {
        tblClanoviKlase.setModel(new TableModelClanoviKlase());
        lblBrojClanova.setText("0");
        brojClanova = 0;
        txtNaziv.setText("");
        txtOpis.setText("");
        txtNapomena.setText("");
   }

   
}
