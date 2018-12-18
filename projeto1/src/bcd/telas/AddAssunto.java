package bcd.telas;

import bcd.ConnectionFactory;
import bcd.DAO.AssuntosDAO;
import bcd.DAO.DisciplinasDAO;
import bcd.tabelas.Assunto;
import bcd.tabelas.Disciplina;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author luisa
 */
public class AddAssunto extends javax.swing.JPanel {

    private FramePrincipal pai;
    private DisciplinasDAO dDAO;

    public AddAssunto(FramePrincipal pai) {
        initComponents();

        this.pai = pai;

        jCBdisc.removeAllItems();

        this.dDAO = new DisciplinasDAO();
        try (Connection conexao = ConnectionFactory.getConnetion()) {
            List<Disciplina> dd = dDAO.listar(conexao);
            for (Disciplina d : dd) {
                jCBdisc.addItem(d.getNome_disc());
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddAssunto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTFassunto = new javax.swing.JTextField();
        jBadd = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jCBdisc = new javax.swing.JComboBox<>();
        jBvoltar = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel2.setText("Adicionar Assunto");

        jLabel3.setText("Assunto:");

        jBadd.setText("Adicionar");
        jBadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBaddActionPerformed(evt);
            }
        });

        jLabel4.setText("Disciplina:");

        jCBdisc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jBvoltar.setText("Voltar");
        jBvoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBvoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel2)
                .addContainerGap(136, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBvoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBadd))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addComponent(jTFassunto, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                        .addComponent(jCBdisc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTFassunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCBdisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBadd)
                    .addComponent(jBvoltar))
                .addGap(37, 37, 37))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBaddActionPerformed
        String valor = (String) jCBdisc.getSelectedItem();
        int idDisc = dDAO.descobreId(valor);

        String assunto = jTFassunto.getText();
        if ("".equals(jTFassunto.getText())) {
            JOptionPane.showMessageDialog(null, "Campo Assunto não foi preenchido!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            Assunto a = new Assunto(assunto, idDisc);

            AssuntosDAO aDAO = new AssuntosDAO();
            aDAO.inserir(a);

            Inicio ini = new Inicio(pai);
            ini.setBounds(0, 0, pai.getWidth(), pai.getHeight());
            ini.setVisible(true);
            pai.setTitle("Início");
            pai.setContentPane(ini);
        }
    }//GEN-LAST:event_jBaddActionPerformed

    private void jBvoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBvoltarActionPerformed
        Inicio ini = new Inicio(pai);
        ini.setBounds(0, 0, pai.getWidth(), pai.getHeight());
        ini.setVisible(true);
        pai.setTitle("Início");
        pai.setContentPane(ini);
    }//GEN-LAST:event_jBvoltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBadd;
    private javax.swing.JButton jBvoltar;
    private javax.swing.JComboBox<String> jCBdisc;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTFassunto;
    // End of variables declaration//GEN-END:variables
}
