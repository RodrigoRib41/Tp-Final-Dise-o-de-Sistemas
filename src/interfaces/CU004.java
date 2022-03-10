package interfaces;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.InputMap;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ScrollPaneConstants;
import java.awt.ScrollPane;
import java.awt.Panel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Component;

import clases.*;
import clasesDAO.*;
import gestores.*;
import clasesDTO.*;

public class CU004 {

	private JFrame frame;
	private JTextField textNombreCompetencia;
	private JTextField textCantidad;
	private JTextField txtCantidadSets;
	private JTextField txtCantidadDeTantos;
	private JTextField textPuntosPorPartidoG;
	private JTextField textPuntosPorPresentarse;
	private JTextField textPuntosPorEmpate;

	ArrayList<LugarDeRealizacion> lugares= new ArrayList<LugarDeRealizacion>();
	ArrayList<DisponibilidadAux> disp;
	int idUsuario;

	
	/**
	 * Create the application.
	 */
	public CU004(int idU) {
		idUsuario=idU;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 500, 625);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel labelNombeCompetencia = new JLabel("Nombre de la Competencia (*)");
		labelNombeCompetencia.setBounds(10, 11, 197, 19);
		
		JLabel labelDeporte = new JLabel("Deporte (*)");
		labelDeporte.setBounds(10, 41, 62, 14);
		
		JLabel labelLugarDeRealizacion = new JLabel("Lugar de Realizacion (*)");
		labelLugarDeRealizacion.setBounds(10, 66, 167, 14);
		
		JLabel labelCantidad = new JLabel("Cantidad (*)");
		labelCantidad.setBounds(258, 66, 133, 14);
		
		textNombreCompetencia = new JTextField();
		textNombreCompetencia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				labelNombeCompetencia.setForeground(Color.BLACK);
			}
		});
		textNombreCompetencia.setBounds(290, 10, 167, 20);
		textNombreCompetencia.addKeyListener(new KeyAdapter() {
			
			@SuppressWarnings("deprecation")
			@Override
			
			public void keyTyped(KeyEvent e) {
				InputMap map2 = textNombreCompetencia.getInputMap(JComponent.WHEN_FOCUSED);
			      map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK), "null");
				if(textNombreCompetencia.getText().length() >= 30) {
					e.consume();
					Toolkit.getDefaultToolkit().beep();
				}
			}
			
		});
		textNombreCompetencia.setColumns(10);
		
		
		
		JLabel labelModalidad = new JLabel("Modalidad de Competencia (*)");
		labelModalidad.setBounds(10, 172, 197, 14);
		
		
		
		JLabel labelFormaDePunt = new JLabel("Forma de Puntuacion (*)");
		labelFormaDePunt.setBounds(10, 210, 133, 14);
		JRadioButton radioButtonPuntuacion = new JRadioButton("Puntuacion");
		radioButtonPuntuacion.setBounds(159, 242, 109, 23);
		JRadioButton radioButtonResultadoFinal = new JRadioButton("Resultado Final");
		radioButtonResultadoFinal.setBounds(159, 277, 167, 23);
		JRadioButton radioButtonSets = new JRadioButton("Sets");
		radioButtonSets.setBounds(159, 206, 109, 23);
		radioButtonSets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(radioButtonSets.isSelected()) {
					txtCantidadSets.setEditable(true);
					txtCantidadSets.setEnabled(true);
					txtCantidadDeTantos.setEditable(false);
					txtCantidadDeTantos.setEnabled(false);
					txtCantidadDeTantos.setText("Cantidad de Tantos");
					radioButtonPuntuacion.setSelected(false);
					radioButtonResultadoFinal.setSelected(false);
				}
			}
		});
		
		
		radioButtonPuntuacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButtonPuntuacion.isSelected()) {
					txtCantidadSets.setEditable(false);
					txtCantidadSets.setEnabled(false);
					txtCantidadDeTantos.setEditable(true);
					txtCantidadDeTantos.setEnabled(true);
					txtCantidadSets.setText("Cantidad Maxima de Sets");
					radioButtonSets.setSelected(false);
					radioButtonResultadoFinal.setSelected(false);
				}
			}
		});
		
		
		radioButtonResultadoFinal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButtonResultadoFinal.isSelected()) {
					labelFormaDePunt.setForeground(Color.BLACK);
					txtCantidadSets.setEditable(false);
					txtCantidadSets.setEnabled(false);
					txtCantidadDeTantos.setEditable(false);
					txtCantidadDeTantos.setEnabled(false);
					txtCantidadDeTantos.setText("Cantidad de Tantos");
					txtCantidadSets.setText("Cantidad Maxima de Sets");
					radioButtonPuntuacion.setSelected(false);
					radioButtonSets.setSelected(false);
				}
			}
		});
		JButton buttonOk = new JButton("OK");

		textCantidad = new JTextField();
		
		
		textCantidad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				labelCantidad.setForeground(Color.BLACK);
			}
		});
		textCantidad.setBounds(349, 63, 42, 20);
		textCantidad.setText("0");
		textCantidad.addKeyListener(new KeyAdapter()
		{
		   @SuppressWarnings("deprecation")
		public void keyTyped(KeyEvent e)
		   {
		      char caracter = e.getKeyChar();
		      if(textCantidad.getText().length() >= 2 || (((caracter < '0') ||
				         (caracter > '9')) &&
				         (caracter != '\b' ))) {
					e.consume();
					Toolkit.getDefaultToolkit().beep();
					InputMap map2 = textCantidad.getInputMap(JComponent.WHEN_FOCUSED);
				      map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK), "null");}
		}});
		textCantidad.setColumns(10);
		
		
		txtCantidadSets = new JTextField();
		txtCantidadSets.setBounds(290, 206, 167, 20);
		txtCantidadSets.addKeyListener(new KeyAdapter()
		{
		   @SuppressWarnings("deprecation")
		public void keyTyped(KeyEvent e)
		   {
		      char caracter = e.getKeyChar();
		      if(txtCantidadSets.getText().length() >= 2 || (((caracter < '0') ||
				         (caracter > '9')) &&
				         (caracter != '\b' ))) {
					e.consume();
					Toolkit.getDefaultToolkit().beep();
					InputMap map2 = txtCantidadSets.getInputMap(JComponent.WHEN_FOCUSED);
				      map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK), "null");}
		     
		     
		   }
		});
		txtCantidadSets.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(radioButtonSets.isSelected()) {
				txtCantidadSets.setText("");
				labelFormaDePunt.setForeground(Color.BLACK);
			}
		}});
		txtCantidadSets.setFont(new Font("Arial Black", Font.PLAIN, 11));
		txtCantidadSets.setEditable(false);
		txtCantidadSets.setText("Cantidad Maxima de Sets ");
		txtCantidadSets.setEnabled(false);
		txtCantidadSets.setColumns(10);
		
		txtCantidadDeTantos = new JTextField();
		txtCantidadDeTantos.setBounds(292, 242, 165, 20);
		txtCantidadDeTantos.addKeyListener(new KeyAdapter()
		{
		   @SuppressWarnings("deprecation")
		public void keyTyped(KeyEvent e)
		   {
		      char caracter = e.getKeyChar();
		      if(txtCantidadDeTantos.getText().length() >= 2 || (((caracter < '0') ||
				         (caracter > '9')) &&
				         (caracter != '\b' ))) {
					e.consume();
					Toolkit.getDefaultToolkit().beep();
					InputMap map2 = txtCantidadDeTantos.getInputMap(JComponent.WHEN_FOCUSED);
				      map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK), "null");
				      }
		     
		     
		   }
		});
		txtCantidadDeTantos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(radioButtonPuntuacion.isSelected()) {
				txtCantidadDeTantos.setText("");
				labelFormaDePunt.setForeground(Color.BLACK);
			}}
		});
		txtCantidadDeTantos.setEditable(false);
		txtCantidadDeTantos.setEnabled(false);
		txtCantidadDeTantos.setFont(new Font("Arial Black", Font.PLAIN, 11));
		txtCantidadDeTantos.setText("Cantidad de Tantos");
		txtCantidadDeTantos.setColumns(10);
		
		JLabel labelSistemaLiga = new JLabel("Sistema de liga");
		labelSistemaLiga.setBounds(10, 311, 94, 14);
		
		JLabel labelPuntosPorPartidoG = new JLabel("Puntos por partido ganado (*)");
		labelPuntosPorPartidoG.setBounds(10, 336, 167, 14);
		labelPuntosPorPartidoG.setEnabled(false);
		
		JLabel labelPuntosPorPresentarse = new JLabel("Puntos por presentarse (*)");
		labelPuntosPorPresentarse.setBounds(249, 336, 176, 14);
		labelPuntosPorPresentarse.setEnabled(false);
		
		JLabel labelPuntosPorEmpate = new JLabel("Puntos por empate (*)");
		labelPuntosPorEmpate.setBounds(161, 366, 133, 14);
		labelPuntosPorEmpate.setEnabled(false);
	
		
		
		textPuntosPorPartidoG = new JTextField();
		textPuntosPorPartidoG.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				labelPuntosPorPartidoG.setForeground(Color.BLACK);
			}
		});
		textPuntosPorPartidoG.setBounds(197, 333, 42, 20);
		textPuntosPorPartidoG.setEditable(false);
		textPuntosPorPartidoG.setEnabled(false);
		textPuntosPorPartidoG.addKeyListener(new KeyAdapter(){
		   @SuppressWarnings("deprecation")
		public void keyTyped(KeyEvent e)
		   {
		      char caracter = e.getKeyChar();
		      if(textPuntosPorPartidoG.getText().length() >= 2 || (((caracter < '0') ||
				         (caracter > '9')) &&
				         (caracter != '\b' ))) {
					e.consume();
					Toolkit.getDefaultToolkit().beep();
					InputMap map2 = textPuntosPorPartidoG.getInputMap(JComponent.WHEN_FOCUSED);
				      map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK), "null");}
		      
		   }
		});
		textPuntosPorPartidoG.setColumns(10);
		
		textPuntosPorPresentarse = new JTextField();
		
		textPuntosPorPresentarse.setBounds(410, 333, 47, 20);
		textPuntosPorPresentarse.setEditable(false);
		textPuntosPorPresentarse.setEnabled(false);
		textPuntosPorPresentarse.addKeyListener(new KeyAdapter()
		{
		   @SuppressWarnings("deprecation")
		public void keyTyped(KeyEvent e)
		   {
		      char caracter = e.getKeyChar();
		      if(textPuntosPorPresentarse.getText().length() >= 2 || (((caracter < '0') ||
				         (caracter > '9')) &&
				         (caracter != '\b' ))) {
					e.consume();
					Toolkit.getDefaultToolkit().beep();
					InputMap map2 = textPuntosPorPresentarse.getInputMap(JComponent.WHEN_FOCUSED);
				      map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK), "null");}
		      
		   }
		});
		textPuntosPorPresentarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				labelPuntosPorPresentarse.setForeground(Color.BLACK);
			}
		});
	
		textPuntosPorPresentarse.setColumns(10);
		JRadioButton radioButtonEmpate = new JRadioButton("Empate");
		radioButtonEmpate.setBounds(10, 357, 109, 23);
		radioButtonEmpate.setEnabled(false);
		
		radioButtonEmpate.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				labelPuntosPorEmpate.setEnabled(false);
				if(radioButtonEmpate.isSelected()) {
					textPuntosPorEmpate.setEnabled(true);
					textPuntosPorEmpate.setEditable(true);
					labelPuntosPorEmpate.setEnabled(true);
				}
				else {textPuntosPorEmpate.setEditable(false);
				textPuntosPorEmpate.setText("");
				textPuntosPorEmpate.setEnabled(false);
				labelPuntosPorEmpate.setForeground(Color.BLACK);
				
				
			}
			}});
	
		
		
	
		
		JLabel labelReglamento = new JLabel("Reglamento");
		labelReglamento.setBounds(10, 396, 94, 14);
		
		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setBounds(10, 540, 89, 23);
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CU003 window = new CU003(idUsuario);
							window.getFrame().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				frame.dispose();
			}
		});
		
		
		
		JComboBox<Deporte> textDeporte = new JComboBox<Deporte>();
		
		ArrayList<Deporte> deportes= GestorCompetencia.obtenerAllDeportes();
		
		for(Deporte d:deportes) {
			textDeporte.addItem(d);
		}
		
		
		textDeporte.setSelectedItem(null);
		
		textDeporte.setBounds(290, 37, 165, 22);
		
		textDeporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 lugares=GestorLugarDeRealizacion.getLugaresDisponibles((Deporte)textDeporte.getSelectedItem(),idUsuario);
				 
				 disp= new ArrayList<DisponibilidadAux>();
				 
				 for(LugarDeRealizacion l:lugares) {
				 disp.add(new DisponibilidadAux(l.getIdLugarDeRealizacion(),(int)(Math.random()*10+1),l.getNombrelugar()));
				 }
				 textCantidad.setText("0");
				 labelCantidad.setForeground(Color.BLACK);
				 buttonOk.doClick();
				
				 
			/*if(textDeporte.getSelectedItem().toString() == "Futbol" || textDeporte.getSelectedItem().toString() == "Basquet"){
				radioButtonSets.setEnabled(false);
			}
				else {radioButtonSets.setEnabled(true);
				}
			if(textDeporte.getSelectedItem().toString() == "Voley" || textDeporte.getSelectedItem().toString() == "Tenis" || textDeporte.getSelectedItem().toString() == "Basquet") {
				radioButtonEmpate.setEnabled(false);
			}
			else {
				radioButtonEmpate.setEnabled(true);
			}*/
				
			}
			}
		);
		
		textDeporte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				labelDeporte.setForeground(Color.BLACK);
			}
		});
		textPuntosPorEmpate = new JTextField();
		textPuntosPorEmpate.setBounds(290, 361, 47, 20);
		textPuntosPorEmpate.setEditable(false);
		textPuntosPorEmpate.setEnabled(false);
		textPuntosPorEmpate.addKeyListener(new KeyAdapter()
		{
		   @SuppressWarnings("deprecation")
		public void keyTyped(KeyEvent e)
		   {
		      char caracter = e.getKeyChar();
		      if(textPuntosPorEmpate.getText().length() >= 2 || (((caracter < '0') ||
				         (caracter > '9')) &&
				         (caracter != '\b' ))) {
					e.consume();
					Toolkit.getDefaultToolkit().beep();
					InputMap map2 = textPuntosPorEmpate.getInputMap(JComponent.WHEN_FOCUSED);
				      map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK), "null");}
		      
		   }
		});
		textPuntosPorEmpate.setColumns(10);
		
		textPuntosPorEmpate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				labelPuntosPorEmpate.setForeground(Color.BLACK);
			}
		});
		
		
		
		JComboBox<String> comboBoxModalidad = new JComboBox<String>();
		comboBoxModalidad.setBounds(260, 168, 197, 22);
		comboBoxModalidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPuntosPorEmpate.setEnabled(false);
				if(comboBoxModalidad.getSelectedItem().toString()== "Sistema Liga") {
					radioButtonEmpate.setEnabled(true);
					labelPuntosPorPartidoG.setEnabled(true);
					labelPuntosPorPresentarse.setEnabled(true);
					
					textPuntosPorPresentarse.setEnabled(true);
					textPuntosPorPresentarse.setEditable(true);
					textPuntosPorPartidoG.setEnabled(true);
					textPuntosPorPartidoG.setEditable(true);
			}
				else {radioButtonEmpate.setEnabled(false);
				radioButtonEmpate.setSelected(false);
				labelPuntosPorPartidoG.setEnabled(false);
				labelPuntosPorPresentarse.setEnabled(false);
				textPuntosPorPartidoG.setText("");
				textPuntosPorPresentarse.setText("");
				textPuntosPorEmpate.setText("");
				labelPuntosPorEmpate.setEnabled(false);
				textPuntosPorPresentarse.setEnabled(false);
				textPuntosPorPresentarse.setEditable(false);
				textPuntosPorPartidoG.setEnabled(false);
				textPuntosPorPartidoG.setEditable(false);
				
				}
			}});
		comboBoxModalidad.addItem("Sistema Liga");
		comboBoxModalidad.addItem("Eliminacion Simple");
		comboBoxModalidad.addItem("Eliminacion Doble");
		
		JTextArea textAreaReglamento = new JTextArea();
		textAreaReglamento.setBounds(10, 421, 415, 108);
		textAreaReglamento.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void keyTyped(KeyEvent e) {
				if(textAreaReglamento.getText().length() >= 800) {
					e.consume();
					Toolkit.getDefaultToolkit().beep();
					InputMap map2 = textAreaReglamento.getInputMap(JComponent.WHEN_FOCUSED);
				      map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK), "null");
				      
				}
			}
		});
		textAreaReglamento.setLineWrap(true);
		getFrame().getContentPane().setLayout(null);
		getFrame().getContentPane().add(labelNombeCompetencia);
		getFrame().getContentPane().add(labelDeporte);
		getFrame().getContentPane().add(labelLugarDeRealizacion);
		getFrame().getContentPane().add(labelCantidad);
		getFrame().getContentPane().add(textNombreCompetencia);
		getFrame().getContentPane().add(textCantidad);
		getFrame().getContentPane().add(labelModalidad);
		getFrame().getContentPane().add(labelFormaDePunt);
		getFrame().getContentPane().add(radioButtonSets);
		getFrame().getContentPane().add(radioButtonPuntuacion);
		getFrame().getContentPane().add(radioButtonResultadoFinal);
		getFrame().getContentPane().add(txtCantidadSets);
		getFrame().getContentPane().add(txtCantidadDeTantos);
		getFrame().getContentPane().add(labelSistemaLiga);
		getFrame().getContentPane().add(labelPuntosPorPartidoG);
		getFrame().getContentPane().add(labelPuntosPorPresentarse);
		getFrame().getContentPane().add(labelPuntosPorEmpate);
		
		
		getFrame().getContentPane().add(textPuntosPorPartidoG);
		getFrame().getContentPane().add(textPuntosPorPresentarse);
		getFrame().getContentPane().add(radioButtonEmpate);
		getFrame().getContentPane().add(textPuntosPorEmpate);
		getFrame().getContentPane().add(labelReglamento);
		getFrame().getContentPane().add(buttonCancelar);
		
		getFrame().getContentPane().add(textDeporte);
		getFrame().getContentPane().add(comboBoxModalidad);
		getFrame().getContentPane().add(textAreaReglamento);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(10, 91, 447, 63);
		getFrame().getContentPane().add(scrollPane);
		
		
		
		
		 class ComboBoxAux implements ActionListener{
			 
			 ArrayList<JComboBox> comboBoxesLugar=new ArrayList<JComboBox>();
			 ArrayList<JTextField> disponibilidades=new ArrayList<JTextField>();
			 
			 
			 public ArrayList<JComboBox> getcomboBoxesLugar() {
				return comboBoxesLugar;
			}
			 public ArrayList<JTextField> getDisponibilidades() {
					return disponibilidades;
				}


			public void setcomboBoxesLugar(ArrayList<JComboBox> comboBoxesLugar) {
				this.comboBoxesLugar=null;
				this.comboBoxesLugar = comboBoxesLugar;
			}
			public void setDisponibilidades(ArrayList<JTextField> disponibilidades) {
				this.disponibilidades=null;
				this.disponibilidades = disponibilidades;
			}


			@Override
			public void actionPerformed(ActionEvent e) {
				int cantidad,contador=0;
				 ArrayList<JComboBox> comboBoxesLugar2=new ArrayList<JComboBox>();
				 JPanel panelLugaresDeRealizacion = new JPanel();
			    cantidad=Integer.parseInt(textCantidad.getText());
	
				if(cantidad>lugares.size()) {
					if(lugares.size()==0) {
						labelCantidad.setForeground(Color.RED);
						JOptionPane.showMessageDialog(null,"No existen lugares disponibles");
					}
					else {
					labelCantidad.setForeground(Color.RED);
					JOptionPane.showMessageDialog(null,"La cantidad maxima de cantidades puede ser "+lugares.size());
					}
					}
				else {
					panelLugaresDeRealizacion.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
					panelLugaresDeRealizacion.setPreferredSize(new Dimension(360, 35*cantidad));
					panelLugaresDeRealizacion.setLayout(null);
				panelLugaresDeRealizacion.setAutoscrolls(true);
				scrollPane.setViewportView(panelLugaresDeRealizacion);
			
				
				
				ArrayList<JLabel> labelsLugar=new ArrayList<JLabel>();
				
				ArrayList<JLabel> labelsDisponibilidad=new ArrayList<JLabel>();
				ArrayList<JTextField> textDisponibilidad=new ArrayList<JTextField>();
				int agregadoY=0;
				while(contador<cantidad) {
					
					
					
				labelsLugar.add(new JLabel("Lugar"));
				
				labelsDisponibilidad.add(new JLabel("Disponibilidad"));
				comboBoxesLugar2.add(new JComboBox<DisponibilidadAux>());
				textDisponibilidad.add(new JTextField());
				
				
				int i=0;
				while(lugares.size()>i) {
				comboBoxesLugar2.get(contador).addItem((DisponibilidadAux)disp.get(i));
				i++;
				}
				comboBoxesLugar2.get(contador).setSelectedItem(null);
				comboBoxesLugar2.get(contador).addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						 labelLugarDeRealizacion.setForeground(Color.BLACK);
					}
				});
				
				
				
				
				
				labelsLugar.get(contador).setBounds(25, 15+agregadoY, 46, 20);
				
				panelLugaresDeRealizacion.add(labelsLugar.get(contador));
				
				comboBoxesLugar2.get(contador).setBounds(67, 15+agregadoY, 97, 20);
				
				panelLugaresDeRealizacion.add(comboBoxesLugar2.get(contador));
				
               labelsDisponibilidad.get(contador).setBounds(181, 15+agregadoY, 100, 20);
				panelLugaresDeRealizacion.add(labelsDisponibilidad.get(contador));
				
				textDisponibilidad.get(contador).setBounds(267, 15+agregadoY, 27, 20);
				textDisponibilidad.get(contador).setText("0");
					
				textDisponibilidad.get(contador).setEditable(true);
				textDisponibilidad.get(contador).setColumns(10);
				class DispKeyEvent extends KeyAdapter{
					  public int contador=0; 
					
					  public DispKeyEvent(int i) {this.contador=i;}
					
					
					@SuppressWarnings("deprecation")
						public void keyTyped(KeyEvent e)
						   {
						      char caracter = e.getKeyChar();
						      if(textDisponibilidad.get(contador).getText().length() >= 2 || (((caracter < '0') ||
								         (caracter > '9')) &&
								         (caracter != '\b' ))) {
									e.consume();
									Toolkit.getDefaultToolkit().beep();
									InputMap map2 = textCantidad.getInputMap(JComponent.WHEN_FOCUSED);
								      map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK), "null");}}}
				
				
				textDisponibilidad.get(contador).addKeyListener(new DispKeyEvent(contador));
				
				
				
				
				
				
				
				
				
				
				panelLugaresDeRealizacion.add(textDisponibilidad.get(contador));
					
				
				
				
				agregadoY=agregadoY+30;
				contador++;
				}
									
			this.setcomboBoxesLugar(comboBoxesLugar2);
			this.setDisponibilidades(textDisponibilidad);
			}
			
			
		}
		 }
		 ComboBoxAux aux= new ComboBoxAux();
		 buttonOk.addActionListener(aux);
		 
		
		
		
		buttonOk.setBounds(401, 62, 56, 23);
		getFrame().getContentPane().add(buttonOk);
		

		
		
		
		JButton buttonAceptar = new JButton("Aceptar");
		buttonAceptar.setBounds(368, 540, 89, 23);
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			
				Boolean ok=true;
				
				CompetenciaDTO dto=new CompetenciaDTO();
				if(textNombreCompetencia.getText().length()==0) {
					labelNombeCompetencia.setForeground(Color.RED);
					ok=false;
				}
				else {
					dto.setNombre(textNombreCompetencia.getText());
				}
				
				if(Integer.parseInt(textCantidad.getText())==0) {
					labelCantidad.setForeground(Color.RED);
					ok=false;
				}
			if(radioButtonSets.isSelected()) {
				if(txtCantidadSets.getText().length()==24 || txtCantidadSets.getText().length()==0) {
					ok=false;
					labelFormaDePunt.setForeground(Color.RED);
					
				}
				else {	
					dto.setFormaDePuntuacion("Sets");
					dto.setCantMaxSets(Integer.parseInt(txtCantidadSets.getText()));
				}
			}
			if(radioButtonPuntuacion.isSelected()) {
				if(txtCantidadDeTantos.getText().length()==18 || txtCantidadDeTantos.getText().length()==0) {
					ok=false;
					labelFormaDePunt.setForeground(Color.RED);
				}
				else {
					dto.setFormaDePuntuacion("Puntuacion");
					dto.setCantMaxTantos(Integer.parseInt(txtCantidadDeTantos.getText()));
				}
				}
			
			if(radioButtonResultadoFinal.isSelected()) {
				dto.setFormaDePuntuacion("Resultado Final");
				
			}
			if(!(radioButtonPuntuacion.isSelected() || radioButtonSets.isSelected() || radioButtonResultadoFinal.isSelected())) {
				ok=false;
				labelFormaDePunt.setForeground(Color.RED);
			}
			if(labelPuntosPorPartidoG.isEnabled()) {
				if(textPuntosPorPartidoG.getText().length()==0) {
					ok=false;
					labelPuntosPorPartidoG.setForeground(Color.RED);
				}
				else {
					dto.setPuntosPartidoGanado(Integer.parseInt(textPuntosPorPartidoG.getText()));	
				}
				if(textPuntosPorPresentarse.getText().length()==0) {
					ok=false;
					labelPuntosPorPresentarse.setForeground(Color.RED);
				}
				else {
					dto.setPuntosPartidoJugado(Integer.parseInt(textPuntosPorPartidoG.getText()));
				}
			}
			if(radioButtonEmpate.isSelected()) {
				if(textPuntosPorEmpate.getText().length()==0) {
					ok=false;
					labelPuntosPorEmpate.setForeground(Color.RED);
				}
				else {	
					dto.setPuntosEmpate(Integer.parseInt(textPuntosPorEmpate.getText()));
				}
			}	
		ArrayList<JComboBox> listaLugares=aux.getcomboBoxesLugar();
		ArrayList<JTextField> listaDisponibilidades=aux.getDisponibilidades();
		ArrayList<DisponibilidadAux> lista=new ArrayList<DisponibilidadAux>();
		for(JComboBox j:listaLugares) {
			if(j.getSelectedItem()==null) {
				labelLugarDeRealizacion.setForeground(Color.RED);
				ok=false;
				break;
			}
			else {
				lista.add((DisponibilidadAux)j.getSelectedItem());
			}
		}
		
		for(int i=0;i<lista.size();i++) {
		
			if(listaDisponibilidades.get(i).getText().length()==0) {
				labelLugarDeRealizacion.setForeground(Color.RED);
				ok=false;
				break;
			}
			else {
			
			lista.get(i).setCantidad(Integer.parseInt(listaDisponibilidades.get(i).getText()));
		
			}
		
		
		}
		
		
		
		if(textDeporte.getSelectedItem() == null) {
			labelDeporte.setForeground(Color.RED);
			ok=false;
		}
		else {
			
			Deporte dep=(Deporte)textDeporte.getSelectedItem();
			dto.setIdDeporte(dep.getIdDeporte());
			
		}
       String lugaresRepetidos="";
		padre:for(int i=0;i<lista.size();i++) {
			for(int j=0;j<lista.size();j++) {
				
				if(lista.get(i).getIdLugar()==lista.get(j).getIdLugar() && j!=i) {
					labelLugarDeRealizacion.setForeground(Color.RED);
				lugaresRepetidos=lugaresRepetidos+"No puede elegir lugares de realizacion repetidos";	
				break padre;
				}
			}
			
		}
		
		
		
			if(!ok && lugaresRepetidos.length()>0) {
			JOptionPane.showMessageDialog(null,"Debe Completar Todos los Campos (*)"+lugaresRepetidos);
			}
			else if(!ok) {
				JOptionPane.showMessageDialog(null,"Debe Completar Todos los Campos (*)");
			}
			else if(lugaresRepetidos.length()>0) {
				JOptionPane.showMessageDialog(null,lugaresRepetidos);
			}
			else {	
				if(JOptionPane.showConfirmDialog(frame, "¿Esta seguro que desea continuar?",
			            "Confirmacion", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
				dto.setLugares(lista);
				dto.setReglamento(textAreaReglamento.getText());
				dto.setModalidad(comboBoxModalidad.getSelectedItem().toString());
				dto.setIdUsuario(idUsuario);
				
				int creada=GestorCompetencia.crearCompetencia(dto);
				
				
				if(creada==0) {JOptionPane.showMessageDialog(null,"Competencia Creada con Exito");
				System.out.println(dto.toString());
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CU003 window = new CU003(idUsuario);
							window.getFrame().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				frame.dispose();}
				}
			}
			}
			
		}
		);
		buttonAceptar.setBounds(342, 540, 89, 23);
		getFrame().getContentPane().add(buttonAceptar);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}