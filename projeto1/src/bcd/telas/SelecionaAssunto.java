package bcd.telas;

import bcd.DAO.AssuntosDAO;
import bcd.DAO.ProvasDAO;
import bcd.tabelas.Assunto;
import bcd.tabelas.Pergunta;
import bcd.tabelas.Prova;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
public class SelecionaAssunto extends javax.swing.JPanel {

    private FramePrincipal pai;
    private List<Assunto> assuntos;
    private List<String> escolhidos = new ArrayList<>();
    private int cont;
    private int numQuest;
    private int vez;
    private int iddisciplina;
    private String disciplina;
    private boolean nunca;

    public SelecionaAssunto(FramePrincipal pai, List<Assunto> assuntos,
            int cont, int numQuest, int vez, boolean nunca, int iddisciplina, String disciplina) {

        initComponents();

        this.pai = pai;
        this.assuntos = assuntos;
        this.cont = cont;
        this.numQuest = numQuest;
        this.vez = vez;
        this.nunca = nunca;
        this.iddisciplina = iddisciplina;
        this.disciplina = disciplina;

        inicializa();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLassuntos = new javax.swing.JLabel();
        jBadd = new javax.swing.JButton();
        jCBassunto = new javax.swing.JComboBox<>();
        jBvoltar = new javax.swing.JButton();
        jLsemestre = new javax.swing.JLabel();
        jLano = new javax.swing.JLabel();
        jCBsemestre = new javax.swing.JComboBox<>();
        jCBanos = new javax.swing.JComboBox<>();

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel2.setText("Gerador de Avaliações");

        jLassuntos.setText("Selecione os assuntos:");

        jBadd.setText("Adicionar");
        jBadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBaddActionPerformed(evt);
            }
        });

        jCBassunto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jBvoltar.setText("Voltar");
        jBvoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBvoltarActionPerformed(evt);
            }
        });

        jLsemestre.setText("Semestre");

        jLano.setText("Ano");

        jCBsemestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jCBanos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jBvoltar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBadd))
                        .addComponent(jLassuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCBassunto, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLsemestre)
                            .addComponent(jCBsemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLano)
                            .addComponent(jCBanos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addGap(36, 36, 36)
                .addComponent(jLassuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCBassunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLsemestre)
                    .addComponent(jLano))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBsemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBanos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBadd)
                    .addComponent(jBvoltar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBaddActionPerformed
        atualiza();
        cont = cont - 1;
        if (cont == 1) {
            ativa();
        } else if (cont == 0) {
            int sem = Integer.parseInt((String) jCBsemestre.getSelectedItem());
            int anoAtual = Integer.parseInt((String) jCBanos.getSelectedItem());

            AssuntosDAO aDAO = new AssuntosDAO();
            String ids = "";
            for (int i = 0; i < escolhidos.size(); i++) {
                if (i == 0) {
                    ids = Integer.toString(aDAO.descobreId(escolhidos.remove(i)));
                } else {
                    ids = ids + ", " + aDAO.descobreId(escolhidos.remove(i));
                }
            }
            // acessa banco para criar prova
            Prova p = new Prova(sem, iddisciplina);
            p.setAno(anoAtual);
            ProvasDAO prova = new ProvasDAO();
            try {
                prova.inserir(p);
                int idProva = prova.descobreId(p); 
                List<Pergunta> lista = prova.selecionaPerg(idProva, numQuest, anoAtual, vez, nunca, ids);
                String nomeProva = "prova" + idProva + ".txt";
                FileWriter arq = new FileWriter(nomeProva);
                PrintWriter gravarArq = new PrintWriter(arq);
                gravarArq.printf("Prova " + idProva + " de " + disciplina + "\n\n");
                int i = 1;
                for (Pergunta a : lista) {
                    gravarArq.println(i + ") " + a.getPergunta() + "\n");
                    gravarArq.println(a.getAlternativas());
                    gravarArq.println("\n");
                    i++;
                }
                arq.close();
            } catch (SQLException ex) {
                Logger.getLogger(SelecionaAssunto.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SelecionaAssunto.class.getName()).log(Level.SEVERE, null, ex);
            }

            // aviso que a prova foi gerada em um arq
            JOptionPane.showMessageDialog(null, "Prova pronta!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            // voltar ao inicio do programa
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

    private void atualiza() {
        String valor = (String) jCBassunto.getSelectedItem();
        escolhidos.add(valor);
        for (int i = 0; i < assuntos.size(); i++) {
            if (assuntos.get(i).getNome().equals(valor)) {
                assuntos.remove(i);
            }
        }
        jCBassunto.removeAllItems();
        for (Assunto a : assuntos) {
            jCBassunto.addItem(a.getNome());
        }
    }

    private void inicializa() {
        jCBassunto.removeAllItems();
        jCBanos.removeAllItems();
        jCBsemestre.removeAllItems();
        jCBsemestre.setVisible(false);
        jCBanos.setVisible(false);
        jLsemestre.setVisible(false);
        jLano.setVisible(false);
        for (Assunto a : assuntos) {
            jCBassunto.addItem(a.getNome());
        }
        for (int i = 2019; i >= 2000; i--) {
            jCBanos.addItem(Integer.toString(i));
        }
        if (cont == 1) {
            ativa();
        }
    }

    private void ativa() {
        jCBsemestre.setVisible(true);
        jCBanos.setVisible(true);
        jLsemestre.setVisible(true);
        jLano.setVisible(true);
        jCBsemestre.addItem("1");
        jCBsemestre.addItem("2");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBadd;
    private javax.swing.JButton jBvoltar;
    private javax.swing.JComboBox<String> jCBanos;
    private javax.swing.JComboBox<String> jCBassunto;
    private javax.swing.JComboBox<String> jCBsemestre;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLano;
    private javax.swing.JLabel jLassuntos;
    private javax.swing.JLabel jLsemestre;
    // End of variables declaration//GEN-END:variables
}
