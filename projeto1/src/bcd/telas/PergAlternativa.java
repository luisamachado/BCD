package bcd.telas;

import bcd.ConnectionFactory;
import bcd.tabelas.Pergunta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisa
 */
public class PergAlternativa extends javax.swing.JPanel {

    private FramePrincipal pai;
    private Pergunta pergTabela;

    public PergAlternativa(FramePrincipal pai, Pergunta pergTabela) {
        initComponents();

        this.pai = pai;
        this.pergTabela = pergTabela;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTFresp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTFletraA = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTFletraB = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTFletraC = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTFletraD = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTFletraE = new javax.swing.JTextField();
        jBfinal = new javax.swing.JButton();

        jLabel2.setText("Digite alternativa correta:");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setText("Resposta");

        jTFresp.setText("Apenas a letra");

        jLabel3.setText("Digite todas as alternativas:");

        jLabel4.setText("a)");

        jLabel5.setText("b)");

        jLabel6.setText("c)");

        jLabel7.setText("d)");

        jLabel8.setText("e)");

        jBfinal.setText("Finalizar");
        jBfinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBfinalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addComponent(jBfinal))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFletraA, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFletraC, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTFletraB, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTFletraD, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTFletraE, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jTFresp, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFresp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTFletraA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTFletraB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTFletraC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTFletraD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTFletraE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBfinal)
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBfinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBfinalActionPerformed
        String resposta = jTFresp.getText();
        pergTabela.setResposta(resposta);

        String letraA = jTFletraA.getText();
        String letraB = jTFletraB.getText();
        String letraC = jTFletraC.getText();
        String letraD = jTFletraD.getText();
        String letraE = jTFletraE.getText();

        String alternativas = "a) " + letraA + "      b) " + letraB + "      c) " + letraC
                + "      d) " + letraD + "      e) " + letraE;

        pergTabela.setAlternativas(alternativas);

        try (Connection conexao = ConnectionFactory.getConnetion()) {
            if (pergTabela.getFlag() == true) {
                String sql = "INSERT INTO Perguntas (pergunta, resposta, "
                        + "idAssunto, flag_alternativa, alternativa) VALUES"
                        + "(?,?,?,?,?)";

                try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                    stmt.setString(1, pergTabela.getPergunta());
                    stmt.setString(2, pergTabela.getResposta());
                    stmt.setInt(3, pergTabela.getIdAssunto());
                    stmt.setBoolean(4, pergTabela.getFlag());
                    stmt.setString(5, pergTabela.getAlternativas());

                    stmt.execute();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PergAlternativa.class.getName()).log(Level.SEVERE, null, ex);
        }
        Inicio ini = new Inicio(pai);
        ini.setBounds(0, 0, pai.getWidth(), pai.getHeight());
        ini.setVisible(true);
        pai.setTitle("Início");
        pai.setContentPane(ini);
    }//GEN-LAST:event_jBfinalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBfinal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTFletraA;
    private javax.swing.JTextField jTFletraB;
    private javax.swing.JTextField jTFletraC;
    private javax.swing.JTextField jTFletraD;
    private javax.swing.JTextField jTFletraE;
    private javax.swing.JTextField jTFresp;
    // End of variables declaration//GEN-END:variables
}
