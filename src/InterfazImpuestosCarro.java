import java.awt.*;
import javax.swing.*;
public class InterfazImpuestosCarro extends JFrame
{
	private CalculadorImpuestos calculador;
	private PanelVehiculo panelVehiculo;
	private PanelDescuentos panelDescuentos;
	private PanelResultados panelResultados;
	
	public InterfazImpuestosCarro() throws Exception
	{
		calculador = new CalculadorImpuestos();
		setTitle( "Calculo impuestos");
		setSize(290,300);
		setResizable(false);
		setDefaultCloseOperation( EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		panelVehiculo = new PanelVehiculo(null);
		add(panelVehiculo,BorderLayout.NORTH);
		
		panelDescuentos = new PanelDescuentos();
		add(panelDescuentos,BorderLayout.CENTER);
		
		panelResultados = new PanelResultados(null);
		add(panelResultados,BorderLayout.SOUTH);
	}


	public static void main (String[] args) throws Exception
	{
		InterfazImpuestosCarro Vent = new InterfazImpuestosCarro();
		Vent.setVisible(true);
	}
	
	public void CalcularPrecioVehiculo() throws Exception
	{
		String unaMarca = panelVehiculo.darMarca();
		String unaLinea = panelVehiculo.darLinea();
		String unModelo = panelVehiculo.darModelo();
		
		double precio = calculador.buscarAvaluoVehiculo(unaMarca,  unaLinea,  unModelo);
		
		panelVehiculo.refrescarPrecio(precio);
	}
	
	public void calcularImpuestos()
	{
		String unaMarca = panelVehiculo.darMarca();
		String unaLinea = panelVehiculo.darLinea();
		String unModelo = panelVehiculo.darModelo();
		
		boolean descProntoPago=panelDescuentos.hayDescuentoProntoPago();
		boolean descServicioPublico=panelDescuentos.hayDescuentoServicioPublico();
		boolean descTrasladoCuenta = panelDescuentos.hayDescuentoTrasladoCuenta();
		
		double pago= calculador.calcularPago(unaMarca, unaLinea,unModelo,descProntoPago,descServicioPublico,descTrasladoCuenta);
		
		panelResultados.refrescarPago(pago);
	}
}



