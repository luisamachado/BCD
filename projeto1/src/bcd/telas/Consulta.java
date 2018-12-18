package bcd.telas;

import bcd.ConnectionFactory;
import bcd.DAO.AssuntosDAO;
import bcd.DAO.DisciplinasDAO;
import bcd.tabelas.Assunto;
import bcd.tabelas.Disciplina;
import bcd.tabelas.Pergunta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author luisa
 */
public class Consulta extends javax.swing.JPanel {

    private FramePrincipal pai;
    private AssuntosDAO aDAO = new AssuntosDAO();
    private int cont = 0;
    private List<Pergunta> p = new ArrayList<>();

    public Consulta(FramePrincipal pai) {
        initComponents();

        this.pai = pai;
        this.aDAO = new AssuntosDAO();

        jCBdisc.removeAllItems();
        jCBassunto.removeAllItems();
        jCBperg.removeAllItems();
        jCBassunto.setVisible(false);
        jBassunto.setVisible(false);
        jLassunto.setVisible(false);
        jCBperg.setVisible(false);
        jBnext.setVisible(false);
        jLperg.setVisible(false);
        DisciplinasDAO dDAO = new DisciplinasDAO();
        try (Connection conexao = ConnectionFactory.getConnetion()) {
            List<Disciplina> disciplinas = dDAO.listar(conexao);
            for (Disciplina a : disciplinas) {
                jCBdisc.addItem(a.getNome_disc());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLdisc = new javax.swing.JLabel();
        jCBdisc = new javax.swing.JComboBox<>();
        jBvoltar = new javax.swing.JButton();
        jBdisc = new javax.swing.JButton();
        jLassunto = new javax.swing.JLabel();
        jCBassunto = new javax.swing.JComboBox<>();
        jBassunto = new javax.swing.JButton();
        jLperg = new javax.swing.JLabel();
        jCBperg = new javax.swing.JComboBox<>();
        jBnext = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setText("Consultar");

        jLdisc.setText("Escolha a disciplina:");

        jCBdisc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jBvoltar.setText("Voltar");
        jBvoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBvoltarActionPerformed(evt);
            }
        });

        jBdisc.setText("Selecionar");
        jBdisc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBdiscActionPerformed(evt);
            }
        });

        jLassunto.setText("Escolha o assunto:");

        jCBassunto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jBassunto.setText("Selecionar");
        jBassunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBassuntoActionPerformed(evt);
            }
        });

        jLperg.setText("Escolha a pergunta:");

        jCBperg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jBnext.setText("Próximo");
        jBnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBnextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLdisc)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLassunto)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCBdisc, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCBassunto, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jBdisc)
                                    .addComponent(jBassunto))))
                        .addGap(50, 50, 50))))
            .addGroup(layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLperg)
                        .addContainerGap(286, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jBvoltar)
                                .addGap(18, 18, 18)
                                .addComponent(jBnext))
                            .addComponent(jCBperg, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(50, 50, 50))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLdisc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBdisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBdisc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLassunto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBassunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBassunto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLperg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBperg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBvoltar)
                    .addComponent(jBnext))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBvoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBvoltarActionPerformed
        Inicio ini = new Inicio(pai);
        ini.setBounds(0, 0, pai.getWidth(), pai.getHeight());
        ini.setVisible(true);
        pai.setTitle("Início");
        pai.setContentPane(ini);
    }//GEN-LAST:event_jBvoltarActionPerformed

    private void jBdiscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBdiscActionPerformed
        String valor = (String) jCBdisc.getSelectedItem();
        DisciplinasDAO dDAO = new DisciplinasDAO();
        int disciplina = 0;
        try (Connection conexao = ConnectionFactory.getConnetion()) {
            disciplina = dDAO.descobreId(valor);
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (Connection conexao = ConnectionFactory.getConnetion()) {
            List<Assunto> assuntos = aDAO.listarPorDisc(disciplina);
            for (Assunto a : assuntos) {
                jCBassunto.addItem(a.getNome());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        jCBassunto.setVisible(true);
        jBassunto.setVisible(true);
    }//GEN-LAST:event_jBdiscActionPerformed

    private void jBassuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBassuntoActionPerformed
        String valor = (String) jCBassunto.getSelectedItem();
        int id = aDAO.descobreId(valor);
        try (Connection conexao = ConnectionFactory.getConnetion()) {
            String sql = "SELECT * FROM Perguntas WHERE idAssunto=" + id;
            try (PreparedStatement stmt = conexao.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Pergunta c = new Pergunta(
                            rs.getString("pergunta"),
                            rs.getInt("idPergunta"),
                            rs.getBoolean("flag_alternativa"));
                    p.add(c);
                }
            }
            for (Pergunta perg : p) {
                jCBperg.addItem(perg.getPergunta());
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        jCBperg.setVisible(true);
        jBnext.setVisible(true);
    }//GEN-LAST:event_jBassuntoActionPerformed

    private void jBnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBnextActionPerformed
        String valor = (String) jCBperg.getSelectedItem();
        int id = descobreId(valor);
        ApresentaConsulta cons = new ApresentaConsulta(pai, id);
        cons.setBounds(0, 0, pai.getWidth(), pai.getHeight());
        cons.setVisible(true);
        pai.setTitle("Início");
        pai.setContentPane(cons);
    }//GEN-LAST:event_jBnextActionPerformed

    public int descobreId(String pergunta) {
        int id = 0;
        try (Connection conexao = ConnectionFactory.getConnetion()) {
            String sql = "SELECT * FROM Perguntas WHERE pergunta like '" + pergunta + "'";
            try (PreparedStatement stmt = conexao.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    id = rs.getInt("idPergunta");
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return id;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBassunto;
    private javax.swing.JButton jBdisc;
    private javax.swing.JButton jBnext;
    private javax.swing.JButton jBvoltar;
    private javax.swing.JComboBox<String> jCBassunto;
    private javax.swing.JComboBox<String> jCBdisc;
    private javax.swing.JComboBox<String> jCBperg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLassunto;
    private javax.swing.JLabel jLdisc;
    private javax.swing.JLabel jLperg;
    // End of variables declaration//GEN-END:variables
}
