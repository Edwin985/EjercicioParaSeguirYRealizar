import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelResultados extends JPanel implements ActionListener
{
	private InterfazImpuestosCarro Principal;
	private JLabel labTotal;
	private JTextField txtTotal;
	private JButton butLimpiar;
	private JButton butCalcular;

	public final static String LIMPIAR = "limpiar";
	public final static String CALCULAR = "calcular";
	
	public PanelResultados(InterfazImpuestosCarro v)
	{
		Principal=v;
		setLayout(new GridLayout(2,3));
		setPreferredSize(new Dimension(0,65));
		
		TitledBorder border = BorderFactory.createTitledBorder("Resultados");
		border.setTitleColor(Color.BLUE);
		setBorder(border);
		
		labTotal = new JLabel("Total a pagar");
		txtTotal = new JTextField("$0");
		butLimpiar = new JButton("Limpiar");
		butCalcular = new JButton("Calcular");
		
		txtTotal.setEditable(false);
		txtTotal.setForeground(Color.BLUE);
		txtTotal.setBackground(Color.WHITE);
		
		add(new JLabel(""));
		add(new JLabel(""));
		add(butLimpiar);
		add(labTotal);
		add(txtTotal);
		add(butCalcular);
		
		butLimpiar.setActionCommand(LIMPIAR);
		butCalcular.setActionCommand(CALCULAR);
		
		butLimpiar.addActionListener(this);
		butCalcular.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent evento)
	{
		String comando = evento.getActionCommand();
		
		if(comando.equals(LIMPIAR))
		{
			//Reaccion al evento de LIMPIAR
			JOptionPane.showMessageDialog(this, "Botón limpiar no funciona", "Calculo de Impuestos", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(comando.equals(CALCULAR))
		{
			//Reaccion al evento de CALCULAR
			JOptionPane.showMessageDialog(this, "Botón cancelar no funciona", "Calculo de Impuestos", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void refrescarPago(double pago) {
		// TODO Auto-generated method stub
		
	}

}
