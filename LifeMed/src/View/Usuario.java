package View;

// @author LucasMarcuzo

import controller.ControllerUsuario;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import model.ModelUsuario;


public class Usuario extends javax.swing.JFrame implements IPadraoTelas{

    private static Login login;
    
    private static ModelUsuario modelNovoLogin;
    private static ControllerUsuario controllerNovoLogin = new ControllerUsuario();
    
    /**
     * Main.
     * @param args the command line arguments
     */
    public static void main(String args[]){
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
                new Usuario().setVisible(true); 
            }
        });
    }

    /**
     * Construtor Load.
     */
    public Usuario() {
        
        //Inicializando Form.
        initComponents();
        
        //Deixando bordas do form arredondadas.
        padraoBordasArredondadas(this);
        
        //Inserindo icone Padrão no form.
        padraoIconeForm(this);
        
        //Dar foco no campo matricula.
        jtfMatriculaNovoLogin.requestFocus();
    }
    
    //Código gerado automaticamente.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        jPanel1 = new javax.swing.JPanel();
        jbFecharNovoLogin = new javax.swing.JButton();
        jbSalvarNovoLogin = new javax.swing.JButton();
        jlFundoNovoLogin = new javax.swing.JLabel();
        jlIDNovoLogin = new javax.swing.JLabel();
        jlUsuarioNovoLogin = new javax.swing.JLabel();
        jlSenhaNovoLogin = new javax.swing.JLabel();
        jlCriarNovoLogin = new javax.swing.JLabel();
        jtfIDNovoLogin = new javax.swing.JTextField();
        jtfUsuarioNovoLogin = new javax.swing.JTextField();
        jtfMatriculaNovoLogin = new javax.swing.JTextField();
        jlMatriculaNovoLogin = new javax.swing.JLabel();
        jpSenhaNovoLogin = new javax.swing.JPasswordField();

        label1.setText("label1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(31, 43, 91));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(31, 43, 91));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbFecharNovoLogin.setBackground(new Color(0,0,0,0));
        jbFecharNovoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/fechar-36.png"))); // NOI18N
        jbFecharNovoLogin.setToolTipText("Fechar");
        jbFecharNovoLogin.setBorder(null);
        jbFecharNovoLogin.setBorderPainted(false);
        jbFecharNovoLogin.setContentAreaFilled(false);
        jbFecharNovoLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbFecharNovoLogin.setMargin(new java.awt.Insets(0, 14, 0, 14));
        jbFecharNovoLogin.setMaximumSize(new java.awt.Dimension(40, 40));
        jbFecharNovoLogin.setMinimumSize(new java.awt.Dimension(40, 40));
        jbFecharNovoLogin.setPreferredSize(new java.awt.Dimension(40, 40));
        jbFecharNovoLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFecharNovoLoginActionPerformed(evt);
            }
        });
        jPanel1.add(jbFecharNovoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 5, 30, 30));

        jbSalvarNovoLogin.setBackground(new java.awt.Color(255, 255, 255));
        jbSalvarNovoLogin.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbSalvarNovoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/salvar-36.png"))); // NOI18N
        jbSalvarNovoLogin.setText("Salvar");
        jbSalvarNovoLogin.setToolTipText("Clique para salvar");
        jbSalvarNovoLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbSalvarNovoLogin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbSalvarNovoLogin.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbSalvarNovoLogin.setIconTextGap(8);
        jbSalvarNovoLogin.setMaximumSize(new java.awt.Dimension(106, 45));
        jbSalvarNovoLogin.setMinimumSize(new java.awt.Dimension(106, 45));
        jbSalvarNovoLogin.setNextFocusableComponent(jtfMatriculaNovoLogin);
        jbSalvarNovoLogin.setPreferredSize(new java.awt.Dimension(106, 45));
        jbSalvarNovoLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarNovoLoginActionPerformed(evt);
            }
        });
        jPanel1.add(jbSalvarNovoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 130, -1));

        jlFundoNovoLogin.setBackground(new java.awt.Color(31, 43, 91));
        jlFundoNovoLogin.setForeground(new java.awt.Color(31, 43, 91));
        jlFundoNovoLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFundoNovoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/LifeMed_Load.png"))); // NOI18N
        jlFundoNovoLogin.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jlFundoNovoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 130));

        jlIDNovoLogin.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jlIDNovoLogin.setForeground(new java.awt.Color(255, 255, 255));
        jlIDNovoLogin.setText("ID:");
        jPanel1.add(jlIDNovoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 20, 25));

        jlUsuarioNovoLogin.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jlUsuarioNovoLogin.setForeground(new java.awt.Color(255, 255, 255));
        jlUsuarioNovoLogin.setText("Usuário:");
        jPanel1.add(jlUsuarioNovoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, 25));

        jlSenhaNovoLogin.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jlSenhaNovoLogin.setForeground(new java.awt.Color(255, 255, 255));
        jlSenhaNovoLogin.setText("Senha:");
        jPanel1.add(jlSenhaNovoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 50, 25));

        jlCriarNovoLogin.setBackground(new java.awt.Color(238, 238, 238));
        jlCriarNovoLogin.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jlCriarNovoLogin.setForeground(new java.awt.Color(255, 255, 255));
        jlCriarNovoLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlCriarNovoLogin.setText("Criar Novo Login");
        jlCriarNovoLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jlCriarNovoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 440, 60));

        jtfIDNovoLogin.setEditable(false);
        jtfIDNovoLogin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfIDNovoLogin.setFocusable(false);
        jtfIDNovoLogin.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfIDNovoLogin.setNextFocusableComponent(jtfUsuarioNovoLogin);
        jtfIDNovoLogin.setPreferredSize(new java.awt.Dimension(30, 25));
        jPanel1.add(jtfIDNovoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 80, -1));
        jtfIDNovoLogin.getAccessibleContext().setAccessibleDescription("Digite a Matricula");

        jtfUsuarioNovoLogin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfUsuarioNovoLogin.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfUsuarioNovoLogin.setNextFocusableComponent(jpSenhaNovoLogin);
        jtfUsuarioNovoLogin.setPreferredSize(new java.awt.Dimension(30, 25));
        jtfUsuarioNovoLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfUsuarioNovoLoginKeyPressed(evt);
            }
        });
        jPanel1.add(jtfUsuarioNovoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 140, 25));

        jtfMatriculaNovoLogin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfMatriculaNovoLogin.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfMatriculaNovoLogin.setNextFocusableComponent(jtfUsuarioNovoLogin);
        jtfMatriculaNovoLogin.setPreferredSize(new java.awt.Dimension(30, 25));
        jtfMatriculaNovoLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfMatriculaNovoLoginFocusGained(evt);
            }
        });
        jtfMatriculaNovoLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfMatriculaNovoLoginKeyPressed(evt);
            }
        });
        jPanel1.add(jtfMatriculaNovoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 140, -1));

        jlMatriculaNovoLogin.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jlMatriculaNovoLogin.setForeground(new java.awt.Color(255, 255, 255));
        jlMatriculaNovoLogin.setText("Matricula:");
        jPanel1.add(jlMatriculaNovoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 75, 25));

        jpSenhaNovoLogin.setMinimumSize(new java.awt.Dimension(30, 25));
        jpSenhaNovoLogin.setNextFocusableComponent(jbSalvarNovoLogin);
        jpSenhaNovoLogin.setPreferredSize(new java.awt.Dimension(30, 25));
        jpSenhaNovoLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpSenhaNovoLoginKeyPressed(evt);
            }
        });
        jPanel1.add(jpSenhaNovoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 140, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 370));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    //Fechar Novo Login
    private void jbFecharNovoLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharNovoLoginActionPerformed
        this.setVisible(false);
        login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_jbFecharNovoLoginActionPerformed
    
    //Criar Novo Login.
    private void jbSalvarNovoLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarNovoLoginActionPerformed
       criarNovoLogin();
    }//GEN-LAST:event_jbSalvarNovoLoginActionPerformed
    
    //Carregar próximo ID do Login.
    private void jtfMatriculaNovoLoginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfMatriculaNovoLoginFocusGained
        jtfIDNovoLogin.setText((String.valueOf(controllerNovoLogin.retornarProximoIDNovoLogin())));
    }//GEN-LAST:event_jtfMatriculaNovoLoginFocusGained
    
    //Login_KeyPressed_Enter
    private void jtfMatriculaNovoLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMatriculaNovoLoginKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) this.criarNovoLogin();
    }//GEN-LAST:event_jtfMatriculaNovoLoginKeyPressed
    //Usuario_KeyPressed_Enter
    private void jtfUsuarioNovoLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfUsuarioNovoLoginKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) this.criarNovoLogin();
    }//GEN-LAST:event_jtfUsuarioNovoLoginKeyPressed
    //Senha_KeyPressed_Enter
    private void jpSenhaNovoLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpSenhaNovoLoginKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) this.criarNovoLogin();
    }//GEN-LAST:event_jpSenhaNovoLoginKeyPressed

    //Método para criação do Login
    private void criarNovoLogin(){
        //Cadastrar usuário
        modelNovoLogin = new ModelUsuario();
        modelNovoLogin.setId_novoLogin(Integer.parseInt(jtfIDNovoLogin.getText()));
        modelNovoLogin.setLogin(jtfUsuarioNovoLogin.getText());
        modelNovoLogin.setSenha(String.valueOf(jpSenhaNovoLogin.getPassword()));
        modelNovoLogin.setMatricula(Integer.parseInt(jtfMatriculaNovoLogin.getText()));
 
        int result = controllerNovoLogin.salvarNovoLoginController(modelNovoLogin);
        
        //Salvar Usuário.
        if (result < 0) {             
            switch (result) {
                case -1:
                    //Erro ao cadastrar usuário (Matrícula inválida).
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário! \n\nA Matrícula inserida não foi encontrada.", "Erro!", JOptionPane.ERROR_MESSAGE);
                    break;
                case -2:
                    //Erro ao cadastrar usuário (Matrícula já existente).
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário! \n\nMatrícula já cadastrada!", "Erro!", JOptionPane.ERROR_MESSAGE);
                    break;
                case -3:
                    //Erro ao cadastrar usuário (Login já existente).
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário! \n\nLogin já cadastro!", "Erro!", JOptionPane.ERROR_MESSAGE);
                    break;
                default:
                    //Erro ao cadastrar usuário ().
                    JOptionPane.showMessageDialog(null, "Erro desconhecido, contate o suporte", "Erro!", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } 
        else{ //Usuário cadastrado com sucesso. 
            JOptionPane.showMessageDialog(this, "Usuário criado com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            limparNovoLogin();
            jtfMatriculaNovoLogin.requestFocus();
        }
    }
    
    //Limpar campos do formulário.
    private void limparNovoLogin(){
        jtfIDNovoLogin.setText("");
        jtfUsuarioNovoLogin.setText("");
        jpSenhaNovoLogin.setText("");
        jtfMatriculaNovoLogin.setText("");
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbFecharNovoLogin;
    private javax.swing.JButton jbSalvarNovoLogin;
    private javax.swing.JLabel jlCriarNovoLogin;
    private javax.swing.JLabel jlFundoNovoLogin;
    private javax.swing.JLabel jlIDNovoLogin;
    private javax.swing.JLabel jlMatriculaNovoLogin;
    private javax.swing.JLabel jlSenhaNovoLogin;
    private javax.swing.JLabel jlUsuarioNovoLogin;
    private javax.swing.JPasswordField jpSenhaNovoLogin;
    private javax.swing.JTextField jtfIDNovoLogin;
    private javax.swing.JTextField jtfMatriculaNovoLogin;
    private javax.swing.JTextField jtfUsuarioNovoLogin;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
