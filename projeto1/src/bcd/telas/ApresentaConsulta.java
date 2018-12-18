package bcd.telas;

import bcd.ConnectionFactory;
import bcd.tabelas.Prova;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luisa
 */
public class ApresentaConsulta extends javax.swing.JPanel {

    private FramePrincipal pai;
    private int idpergunta;

    public ApresentaConsulta(FramePrincipal pai, int idpergunta) {
        initComponents();

        this.pai = pai;
        this.idpergunta = idpergunta;
        semestre();
    }

    private void semestre() {
        List<Prova> provas = new ArrayList<>();
        try (Connection conexao = ConnectionFactory.getConnetion()) {
            String sql = "SELECT * FROM Provas NATURAL JOIN"
                    + " Historico WHERE idPergunta=" + idpergunta;
            try (PreparedStatement stmt = conexao.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Prova c = new Prova(
                            rs.getInt("semestre"),
                            rs.getInt("idDisc"));
                    c.setAno(rs.getInt("data"));
                    provas.add(c);
                }
                String semestres = "";
                int qtd = 0;
                for (Prova p : provas) {
                    semestres = semestres + p.getAno() + "/" + p.getSemestre() + "\n ";
                    qtd++;
                }
                if (semestres == "") {
                    jTAsemestres.setText("Essa pergunta ainda não foi utilizada!");
                    jLqtd.setVisible(false);
                    jTFqtd.setVisible(false);
                } else {
                    jTAsemestres.setText(semestres);
                    jTFqtd.setText(qtd + " vezes");
                    if (qtd == 1) {
                        jTFqtd.setText(qtd + " vez");
                    }
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLsemestre = new javax.swing.JLabel();
        jBvoltar = new javax.swing.JButton();
        jLqtd = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTAsemestres = new javax.swing.JTextArea();
        jTFqtd = new javax.swing.JTextField();

        jLsemestre.setText("Essa questão apareceu em:");

        jBvoltar.setText("Voltar");
        jBvoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBvoltarActionPerformed(evt);
            }
        });

        jLqtd.setText("Essa questão ja foi usada:");

        jTAsemestres.setColumns(20);
        jTAsemestres.setRows(5);
        jScrollPane2.setViewportView(jTAsemestres);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLqtd)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBvoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFqtd, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLsemestre))
                        .addGap(0, 31, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLsemestre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLqtd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTFqtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBvoltar)
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBvoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBvoltarActionPerformed
        Inicio ini = new Inicio(pai);
        ini.setBounds(0, 0, pai.getWidth(), pai.getHeight());
        ini.setVisible(true);
        pai.setTitle("Início");
        pai.setContentPane(ini);
    }//GEN-LAST:event_jBvoltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBvoltar;
    private javax.swing.JLabel jLqtd;
    private javax.swing.JLabel jLsemestre;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTAsemestres;
    private javax.swing.JTextField jTFqtd;
    // End of variables declaration//GEN-END:variables
}
