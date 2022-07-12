package View;

// @author LucasMarcuzo

import controller.ControllerUsuario;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import model.ModelUsuario;

public class Login extends javax.swing.JFrame implements IPadraoTelas{
    
    private static Usuario novoLogin;
    private String nomeUsuario = "";
    
    ModelUsuario modelUsuario = new ModelUsuario();
    ControllerUsuario controllerUsuario = new ControllerUsuario();
    
    /**
     * Main
     * @param args
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true); 
            }
        });
    }
    
    /**
     * Construtor Login.
     */
    public Login() {
        initComponents();
        
        //Deixando bordas do form arredondadas.
        padraoBordasArredondadas(this);
        
        //Inserindo icone Padrão no form.
        padraoIconeForm(this);
        
        //Atualizando Data.
        atualizarDataAtual(jlDataAtualLogin);
        
        //Atualizando Hora.
        atualizarHorasAtuais(jlHoraAtualLogin);
        
    }
    
    
    //Código Gerado automaticamente.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbSairLogin = new javax.swing.JButton();
        jbEntrarLogin = new javax.swing.JButton();
        jtfUsuarioLogin = new javax.swing.JTextField();
        jpSenhaLogin = new javax.swing.JPasswordField();
        jbFecharLogin = new javax.swing.JButton();
        jbMinimizarLogin = new javax.swing.JButton();
        jlNovoCadastro = new javax.swing.JLabel();
        jlHoraAtualLogin = new javax.swing.JLabel();
        jlDataAtualLogin = new javax.swing.JLabel();
        jLabelSenha = new javax.swing.JLabel();
        jLabelLogin = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 500));
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(600, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbSairLogin.setBackground(new java.awt.Color(255, 51, 51));
        jbSairLogin.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbSairLogin.setForeground(new java.awt.Color(255, 255, 255));
        jbSairLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/sair-48.png"))); // NOI18N
        jbSairLogin.setText(" Sair");
        jbSairLogin.setToolTipText("Clique para Sair");
        jbSairLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbSairLogin.setFocusPainted(false);
        jbSairLogin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbSairLogin.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbSairLogin.setIconTextGap(10);
        jbSairLogin.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jbSairLogin.setMaximumSize(new java.awt.Dimension(140, 52));
        jbSairLogin.setMinimumSize(new java.awt.Dimension(140, 52));
        jbSairLogin.setName(""); // NOI18N
        jbSairLogin.setNextFocusableComponent(jtfUsuarioLogin);
        jbSairLogin.setPreferredSize(new java.awt.Dimension(140, 52));
        jbSairLogin.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Sair-48-rollover-Login.png"))); // NOI18N
        jbSairLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairLoginActionPerformed(evt);
            }
        });
        jPanel1.add(jbSairLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 385, 150, -1));

        jbEntrarLogin.setBackground(new java.awt.Color(42, 152, 223));
        jbEntrarLogin.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbEntrarLogin.setForeground(new java.awt.Color(255, 255, 255));
        jbEntrarLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/entrar-48.png"))); // NOI18N
        jbEntrarLogin.setText("Entrar");
        jbEntrarLogin.setToolTipText("Clique para Entrar");
        jbEntrarLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbEntrarLogin.setFocusPainted(false);
        jbEntrarLogin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbEntrarLogin.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbEntrarLogin.setIconTextGap(10);
        jbEntrarLogin.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jbEntrarLogin.setMaximumSize(new java.awt.Dimension(140, 52));
        jbEntrarLogin.setMinimumSize(new java.awt.Dimension(140, 52));
        jbEntrarLogin.setNextFocusableComponent(jbSairLogin);
        jbEntrarLogin.setPreferredSize(new java.awt.Dimension(140, 52));
        jbEntrarLogin.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Entrar-48-rollover.png"))); // NOI18N
        jbEntrarLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEntrarLoginActionPerformed(evt);
            }
        });
        jPanel1.add(jbEntrarLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 385, 150, -1));

        jtfUsuarioLogin.setToolTipText("Digite o Usuário");
        jtfUsuarioLogin.setNextFocusableComponent(jpSenhaLogin);
        jtfUsuarioLogin.setSelectionColor(new java.awt.Color(208, 146, 33));
        jtfUsuarioLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfUsuarioLoginKeyPressed(evt);
            }
        });
        jPanel1.add(jtfUsuarioLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 265, 290, 30));

        jpSenhaLogin.setToolTipText("Digite a Senha do Usuário");
        jpSenhaLogin.setNextFocusableComponent(jbEntrarLogin);
        jpSenhaLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpSenhaLoginKeyPressed(evt);
            }
        });
        jPanel1.add(jpSenhaLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 315, 290, 30));

        jbFecharLogin.setBackground(new Color(0,0,0,0));
        jbFecharLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/fechar-36.png"))); // NOI18N
        jbFecharLogin.setToolTipText("Fechar");
        jbFecharLogin.setBorder(null);
        jbFecharLogin.setBorderPainted(false);
        jbFecharLogin.setContentAreaFilled(false);
        jbFecharLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbFecharLogin.setMargin(new java.awt.Insets(0, 14, 0, 14));
        jbFecharLogin.setMaximumSize(new java.awt.Dimension(40, 40));
        jbFecharLogin.setMinimumSize(new java.awt.Dimension(40, 40));
        jbFecharLogin.setPreferredSize(new java.awt.Dimension(40, 40));
        jbFecharLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFecharLoginActionPerformed(evt);
            }
        });
        jPanel1.add(jbFecharLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 28, 28));

        jbMinimizarLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/minimizar-36.png"))); // NOI18N
        jbMinimizarLogin.setToolTipText("Minimizar");
        jbMinimizarLogin.setBorder(null);
        jbMinimizarLogin.setBorderPainted(false);
        jbMinimizarLogin.setContentAreaFilled(false);
        jbMinimizarLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbMinimizarLogin.setMargin(new java.awt.Insets(0, 14, 0, 14));
        jbMinimizarLogin.setMaximumSize(new java.awt.Dimension(40, 40));
        jbMinimizarLogin.setMinimumSize(new java.awt.Dimension(40, 40));
        jbMinimizarLogin.setPreferredSize(new java.awt.Dimension(40, 40));
        jbMinimizarLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMinimizarLoginActionPerformed(evt);
            }
        });
        jPanel1.add(jbMinimizarLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 28, 28));

        jlNovoCadastro.setBackground(new java.awt.Color(255, 255, 255));
        jlNovoCadastro.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jlNovoCadastro.setForeground(new java.awt.Color(255, 255, 255));
        jlNovoCadastro.setText("<html><font color=\"#2a98df\"><a>Não tenho cadastro.</a></font></html>");
        jlNovoCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlNovoCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlNovoCadastroMouseClicked(evt);
            }
        });
        jPanel1.add(jlNovoCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 357, -1, -1));
        jlNovoCadastro.getAccessibleContext().setAccessibleDescription("Criar novo cadastro");

        jlHoraAtualLogin.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jlHoraAtualLogin.setForeground(new java.awt.Color(31, 43, 91));
        jlHoraAtualLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlHoraAtualLogin.setText("Hora Atual");
        jPanel1.add(jlHoraAtualLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 480, 80, 20));

        jlDataAtualLogin.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jlDataAtualLogin.setForeground(new java.awt.Color(31, 43, 91));
        jlDataAtualLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlDataAtualLogin.setText("Data Atual");
        jlDataAtualLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jlDataAtualLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, 20));

        jLabelSenha.setBackground(new java.awt.Color(238, 238, 238));
        jLabelSenha.setFont(new java.awt.Font("Dialog", 0, 19)); // NOI18N
        jLabelSenha.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSenha.setText("Senha:");
        jPanel1.add(jLabelSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 315, 70, 30));

        jLabelLogin.setBackground(new java.awt.Color(238, 238, 238));
        jLabelLogin.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabelLogin.setForeground(new java.awt.Color(42, 152, 223));
        jLabelLogin.setText("Login");
        jPanel1.add(jLabelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, -1, 50));

        jLabelUsuario.setBackground(new java.awt.Color(238, 238, 238));
        jLabelUsuario.setFont(new java.awt.Font("Dialog", 0, 19)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario.setText("Usuário:");
        jPanel1.add(jLabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 265, -1, -1));

        jLabelFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/LifeMed_Login.png"))); // NOI18N
        jPanel1.add(jLabelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //-----+++++++++++++++++++++++=========== OPÇÕES DO JFRAME =============+++++++++++++++++-----
    //Botão Minimizar.
    private void jbMinimizarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMinimizarLoginActionPerformed
        this.setExtendedState(Login.ICONIFIED);
    }//GEN-LAST:event_jbMinimizarLoginActionPerformed

    //Botão Fechar.
    private void jbFecharLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharLoginActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jbFecharLoginActionPerformed
    
    //Botão Entrar.
    private void jbEntrarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEntrarLoginActionPerformed
       realizarLogin();
    }//GEN-LAST:event_jbEntrarLoginActionPerformed
    
    //Não tenho cadastaro.
    private void jlNovoCadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlNovoCadastroMouseClicked
        novoLogin = new Usuario();
        this.setVisible(false);
        novoLogin.setVisible(true);
    }//GEN-LAST:event_jlNovoCadastroMouseClicked
    
    //Usuario_KeyPressed_Enter
    private void jtfUsuarioLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfUsuarioLoginKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) this.realizarLogin();
    }//GEN-LAST:event_jtfUsuarioLoginKeyPressed
    //Senha_KeyPressed_Enter
    private void jpSenhaLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpSenhaLoginKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) this.realizarLogin();
    }//GEN-LAST:event_jpSenhaLoginKeyPressed
    
    //Dar foco no campo login ao ativar janela.
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        jtfUsuarioLogin.requestFocus();
    }//GEN-LAST:event_formWindowActivated
    
    //Botão Sair Login.
    private void jbSairLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairLoginActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jbSairLoginActionPerformed
    
    //Realiza Login.
    private void realizarLogin() {
        modelUsuario.setLogin(jtfUsuarioLogin.getText());
        modelUsuario.setSenha(String.valueOf(jpSenhaLogin.getPassword()));
        
        if(controllerUsuario.validarUsuarioController(modelUsuario))
        {
            this.nomeUsuario = jtfUsuarioLogin.getText();
            this.setVisible(false);
            new Menu(nomeUsuario).setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Usuário e/ou Senha estão incorretos!");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbEntrarLogin;
    private javax.swing.JButton jbFecharLogin;
    private javax.swing.JButton jbMinimizarLogin;
    private javax.swing.JButton jbSairLogin;
    private javax.swing.JLabel jlDataAtualLogin;
    private javax.swing.JLabel jlHoraAtualLogin;
    private javax.swing.JLabel jlNovoCadastro;
    private javax.swing.JPasswordField jpSenhaLogin;
    private javax.swing.JTextField jtfUsuarioLogin;
    // End of variables declaration//GEN-END:variables


}
