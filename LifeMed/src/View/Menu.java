package View;

// @author LucasMarcuzo
import Util.CepWebService;
import controller.ControllerAgendamentos;
import controller.ControllerAtendimentoMedico;
import controller.ControllerFuncionarios;
import controller.ControllerPacientes;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import model.ModelAgendamentos;
import model.ModelAtendimentoMedico;
import model.ModelFuncionarios;
import model.ModelPacientes;


public class Menu extends javax.swing.JFrame implements IPadraoTelas{
    
    private static String cadastrarAlterarPacientes = "cad"; 
    private static String cadastrarAlterarFuncionarios = "cad"; 
    private static String cadastrarAlterarAgendamentos = "cad"; 
    
    private static ModelPacientes modelPacientes;
    private static final ControllerPacientes controllerPacientes = new ControllerPacientes();
    private static List<ModelPacientes> listaPacientes = new ArrayList<>();
    
    private static ModelFuncionarios modelFuncionarios;
    private static final ControllerFuncionarios controllerFuncionarios = new ControllerFuncionarios();
    private static List<ModelFuncionarios> listaFuncionarios = new ArrayList<>();
    
    private static ModelAgendamentos modelAgendamentos;
    private static final ControllerAgendamentos controllerAgendamentos = new ControllerAgendamentos();
    private static List<ModelAgendamentos> listaAgendamentos = new ArrayList<>();
    
    private static ModelAtendimentoMedico modelAtendimentoMed;
    private static final ControllerAtendimentoMedico controllerAtendimentoMed = new ControllerAtendimentoMedico();
    private static List<ModelAtendimentoMedico> listaAtendimentoMed = new ArrayList<>();
    
    private static CepWebService cepWebService;
    private static List<JButton> listaBotoesMenu;
    private static List<JLabel> listaSetasMenu;
    
    private static Login login;
    private static final long serialVersionUID = 1L;
    
    /**
     * Main. 
     * @param nomeUsuario
     */
    public static void main(String nomeUsuario) {
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu(nomeUsuario).setVisible(true);
            }
        });
    }

    /**
     * Construtor Menu.
     * @param nomeUsuario
     */
    public Menu(String nomeUsuario) {
        initComponents();
        
        //Deixando bordas do form arredondadas.
        padraoBordasArredondadas(this);
        
        //Inserindo icone Padrão no form.
        padraoIconeForm(this);
        
        //Inserir botoes na listaBotoesMenu.
        inserirBotoesMenuLista();
        
        //Inserindo labels de setas na listaSetasMenu.
        listaSetasMenu();
        
        //Deixando botoes do menu com bordas padrão.
        padraoBotoesMenu(listaBotoesMenu);
        
        //Deixando labels das setas do menu com icone padrão.
        padraoCorSetas(listaSetasMenu);
        
        //Atualizando Data.
        atualizarDataAtual(jlDataAtualMenu);
        
        //Atualizando Hora.
        atualizarHorasAtuais(jlHorasAtuaisMenu);
        
        //Alterando o nome de usuário do Menu principal.
        jlNomeUsuario.setText(nomeUsuario);
        
    }
    
    //Inserir botões na listaBotoesMenu.
    private void inserirBotoesMenuLista(){
        listaBotoesMenu = new ArrayList<>();
        listaBotoesMenu.add(jbRegistrosMenu);
        listaBotoesMenu.add(jbAgendamentosMenu);
        listaBotoesMenu.add(jbAtendimentosMenu);
        listaBotoesMenu.add(jbLaboratorioMenu);
        listaBotoesMenu.add(jbFinanceiroMenu);
    }
    
    //Inserir labels das setas na listaSetasMenu.
    private void listaSetasMenu(){
        listaSetasMenu = new ArrayList<>();
        listaSetasMenu.add(jlSetaRegistros);
        listaSetasMenu.add(jlSetaAgendamentos);
        listaSetasMenu.add(jlSetaAtendimentos);
        listaSetasMenu.add(jlSetaLaboratorios);
        listaSetasMenu.add(jlSetaFinanceiro);
    }
    
    //Esconder todos os Panels do Menu.
    private void padraoFormsVisibleFalse(){
        jpPrincipalMenu.setVisible(false);
        
        jpRegistrosMenu.setVisible(false);
        jpPacientesRegistros.setVisible(false);
        jpFuncionariosRegistros.setVisible(false);
        
        jpAgendamentosMenu.setVisible(false);
        jpAgendamentos.setVisible(false);
        
        jpAtendimentosMenu.setVisible(false);
        jpMedicosAtendimentos.setVisible(false);
        jpEnfermeirosAtendimentos.setVisible(false);
        
        jpLaborartoriosMenu.setVisible(false);
        jpInserirResultadosLaboratorios.setVisible(false);
        jpVerResultadosLaboratorios.setVisible(false);
        
        jpFinanceiroMenu.setVisible(false);
        jpRecebimentosFinanceiro.setVisible(false);
        
    }
    
    //Padrão de eventos para os botoes do Menu.
    private void eventosPadraoBotoesMenu(JPanel jpVisivel, String nomeMenu, JButton jb, JLabel jlsetaBotao){
        padraoFormsVisibleFalse(); //Escondendo todos os Panels.
        jpVisivel.setVisible(true); //Deixando somente o jpanel passado como visivel.
        jlNomeMenu.setText(nomeMenu); //Trocando o nome do Menu Principal Superior.
        padraoBotoesMenu(listaBotoesMenu); //Definindo os botoes como padrão.
        jb.setBorderPainted(true); //Colorindo somente o botão selecionado.
        jb.setBorder(new LineBorder(new Color(31, 43, 91), 2, true)); //Colorindo somente o botão selecionado.
        padraoCorSetas(listaSetasMenu); //Definindo cores das setas como padrão.
        jlsetaBotao.setIcon(new ImageIcon(getClass().getResource("/View/Images/seta-esquerda-azul-13-30.png"))); //Colorindo seta do btn selecionado.
        //Definindo o botão sair parar voltar.
        jbSairMenu.setIcon(new ImageIcon(getClass().getResource("/View/Images/voltar-48.png")));
        jbSairMenu.setRolloverEnabled(false);
        jbSairMenu.setText("Voltar");
        jbSairMenu.setToolTipText("Clique para voltar ao Menu anterior.");
    }
    
    //Código gerado altomaticamente pela IDE.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpColunaBotoesMenu = new javax.swing.JPanel();
        jlIconeMenu = new javax.swing.JLabel();
        jlUsuarioMenu = new javax.swing.JLabel();
        jlNomeUsuario = new javax.swing.JLabel();
        jlSetaRegistros = new javax.swing.JLabel();
        jlSetaAgendamentos = new javax.swing.JLabel();
        jlSetaAtendimentos = new javax.swing.JLabel();
        jlSetaLaboratorios = new javax.swing.JLabel();
        jlSetaFinanceiro = new javax.swing.JLabel();
        jbSairMenu = new javax.swing.JButton();
        jbFinanceiroMenu = new javax.swing.JButton();
        jbLaboratorioMenu = new javax.swing.JButton();
        jbAtendimentosMenu = new javax.swing.JButton();
        jbAgendamentosMenu = new javax.swing.JButton();
        jbRegistrosMenu = new javax.swing.JButton();
        jpNomeMenu = new javax.swing.JPanel();
        jlDataAtualMenu = new javax.swing.JLabel();
        jlHorasAtuaisMenu = new javax.swing.JLabel();
        jlNomeMenu = new javax.swing.JLabel();
        jbFecharMenu = new javax.swing.JButton();
        jbMinimizarMenu = new javax.swing.JButton();
        jpMenuPrincipal = new javax.swing.JPanel();
        jpPrincipalMenu = new javax.swing.JPanel();
        jlSloganMenu = new javax.swing.JLabel();
        jpRegistrosMenu = new javax.swing.JPanel();
        jbFuncionariosRegistros = new javax.swing.JButton();
        jbPacientesRegistros = new javax.swing.JButton();
        jpPacientesRegistros = new javax.swing.JPanel();
        jpDadosPessoaisPacientesRegistros = new javax.swing.JPanel();
        jlIDPacientes = new javax.swing.JLabel();
        jlEstadoCivilPacientes = new javax.swing.JLabel();
        jlSexoPacientes = new javax.swing.JLabel();
        jlRGPacientes = new javax.swing.JLabel();
        jlNomePacientes = new javax.swing.JLabel();
        jlTelefoneRecadoPacientes = new javax.swing.JLabel();
        jlClienteDesdePacientes = new javax.swing.JLabel();
        jlEmailPacientes = new javax.swing.JLabel();
        jlNumCasaPacientes = new javax.swing.JLabel();
        jlDataNascPacientes = new javax.swing.JLabel();
        jlOrgaoExpedidorPacientes = new javax.swing.JLabel();
        jlNacionalidadePacientes = new javax.swing.JLabel();
        jlTipoPacientes = new javax.swing.JLabel();
        jlLogradouroPacientes = new javax.swing.JLabel();
        jlCelularPacientes = new javax.swing.JLabel();
        jlCEPPacientes = new javax.swing.JLabel();
        jlCidadePacientes = new javax.swing.JLabel();
        jlBairroPacientes = new javax.swing.JLabel();
        jlEstadoPacientes = new javax.swing.JLabel();
        jlComplementoPacientes = new javax.swing.JLabel();
        jlCPFPacientes = new javax.swing.JLabel();
        jlNaturalidadePacientes = new javax.swing.JLabel();
        jlTelefoneFixoPacientes = new javax.swing.JLabel();
        jtfIDPacientes = new javax.swing.JTextField();
        jtfNomePacientes = new javax.swing.JTextField();
        jtfEmailPacientes = new javax.swing.JTextField();
        jtfLogradouroPacientes = new javax.swing.JTextField();
        jtfNumeroCasaPacientes = new javax.swing.JTextField();
        jtfCidadePacientes = new javax.swing.JTextField();
        jtfUFPacientes = new javax.swing.JTextField();
        jtfComplementoPacientes = new javax.swing.JTextField();
        jtfTipoLogradouroPacientes = new javax.swing.JTextField();
        jtfBairroPacientes = new javax.swing.JTextField();
        jftTelefoneRecadoPacientes = new javax.swing.JFormattedTextField();
        jftRGPacientes = new javax.swing.JFormattedTextField();
        jftCadastradoDesdePacientes = new javax.swing.JFormattedTextField();
        jftCepPacientes = new javax.swing.JFormattedTextField();
        jftCelularPacientes = new javax.swing.JFormattedTextField();
        jftCPFPacientes = new javax.swing.JFormattedTextField();
        jftTelefoneFixoPacientes = new javax.swing.JFormattedTextField();
        jcbEstadoCivilPacientes = new javax.swing.JComboBox<>();
        jcbNacionalidadePacientes = new javax.swing.JComboBox<>();
        jcbNaturalidadePacientes = new javax.swing.JComboBox<>();
        jdcDataNascPacientes = new com.toedter.calendar.JDateChooser();
        jcbSexoPacientes = new javax.swing.JComboBox<>();
        jtfOrgaoExpedidorPacientes = new javax.swing.JTextField();
        jpListaPacientesRegistros = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaPacientes = new javax.swing.JTable();
        jlPesquisarPacientes = new javax.swing.JLabel();
        jlFiltrarPacientes = new javax.swing.JLabel();
        jtfPesquisarPacientes = new javax.swing.JTextField();
        jcbFiltrarPacientes = new javax.swing.JComboBox<>();
        jbProcurarPacientes = new javax.swing.JButton();
        jlNomeTelaPacientes = new javax.swing.JLabel();
        jbNovoPacientes = new javax.swing.JButton();
        jbEditarPacientes = new javax.swing.JButton();
        jbSalvarPacientes = new javax.swing.JButton();
        jbExlcuirPacientes = new javax.swing.JButton();
        jbLimparTelaPacientes = new javax.swing.JButton();
        jpFuncionariosRegistros = new javax.swing.JPanel();
        jpDadosPessoaisFuncionarios = new javax.swing.JPanel();
        jlSexoFuncionarios = new javax.swing.JLabel();
        jlRGFuncionarios = new javax.swing.JLabel();
        jlNomeFuncionarios = new javax.swing.JLabel();
        jlIDFuncionarios = new javax.swing.JLabel();
        jlEstadoCivilFuncionarios = new javax.swing.JLabel();
        jlTelefoneRecadoFuncionarios = new javax.swing.JLabel();
        jlEmailFuncionarios = new javax.swing.JLabel();
        jlNumCasaFuncionarios = new javax.swing.JLabel();
        jlDataNascFuncionarios = new javax.swing.JLabel();
        jlCelularFuncionarios = new javax.swing.JLabel();
        jlCEPFuncionarios = new javax.swing.JLabel();
        jlCidadeFuncionarios = new javax.swing.JLabel();
        jlBairroFuncionarios = new javax.swing.JLabel();
        jlEstadoFuncionarios = new javax.swing.JLabel();
        jlComplementoFuncionarios = new javax.swing.JLabel();
        jlCPFFuncionarios = new javax.swing.JLabel();
        jlNaturalidadeFuncionarios = new javax.swing.JLabel();
        jlTelefoneFixoFuncionarios = new javax.swing.JLabel();
        jlOrgaoExpedFuncionarios = new javax.swing.JLabel();
        jlNacionalidadeFuncionarios = new javax.swing.JLabel();
        jlTipoLogradouroFuncionarios = new javax.swing.JLabel();
        jlLogradouroFuncionarios = new javax.swing.JLabel();
        jtfIDFuncionarios = new javax.swing.JTextField();
        jtfEmailFuncionarios = new javax.swing.JTextField();
        jtfNomeFuncionarios = new javax.swing.JTextField();
        jtfTipoLogradouroFuncionarios = new javax.swing.JTextField();
        jtfLogradouroFuncionarios = new javax.swing.JTextField();
        jtfNumeroCasaFuncionarios = new javax.swing.JTextField();
        jtfCidadeFuncionarios = new javax.swing.JTextField();
        jtfUFFuncionarios = new javax.swing.JTextField();
        jtfOrgaoExpedFuncionarios = new javax.swing.JTextField();
        jtfBairroFuncionarios = new javax.swing.JTextField();
        jtfComplementoFuncionarios = new javax.swing.JTextField();
        jftTelefoneRecadoFuncionarios = new javax.swing.JFormattedTextField();
        jftRGFuncionarios = new javax.swing.JFormattedTextField();
        jftCepFuncionarios = new javax.swing.JFormattedTextField();
        jftCelularFuncionarios = new javax.swing.JFormattedTextField();
        jftCPFFuncionarios = new javax.swing.JFormattedTextField();
        jftTelefoneFixoFuncionarios = new javax.swing.JFormattedTextField();
        jcbEstadoCivilFuncionarios = new javax.swing.JComboBox<>();
        jcbNacionalidadeFuncionarios = new javax.swing.JComboBox<>();
        jcbSexoFuncionarios = new javax.swing.JComboBox<>();
        jcbNaturalidadeFuncionarios = new javax.swing.JComboBox<>();
        jdcDataNascFuncionarios = new com.toedter.calendar.JDateChooser();
        jpDadosFuncionarios = new javax.swing.JPanel();
        jlCTPSFuncionarios = new javax.swing.JLabel();
        jlFuncaoFuncionarios = new javax.swing.JLabel();
        jlFuncionarioDesdeFuncionarios = new javax.swing.JLabel();
        jlDataAdmFuncionarios = new javax.swing.JLabel();
        jlSetorFuncionarios = new javax.swing.JLabel();
        jlMatriculaFuncionarios = new javax.swing.JLabel();
        jlDataDemFuncionarios = new javax.swing.JLabel();
        jlPISFuncionarios = new javax.swing.JLabel();
        jlSerieUFFuncionarios = new javax.swing.JLabel();
        jtfMatriculaFuncionarios = new javax.swing.JTextField();
        jtfPISFuncionarios = new javax.swing.JTextField();
        jtfCTPSFuncionarios = new javax.swing.JTextField();
        jtfSerieUFFuncionarios = new javax.swing.JTextField();
        jftFuncionarioDesdeFuncionarios = new javax.swing.JFormattedTextField();
        jcbSetorFuncionarios = new javax.swing.JComboBox<>();
        jcbFuncaoFuncionarios = new javax.swing.JComboBox<>();
        jdcDataAdmFuncionarios = new com.toedter.calendar.JDateChooser();
        jdcDataDemFuncionarios = new com.toedter.calendar.JDateChooser();
        jpListaFuncionarios = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtListaFuncionarios = new javax.swing.JTable();
        jlPesquisarFuncionarios = new javax.swing.JLabel();
        jlFiltrarFuncionarios = new javax.swing.JLabel();
        jtfPesquisarFuncionarios = new javax.swing.JTextField();
        jcbFiltrarFuncionarios = new javax.swing.JComboBox<>();
        jbProcurarFuncionarios = new javax.swing.JButton();
        jlNomeTelaFuncionarios = new javax.swing.JLabel();
        jbSalvarFuncionarios = new javax.swing.JButton();
        jbLimparTelaFuncionarios = new javax.swing.JButton();
        jbExcluirFuncionarios = new javax.swing.JButton();
        jpEditarFuncionarios = new javax.swing.JButton();
        jbNovoFuncionarios = new javax.swing.JButton();
        jpAgendamentosMenu = new javax.swing.JPanel();
        jbConsultasAgendamentos = new javax.swing.JButton();
        jbExamesAgendamentos = new javax.swing.JButton();
        jbVacinasAgendamentos = new javax.swing.JButton();
        jpAgendamentos = new javax.swing.JPanel();
        jlNomeTelaAgendamentos = new javax.swing.JLabel();
        jpDadosDoAgendamentos = new javax.swing.JPanel();
        jlIDAgendamentos = new javax.swing.JLabel();
        jlDataAgendamentos = new javax.swing.JLabel();
        jlHoraAgendamentos = new javax.swing.JLabel();
        jlPacienteAgendamentos = new javax.swing.JLabel();
        jlTelefoneFixoAgendamentos = new javax.swing.JLabel();
        jlCelularAgendamentos = new javax.swing.JLabel();
        jlTelefoneRecadoAgendamentos = new javax.swing.JLabel();
        jlStatusAgendamentos = new javax.swing.JLabel();
        jlObservacoesAgendamentos = new javax.swing.JLabel();
        jlTipoAtendAgendamentos = new javax.swing.JLabel();
        jlEspecialidadeAgendamentos = new javax.swing.JLabel();
        jlTipoProcedimentoAgendamentos = new javax.swing.JLabel();
        jlConvenioAgendamentos = new javax.swing.JLabel();
        jlEspecialistaAgendamentos = new javax.swing.JLabel();
        jlProcedimentoAgendamentos = new javax.swing.JLabel();
        jldtDoAgendAgendamentos = new javax.swing.JLabel();
        jtfIDAgendamentos = new javax.swing.JTextField();
        jftTelefoneFixoAgendamentos = new javax.swing.JFormattedTextField();
        jftCelularAgendamentos = new javax.swing.JFormattedTextField();
        jftTelefoneRecadoAgendamentos = new javax.swing.JFormattedTextField();
        jcbPacienteAgendamentos = new javax.swing.JComboBox<>();
        jcbHoraAgendamentos = new javax.swing.JComboBox<>();
        jcbStatusAgendamentos = new javax.swing.JComboBox<>();
        jcbEspecialidadeAgendamentos = new javax.swing.JComboBox<>();
        jcbEspecialistaAgendamentos = new javax.swing.JComboBox<>();
        jcbTipoAtendAgendamentos = new javax.swing.JComboBox<>();
        jcbProcedimentoAgendamentos = new javax.swing.JComboBox<>();
        jcbConvenioAgendamentos = new javax.swing.JComboBox<>();
        jcbTipoProcedimentoAgendamentos = new javax.swing.JComboBox<>();
        jdcDataAgendamentos = new com.toedter.calendar.JDateChooser();
        jftDataAgendAgendamentos = new javax.swing.JFormattedTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtpObservacoesAgendamentos = new javax.swing.JTextPane();
        jpListaDeAgendamentos = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtListaAgendamentos = new javax.swing.JTable();
        jlPesquisarAgendamentos = new javax.swing.JLabel();
        jlFiltrarAgendamentos = new javax.swing.JLabel();
        jtfPesquisarAgendamentos = new javax.swing.JTextField();
        jcbFiltrarAgendamentos = new javax.swing.JComboBox<>();
        jbProcurarAgendamentos = new javax.swing.JButton();
        jbNovoAgendamentos = new javax.swing.JButton();
        jbEditarAgendamentos = new javax.swing.JButton();
        jbSalvarAgendamentos = new javax.swing.JButton();
        jbExlcuirAgendamentos = new javax.swing.JButton();
        jbLimparTelaAgendamentos = new javax.swing.JButton();
        jpAtendimentosMenu = new javax.swing.JPanel();
        jbMedicosAtendimentos = new javax.swing.JButton();
        jbEnfermeirosAtendimentos = new javax.swing.JButton();
        jpMedicosAtendimentos = new javax.swing.JPanel();
        jlNomeTelaAtendMedico = new javax.swing.JLabel();
        jbLimparTelaAtendMedico = new javax.swing.JButton();
        jbSalvarAtendMedico = new javax.swing.JButton();
        jpDadosPacienteAtendMedico = new javax.swing.JPanel();
        jlPacienteAtendMedico = new javax.swing.JLabel();
        jcbPacienteAtendMedico = new javax.swing.JComboBox<>();
        jlSexoAtendMedico = new javax.swing.JLabel();
        jcbSexoPacienteAtendMedico = new javax.swing.JComboBox<>();
        jlDataNascPacienteAtendMedico = new javax.swing.JLabel();
        jdcDataNascPacienteAtendMedico = new com.toedter.calendar.JDateChooser();
        jtfLogradouroPacienteAtendMedico = new javax.swing.JTextField();
        jlLogradouroPacienteAtendMedico = new javax.swing.JLabel();
        jpConsultaAtendMedico = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtpDoencasCronicasAtendMedico = new javax.swing.JTextPane();
        jlDoencasCronicasAtendMedico = new javax.swing.JLabel();
        jlDiagnosticoAtendMedico = new javax.swing.JLabel();
        jcbDoencasCronicasAtendMedico = new javax.swing.JComboBox<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        jtpDiagnosticoAtendMedico = new javax.swing.JTextPane();
        jbAdcDoencaCronicaAtendMedico = new javax.swing.JButton();
        jtfIDAtendMedico = new javax.swing.JTextField();
        jlIDAtendMedico = new javax.swing.JLabel();
        jtfConsultasDiaAtendMedico = new javax.swing.JTextField();
        jtfMatriculaMedicoAtendMedico = new javax.swing.JTextField();
        jlConsultasDiaAtendMedico = new javax.swing.JLabel();
        jlConsultasDiaAtendMedico1 = new javax.swing.JLabel();
        jlDataAtendMedico = new javax.swing.JLabel();
        jftDataAtendMedico = new javax.swing.JFormattedTextField();
        jpHistoricoPacienteAtendMedico = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtpHistoricoConsultaAtendMedico = new javax.swing.JTextPane();
        jlFiltrarAtendimentoAtendMedico = new javax.swing.JLabel();
        jlHistoricoDoencasCronicasAtendMedico = new javax.swing.JLabel();
        jlHistoricoConsultaAtendMedico = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jtpHistoricoDoencasCronicasAtendMedico = new javax.swing.JTextPane();
        jcbFiltrarAtendimentoAtendMedico = new javax.swing.JComboBox<>();
        jbNovoAtendMedico = new javax.swing.JButton();
        jpEnfermeirosAtendimentos = new javax.swing.JPanel();
        jpLaborartoriosMenu = new javax.swing.JPanel();
        jbInserirResultadosLaboratorios = new javax.swing.JButton();
        jbVerResultadosLaboratorios = new javax.swing.JButton();
        jpInserirResultadosLaboratorios = new javax.swing.JPanel();
        jpVerResultadosLaboratorios = new javax.swing.JPanel();
        jpFinanceiroMenu = new javax.swing.JPanel();
        jbRecebimentosFinanceiro = new javax.swing.JButton();
        jpRecebimentosFinanceiro = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(14, 165, 216));
        setMaximumSize(null);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1280, 720));

        jpColunaBotoesMenu.setBackground(new java.awt.Color(42, 152, 223));
        jpColunaBotoesMenu.setPreferredSize(new java.awt.Dimension(133, 720));

        jlIconeMenu.setBackground(new java.awt.Color(31, 43, 91));
        jlIconeMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlIconeMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/LifeMed_(120 px × 66 px).png"))); // NOI18N
        jlIconeMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jlUsuarioMenu.setBackground(new java.awt.Color(255, 255, 255));
        jlUsuarioMenu.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jlUsuarioMenu.setForeground(new java.awt.Color(31, 43, 91));
        jlUsuarioMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlUsuarioMenu.setText("Usuário:");
        jlUsuarioMenu.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jlNomeUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jlNomeUsuario.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jlNomeUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jlNomeUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlNomeUsuario.setText("<html>\n Administrador");
        jlNomeUsuario.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jlSetaRegistros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlSetaRegistros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/seta-esquerda-13-30.png"))); // NOI18N
        jlSetaRegistros.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jlSetaRegistros.setIconTextGap(0);

        jlSetaAgendamentos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlSetaAgendamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/seta-esquerda-13-30.png"))); // NOI18N

        jlSetaAtendimentos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlSetaAtendimentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/seta-esquerda-13-30.png"))); // NOI18N

        jlSetaLaboratorios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlSetaLaboratorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/seta-esquerda-13-30.png"))); // NOI18N
        jlSetaLaboratorios.setVerifyInputWhenFocusTarget(false);

        jlSetaFinanceiro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlSetaFinanceiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/seta-esquerda-13-30.png"))); // NOI18N
        jlSetaFinanceiro.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jbSairMenu.setBackground(new java.awt.Color(42, 152, 223));
        jbSairMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbSairMenu.setForeground(new java.awt.Color(255, 255, 255));
        jbSairMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/sair-48.png"))); // NOI18N
        jbSairMenu.setText("Sair");
        jbSairMenu.setToolTipText("Clique para Sair do programa");
        jbSairMenu.setBorder(null);
        jbSairMenu.setBorderPainted(false);
        jbSairMenu.setContentAreaFilled(false);
        jbSairMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbSairMenu.setFocusPainted(false);
        jbSairMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbSairMenu.setIconTextGap(0);
        jbSairMenu.setMaximumSize(new java.awt.Dimension(120, 70));
        jbSairMenu.setMinimumSize(new java.awt.Dimension(120, 70));
        jbSairMenu.setPreferredSize(new java.awt.Dimension(120, 70));
        jbSairMenu.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Sair-48-rollover.png"))); // NOI18N
        jbSairMenu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbSairMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairMenuActionPerformed(evt);
            }
        });

        jbFinanceiroMenu.setBackground(new java.awt.Color(42, 152, 223));
        jbFinanceiroMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbFinanceiroMenu.setForeground(new java.awt.Color(255, 255, 255));
        jbFinanceiroMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/financeiro-48.png"))); // NOI18N
        jbFinanceiroMenu.setText("Financeiro");
        jbFinanceiroMenu.setBorder(null);
        jbFinanceiroMenu.setBorderPainted(false);
        jbFinanceiroMenu.setContentAreaFilled(false);
        jbFinanceiroMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbFinanceiroMenu.setFocusPainted(false);
        jbFinanceiroMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbFinanceiroMenu.setIconTextGap(0);
        jbFinanceiroMenu.setMaximumSize(new java.awt.Dimension(120, 70));
        jbFinanceiroMenu.setMinimumSize(new java.awt.Dimension(120, 70));
        jbFinanceiroMenu.setPreferredSize(new java.awt.Dimension(120, 70));
        jbFinanceiroMenu.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/financeiro-48-rollover.png"))); // NOI18N
        jbFinanceiroMenu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbFinanceiroMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFinanceiroMenuActionPerformed(evt);
            }
        });

        jbLaboratorioMenu.setBackground(new java.awt.Color(42, 152, 223));
        jbLaboratorioMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbLaboratorioMenu.setForeground(new java.awt.Color(255, 255, 255));
        jbLaboratorioMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/laboratorio-48.png"))); // NOI18N
        jbLaboratorioMenu.setText("Laboratório");
        jbLaboratorioMenu.setBorder(null);
        jbLaboratorioMenu.setBorderPainted(false);
        jbLaboratorioMenu.setContentAreaFilled(false);
        jbLaboratorioMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbLaboratorioMenu.setFocusPainted(false);
        jbLaboratorioMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbLaboratorioMenu.setIconTextGap(0);
        jbLaboratorioMenu.setMaximumSize(new java.awt.Dimension(120, 70));
        jbLaboratorioMenu.setMinimumSize(new java.awt.Dimension(120, 70));
        jbLaboratorioMenu.setPreferredSize(new java.awt.Dimension(120, 70));
        jbLaboratorioMenu.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/laboratorios-48-rollover.png"))); // NOI18N
        jbLaboratorioMenu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbLaboratorioMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLaboratorioMenuActionPerformed(evt);
            }
        });

        jbAtendimentosMenu.setBackground(new java.awt.Color(42, 152, 223));
        jbAtendimentosMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbAtendimentosMenu.setForeground(new java.awt.Color(255, 255, 255));
        jbAtendimentosMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/atendimentos-48.png"))); // NOI18N
        jbAtendimentosMenu.setText("Atendimentos");
        jbAtendimentosMenu.setBorder(null);
        jbAtendimentosMenu.setBorderPainted(false);
        jbAtendimentosMenu.setContentAreaFilled(false);
        jbAtendimentosMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbAtendimentosMenu.setFocusPainted(false);
        jbAtendimentosMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbAtendimentosMenu.setIconTextGap(0);
        jbAtendimentosMenu.setMaximumSize(new java.awt.Dimension(120, 70));
        jbAtendimentosMenu.setMinimumSize(new java.awt.Dimension(120, 70));
        jbAtendimentosMenu.setPreferredSize(new java.awt.Dimension(120, 70));
        jbAtendimentosMenu.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/atendimentos-48-rollover.png"))); // NOI18N
        jbAtendimentosMenu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbAtendimentosMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtendimentosMenuActionPerformed(evt);
            }
        });

        jbAgendamentosMenu.setBackground(new java.awt.Color(42, 152, 223));
        jbAgendamentosMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbAgendamentosMenu.setForeground(new java.awt.Color(255, 255, 255));
        jbAgendamentosMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/agendamentos-48.png"))); // NOI18N
        jbAgendamentosMenu.setText("Agendamentos");
        jbAgendamentosMenu.setBorder(null);
        jbAgendamentosMenu.setBorderPainted(false);
        jbAgendamentosMenu.setContentAreaFilled(false);
        jbAgendamentosMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbAgendamentosMenu.setFocusPainted(false);
        jbAgendamentosMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbAgendamentosMenu.setIconTextGap(0);
        jbAgendamentosMenu.setMaximumSize(new java.awt.Dimension(120, 70));
        jbAgendamentosMenu.setMinimumSize(new java.awt.Dimension(120, 70));
        jbAgendamentosMenu.setPreferredSize(new java.awt.Dimension(120, 70));
        jbAgendamentosMenu.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/agendamentos-48-rollover.png"))); // NOI18N
        jbAgendamentosMenu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbAgendamentosMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgendamentosMenuActionPerformed(evt);
            }
        });

        jbRegistrosMenu.setBackground(new java.awt.Color(42, 152, 223));
        jbRegistrosMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbRegistrosMenu.setForeground(new java.awt.Color(255, 255, 255));
        jbRegistrosMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/registros-48.png"))); // NOI18N
        jbRegistrosMenu.setText("Registros");
        jbRegistrosMenu.setBorder(null);
        jbRegistrosMenu.setBorderPainted(false);
        jbRegistrosMenu.setContentAreaFilled(false);
        jbRegistrosMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbRegistrosMenu.setFocusPainted(false);
        jbRegistrosMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbRegistrosMenu.setIconTextGap(0);
        jbRegistrosMenu.setMaximumSize(new java.awt.Dimension(120, 70));
        jbRegistrosMenu.setMinimumSize(new java.awt.Dimension(120, 70));
        jbRegistrosMenu.setPreferredSize(new java.awt.Dimension(120, 70));
        jbRegistrosMenu.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/registros-48-rollover.png"))); // NOI18N
        jbRegistrosMenu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbRegistrosMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegistrosMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpColunaBotoesMenuLayout = new javax.swing.GroupLayout(jpColunaBotoesMenu);
        jpColunaBotoesMenu.setLayout(jpColunaBotoesMenuLayout);
        jpColunaBotoesMenuLayout.setHorizontalGroup(
            jpColunaBotoesMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlIconeMenu)
            .addComponent(jlUsuarioMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jlNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jbRegistrosMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jbAgendamentosMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jbAtendimentosMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jbLaboratorioMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jbFinanceiroMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jbSairMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jpColunaBotoesMenuLayout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(jpColunaBotoesMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlSetaRegistros)
                    .addComponent(jlSetaAgendamentos)
                    .addComponent(jlSetaAtendimentos)
                    .addComponent(jlSetaLaboratorios)
                    .addComponent(jlSetaFinanceiro)))
        );
        jpColunaBotoesMenuLayout.setVerticalGroup(
            jpColunaBotoesMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpColunaBotoesMenuLayout.createSequentialGroup()
                .addComponent(jlIconeMenu)
                .addGap(5, 5, 5)
                .addComponent(jlUsuarioMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jlNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jpColunaBotoesMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlSetaRegistros)
                    .addGroup(jpColunaBotoesMenuLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jbRegistrosMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(jpColunaBotoesMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbAgendamentosMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpColunaBotoesMenuLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jlSetaAgendamentos)))
                .addGap(25, 25, 25)
                .addGroup(jpColunaBotoesMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpColunaBotoesMenuLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jlSetaAtendimentos))
                    .addComponent(jbAtendimentosMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jpColunaBotoesMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpColunaBotoesMenuLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jlSetaLaboratorios))
                    .addComponent(jbLaboratorioMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jpColunaBotoesMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpColunaBotoesMenuLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jlSetaFinanceiro))
                    .addComponent(jbFinanceiroMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(jbSairMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jpNomeMenu.setBackground(new java.awt.Color(31, 43, 91));
        jpNomeMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlDataAtualMenu.setBackground(new java.awt.Color(31, 43, 91));
        jlDataAtualMenu.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        jlDataAtualMenu.setForeground(new java.awt.Color(255, 255, 255));
        jlDataAtualMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlDataAtualMenu.setText("Data");
        jlDataAtualMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlDataAtualMenu.setIconTextGap(5);
        jpNomeMenu.add(jlDataAtualMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 100, 66));

        jlHorasAtuaisMenu.setBackground(new java.awt.Color(31, 43, 91));
        jlHorasAtuaisMenu.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        jlHorasAtuaisMenu.setForeground(new java.awt.Color(255, 255, 255));
        jlHorasAtuaisMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlHorasAtuaisMenu.setText("Hora");
        jlHorasAtuaisMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlHorasAtuaisMenu.setIconTextGap(5);
        jpNomeMenu.add(jlHorasAtuaisMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 120, 66));

        jlNomeMenu.setBackground(new java.awt.Color(31, 43, 91));
        jlNomeMenu.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jlNomeMenu.setForeground(new java.awt.Color(255, 255, 255));
        jlNomeMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlNomeMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/seta-direita-13-30.png"))); // NOI18N
        jlNomeMenu.setText("Menu Principal");
        jlNomeMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlNomeMenu.setIconTextGap(5);
        jlNomeMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlNomeMenuMouseClicked(evt);
            }
        });
        jpNomeMenu.add(jlNomeMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 66));

        jbFecharMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/fechar-48.png"))); // NOI18N
        jbFecharMenu.setBorder(null);
        jbFecharMenu.setBorderPainted(false);
        jbFecharMenu.setContentAreaFilled(false);
        jbFecharMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbFecharMenu.setIconTextGap(0);
        jbFecharMenu.setMargin(new java.awt.Insets(0, 14, 0, 14));
        jbFecharMenu.setMaximumSize(new java.awt.Dimension(40, 40));
        jbFecharMenu.setMinimumSize(new java.awt.Dimension(40, 40));
        jbFecharMenu.setPreferredSize(new java.awt.Dimension(40, 40));
        jbFecharMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFecharMenuActionPerformed(evt);
            }
        });
        jpNomeMenu.add(jbFecharMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1108, 13, -1, -1));
        jbFecharMenu.getAccessibleContext().setAccessibleName("Fechar");
        jbFecharMenu.getAccessibleContext().setAccessibleDescription("Clique para Fechar");

        jbMinimizarMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/minimizar-48.png"))); // NOI18N
        jbMinimizarMenu.setBorder(null);
        jbMinimizarMenu.setBorderPainted(false);
        jbMinimizarMenu.setContentAreaFilled(false);
        jbMinimizarMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbMinimizarMenu.setIconTextGap(0);
        jbMinimizarMenu.setMargin(new java.awt.Insets(0, 14, 0, 14));
        jbMinimizarMenu.setMaximumSize(new java.awt.Dimension(40, 40));
        jbMinimizarMenu.setMinimumSize(new java.awt.Dimension(40, 40));
        jbMinimizarMenu.setPreferredSize(new java.awt.Dimension(40, 40));
        jbMinimizarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMinimizarMenuActionPerformed(evt);
            }
        });
        jpNomeMenu.add(jbMinimizarMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1066, 13, -1, -1));
        jbMinimizarMenu.getAccessibleContext().setAccessibleName("Minimizar");
        jbMinimizarMenu.getAccessibleContext().setAccessibleDescription("Clique para Minimizar");

        jpMenuPrincipal.setBackground(new java.awt.Color(0, 0, 204));
        jpMenuPrincipal.setMinimumSize(new java.awt.Dimension(1160, 627));
        jpMenuPrincipal.setPreferredSize(new java.awt.Dimension(1160, 627));
        jpMenuPrincipal.setLayout(new java.awt.CardLayout());

        jpPrincipalMenu.setBackground(new java.awt.Color(31, 43, 91));
        jpPrincipalMenu.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jpPrincipalMenu.setMinimumSize(new java.awt.Dimension(1160, 627));
        jpPrincipalMenu.setPreferredSize(new java.awt.Dimension(1160, 627));

        jlSloganMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlSloganMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/LifeMed_menu.gif"))); // NOI18N
        jlSloganMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlSloganMenu.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jlSloganMenu.setMinimumSize(new java.awt.Dimension(1160, 627));
        jlSloganMenu.setPreferredSize(new java.awt.Dimension(1160, 627));

        javax.swing.GroupLayout jpPrincipalMenuLayout = new javax.swing.GroupLayout(jpPrincipalMenu);
        jpPrincipalMenu.setLayout(jpPrincipalMenuLayout);
        jpPrincipalMenuLayout.setHorizontalGroup(
            jpPrincipalMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalMenuLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jlSloganMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpPrincipalMenuLayout.setVerticalGroup(
            jpPrincipalMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlSloganMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
        );

        jpMenuPrincipal.add(jpPrincipalMenu, "card2");

        jpRegistrosMenu.setBackground(new java.awt.Color(177, 201, 234));
        jpRegistrosMenu.setMinimumSize(new java.awt.Dimension(1160, 627));

        jbFuncionariosRegistros.setBackground(new java.awt.Color(204, 204, 204));
        jbFuncionariosRegistros.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jbFuncionariosRegistros.setForeground(new java.awt.Color(255, 255, 255));
        jbFuncionariosRegistros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Funcionarios.png"))); // NOI18N
        jbFuncionariosRegistros.setText("Funcionários");
        jbFuncionariosRegistros.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 43, 91), 2, true));
        jbFuncionariosRegistros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbFuncionariosRegistros.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbFuncionariosRegistros.setIconTextGap(-60);
        jbFuncionariosRegistros.setMargin(new java.awt.Insets(2, 10, 2, 10));
        jbFuncionariosRegistros.setMaximumSize(new java.awt.Dimension(570, 617));
        jbFuncionariosRegistros.setMinimumSize(new java.awt.Dimension(570, 617));
        jbFuncionariosRegistros.setPreferredSize(new java.awt.Dimension(570, 617));
        jbFuncionariosRegistros.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbFuncionariosRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFuncionariosRegistrosActionPerformed(evt);
            }
        });

        jbPacientesRegistros.setBackground(new java.awt.Color(204, 204, 204));
        jbPacientesRegistros.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jbPacientesRegistros.setForeground(new java.awt.Color(255, 255, 255));
        jbPacientesRegistros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Pacientes.png"))); // NOI18N
        jbPacientesRegistros.setText("Pacientes");
        jbPacientesRegistros.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 43, 91), 2, true));
        jbPacientesRegistros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbPacientesRegistros.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbPacientesRegistros.setIconTextGap(-60);
        jbPacientesRegistros.setMargin(new java.awt.Insets(2, 10, 2, 10));
        jbPacientesRegistros.setMaximumSize(new java.awt.Dimension(570, 617));
        jbPacientesRegistros.setMinimumSize(new java.awt.Dimension(570, 617));
        jbPacientesRegistros.setPreferredSize(new java.awt.Dimension(570, 617));
        jbPacientesRegistros.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbPacientesRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPacientesRegistrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpRegistrosMenuLayout = new javax.swing.GroupLayout(jpRegistrosMenu);
        jpRegistrosMenu.setLayout(jpRegistrosMenuLayout);
        jpRegistrosMenuLayout.setHorizontalGroup(
            jpRegistrosMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRegistrosMenuLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jbPacientesRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jbFuncionariosRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jpRegistrosMenuLayout.setVerticalGroup(
            jpRegistrosMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpRegistrosMenuLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jpRegistrosMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbPacientesRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbFuncionariosRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        jpMenuPrincipal.add(jpRegistrosMenu, "card3");

        jpPacientesRegistros.setBackground(new java.awt.Color(177, 201, 234));
        jpPacientesRegistros.setMinimumSize(new java.awt.Dimension(1160, 627));
        jpPacientesRegistros.setPreferredSize(new java.awt.Dimension(1160, 627));
        jpPacientesRegistros.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jpPacientesRegistrosComponentShown(evt);
            }
        });
        jpPacientesRegistros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpDadosPessoaisPacientesRegistros.setBackground(new java.awt.Color(177, 201, 234));
        jpDadosPessoaisPacientesRegistros.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Dados Pessoais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jpDadosPessoaisPacientesRegistros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlIDPacientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlIDPacientes.setText("ID:");
        jpDadosPessoaisPacientesRegistros.add(jlIDPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 20));

        jlEstadoCivilPacientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlEstadoCivilPacientes.setText("Estado Civil:");
        jpDadosPessoaisPacientesRegistros.add(jlEstadoCivilPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 30, -1, 20));

        jlSexoPacientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlSexoPacientes.setText("Sexo:");
        jpDadosPessoaisPacientesRegistros.add(jlSexoPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, -1, 20));

        jlRGPacientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlRGPacientes.setText("Identidade (RG):");
        jpDadosPessoaisPacientesRegistros.add(jlRGPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, 20));

        jlNomePacientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlNomePacientes.setText("Nome Completo:");
        jpDadosPessoaisPacientesRegistros.add(jlNomePacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, 20));

        jlTelefoneRecadoPacientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlTelefoneRecadoPacientes.setText("Tel. Recado:");
        jpDadosPessoaisPacientesRegistros.add(jlTelefoneRecadoPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 90, -1, 20));

        jlClienteDesdePacientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlClienteDesdePacientes.setText("Cliente desde:");
        jpDadosPessoaisPacientesRegistros.add(jlClienteDesdePacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 210, -1, 20));

        jlEmailPacientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlEmailPacientes.setText("E-mail:");
        jpDadosPessoaisPacientesRegistros.add(jlEmailPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 50, 20));

        jlNumCasaPacientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlNumCasaPacientes.setText("Número:");
        jpDadosPessoaisPacientesRegistros.add(jlNumCasaPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 210, 60, 20));

        jlDataNascPacientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlDataNascPacientes.setText("Data de Nasc.:");
        jpDadosPessoaisPacientesRegistros.add(jlDataNascPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 30, -1, 20));

        jlOrgaoExpedidorPacientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlOrgaoExpedidorPacientes.setText("Orgão Exped.:");
        jpDadosPessoaisPacientesRegistros.add(jlOrgaoExpedidorPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, 20));

        jlNacionalidadePacientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlNacionalidadePacientes.setText("Nacionalidade:");
        jpDadosPessoaisPacientesRegistros.add(jlNacionalidadePacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, -1, 20));

        jlTipoPacientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlTipoPacientes.setText("Tipo:");
        jpDadosPessoaisPacientesRegistros.add(jlTipoPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, 20));

        jlLogradouroPacientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlLogradouroPacientes.setText("Logradouro:");
        jpDadosPessoaisPacientesRegistros.add(jlLogradouroPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, 20));

        jlCelularPacientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlCelularPacientes.setText("Tel. Celular:");
        jpDadosPessoaisPacientesRegistros.add(jlCelularPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 90, -1, 20));

        jlCEPPacientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlCEPPacientes.setText("CEP:");
        jpDadosPessoaisPacientesRegistros.add(jlCEPPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, -1, 20));

        jlCidadePacientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlCidadePacientes.setText("Cidade:");
        jpDadosPessoaisPacientesRegistros.add(jlCidadePacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 150, -1, 20));

        jlBairroPacientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlBairroPacientes.setText("Bairro:");
        jpDadosPessoaisPacientesRegistros.add(jlBairroPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 150, -1, 20));

        jlEstadoPacientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlEstadoPacientes.setText("UF:");
        jpDadosPessoaisPacientesRegistros.add(jlEstadoPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 20, 20));

        jlComplementoPacientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlComplementoPacientes.setText("Complemento:");
        jpDadosPessoaisPacientesRegistros.add(jlComplementoPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 210, 90, 20));

        jlCPFPacientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlCPFPacientes.setText("CPF:");
        jpDadosPessoaisPacientesRegistros.add(jlCPFPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 20));

        jlNaturalidadePacientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlNaturalidadePacientes.setText("Naturalidade:");
        jpDadosPessoaisPacientesRegistros.add(jlNaturalidadePacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, -1, 20));

        jlTelefoneFixoPacientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlTelefoneFixoPacientes.setText("Tel. Fixo:");
        jpDadosPessoaisPacientesRegistros.add(jlTelefoneFixoPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 90, -1, 20));

        jtfIDPacientes.setEditable(false);
        jtfIDPacientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfIDPacientes.setForeground(new java.awt.Color(255, 0, 51));
        jtfIDPacientes.setEnabled(false);
        jtfIDPacientes.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfIDPacientes.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisPacientesRegistros.add(jtfIDPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 70, -1));

        jtfNomePacientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfNomePacientes.setEnabled(false);
        jtfNomePacientes.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfNomePacientes.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisPacientesRegistros.add(jtfNomePacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 620, -1));

        jtfEmailPacientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfEmailPacientes.setEnabled(false);
        jtfEmailPacientes.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfEmailPacientes.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisPacientesRegistros.add(jtfEmailPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 450, -1));

        jtfLogradouroPacientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfLogradouroPacientes.setEnabled(false);
        jtfLogradouroPacientes.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfLogradouroPacientes.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisPacientesRegistros.add(jtfLogradouroPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 600, -1));

        jtfNumeroCasaPacientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfNumeroCasaPacientes.setEnabled(false);
        jtfNumeroCasaPacientes.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfNumeroCasaPacientes.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisPacientesRegistros.add(jtfNumeroCasaPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 230, 60, -1));

        jtfCidadePacientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfCidadePacientes.setEnabled(false);
        jtfCidadePacientes.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfCidadePacientes.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisPacientesRegistros.add(jtfCidadePacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, 240, -1));

        jtfUFPacientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfUFPacientes.setEnabled(false);
        jtfUFPacientes.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfUFPacientes.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisPacientesRegistros.add(jtfUFPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 40, -1));

        jtfComplementoPacientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfComplementoPacientes.setEnabled(false);
        jtfComplementoPacientes.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfComplementoPacientes.setNextFocusableComponent(jbSalvarPacientes);
        jtfComplementoPacientes.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisPacientesRegistros.add(jtfComplementoPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 230, 210, -1));

        jtfTipoLogradouroPacientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfTipoLogradouroPacientes.setEnabled(false);
        jtfTipoLogradouroPacientes.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfTipoLogradouroPacientes.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisPacientesRegistros.add(jtfTipoLogradouroPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 110, -1));

        jtfBairroPacientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfBairroPacientes.setEnabled(false);
        jtfBairroPacientes.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfBairroPacientes.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisPacientesRegistros.add(jtfBairroPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 170, 240, -1));

        try {
            jftTelefoneRecadoPacientes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftTelefoneRecadoPacientes.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jftTelefoneRecadoPacientes.setEnabled(false);
        jftTelefoneRecadoPacientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jftTelefoneRecadoPacientes.setMinimumSize(new java.awt.Dimension(3, 25));
        jftTelefoneRecadoPacientes.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisPacientesRegistros.add(jftTelefoneRecadoPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 110, 100, -1));

        try {
            jftRGPacientes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftRGPacientes.setEnabled(false);
        jftRGPacientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jftRGPacientes.setMinimumSize(new java.awt.Dimension(3, 25));
        jftRGPacientes.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisPacientesRegistros.add(jftRGPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 100, -1));

        jftCadastradoDesdePacientes.setEditable(false);
        jftCadastradoDesdePacientes.setForeground(new java.awt.Color(255, 0, 51));
        jftCadastradoDesdePacientes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jftCadastradoDesdePacientes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jftCadastradoDesdePacientes.setEnabled(false);
        jftCadastradoDesdePacientes.setFocusable(false);
        jftCadastradoDesdePacientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jftCadastradoDesdePacientes.setMinimumSize(new java.awt.Dimension(3, 25));
        jftCadastradoDesdePacientes.setNextFocusableComponent(jbSalvarPacientes);
        jftCadastradoDesdePacientes.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisPacientesRegistros.add(jftCadastradoDesdePacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 230, 90, -1));

        try {
            jftCepPacientes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftCepPacientes.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jftCepPacientes.setEnabled(false);
        jftCepPacientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jftCepPacientes.setMinimumSize(new java.awt.Dimension(3, 25));
        jftCepPacientes.setPreferredSize(new java.awt.Dimension(3, 25));
        jftCepPacientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jftCepPacientesKeyReleased(evt);
            }
        });
        jpDadosPessoaisPacientesRegistros.add(jftCepPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 100, -1));

        try {
            jftCelularPacientes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftCelularPacientes.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jftCelularPacientes.setEnabled(false);
        jftCelularPacientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jftCelularPacientes.setMinimumSize(new java.awt.Dimension(3, 25));
        jftCelularPacientes.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisPacientesRegistros.add(jftCelularPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 110, 100, -1));

        try {
            jftCPFPacientes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftCPFPacientes.setEnabled(false);
        jftCPFPacientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jftCPFPacientes.setMinimumSize(new java.awt.Dimension(3, 25));
        jftCPFPacientes.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisPacientesRegistros.add(jftCPFPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 100, -1));

        try {
            jftTelefoneFixoPacientes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftTelefoneFixoPacientes.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jftTelefoneFixoPacientes.setEnabled(false);
        jftTelefoneFixoPacientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jftTelefoneFixoPacientes.setMinimumSize(new java.awt.Dimension(3, 25));
        jftTelefoneFixoPacientes.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisPacientesRegistros.add(jftTelefoneFixoPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 110, 100, -1));

        jcbEstadoCivilPacientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbEstadoCivilPacientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Solteiro(a)", "Casado(a)", "Viúvo(a)", "Separado(a)", "Divorciado(a)" }));
        jcbEstadoCivilPacientes.setEnabled(false);
        jcbEstadoCivilPacientes.setMinimumSize(new java.awt.Dimension(3, 25));
        jcbEstadoCivilPacientes.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisPacientesRegistros.add(jcbEstadoCivilPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 50, 110, -1));

        jcbNacionalidadePacientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbNacionalidadePacientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Brasil - Brasileiro" }));
        jcbNacionalidadePacientes.setEnabled(false);
        jcbNacionalidadePacientes.setMinimumSize(new java.awt.Dimension(3, 25));
        jcbNacionalidadePacientes.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisPacientesRegistros.add(jcbNacionalidadePacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 220, -1));

        jcbNaturalidadePacientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbNaturalidadePacientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Acre (AC)", "Alagoas (AL)", "Amapá (AP)", "Amazonas (AM)", "Bahia (BA)", "Ceará (CE)", "Distrito Federal (DF)", "Espírito Santo (ES)", "Goiás (GO)", "Maranhão (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)", "Minas Gerais (MG)", "Pará (PA)", "Paraíba (PB)", "Paraná (PR)", "Pernambuco (PE)", "Piauí (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)", "Rio Grande do Sul (RS)", "Rondônia (RO)", "Roraima (RR)", "Santa Catarina (SC)", "São Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)" }));
        jcbNaturalidadePacientes.setEnabled(false);
        jcbNaturalidadePacientes.setMinimumSize(new java.awt.Dimension(3, 25));
        jcbNaturalidadePacientes.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisPacientesRegistros.add(jcbNaturalidadePacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 220, -1));

        jdcDataNascPacientes.setBackground(new java.awt.Color(177, 201, 234));
        jdcDataNascPacientes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jdcDataNascPacientes.setEnabled(false);
        jdcDataNascPacientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jdcDataNascPacientes.setMinimumSize(new java.awt.Dimension(100, 25));
        jdcDataNascPacientes.setPreferredSize(new java.awt.Dimension(100, 25));
        jpDadosPessoaisPacientesRegistros.add(jdcDataNascPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 50, 160, 25));

        jcbSexoPacientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbSexoPacientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Masculino", "Feminino" }));
        jcbSexoPacientes.setEnabled(false);
        jcbSexoPacientes.setMinimumSize(new java.awt.Dimension(3, 25));
        jcbSexoPacientes.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisPacientesRegistros.add(jcbSexoPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 50, 110, -1));

        jtfOrgaoExpedidorPacientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfOrgaoExpedidorPacientes.setEnabled(false);
        jtfOrgaoExpedidorPacientes.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfOrgaoExpedidorPacientes.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisPacientesRegistros.add(jtfOrgaoExpedidorPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 90, -1));

        jpPacientesRegistros.add(jpDadosPessoaisPacientesRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 35, 1140, 270));

        jpListaPacientesRegistros.setBackground(new java.awt.Color(177, 201, 234));
        jpListaPacientesRegistros.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Lista de Pacientes Cadastrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jpListaPacientesRegistros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtListaPacientes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtListaPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID:", "Nome:", "Sexo:", "Data de Nasc.:", "Estado Civil:", "CPF:", "RG:", "Orgão Exped.:", "Nacionalidade:", "Naturalidade:", "Tel. Fixo:", "Tel. Celular:", "Tel. Recado:", "E-mail:", "CEP:", "UF:", "Cidade:", "Bairro:", "Logradouro:", "Número:", "Complemento:", "Cliente desde:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtListaPacientes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtListaPacientes.setGridColor(new java.awt.Color(31, 43, 91));
        jtListaPacientes.setRowHeight(20);
        jtListaPacientes.setSelectionBackground(new java.awt.Color(42, 152, 223));
        jtListaPacientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jtListaPacientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtListaPacientes.setShowGrid(true);
        jScrollPane1.setViewportView(jtListaPacientes);
        if (jtListaPacientes.getColumnModel().getColumnCount() > 0) {
            jtListaPacientes.getColumnModel().getColumn(0).setMinWidth(85);
            jtListaPacientes.getColumnModel().getColumn(0).setPreferredWidth(85);
            jtListaPacientes.getColumnModel().getColumn(1).setMinWidth(300);
            jtListaPacientes.getColumnModel().getColumn(1).setPreferredWidth(300);
            jtListaPacientes.getColumnModel().getColumn(2).setMinWidth(100);
            jtListaPacientes.getColumnModel().getColumn(2).setPreferredWidth(100);
            jtListaPacientes.getColumnModel().getColumn(3).setMinWidth(200);
            jtListaPacientes.getColumnModel().getColumn(3).setPreferredWidth(200);
            jtListaPacientes.getColumnModel().getColumn(4).setMinWidth(200);
            jtListaPacientes.getColumnModel().getColumn(4).setPreferredWidth(200);
            jtListaPacientes.getColumnModel().getColumn(5).setMinWidth(200);
            jtListaPacientes.getColumnModel().getColumn(5).setPreferredWidth(200);
            jtListaPacientes.getColumnModel().getColumn(6).setMinWidth(200);
            jtListaPacientes.getColumnModel().getColumn(6).setPreferredWidth(200);
            jtListaPacientes.getColumnModel().getColumn(7).setMinWidth(100);
            jtListaPacientes.getColumnModel().getColumn(7).setPreferredWidth(100);
            jtListaPacientes.getColumnModel().getColumn(8).setMinWidth(200);
            jtListaPacientes.getColumnModel().getColumn(8).setPreferredWidth(200);
            jtListaPacientes.getColumnModel().getColumn(9).setMinWidth(200);
            jtListaPacientes.getColumnModel().getColumn(9).setPreferredWidth(200);
            jtListaPacientes.getColumnModel().getColumn(10).setMinWidth(150);
            jtListaPacientes.getColumnModel().getColumn(10).setPreferredWidth(150);
            jtListaPacientes.getColumnModel().getColumn(11).setMinWidth(150);
            jtListaPacientes.getColumnModel().getColumn(11).setPreferredWidth(150);
            jtListaPacientes.getColumnModel().getColumn(12).setMinWidth(150);
            jtListaPacientes.getColumnModel().getColumn(12).setPreferredWidth(150);
            jtListaPacientes.getColumnModel().getColumn(13).setMinWidth(200);
            jtListaPacientes.getColumnModel().getColumn(13).setPreferredWidth(200);
            jtListaPacientes.getColumnModel().getColumn(14).setMinWidth(100);
            jtListaPacientes.getColumnModel().getColumn(14).setPreferredWidth(100);
            jtListaPacientes.getColumnModel().getColumn(15).setMinWidth(80);
            jtListaPacientes.getColumnModel().getColumn(15).setPreferredWidth(80);
            jtListaPacientes.getColumnModel().getColumn(16).setMinWidth(200);
            jtListaPacientes.getColumnModel().getColumn(16).setPreferredWidth(200);
            jtListaPacientes.getColumnModel().getColumn(17).setMinWidth(200);
            jtListaPacientes.getColumnModel().getColumn(17).setPreferredWidth(200);
            jtListaPacientes.getColumnModel().getColumn(18).setMinWidth(300);
            jtListaPacientes.getColumnModel().getColumn(18).setPreferredWidth(300);
            jtListaPacientes.getColumnModel().getColumn(19).setMinWidth(100);
            jtListaPacientes.getColumnModel().getColumn(19).setPreferredWidth(100);
            jtListaPacientes.getColumnModel().getColumn(20).setMinWidth(200);
            jtListaPacientes.getColumnModel().getColumn(20).setPreferredWidth(200);
            jtListaPacientes.getColumnModel().getColumn(21).setMinWidth(100);
            jtListaPacientes.getColumnModel().getColumn(21).setPreferredWidth(100);
        }

        jpListaPacientesRegistros.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1000, 250));

        jlPesquisarPacientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlPesquisarPacientes.setText("Pesquisar:");
        jpListaPacientesRegistros.add(jlPesquisarPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 35, -1, 20));

        jlFiltrarPacientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlFiltrarPacientes.setText("Filtrar:");
        jpListaPacientesRegistros.add(jlFiltrarPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 35, -1, 20));

        jtfPesquisarPacientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfPesquisarPacientes.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfPesquisarPacientes.setPreferredSize(new java.awt.Dimension(3, 25));
        jpListaPacientesRegistros.add(jtfPesquisarPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 35, 509, -1));

        jcbFiltrarPacientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbFiltrarPacientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "NOME", "CPF", "RG" }));
        jcbFiltrarPacientes.setMinimumSize(new java.awt.Dimension(3, 25));
        jcbFiltrarPacientes.setPreferredSize(new java.awt.Dimension(3, 25));
        jpListaPacientesRegistros.add(jcbFiltrarPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 35, 90, -1));

        jbProcurarPacientes.setBackground(new java.awt.Color(255, 255, 255));
        jbProcurarPacientes.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbProcurarPacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/pesquisar-36.png"))); // NOI18N
        jbProcurarPacientes.setText("Procurar");
        jbProcurarPacientes.setToolTipText("Clique para procurar paciente");
        jbProcurarPacientes.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jbProcurarPacientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbProcurarPacientes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbProcurarPacientes.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbProcurarPacientes.setIconTextGap(8);
        jbProcurarPacientes.setMaximumSize(new java.awt.Dimension(106, 40));
        jbProcurarPacientes.setMinimumSize(new java.awt.Dimension(106, 40));
        jbProcurarPacientes.setPreferredSize(new java.awt.Dimension(106, 40));
        jbProcurarPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProcurarPacientesActionPerformed(evt);
            }
        });
        jpListaPacientesRegistros.add(jbProcurarPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 25, 120, 45));

        jpPacientesRegistros.add(jpListaPacientesRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 1019, 340));

        jlNomeTelaPacientes.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jlNomeTelaPacientes.setForeground(new java.awt.Color(31, 43, 91));
        jlNomeTelaPacientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlNomeTelaPacientes.setText("Cadastro de Pacientes");
        jlNomeTelaPacientes.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(42, 152, 223), null));
        jpPacientesRegistros.add(jlNomeTelaPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 4, 1140, -1));

        jbNovoPacientes.setBackground(new java.awt.Color(255, 255, 255));
        jbNovoPacientes.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbNovoPacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/adicionar-36.png"))); // NOI18N
        jbNovoPacientes.setText("Novo");
        jbNovoPacientes.setToolTipText("Clique para inciar um novo cadastro");
        jbNovoPacientes.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jbNovoPacientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbNovoPacientes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbNovoPacientes.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbNovoPacientes.setIconTextGap(8);
        jbNovoPacientes.setMaximumSize(new java.awt.Dimension(106, 45));
        jbNovoPacientes.setMinimumSize(new java.awt.Dimension(106, 45));
        jbNovoPacientes.setPreferredSize(new java.awt.Dimension(106, 45));
        jbNovoPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoPacientesActionPerformed(evt);
            }
        });
        jpPacientesRegistros.add(jbNovoPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(1041, 335, -1, -1));

        jbEditarPacientes.setBackground(new java.awt.Color(255, 255, 255));
        jbEditarPacientes.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbEditarPacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/editar-36.png"))); // NOI18N
        jbEditarPacientes.setText("Editar");
        jbEditarPacientes.setToolTipText("Clique para editar o cadastro selecionado");
        jbEditarPacientes.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jbEditarPacientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbEditarPacientes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbEditarPacientes.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbEditarPacientes.setIconTextGap(8);
        jbEditarPacientes.setMaximumSize(new java.awt.Dimension(106, 45));
        jbEditarPacientes.setMinimumSize(new java.awt.Dimension(106, 45));
        jbEditarPacientes.setPreferredSize(new java.awt.Dimension(106, 45));
        jbEditarPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarPacientesActionPerformed(evt);
            }
        });
        jpPacientesRegistros.add(jbEditarPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(1041, 400, -1, -1));

        jbSalvarPacientes.setBackground(new java.awt.Color(255, 255, 255));
        jbSalvarPacientes.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbSalvarPacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/salvar-36.png"))); // NOI18N
        jbSalvarPacientes.setText("Salvar");
        jbSalvarPacientes.setToolTipText("Clique para salvar");
        jbSalvarPacientes.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jbSalvarPacientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbSalvarPacientes.setEnabled(false);
        jbSalvarPacientes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbSalvarPacientes.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbSalvarPacientes.setIconTextGap(8);
        jbSalvarPacientes.setMaximumSize(new java.awt.Dimension(106, 45));
        jbSalvarPacientes.setMinimumSize(new java.awt.Dimension(106, 45));
        jbSalvarPacientes.setPreferredSize(new java.awt.Dimension(106, 45));
        jbSalvarPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarPacientesActionPerformed(evt);
            }
        });
        jpPacientesRegistros.add(jbSalvarPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(1041, 465, -1, -1));

        jbExlcuirPacientes.setBackground(new java.awt.Color(255, 255, 255));
        jbExlcuirPacientes.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jbExlcuirPacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/excluir-36.png"))); // NOI18N
        jbExlcuirPacientes.setText("Excluir");
        jbExlcuirPacientes.setToolTipText("Clique para excluir o cadastro selecionado");
        jbExlcuirPacientes.setAutoscrolls(true);
        jbExlcuirPacientes.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jbExlcuirPacientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbExlcuirPacientes.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jbExlcuirPacientes.setIconTextGap(8);
        jbExlcuirPacientes.setMaximumSize(new java.awt.Dimension(106, 45));
        jbExlcuirPacientes.setMinimumSize(new java.awt.Dimension(106, 45));
        jbExlcuirPacientes.setPreferredSize(new java.awt.Dimension(106, 45));
        jbExlcuirPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExlcuirPacientesActionPerformed(evt);
            }
        });
        jpPacientesRegistros.add(jbExlcuirPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(1041, 530, -1, -1));

        jbLimparTelaPacientes.setBackground(new java.awt.Color(255, 255, 255));
        jbLimparTelaPacientes.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbLimparTelaPacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/limpar-36.png"))); // NOI18N
        jbLimparTelaPacientes.setText("Limpar");
        jbLimparTelaPacientes.setToolTipText("Clique para limpar todos os campos");
        jbLimparTelaPacientes.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jbLimparTelaPacientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbLimparTelaPacientes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbLimparTelaPacientes.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbLimparTelaPacientes.setIconTextGap(8);
        jbLimparTelaPacientes.setMaximumSize(new java.awt.Dimension(106, 45));
        jbLimparTelaPacientes.setMinimumSize(new java.awt.Dimension(106, 45));
        jbLimparTelaPacientes.setPreferredSize(new java.awt.Dimension(106, 45));
        jbLimparTelaPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparTelaPacientesActionPerformed(evt);
            }
        });
        jpPacientesRegistros.add(jbLimparTelaPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(1041, 595, -1, -1));

        jpMenuPrincipal.add(jpPacientesRegistros, "card4");

        jpFuncionariosRegistros.setBackground(new java.awt.Color(177, 201, 234));
        jpFuncionariosRegistros.setMinimumSize(new java.awt.Dimension(1160, 627));
        jpFuncionariosRegistros.setPreferredSize(new java.awt.Dimension(1160, 627));
        jpFuncionariosRegistros.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jpFuncionariosRegistrosComponentShown(evt);
            }
        });
        jpFuncionariosRegistros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpDadosPessoaisFuncionarios.setBackground(new java.awt.Color(177, 201, 234));
        jpDadosPessoaisFuncionarios.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Dados Pessoais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jpDadosPessoaisFuncionarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlSexoFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlSexoFuncionarios.setText("Sexo:");
        jpDadosPessoaisFuncionarios.add(jlSexoFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, -1, 20));

        jlRGFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlRGFuncionarios.setText("Identidade (RG):");
        jpDadosPessoaisFuncionarios.add(jlRGFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, 20));

        jlNomeFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlNomeFuncionarios.setText("Nome Completo:");
        jpDadosPessoaisFuncionarios.add(jlNomeFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, 20));

        jlIDFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlIDFuncionarios.setText("ID:");
        jpDadosPessoaisFuncionarios.add(jlIDFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 20));

        jlEstadoCivilFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlEstadoCivilFuncionarios.setText("Estado Civil:");
        jpDadosPessoaisFuncionarios.add(jlEstadoCivilFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 20, -1, 20));

        jlTelefoneRecadoFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlTelefoneRecadoFuncionarios.setText("Tel. Recado:");
        jpDadosPessoaisFuncionarios.add(jlTelefoneRecadoFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 70, -1, 20));

        jlEmailFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlEmailFuncionarios.setText("E-mail:");
        jpDadosPessoaisFuncionarios.add(jlEmailFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 50, 20));

        jlNumCasaFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlNumCasaFuncionarios.setText("Número:");
        jpDadosPessoaisFuncionarios.add(jlNumCasaFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 170, 60, 20));

        jlDataNascFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlDataNascFuncionarios.setText("Data de Nasc.:");
        jpDadosPessoaisFuncionarios.add(jlDataNascFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, -1, 20));

        jlCelularFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlCelularFuncionarios.setText("Tel. Celular:");
        jpDadosPessoaisFuncionarios.add(jlCelularFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 70, -1, 20));

        jlCEPFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlCEPFuncionarios.setText("CEP:");
        jpDadosPessoaisFuncionarios.add(jlCEPFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, -1, 20));

        jlCidadeFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlCidadeFuncionarios.setText("Cidade:");
        jpDadosPessoaisFuncionarios.add(jlCidadeFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, -1, 20));

        jlBairroFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlBairroFuncionarios.setText("Bairro:");
        jpDadosPessoaisFuncionarios.add(jlBairroFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 120, -1, 20));

        jlEstadoFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlEstadoFuncionarios.setText("UF:");
        jpDadosPessoaisFuncionarios.add(jlEstadoFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 20, 20));

        jlComplementoFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlComplementoFuncionarios.setText("Complemento:");
        jpDadosPessoaisFuncionarios.add(jlComplementoFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 170, 90, 20));

        jlCPFFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlCPFFuncionarios.setText("CPF:");
        jpDadosPessoaisFuncionarios.add(jlCPFFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 20));

        jlNaturalidadeFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlNaturalidadeFuncionarios.setText("Naturalidade:");
        jpDadosPessoaisFuncionarios.add(jlNaturalidadeFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, -1, 20));

        jlTelefoneFixoFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlTelefoneFixoFuncionarios.setText("Tel. Fixo:");
        jpDadosPessoaisFuncionarios.add(jlTelefoneFixoFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, -1, 20));

        jlOrgaoExpedFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlOrgaoExpedFuncionarios.setText("Orgão Exped.:");
        jpDadosPessoaisFuncionarios.add(jlOrgaoExpedFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, 20));

        jlNacionalidadeFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlNacionalidadeFuncionarios.setText("Nacionalidade:");
        jpDadosPessoaisFuncionarios.add(jlNacionalidadeFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, -1, 20));

        jlTipoLogradouroFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlTipoLogradouroFuncionarios.setText("Tipo:");
        jpDadosPessoaisFuncionarios.add(jlTipoLogradouroFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 20));

        jlLogradouroFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlLogradouroFuncionarios.setText("Logradouro:");
        jpDadosPessoaisFuncionarios.add(jlLogradouroFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, 20));

        jtfIDFuncionarios.setEditable(false);
        jtfIDFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfIDFuncionarios.setForeground(new java.awt.Color(255, 0, 51));
        jtfIDFuncionarios.setEnabled(false);
        jtfIDFuncionarios.setFocusable(false);
        jtfIDFuncionarios.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfIDFuncionarios.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisFuncionarios.add(jtfIDFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 70, -1));

        jtfEmailFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfEmailFuncionarios.setEnabled(false);
        jtfEmailFuncionarios.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfEmailFuncionarios.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisFuncionarios.add(jtfEmailFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 450, -1));

        jtfNomeFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfNomeFuncionarios.setEnabled(false);
        jtfNomeFuncionarios.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfNomeFuncionarios.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisFuncionarios.add(jtfNomeFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 620, -1));

        jtfTipoLogradouroFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfTipoLogradouroFuncionarios.setEnabled(false);
        jtfTipoLogradouroFuncionarios.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfTipoLogradouroFuncionarios.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisFuncionarios.add(jtfTipoLogradouroFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 110, -1));

        jtfLogradouroFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfLogradouroFuncionarios.setEnabled(false);
        jtfLogradouroFuncionarios.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfLogradouroFuncionarios.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisFuncionarios.add(jtfLogradouroFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 600, -1));

        jtfNumeroCasaFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfNumeroCasaFuncionarios.setEnabled(false);
        jtfNumeroCasaFuncionarios.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfNumeroCasaFuncionarios.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisFuncionarios.add(jtfNumeroCasaFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 190, 60, -1));

        jtfCidadeFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfCidadeFuncionarios.setEnabled(false);
        jtfCidadeFuncionarios.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfCidadeFuncionarios.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisFuncionarios.add(jtfCidadeFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 240, -1));

        jtfUFFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfUFFuncionarios.setEnabled(false);
        jtfUFFuncionarios.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfUFFuncionarios.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisFuncionarios.add(jtfUFFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, 40, -1));

        jtfOrgaoExpedFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfOrgaoExpedFuncionarios.setEnabled(false);
        jtfOrgaoExpedFuncionarios.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfOrgaoExpedFuncionarios.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisFuncionarios.add(jtfOrgaoExpedFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 90, -1));

        jtfBairroFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfBairroFuncionarios.setEnabled(false);
        jtfBairroFuncionarios.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfBairroFuncionarios.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisFuncionarios.add(jtfBairroFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 140, 240, -1));

        jtfComplementoFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfComplementoFuncionarios.setEnabled(false);
        jtfComplementoFuncionarios.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfComplementoFuncionarios.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisFuncionarios.add(jtfComplementoFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 190, 310, -1));

        try {
            jftTelefoneRecadoFuncionarios.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftTelefoneRecadoFuncionarios.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jftTelefoneRecadoFuncionarios.setEnabled(false);
        jftTelefoneRecadoFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jftTelefoneRecadoFuncionarios.setMinimumSize(new java.awt.Dimension(3, 25));
        jftTelefoneRecadoFuncionarios.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisFuncionarios.add(jftTelefoneRecadoFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 90, 100, -1));

        try {
            jftRGFuncionarios.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftRGFuncionarios.setEnabled(false);
        jftRGFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jftRGFuncionarios.setMinimumSize(new java.awt.Dimension(3, 25));
        jftRGFuncionarios.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisFuncionarios.add(jftRGFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 100, -1));

        try {
            jftCepFuncionarios.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftCepFuncionarios.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jftCepFuncionarios.setEnabled(false);
        jftCepFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jftCepFuncionarios.setMinimumSize(new java.awt.Dimension(3, 25));
        jftCepFuncionarios.setPreferredSize(new java.awt.Dimension(3, 25));
        jftCepFuncionarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jftCepFuncionariosKeyReleased(evt);
            }
        });
        jpDadosPessoaisFuncionarios.add(jftCepFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 100, -1));

        try {
            jftCelularFuncionarios.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftCelularFuncionarios.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jftCelularFuncionarios.setEnabled(false);
        jftCelularFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jftCelularFuncionarios.setMinimumSize(new java.awt.Dimension(3, 25));
        jftCelularFuncionarios.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisFuncionarios.add(jftCelularFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 90, 100, -1));

        try {
            jftCPFFuncionarios.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftCPFFuncionarios.setEnabled(false);
        jftCPFFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jftCPFFuncionarios.setMinimumSize(new java.awt.Dimension(3, 25));
        jftCPFFuncionarios.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisFuncionarios.add(jftCPFFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 100, -1));

        try {
            jftTelefoneFixoFuncionarios.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftTelefoneFixoFuncionarios.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jftTelefoneFixoFuncionarios.setEnabled(false);
        jftTelefoneFixoFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jftTelefoneFixoFuncionarios.setMinimumSize(new java.awt.Dimension(3, 25));
        jftTelefoneFixoFuncionarios.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisFuncionarios.add(jftTelefoneFixoFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 90, 100, -1));

        jcbEstadoCivilFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbEstadoCivilFuncionarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Solteiro(a)", "Casado(a)", "Viúvo(a)", "Separado(a)", "Divorciado(a)" }));
        jcbEstadoCivilFuncionarios.setEnabled(false);
        jcbEstadoCivilFuncionarios.setMinimumSize(new java.awt.Dimension(3, 25));
        jcbEstadoCivilFuncionarios.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisFuncionarios.add(jcbEstadoCivilFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 40, 110, -1));

        jcbNacionalidadeFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbNacionalidadeFuncionarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Brasil - Brasileiro" }));
        jcbNacionalidadeFuncionarios.setEnabled(false);
        jcbNacionalidadeFuncionarios.setMinimumSize(new java.awt.Dimension(3, 25));
        jcbNacionalidadeFuncionarios.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisFuncionarios.add(jcbNacionalidadeFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 220, -1));

        jcbSexoFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbSexoFuncionarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Masculino", "Feminino" }));
        jcbSexoFuncionarios.setEnabled(false);
        jcbSexoFuncionarios.setMinimumSize(new java.awt.Dimension(3, 25));
        jcbSexoFuncionarios.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisFuncionarios.add(jcbSexoFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, 110, -1));

        jcbNaturalidadeFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbNaturalidadeFuncionarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Acre (AC)", "Alagoas (AL)", "Amapá (AP)", "Amazonas (AM)", "Bahia (BA)", "Ceará (CE)", "Distrito Federal (DF)", "Espírito Santo (ES)", "Goiás (GO)", "Maranhão (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)", "Minas Gerais (MG)", "Pará (PA)", "Paraíba (PB)", "Paraná (PR)", "Pernambuco (PE)", "Piauí (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)", "Rio Grande do Sul (RS)", "Rondônia (RO)", "Roraima (RR)", "Santa Catarina (SC)", "São Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)" }));
        jcbNaturalidadeFuncionarios.setEnabled(false);
        jcbNaturalidadeFuncionarios.setMinimumSize(new java.awt.Dimension(3, 25));
        jcbNaturalidadeFuncionarios.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPessoaisFuncionarios.add(jcbNaturalidadeFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 220, -1));

        jdcDataNascFuncionarios.setBackground(new java.awt.Color(177, 201, 234));
        jdcDataNascFuncionarios.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jdcDataNascFuncionarios.setEnabled(false);
        jdcDataNascFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jdcDataNascFuncionarios.setMinimumSize(new java.awt.Dimension(100, 25));
        jdcDataNascFuncionarios.setPreferredSize(new java.awt.Dimension(100, 25));
        jpDadosPessoaisFuncionarios.add(jdcDataNascFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 40, 160, 25));

        jpFuncionariosRegistros.add(jpDadosPessoaisFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 1140, 230));

        jpDadosFuncionarios.setBackground(new java.awt.Color(177, 201, 234));
        jpDadosFuncionarios.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Dados do Funcionário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jpDadosFuncionarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlCTPSFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlCTPSFuncionarios.setText("CTPS:");
        jpDadosFuncionarios.add(jlCTPSFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 24, 37, 20));

        jlFuncaoFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlFuncaoFuncionarios.setText("Função:");
        jpDadosFuncionarios.add(jlFuncaoFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 24, 60, 20));

        jlFuncionarioDesdeFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlFuncionarioDesdeFuncionarios.setText("Funcionário desde:");
        jpDadosFuncionarios.add(jlFuncionarioDesdeFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 24, 120, 20));

        jlDataAdmFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlDataAdmFuncionarios.setText("Data de Adm.:");
        jpDadosFuncionarios.add(jlDataAdmFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 24, 84, 20));

        jlSetorFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlSetorFuncionarios.setText("Setor:");
        jpDadosFuncionarios.add(jlSetorFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 24, 40, 20));

        jlMatriculaFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlMatriculaFuncionarios.setText("Matricula:");
        jpDadosFuncionarios.add(jlMatriculaFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 24, 70, 20));

        jlDataDemFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlDataDemFuncionarios.setText("Data de Dem.:");
        jpDadosFuncionarios.add(jlDataDemFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 24, 84, 20));

        jlPISFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlPISFuncionarios.setText("PIS:");
        jpDadosFuncionarios.add(jlPISFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 24, 37, 20));

        jlSerieUFFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlSerieUFFuncionarios.setText("Série / UF:");
        jpDadosFuncionarios.add(jlSerieUFFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 24, -1, 20));

        jtfMatriculaFuncionarios.setEditable(false);
        jtfMatriculaFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfMatriculaFuncionarios.setEnabled(false);
        jtfMatriculaFuncionarios.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfMatriculaFuncionarios.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosFuncionarios.add(jtfMatriculaFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 44, 140, -1));

        jtfPISFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfPISFuncionarios.setEnabled(false);
        jtfPISFuncionarios.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfPISFuncionarios.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosFuncionarios.add(jtfPISFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 44, 90, -1));

        jtfCTPSFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfCTPSFuncionarios.setEnabled(false);
        jtfCTPSFuncionarios.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfCTPSFuncionarios.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosFuncionarios.add(jtfCTPSFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 44, 90, -1));

        jtfSerieUFFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfSerieUFFuncionarios.setEnabled(false);
        jtfSerieUFFuncionarios.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfSerieUFFuncionarios.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosFuncionarios.add(jtfSerieUFFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 44, 90, -1));

        jftFuncionarioDesdeFuncionarios.setEditable(false);
        jftFuncionarioDesdeFuncionarios.setForeground(new java.awt.Color(255, 0, 51));
        jftFuncionarioDesdeFuncionarios.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jftFuncionarioDesdeFuncionarios.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jftFuncionarioDesdeFuncionarios.setEnabled(false);
        jftFuncionarioDesdeFuncionarios.setFocusable(false);
        jftFuncionarioDesdeFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jftFuncionarioDesdeFuncionarios.setMinimumSize(new java.awt.Dimension(3, 25));
        jftFuncionarioDesdeFuncionarios.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosFuncionarios.add(jftFuncionarioDesdeFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 44, 120, -1));

        jcbSetorFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbSetorFuncionarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Administrativo", "Enfermagem", "Laboratorial", "Médico" }));
        jcbSetorFuncionarios.setEnabled(false);
        jcbSetorFuncionarios.setMinimumSize(new java.awt.Dimension(3, 25));
        jcbSetorFuncionarios.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosFuncionarios.add(jcbSetorFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 44, 120, -1));

        jcbFuncaoFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbFuncaoFuncionarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Atendente", "Enfermeiro(a)", "Médico(a)", "Técnico(a) de Laboratório" }));
        jcbFuncaoFuncionarios.setEnabled(false);
        jcbFuncaoFuncionarios.setMinimumSize(new java.awt.Dimension(3, 25));
        jcbFuncaoFuncionarios.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosFuncionarios.add(jcbFuncaoFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 44, 133, -1));

        jdcDataAdmFuncionarios.setBackground(new java.awt.Color(177, 201, 234));
        jdcDataAdmFuncionarios.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jdcDataAdmFuncionarios.setDateFormatString("dd '/' MM '/' yy");
        jdcDataAdmFuncionarios.setEnabled(false);
        jdcDataAdmFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jdcDataAdmFuncionarios.setMinimumSize(new java.awt.Dimension(100, 25));
        jdcDataAdmFuncionarios.setPreferredSize(new java.awt.Dimension(100, 25));
        jpDadosFuncionarios.add(jdcDataAdmFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 44, 120, -1));

        jdcDataDemFuncionarios.setBackground(new java.awt.Color(177, 201, 234));
        jdcDataDemFuncionarios.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jdcDataDemFuncionarios.setToolTipText("");
        jdcDataDemFuncionarios.setDateFormatString("dd '/' MM '/' yy");
        jdcDataDemFuncionarios.setEnabled(false);
        jdcDataDemFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jdcDataDemFuncionarios.setMinimumSize(new java.awt.Dimension(100, 25));
        jdcDataDemFuncionarios.setPreferredSize(new java.awt.Dimension(100, 25));
        jpDadosFuncionarios.add(jdcDataDemFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 44, 120, -1));

        jpFuncionariosRegistros.add(jpDadosFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 1140, 80));

        jpListaFuncionarios.setBackground(new java.awt.Color(177, 201, 234));
        jpListaFuncionarios.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Lista de Funcionários Cadastrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jpListaFuncionarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtListaFuncionarios.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtListaFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID:", "Nome:", "Sexo:", "Data de Nasc.:", "Estado Civil:", "CPF:", "RG:", "Orgão Exped.:", "Nacionalidade:", "Naturalidade:", "Tel. Fixo:", "Tel. Celular:", "Tel. Recado:", "E-mail:", "CEP:", "UF:", "Cidade:", "Bairro:", "Logradouro:", "Número:", "Complemento:", "Setor:", "Função:", "Matrícula:", "Data de Adm.:", "Data de Dem.:", "CTPS:", "Série/UF:", "PIS:", "Funcionário desde:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtListaFuncionarios.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtListaFuncionarios.setGridColor(new java.awt.Color(31, 43, 91));
        jtListaFuncionarios.setRowHeight(20);
        jtListaFuncionarios.setSelectionBackground(new java.awt.Color(42, 152, 223));
        jtListaFuncionarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jtListaFuncionarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtListaFuncionarios.setShowGrid(true);
        jScrollPane2.setViewportView(jtListaFuncionarios);
        if (jtListaFuncionarios.getColumnModel().getColumnCount() > 0) {
            jtListaFuncionarios.getColumnModel().getColumn(0).setMinWidth(85);
            jtListaFuncionarios.getColumnModel().getColumn(0).setPreferredWidth(85);
            jtListaFuncionarios.getColumnModel().getColumn(1).setMinWidth(100);
            jtListaFuncionarios.getColumnModel().getColumn(1).setPreferredWidth(100);
            jtListaFuncionarios.getColumnModel().getColumn(2).setMinWidth(100);
            jtListaFuncionarios.getColumnModel().getColumn(2).setPreferredWidth(100);
            jtListaFuncionarios.getColumnModel().getColumn(3).setMinWidth(250);
            jtListaFuncionarios.getColumnModel().getColumn(3).setPreferredWidth(250);
            jtListaFuncionarios.getColumnModel().getColumn(4).setMinWidth(150);
            jtListaFuncionarios.getColumnModel().getColumn(4).setPreferredWidth(150);
            jtListaFuncionarios.getColumnModel().getColumn(5).setMinWidth(150);
            jtListaFuncionarios.getColumnModel().getColumn(5).setPreferredWidth(150);
            jtListaFuncionarios.getColumnModel().getColumn(6).setMinWidth(150);
            jtListaFuncionarios.getColumnModel().getColumn(6).setPreferredWidth(150);
            jtListaFuncionarios.getColumnModel().getColumn(7).setMinWidth(100);
            jtListaFuncionarios.getColumnModel().getColumn(7).setPreferredWidth(100);
            jtListaFuncionarios.getColumnModel().getColumn(8).setMinWidth(250);
            jtListaFuncionarios.getColumnModel().getColumn(8).setPreferredWidth(250);
            jtListaFuncionarios.getColumnModel().getColumn(9).setMinWidth(150);
            jtListaFuncionarios.getColumnModel().getColumn(9).setPreferredWidth(150);
            jtListaFuncionarios.getColumnModel().getColumn(10).setMinWidth(150);
            jtListaFuncionarios.getColumnModel().getColumn(10).setPreferredWidth(150);
            jtListaFuncionarios.getColumnModel().getColumn(11).setMinWidth(150);
            jtListaFuncionarios.getColumnModel().getColumn(11).setPreferredWidth(150);
            jtListaFuncionarios.getColumnModel().getColumn(12).setMinWidth(150);
            jtListaFuncionarios.getColumnModel().getColumn(12).setPreferredWidth(150);
            jtListaFuncionarios.getColumnModel().getColumn(13).setMinWidth(150);
            jtListaFuncionarios.getColumnModel().getColumn(13).setPreferredWidth(150);
            jtListaFuncionarios.getColumnModel().getColumn(14).setMinWidth(100);
            jtListaFuncionarios.getColumnModel().getColumn(14).setPreferredWidth(100);
            jtListaFuncionarios.getColumnModel().getColumn(15).setMinWidth(80);
            jtListaFuncionarios.getColumnModel().getColumn(15).setPreferredWidth(80);
            jtListaFuncionarios.getColumnModel().getColumn(16).setMinWidth(200);
            jtListaFuncionarios.getColumnModel().getColumn(16).setPreferredWidth(200);
            jtListaFuncionarios.getColumnModel().getColumn(17).setMinWidth(200);
            jtListaFuncionarios.getColumnModel().getColumn(17).setPreferredWidth(200);
            jtListaFuncionarios.getColumnModel().getColumn(18).setMinWidth(300);
            jtListaFuncionarios.getColumnModel().getColumn(18).setPreferredWidth(300);
            jtListaFuncionarios.getColumnModel().getColumn(19).setMinWidth(100);
            jtListaFuncionarios.getColumnModel().getColumn(19).setPreferredWidth(100);
            jtListaFuncionarios.getColumnModel().getColumn(20).setMinWidth(200);
            jtListaFuncionarios.getColumnModel().getColumn(20).setPreferredWidth(200);
            jtListaFuncionarios.getColumnModel().getColumn(21).setMinWidth(100);
            jtListaFuncionarios.getColumnModel().getColumn(21).setPreferredWidth(100);
            jtListaFuncionarios.getColumnModel().getColumn(22).setMinWidth(150);
            jtListaFuncionarios.getColumnModel().getColumn(22).setPreferredWidth(150);
            jtListaFuncionarios.getColumnModel().getColumn(23).setMinWidth(150);
            jtListaFuncionarios.getColumnModel().getColumn(23).setPreferredWidth(150);
            jtListaFuncionarios.getColumnModel().getColumn(24).setMinWidth(100);
            jtListaFuncionarios.getColumnModel().getColumn(24).setPreferredWidth(100);
            jtListaFuncionarios.getColumnModel().getColumn(25).setMinWidth(150);
            jtListaFuncionarios.getColumnModel().getColumn(25).setPreferredWidth(150);
            jtListaFuncionarios.getColumnModel().getColumn(26).setMinWidth(100);
            jtListaFuncionarios.getColumnModel().getColumn(26).setPreferredWidth(100);
            jtListaFuncionarios.getColumnModel().getColumn(27).setMinWidth(100);
            jtListaFuncionarios.getColumnModel().getColumn(27).setPreferredWidth(100);
            jtListaFuncionarios.getColumnModel().getColumn(28).setMinWidth(120);
            jtListaFuncionarios.getColumnModel().getColumn(28).setPreferredWidth(120);
            jtListaFuncionarios.getColumnModel().getColumn(29).setMinWidth(120);
            jtListaFuncionarios.getColumnModel().getColumn(29).setPreferredWidth(120);
        }

        jpListaFuncionarios.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 990, 220));

        jlPesquisarFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlPesquisarFuncionarios.setText("Pesquisar:");
        jpListaFuncionarios.add(jlPesquisarFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 35, -1, 20));

        jlFiltrarFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlFiltrarFuncionarios.setText("Filtrar:");
        jpListaFuncionarios.add(jlFiltrarFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 35, -1, 20));

        jtfPesquisarFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfPesquisarFuncionarios.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfPesquisarFuncionarios.setPreferredSize(new java.awt.Dimension(3, 25));
        jpListaFuncionarios.add(jtfPesquisarFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 35, 509, -1));

        jcbFiltrarFuncionarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbFiltrarFuncionarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "NOME", "CPF", "RG" }));
        jcbFiltrarFuncionarios.setMinimumSize(new java.awt.Dimension(3, 25));
        jcbFiltrarFuncionarios.setPreferredSize(new java.awt.Dimension(3, 25));
        jpListaFuncionarios.add(jcbFiltrarFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 35, 90, -1));

        jbProcurarFuncionarios.setBackground(new java.awt.Color(255, 255, 255));
        jbProcurarFuncionarios.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbProcurarFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/pesquisar-36.png"))); // NOI18N
        jbProcurarFuncionarios.setText("Procurar");
        jbProcurarFuncionarios.setToolTipText("Clique para procurar funcionário");
        jbProcurarFuncionarios.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jbProcurarFuncionarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbProcurarFuncionarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbProcurarFuncionarios.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbProcurarFuncionarios.setIconTextGap(8);
        jbProcurarFuncionarios.setMaximumSize(new java.awt.Dimension(106, 40));
        jbProcurarFuncionarios.setMinimumSize(new java.awt.Dimension(106, 40));
        jbProcurarFuncionarios.setPreferredSize(new java.awt.Dimension(106, 40));
        jbProcurarFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProcurarFuncionariosActionPerformed(evt);
            }
        });
        jpListaFuncionarios.add(jbProcurarFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 25, 120, 45));

        jpFuncionariosRegistros.add(jpListaFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 1010, 310));

        jlNomeTelaFuncionarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jlNomeTelaFuncionarios.setForeground(new java.awt.Color(31, 43, 91));
        jlNomeTelaFuncionarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlNomeTelaFuncionarios.setText("Cadastro de Funcionários");
        jlNomeTelaFuncionarios.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(42, 152, 223), null));
        jpFuncionariosRegistros.add(jlNomeTelaFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 1140, 25));

        jbSalvarFuncionarios.setBackground(new java.awt.Color(255, 255, 255));
        jbSalvarFuncionarios.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbSalvarFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/salvar-36.png"))); // NOI18N
        jbSalvarFuncionarios.setText("Salvar");
        jbSalvarFuncionarios.setToolTipText("Clique para salvar");
        jbSalvarFuncionarios.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jbSalvarFuncionarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbSalvarFuncionarios.setEnabled(false);
        jbSalvarFuncionarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbSalvarFuncionarios.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbSalvarFuncionarios.setIconTextGap(8);
        jbSalvarFuncionarios.setMaximumSize(new java.awt.Dimension(106, 45));
        jbSalvarFuncionarios.setMinimumSize(new java.awt.Dimension(106, 45));
        jbSalvarFuncionarios.setPreferredSize(new java.awt.Dimension(106, 45));
        jbSalvarFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarFuncionariosActionPerformed(evt);
            }
        });
        jpFuncionariosRegistros.add(jbSalvarFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 480, -1, -1));

        jbLimparTelaFuncionarios.setBackground(new java.awt.Color(255, 255, 255));
        jbLimparTelaFuncionarios.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbLimparTelaFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/limpar-36.png"))); // NOI18N
        jbLimparTelaFuncionarios.setText("Limpar");
        jbLimparTelaFuncionarios.setToolTipText("Clique para limpar todos os campos");
        jbLimparTelaFuncionarios.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jbLimparTelaFuncionarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbLimparTelaFuncionarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbLimparTelaFuncionarios.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbLimparTelaFuncionarios.setIconTextGap(8);
        jbLimparTelaFuncionarios.setMaximumSize(new java.awt.Dimension(106, 45));
        jbLimparTelaFuncionarios.setMinimumSize(new java.awt.Dimension(106, 45));
        jbLimparTelaFuncionarios.setPreferredSize(new java.awt.Dimension(106, 45));
        jbLimparTelaFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparTelaFuncionariosActionPerformed(evt);
            }
        });
        jpFuncionariosRegistros.add(jbLimparTelaFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 600, -1, -1));

        jbExcluirFuncionarios.setBackground(new java.awt.Color(255, 255, 255));
        jbExcluirFuncionarios.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jbExcluirFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/excluir-36.png"))); // NOI18N
        jbExcluirFuncionarios.setText("Excluir");
        jbExcluirFuncionarios.setToolTipText("Clique para excluir o cadastro selecionado");
        jbExcluirFuncionarios.setAutoscrolls(true);
        jbExcluirFuncionarios.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jbExcluirFuncionarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbExcluirFuncionarios.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jbExcluirFuncionarios.setIconTextGap(8);
        jbExcluirFuncionarios.setMaximumSize(new java.awt.Dimension(106, 45));
        jbExcluirFuncionarios.setMinimumSize(new java.awt.Dimension(106, 45));
        jbExcluirFuncionarios.setPreferredSize(new java.awt.Dimension(106, 45));
        jbExcluirFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirFuncionariosActionPerformed(evt);
            }
        });
        jpFuncionariosRegistros.add(jbExcluirFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 540, -1, -1));

        jpEditarFuncionarios.setBackground(new java.awt.Color(255, 255, 255));
        jpEditarFuncionarios.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jpEditarFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/editar-36.png"))); // NOI18N
        jpEditarFuncionarios.setText("Editar");
        jpEditarFuncionarios.setToolTipText("Clique para editar o cadastro selecionado");
        jpEditarFuncionarios.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jpEditarFuncionarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpEditarFuncionarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jpEditarFuncionarios.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jpEditarFuncionarios.setIconTextGap(8);
        jpEditarFuncionarios.setMaximumSize(new java.awt.Dimension(106, 45));
        jpEditarFuncionarios.setMinimumSize(new java.awt.Dimension(106, 45));
        jpEditarFuncionarios.setPreferredSize(new java.awt.Dimension(106, 45));
        jpEditarFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpEditarFuncionariosActionPerformed(evt);
            }
        });
        jpFuncionariosRegistros.add(jpEditarFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 420, -1, -1));

        jbNovoFuncionarios.setBackground(new java.awt.Color(255, 255, 255));
        jbNovoFuncionarios.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbNovoFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/adicionar-36.png"))); // NOI18N
        jbNovoFuncionarios.setText("Novo");
        jbNovoFuncionarios.setToolTipText("Clique para inciar um novo cadastro");
        jbNovoFuncionarios.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jbNovoFuncionarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbNovoFuncionarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbNovoFuncionarios.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbNovoFuncionarios.setIconTextGap(8);
        jbNovoFuncionarios.setMaximumSize(new java.awt.Dimension(106, 45));
        jbNovoFuncionarios.setMinimumSize(new java.awt.Dimension(106, 45));
        jbNovoFuncionarios.setPreferredSize(new java.awt.Dimension(106, 45));
        jbNovoFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoFuncionariosActionPerformed(evt);
            }
        });
        jpFuncionariosRegistros.add(jbNovoFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 360, -1, -1));

        jpMenuPrincipal.add(jpFuncionariosRegistros, "card5");

        jpAgendamentosMenu.setBackground(new java.awt.Color(177, 201, 234));
        jpAgendamentosMenu.setMinimumSize(new java.awt.Dimension(1160, 627));

        jbConsultasAgendamentos.setBackground(new java.awt.Color(204, 204, 204));
        jbConsultasAgendamentos.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jbConsultasAgendamentos.setForeground(new java.awt.Color(255, 255, 255));
        jbConsultasAgendamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Consultas.png"))); // NOI18N
        jbConsultasAgendamentos.setText("Consultas");
        jbConsultasAgendamentos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 43, 91), 2, true));
        jbConsultasAgendamentos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbConsultasAgendamentos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbConsultasAgendamentos.setIconTextGap(-60);
        jbConsultasAgendamentos.setMargin(new java.awt.Insets(2, 10, 2, 10));
        jbConsultasAgendamentos.setMaximumSize(new java.awt.Dimension(380, 617));
        jbConsultasAgendamentos.setMinimumSize(new java.awt.Dimension(380, 617));
        jbConsultasAgendamentos.setPreferredSize(new java.awt.Dimension(380, 617));
        jbConsultasAgendamentos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbConsultasAgendamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConsultasAgendamentosActionPerformed(evt);
            }
        });

        jbExamesAgendamentos.setBackground(new java.awt.Color(204, 204, 204));
        jbExamesAgendamentos.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jbExamesAgendamentos.setForeground(new java.awt.Color(255, 255, 255));
        jbExamesAgendamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Exames.png"))); // NOI18N
        jbExamesAgendamentos.setText("Exames");
        jbExamesAgendamentos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 43, 91), 2, true));
        jbExamesAgendamentos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbExamesAgendamentos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbExamesAgendamentos.setIconTextGap(-60);
        jbExamesAgendamentos.setMargin(new java.awt.Insets(2, 10, 2, 10));
        jbExamesAgendamentos.setMaximumSize(new java.awt.Dimension(380, 617));
        jbExamesAgendamentos.setMinimumSize(new java.awt.Dimension(380, 617));
        jbExamesAgendamentos.setPreferredSize(new java.awt.Dimension(380, 617));
        jbExamesAgendamentos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbExamesAgendamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExamesAgendamentosActionPerformed(evt);
            }
        });

        jbVacinasAgendamentos.setBackground(new java.awt.Color(204, 204, 204));
        jbVacinasAgendamentos.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jbVacinasAgendamentos.setForeground(new java.awt.Color(255, 255, 255));
        jbVacinasAgendamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Vacinas.png"))); // NOI18N
        jbVacinasAgendamentos.setText("Vacinas");
        jbVacinasAgendamentos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 43, 91), 2, true));
        jbVacinasAgendamentos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbVacinasAgendamentos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbVacinasAgendamentos.setIconTextGap(-60);
        jbVacinasAgendamentos.setMargin(new java.awt.Insets(2, 10, 2, 10));
        jbVacinasAgendamentos.setMaximumSize(new java.awt.Dimension(380, 617));
        jbVacinasAgendamentos.setMinimumSize(new java.awt.Dimension(380, 617));
        jbVacinasAgendamentos.setPreferredSize(new java.awt.Dimension(380, 617));
        jbVacinasAgendamentos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbVacinasAgendamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVacinasAgendamentosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpAgendamentosMenuLayout = new javax.swing.GroupLayout(jpAgendamentosMenu);
        jpAgendamentosMenu.setLayout(jpAgendamentosMenuLayout);
        jpAgendamentosMenuLayout.setHorizontalGroup(
            jpAgendamentosMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAgendamentosMenuLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jbConsultasAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jbExamesAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jbVacinasAgendamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jpAgendamentosMenuLayout.setVerticalGroup(
            jpAgendamentosMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAgendamentosMenuLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jpAgendamentosMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbExamesAgendamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbConsultasAgendamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbVacinasAgendamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        jpMenuPrincipal.add(jpAgendamentosMenu, "card6");

        jpAgendamentos.setBackground(new java.awt.Color(177, 201, 234));
        jpAgendamentos.setMinimumSize(new java.awt.Dimension(1160, 627));
        jpAgendamentos.setPreferredSize(new java.awt.Dimension(1160, 627));
        jpAgendamentos.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jpAgendamentosComponentShown(evt);
            }
        });
        jpAgendamentos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlNomeTelaAgendamentos.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jlNomeTelaAgendamentos.setForeground(new java.awt.Color(31, 43, 91));
        jlNomeTelaAgendamentos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlNomeTelaAgendamentos.setText("Agendamento de Consultas");
        jlNomeTelaAgendamentos.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(42, 152, 223), null));
        jpAgendamentos.add(jlNomeTelaAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 4, 1140, -1));

        jpDadosDoAgendamentos.setBackground(new java.awt.Color(177, 201, 234));
        jpDadosDoAgendamentos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Dados do Agendamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jpDadosDoAgendamentos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlIDAgendamentos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlIDAgendamentos.setText("ID:");
        jpDadosDoAgendamentos.add(jlIDAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 20));

        jlDataAgendamentos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlDataAgendamentos.setText("Data:");
        jpDadosDoAgendamentos.add(jlDataAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 20, -1, 20));

        jlHoraAgendamentos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlHoraAgendamentos.setText("Hora:");
        jpDadosDoAgendamentos.add(jlHoraAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, 20));

        jlPacienteAgendamentos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlPacienteAgendamentos.setText("Paciente:");
        jpDadosDoAgendamentos.add(jlPacienteAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, 20));

        jlTelefoneFixoAgendamentos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlTelefoneFixoAgendamentos.setText("Tel. Fixo:");
        jpDadosDoAgendamentos.add(jlTelefoneFixoAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, -1, 20));

        jlCelularAgendamentos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlCelularAgendamentos.setText("Tel. Celular:");
        jpDadosDoAgendamentos.add(jlCelularAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, -1, 20));

        jlTelefoneRecadoAgendamentos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlTelefoneRecadoAgendamentos.setText("Tel. Recado:");
        jpDadosDoAgendamentos.add(jlTelefoneRecadoAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 20, -1, 20));

        jlStatusAgendamentos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlStatusAgendamentos.setText("Status:");
        jpDadosDoAgendamentos.add(jlStatusAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 150, -1, 20));

        jlObservacoesAgendamentos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlObservacoesAgendamentos.setText("Observações:");
        jpDadosDoAgendamentos.add(jlObservacoesAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, 20));

        jlTipoAtendAgendamentos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlTipoAtendAgendamentos.setText("Tipo de Atendimento:");
        jpDadosDoAgendamentos.add(jlTipoAtendAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 80, -1, 20));

        jlEspecialidadeAgendamentos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlEspecialidadeAgendamentos.setText("Especialidade:");
        jpDadosDoAgendamentos.add(jlEspecialidadeAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 90, 20));

        jlTipoProcedimentoAgendamentos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlTipoProcedimentoAgendamentos.setText("Tipo de Proced.:");
        jpDadosDoAgendamentos.add(jlTipoProcedimentoAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, -1, 20));

        jlConvenioAgendamentos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlConvenioAgendamentos.setText("Convênio:");
        jpDadosDoAgendamentos.add(jlConvenioAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 80, -1, 20));

        jlEspecialistaAgendamentos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlEspecialistaAgendamentos.setText("Especialista:");
        jpDadosDoAgendamentos.add(jlEspecialistaAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, -1, 20));

        jlProcedimentoAgendamentos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlProcedimentoAgendamentos.setText("Procedimento:");
        jpDadosDoAgendamentos.add(jlProcedimentoAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, -1, 20));

        jldtDoAgendAgendamentos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jldtDoAgendAgendamentos.setText("Data do Agend.:");
        jpDadosDoAgendamentos.add(jldtDoAgendAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 150, 120, 20));

        jtfIDAgendamentos.setEditable(false);
        jtfIDAgendamentos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfIDAgendamentos.setForeground(new java.awt.Color(255, 0, 51));
        jtfIDAgendamentos.setEnabled(false);
        jtfIDAgendamentos.setFocusable(false);
        jtfIDAgendamentos.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfIDAgendamentos.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosDoAgendamentos.add(jtfIDAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 70, -1));

        jftTelefoneFixoAgendamentos.setEditable(false);
        try {
            jftTelefoneFixoAgendamentos.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftTelefoneFixoAgendamentos.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jftTelefoneFixoAgendamentos.setEnabled(false);
        jftTelefoneFixoAgendamentos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jftTelefoneFixoAgendamentos.setMinimumSize(new java.awt.Dimension(3, 25));
        jftTelefoneFixoAgendamentos.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosDoAgendamentos.add(jftTelefoneFixoAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 40, 100, -1));

        jftCelularAgendamentos.setEditable(false);
        try {
            jftCelularAgendamentos.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftCelularAgendamentos.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jftCelularAgendamentos.setEnabled(false);
        jftCelularAgendamentos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jftCelularAgendamentos.setMinimumSize(new java.awt.Dimension(3, 25));
        jftCelularAgendamentos.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosDoAgendamentos.add(jftCelularAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 40, 100, -1));

        jftTelefoneRecadoAgendamentos.setEditable(false);
        try {
            jftTelefoneRecadoAgendamentos.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftTelefoneRecadoAgendamentos.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jftTelefoneRecadoAgendamentos.setEnabled(false);
        jftTelefoneRecadoAgendamentos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jftTelefoneRecadoAgendamentos.setMinimumSize(new java.awt.Dimension(3, 25));
        jftTelefoneRecadoAgendamentos.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosDoAgendamentos.add(jftTelefoneRecadoAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 40, 100, -1));

        jcbPacienteAgendamentos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbPacienteAgendamentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        jcbPacienteAgendamentos.setEnabled(false);
        jcbPacienteAgendamentos.setMinimumSize(new java.awt.Dimension(3, 25));
        jcbPacienteAgendamentos.setPreferredSize(new java.awt.Dimension(3, 25));
        jcbPacienteAgendamentos.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcbPacienteAgendamentosPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jcbPacienteAgendamentosPopupMenuWillBecomeVisible(evt);
            }
        });
        jpDadosDoAgendamentos.add(jcbPacienteAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 440, -1));

        jcbHoraAgendamentos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbHoraAgendamentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "00:00", "00:30", "01:00", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00", "23:30" }));
        jcbHoraAgendamentos.setEnabled(false);
        jcbHoraAgendamentos.setMinimumSize(new java.awt.Dimension(3, 25));
        jcbHoraAgendamentos.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosDoAgendamentos.add(jcbHoraAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 90, -1));

        jcbStatusAgendamentos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbStatusAgendamentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "AGENDADO", "AGUARDANDO PGT.", "PGT. LIBERADO", "CONCLUÍDO", "CANCELADO" }));
        jcbStatusAgendamentos.setEnabled(false);
        jcbStatusAgendamentos.setMinimumSize(new java.awt.Dimension(3, 25));
        jcbStatusAgendamentos.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosDoAgendamentos.add(jcbStatusAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 170, 160, -1));

        jcbEspecialidadeAgendamentos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbEspecialidadeAgendamentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Enfermagem", "Laboratorial", "Médico" }));
        jcbEspecialidadeAgendamentos.setEnabled(false);
        jcbEspecialidadeAgendamentos.setMinimumSize(new java.awt.Dimension(3, 25));
        jcbEspecialidadeAgendamentos.setPreferredSize(new java.awt.Dimension(3, 25));
        jcbEspecialidadeAgendamentos.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcbEspecialidadeAgendamentosPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jpDadosDoAgendamentos.add(jcbEspecialidadeAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 120, -1));

        jcbEspecialistaAgendamentos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbEspecialistaAgendamentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        jcbEspecialistaAgendamentos.setEnabled(false);
        jcbEspecialistaAgendamentos.setMinimumSize(new java.awt.Dimension(3, 25));
        jcbEspecialistaAgendamentos.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosDoAgendamentos.add(jcbEspecialistaAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 360, -1));

        jcbTipoAtendAgendamentos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbTipoAtendAgendamentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Particular", "Convênio" }));
        jcbTipoAtendAgendamentos.setEnabled(false);
        jcbTipoAtendAgendamentos.setMinimumSize(new java.awt.Dimension(3, 25));
        jcbTipoAtendAgendamentos.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosDoAgendamentos.add(jcbTipoAtendAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 100, 140, -1));

        jcbProcedimentoAgendamentos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbProcedimentoAgendamentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", " " }));
        jcbProcedimentoAgendamentos.setEnabled(false);
        jcbProcedimentoAgendamentos.setMinimumSize(new java.awt.Dimension(3, 25));
        jcbProcedimentoAgendamentos.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosDoAgendamentos.add(jcbProcedimentoAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 170, -1));

        jcbConvenioAgendamentos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbConvenioAgendamentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Particular", "SulAmérica", "NotreDame Intermédica", "Prevent Senior", "Assim Saúde", "Central Nacional Unimed (CNU)", "Bradesco Seguros", "São Francisco Saúde", "Amil Assistência Médica" }));
        jcbConvenioAgendamentos.setEnabled(false);
        jcbConvenioAgendamentos.setMinimumSize(new java.awt.Dimension(3, 25));
        jcbConvenioAgendamentos.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosDoAgendamentos.add(jcbConvenioAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 100, 160, -1));

        jcbTipoProcedimentoAgendamentos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbTipoProcedimentoAgendamentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Consulta", "Exame", "Vacina" }));
        jcbTipoProcedimentoAgendamentos.setEnabled(false);
        jcbTipoProcedimentoAgendamentos.setMinimumSize(new java.awt.Dimension(3, 25));
        jcbTipoProcedimentoAgendamentos.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosDoAgendamentos.add(jcbTipoProcedimentoAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 110, -1));

        jdcDataAgendamentos.setBackground(new java.awt.Color(177, 201, 234));
        jdcDataAgendamentos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jdcDataAgendamentos.setEnabled(false);
        jdcDataAgendamentos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jdcDataAgendamentos.setMinimumSize(new java.awt.Dimension(100, 25));
        jdcDataAgendamentos.setPreferredSize(new java.awt.Dimension(100, 25));
        jpDadosDoAgendamentos.add(jdcDataAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 150, 25));

        jftDataAgendAgendamentos.setEditable(false);
        jftDataAgendAgendamentos.setForeground(new java.awt.Color(255, 0, 51));
        jftDataAgendAgendamentos.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jftDataAgendAgendamentos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jftDataAgendAgendamentos.setEnabled(false);
        jftDataAgendAgendamentos.setFocusable(false);
        jftDataAgendAgendamentos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jftDataAgendAgendamentos.setMinimumSize(new java.awt.Dimension(3, 25));
        jftDataAgendAgendamentos.setNextFocusableComponent(jbSalvarAgendamentos);
        jftDataAgendAgendamentos.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosDoAgendamentos.add(jftDataAgendAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 170, 120, -1));

        jtpObservacoesAgendamentos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jtpObservacoesAgendamentos.setEnabled(false);
        jScrollPane4.setViewportView(jtpObservacoesAgendamentos);

        jpDadosDoAgendamentos.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 810, 40));

        jpAgendamentos.add(jpDadosDoAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 35, 1140, 210));

        jpListaDeAgendamentos.setBackground(new java.awt.Color(177, 201, 234));
        jpListaDeAgendamentos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Lista de Agendamentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jpListaDeAgendamentos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtListaAgendamentos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtListaAgendamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID:", "Data:", "Hora:", "Paciente:", "Tel. Fixo:", "Tel. Celular:", "Tel. Recado:", "Setor:", "Especialista:", "Procedimento:", "Tipo de Proced.:", "Tipo de Atend.:", "Convênio:", "Observações:", "Status:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtListaAgendamentos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtListaAgendamentos.setGridColor(new java.awt.Color(31, 43, 91));
        jtListaAgendamentos.setRowHeight(20);
        jtListaAgendamentos.setSelectionBackground(new java.awt.Color(42, 152, 223));
        jtListaAgendamentos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jtListaAgendamentos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtListaAgendamentos.setShowGrid(true);
        jScrollPane3.setViewportView(jtListaAgendamentos);
        if (jtListaAgendamentos.getColumnModel().getColumnCount() > 0) {
            jtListaAgendamentos.getColumnModel().getColumn(0).setMinWidth(85);
            jtListaAgendamentos.getColumnModel().getColumn(0).setPreferredWidth(85);
            jtListaAgendamentos.getColumnModel().getColumn(1).setMinWidth(100);
            jtListaAgendamentos.getColumnModel().getColumn(1).setPreferredWidth(100);
            jtListaAgendamentos.getColumnModel().getColumn(2).setMinWidth(100);
            jtListaAgendamentos.getColumnModel().getColumn(2).setPreferredWidth(100);
            jtListaAgendamentos.getColumnModel().getColumn(3).setMinWidth(250);
            jtListaAgendamentos.getColumnModel().getColumn(3).setPreferredWidth(250);
            jtListaAgendamentos.getColumnModel().getColumn(4).setMinWidth(150);
            jtListaAgendamentos.getColumnModel().getColumn(4).setPreferredWidth(150);
            jtListaAgendamentos.getColumnModel().getColumn(5).setMinWidth(150);
            jtListaAgendamentos.getColumnModel().getColumn(5).setPreferredWidth(150);
            jtListaAgendamentos.getColumnModel().getColumn(6).setMinWidth(150);
            jtListaAgendamentos.getColumnModel().getColumn(6).setPreferredWidth(150);
            jtListaAgendamentos.getColumnModel().getColumn(7).setMinWidth(100);
            jtListaAgendamentos.getColumnModel().getColumn(7).setPreferredWidth(100);
            jtListaAgendamentos.getColumnModel().getColumn(8).setMinWidth(250);
            jtListaAgendamentos.getColumnModel().getColumn(8).setPreferredWidth(250);
            jtListaAgendamentos.getColumnModel().getColumn(9).setMinWidth(150);
            jtListaAgendamentos.getColumnModel().getColumn(9).setPreferredWidth(150);
            jtListaAgendamentos.getColumnModel().getColumn(10).setMinWidth(200);
            jtListaAgendamentos.getColumnModel().getColumn(10).setPreferredWidth(200);
            jtListaAgendamentos.getColumnModel().getColumn(11).setMinWidth(150);
            jtListaAgendamentos.getColumnModel().getColumn(11).setPreferredWidth(150);
            jtListaAgendamentos.getColumnModel().getColumn(12).setMinWidth(150);
            jtListaAgendamentos.getColumnModel().getColumn(12).setPreferredWidth(150);
            jtListaAgendamentos.getColumnModel().getColumn(13).setMinWidth(150);
            jtListaAgendamentos.getColumnModel().getColumn(13).setPreferredWidth(150);
            jtListaAgendamentos.getColumnModel().getColumn(14).setMinWidth(150);
            jtListaAgendamentos.getColumnModel().getColumn(14).setPreferredWidth(150);
        }

        jpListaDeAgendamentos.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 990, 310));

        jlPesquisarAgendamentos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlPesquisarAgendamentos.setText("Pesquisar:");
        jpListaDeAgendamentos.add(jlPesquisarAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 35, -1, 20));

        jlFiltrarAgendamentos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlFiltrarAgendamentos.setText("Filtrar:");
        jpListaDeAgendamentos.add(jlFiltrarAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 35, -1, 20));

        jtfPesquisarAgendamentos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfPesquisarAgendamentos.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfPesquisarAgendamentos.setPreferredSize(new java.awt.Dimension(3, 25));
        jpListaDeAgendamentos.add(jtfPesquisarAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 35, 509, -1));

        jcbFiltrarAgendamentos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbFiltrarAgendamentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "NOME", "ESPECIALISTA" }));
        jcbFiltrarAgendamentos.setMinimumSize(new java.awt.Dimension(3, 25));
        jcbFiltrarAgendamentos.setPreferredSize(new java.awt.Dimension(3, 25));
        jpListaDeAgendamentos.add(jcbFiltrarAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 35, 90, -1));

        jbProcurarAgendamentos.setBackground(new java.awt.Color(255, 255, 255));
        jbProcurarAgendamentos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbProcurarAgendamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/pesquisar-36.png"))); // NOI18N
        jbProcurarAgendamentos.setText("Procurar");
        jbProcurarAgendamentos.setToolTipText("Clique para procurar agendamento");
        jbProcurarAgendamentos.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jbProcurarAgendamentos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbProcurarAgendamentos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbProcurarAgendamentos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbProcurarAgendamentos.setIconTextGap(8);
        jbProcurarAgendamentos.setMaximumSize(new java.awt.Dimension(106, 40));
        jbProcurarAgendamentos.setMinimumSize(new java.awt.Dimension(106, 40));
        jbProcurarAgendamentos.setPreferredSize(new java.awt.Dimension(106, 40));
        jbProcurarAgendamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProcurarAgendamentosActionPerformed(evt);
            }
        });
        jpListaDeAgendamentos.add(jbProcurarAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 25, 120, 45));

        jpAgendamentos.add(jpListaDeAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 1010, 400));

        jbNovoAgendamentos.setBackground(new java.awt.Color(255, 255, 255));
        jbNovoAgendamentos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbNovoAgendamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/adicionar-36.png"))); // NOI18N
        jbNovoAgendamentos.setText("Novo");
        jbNovoAgendamentos.setToolTipText("Clique para inciar um novo cadastro");
        jbNovoAgendamentos.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jbNovoAgendamentos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbNovoAgendamentos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbNovoAgendamentos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbNovoAgendamentos.setIconTextGap(8);
        jbNovoAgendamentos.setMaximumSize(new java.awt.Dimension(106, 45));
        jbNovoAgendamentos.setMinimumSize(new java.awt.Dimension(106, 45));
        jbNovoAgendamentos.setPreferredSize(new java.awt.Dimension(106, 45));
        jbNovoAgendamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoAgendamentosActionPerformed(evt);
            }
        });
        jpAgendamentos.add(jbNovoAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 310, -1, -1));

        jbEditarAgendamentos.setBackground(new java.awt.Color(255, 255, 255));
        jbEditarAgendamentos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbEditarAgendamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/editar-36.png"))); // NOI18N
        jbEditarAgendamentos.setText("Editar");
        jbEditarAgendamentos.setToolTipText("Clique para editar o cadastro selecionado");
        jbEditarAgendamentos.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jbEditarAgendamentos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbEditarAgendamentos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbEditarAgendamentos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbEditarAgendamentos.setIconTextGap(8);
        jbEditarAgendamentos.setMaximumSize(new java.awt.Dimension(106, 45));
        jbEditarAgendamentos.setMinimumSize(new java.awt.Dimension(106, 45));
        jbEditarAgendamentos.setPreferredSize(new java.awt.Dimension(106, 45));
        jbEditarAgendamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarAgendamentosActionPerformed(evt);
            }
        });
        jpAgendamentos.add(jbEditarAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 370, -1, -1));

        jbSalvarAgendamentos.setBackground(new java.awt.Color(255, 255, 255));
        jbSalvarAgendamentos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbSalvarAgendamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/salvar-36.png"))); // NOI18N
        jbSalvarAgendamentos.setText("Salvar");
        jbSalvarAgendamentos.setToolTipText("Clique para salvar");
        jbSalvarAgendamentos.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jbSalvarAgendamentos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbSalvarAgendamentos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbSalvarAgendamentos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbSalvarAgendamentos.setIconTextGap(8);
        jbSalvarAgendamentos.setMaximumSize(new java.awt.Dimension(106, 45));
        jbSalvarAgendamentos.setMinimumSize(new java.awt.Dimension(106, 45));
        jbSalvarAgendamentos.setPreferredSize(new java.awt.Dimension(106, 45));
        jbSalvarAgendamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarAgendamentosActionPerformed(evt);
            }
        });
        jpAgendamentos.add(jbSalvarAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 430, -1, -1));

        jbExlcuirAgendamentos.setBackground(new java.awt.Color(255, 255, 255));
        jbExlcuirAgendamentos.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jbExlcuirAgendamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/excluir-36.png"))); // NOI18N
        jbExlcuirAgendamentos.setText("Excluir");
        jbExlcuirAgendamentos.setToolTipText("Clique para excluir o cadastro selecionado");
        jbExlcuirAgendamentos.setAutoscrolls(true);
        jbExlcuirAgendamentos.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jbExlcuirAgendamentos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbExlcuirAgendamentos.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jbExlcuirAgendamentos.setIconTextGap(8);
        jbExlcuirAgendamentos.setMaximumSize(new java.awt.Dimension(106, 45));
        jbExlcuirAgendamentos.setMinimumSize(new java.awt.Dimension(106, 45));
        jbExlcuirAgendamentos.setPreferredSize(new java.awt.Dimension(106, 45));
        jbExlcuirAgendamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExlcuirAgendamentosActionPerformed(evt);
            }
        });
        jpAgendamentos.add(jbExlcuirAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 490, -1, -1));

        jbLimparTelaAgendamentos.setBackground(new java.awt.Color(255, 255, 255));
        jbLimparTelaAgendamentos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbLimparTelaAgendamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/limpar-36.png"))); // NOI18N
        jbLimparTelaAgendamentos.setText("Limpar");
        jbLimparTelaAgendamentos.setToolTipText("Clique para limpar todos os campos");
        jbLimparTelaAgendamentos.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jbLimparTelaAgendamentos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbLimparTelaAgendamentos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbLimparTelaAgendamentos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbLimparTelaAgendamentos.setIconTextGap(8);
        jbLimparTelaAgendamentos.setMaximumSize(new java.awt.Dimension(106, 45));
        jbLimparTelaAgendamentos.setMinimumSize(new java.awt.Dimension(106, 45));
        jbLimparTelaAgendamentos.setPreferredSize(new java.awt.Dimension(106, 45));
        jbLimparTelaAgendamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparTelaAgendamentosActionPerformed(evt);
            }
        });
        jpAgendamentos.add(jbLimparTelaAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 550, -1, -1));

        jpMenuPrincipal.add(jpAgendamentos, "card8");

        jpAtendimentosMenu.setBackground(new java.awt.Color(177, 201, 234));
        jpAtendimentosMenu.setMinimumSize(new java.awt.Dimension(1160, 627));
        jpAtendimentosMenu.setPreferredSize(new java.awt.Dimension(1160, 627));

        jbMedicosAtendimentos.setBackground(new java.awt.Color(204, 204, 204));
        jbMedicosAtendimentos.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jbMedicosAtendimentos.setForeground(new java.awt.Color(255, 255, 255));
        jbMedicosAtendimentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Médicos.png"))); // NOI18N
        jbMedicosAtendimentos.setText("Médicos");
        jbMedicosAtendimentos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 43, 91), 2, true));
        jbMedicosAtendimentos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbMedicosAtendimentos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbMedicosAtendimentos.setIconTextGap(-60);
        jbMedicosAtendimentos.setMargin(new java.awt.Insets(2, 10, 2, 10));
        jbMedicosAtendimentos.setMaximumSize(new java.awt.Dimension(570, 617));
        jbMedicosAtendimentos.setMinimumSize(new java.awt.Dimension(570, 617));
        jbMedicosAtendimentos.setPreferredSize(new java.awt.Dimension(570, 617));
        jbMedicosAtendimentos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbMedicosAtendimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMedicosAtendimentosActionPerformed(evt);
            }
        });

        jbEnfermeirosAtendimentos.setBackground(new java.awt.Color(204, 204, 204));
        jbEnfermeirosAtendimentos.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jbEnfermeirosAtendimentos.setForeground(new java.awt.Color(255, 255, 255));
        jbEnfermeirosAtendimentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Enfermeiros.png"))); // NOI18N
        jbEnfermeirosAtendimentos.setText("Enfermeiros");
        jbEnfermeirosAtendimentos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 43, 91), 2, true));
        jbEnfermeirosAtendimentos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbEnfermeirosAtendimentos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbEnfermeirosAtendimentos.setIconTextGap(-60);
        jbEnfermeirosAtendimentos.setMargin(new java.awt.Insets(2, 10, 2, 10));
        jbEnfermeirosAtendimentos.setMaximumSize(new java.awt.Dimension(570, 617));
        jbEnfermeirosAtendimentos.setMinimumSize(new java.awt.Dimension(570, 617));
        jbEnfermeirosAtendimentos.setPreferredSize(new java.awt.Dimension(570, 617));
        jbEnfermeirosAtendimentos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbEnfermeirosAtendimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEnfermeirosAtendimentosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpAtendimentosMenuLayout = new javax.swing.GroupLayout(jpAtendimentosMenu);
        jpAtendimentosMenu.setLayout(jpAtendimentosMenuLayout);
        jpAtendimentosMenuLayout.setHorizontalGroup(
            jpAtendimentosMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAtendimentosMenuLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jbMedicosAtendimentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jbEnfermeirosAtendimentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jpAtendimentosMenuLayout.setVerticalGroup(
            jpAtendimentosMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAtendimentosMenuLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jpAtendimentosMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbMedicosAtendimentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbEnfermeirosAtendimentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        jpMenuPrincipal.add(jpAtendimentosMenu, "card10");

        jpMedicosAtendimentos.setBackground(new java.awt.Color(177, 201, 234));
        jpMedicosAtendimentos.setMinimumSize(new java.awt.Dimension(1160, 627));
        jpMedicosAtendimentos.setPreferredSize(new java.awt.Dimension(1160, 627));
        jpMedicosAtendimentos.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jpMedicosAtendimentosComponentShown(evt);
            }
        });
        jpMedicosAtendimentos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlNomeTelaAtendMedico.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jlNomeTelaAtendMedico.setForeground(new java.awt.Color(31, 43, 91));
        jlNomeTelaAtendMedico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlNomeTelaAtendMedico.setText("Atendimento Médico");
        jlNomeTelaAtendMedico.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(42, 152, 223), null));
        jpMedicosAtendimentos.add(jlNomeTelaAtendMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 4, 1140, -1));

        jbLimparTelaAtendMedico.setBackground(new java.awt.Color(255, 255, 255));
        jbLimparTelaAtendMedico.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbLimparTelaAtendMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/limpar-36.png"))); // NOI18N
        jbLimparTelaAtendMedico.setText("Limpar");
        jbLimparTelaAtendMedico.setToolTipText("Clique para limpar todos os campos");
        jbLimparTelaAtendMedico.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jbLimparTelaAtendMedico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbLimparTelaAtendMedico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbLimparTelaAtendMedico.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbLimparTelaAtendMedico.setIconTextGap(8);
        jbLimparTelaAtendMedico.setMaximumSize(new java.awt.Dimension(106, 45));
        jbLimparTelaAtendMedico.setMinimumSize(new java.awt.Dimension(106, 45));
        jbLimparTelaAtendMedico.setPreferredSize(new java.awt.Dimension(106, 45));
        jbLimparTelaAtendMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparTelaAtendMedicoActionPerformed(evt);
            }
        });
        jpMedicosAtendimentos.add(jbLimparTelaAtendMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 590, -1, -1));

        jbSalvarAtendMedico.setBackground(new java.awt.Color(255, 255, 255));
        jbSalvarAtendMedico.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbSalvarAtendMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/salvar-36.png"))); // NOI18N
        jbSalvarAtendMedico.setText("Salvar");
        jbSalvarAtendMedico.setToolTipText("Clique para salvar");
        jbSalvarAtendMedico.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jbSalvarAtendMedico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbSalvarAtendMedico.setEnabled(false);
        jbSalvarAtendMedico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbSalvarAtendMedico.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbSalvarAtendMedico.setIconTextGap(8);
        jbSalvarAtendMedico.setMaximumSize(new java.awt.Dimension(106, 45));
        jbSalvarAtendMedico.setMinimumSize(new java.awt.Dimension(106, 45));
        jbSalvarAtendMedico.setPreferredSize(new java.awt.Dimension(106, 45));
        jbSalvarAtendMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarAtendMedicoActionPerformed(evt);
            }
        });
        jpMedicosAtendimentos.add(jbSalvarAtendMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 530, -1, -1));

        jpDadosPacienteAtendMedico.setBackground(new java.awt.Color(177, 201, 234));
        jpDadosPacienteAtendMedico.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Dados do Paciente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jpDadosPacienteAtendMedico.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlPacienteAtendMedico.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlPacienteAtendMedico.setText("Paciente:");
        jpDadosPacienteAtendMedico.add(jlPacienteAtendMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 20));

        jcbPacienteAtendMedico.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbPacienteAtendMedico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        jcbPacienteAtendMedico.setEnabled(false);
        jcbPacienteAtendMedico.setMinimumSize(new java.awt.Dimension(3, 25));
        jcbPacienteAtendMedico.setPreferredSize(new java.awt.Dimension(3, 25));
        jcbPacienteAtendMedico.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcbPacienteAtendMedicoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jcbPacienteAtendMedicoPopupMenuWillBecomeVisible(evt);
            }
        });
        jpDadosPacienteAtendMedico.add(jcbPacienteAtendMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 390, -1));

        jlSexoAtendMedico.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlSexoAtendMedico.setText("Sexo:");
        jpDadosPacienteAtendMedico.add(jlSexoAtendMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, 20));

        jcbSexoPacienteAtendMedico.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbSexoPacienteAtendMedico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indefinido", "Masculino", "Feminino" }));
        jcbSexoPacienteAtendMedico.setEnabled(false);
        jcbSexoPacienteAtendMedico.setMinimumSize(new java.awt.Dimension(3, 25));
        jcbSexoPacienteAtendMedico.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPacienteAtendMedico.add(jcbSexoPacienteAtendMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 110, -1));

        jlDataNascPacienteAtendMedico.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlDataNascPacienteAtendMedico.setText("Data de Nasc.:");
        jpDadosPacienteAtendMedico.add(jlDataNascPacienteAtendMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, 20));

        jdcDataNascPacienteAtendMedico.setBackground(new java.awt.Color(177, 201, 234));
        jdcDataNascPacienteAtendMedico.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jdcDataNascPacienteAtendMedico.setEnabled(false);
        jdcDataNascPacienteAtendMedico.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jdcDataNascPacienteAtendMedico.setMinimumSize(new java.awt.Dimension(100, 25));
        jdcDataNascPacienteAtendMedico.setPreferredSize(new java.awt.Dimension(100, 25));
        jpDadosPacienteAtendMedico.add(jdcDataNascPacienteAtendMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 160, 25));

        jtfLogradouroPacienteAtendMedico.setEditable(false);
        jtfLogradouroPacienteAtendMedico.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfLogradouroPacienteAtendMedico.setEnabled(false);
        jtfLogradouroPacienteAtendMedico.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfLogradouroPacienteAtendMedico.setPreferredSize(new java.awt.Dimension(3, 25));
        jpDadosPacienteAtendMedico.add(jtfLogradouroPacienteAtendMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 40, 430, -1));

        jlLogradouroPacienteAtendMedico.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlLogradouroPacienteAtendMedico.setText("Logradouro:");
        jpDadosPacienteAtendMedico.add(jlLogradouroPacienteAtendMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, -1, 20));

        jpMedicosAtendimentos.add(jpDadosPacienteAtendMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1140, 80));

        jpConsultaAtendMedico.setBackground(new java.awt.Color(177, 201, 234));
        jpConsultaAtendMedico.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")), "Consulta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jpConsultaAtendMedico.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtpDoencasCronicasAtendMedico.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jtpDoencasCronicasAtendMedico.setEnabled(false);
        jScrollPane5.setViewportView(jtpDoencasCronicasAtendMedico);

        jpConsultaAtendMedico.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 470, 150));

        jlDoencasCronicasAtendMedico.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlDoencasCronicasAtendMedico.setText("Doenças Crônicas:");
        jpConsultaAtendMedico.add(jlDoencasCronicasAtendMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, 20));

        jlDiagnosticoAtendMedico.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlDiagnosticoAtendMedico.setText("Diagnóstico:");
        jpConsultaAtendMedico.add(jlDiagnosticoAtendMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 20));

        jcbDoencasCronicasAtendMedico.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbDoencasCronicasAtendMedico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "A15 Tuberculose respiratória, com confirmação bacteriológica e histológica", "A16 Tuberculose das vias respiratórias, sem confirmação bacteriológica ou histológica", "A17 Tuberculose do sistema nervoso", "A18 Tuberculose de outros órgãos", "B18 Hepatite viral crônica", "B20 Doença pelo vírus da imunodeficiência humana [HIV], resultando em doenças infecciosas e parasitárias", "B21 Doença pelo vírus da imunodeficiência humana [HIV], resultando em neoplasias malignas", "B21 Doença pelo vírus da imunodeficiência humana [HIV], resultando em neoplasias malignas", "B22 Doença pelo vírus da imunodeficiência humana [HIV] resultando em outras doenças especificadas", "B22 Doença pelo vírus da imunodeficiência humana [HIV] resultando em outras doenças especificadas", "B23 Doença pelo vírus da imunodeficiência humana [HIV] resultando em outras doenças", "B23 Doença pelo vírus da imunodeficiência humana [HIV] resultando em outras doenças", "B24 Doença pelo vírus da imunodeficiência humana [HIV] não especificada", "B90 Seqüelas de tuberculose", "B91 Seqüelas de poliomielite", "B92 Seqüelas de hanseníase [lepra]", "B94 Seqüelas de outras doenças infecciosas e parasitárias e das não especificadas", "D45 Policitemia vera", "D46 Síndromes mielodisplásicas", "D60 Aplasia pura da série vermelha, adquirida [eritroblastopenia]", "D61 Outras anemias aplásticas", "D66 Deficiência hereditária do fator VIII", "D67 Deficiência hereditária do fator IX", "D69 Púrpura e outras afecções hemorrágicas", "D69 Púrpura e outras afecções hemorrágicas", "D70 Agranulocitose", "D71 Transtornos funcionais dos neutrófilos polimorfonucleares", "D72 Outros transtornos dos glóbulos brancos", "D74 Metemoglobinemia", "D74 Metemoglobinemia", "D75 Outras doenças do sangue e dos órgãos hematopoéticos", "D76 Algumas doenças que envolvem o tecido linforreticular e o sistema reticulohistiocítico", "D80 Imunodeficiência com predominância de defeitos de anticorpos", "D81 Deficiências imunitárias combinadas", "D82 Imunodeficiência associada com outros defeitos “major”", "D83 Imunodeficiência comum variável", "D86 Sarcoidose", "E03 Outros hipotireoidismos", "E05 Tireotoxicose [hipertireoidismo]", "E10 Diabetes mellitus insulino‐dependente", "E11 Diabetes mellitus não‐insulino‐dependente", "E14 Diabetes mellitus não especificado", "E20 Hipoparatireoidismo", "E21 Hiperparatireoidismo e outros transtornos da glândula paratireóide", "E22 Hiperfunção da hipófise", "E23 Hipofunção e outros transtornos da hipófise", "E24 Síndrome de Cushing", "E24 Síndrome de Cushing", "E25 Transtornos adrenogenitais", "E26 Hiperaldosteronismo", "E26 Hiperaldosteronismo", "E27 Outros transtornos da glândula supra‐renal", "E31 Disfunção poliglandular", "E32 Doenças do timo", "E34 Outros transtornos endócrinos", "E66 Obesidade", "E84 Fibrose cística", "E84 Fibrose cística", "E85 Amiloidose", "E85 Amiloidose", "G10 Doença de Huntington", "G10 Doença de Huntington", "G11 Ataxia hereditária", "G11 Ataxia hereditária", "G12 Atrofia muscular espinal e síndromes correlatas", "G12 Atrofia muscular espinal e síndromes correlatas", "G20 Doença de Parkinson", "G21 Parkinsonismo secundário", "G30 Doença de Alzheimer", "G35 Esclerose múltipla", "G35 Esclerose múltipla", "G40 Epilepsia", "G41 Estado de mal epiléptico", "G41 Estado de mal epiléptico", "G80 Paralisia cerebral", "G80 Paralisia cerebral", "G81 Hemiplegia", "G82 Paraplegia e tetraplegia", "G91 Hidrocefalia", "H40 Glaucoma", "I01 Febre reumática com comprometimento do coração", "I02 Coréia reumática", "I05 Doenças reumáticas da valva mitral", "I06 Doenças reumáticas da valva aórtica", "I07 Doenças reumáticas da valva tricúspide", "I08 Doenças de múltiplas valvas", "I10 Hipertensão essencial (primária)", "I11 Doença cardíaca hipertensiva", "I12 Doença renal hipertensiva", "I13 Doença cardíaca e renal hipertensiva", "I15 Hipertensão secundária", "I21 Infarto agudo do miocárdio", "I22 Infarto do miocárdio recorrente", "I25 Doença isquêmica crônica do coração", "I26 Embolia pulmonar", "I26 I28 Doenças cardíaca pulmonar e da circulação pulmonar", "I42 Cardiomiopatias", "I48 “Flutter” e fibrilação atrial", "I50 Insuficiência cardíaca", "I60 Hemorragia subaracnóide", "I61 Hemorragia intracerebral", "I63 Infarto cerebral", "I64 Acidente vascular cerebral, não especificado como hemorrágico ou isquêmico", "I65 Oclusão e estenose de artérias pré‐cerebrais que não resultam em infarto cerebral", "I66 Oclusão e estenose de artérias cerebrais que não resultam em infarto cerebral", "I69 Seqüelas de doenças cerebrovasculares", "I70 I79 Doenças das artérias, das arteríolas e dos capilares", "I71 Aneurisma e dissecção da aorta", "I72 Outros aneurismas", "I81 Trombose da veia porta", "J40 Bronquite não especificada como aguda ou crônica", "J41 Bronquite crônica simples e a mucopurulenta", "J42 Bronquite crônica não especificada", "J43 Enfisema", "J44 Outras doenças pulmonares obstrutivas crônicas", "J45 Asma", "J46 Estado de mal asmático", "J47 Bronquectasia", "J60 Pneumoconiose dos mineiros de carvão", "J61 Pneumoconiose devida a amianto [asbesto] e outras fibras minerais", "J62 Pneumoconiose devida a poeira que contenham sílica", "J63 Pneumoconiose devida a outras poeiras inorgânicas", "J64 Pneumoconiose não especificada", "J65 Pneumoconiose associada com tuberculose", "J66 Doenças das vias aéreas devida a poeiras orgânicas específicas", "J81 Edema pulmonar, não especificado de outra forma", "J82 Eosinofilia pulmonar, não classificada em outra parte", "J82 Eosinofilia pulmonar, não classificada em outra parte", "J96 Insuficiência respiratória não classificada de outra parte", "J96 Insuficiência respiratória não classificada de outra parte", "K50 Doença de Crohn [enterite regional]", "K51 Colite ulcerativa", "K52 Outras gastroenterites e colites não‐infecciosas", "K55 Transtornos vasculares do intestino", "K57 Doença diverticular do intestino", "K58 Síndrome do cólon irritável", "K59 Outros transtornos funcionais do intestino", "K70 Doença alcoólica do fígado", "K72 Insuficiência hepática não classificada em outra parte", "K72 Insuficiência hepática não classificada em outra parte", "K73 Hepatite crônica não classificada em outra parte", "K74 Fibrose e cirrose hepáticas", "K74 Fibrose e cirrose hepáticas", "K75 Outras doenças inflamatórias do fígado", "K76 Outras doenças do fígado", "K90 Má‐absorção intestinal", "L40 Psoríase", "L43 Líquen plano", "L93 Lúpus eritematoso", "L95 Vasculite limitada a pele não classificadas em outra parte", "M05 Artrite reumatóide soro‐positiva", "M06 Outras artrites reumatóides", "M08 Artrite juvenil", "M10 Gota", "M12 Outras artropatias especificadas", "M13 Outras artrites", "M15 Poliartrose", "M16 Coxartrose [artrose do quadril]", "M17 Gonartrose [artrose do joelho]", "M18 Artrose da primeira articulação carpometacarpiana", "M19 Outras artroses", "M30 Poliarterite nodosa e afecções correlatas", "M31 Outras vasculopatias necrotizantes", "M31 Outras vasculopatias necrotizantes", "M32 Lúpus eritematoso disseminado [sistêmico]", "M33 Dermatopoliomiosite", "M34 Esclerose sistêmica", "M35 Outras afecções sistêmicas do tecido conjuntivo", "M40 Cifose e lordose", "M41 Escoliose", "M42 Osteocondrose da coluna vertebral", "M43 Outras dorsopatias deformantes", "M45 Espondilite ancilosante", "M47 Espondilose", "M80 Osteoporose com fratura patológica", "M80 Osteoporose com fratura patológica", "M83 Osteomalácia do adulto", "M86 Osteomielite", "M87 Osteonecrose", "M88 Doença de Paget do osso (osteíte deformante)", "M91 Osteocondrose juvenil do quadril e da pelve", "N01 Síndrome nefrítica rapidamente progressiva", "N01 Síndrome nefrítica rapidamente progressiva", "N03 Síndrome nefrítica crônica", "N03 Síndrome nefrítica crônica", "N11 Nefrite túbulo‐intersticial crônica", "N11 Nefrite túbulo‐intersticial crônica", "N12 Nefrite túbulo‐intersticial não especificada se aguda ou crônica", "N12 Nefrite túbulo‐intersticial não especificada se aguda ou crônica", "N18 Insuficiência renal crônica", "N18 Insuficiência renal crônica", "N19 Insuficiência renal não especificada", "N80 Endometriose", "Q01 Encefalocele", "Q01 Encefalocele", "Q02 Microcefalia", "Q03 Hidrocefalia congênita", "Q03 Hidrocefalia congênita", "Q04 Outras malformações congênitas do cérebro", "Q05 Espinha bífida", "Q06 Outras malformações congênitas da medula espinhal", "Q07 Outras malformações congênitas do sistema nervoso", "Q10 Malformações congênitas das pálpebras, do aparelho lacrimal e da órbita", "Q10 Q18 Malformações congênitas do olho, do ouvido, da face e do pescoço", "Q11 Anoftalmia, microftalmia e macroftalmia", "Q12 Malformações congênitas do cristalino", "Q13 Malformações congênitas da câmara anterior do olho", "Q14 Malformações congênitas da câmara posterior do olho", "Q15 Outras malformações congênitas do olho", "Q16 Malformações congênitas do ouvido causando comprometimento da audição", "Q18 Outras malformações congênitas da face e do pescoço", "Q20 Malformações congênitas das câmaras e das comunicações cardíacas", "Q20 Malformações congênitas das câmaras e das comunicações cardíacas", "Q21 Malformações congênitas dos septos cardíacos", "Q21 Malformações congênitas dos septos cardíacos", "Q22 Malformações congênitas das valvas pulmonar e tricúspide", "Q22 Malformações congênitas das valvas pulmonar e tricúspide", "Q23 Malformações congênitas das valvas aórtica e mitral", "Q23 Malformações congênitas das valvas aórtica e mitral", "Q24 Outras malformações congênitas do coração", "Q25 Malformações congênitas das grandes artérias", "Q25 Malformações congênitas das grandes artérias", "Q26 Malformações congênitas das grandes veias", "Q26 Malformações congênitas das grandes veias", "Q27 Outras malformações congênitas do sistema vascular periférico", "Q28 Outras malformações congênitas do aparelho circulatório", "Q30 Malformação congênita do nariz", "Q31 Malformações congênitas da laringe", "Q31 Malformações congênitas da laringe", "Q32 Malformações congênitas da traquéia e dos brônquios", "Q32 Malformações congênitas da traquéia e dos brônquios", "Q33 Malformações congênitas do pulmão", "Q33 Malformações congênitas do pulmão", "Q34 Outras malformações congênitas do aparelho respiratório", "Q35 Fenda palatina", "Q36 Fenda labial", "Q37 Fenda labial com fenda palatina", "Q38 Outras malformações congênitas da língua, da boca e da faringe", "Q39 Malformações congênitas do esôfago", "Q39 Malformações congênitas do esôfago", "Q40 Outras malformações congênitas do trato digestivo superior", "Q41 Ausência, atresia e estenose congênita do intestino delgado", "Q41 Ausência, atresia e estenose congênita do intestino delgado", "Q42 Ausência, atresia e estenose congênita do cólon", "Q42 Ausência, atresia e estenose congênita do cólon", "Q43 Outras malformações congênitas do intestino", "Q44 Malformações congênitas da vesícula biliar, das vias biliares e do fígado", "Q44 Malformações congênitas da vesícula biliar, das vias biliares e do fígado", "Q45 Outras malformações congênitas do aparelho digestivo", "Q50 Malformações congênitas dos ovários, das trompas de Falópio e dos ligamentos largos", "Q51 Malformações congênitas do útero e do colo do útero", "Q52 Outras malformações congênitas dos órgãos genitais femininos", "Q55 Outras malformações congênitas dos órgãos genitais masculinos", "Q56 Sexo indeterminado e pseudo‐hermafroditismo", "Q60 Agenesia renal e outros defeitos de redução do rim", "Q61 Doenças císticas do rim", "Q62 Anomalias congênitas obstrutivas da pelve renal e malformações congênitas do ureter", "Q63 Outras malformações congênitas do rim", "Q64 Outras malformações congênitas do aparelho urinário", "Q65 Malformações congênitas do quadril", "Q65 Q79 Malformações e deformidades congênitas do sistema osteomuscular", "Q66 Deformidades congênitas do pé", "Q67 Deformidades osteomusculares congênitas da cabeça, da face, da coluna e do tórax", "Q68 Outras deformidades osteomusculares congênitas", "Q71 Defeitos, por redução, do membro superior", "Q72 Defeitos, por redução, do membro inferior", "Q73 Defeitos por redução de membro não especificado", "Q74 Outras malformações congênitas dos membros", "Q75 Outras malformações congênitas dos ossos do crânio e da face", "Q76 Malformações congênitas da coluna vertebral e dos ossos do tórax", "Q77 Osteocondrodisplasia com anomalias de crescimento dos ossos longos e da coluna vertebral", "Q78 Outras osteocondrodisplasias", "Q79 Malformações congênitas do sistema osteomuscular não classificadas em outra parte", "Q90 Síndrome de Down", "Q91 Síndrome de Edwards e síndrome de Patau", "Q91 Síndrome de Edwards e síndrome de Patau", "Q92 Outras trissomias e trissomias parciais dos autossomos, não classificadas em outra parte", "Q93 Monossomias e deleções dos autossomos, não classificadas em outra parte", "Q95 Rearranjos equilibrados e marcadores estruturais, não classificados em outra parte", "Q96 Síndrome de Turner" }));
        jcbDoencasCronicasAtendMedico.setEnabled(false);
        jcbDoencasCronicasAtendMedico.setMinimumSize(new java.awt.Dimension(3, 25));
        jcbDoencasCronicasAtendMedico.setPreferredSize(new java.awt.Dimension(3, 25));
        jpConsultaAtendMedico.add(jcbDoencasCronicasAtendMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 330, -1));

        jtpDiagnosticoAtendMedico.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jtpDiagnosticoAtendMedico.setEnabled(false);
        jScrollPane9.setViewportView(jtpDiagnosticoAtendMedico);

        jpConsultaAtendMedico.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 470, 190));

        jbAdcDoencaCronicaAtendMedico.setBackground(new java.awt.Color(255, 255, 255));
        jbAdcDoencaCronicaAtendMedico.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbAdcDoencaCronicaAtendMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/adicionar-36.png"))); // NOI18N
        jbAdcDoencaCronicaAtendMedico.setText("Adicionar");
        jbAdcDoencaCronicaAtendMedico.setToolTipText("Clique para inciar um novo cadastro");
        jbAdcDoencaCronicaAtendMedico.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jbAdcDoencaCronicaAtendMedico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbAdcDoencaCronicaAtendMedico.setEnabled(false);
        jbAdcDoencaCronicaAtendMedico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbAdcDoencaCronicaAtendMedico.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbAdcDoencaCronicaAtendMedico.setIconTextGap(8);
        jbAdcDoencaCronicaAtendMedico.setMaximumSize(new java.awt.Dimension(106, 45));
        jbAdcDoencaCronicaAtendMedico.setMinimumSize(new java.awt.Dimension(106, 45));
        jbAdcDoencaCronicaAtendMedico.setPreferredSize(new java.awt.Dimension(106, 45));
        jbAdcDoencaCronicaAtendMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdcDoencaCronicaAtendMedicoActionPerformed(evt);
            }
        });
        jpConsultaAtendMedico.add(jbAdcDoencaCronicaAtendMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 130, 40));

        jtfIDAtendMedico.setEditable(false);
        jtfIDAtendMedico.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfIDAtendMedico.setForeground(new java.awt.Color(255, 0, 51));
        jtfIDAtendMedico.setEnabled(false);
        jtfIDAtendMedico.setFocusable(false);
        jtfIDAtendMedico.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfIDAtendMedico.setPreferredSize(new java.awt.Dimension(3, 25));
        jpConsultaAtendMedico.add(jtfIDAtendMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 80, -1));

        jlIDAtendMedico.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlIDAtendMedico.setText("ID:");
        jpConsultaAtendMedico.add(jlIDAtendMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 20));

        jtfConsultasDiaAtendMedico.setEditable(false);
        jtfConsultasDiaAtendMedico.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfConsultasDiaAtendMedico.setEnabled(false);
        jtfConsultasDiaAtendMedico.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfConsultasDiaAtendMedico.setPreferredSize(new java.awt.Dimension(3, 25));
        jpConsultaAtendMedico.add(jtfConsultasDiaAtendMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 70, -1));

        jtfMatriculaMedicoAtendMedico.setEditable(false);
        jtfMatriculaMedicoAtendMedico.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtfMatriculaMedicoAtendMedico.setEnabled(false);
        jtfMatriculaMedicoAtendMedico.setMinimumSize(new java.awt.Dimension(3, 25));
        jtfMatriculaMedicoAtendMedico.setPreferredSize(new java.awt.Dimension(3, 25));
        jpConsultaAtendMedico.add(jtfMatriculaMedicoAtendMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 140, -1));

        jlConsultasDiaAtendMedico.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlConsultasDiaAtendMedico.setText("Matric. Profissional:");
        jpConsultaAtendMedico.add(jlConsultasDiaAtendMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, 20));

        jlConsultasDiaAtendMedico1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlConsultasDiaAtendMedico1.setText("Con. do dia:");
        jpConsultaAtendMedico.add(jlConsultasDiaAtendMedico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, 20));

        jlDataAtendMedico.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlDataAtendMedico.setText("Data:");
        jpConsultaAtendMedico.add(jlDataAtendMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, 20));

        jftDataAtendMedico.setEditable(false);
        jftDataAtendMedico.setForeground(new java.awt.Color(255, 0, 51));
        jftDataAtendMedico.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jftDataAtendMedico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jftDataAtendMedico.setEnabled(false);
        jftDataAtendMedico.setFocusable(false);
        jftDataAtendMedico.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jftDataAtendMedico.setMinimumSize(new java.awt.Dimension(3, 25));
        jftDataAtendMedico.setNextFocusableComponent(jbSalvarAgendamentos);
        jftDataAtendMedico.setPreferredSize(new java.awt.Dimension(3, 25));
        jpConsultaAtendMedico.add(jftDataAtendMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 150, -1));

        jpMedicosAtendimentos.add(jpConsultaAtendMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 490, 510));

        jpHistoricoPacienteAtendMedico.setBackground(new java.awt.Color(177, 201, 234));
        jpHistoricoPacienteAtendMedico.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")), "Histórico do Paciente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jpHistoricoPacienteAtendMedico.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtpHistoricoConsultaAtendMedico.setEditable(false);
        jtpHistoricoConsultaAtendMedico.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jtpHistoricoConsultaAtendMedico.setEnabled(false);
        jtpHistoricoConsultaAtendMedico.setFocusable(false);
        jScrollPane7.setViewportView(jtpHistoricoConsultaAtendMedico);

        jpHistoricoPacienteAtendMedico.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 470, 190));

        jlFiltrarAtendimentoAtendMedico.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlFiltrarAtendimentoAtendMedico.setText("Filtrar por Atendimento:");
        jpHistoricoPacienteAtendMedico.add(jlFiltrarAtendimentoAtendMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 20));

        jlHistoricoDoencasCronicasAtendMedico.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlHistoricoDoencasCronicasAtendMedico.setText("Histórico de Doenças Crônicas:");
        jpHistoricoPacienteAtendMedico.add(jlHistoricoDoencasCronicasAtendMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, 20));

        jlHistoricoConsultaAtendMedico.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jlHistoricoConsultaAtendMedico.setText("Diagnóstico da Consulta:");
        jpHistoricoPacienteAtendMedico.add(jlHistoricoConsultaAtendMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 20));

        jtpHistoricoDoencasCronicasAtendMedico.setEditable(false);
        jtpHistoricoDoencasCronicasAtendMedico.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jtpHistoricoDoencasCronicasAtendMedico.setEnabled(false);
        jtpHistoricoDoencasCronicasAtendMedico.setFocusable(false);
        jScrollPane8.setViewportView(jtpHistoricoDoencasCronicasAtendMedico);

        jpHistoricoPacienteAtendMedico.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 470, 190));

        jcbFiltrarAtendimentoAtendMedico.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbFiltrarAtendimentoAtendMedico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        jcbFiltrarAtendimentoAtendMedico.setEnabled(false);
        jcbFiltrarAtendimentoAtendMedico.setMinimumSize(new java.awt.Dimension(3, 25));
        jcbFiltrarAtendimentoAtendMedico.setPreferredSize(new java.awt.Dimension(3, 25));
        jcbFiltrarAtendimentoAtendMedico.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcbFiltrarAtendimentoAtendMedicoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jcbFiltrarAtendimentoAtendMedicoPopupMenuWillBecomeVisible(evt);
            }
        });
        jpHistoricoPacienteAtendMedico.add(jcbFiltrarAtendimentoAtendMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 470, -1));

        jpMedicosAtendimentos.add(jpHistoricoPacienteAtendMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 490, 510));

        jbNovoAtendMedico.setBackground(new java.awt.Color(255, 255, 255));
        jbNovoAtendMedico.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbNovoAtendMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/adicionar-36.png"))); // NOI18N
        jbNovoAtendMedico.setText("Novo");
        jbNovoAtendMedico.setToolTipText("Clique para inciar um novo cadastro");
        jbNovoAtendMedico.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jbNovoAtendMedico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbNovoAtendMedico.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbNovoAtendMedico.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbNovoAtendMedico.setIconTextGap(8);
        jbNovoAtendMedico.setMaximumSize(new java.awt.Dimension(106, 45));
        jbNovoAtendMedico.setMinimumSize(new java.awt.Dimension(106, 45));
        jbNovoAtendMedico.setPreferredSize(new java.awt.Dimension(106, 45));
        jbNovoAtendMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoAtendMedicoActionPerformed(evt);
            }
        });
        jpMedicosAtendimentos.add(jbNovoAtendMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 470, -1, -1));

        jpMenuPrincipal.add(jpMedicosAtendimentos, "card11");

        jpEnfermeirosAtendimentos.setBackground(new java.awt.Color(255, 153, 0));
        jpEnfermeirosAtendimentos.setMinimumSize(new java.awt.Dimension(1160, 627));
        jpEnfermeirosAtendimentos.setPreferredSize(new java.awt.Dimension(1160, 627));

        javax.swing.GroupLayout jpEnfermeirosAtendimentosLayout = new javax.swing.GroupLayout(jpEnfermeirosAtendimentos);
        jpEnfermeirosAtendimentos.setLayout(jpEnfermeirosAtendimentosLayout);
        jpEnfermeirosAtendimentosLayout.setHorizontalGroup(
            jpEnfermeirosAtendimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1160, Short.MAX_VALUE)
        );
        jpEnfermeirosAtendimentosLayout.setVerticalGroup(
            jpEnfermeirosAtendimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 654, Short.MAX_VALUE)
        );

        jpMenuPrincipal.add(jpEnfermeirosAtendimentos, "card12");

        jpLaborartoriosMenu.setBackground(new java.awt.Color(177, 201, 234));
        jpLaborartoriosMenu.setMinimumSize(new java.awt.Dimension(1160, 627));
        jpLaborartoriosMenu.setPreferredSize(new java.awt.Dimension(1160, 627));

        jbInserirResultadosLaboratorios.setBackground(new java.awt.Color(204, 204, 204));
        jbInserirResultadosLaboratorios.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jbInserirResultadosLaboratorios.setForeground(new java.awt.Color(255, 255, 255));
        jbInserirResultadosLaboratorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Novo-Resultado.png"))); // NOI18N
        jbInserirResultadosLaboratorios.setText("Inserir Resultados");
        jbInserirResultadosLaboratorios.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 43, 91), 2, true));
        jbInserirResultadosLaboratorios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbInserirResultadosLaboratorios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbInserirResultadosLaboratorios.setIconTextGap(-60);
        jbInserirResultadosLaboratorios.setMargin(new java.awt.Insets(2, 10, 2, 10));
        jbInserirResultadosLaboratorios.setMaximumSize(new java.awt.Dimension(570, 617));
        jbInserirResultadosLaboratorios.setMinimumSize(new java.awt.Dimension(570, 617));
        jbInserirResultadosLaboratorios.setPreferredSize(new java.awt.Dimension(570, 617));
        jbInserirResultadosLaboratorios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbInserirResultadosLaboratorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInserirResultadosLaboratoriosActionPerformed(evt);
            }
        });

        jbVerResultadosLaboratorios.setBackground(new java.awt.Color(204, 204, 204));
        jbVerResultadosLaboratorios.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jbVerResultadosLaboratorios.setForeground(new java.awt.Color(255, 255, 255));
        jbVerResultadosLaboratorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Resultados.png"))); // NOI18N
        jbVerResultadosLaboratorios.setText("Ver Resultados");
        jbVerResultadosLaboratorios.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 43, 91), 2, true));
        jbVerResultadosLaboratorios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbVerResultadosLaboratorios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbVerResultadosLaboratorios.setIconTextGap(-60);
        jbVerResultadosLaboratorios.setMargin(new java.awt.Insets(2, 10, 2, 10));
        jbVerResultadosLaboratorios.setMaximumSize(new java.awt.Dimension(570, 617));
        jbVerResultadosLaboratorios.setMinimumSize(new java.awt.Dimension(570, 617));
        jbVerResultadosLaboratorios.setPreferredSize(new java.awt.Dimension(570, 617));
        jbVerResultadosLaboratorios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbVerResultadosLaboratorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVerResultadosLaboratoriosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpLaborartoriosMenuLayout = new javax.swing.GroupLayout(jpLaborartoriosMenu);
        jpLaborartoriosMenu.setLayout(jpLaborartoriosMenuLayout);
        jpLaborartoriosMenuLayout.setHorizontalGroup(
            jpLaborartoriosMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLaborartoriosMenuLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jbInserirResultadosLaboratorios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jbVerResultadosLaboratorios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jpLaborartoriosMenuLayout.setVerticalGroup(
            jpLaborartoriosMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpLaborartoriosMenuLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jpLaborartoriosMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbVerResultadosLaboratorios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbInserirResultadosLaboratorios, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        jpMenuPrincipal.add(jpLaborartoriosMenu, "card13");

        jpInserirResultadosLaboratorios.setBackground(new java.awt.Color(0, 153, 153));
        jpInserirResultadosLaboratorios.setMinimumSize(new java.awt.Dimension(1160, 627));
        jpInserirResultadosLaboratorios.setPreferredSize(new java.awt.Dimension(1160, 627));

        javax.swing.GroupLayout jpInserirResultadosLaboratoriosLayout = new javax.swing.GroupLayout(jpInserirResultadosLaboratorios);
        jpInserirResultadosLaboratorios.setLayout(jpInserirResultadosLaboratoriosLayout);
        jpInserirResultadosLaboratoriosLayout.setHorizontalGroup(
            jpInserirResultadosLaboratoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1160, Short.MAX_VALUE)
        );
        jpInserirResultadosLaboratoriosLayout.setVerticalGroup(
            jpInserirResultadosLaboratoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 654, Short.MAX_VALUE)
        );

        jpMenuPrincipal.add(jpInserirResultadosLaboratorios, "card14");

        jpVerResultadosLaboratorios.setBackground(new java.awt.Color(51, 0, 51));
        jpVerResultadosLaboratorios.setMinimumSize(new java.awt.Dimension(1160, 627));
        jpVerResultadosLaboratorios.setPreferredSize(new java.awt.Dimension(1160, 627));

        javax.swing.GroupLayout jpVerResultadosLaboratoriosLayout = new javax.swing.GroupLayout(jpVerResultadosLaboratorios);
        jpVerResultadosLaboratorios.setLayout(jpVerResultadosLaboratoriosLayout);
        jpVerResultadosLaboratoriosLayout.setHorizontalGroup(
            jpVerResultadosLaboratoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1160, Short.MAX_VALUE)
        );
        jpVerResultadosLaboratoriosLayout.setVerticalGroup(
            jpVerResultadosLaboratoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 654, Short.MAX_VALUE)
        );

        jpMenuPrincipal.add(jpVerResultadosLaboratorios, "card15");

        jpFinanceiroMenu.setBackground(new java.awt.Color(177, 201, 234));
        jpFinanceiroMenu.setMinimumSize(new java.awt.Dimension(1160, 627));
        jpFinanceiroMenu.setPreferredSize(new java.awt.Dimension(1160, 627));

        jbRecebimentosFinanceiro.setBackground(new java.awt.Color(204, 204, 204));
        jbRecebimentosFinanceiro.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jbRecebimentosFinanceiro.setForeground(new java.awt.Color(255, 255, 255));
        jbRecebimentosFinanceiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Recebimentos.png"))); // NOI18N
        jbRecebimentosFinanceiro.setText("Recebimentos");
        jbRecebimentosFinanceiro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 43, 91), 2, true));
        jbRecebimentosFinanceiro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbRecebimentosFinanceiro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbRecebimentosFinanceiro.setIconTextGap(-65);
        jbRecebimentosFinanceiro.setMargin(new java.awt.Insets(2, 10, 2, 10));
        jbRecebimentosFinanceiro.setMaximumSize(new java.awt.Dimension(570, 617));
        jbRecebimentosFinanceiro.setMinimumSize(new java.awt.Dimension(570, 617));
        jbRecebimentosFinanceiro.setPreferredSize(new java.awt.Dimension(570, 617));
        jbRecebimentosFinanceiro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbRecebimentosFinanceiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRecebimentosFinanceiroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpFinanceiroMenuLayout = new javax.swing.GroupLayout(jpFinanceiroMenu);
        jpFinanceiroMenu.setLayout(jpFinanceiroMenuLayout);
        jpFinanceiroMenuLayout.setHorizontalGroup(
            jpFinanceiroMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFinanceiroMenuLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jbRecebimentosFinanceiro, javax.swing.GroupLayout.DEFAULT_SIZE, 1150, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        jpFinanceiroMenuLayout.setVerticalGroup(
            jpFinanceiroMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFinanceiroMenuLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jbRecebimentosFinanceiro, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        jpMenuPrincipal.add(jpFinanceiroMenu, "card16");

        jpRecebimentosFinanceiro.setBackground(new java.awt.Color(153, 0, 0));
        jpRecebimentosFinanceiro.setMinimumSize(new java.awt.Dimension(1160, 627));
        jpRecebimentosFinanceiro.setPreferredSize(new java.awt.Dimension(1160, 627));

        javax.swing.GroupLayout jpRecebimentosFinanceiroLayout = new javax.swing.GroupLayout(jpRecebimentosFinanceiro);
        jpRecebimentosFinanceiro.setLayout(jpRecebimentosFinanceiroLayout);
        jpRecebimentosFinanceiroLayout.setHorizontalGroup(
            jpRecebimentosFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1160, Short.MAX_VALUE)
        );
        jpRecebimentosFinanceiroLayout.setVerticalGroup(
            jpRecebimentosFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 654, Short.MAX_VALUE)
        );

        jpMenuPrincipal.add(jpRecebimentosFinanceiro, "card17");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpColunaBotoesMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpMenuPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpNomeMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpColunaBotoesMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpNomeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpMenuPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    //-----+++++++++++++++++++++++=========== OPÇÕES DE REGISTROS =============+++++++++++++++++-----
    //Botão Registros > (Menu)
    private void jbRegistrosMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegistrosMenuActionPerformed
        if(evt.getSource() == jbRegistrosMenu)
        {            
            eventosPadraoBotoesMenu(jpRegistrosMenu, "Registros", jbRegistrosMenu, jlSetaRegistros);
        }
    }//GEN-LAST:event_jbRegistrosMenuActionPerformed

    //Botão Pacientes > (Registros)
    private void jbPacientesRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPacientesRegistrosActionPerformed
        if(evt.getSource() == jbPacientesRegistros){
            padraoFormsVisibleFalse();
            jpPacientesRegistros.setVisible(true);
            jlNomeMenu.setText("Registros | Pacientes");
            listarPacientesTabela();
        }
    }//GEN-LAST:event_jbPacientesRegistrosActionPerformed
    
    //Botão Funcionários > (Registros)
    private void jbFuncionariosRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFuncionariosRegistrosActionPerformed
        if(evt.getSource() == jbFuncionariosRegistros){
            padraoFormsVisibleFalse();
            jpFuncionariosRegistros.setVisible(true);
            jlNomeMenu.setText("Registros | Funcionários");
            listarFuncionariosTabela();
        }
    }//GEN-LAST:event_jbFuncionariosRegistrosActionPerformed

    //-----+++++++++++++++++++++++=========== OPÇÕES DE AGENDAMENTOS =============+++++++++++++++++-----
    //Botão Agendamentos > (Menu)
    private void jbAgendamentosMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgendamentosMenuActionPerformed
        if(evt.getSource() == jbAgendamentosMenu)
        {            
            eventosPadraoBotoesMenu(jpAgendamentosMenu, "Agendamentos", jbAgendamentosMenu, jlSetaAgendamentos);
        }
    }//GEN-LAST:event_jbAgendamentosMenuActionPerformed

    //Botão Consultas > (Agendamentos)
    private void jbConsultasAgendamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConsultasAgendamentosActionPerformed
        if(evt.getSource() == jbConsultasAgendamentos){
            padraoFormsVisibleFalse();
            jpAgendamentos.setVisible(true);
            jlNomeMenu.setText("Agendamentos | Consultas");
            jlNomeTelaAgendamentos.setText("Agendamento de Consultas");
            listarAgendamentosTabela();
        }
    }//GEN-LAST:event_jbConsultasAgendamentosActionPerformed
    
    //Botão Exames > (Agendamentos)
    private void jbExamesAgendamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExamesAgendamentosActionPerformed
        if(evt.getSource() == jbExamesAgendamentos){
            padraoFormsVisibleFalse();
            jpAgendamentos.setVisible(true);
            jlNomeMenu.setText("Agendamentos | Exames");
            jlNomeTelaAgendamentos.setText("Agendamento de Exames");
            listarAgendamentosTabela();

        }
    }//GEN-LAST:event_jbExamesAgendamentosActionPerformed
    
    //Botão Vacinas > (Agendamentos)
    private void jbVacinasAgendamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVacinasAgendamentosActionPerformed
       if(evt.getSource() == jbVacinasAgendamentos){
            padraoFormsVisibleFalse();
            jpAgendamentos.setVisible(true);
            jlNomeMenu.setText("Agendamentos | Vacinas");
            jlNomeTelaAgendamentos.setText("Agendamento de Vacinas");
            listarAgendamentosTabela();
        }
    }//GEN-LAST:event_jbVacinasAgendamentosActionPerformed
    
    //-----+++++++++++++++++++++++=========== OPÇÕES DE ATENDIMENTOS =============+++++++++++++++++-----
    //Botão Atendimentos > (Menu)
    private void jbAtendimentosMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtendimentosMenuActionPerformed
       if(evt.getSource() == jbAtendimentosMenu){            
            eventosPadraoBotoesMenu(jpAtendimentosMenu, "Atendimentos", jbAtendimentosMenu, jlSetaAtendimentos);
        }
    }//GEN-LAST:event_jbAtendimentosMenuActionPerformed

    //Botão Médicos > (Atendimentos)
    private void jbMedicosAtendimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMedicosAtendimentosActionPerformed
        if(evt.getSource() == jbMedicosAtendimentos){
            padraoFormsVisibleFalse();
            jpMedicosAtendimentos.setVisible(true);
            jlNomeMenu.setText("Atendimentos | Médicos");
            
        }
    }//GEN-LAST:event_jbMedicosAtendimentosActionPerformed

    //Botão Enfermeiro > (Atendimentos)
    private void jbEnfermeirosAtendimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEnfermeirosAtendimentosActionPerformed
        if(evt.getSource() == jbEnfermeirosAtendimentos){
            padraoFormsVisibleFalse();
            jpEnfermeirosAtendimentos.setVisible(true);
            jlNomeMenu.setText("Atendimentos | Enfermeiros");
        }
    }//GEN-LAST:event_jbEnfermeirosAtendimentosActionPerformed

    //-----+++++++++++++++++++++++=========== OPÇÕES DE LABORATÓRIOS =============+++++++++++++++++-----
    //Botão Laboratórios > (Menu)
    private void jbLaboratorioMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLaboratorioMenuActionPerformed
        if(evt.getSource() == jbLaboratorioMenu)
        {            
            eventosPadraoBotoesMenu(jpLaborartoriosMenu, "Laboratório", jbLaboratorioMenu, jlSetaLaboratorios);
        }
    }//GEN-LAST:event_jbLaboratorioMenuActionPerformed
    
    //Botão Novo Resultado > (Laboratórios)
    private void jbInserirResultadosLaboratoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInserirResultadosLaboratoriosActionPerformed
        if(evt.getSource() == jbInserirResultadosLaboratorios){
            padraoFormsVisibleFalse();
            jpInserirResultadosLaboratorios.setVisible(true);
            jlNomeMenu.setText("Laboratório | Inserir Resultados");
        }
    }//GEN-LAST:event_jbInserirResultadosLaboratoriosActionPerformed
    
    //Botão Ver Resultados > (Laboratórios)
    private void jbVerResultadosLaboratoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVerResultadosLaboratoriosActionPerformed
        if(evt.getSource() == jbVerResultadosLaboratorios){
            padraoFormsVisibleFalse();
            jpVerResultadosLaboratorios.setVisible(true);
            jlNomeMenu.setText("Laboratório | Imprimir Resultados");
        }
    }//GEN-LAST:event_jbVerResultadosLaboratoriosActionPerformed

    //-----+++++++++++++++++++++++=========== OPÇÕES DE FINANCEIRO =============+++++++++++++++++-----
    //Botão Finaceiro > (Menu)
    private void jbFinanceiroMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFinanceiroMenuActionPerformed
        if(evt.getSource() == jbFinanceiroMenu)
        {            
            eventosPadraoBotoesMenu(jpFinanceiroMenu, "Financeiro", jbFinanceiroMenu, jlSetaFinanceiro);
        }
    }//GEN-LAST:event_jbFinanceiroMenuActionPerformed
    
    //Botão Recebimentos > (Financeiro)
    private void jbRecebimentosFinanceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRecebimentosFinanceiroActionPerformed
        if(evt.getSource() == jbRecebimentosFinanceiro){
            padraoFormsVisibleFalse();
            jpRecebimentosFinanceiro.setVisible(true);
            jlNomeMenu.setText("Financeiro | Recebimentos");
        }
    }//GEN-LAST:event_jbRecebimentosFinanceiroActionPerformed
    
    //-----+++++++++++++++++++++++=========== BOTÃO NOME DO PANEL =============+++++++++++++++++-----
    //Dar foco no menu anterior.
    private void jlNomeMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlNomeMenuMouseClicked
        
        if(! (jlNomeMenu.getText().equals("Agendamentos") || jlNomeMenu.getText().equals("Atendimentos") 
          || jlNomeMenu.getText().equals("Laboratório") || jlNomeMenu.getText().equals("Registros")
          || jlNomeMenu.getText().equals("Financeiro")))
        {
            jbSairMenu.doClick();
        }
    }//GEN-LAST:event_jlNomeMenuMouseClicked

    //-----+++++++++++++++++++++++=========== OPÇÕES DO JFRAME =============+++++++++++++++++-----
    //Botão Minimizar
    private void jbMinimizarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMinimizarMenuActionPerformed
       this.setExtendedState(Menu.ICONIFIED);
    }//GEN-LAST:event_jbMinimizarMenuActionPerformed
    
    //Botão Fechar
    private void jbFecharMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharMenuActionPerformed
        this.dispose();
        login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_jbFecharMenuActionPerformed
    
    //Botão Voltar / Sair > (Menu).
    private void jbSairMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairMenuActionPerformed
        if(! jlNomeMenu.getText().equals("Menu Principal"))
        {
            if(jlNomeMenu.getText().contains("Pacientes") || jlNomeMenu.getText().contains("Funcionários"))
            {
                jbRegistrosMenu.doClick();
            }
            else if(jlNomeMenu.getText().contains("Consultas") || jlNomeMenu.getText().contains("Exames") || jlNomeMenu.getText().contains("Vacinas"))
            {
                jbAgendamentosMenu.doClick();
            }
            else if(jlNomeMenu.getText().contains("Médicos") || jlNomeMenu.getText().contains("Enfermeiros"))
            {
                jbAtendimentosMenu.doClick();
            }
            else if(jlNomeMenu.getText().contains("Inserir Resultados") || jlNomeMenu.getText().contains("Imprimir Resultados"))
            {
                jbLaboratorioMenu.doClick();
            }
            else if(jlNomeMenu.getText().contains("Recebimentos"))
            {
                jbFinanceiroMenu.doClick();
            }
            else if (jlNomeMenu.getText().equals("Agendamentos") || jlNomeMenu.getText().equals("Atendimentos") 
                   || jlNomeMenu.getText().equals("Laboratório") || jlNomeMenu.getText().equals("Registros")
                   || jlNomeMenu.getText().equals("Financeiro"))
            {
                padraoFormsVisibleFalse();
                padraoBotoesMenu(listaBotoesMenu);
                padraoCorSetas(listaSetasMenu);
                jpMenuPrincipal.setVisible(true);
                jlNomeMenu.setText("Menu Principal");
                jbSairMenu.setIcon(new ImageIcon(getClass().getResource("/View/Images/sair-48.png")));
                jbSairMenu.setRolloverEnabled(true);
                jbSairMenu.setText("Sair");
                jbSairMenu.setToolTipText("Clique para Sair do programa");
            }
        }
        else{
            this.dispose();
            login = new Login();
            login.setVisible(true);
        }
    }//GEN-LAST:event_jbSairMenuActionPerformed

    //-----+++++++++++++++++++++++=========== OPÇÕES DE REGISTROS > PACIENTES =============+++++++++++++++++-----
    //Códigos gerados quando da foco no Panel Registros > (Pacientes).
    private void jpPacientesRegistrosComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jpPacientesRegistrosComponentShown
        jftCadastradoDesdePacientes.setText(jlDataAtualMenu.getText());
    }//GEN-LAST:event_jpPacientesRegistrosComponentShown
        
    //-----+++++++++++++++++++++++=========== GERAR ENDEREÇO PELO CEP > PACIENTES =============+++++++++++++++++-----
    //Códigos gerados quando da o campo cep for preenchido > (Pacientes).
    private void jftCepPacientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jftCepPacientesKeyReleased
        cepWebService = new CepWebService(jftCepPacientes.getText());
        jtfTipoLogradouroPacientes.setText(cepWebService.getTipo_logradouro());
        jtfLogradouroPacientes.setText(cepWebService.getLogradouro());
        jtfUFPacientes.setText(cepWebService.getEstado());
        jtfCidadePacientes.setText(cepWebService.getCidade());
        jtfBairroPacientes.setText(cepWebService.getBairro());
    }//GEN-LAST:event_jftCepPacientesKeyReleased
    
    //Códigos gerados quando da o campo cep for preenchido > (Funcionários).
    private void jftCepFuncionariosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jftCepFuncionariosKeyReleased
        cepWebService = new CepWebService(jftCepFuncionarios.getText());
        jtfTipoLogradouroFuncionarios.setText(cepWebService.getTipo_logradouro());
        jtfLogradouroFuncionarios.setText(cepWebService.getLogradouro());
        jtfUFFuncionarios.setText(cepWebService.getEstado());
        jtfCidadeFuncionarios.setText(cepWebService.getCidade());
        jtfBairroFuncionarios.setText(cepWebService.getBairro());
    }//GEN-LAST:event_jftCepFuncionariosKeyReleased
    
    //-----+++++++++++++++++++++++=========== PACIENTES =============+++++++++++++++++-----
    //Preenche os Pacientes do BD na tabela de Pacientes.
    private void listarPacientesTabela(){
        listaPacientes.clear();
        listaPacientes = controllerPacientes.getListaPacientesController();
        DefaultTableModel tabelaPacientesModel = (DefaultTableModel) jtListaPacientes.getModel();
        tabelaPacientesModel.setNumRows(0);
        
        for (int i = 0; i < listaPacientes.size(); i++) {
            tabelaPacientesModel.addRow(new Object[]{
                listaPacientes.get(i).getId_paciente(),
                listaPacientes.get(i).getNome(),
                listaPacientes.get(i).getSexo(),
                listaPacientes.get(i).getDt_nascimento(),
                listaPacientes.get(i).getEstado_civil(),
                listaPacientes.get(i).getCpf(),
                listaPacientes.get(i).getRg(),
                listaPacientes.get(i).getNacionalidade(),
                listaPacientes.get(i).getNaturalidade(),
                listaPacientes.get(i).getTel_fixo(),
                listaPacientes.get(i).getTel_celular(),
                listaPacientes.get(i).getTel_contato(),
                listaPacientes.get(i).getEmail(),
                listaPacientes.get(i).getCep(),
                listaPacientes.get(i).getUf(),
                listaPacientes.get(i).getCidade(),
                listaPacientes.get(i).getBairro(),
                listaPacientes.get(i).getTipoLogradouro(),
                listaPacientes.get(i).getLogradouro(),
                listaPacientes.get(i).getNumeroCasa(),
                listaPacientes.get(i).getComplemento(),
                listaPacientes.get(i).getDt_cliente_desde()
            });
        }
    }
    
    //Limpar Formulario Pacientes.
    private void limparFormularioPacientes(){
        jtfIDPacientes.setText("");
        jtfNomePacientes.setText("");
        jcbSexoPacientes.setSelectedIndex(0);
        jdcDataNascPacientes.setDate(null);
        jcbEstadoCivilPacientes.setSelectedIndex(0);
        jftCPFPacientes.setText("");
        jftRGPacientes.setText("");
        jtfOrgaoExpedidorPacientes.setText("");
        jcbNacionalidadePacientes.setSelectedIndex(0);
        jcbNaturalidadePacientes.setSelectedIndex(0);
        jftTelefoneFixoPacientes.setText("");
        jftCelularPacientes.setText("");
        jftTelefoneRecadoPacientes.setText("");
        jtfEmailPacientes.setText("");
        jftCepPacientes.setText("");
        jtfUFPacientes.setText("");
        jtfCidadePacientes.setText("");
        jtfBairroPacientes.setText("");
        jtfTipoLogradouroPacientes.setText("");
        jtfLogradouroPacientes.setText("");
        jtfNumeroCasaPacientes.setText("");
        jtfComplementoPacientes.setText("");
        jftCadastradoDesdePacientes.setText(jlDataAtualMenu.getText());
        
        jtfPesquisarPacientes.setText("");
        jcbFiltrarPacientes.setSelectedIndex(0);
        
        jbSalvarPacientes.setText("<html>Salvar");
        jbSalvarPacientes.setFont(new java.awt.Font("Dialog", 1, 14));
        jbNovoPacientes.requestFocus();
    }
    
    //Ativar Campos Pacientes.
    private void ativarCamposPacientes(Boolean AtvInat){
        jtfNomePacientes.setEnabled(AtvInat);
        jcbSexoPacientes.setEnabled(AtvInat);
        jdcDataNascPacientes.setEnabled(AtvInat);
        jcbEstadoCivilPacientes.setEnabled(AtvInat);
        jftCPFPacientes.setEnabled(AtvInat);
        jftRGPacientes.setEnabled(AtvInat);
        jtfOrgaoExpedidorPacientes.setEnabled(AtvInat);
        jcbNacionalidadePacientes.setEnabled(AtvInat);
        jcbNaturalidadePacientes.setEnabled(AtvInat);
        jftTelefoneFixoPacientes.setEnabled(AtvInat);
        jftCelularPacientes.setEnabled(AtvInat);
        jftTelefoneRecadoPacientes.setEnabled(AtvInat);
        jtfEmailPacientes.setEnabled(AtvInat);
        jftCepPacientes.setEnabled(AtvInat);
        jtfUFPacientes.setEnabled(AtvInat);
        jtfCidadePacientes.setEnabled(AtvInat);
        jtfBairroPacientes.setEnabled(AtvInat);
        jtfTipoLogradouroPacientes.setEnabled(AtvInat);
        jtfLogradouroPacientes.setEnabled(AtvInat);
        jtfNumeroCasaPacientes.setEnabled(AtvInat);
        jtfComplementoPacientes.setEnabled(AtvInat);
        jftCadastradoDesdePacientes.setEnabled(AtvInat);
        jbSalvarPacientes.setEnabled(AtvInat);
        jbSalvarPacientes.setEnabled(AtvInat);
        jtfNomePacientes.setEnabled(AtvInat);
    }
    
    //Realiza uma pesquisa de Pacientes do BD e Preenche a tabela do View Pacientes.
    private void pesquisarListarPacientesTabela(String pesquisa, String localPesquisa){
        listaPacientes.clear();
        listaPacientes = controllerPacientes.pesquisarPacienteController(pesquisa, localPesquisa);
        
        if(listaPacientes.isEmpty())
        {
            //Erro ao localizar busca.
            JOptionPane.showMessageDialog(this, "Sua pesquisa \"" + pesquisa + "\" não encontrou nenhum paciente com este\"" + localPesquisa.toLowerCase() + "\" ", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            DefaultTableModel tabelaPacientesModel = (DefaultTableModel) jtListaPacientes.getModel();
            tabelaPacientesModel.setNumRows(0);

            for (int i = 0; i < listaPacientes.size(); i++) {
                tabelaPacientesModel.addRow(new Object[]{
                    listaPacientes.get(i).getId_paciente(),
                    listaPacientes.get(i).getNome(),
                    listaPacientes.get(i).getSexo(),
                    listaPacientes.get(i).getDt_nascimento(),
                    listaPacientes.get(i).getEstado_civil(),
                    listaPacientes.get(i).getCpf(),
                    listaPacientes.get(i).getRg(),
                    listaPacientes.get(i).getNacionalidade(),
                    listaPacientes.get(i).getNaturalidade(),
                    listaPacientes.get(i).getTel_fixo(),
                    listaPacientes.get(i).getTel_celular(),
                    listaPacientes.get(i).getTel_contato(),
                    listaPacientes.get(i).getEmail(),
                    listaPacientes.get(i).getCep(),
                    listaPacientes.get(i).getUf(),
                    listaPacientes.get(i).getCidade(),
                    listaPacientes.get(i).getBairro(),
                    listaPacientes.get(i).getTipoLogradouro(),
                    listaPacientes.get(i).getLogradouro(),
                    listaPacientes.get(i).getNumeroCasa(),
                    listaPacientes.get(i).getComplemento(),
                    listaPacientes.get(i).getDt_cliente_desde()
                });
            }
            
        }
    }

    //Salvar/Atualizar novo Paciente.
    private void jbSalvarPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarPacientesActionPerformed
        modelPacientes = new ModelPacientes();

        modelPacientes.setId_paciente(Integer.parseInt(jtfIDPacientes.getText()));
        modelPacientes.setNome(jtfNomePacientes.getText());
        modelPacientes.setSexo(jcbSexoPacientes.getSelectedItem().toString());
        SimpleDateFormat dataFormatada = new SimpleDateFormat("d 'de' MMM 'de' y");
        modelPacientes.setDt_nascimento(dataFormatada.format(jdcDataNascPacientes.getDate()));
        modelPacientes.setEstado_civil(jcbEstadoCivilPacientes.getSelectedItem().toString());
        modelPacientes.setCpf(jftCPFPacientes.getText());
        modelPacientes.setRg(jftRGPacientes.getText());
        modelPacientes.setOrgao_exp(jtfOrgaoExpedidorPacientes.getText());
        modelPacientes.setNacionalidade(jcbNacionalidadePacientes.getSelectedItem().toString());
        modelPacientes.setNaturalidade(jcbNaturalidadePacientes.getSelectedItem().toString());
        modelPacientes.setTel_fixo(jftTelefoneFixoPacientes.getText());
        modelPacientes.setTel_celular(jftCelularPacientes.getText());
        modelPacientes.setTel_contato(jftTelefoneRecadoPacientes.getText());
        modelPacientes.setEmail(jtfEmailPacientes.getText());
        modelPacientes.setCep(jftCepPacientes.getText());
        modelPacientes.setUf(jtfUFPacientes.getText());
        modelPacientes.setCidade(jtfCidadePacientes.getText());
        modelPacientes.setBairro(jtfBairroPacientes.getText());
        modelPacientes.setTipoLogradouro(jtfTipoLogradouroPacientes.getText());
        modelPacientes.setLogradouro(jtfLogradouroPacientes.getText());
        modelPacientes.setNumeroCasa(Integer.parseInt(jtfNumeroCasaPacientes.getText()));
        modelPacientes.setComplemento(jtfComplementoPacientes.getText());
        modelPacientes.setDt_cliente_desde(jftCadastradoDesdePacientes.getText());
        
        if(cadastrarAlterarPacientes.equals("cad"))
        {  

            if(controllerPacientes.salvarPacientesController(modelPacientes))
            {   //Produto cadastrado com sucesso.
                JOptionPane.showMessageDialog(this, "Paciente cadastrado com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                jtfNomePacientes.requestFocus();
                listarPacientesTabela();
                limparFormularioPacientes();
            }
            else 
            {   //Erro ao cadastrar Produto.
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar Paciente!", "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {   
            int dialogResult = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja salvar as alterações?", "Atenção!", JOptionPane.YES_NO_OPTION);
            if(dialogResult == 0) 
            {
                modelPacientes.setId_paciente(Integer.parseInt(jtfIDPacientes.getText()));
                //Alterar Paciente.
                if(controllerPacientes.atualizarPacientesController(modelPacientes))
                {   //Paciente alterado com sucesso.
                    JOptionPane.showMessageDialog(this, "Paciente atualizado com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                    jtfNomePacientes.requestFocus();
                    listarPacientesTabela();
                    ativarCamposPacientes(false);
                }
                else 
                {   //Erro ao alterar Paciente.
                    JOptionPane.showMessageDialog(this, "Erro ao alterar Paciente!", "Erro!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jbSalvarPacientesActionPerformed
    
    //Adicionar novo Paciente.
    private void jbNovoPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoPacientesActionPerformed
       jtfIDPacientes.setText((String.valueOf(controllerPacientes.retornarProximoIDPacientes())));
       ativarCamposPacientes(true);
       jtfNomePacientes.requestFocus();
    }//GEN-LAST:event_jbNovoPacientesActionPerformed
    
    //Editar Paciente.
    private void jbEditarPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarPacientesActionPerformed
        cadastrarAlterarPacientes = "alt";
        modelPacientes = new ModelPacientes();
        int linha = jtListaPacientes.getSelectedRow();
        if(linha < 0)
        {
            JOptionPane.showMessageDialog(this, "Nenhum paciente foi selecionado!", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        else
        {   
            int codigo = (int) jtListaPacientes.getValueAt(linha, 0);
            modelPacientes = controllerPacientes.getPacientesController(codigo);
            
            jtfIDPacientes.setText(String.valueOf(modelPacientes.getId_paciente()));
            jtfNomePacientes.setText(modelPacientes.getNome());
            jcbSexoPacientes.setSelectedItem(modelPacientes.getSexo());
            try {
                jdcDataNascPacientes.setDate(new SimpleDateFormat("d 'de' MMM 'de' y").parse(modelPacientes.getDt_nascimento()));
            } catch (ParseException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            jcbEstadoCivilPacientes.setSelectedItem(modelPacientes.getEstado_civil());
            jftCPFPacientes.setText(modelPacientes.getCpf());
            jftRGPacientes.setText(modelPacientes.getRg());
            jtfOrgaoExpedidorPacientes.setText(modelPacientes.getOrgao_exp());
            jcbNacionalidadePacientes.setSelectedItem(modelPacientes.getNacionalidade());
            jcbNaturalidadePacientes.setSelectedItem(modelPacientes.getNaturalidade());
            jftTelefoneFixoPacientes.setText(modelPacientes.getTel_fixo());
            jftCelularPacientes.setText(modelPacientes.getTel_celular());
            jftTelefoneRecadoPacientes.setText(modelPacientes.getTel_contato());
            jtfEmailPacientes.setText(modelPacientes.getEmail());
            jftCepPacientes.setText(modelPacientes.getCep());
            jtfUFPacientes.setText(modelPacientes.getUf());
            jtfCidadePacientes.setText(modelPacientes.getCidade());
            jtfBairroPacientes.setText(modelPacientes.getBairro());
            jtfTipoLogradouroPacientes.setText(modelPacientes.getTipoLogradouro());
            jtfLogradouroPacientes.setText(modelPacientes.getLogradouro());
            jtfNumeroCasaPacientes.setText(String.valueOf(modelPacientes.getNumeroCasa()));
            jtfComplementoPacientes.setText(modelPacientes.getComplemento());
            jftCadastradoDesdePacientes.setText(modelPacientes.getDt_cliente_desde());
            jbSalvarPacientes.setText("<html>Atualizar");
            jbSalvarPacientes.setFont(new java.awt.Font("Dialog", 1, 12));
            ativarCamposPacientes(true);
        }
    }//GEN-LAST:event_jbEditarPacientesActionPerformed
    
    //Excluir Paciente.
    private void jbExlcuirPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExlcuirPacientesActionPerformed
        int linha = jtListaPacientes.getSelectedRow();
        if(linha < 0)
        {
            JOptionPane.showMessageDialog(this, "Nenhum paciente foi selecionado!", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        else
        {   
            int dialogResult = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir este paciente?", "Atenção!", JOptionPane.YES_NO_OPTION);
            if(dialogResult == 0) 
            {
                int codigo = (int) jtListaPacientes.getValueAt(linha, 0);
                if(controllerPacientes.excluirPacientesController(codigo))
                {
                    listarPacientesTabela();
                    jtfNomePacientes.requestFocus();
                    JOptionPane.showMessageDialog(this, "Paciente excluído com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Erro ao excluir paciente!", "Erro!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jbExlcuirPacientesActionPerformed
    
    //Limpar Paciente.
    private void jbLimparTelaPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparTelaPacientesActionPerformed
       limparFormularioPacientes();
       ativarCamposPacientes(false);
    }//GEN-LAST:event_jbLimparTelaPacientesActionPerformed

    //Procurar Paciente.
    private void jbProcurarPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProcurarPacientesActionPerformed
        pesquisarListarPacientesTabela(jtfPesquisarPacientes.getText(), jcbFiltrarPacientes.getSelectedItem().toString());
    }//GEN-LAST:event_jbProcurarPacientesActionPerformed

    
    
    //-----+++++++++++++++++++++++=========== FUNCIONÁRIOS =============+++++++++++++++++-----
    //Preenche os Pacientes do BD na tabela de Funcionarios.
    private void listarFuncionariosTabela(){
        listaFuncionarios.clear();
        listaFuncionarios = controllerFuncionarios.getListaFuncionariosController();
        DefaultTableModel tabelaFuncionariosModel = (DefaultTableModel) jtListaFuncionarios.getModel();
        tabelaFuncionariosModel.setNumRows(0);
        
        for (int i = 0; i < listaFuncionarios.size(); i++) {
            tabelaFuncionariosModel.addRow(new Object[]{
                listaFuncionarios.get(i).getId_funcionarios(),
                listaFuncionarios.get(i).getNome(),
                listaFuncionarios.get(i).getSexo(),
                listaFuncionarios.get(i).getDt_nascimento(),
                listaFuncionarios.get(i).getEstado_civil(),
                listaFuncionarios.get(i).getCpf(),
                listaFuncionarios.get(i).getRg(),
                listaFuncionarios.get(i).getNacionalidade(),
                listaFuncionarios.get(i).getNaturalidade(),
                listaFuncionarios.get(i).getTel_fixo(),
                listaFuncionarios.get(i).getTel_celular(),
                listaFuncionarios.get(i).getTel_contato(),
                listaFuncionarios.get(i).getEmail(),
                listaFuncionarios.get(i).getCep(),
                listaFuncionarios.get(i).getUf(),
                listaFuncionarios.get(i).getCidade(),
                listaFuncionarios.get(i).getBairro(),
                listaFuncionarios.get(i).getTipoLogradouro(),
                listaFuncionarios.get(i).getLogradouro(),
                listaFuncionarios.get(i).getNumeroCasa(),
                listaFuncionarios.get(i).getComplemento(),
                listaFuncionarios.get(i).getSetor(),
                listaFuncionarios.get(i).getFuncao(),
                listaFuncionarios.get(i).getMatricula(),
                listaFuncionarios.get(i).getData_adm(),
                listaFuncionarios.get(i).getData_dem(),
                listaFuncionarios.get(i).getCtps(),
                listaFuncionarios.get(i).getSerie_uf(),
                listaFuncionarios.get(i).getPis(),
                listaFuncionarios.get(i).getDt_funcionario_desde()
            });
        }
    }
    
    //Limpar Formulario Pacientes.
    private void limparFormularioFuncionarios(){
        jtfIDFuncionarios.setText("");
        jtfNomeFuncionarios.setText("");
        jcbSexoFuncionarios.setSelectedIndex(0);
        jdcDataNascFuncionarios.setDate(null);
        jcbEstadoCivilFuncionarios.setSelectedIndex(0);
        jftCPFFuncionarios.setText("");
        jftRGFuncionarios.setText("");
        jtfOrgaoExpedFuncionarios.setText("");
        jcbNacionalidadeFuncionarios.setSelectedIndex(0);
        jcbNaturalidadeFuncionarios.setSelectedIndex(0);
        jftTelefoneFixoFuncionarios.setText("");
        jftCelularFuncionarios.setText("");
        jftTelefoneRecadoFuncionarios.setText("");
        jtfEmailFuncionarios.setText("");
        jftCepFuncionarios.setText("");
        jtfUFFuncionarios.setText("");
        jtfCidadeFuncionarios.setText("");
        jtfBairroFuncionarios.setText("");
        jtfTipoLogradouroFuncionarios.setText("");
        jtfLogradouroFuncionarios.setText("");
        jtfNumeroCasaFuncionarios.setText("");
        jtfComplementoFuncionarios.setText("");
        jcbSetorFuncionarios.setSelectedIndex(0);
        jcbFuncaoFuncionarios.setSelectedIndex(0);
        jtfMatriculaFuncionarios.setText("");
        jdcDataAdmFuncionarios.setDate(null);
        jdcDataDemFuncionarios.setDate(null);
        jtfCTPSFuncionarios.setText("");
        jtfSerieUFFuncionarios.setText("");
        jtfPISFuncionarios.setText("");
        jftFuncionarioDesdeFuncionarios.setText(jlDataAtualMenu.getText());
        
        jtfPesquisarFuncionarios.setText("");
        jcbFiltrarFuncionarios.setSelectedIndex(0);
        
        jbSalvarFuncionarios.setText("<html>Salvar");
        jbSalvarFuncionarios.setFont(new java.awt.Font("Dialog", 1, 14));
        jbNovoFuncionarios.requestFocus();
    }

    //Ativar Campos Funcionarios.
    private void ativarCamposFuncionarios(Boolean AtvInat){
        jtfNomeFuncionarios.setEnabled(AtvInat);
        jcbSexoFuncionarios.setEnabled(AtvInat);
        jdcDataNascFuncionarios.setEnabled(AtvInat);
        jcbEstadoCivilFuncionarios.setEnabled(AtvInat);
        jftCPFFuncionarios.setEnabled(AtvInat);
        jftRGFuncionarios.setEnabled(AtvInat);
        jtfOrgaoExpedFuncionarios.setEnabled(AtvInat);
        jcbNacionalidadeFuncionarios.setEnabled(AtvInat);
        jcbNaturalidadeFuncionarios.setEnabled(AtvInat);
        jftTelefoneFixoFuncionarios.setEnabled(AtvInat);
        jftCelularFuncionarios.setEnabled(AtvInat);
        jftTelefoneRecadoFuncionarios.setEnabled(AtvInat);
        jtfEmailFuncionarios.setEnabled(AtvInat);
        jftCepFuncionarios.setEnabled(AtvInat);
        jtfUFFuncionarios.setEnabled(AtvInat);
        jtfCidadeFuncionarios.setEnabled(AtvInat);
        jtfBairroFuncionarios.setEnabled(AtvInat);
        jtfTipoLogradouroFuncionarios.setEnabled(AtvInat);
        jtfLogradouroFuncionarios.setEnabled(AtvInat);
        jtfNumeroCasaFuncionarios.setEnabled(AtvInat);
        jtfComplementoFuncionarios.setEnabled(AtvInat);
        jcbSetorFuncionarios.setEnabled(AtvInat);
        jcbFuncaoFuncionarios.setEnabled(AtvInat);
        jdcDataAdmFuncionarios.setEnabled(AtvInat);
        jdcDataDemFuncionarios.setEnabled(AtvInat);
        jtfCTPSFuncionarios.setEnabled(AtvInat);
        jtfSerieUFFuncionarios.setEnabled(AtvInat);
        jtfPISFuncionarios.setEnabled(AtvInat);
        jftFuncionarioDesdeFuncionarios.setEnabled(AtvInat);
        jbSalvarFuncionarios.setEnabled(AtvInat);
        
    }    
    
    //Realiza uma pesquisa de Funcionarios do BD e Preenche a tabela do View Funcionarios.
    private void procurarListarFuncionariosTabela(String pesquisa, String localPesquisa){
        listaFuncionarios.clear();
        listaFuncionarios = controllerFuncionarios.realizarPesquisaController(pesquisa, localPesquisa);
        
        if(listaFuncionarios.isEmpty())
        {
            //Erro ao localizar busca.
            JOptionPane.showMessageDialog(this, "Sua pesquisa \"" + pesquisa + "\" não encontrou nenhum funcionário com este\"" + localPesquisa.toLowerCase() + "\" ", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            DefaultTableModel tabelaFuncionarioModel = (DefaultTableModel) jtListaFuncionarios.getModel();
            tabelaFuncionarioModel.setNumRows(0);

            for (int i = 0; i < listaFuncionarios.size(); i++) {
                tabelaFuncionarioModel.addRow(new Object[]{
                listaFuncionarios.get(i).getId_funcionarios(),
                listaFuncionarios.get(i).getNome(),
                listaFuncionarios.get(i).getSexo(),
                listaFuncionarios.get(i).getDt_nascimento(),
                listaFuncionarios.get(i).getEstado_civil(),
                listaFuncionarios.get(i).getCpf(),
                listaFuncionarios.get(i).getRg(),
                listaFuncionarios.get(i).getNacionalidade(),
                listaFuncionarios.get(i).getNaturalidade(),
                listaFuncionarios.get(i).getTel_fixo(),
                listaFuncionarios.get(i).getTel_celular(),
                listaFuncionarios.get(i).getTel_contato(),
                listaFuncionarios.get(i).getEmail(),
                listaFuncionarios.get(i).getCep(),
                listaFuncionarios.get(i).getUf(),
                listaFuncionarios.get(i).getCidade(),
                listaFuncionarios.get(i).getBairro(),
                listaFuncionarios.get(i).getTipoLogradouro(),
                listaFuncionarios.get(i).getLogradouro(),
                listaFuncionarios.get(i).getNumeroCasa(),
                listaFuncionarios.get(i).getComplemento(),
                listaFuncionarios.get(i).getSetor(),
                listaFuncionarios.get(i).getFuncao(),
                listaFuncionarios.get(i).getMatricula(),
                listaFuncionarios.get(i).getData_adm(),
                listaFuncionarios.get(i).getData_dem(),
                listaFuncionarios.get(i).getCtps(),
                listaFuncionarios.get(i).getSerie_uf(),
                listaFuncionarios.get(i).getPis(),
                listaFuncionarios.get(i).getDt_funcionario_desde()
                });
            }
            
        }
    }

    //Adicionar novo Funcionário.
    private void jbNovoFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoFuncionariosActionPerformed
       jtfIDFuncionarios.setText((String.valueOf(controllerFuncionarios.retornarProximoIDFuncionarios())));
       jtfMatriculaFuncionarios.setText((String.valueOf(controllerFuncionarios.retornarProximaMatriculaFuncionarios())));
       ativarCamposFuncionarios(true);
       jtfNomeFuncionarios.requestFocus();
    }//GEN-LAST:event_jbNovoFuncionariosActionPerformed
     
    //Salvar/Atualizar novo Funcionário.
    private void jbSalvarFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarFuncionariosActionPerformed
        modelFuncionarios = new ModelFuncionarios();

        modelFuncionarios.setId_funcionarios(Integer.parseInt(jtfIDFuncionarios.getText()));
        modelFuncionarios.setNome(jtfNomeFuncionarios.getText());
        modelFuncionarios.setSexo(jcbSexoFuncionarios.getSelectedItem().toString());
        SimpleDateFormat dataFormatada = new SimpleDateFormat("d 'de' MMM 'de' y");
        modelFuncionarios.setDt_nascimento(dataFormatada.format(jdcDataNascFuncionarios.getDate()));
        modelFuncionarios.setEstado_civil(jcbEstadoCivilFuncionarios.getSelectedItem().toString());
        modelFuncionarios.setCpf(jftCPFFuncionarios.getText());
        modelFuncionarios.setRg(jftRGFuncionarios.getText());
        modelFuncionarios.setOrgao_exp(jtfOrgaoExpedFuncionarios.getText());
        modelFuncionarios.setNacionalidade(jcbNacionalidadeFuncionarios.getSelectedItem().toString());
        modelFuncionarios.setNaturalidade(jcbNaturalidadeFuncionarios.getSelectedItem().toString());
        modelFuncionarios.setTel_fixo(jftTelefoneFixoFuncionarios.getText());
        modelFuncionarios.setTel_celular(jftCelularFuncionarios.getText());
        modelFuncionarios.setTel_contato(jftTelefoneRecadoFuncionarios.getText());
        modelFuncionarios.setEmail(jtfEmailFuncionarios.getText());
        modelFuncionarios.setCep(jftCepFuncionarios.getText());
        modelFuncionarios.setUf(jtfUFFuncionarios.getText());
        modelFuncionarios.setCidade(jtfCidadeFuncionarios.getText());
        modelFuncionarios.setBairro(jtfBairroFuncionarios.getText());
        modelFuncionarios.setTipoLogradouro(jtfTipoLogradouroFuncionarios.getText());
        modelFuncionarios.setLogradouro(jtfLogradouroFuncionarios.getText());
        modelFuncionarios.setNumeroCasa(Integer.parseInt(jtfNumeroCasaFuncionarios.getText()));
        modelFuncionarios.setComplemento(jtfComplementoFuncionarios.getText());
        modelFuncionarios.setSetor(jcbSetorFuncionarios.getSelectedItem().toString());
        modelFuncionarios.setFuncao(jcbFuncaoFuncionarios.getSelectedItem().toString());
        modelFuncionarios.setMatricula(Integer.parseInt(jtfMatriculaFuncionarios.getText()));
        modelFuncionarios.setDt_nascimento(dataFormatada.format(jdcDataNascFuncionarios.getDate()));
        SimpleDateFormat dfFunc = new SimpleDateFormat("dd '/' MM '/' yy");
        modelFuncionarios.setData_adm(dfFunc.format(jdcDataAdmFuncionarios.getDate()));
        modelFuncionarios.setData_dem(dfFunc.format(jdcDataDemFuncionarios.getDate()));
        modelFuncionarios.setCtps(Integer.parseInt(jtfCTPSFuncionarios.getText()));
        modelFuncionarios.setSerie_uf(jtfSerieUFFuncionarios.getText());
        modelFuncionarios.setPis(Integer.parseInt(jtfPISFuncionarios.getText()));
        modelFuncionarios.setDt_funcionario_desde(jftFuncionarioDesdeFuncionarios.getText());
        
        
        if(cadastrarAlterarFuncionarios.equals("cad"))
        {  
            if(controllerFuncionarios.salvarFuncionariosController(modelFuncionarios))
            {   //Produto cadastrado com sucesso.
                JOptionPane.showMessageDialog(this, "Funcionário cadastrado com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                jtfNomeFuncionarios.requestFocus();
                listarFuncionariosTabela();
                limparFormularioFuncionarios();
            }
            else 
            {   //Erro ao cadastrar Produto.
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar Funcionário!", "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {   
            int dialogResult = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja salvar as alterações?", "Atenção!", JOptionPane.YES_NO_OPTION);
            if(dialogResult == 0) 
            {
                modelFuncionarios.setId_funcionarios(Integer.parseInt(jtfIDFuncionarios.getText()));
                //Alterar Paciente.
                if(controllerFuncionarios.salvarFuncionariosController(modelFuncionarios))
                {   //Paciente alterado com sucesso.
                    JOptionPane.showMessageDialog(this, "Funcionário atualizado com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                    jtfNomeFuncionarios.requestFocus();
                    listarFuncionariosTabela();
                    ativarCamposFuncionarios(false);
                }
                else 
                {   //Erro ao alterar Paciente.
                    JOptionPane.showMessageDialog(this, "Erro ao alterar Funcionário!", "Erro!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jbSalvarFuncionariosActionPerformed
    
    //Editar Funcionário.
    private void jpEditarFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpEditarFuncionariosActionPerformed
        cadastrarAlterarFuncionarios = "alt";
        modelFuncionarios = new ModelFuncionarios();
        int linha = jtListaFuncionarios.getSelectedRow();
        if(linha < 0)
        {
            JOptionPane.showMessageDialog(this, "Nenhum funcionário foi selecionado!", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        else
        {   
            int codigo = (int) jtListaFuncionarios.getValueAt(linha, 0);
            modelFuncionarios = controllerFuncionarios.getFuncionariosController(codigo);
            
            jtfIDFuncionarios.setText(String.valueOf(modelFuncionarios.getId_funcionarios()));
            jtfNomeFuncionarios.setText(modelFuncionarios.getNome());
            jcbSexoFuncionarios.setSelectedItem(modelFuncionarios.getSexo());
            try {
                jdcDataNascFuncionarios.setDate(new SimpleDateFormat("d 'de' MMM 'de' y").parse(modelFuncionarios.getDt_nascimento()));
            } catch (ParseException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            jcbEstadoCivilFuncionarios.setSelectedItem(modelFuncionarios.getEstado_civil());
            jftCPFFuncionarios.setText(modelFuncionarios.getCpf());
            jftRGFuncionarios.setText(modelFuncionarios.getRg());
            jtfOrgaoExpedFuncionarios.setText(modelFuncionarios.getOrgao_exp());
            jcbNacionalidadeFuncionarios.setSelectedItem(modelFuncionarios.getNacionalidade());
            jcbNaturalidadeFuncionarios.setSelectedItem(modelFuncionarios.getNaturalidade());
            jftTelefoneFixoFuncionarios.setText(modelFuncionarios.getTel_fixo());
            jftCelularFuncionarios.setText(modelFuncionarios.getTel_celular());
            jftTelefoneRecadoFuncionarios.setText(modelFuncionarios.getTel_contato());
            jtfEmailFuncionarios.setText(modelFuncionarios.getEmail());
            jftCepFuncionarios.setText(modelFuncionarios.getCep());
            jtfUFFuncionarios.setText(modelFuncionarios.getUf());
            jtfCidadeFuncionarios.setText(modelFuncionarios.getCidade());
            jtfBairroFuncionarios.setText(modelFuncionarios.getBairro());
            jtfTipoLogradouroFuncionarios.setText(modelFuncionarios.getTipoLogradouro());
            jtfLogradouroFuncionarios.setText(modelFuncionarios.getLogradouro());
            jtfNumeroCasaFuncionarios.setText(String.valueOf(modelFuncionarios.getNumeroCasa()));
            jtfComplementoFuncionarios.setText(modelFuncionarios.getComplemento());      
            jcbSetorFuncionarios.setSelectedItem(modelFuncionarios.getSetor());
            jcbFuncaoFuncionarios.setSelectedItem(modelFuncionarios.getFuncao());
            jtfMatriculaFuncionarios.setText(String.valueOf(modelFuncionarios.getMatricula()));
            try {
                jdcDataAdmFuncionarios.setDate(new SimpleDateFormat("dd '/' MM '/' yy").parse(modelFuncionarios.getData_adm()));
                jdcDataDemFuncionarios.setDate(new SimpleDateFormat("dd '/' MM '/' yy").parse(modelFuncionarios.getData_dem()));
            } catch (ParseException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            jtfCTPSFuncionarios.setText(String.valueOf(modelFuncionarios.getCtps()));
            jtfSerieUFFuncionarios.setText(modelFuncionarios.getSerie_uf());
            jtfPISFuncionarios.setText(String.valueOf(modelFuncionarios.getPis()));    
            jftFuncionarioDesdeFuncionarios.setText(modelFuncionarios.getDt_funcionario_desde());
            
            jbSalvarFuncionarios.setText("<html>Atualizar");
            jbSalvarFuncionarios.setFont(new java.awt.Font("Dialog", 1, 12));
            
            ativarCamposFuncionarios(true);
        }
    }//GEN-LAST:event_jpEditarFuncionariosActionPerformed

    //Excluir Funcionário.
    private void jbExcluirFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirFuncionariosActionPerformed
        int linha = jtListaFuncionarios.getSelectedRow();
        if(linha < 0)
        {
            JOptionPane.showMessageDialog(this, "Nenhum funcionário foi selecionado!", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        else
        {   
            int dialogResult = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir este funcionário?", "Atenção!", JOptionPane.YES_NO_OPTION);
            if(dialogResult == 0) 
            {
                int codigo = (int) jtListaFuncionarios.getValueAt(linha, 0);
                if(controllerFuncionarios.excluirFuncionariosController(codigo))
                {
                    listarFuncionariosTabela();
                    jtfNomeFuncionarios.requestFocus();
                    JOptionPane.showMessageDialog(this, "Funcionário excluído com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Erro ao excluir funcionário!", "Erro!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jbExcluirFuncionariosActionPerformed
    
    //Limpar Funcionário.
    private void jbLimparTelaFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparTelaFuncionariosActionPerformed
       limparFormularioFuncionarios();
       ativarCamposFuncionarios(false);
    }//GEN-LAST:event_jbLimparTelaFuncionariosActionPerformed
    
    //Procuar Funcionário.
    private void jbProcurarFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProcurarFuncionariosActionPerformed
        procurarListarFuncionariosTabela(jtfPesquisarFuncionarios.getText(), jcbFiltrarFuncionarios.getSelectedItem().toString());
    }//GEN-LAST:event_jbProcurarFuncionariosActionPerformed

    //-----+++++++++++++++++++++++=========== OPÇÕES DE REGISTROS > FUNCIONÁRIOS =============+++++++++++++++++-----
    //Códigos gerados quando da foco no Panel Registros > (Funcionários).
    private void jpFuncionariosRegistrosComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jpFuncionariosRegistrosComponentShown
        jftFuncionarioDesdeFuncionarios.setText(jlDataAtualMenu.getText());
    }//GEN-LAST:event_jpFuncionariosRegistrosComponentShown
    
    
    
    
    //-----+++++++++++++++++++++++=========== AGENDAMENTOS =============+++++++++++++++++-----
    //Listar Agendamentos tabela.
    private void listarAgendamentosTabela(){
        listaAgendamentos.clear();
        listaAgendamentos = controllerAgendamentos.getListaAgendamentosController();
        DefaultTableModel tabelaAgendamentosModel = (DefaultTableModel) jtListaAgendamentos.getModel();
        tabelaAgendamentosModel.setNumRows(0);
        
        for (int i = 0; i < listaAgendamentos.size(); i++) {
            tabelaAgendamentosModel.addRow(new Object[]{
                listaAgendamentos.get(i).getId_agendamento(),
                listaAgendamentos.get(i).getData_agendamento(),
                listaAgendamentos.get(i).getHora_agendamento(),
                listaAgendamentos.get(i).getPaciente(),
                listaAgendamentos.get(i).getTel_fixo(),
                listaAgendamentos.get(i).getTel_celular(),
                listaAgendamentos.get(i).getTel_contato(),
                listaAgendamentos.get(i).getEspecialidade(),
                listaAgendamentos.get(i).getEspecialista(),
                listaAgendamentos.get(i).getTipo_procedimento(),
                listaAgendamentos.get(i).getProcedimento(),
                listaAgendamentos.get(i).getTipo_atendimento(),
                listaAgendamentos.get(i).getConvenio(),
                listaAgendamentos.get(i).getObservacoes(),
                listaAgendamentos.get(i).getStatus_agendamento(),
                listaAgendamentos.get(i).getDt_realizacao_agendamento()
            });
        }
    }

    //Limpar Formulario Agendamentos.
    private void limparFormularioAgendamentos(){
        jtfIDAgendamentos.setText("");
        jdcDataAgendamentos.setDate(null);
        jcbHoraAgendamentos.setSelectedIndex(0);
        jftTelefoneFixoAgendamentos.setText("");
        jftCelularAgendamentos.setText("");
        jftTelefoneRecadoAgendamentos.setText("");
        jcbEspecialidadeAgendamentos.setSelectedIndex(0);
        jcbEspecialistaAgendamentos.setSelectedIndex(0);
        jcbTipoProcedimentoAgendamentos.setSelectedIndex(0);
        jcbProcedimentoAgendamentos.setSelectedIndex(0);
        jcbTipoAtendAgendamentos.setSelectedIndex(0);
        jcbConvenioAgendamentos.setSelectedIndex(0);
        jtpObservacoesAgendamentos.setText("");
        jcbStatusAgendamentos.setSelectedItem(0);
        jftDataAgendAgendamentos.setText(jlDataAtualMenu.getText());
        
        jcbPacienteAgendamentos.removeAllItems();
        jcbPacienteAgendamentos.addItem("Selecione");
        jcbPacienteAgendamentos.setSelectedIndex(0);
        
        jtfPesquisarAgendamentos.setText("");
        jcbFiltrarAgendamentos.setSelectedIndex(0);

        jbSalvarAgendamentos.setText("<html>Salvar");
        jbSalvarAgendamentos.setFont(new java.awt.Font("Dialog", 1, 14));
        jbNovoAgendamentos.requestFocus();
    }

    //Ativar Campos Agendamentos.
    private void ativarCamposAgendamentos(Boolean AtvInat){
        jtfIDAgendamentos.setEnabled(AtvInat);
        jdcDataAgendamentos.setEnabled(AtvInat);
        jcbHoraAgendamentos.setEnabled(AtvInat);
        jcbPacienteAgendamentos.setEnabled(AtvInat);
        jcbEspecialidadeAgendamentos.setEnabled(AtvInat);
        jcbEspecialistaAgendamentos.setEnabled(AtvInat);
        jcbTipoProcedimentoAgendamentos.setEnabled(AtvInat);
        jcbProcedimentoAgendamentos.setEnabled(AtvInat);
        jcbTipoAtendAgendamentos.setEnabled(AtvInat);
        jcbConvenioAgendamentos.setEnabled(AtvInat);
        jtpObservacoesAgendamentos.setEnabled(AtvInat);
        jcbStatusAgendamentos.setEnabled(AtvInat);
        jftDataAgendAgendamentos.setEnabled(AtvInat);
        jbSalvarAgendamentos.setEnabled(AtvInat);
        
    }   
    
     //Realiza uma pesquisa de Agendamentos do BD e Preenche a tabela do View Agendamentos.
    private void procurarListarAgendamentosTabela(String pesquisa, String localPesquisa){
        listaAgendamentos.clear();
        listaAgendamentos = controllerAgendamentos.realizarPesquisaAgendamentosController(pesquisa, localPesquisa);
        
        if(listaAgendamentos.isEmpty())
        {
            //Erro ao localizar busca.
            JOptionPane.showMessageDialog(this, "Sua pesquisa \"" + pesquisa + "\" não encontrou nenhum agendamentos com este\"" + localPesquisa.toLowerCase() + "\" ", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            DefaultTableModel tabelaAgendamentosModel = (DefaultTableModel) jtListaAgendamentos.getModel();
            tabelaAgendamentosModel.setNumRows(0);

            for (int i = 0; i < listaAgendamentos.size(); i++) {
                tabelaAgendamentosModel.addRow(new Object[]{
                    listaAgendamentos.get(i).getId_agendamento(),
                    listaAgendamentos.get(i).getData_agendamento(),
                    listaAgendamentos.get(i).getHora_agendamento(),
                    listaAgendamentos.get(i).getPaciente(),
                    listaAgendamentos.get(i).getTel_fixo(),
                    listaAgendamentos.get(i).getTel_celular(),
                    listaAgendamentos.get(i).getTel_contato(),
                    listaAgendamentos.get(i).getEspecialidade(),
                    listaAgendamentos.get(i).getEspecialista(),
                    listaAgendamentos.get(i).getTipo_procedimento(),
                    listaAgendamentos.get(i).getProcedimento(),
                    listaAgendamentos.get(i).getTipo_atendimento(),
                    listaAgendamentos.get(i).getConvenio(),
                    listaAgendamentos.get(i).getObservacoes(),
                    listaAgendamentos.get(i).getStatus_agendamento(),
                    listaAgendamentos.get(i).getDt_realizacao_agendamento()
                });
            }
            
        }
    }
    
    //Novo Agendamento.
    private void jbNovoAgendamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoAgendamentosActionPerformed
       jtfIDAgendamentos.setText((String.valueOf(controllerAgendamentos.retornarProximoIDAgendamentos())));
       ativarCamposAgendamentos(true);
       jdcDataAgendamentos.requestFocus();
    }//GEN-LAST:event_jbNovoAgendamentosActionPerformed
    
    //Salvar Agendamento.
    private void jbSalvarAgendamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarAgendamentosActionPerformed
        modelAgendamentos = new ModelAgendamentos();

        modelAgendamentos.setId_agendamento(Integer.parseInt(jtfIDAgendamentos.getText()));
        SimpleDateFormat dataFormatada = new SimpleDateFormat("d 'de' MMM 'de' y");
        modelAgendamentos.setData_agendamento(dataFormatada.format(jdcDataAgendamentos.getDate()));
        modelAgendamentos.setHora_agendamento(jcbHoraAgendamentos.getSelectedItem().toString());
        modelAgendamentos.setPaciente(jcbPacienteAgendamentos.getSelectedItem().toString());
        modelAgendamentos.setTel_fixo(jftTelefoneFixoAgendamentos.getText());
        modelAgendamentos.setTel_celular(jftCelularAgendamentos.getText());
        modelAgendamentos.setTel_contato(jftTelefoneRecadoAgendamentos.getText());
        modelAgendamentos.setEspecialidade(jcbEspecialidadeAgendamentos.getSelectedItem().toString());
        modelAgendamentos.setEspecialista(jcbEspecialistaAgendamentos.getSelectedItem().toString());
        modelAgendamentos.setTipo_procedimento(jcbTipoProcedimentoAgendamentos.getSelectedItem().toString());
        modelAgendamentos.setProcedimento(jcbProcedimentoAgendamentos.getSelectedItem().toString());
        modelAgendamentos.setTipo_atendimento(jcbTipoAtendAgendamentos.getSelectedItem().toString());
        modelAgendamentos.setConvenio(jcbConvenioAgendamentos.getSelectedItem().toString());
        modelAgendamentos.setObservacoes(jtpObservacoesAgendamentos.getText());
        modelAgendamentos.setStatus_agendamento(jcbStatusAgendamentos.getSelectedItem().toString());
        modelAgendamentos.setDt_realizacao_agendamento(jftDataAgendAgendamentos.getText());
        
        if(cadastrarAlterarAgendamentos.equals("cad"))
        {  
            if(controllerAgendamentos.salvarAgendamentosController(modelAgendamentos))
            {   //Produto cadastrado com sucesso.
                JOptionPane.showMessageDialog(this, "Agendamento salvo com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                jdcDataAgendamentos.requestFocus();
                listarAgendamentosTabela();
                limparFormularioAgendamentos();
            }
            else 
            {   //Erro ao cadastrar Produto.
                JOptionPane.showMessageDialog(this, "Erro ao salvar agendamento!", "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {   
            int dialogResult = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja salvar as alterações?", "Atenção!", JOptionPane.YES_NO_OPTION);
            if(dialogResult == 0) 
            {
                modelAgendamentos.setId_agendamento(Integer.parseInt(jtfIDAgendamentos.getText()));
                //Alterar Paciente.
                if(controllerAgendamentos.salvarAgendamentosController(modelAgendamentos))
                {   //Paciente alterado com sucesso.
                    JOptionPane.showMessageDialog(this, "Agendamento atualizado com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                    jdcDataAgendamentos.requestFocus();
                    listarAgendamentosTabela();
                    ativarCamposAgendamentos(false);
                }
                else 
                {   //Erro ao alterar Paciente.
                    JOptionPane.showMessageDialog(this, "Erro ao alterar Agendamento!", "Erro!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jbSalvarAgendamentosActionPerformed
    
    //Editar Agendamento.
    private void jbEditarAgendamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarAgendamentosActionPerformed
        cadastrarAlterarAgendamentos = "alt";
        modelAgendamentos = new ModelAgendamentos();
        int linha = jtListaAgendamentos.getSelectedRow();
        if(linha < 0)
        {
            JOptionPane.showMessageDialog(this, "Nenhum agendamento foi selecionado!", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        else
        {   
            int codigo = (int) jtListaAgendamentos.getValueAt(linha, 0);
            modelAgendamentos = controllerAgendamentos.getAgendamentosController(codigo);
            
            
            jtfIDAgendamentos.setText(String.valueOf(modelAgendamentos.getId_agendamento()));
            try {
                jdcDataAgendamentos.setDate(new SimpleDateFormat("d 'de' MMM 'de' y").parse(modelAgendamentos.getData_agendamento()));
            } catch (ParseException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            jcbHoraAgendamentos.setSelectedItem(modelAgendamentos.getHora_agendamento());
            jcbPacienteAgendamentos.setSelectedItem(modelAgendamentos.getPaciente());
            jftTelefoneFixoAgendamentos.setText(modelAgendamentos.getTel_fixo());
            jftCelularAgendamentos.setText(modelAgendamentos.getTel_celular());
            jftTelefoneRecadoAgendamentos.setText(modelAgendamentos.getTel_contato());
            jcbEspecialidadeAgendamentos.setSelectedItem(modelAgendamentos.getEspecialidade());
            jcbEspecialistaAgendamentos.setSelectedItem(modelAgendamentos.getEspecialista());
            jcbTipoProcedimentoAgendamentos.setSelectedItem(modelAgendamentos.getTipo_procedimento());
            jcbProcedimentoAgendamentos.setSelectedItem(modelAgendamentos.getProcedimento());
            jcbTipoAtendAgendamentos.setSelectedItem(modelAgendamentos.getTipo_atendimento());
            jcbConvenioAgendamentos.setSelectedItem(modelAgendamentos.getConvenio());
            jtpObservacoesAgendamentos.setText(modelAgendamentos.getObservacoes());
            jcbStatusAgendamentos.setSelectedItem(modelAgendamentos.getStatus_agendamento());
            jftDataAgendAgendamentos.setText(modelAgendamentos.getDt_realizacao_agendamento());
            
            jbSalvarFuncionarios.setText("<html>Atualizar");
            jbSalvarFuncionarios.setFont(new java.awt.Font("Dialog", 1, 12));
            
            ativarCamposAgendamentos(true);
        }
    }//GEN-LAST:event_jbEditarAgendamentosActionPerformed
    
    //Excluir Agendamento.
    private void jbExlcuirAgendamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExlcuirAgendamentosActionPerformed
        int linha = jtListaAgendamentos.getSelectedRow();
        if(linha < 0)
        {
            JOptionPane.showMessageDialog(this, "Nenhum agendamento foi selecionado!", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        else
        {   
            int dialogResult = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir este agendamento?", "Atenção!", JOptionPane.YES_NO_OPTION);
            if(dialogResult == 0) 
            {
                int codigo = (int) jtListaAgendamentos.getValueAt(linha, 0);
                if(controllerAgendamentos.excluirAgendamentosController(codigo))
                {
                    listarAgendamentosTabela();
                    jdcDataAgendamentos.requestFocus();
                    JOptionPane.showMessageDialog(this, "Agendamento excluído com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Erro ao excluir agendamento!", "Erro!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jbExlcuirAgendamentosActionPerformed
    
    //Limpar Agendamento.
    private void jbLimparTelaAgendamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparTelaAgendamentosActionPerformed
        limparFormularioAgendamentos();
        ativarCamposAgendamentos(false);
    }//GEN-LAST:event_jbLimparTelaAgendamentosActionPerformed
    
    //Procurar Agendamento.
    private void jbProcurarAgendamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProcurarAgendamentosActionPerformed
        procurarListarAgendamentosTabela(jtfPesquisarAgendamentos.getText(), jcbFiltrarAgendamentos.getSelectedItem().toString());
    }//GEN-LAST:event_jbProcurarAgendamentosActionPerformed
    
    //Carregar lista de Pacientes para seleção.
    private void jcbPacienteAgendamentosPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbPacienteAgendamentosPopupMenuWillBecomeVisible
        listaPacientes.clear();
        listaPacientes = controllerPacientes.getListaPacientesController();

        if(!listaPacientes.isEmpty()){
             jcbPacienteAgendamentos.removeAllItems();   
            jcbPacienteAgendamentos.addItem("Selecione");

            for (int i = 0; i < listaPacientes.size(); i++) {
                jcbPacienteAgendamentos.addItem(listaPacientes.get(i).getNome());
            }
        }
    }//GEN-LAST:event_jcbPacienteAgendamentosPopupMenuWillBecomeVisible
    
    //Carregar dados de contato do paciente selecionado.
    private void jcbPacienteAgendamentosPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbPacienteAgendamentosPopupMenuWillBecomeInvisible
        if(jcbPacienteAgendamentos.getItemCount() >= 0){
            listaPacientes.clear();
            listaPacientes = controllerPacientes.pesquisarPacienteController(jcbPacienteAgendamentos.getSelectedItem().toString(), "NOME");

            jftTelefoneFixoAgendamentos.setText(listaPacientes.get(0).getTel_fixo());
            jftCelularAgendamentos.setText(listaPacientes.get(0).getTel_celular());
            jftTelefoneRecadoAgendamentos.setText(listaPacientes.get(0).getTel_contato());
        }
    }//GEN-LAST:event_jcbPacienteAgendamentosPopupMenuWillBecomeInvisible
    
    //Carregar especialidades disponiveis.
    private void jcbEspecialidadeAgendamentosPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbEspecialidadeAgendamentosPopupMenuWillBecomeInvisible
        listaFuncionarios.clear();
        listaFuncionarios = controllerFuncionarios.getListaFuncionariosController();

        if(!listaFuncionarios.isEmpty()){
            jcbEspecialistaAgendamentos.removeAllItems();   
            jcbEspecialistaAgendamentos.addItem("Selecione");

            for (int i = 0; i < listaFuncionarios.size(); i++) {
                if(jcbEspecialidadeAgendamentos.getSelectedItem().toString().equals(listaFuncionarios.get(i).getSetor())){
                    jcbEspecialistaAgendamentos.addItem(listaFuncionarios.get(i).getNome());  
                }
            }
        }
    }//GEN-LAST:event_jcbEspecialidadeAgendamentosPopupMenuWillBecomeInvisible
    
    //Códigos gerados quando da foco no Panel Registros > (Agendamentos).
    private void jpAgendamentosComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jpAgendamentosComponentShown
        jftDataAgendAgendamentos.setText(jlDataAtualMenu.getText());
    }//GEN-LAST:event_jpAgendamentosComponentShown

    
    
    
    //-----+++++++++++++++++++++++=========== ATENDIMENTOS (MÉDICO) =============+++++++++++++++++-----
    //Ativar Campos Atend. Médico.
    private void ativarCamposAtendMedico(Boolean AtvInat){
        jcbPacienteAtendMedico.setEnabled(AtvInat);
        jtpDiagnosticoAtendMedico.setEnabled(AtvInat);
        jcbDoencasCronicasAtendMedico.setEnabled(AtvInat);
        jtpDoencasCronicasAtendMedico.setEnabled(AtvInat);
        jbAdcDoencaCronicaAtendMedico.setEnabled(AtvInat);
        jbSalvarAtendMedico.setEnabled(AtvInat);
    }   
    
    //Limpar Campos Atend. Médico.
    private void limparFormularioAtendMedico(){
        jcbPacienteAtendMedico.setSelectedItem(0);
        jcbSexoPacienteAtendMedico.setSelectedItem(0);
        jdcDataNascPacienteAtendMedico.setDate(null);
        jtfLogradouroPacienteAtendMedico.setText("");
        jcbFiltrarAtendimentoAtendMedico.setSelectedItem(0);
        jtpHistoricoConsultaAtendMedico.setText("");
        jtpHistoricoDoencasCronicasAtendMedico.setText("");
        jtfIDAtendMedico.setText("");
        jtfMatriculaMedicoAtendMedico.setText("");
        jtfConsultasDiaAtendMedico.setText("");
        jtpDiagnosticoAtendMedico.setText("");
        jcbDoencasCronicasAtendMedico.setSelectedItem(0);
        jtpDoencasCronicasAtendMedico.setText("");
        jbSalvarAtendMedico.setText("");
        jbNovoAtendMedico.requestFocus();
        
        jcbPacienteAtendMedico.removeAllItems();
        jcbPacienteAtendMedico.addItem("Selecione");
        jcbPacienteAtendMedico.setSelectedIndex(0);
        
        jcbFiltrarAtendimentoAtendMedico.removeAllItems();
        jcbFiltrarAtendimentoAtendMedico.addItem("Selecione");
        jcbFiltrarAtendimentoAtendMedico.setSelectedIndex(0);
    }
    
    //Carregar lista de Pacientes para seleção.
    private void jcbPacienteAtendMedicoPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbPacienteAtendMedicoPopupMenuWillBecomeVisible
        listaPacientes.clear();
        listaPacientes = controllerPacientes.getListaPacientesController();
        
        if(!listaPacientes.isEmpty()){
            jcbPacienteAtendMedico.removeAllItems();   
            jcbPacienteAtendMedico.addItem("Selecione");

            for (int i = 0; i < listaPacientes.size(); i++) {
                jcbPacienteAtendMedico.addItem(listaPacientes.get(i).getNome());
            }
        }
        
    }//GEN-LAST:event_jcbPacienteAtendMedicoPopupMenuWillBecomeVisible
    
    //Carregar dados pessoais do Paciente selecionado.
    private void jcbPacienteAtendMedicoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbPacienteAtendMedicoPopupMenuWillBecomeInvisible
        if(jcbPacienteAtendMedico.getItemCount() >= 0){
            listaPacientes.clear();
            listaPacientes = controllerPacientes.pesquisarPacienteController(jcbPacienteAtendMedico.getSelectedItem().toString(), "NOME");

            if(!listaPacientes.isEmpty()){
                jcbSexoPacienteAtendMedico.setSelectedItem(listaPacientes.get(0).getSexo());
                try {
                    jdcDataNascPacienteAtendMedico.setDate(new SimpleDateFormat("d 'de' MMM 'de' y").parse(listaPacientes.get(0).getDt_nascimento()));
                } catch (ParseException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                jtfLogradouroPacienteAtendMedico.setText(listaPacientes.get(0).getTipoLogradouro()
                                               + " " + listaPacientes.get(0).getLogradouro() 
                                               + ", " + listaPacientes.get(0).getNumeroCasa()
                                               + " - " + listaPacientes.get(0).getComplemento()
                                               + " - " + listaPacientes.get(0).getBairro() 
                                               + " - " + listaPacientes.get(0).getCidade()
                                               + " - " + listaPacientes.get(0).getUf()
                );
            }
            
            if(!jcbPacienteAtendMedico.getSelectedItem().equals("Selecione")){
                jcbFiltrarAtendimentoAtendMedico.setEnabled(true);
            }
            else{
                jcbFiltrarAtendimentoAtendMedico.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jcbPacienteAtendMedicoPopupMenuWillBecomeInvisible
    
    //Salvar Atendimento Médico.
    private void jbSalvarAtendMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarAtendMedicoActionPerformed
        modelAtendimentoMed = new ModelAtendimentoMedico();

        modelAtendimentoMed.setId_atendimentos_medicos(Integer.parseInt(jtfIDAtendMedico.getText()));
        modelAtendimentoMed.setMatricula_medico(Integer.parseInt(jtfMatriculaMedicoAtendMedico.getText()));
        modelAtendimentoMed.setNum_consulta_dia(Integer.parseInt(jtfConsultasDiaAtendMedico.getText()));
        modelAtendimentoMed.setData_consulta(jftDataAtendMedico.getText());
        modelAtendimentoMed.setDiagnostico(jtpDiagnosticoAtendMedico.getText());
        modelAtendimentoMed.setDoencas_cronicas(jtpDoencasCronicasAtendMedico.getText());
        
        modelAtendimentoMed.setNome_paciente(jcbPacienteAtendMedico.getSelectedItem().toString());
        modelAtendimentoMed.setSexo_paciente(jcbSexoPacienteAtendMedico.getSelectedItem().toString());
        SimpleDateFormat dataFormatada = new SimpleDateFormat("d 'de' MMM 'de' y");
        modelAtendimentoMed.setDt_nasc_paciente(dataFormatada.format(jdcDataNascPacienteAtendMedico.getDate()));
        modelAtendimentoMed.setLogradouro_paciente(jtfLogradouroPacienteAtendMedico.getText());
        
        modelAtendimentoMed.setRegistro_atendimento(
            "ID: "+Integer.parseInt(jtfIDAtendMedico.getText())
            +" - PACIENTE: "+ jcbPacienteAtendMedico.getSelectedItem().toString()
            +" - DATA:" + dataFormatada.format(jdcDataNascPacienteAtendMedico.getDate())
        
        );
         
        if(controllerAtendimentoMed.salvarAtendimentoMedicoController(modelAtendimentoMed))
        {   //Produto cadastrado com sucesso.
            JOptionPane.showMessageDialog(this, "Consulta salva com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            jcbPacienteAtendMedico.requestFocus();
            limparFormularioAtendMedico();
        }
        else 
        {   //Erro ao cadastrar Produto.
            JOptionPane.showMessageDialog(this, "Erro ao salvar consulta!", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
      

    }//GEN-LAST:event_jbSalvarAtendMedicoActionPerformed
     
    //Códigos gerados quando da foco no Panel Atendimentos > (Medicos).
    private void jpMedicosAtendimentosComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jpMedicosAtendimentosComponentShown
        jftDataAtendMedico.setText(jlDataAtualMenu.getText());
    }//GEN-LAST:event_jpMedicosAtendimentosComponentShown
    
    //Novo Atendimento Medico.
    private void jbNovoAtendMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoAtendMedicoActionPerformed
        ativarCamposAtendMedico(true);
        jtfMatriculaMedicoAtendMedico.setText(String.valueOf(controllerAtendimentoMed.retornarMatriculaMedico(jlNomeUsuario.getText())));
        jtfIDAtendMedico.setText(String.valueOf(controllerAtendimentoMed.retornarProximoIDAtendMedico()));
        jtfConsultasDiaAtendMedico.setText(String.valueOf(controllerAtendimentoMed.retornarNumConsultasDoDia(jtfMatriculaMedicoAtendMedico.getText())));
    }//GEN-LAST:event_jbNovoAtendMedicoActionPerformed
    
    //Adicionando nomes de Doenças Crônicas na Lista.
    private void jbAdcDoencaCronicaAtendMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdcDoencaCronicaAtendMedicoActionPerformed
        if(!jcbDoencasCronicasAtendMedico.getSelectedItem().equals("Selecione")){
            String nomeDoenca;
            if(!jtpDoencasCronicasAtendMedico.getText().isBlank())
            {
                if(!jtpDoencasCronicasAtendMedico.getText().contains(jcbDoencasCronicasAtendMedico.getSelectedItem().toString())){
                    nomeDoenca = (jtpDoencasCronicasAtendMedico.getText() + "\n" +
                                  jcbDoencasCronicasAtendMedico.getSelectedItem().toString());
                    jtpDoencasCronicasAtendMedico.setText(nomeDoenca);
                }
            }
            else
            {
                nomeDoenca = (jcbDoencasCronicasAtendMedico.getSelectedItem().toString());
                jtpDoencasCronicasAtendMedico.setText(nomeDoenca);
            }
            
            
        }
    }//GEN-LAST:event_jbAdcDoencaCronicaAtendMedicoActionPerformed
    
    //Limpar formulário atendimento médico.
    private void jbLimparTelaAtendMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparTelaAtendMedicoActionPerformed
        limparFormularioAtendMedico();
        ativarCamposAtendMedico(false);
    }//GEN-LAST:event_jbLimparTelaAtendMedicoActionPerformed
    
    //Carregar histórico de consultas do paciente.
    private void jcbFiltrarAtendimentoAtendMedicoPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbFiltrarAtendimentoAtendMedicoPopupMenuWillBecomeVisible
        listaAtendimentoMed.clear();
        listaAtendimentoMed = controllerAtendimentoMed.getListaAtendimentoMedController(jcbPacienteAtendMedico.getSelectedItem().toString());

        if(!listaAtendimentoMed.isEmpty()){
            jcbFiltrarAtendimentoAtendMedico.removeAllItems();   
            jcbFiltrarAtendimentoAtendMedico.addItem("Selecione");

            for (int i = 0; i < listaAtendimentoMed.size(); i++) {
                jcbFiltrarAtendimentoAtendMedico.addItem(listaAtendimentoMed.get(i).getRegistro_atendimento());
            }
        }
    }//GEN-LAST:event_jcbFiltrarAtendimentoAtendMedicoPopupMenuWillBecomeVisible

    private void jcbFiltrarAtendimentoAtendMedicoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbFiltrarAtendimentoAtendMedicoPopupMenuWillBecomeInvisible
        if(jcbFiltrarAtendimentoAtendMedico.getSelectedIndex() >= 0){
            listaAtendimentoMed.clear();
            listaAtendimentoMed = controllerAtendimentoMed.getListaAtendimentoMedController(jcbPacienteAtendMedico.getSelectedItem().toString());
            
            for (int i = 0; i < listaAtendimentoMed.size(); i++) {
                jtpHistoricoConsultaAtendMedico.setText(listaAtendimentoMed.get(i).getDiagnostico());
                jtpHistoricoDoencasCronicasAtendMedico.setText(listaAtendimentoMed.get(i).getDoencas_cronicas());
            }
            
        }
        else{
            jcbFiltrarAtendimentoAtendMedico.setEnabled(false);
        }
    }//GEN-LAST:event_jcbFiltrarAtendimentoAtendMedicoPopupMenuWillBecomeInvisible
    
   
   
    
    
    
    
    
    
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JButton jbAdcDoencaCronicaAtendMedico;
    private javax.swing.JButton jbAgendamentosMenu;
    private javax.swing.JButton jbAtendimentosMenu;
    private javax.swing.JButton jbConsultasAgendamentos;
    private javax.swing.JButton jbEditarAgendamentos;
    private javax.swing.JButton jbEditarPacientes;
    private javax.swing.JButton jbEnfermeirosAtendimentos;
    private javax.swing.JButton jbExamesAgendamentos;
    private javax.swing.JButton jbExcluirFuncionarios;
    private javax.swing.JButton jbExlcuirAgendamentos;
    private javax.swing.JButton jbExlcuirPacientes;
    private javax.swing.JButton jbFecharMenu;
    private javax.swing.JButton jbFinanceiroMenu;
    private javax.swing.JButton jbFuncionariosRegistros;
    private javax.swing.JButton jbInserirResultadosLaboratorios;
    private javax.swing.JButton jbLaboratorioMenu;
    private javax.swing.JButton jbLimparTelaAgendamentos;
    private javax.swing.JButton jbLimparTelaAtendMedico;
    private javax.swing.JButton jbLimparTelaFuncionarios;
    private javax.swing.JButton jbLimparTelaPacientes;
    private javax.swing.JButton jbMedicosAtendimentos;
    private javax.swing.JButton jbMinimizarMenu;
    private javax.swing.JButton jbNovoAgendamentos;
    private javax.swing.JButton jbNovoAtendMedico;
    private javax.swing.JButton jbNovoFuncionarios;
    private javax.swing.JButton jbNovoPacientes;
    private javax.swing.JButton jbPacientesRegistros;
    private javax.swing.JButton jbProcurarAgendamentos;
    private javax.swing.JButton jbProcurarFuncionarios;
    private javax.swing.JButton jbProcurarPacientes;
    private javax.swing.JButton jbRecebimentosFinanceiro;
    private javax.swing.JButton jbRegistrosMenu;
    private javax.swing.JButton jbSairMenu;
    private javax.swing.JButton jbSalvarAgendamentos;
    private javax.swing.JButton jbSalvarAtendMedico;
    private javax.swing.JButton jbSalvarFuncionarios;
    private javax.swing.JButton jbSalvarPacientes;
    private javax.swing.JButton jbVacinasAgendamentos;
    private javax.swing.JButton jbVerResultadosLaboratorios;
    private javax.swing.JComboBox<String> jcbConvenioAgendamentos;
    private javax.swing.JComboBox<String> jcbDoencasCronicasAtendMedico;
    private javax.swing.JComboBox<String> jcbEspecialidadeAgendamentos;
    private javax.swing.JComboBox<String> jcbEspecialistaAgendamentos;
    private javax.swing.JComboBox<String> jcbEstadoCivilFuncionarios;
    private javax.swing.JComboBox<String> jcbEstadoCivilPacientes;
    private javax.swing.JComboBox<String> jcbFiltrarAgendamentos;
    private javax.swing.JComboBox<String> jcbFiltrarAtendimentoAtendMedico;
    private javax.swing.JComboBox<String> jcbFiltrarFuncionarios;
    private javax.swing.JComboBox<String> jcbFiltrarPacientes;
    private javax.swing.JComboBox<String> jcbFuncaoFuncionarios;
    private javax.swing.JComboBox<String> jcbHoraAgendamentos;
    private javax.swing.JComboBox<String> jcbNacionalidadeFuncionarios;
    private javax.swing.JComboBox<String> jcbNacionalidadePacientes;
    private javax.swing.JComboBox<String> jcbNaturalidadeFuncionarios;
    private javax.swing.JComboBox<String> jcbNaturalidadePacientes;
    private javax.swing.JComboBox<String> jcbPacienteAgendamentos;
    private javax.swing.JComboBox<String> jcbPacienteAtendMedico;
    private javax.swing.JComboBox<String> jcbProcedimentoAgendamentos;
    private javax.swing.JComboBox<String> jcbSetorFuncionarios;
    private javax.swing.JComboBox<String> jcbSexoFuncionarios;
    private javax.swing.JComboBox<String> jcbSexoPacienteAtendMedico;
    private javax.swing.JComboBox<String> jcbSexoPacientes;
    private javax.swing.JComboBox<String> jcbStatusAgendamentos;
    private javax.swing.JComboBox<String> jcbTipoAtendAgendamentos;
    private javax.swing.JComboBox<String> jcbTipoProcedimentoAgendamentos;
    private com.toedter.calendar.JDateChooser jdcDataAdmFuncionarios;
    private com.toedter.calendar.JDateChooser jdcDataAgendamentos;
    private com.toedter.calendar.JDateChooser jdcDataDemFuncionarios;
    private com.toedter.calendar.JDateChooser jdcDataNascFuncionarios;
    private com.toedter.calendar.JDateChooser jdcDataNascPacienteAtendMedico;
    private com.toedter.calendar.JDateChooser jdcDataNascPacientes;
    private javax.swing.JFormattedTextField jftCPFFuncionarios;
    private javax.swing.JFormattedTextField jftCPFPacientes;
    private javax.swing.JFormattedTextField jftCadastradoDesdePacientes;
    private javax.swing.JFormattedTextField jftCelularAgendamentos;
    private javax.swing.JFormattedTextField jftCelularFuncionarios;
    private javax.swing.JFormattedTextField jftCelularPacientes;
    private javax.swing.JFormattedTextField jftCepFuncionarios;
    private javax.swing.JFormattedTextField jftCepPacientes;
    private javax.swing.JFormattedTextField jftDataAgendAgendamentos;
    private javax.swing.JFormattedTextField jftDataAtendMedico;
    private javax.swing.JFormattedTextField jftFuncionarioDesdeFuncionarios;
    private javax.swing.JFormattedTextField jftRGFuncionarios;
    private javax.swing.JFormattedTextField jftRGPacientes;
    private javax.swing.JFormattedTextField jftTelefoneFixoAgendamentos;
    private javax.swing.JFormattedTextField jftTelefoneFixoFuncionarios;
    private javax.swing.JFormattedTextField jftTelefoneFixoPacientes;
    private javax.swing.JFormattedTextField jftTelefoneRecadoAgendamentos;
    private javax.swing.JFormattedTextField jftTelefoneRecadoFuncionarios;
    private javax.swing.JFormattedTextField jftTelefoneRecadoPacientes;
    private javax.swing.JLabel jlBairroFuncionarios;
    private javax.swing.JLabel jlBairroPacientes;
    private javax.swing.JLabel jlCEPFuncionarios;
    private javax.swing.JLabel jlCEPPacientes;
    private javax.swing.JLabel jlCPFFuncionarios;
    private javax.swing.JLabel jlCPFPacientes;
    private javax.swing.JLabel jlCTPSFuncionarios;
    private javax.swing.JLabel jlCelularAgendamentos;
    private javax.swing.JLabel jlCelularFuncionarios;
    private javax.swing.JLabel jlCelularPacientes;
    private javax.swing.JLabel jlCidadeFuncionarios;
    private javax.swing.JLabel jlCidadePacientes;
    private javax.swing.JLabel jlClienteDesdePacientes;
    private javax.swing.JLabel jlComplementoFuncionarios;
    private javax.swing.JLabel jlComplementoPacientes;
    private javax.swing.JLabel jlConsultasDiaAtendMedico;
    private javax.swing.JLabel jlConsultasDiaAtendMedico1;
    private javax.swing.JLabel jlConvenioAgendamentos;
    private javax.swing.JLabel jlDataAdmFuncionarios;
    private javax.swing.JLabel jlDataAgendamentos;
    private javax.swing.JLabel jlDataAtendMedico;
    private javax.swing.JLabel jlDataAtualMenu;
    private javax.swing.JLabel jlDataDemFuncionarios;
    private javax.swing.JLabel jlDataNascFuncionarios;
    private javax.swing.JLabel jlDataNascPacienteAtendMedico;
    private javax.swing.JLabel jlDataNascPacientes;
    private javax.swing.JLabel jlDiagnosticoAtendMedico;
    private javax.swing.JLabel jlDoencasCronicasAtendMedico;
    private javax.swing.JLabel jlEmailFuncionarios;
    private javax.swing.JLabel jlEmailPacientes;
    private javax.swing.JLabel jlEspecialidadeAgendamentos;
    private javax.swing.JLabel jlEspecialistaAgendamentos;
    private javax.swing.JLabel jlEstadoCivilFuncionarios;
    private javax.swing.JLabel jlEstadoCivilPacientes;
    private javax.swing.JLabel jlEstadoFuncionarios;
    private javax.swing.JLabel jlEstadoPacientes;
    private javax.swing.JLabel jlFiltrarAgendamentos;
    private javax.swing.JLabel jlFiltrarAtendimentoAtendMedico;
    private javax.swing.JLabel jlFiltrarFuncionarios;
    private javax.swing.JLabel jlFiltrarPacientes;
    private javax.swing.JLabel jlFuncaoFuncionarios;
    private javax.swing.JLabel jlFuncionarioDesdeFuncionarios;
    private javax.swing.JLabel jlHistoricoConsultaAtendMedico;
    private javax.swing.JLabel jlHistoricoDoencasCronicasAtendMedico;
    private javax.swing.JLabel jlHoraAgendamentos;
    private javax.swing.JLabel jlHorasAtuaisMenu;
    private javax.swing.JLabel jlIDAgendamentos;
    private javax.swing.JLabel jlIDAtendMedico;
    private javax.swing.JLabel jlIDFuncionarios;
    private javax.swing.JLabel jlIDPacientes;
    private javax.swing.JLabel jlIconeMenu;
    private javax.swing.JLabel jlLogradouroFuncionarios;
    private javax.swing.JLabel jlLogradouroPacienteAtendMedico;
    private javax.swing.JLabel jlLogradouroPacientes;
    private javax.swing.JLabel jlMatriculaFuncionarios;
    private javax.swing.JLabel jlNacionalidadeFuncionarios;
    private javax.swing.JLabel jlNacionalidadePacientes;
    private javax.swing.JLabel jlNaturalidadeFuncionarios;
    private javax.swing.JLabel jlNaturalidadePacientes;
    private javax.swing.JLabel jlNomeFuncionarios;
    private javax.swing.JLabel jlNomeMenu;
    private javax.swing.JLabel jlNomePacientes;
    private javax.swing.JLabel jlNomeTelaAgendamentos;
    private javax.swing.JLabel jlNomeTelaAtendMedico;
    private javax.swing.JLabel jlNomeTelaFuncionarios;
    private javax.swing.JLabel jlNomeTelaPacientes;
    private javax.swing.JLabel jlNomeUsuario;
    private javax.swing.JLabel jlNumCasaFuncionarios;
    private javax.swing.JLabel jlNumCasaPacientes;
    private javax.swing.JLabel jlObservacoesAgendamentos;
    private javax.swing.JLabel jlOrgaoExpedFuncionarios;
    private javax.swing.JLabel jlOrgaoExpedidorPacientes;
    private javax.swing.JLabel jlPISFuncionarios;
    private javax.swing.JLabel jlPacienteAgendamentos;
    private javax.swing.JLabel jlPacienteAtendMedico;
    private javax.swing.JLabel jlPesquisarAgendamentos;
    private javax.swing.JLabel jlPesquisarFuncionarios;
    private javax.swing.JLabel jlPesquisarPacientes;
    private javax.swing.JLabel jlProcedimentoAgendamentos;
    private javax.swing.JLabel jlRGFuncionarios;
    private javax.swing.JLabel jlRGPacientes;
    private javax.swing.JLabel jlSerieUFFuncionarios;
    private javax.swing.JLabel jlSetaAgendamentos;
    private javax.swing.JLabel jlSetaAtendimentos;
    private javax.swing.JLabel jlSetaFinanceiro;
    private javax.swing.JLabel jlSetaLaboratorios;
    private javax.swing.JLabel jlSetaRegistros;
    private javax.swing.JLabel jlSetorFuncionarios;
    private javax.swing.JLabel jlSexoAtendMedico;
    private javax.swing.JLabel jlSexoFuncionarios;
    private javax.swing.JLabel jlSexoPacientes;
    private javax.swing.JLabel jlSloganMenu;
    private javax.swing.JLabel jlStatusAgendamentos;
    private javax.swing.JLabel jlTelefoneFixoAgendamentos;
    private javax.swing.JLabel jlTelefoneFixoFuncionarios;
    private javax.swing.JLabel jlTelefoneFixoPacientes;
    private javax.swing.JLabel jlTelefoneRecadoAgendamentos;
    private javax.swing.JLabel jlTelefoneRecadoFuncionarios;
    private javax.swing.JLabel jlTelefoneRecadoPacientes;
    private javax.swing.JLabel jlTipoAtendAgendamentos;
    private javax.swing.JLabel jlTipoLogradouroFuncionarios;
    private javax.swing.JLabel jlTipoPacientes;
    private javax.swing.JLabel jlTipoProcedimentoAgendamentos;
    private javax.swing.JLabel jlUsuarioMenu;
    private javax.swing.JLabel jldtDoAgendAgendamentos;
    private javax.swing.JPanel jpAgendamentos;
    private javax.swing.JPanel jpAgendamentosMenu;
    private javax.swing.JPanel jpAtendimentosMenu;
    private javax.swing.JPanel jpColunaBotoesMenu;
    private javax.swing.JPanel jpConsultaAtendMedico;
    private javax.swing.JPanel jpDadosDoAgendamentos;
    private javax.swing.JPanel jpDadosFuncionarios;
    private javax.swing.JPanel jpDadosPacienteAtendMedico;
    private javax.swing.JPanel jpDadosPessoaisFuncionarios;
    private javax.swing.JPanel jpDadosPessoaisPacientesRegistros;
    private javax.swing.JButton jpEditarFuncionarios;
    private javax.swing.JPanel jpEnfermeirosAtendimentos;
    private javax.swing.JPanel jpFinanceiroMenu;
    private javax.swing.JPanel jpFuncionariosRegistros;
    private javax.swing.JPanel jpHistoricoPacienteAtendMedico;
    private javax.swing.JPanel jpInserirResultadosLaboratorios;
    private javax.swing.JPanel jpLaborartoriosMenu;
    private javax.swing.JPanel jpListaDeAgendamentos;
    private javax.swing.JPanel jpListaFuncionarios;
    private javax.swing.JPanel jpListaPacientesRegistros;
    private javax.swing.JPanel jpMedicosAtendimentos;
    private javax.swing.JPanel jpMenuPrincipal;
    private javax.swing.JPanel jpNomeMenu;
    private javax.swing.JPanel jpPacientesRegistros;
    private javax.swing.JPanel jpPrincipalMenu;
    private javax.swing.JPanel jpRecebimentosFinanceiro;
    private javax.swing.JPanel jpRegistrosMenu;
    private javax.swing.JPanel jpVerResultadosLaboratorios;
    private javax.swing.JTable jtListaAgendamentos;
    private javax.swing.JTable jtListaFuncionarios;
    private javax.swing.JTable jtListaPacientes;
    private javax.swing.JTextField jtfBairroFuncionarios;
    private javax.swing.JTextField jtfBairroPacientes;
    private javax.swing.JTextField jtfCTPSFuncionarios;
    private javax.swing.JTextField jtfCidadeFuncionarios;
    private javax.swing.JTextField jtfCidadePacientes;
    private javax.swing.JTextField jtfComplementoFuncionarios;
    private javax.swing.JTextField jtfComplementoPacientes;
    private javax.swing.JTextField jtfConsultasDiaAtendMedico;
    private javax.swing.JTextField jtfEmailFuncionarios;
    private javax.swing.JTextField jtfEmailPacientes;
    private javax.swing.JTextField jtfIDAgendamentos;
    private javax.swing.JTextField jtfIDAtendMedico;
    private javax.swing.JTextField jtfIDFuncionarios;
    protected javax.swing.JTextField jtfIDPacientes;
    private javax.swing.JTextField jtfLogradouroFuncionarios;
    private javax.swing.JTextField jtfLogradouroPacienteAtendMedico;
    private javax.swing.JTextField jtfLogradouroPacientes;
    private javax.swing.JTextField jtfMatriculaFuncionarios;
    private javax.swing.JTextField jtfMatriculaMedicoAtendMedico;
    private javax.swing.JTextField jtfNomeFuncionarios;
    private javax.swing.JTextField jtfNomePacientes;
    private javax.swing.JTextField jtfNumeroCasaFuncionarios;
    private javax.swing.JTextField jtfNumeroCasaPacientes;
    private javax.swing.JTextField jtfOrgaoExpedFuncionarios;
    private javax.swing.JTextField jtfOrgaoExpedidorPacientes;
    private javax.swing.JTextField jtfPISFuncionarios;
    private javax.swing.JTextField jtfPesquisarAgendamentos;
    private javax.swing.JTextField jtfPesquisarFuncionarios;
    private javax.swing.JTextField jtfPesquisarPacientes;
    private javax.swing.JTextField jtfSerieUFFuncionarios;
    private javax.swing.JTextField jtfTipoLogradouroFuncionarios;
    private javax.swing.JTextField jtfTipoLogradouroPacientes;
    private javax.swing.JTextField jtfUFFuncionarios;
    private javax.swing.JTextField jtfUFPacientes;
    private javax.swing.JTextPane jtpDiagnosticoAtendMedico;
    private javax.swing.JTextPane jtpDoencasCronicasAtendMedico;
    private javax.swing.JTextPane jtpHistoricoConsultaAtendMedico;
    private javax.swing.JTextPane jtpHistoricoDoencasCronicasAtendMedico;
    private javax.swing.JTextPane jtpObservacoesAgendamentos;
    // End of variables declaration//GEN-END:variables

  
}
