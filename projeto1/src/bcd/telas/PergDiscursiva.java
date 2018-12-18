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
public class PergDiscursiva extends javax.swing.JPanel {

    private FramePrincipal pai;
    private Pergunta pergTabela;

    public PergDiscursiva(FramePrincipal pai, Pergunta pergTabela) {
        initComponents();

        this.pai = pai;
        this.pergTabela = pergTabela;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jBfinal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAresposta = new javax.swing.JTextArea();

        jLabel2.setText("Digite a reposta:");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setText("Resposta");

        jBfinal.setText("Finalizar");
        jBfinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBfinalActionPerformed(evt);
            }
        });

        jTAresposta.setColumns(20);
        jTAresposta.setRows(5);
        jScrollPane1.setViewportView(jTAresposta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jBfinal))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel1)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBfinal)
                .addContainerGap(63, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBfinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBfinalActionPerformed
        String resposta = jTAresposta.getText();

        try (Connection conexao = ConnectionFactory.getConnetion()) {
            if (pergTabela.getFlag() == false) {
                String sql = "INSERT INTO Perguntas (pergunta, resposta, "
                        + "idAssunto, flag_alternativa) VALUES"
                        + "(?,?,?,?)";

                try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                    stmt.setString(1, pergTabela.getPergunta());
                    stmt.setString(2, resposta);
                    stmt.setInt(3, pergTabela.getIdAssunto());
                    stmt.setBoolean(4, pergTabela.getFlag());

                    stmt.execute();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PergDiscursiva.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTAresposta;
    // End of variables declaration//GEN-END:variables
}
