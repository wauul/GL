/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avocado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Waul
 */
public class ListeConfreres extends javax.swing.JPanel {

    Connection conn = null;
    PreparedStatement req = null;
    ResultSet res = null;
    
public static int GetIds(){
        return Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            }
    

public void AffichageMembre(){
    conn = Avocado.DBConn();
    String sql = "SELECT  Id_Conf , `Nom_Conf`, `Prenom_Conf`, `Ville`, `Add_Conf`, `Tel_Conf`, `Email_Conf`, `Type_Conf`, `Description` FROM `confreres`, utilisateur WHERE `Id_Conf` IN (utilisateur.Id_Avoc)";
    try{
        req = conn.prepareStatement(sql);
        res = req.executeQuery();
        int k= 0;
        int i = 0;
        if(res.next()){
                    res.last();
                    k=res.getRow();
                    res.beforeFirst();
                }
               Object[][] t=new Object[k][9];
        
        while(res.next())
        {
                   t[i][0]=res.getString(1);
                   t[i][1]=res.getString(2);
                   t[i][2]=res.getString(3);
                   t[i][3]=res.getString(4);
                   t[i][4]=res.getString(5);
                   t[i][5]=res.getString(6);
                   t[i][6]=res.getString(7);
                   t[i][7]=res.getString(8);
                   t[i][8]=res.getString(9);
                   i++;
                }
               
                res.close();
         final String columnNames[] = {"ID","Nom","Prénom","Ville", "Adresse", "Numéro de téléphone", "Email", "Poste", "Description"};
         jTable1.setModel(new DefaultTableModel(t,columnNames));
         ListSelectionModel listMod =  jTable1.getSelectionModel();
         listMod.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         listMod.addListSelectionListener(jTable1);
        
    }   catch (SQLException ex) {
            Logger.getLogger(ListeConfreres.class.getName()).log(Level.SEVERE, null, ex);
        }
}

public void AffichageConfrere(){
    conn = Avocado.DBConn();
    String sql = "SELECT  Id_Conf , `Nom_Conf`, `Prenom_Conf`, `Ville`, `Add_Conf`, `Tel_Conf`, `Email_Conf`, `Type_Conf`, `Description` FROM `confreres`";
    try{
        req = conn.prepareStatement(sql);
        res = req.executeQuery();
        int k= 0;
        int i = 0;
        if(res.next()){
                    res.last();
                    k=res.getRow();
                    res.beforeFirst();
                }
               Object[][] t=new Object[k][9];
        
        while(res.next())
        {
                   t[i][0]=res.getString(1);
                   t[i][1]=res.getString(2);
                   t[i][2]=res.getString(3);
                   t[i][3]=res.getString(4);
                   t[i][4]=res.getString(5);
                   t[i][5]=res.getString(6);
                   t[i][6]=res.getString(7);
                   t[i][7]=res.getString(8);
                   t[i][8]=res.getString(9);
                   i++;
                }
               
                res.close();
         final String columnNames[] = {"ID","Nom","Prénom","Ville", "Adresse", "Numéro de téléphone", "Email", "Poste", "Description"};
         jTable1.setModel(new DefaultTableModel(t,columnNames));
         ListSelectionModel listMod =  jTable1.getSelectionModel();
         listMod.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         listMod.addListSelectionListener(jTable1);
        
    }   catch (SQLException ex) {
            Logger.getLogger(ListeConfreres.class.getName()).log(Level.SEVERE, null, ex);
        }
}

public void Affichage(int b) {
    conn = Avocado.DBConn();
    String job= null;
        switch (b) {
            case 2:
                job = "Avocat";
                break;
            case 3:
                job = "Huissier";
                break;
            case 4:
                job = "Notaire";
                break;
            default:
                break;
        }
    String sql = "SELECT  `Nom_Conf`, `Prenom_Conf`, `Ville`, `Add_Conf`, `Tel_Conf`, `Email_Conf`, `Description` FROM `confreres` WHERE `Type_Conf` = ?";
    try{
        req = conn.prepareStatement(sql);
        req.setString(1, job);
        res = req.executeQuery();
        int k= 0;
        int i = 0;
        if(res.next()){
                    res.last();
                    k=res.getRow();
                    res.beforeFirst();
                }
               Object[][] t=new Object[k][7];
        
        while(res.next())
        {
                   t[i][0]=res.getString(1);
                   t[i][1]=res.getString(2);
                   t[i][2]=res.getString(3);
                   t[i][3]=res.getString(4);
                   t[i][4]=res.getString(5);
                   t[i][5]=res.getString(6);
                   t[i][6]=res.getString(7);
                   
                   i++;
                }
               
                res.close();
         final String columnNames[] = {"ID","Nom","Prénom","Ville", "Adresse", "Numéro de téléphone", "Email", "Description"};
         jTable1.setModel(new DefaultTableModel(t,columnNames));
         ListSelectionModel listMod =  jTable1.getSelectionModel();
         listMod.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         listMod.addListSelectionListener(jTable1);
        
    }   catch (SQLException ex) {
            Logger.getLogger(ListeConfreres.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    /**
     * Creates new form ListesAffaires
     */
    public ListeConfreres() {
        initComponents();
        if(AjoutAudience.getMembre() == 1) AffichageMembre();
        else{ 
            if(ConfrereMenu.getBtnC() == 1) AffichageConfrere();      
            else Affichage(ConfrereMenu.getBtnC());}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
