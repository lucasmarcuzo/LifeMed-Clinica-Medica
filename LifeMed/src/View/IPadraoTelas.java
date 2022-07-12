package View;

//@author LucasMarcuzo
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.geom.RoundRectangle2D;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public interface IPadraoTelas {
    
    //Deixando bordas arredondadas no form passado.
    default public void padraoBordasArredondadas(JFrame frm) {
        frm.setShape(new RoundRectangle2D.Double(0, 0, frm.getWidth(), frm.getHeight(), 20, 20));
    }
    
    //Insere icone Padrão no form passado.
    default public void padraoIconeForm(JFrame frm){
        frm.setIconImage(Toolkit.getDefaultToolkit().getImage("src/View/Images/icone-Lifemed-60.png"));
    }
    
    //Define as bordas dos botões do Menu como padrão.
    default public void padraoBotoesMenu(List<JButton> listaBotoesMenu){
        for (JButton lBotoesMenu : listaBotoesMenu) {
            lBotoesMenu.setBorderPainted(false);
            lBotoesMenu.setBorder(null);
        }
    }
    
    //Define setas dos botoes Menu na cor padrão.
    default public void padraoCorSetas(List<JLabel> listaLabelsSetas){
        for (JLabel lbSetas : listaLabelsSetas) {
            lbSetas.setIcon(new ImageIcon(getClass().getResource("/View/Images/seta-esquerda-13-30.png")));
            
        }
    }
    
    //Atualizar a Data atual do Panel.
    default public void atualizarDataAtual(JLabel lbDataAtual){
        lbDataAtual.setText(new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()));
    }
    
    //Atualizar a Hora atual do Panel.
    default public void atualizarHorasAtuais(JLabel lbHorasAtuais){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat hora = new SimpleDateFormat("HH:mm:ss");
        Timer timer = new Timer(1000, (ActionEvent e) ->{
        calendar.setTimeInMillis(calendar.getTimeInMillis()+1000);  
            lbHorasAtuais.setText(hora.format(calendar.getTime()));
        });
        timer.start();
    }
    
    
}
