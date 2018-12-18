package bcd.telas;

import bcd.ConnectionFactory;
import bcd.DAO.AssuntosDAO;
import bcd.DAO.DisciplinasDAO;
import bcd.tabelas.Assunto;
import bcd.tabelas.Disciplina;
import bcd.tabelas.Pergunta;
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
public class AddPergunta extends javax.swing.JPanel {

    private FramePrincipal pai;
    private AssuntosDAO aDAO = new AssuntosDAO();

    public AddPergunta(FramePrincipal pai) {
        initComponents();

        this.pai = pai;
        this.aDAO = new AssuntosDAO();

        jRBdiscursiva.setSelected(true);

        jLassunto.setText("Escolha a disciplina:");
        jCBassunto.removeAllItems();

        DisciplinasDAO dDAO = new DisciplinasDAO();
        try (Connection conexao = ConnectionFactory.getConnetion()) {
            List<Disciplina> disciplinas = dDAO.listar(conexao);
            for (Disciplina a : disciplinas) {
                jCBassunto.addItem(a.getNome_disc());
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddPergunta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jRBdiscursiva = new javax.swing.JRadioButton();
        jRBalternativas = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTApergunta = new javax.swing.JTextArea();
        jBproximo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLassunto = new javax.swing.JLabel();
        jCBassunto = new javax.swing.JComboBox<>();
        jBvoltar = new javax.swing.JButton();
        jBseleciona = new javax.swing.JButton();

        jLabel2.setText("Digite a pergunta:");

        jLabel3.setText("Qual o tipo da questão?");

        buttonGroup1.add(jRBdiscursiva);
        jRBdiscursiva.setText("Discursiva");

        buttonGroup1.add(jRBalternativas);
        jRBalternativas.setText("Múltipla escolha");

        jTApergunta.setColumns(20);
        jTApergunta.setRows(5);
        jScrollPane1.setViewportView(jTApergunta);

        jBproximo.setText("Próximo");
        jBproximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBproximoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setText("Adicionar Pergunta");

        jLassunto.setText("Assunto da pergunta:");

        jCBassunto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jBvoltar.setText("Voltar");
        jBvoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBvoltarActionPerformed(evt);
            }
        });

        jBseleciona.setText("Selecionar");
        jBseleciona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBselecionaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLassunto)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(jCBassunto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jBseleciona)
                                        .addGap(79, 79, 79)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRBdiscursiva)
                                    .addComponent(jLabel3)
                                    .addComponent(jRBalternativas)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBvoltar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBproximo))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel1)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLassunto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBdiscursiva)
                    .addComponent(jCBassunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBalternativas)
                    .addComponent(jBseleciona))
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBproximo)
                    .addComponent(jBvoltar))
                .addContainerGap(13, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBproximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBproximoActionPerformed
        String valor = (String) jCBassunto.getSelectedItem();
        int idAssunto = aDAO.descobreId(valor);

        String perg = jTApergunta.getText();
        if ("".equals(perg)) {
            JOptionPane.showMessageDialog(null, "Campo Resposta não foi preenchido!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            boolean flag = jRBalternativas.isSelected();

            Pergunta pergTabela = new Pergunta(perg, idAssunto, flag);

            if (flag == true) {
                PergAlternativa alterPainel = new PergAlternativa(pai, pergTabela);
                alterPainel.setBounds(0, 0, pai.getWidth(), pai.getHeight());
                alterPainel.setVisible(true);
                pai.setTitle("Resposta e Alternativas");
                pai.setContentPane(alterPainel);
            } else {
                PergDiscursiva discursivaPainel = new PergDiscursiva(pai, pergTabela);
                discursivaPainel.setBounds(0, 0, pai.getWidth(), pai.getHeight());
                discursivaPainel.setVisible(true);
                pai.setTitle("Resposta e Alternativas");
                pai.setContentPane(discursivaPainel);
            }
        }
    }//GEN-LAST:event_jBproximoActionPerformed

    private void jBvoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBvoltarActionPerformed
        Inicio ini = new Inicio(pai);
        ini.setBounds(0, 0, pai.getWidth(), pai.getHeight());
        ini.setVisible(true);
        pai.setTitle("Início");
        pai.setContentPane(ini);
    }//GEN-LAST:event_jBvoltarActionPerformed

    private void jBselecionaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBselecionaActionPerformed
        String valor = (String) jCBassunto.getSelectedItem();
        DisciplinasDAO dDAO = new DisciplinasDAO();
        int disciplina = 0;
        try (Connection conexao = ConnectionFactory.getConnetion()) {
            disciplina = dDAO.descobreId(valor);
        } catch (SQLException ex) {
            Logger.getLogger(AddPergunta.class.getName()).log(Level.SEVERE, null, ex);
        }
        jBseleciona.setVisible(false);
        jLassunto.setText("Escolha o assunto:");
        jCBassunto.removeAllItems();
        try (Connection conexao = ConnectionFactory.getConnetion()) {
            List<Assunto> assuntos = aDAO.listarPorDisc(disciplina);
            for (Assunto a : assuntos) {
                jCBassunto.addItem(a.getNome());
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddPergunta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBselecionaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBproximo;
    private javax.swing.JButton jBseleciona;
    private javax.swing.JButton jBvoltar;
    private javax.swing.JComboBox<String> jCBassunto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLassunto;
    private javax.swing.JRadioButton jRBalternativas;
    private javax.swing.JRadioButton jRBdiscursiva;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTApergunta;
    // End of variables declaration//GEN-END:variables
}
