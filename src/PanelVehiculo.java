import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelVehiculo extends JPanel implements ActionListener
{
	private InterfazImpuestosCarro Principal;
	private JTextField txtMarca;
	private JTextField txtLinea;
	private JTextField txtModelo;
	private JTextField txtValor;
	private JLabel labMarca;
	private JLabel labLinea;
	private JLabel labModelo;
	private JLabel labValor;
	private JLabel labVacio;
	private JButton butBuscar;
	

	public final static String BUSCAR = "buscar";
	
	public PanelVehiculo(InterfazImpuestosCarro v)
	{
		Principal=v;
		setLayout(new GridLayout(5,2));
		setPreferredSize(new Dimension(0,130));
		
		TitledBorder border = BorderFactory.createTitledBorder("Datos del vehiculo");
		border.setTitleColor(Color.BLUE);
		setBorder(border);
		
		labMarca = new JLabel("Marca");
		labLinea = new JLabel("Linea");
		labModelo = new JLabel("Modelo");
		labValor = new JLabel("Valor");
		txtMarca = new JTextField();
		txtLinea = new JTextField();
		txtModelo = new JTextField();
		txtValor = new JTextField("$ 0");
		labVacio = new JLabel("");
		butBuscar = new JButton("Buscar");
		
		txtValor.setEditable(false);
		txtValor.setForeground(Color.BLUE);
		txtValor.setBackground(Color.WHITE);
		
		add(labMarca);
		add(txtMarca);
		add(labLinea);
		add(txtLinea);
		add(labModelo);
		add(txtModelo);
		add(labValor);
		add(txtValor);
		add(labVacio);
		add(butBuscar);
		
		butBuscar.setActionCommand(BUSCAR);
		butBuscar.addActionListener(this);
		
		
		try
		{
			String strModelo = txtModelo.getText();
			int nModelo = Integer.parseInt(strModelo);
		}
		catch(Exception e)
		{
			txtModelo.setText("");
			
		}		
		
	}
	
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		
		if(comando.equals(BUSCAR)) {
			JOptionPane.showMessageDialog(this, "Botón buscar no funciona", "Calculo de Impuestos", JOptionPane.INFORMATION_MESSAGE);
		}	
	}
	
	public void refrescarPrecio(double precio)
	{
DecimalFormat df = (DecimalFormat)NumberFormat.getInstance();
		
		df.applyPattern("$ ###,###.##");
		txtValor.setText(df.format(precio));
	}
	
	public String darMarca()
	{
		return txtMarca.getText();
	}
	
	public String darLinea()
	{
		return txtLinea.getText();
	}
	
	public String darModelo()
	{
		return txtModelo.getText();
	}
	

}
