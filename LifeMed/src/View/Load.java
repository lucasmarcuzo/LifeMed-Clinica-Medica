package View;

// @author LucasMarcuzo
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Load extends javax.swing.JFrame implements IPadraoTelas{
    
    private static Load load;
    private static Login login;
    /**
     * Main.
     * @param args the command line arguments
     */
    public static void main(String args[]){
        //Inicializando tela de carregamento do programa.
        load = new Load();
        load.setVisible(true);

        for (int x = 0; x <= 100; x++) {
            try {
                Thread.sleep(60);
                load.jlPorcentagemLoad.setText(Integer.toString(x) + " %");
                load.jpbBarraProgresso.setValue(x);
                
                if (x == 100) {
                    login = new Login();
                    load.dispose();
                    login.setVisible(true);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Load.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Construtor Load.
     */
    public Load() {
        //Inicializando Form.
        initComponents();
        
        //Permitir mudança de cor da Barra de Progresso.
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Load.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Deixando bordas do form arredondadas.
        padraoBordasArredondadas(this);
        
        //Inserindo icone Padrão no form.
        padraoIconeForm(this);
    }
    
    //Código gerado automaticamente.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        jlPorcentagemLoad = new javax.swing.JLabel();
        jlCarregando = new javax.swing.JLabel();
        jlFundoLoad = new javax.swing.JLabel();
        jpbBarraProgresso = new javax.swing.JProgressBar();

        label1.setText("label1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlPorcentagemLoad.setFont(new java.awt.Font("Microsoft Sans Serif", 2, 14)); // NOI18N
        jlPorcentagemLoad.setForeground(new java.awt.Color(255, 255, 255));
        jlPorcentagemLoad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPorcentagemLoad.setText("0%");
        getContentPane().add(jlPorcentagemLoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 40, 20));

        jlCarregando.setFont(new java.awt.Font("Microsoft Sans Serif", 2, 14)); // NOI18N
        jlCarregando.setForeground(new java.awt.Color(255, 255, 255));
        jlCarregando.setText("Carregando...");
        getContentPane().add(jlCarregando, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 100, 20));

        jlFundoLoad.setBackground(new java.awt.Color(255, 255, 255));
        jlFundoLoad.setForeground(new java.awt.Color(255, 255, 255));
        jlFundoLoad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFundoLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/LifeMed_Load.png"))); // NOI18N
        jlFundoLoad.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jlFundoLoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jpbBarraProgresso.setBackground(new java.awt.Color(31, 43, 91));
        jpbBarraProgresso.setForeground(new java.awt.Color(14, 165, 216));
        jpbBarraProgresso.setBorderPainted(false);
        jpbBarraProgresso.setPreferredSize(new java.awt.Dimension(150, 5));
        getContentPane().add(jpbBarraProgresso, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 440, 11));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlCarregando;
    private javax.swing.JLabel jlFundoLoad;
    private javax.swing.JLabel jlPorcentagemLoad;
    public static javax.swing.JProgressBar jpbBarraProgresso;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
