package interfaces;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import clases.Deporte;
import clasesDTO.CompetenciaDTO;
import gestores.GestorCompetencia;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class CU003 {

	private JFrame frame;
	static int idUsuario;
	private JTextField textField;

	/**
	 * Create the application.
	 */
	public CU003(int idU) {
		idUsuario=idU;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 626, 449);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Competencias Deportivas");
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(10, 22, 590, 142);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(157, 11, 182, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JComboBox estado = new JComboBox();
		estado.addItem("Creada");
		estado.addItem("Planificada");
		estado.addItem("En Disputa");
		estado.addItem("Finalizada");
		estado.setSelectedItem(null);
		estado.setBounds(10, 59, 137, 22);
		panel.add(estado);
	
		
		JComboBox modalidad = new JComboBox();
		modalidad.addItem("Sistema Liga");
		modalidad.addItem("Eliminacion Simple");
		modalidad.addItem("Eliminacion Doble");
		modalidad.setSelectedItem(null);
		modalidad.setBounds(232, 59, 137, 22);
		panel.add(modalidad);
		
		
		JComboBox deporte = new JComboBox();
ArrayList<Deporte> deportes= GestorCompetencia.obtenerAllDeportes();
		for(Deporte d:deportes) {
			deporte.addItem(d);
		}
		deporte.setSelectedItem(null);
		deporte.setBounds(424, 59, 137, 22);
		panel.add(deporte);
		
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(303, 108, 101, 23);
		panel.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("Limpiar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estado.setSelectedItem(null);
				modalidad.setSelectedItem(null);
				deporte.setSelectedItem(null);
				textField.setText("");
			}
		});
		btnNewButton_1.setBounds(479, 108, 101, 23);
		panel.add(btnNewButton_1);
		
		
		JTextPane txtpnNombreCompetencia = new JTextPane();
		txtpnNombreCompetencia.setText("Nombre Competencia:");
		txtpnNombreCompetencia.setBounds(10, 11, 137, 20);
		panel.add(txtpnNombreCompetencia);
		
		JTextPane txtpnEstado = new JTextPane();
		txtpnEstado.setText("Estado");
		txtpnEstado.setBounds(10, 42, 94, 20);
		panel.add(txtpnEstado);
		
		JTextPane txtpnModalidad = new JTextPane();
		txtpnModalidad.setText("Modalidad");
		txtpnModalidad.setBounds(232, 42, 94, 20);
		panel.add(txtpnModalidad);
		
		JTextPane txtpnDeporte = new JTextPane();
		txtpnDeporte.setText("Deporte");
		txtpnDeporte.setBounds(424, 42, 113, 20);
		panel.add(txtpnDeporte);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 196, 590, 150);
		frame.getContentPane().add(scrollPane);
		 
		class Resultados implements ActionListener{
		
			String n;
			String es;
			String m;
			String d;
			ArrayList<CompetenciaDTO> competencias;
			
		
			
			
			
		
			@Override
			public void actionPerformed(ActionEvent e) {

				this.n="all";
				this.es="all";
				this.m="all";
				this.d="all";
				
				if(!textField.getText().isEmpty()) {
					System.out.println(textField.getText()+"<-");
			    	 n=textField.getText().toLowerCase();
			     
				}
			     if(estado.getSelectedItem()!=null) {
			    	 
			    	 es=estado.getSelectedItem().toString().toLowerCase();
			    	
			     }
			     if(modalidad.getSelectedItem()!=null) {
			    	 
			    	 m=modalidad.getSelectedItem().toString().toLowerCase();
			    	 
			     }
			     if(deporte.getSelectedItem()!=null) {
			    	 
			    	 d=deporte.getSelectedItem().toString().toLowerCase();
			    	 
			     }
				
				System.out.println("-"+n+"-"+es+"-"+m+"-"+d+"-");
				competencias=GestorCompetencia.buscarCompetencias(n,es,m,d,0);
				
				for(CompetenciaDTO c:competencias) {
					System.out.println(c.getNombre()+" "+c.getModalidad());
				}
				
				// TODO Auto-generated method stub
				int cantidad=competencias.size(); /*Setear la cantidad de resultados encontrados en la busqueda*/
				int contador=0;
				int agregadoY=0;
				 JPanel panelResultados = new JPanel();
				 panelResultados.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					panelResultados.setPreferredSize(new Dimension(360, 35*cantidad));
					panelResultados.setLayout(null);
				panelResultados.setAutoscrolls(true);
				scrollPane.setViewportView(panelResultados);
				ArrayList<JLabel> labelsCompetencia=new ArrayList<JLabel>();
				ArrayList<JLabel> labelsEstado=new ArrayList<JLabel>();
				ArrayList<JLabel> labelsModalidad=new ArrayList<JLabel>();
				ArrayList<JLabel> labelsDeporte=new ArrayList<JLabel>();
				
				ArrayList<JTextField> competencia2=new ArrayList<JTextField>();
				 ArrayList<JTextField> estado2=new ArrayList<JTextField>();
				 ArrayList<JTextField> modalidad2=new ArrayList<JTextField>();
				 ArrayList<JTextField> deporte2=new ArrayList<JTextField>();
				 ArrayList<JButton>  detalle2=new ArrayList<JButton>();
				
				
				labelsCompetencia.add(new JLabel("Competencia"));
				labelsEstado.add(new JLabel("Estado"));
				labelsModalidad.add(new JLabel("Modalidad"));
				labelsDeporte.add(new JLabel("Deporte"));
				detalle2.add(new JButton("Ver Detalle"));
				
				
				labelsCompetencia.get(contador).setBounds(10, 11, 85, 14);
				panelResultados.add(labelsCompetencia.get(contador));
				labelsEstado.get(contador).setBounds(378, 11, 46, 14);
				panelResultados.add(labelsEstado.get(contador));
				labelsModalidad.get(contador).setBounds(254, 11, 79, 14);
				panelResultados.add(labelsModalidad.get(contador));
				labelsDeporte.get(contador).setBounds(144, 11, 63, 14);
				panelResultados.add(labelsDeporte.get(contador));
				
				while(cantidad>contador) {
					int contadorAux=contador;
					competencia2.add(new JTextField());
					competencia2.get(contador).setBounds(10, 41+agregadoY, 110, 20);
			/*agregar settext de la competencia del resultado de busqueda, igual con deporte,modalidad,etc*/
					
					competencia2.get(contador).setEditable(false);
					competencia2.get(contador).setText(competencias.get(contador).getNombre());
					panelResultados.add(competencia2.get(contador));
					deporte2.add(new JTextField());
					deporte2.get(contador).setBounds(144, 41+agregadoY, 85, 20);
					
					deporte2.get(contador).setEditable(false);
					deporte2.get(contador).setText(competencias.get(contador).getDeporte());
					panelResultados.add(deporte2.get(contador));
					modalidad2.add(new JTextField());
					modalidad2.get(contador).setBounds(254, 41+agregadoY, 100, 20);
					
					modalidad2.get(contador).setEditable(false);
					modalidad2.get(contador).setText(competencias.get(contador).getModalidad());
					panelResultados.add(modalidad2.get(contador));
					estado2.add(new JTextField());
					estado2.get(contador).setBounds(378, 41+agregadoY, 75, 20);
					
					estado2.get(contador).setEditable(false);
					estado2.get(contador).setText(competencias.get(contador).getEstado());
					panelResultados.add(estado2.get(contador));
					detalle2.add(new JButton("Ver Detalle")); 
					detalle2.get(contador).setBounds(470, 41+agregadoY, 96, 23);
					detalle2.get(contador).addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										CU020 window = new CU020(competencias.get(contadorAux).getIdCompetencia(),idUsuario);
										window.getFrame().setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
							frame.dispose();
						}
					});
					
					panelResultados.add(detalle2.get(contador));
					
					
					agregadoY=agregadoY+30;
					contador++;
				}
				
				
				
			}
			 
			 
		}
		
		
	    
	     
		 Resultados aux= new Resultados();
		 btnNewButton.addActionListener(aux);
		 
		
		JButton crearcompetencia = new JButton("Crear Competencia");
		crearcompetencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CU004 window = new CU004(idUsuario);
							window.getFrame().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				frame.dispose();
			}
		});
		crearcompetencia.setBounds(442, 370, 158, 23);
		frame.getContentPane().add(crearcompetencia);
		
		JButton regresar = new JButton("Regresar");
		regresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Principal window = new Principal(idUsuario);
							window.frame().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				frame.dispose();
			}
		});
		regresar.setBounds(10, 370, 126, 23);
		frame.getContentPane().add(regresar);
		
		JTextPane txtpnResultadoDeBusqueda = new JTextPane();
		txtpnResultadoDeBusqueda.setEditable(false);
		txtpnResultadoDeBusqueda.setText("Resultado de Busqueda");
		txtpnResultadoDeBusqueda.setBounds(10, 175, 244, 20);
		frame.getContentPane().add(txtpnResultadoDeBusqueda);
		
		JTextPane txtpnBusquedaDeCompetencias = new JTextPane();
		txtpnBusquedaDeCompetencias.setText("Busqueda de Competencias");
		txtpnBusquedaDeCompetencias.setEditable(false);
		txtpnBusquedaDeCompetencias.setBounds(10, 0, 224, 20);
		frame.getContentPane().add(txtpnBusquedaDeCompetencias);
		
	
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
