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
public class Gera_prova extends javax.swing.JPanel {

    private FramePrincipal pai;
    private DisciplinasDAO dDAO;
    private int idDisc;

    public Gera_prova(FramePrincipal pai) {
        initComponents();

        this.pai = pai;
        this.dDAO = new DisciplinasDAO();

        jCBdisc.removeAllItems();

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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jBproximo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTFtotal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCBdisc = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jTFqtdAssuntos = new javax.swing.JTextField();
        jTFanos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jCBnunca = new javax.swing.JCheckBox();
        jCBultima = new javax.swing.JCheckBox();

        setPreferredSize(new java.awt.Dimension(643, 422));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setText("Gerador de Avaliações");

        jBproximo.setText("Próximo");
        jBproximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBproximoActionPerformed(evt);
            }
        });

        jLabel2.setText("Total de questões:");

        jTFtotal.setText("Ex: 10");
        jTFtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFtotalActionPerformed(evt);
            }
        });

        jLabel4.setText("Critérios de seleção:");

        jLabel5.setText("Disciplina:");

        jCBdisc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Quantos assuntos deve ter a prova?");

        jTFqtdAssuntos.setText("Ex: 2");
        jTFqtdAssuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFqtdAssuntosActionPerformed(evt);
            }
        });

        jTFanos.setText("Ex: 2");
        jTFanos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFanosActionPerformed(evt);
            }
        });

        jLabel3.setText("anos atrás");

        jCBnunca.setSelected(true);
        jCBnunca.setText("Questões nunca usadas");

        jCBultima.setText("Última vez usada:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(146, 146, 146)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTFtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(47, 47, 47))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jCBnunca)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jCBultima)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jCBdisc, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTFqtdAssuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jTFanos, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBproximo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCBdisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTFqtdAssuntos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jBproximo))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTFtotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBnunca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBultima)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFanos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void assuntos(int cont, int numQuest, int vezes, boolean nunca) {
        AssuntosDAO aDAO = new AssuntosDAO();
        String disc = (String) jCBdisc.getSelectedItem();
        idDisc = dDAO.descobreId(disc);
        try (Connection conexao = ConnectionFactory.getConnetion()) {
            List<Assunto> a = aDAO.listarPorDisc(idDisc);

            if (a.size() < cont) {
                String msg = "Esta disciplina tem " + a.size() + " assuntos!";
                JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                SelecionaAssunto sel = new SelecionaAssunto(pai, a, cont, numQuest, vezes, nunca, idDisc, disc);
                sel.setBounds(0, 0, pai.getWidth(), pai.getHeight());
                sel.setVisible(true);
                pai.setTitle("Prova");
                pai.setContentPane(sel);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddPergunta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jBproximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBproximoActionPerformed
        int vezes = 0;
        boolean nunca = false;

        if (jCBultima.isSelected()) {
            vezes = Integer.parseInt(jTFanos.getText());
        }
        if (jCBnunca.isSelected()) {
            nunca = true;
        }

        int numQuest = Integer.parseInt(jTFtotal.getText());
        int cont = Integer.parseInt(jTFqtdAssuntos.getText());

        assuntos(cont, numQuest, vezes, nunca);
    }//GEN-LAST:event_jBproximoActionPerformed

    private void jTFtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFtotalActionPerformed

    private void jTFqtdAssuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFqtdAssuntosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFqtdAssuntosActionPerformed

    private void jTFanosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFanosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFanosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBproximo;
    private javax.swing.JComboBox<String> jCBdisc;
    private javax.swing.JCheckBox jCBnunca;
    private javax.swing.JCheckBox jCBultima;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTFanos;
    private javax.swing.JTextField jTFqtdAssuntos;
    private javax.swing.JTextField jTFtotal;
    // End of variables declaration//GEN-END:variables
}
