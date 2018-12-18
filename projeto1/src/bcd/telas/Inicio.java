package bcd.telas;

import bcd.ConnectionFactory;
import java.sql.Connection;

/**
 *
 * @author luisa
 */
public class Inicio extends javax.swing.JPanel {

    private FramePrincipal pai;

    public Inicio(FramePrincipal pai) {
        initComponents();

        this.pai = pai;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jBAss = new javax.swing.JButton();
        jBPerg = new javax.swing.JButton();
        jBDisc = new javax.swing.JButton();
        jBProva = new javax.swing.JButton();
        jBconsulta = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setText("Sistema de Questões");

        jBAss.setText("Adicionar Assunto");
        jBAss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAssActionPerformed(evt);
            }
        });

        jBPerg.setText("Adicionar Pergunta");
        jBPerg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPergActionPerformed(evt);
            }
        });

        jBDisc.setText("Adicionar Disciplina");
        jBDisc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDiscActionPerformed(evt);
            }
        });

        jBProva.setText("Montar Prova");
        jBProva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBProvaActionPerformed(evt);
            }
        });

        jBconsulta.setText("Consulta Pergunta");
        jBconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBconsultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBPerg, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBDisc, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBconsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBAss, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBProva, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBDisc, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBAss, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBPerg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(76, 76, 76))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBProva, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBconsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBAssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAssActionPerformed
        AddAssunto pergPainel = new AddAssunto(pai);

        pergPainel.setBounds(0, 0, pai.getWidth(), pai.getHeight());
        pergPainel.setVisible(true);

        pai.setTitle("Pergunta");

        pai.setContentPane(pergPainel);
    }//GEN-LAST:event_jBAssActionPerformed

    private void jBPergActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPergActionPerformed
        AddPergunta pergPainel = new AddPergunta(pai);
        pergPainel.setBounds(0, 0, pai.getWidth(), pai.getHeight());
        pergPainel.setVisible(true);

        pai.setTitle("Pergunta");

        pai.setContentPane(pergPainel);
    }//GEN-LAST:event_jBPergActionPerformed

    private void jBDiscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDiscActionPerformed
        Connection conexao = ConnectionFactory.getConnetion();

        AddDisc discPainel = new AddDisc(pai, conexao);

        discPainel.setBounds(0, 0, pai.getWidth(), pai.getHeight());
        discPainel.setVisible(true);

        pai.setTitle("Disciplina");

        pai.setContentPane(discPainel);
    }//GEN-LAST:event_jBDiscActionPerformed

    private void jBProvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBProvaActionPerformed
        Gera_prova prova = new Gera_prova(pai);
        prova.setBounds(0, 0, pai.getWidth(), pai.getHeight());
        prova.setVisible(true);

        pai.setTitle("Prova");

        pai.setContentPane(prova);
    }//GEN-LAST:event_jBProvaActionPerformed

    private void jBconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBconsultaActionPerformed
        Consulta consulta = new Consulta(pai);
        consulta.setBounds(0, 0, pai.getWidth(), pai.getHeight());
        consulta.setVisible(true);

        pai.setTitle("Consulta");

        pai.setContentPane(consulta);
    }//GEN-LAST:event_jBconsultaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBAss;
    private javax.swing.JButton jBDisc;
    private javax.swing.JButton jBPerg;
    private javax.swing.JButton jBProva;
    private javax.swing.JButton jBconsulta;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
