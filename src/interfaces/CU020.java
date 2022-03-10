package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

import clases.Fixture;
import clasesDAO.CompetenciaDao;
import clasesDTO.CompetenciaDTO;
import clasesDTO.FixtureDTO;
import gestores.GestorCompetencia;
import gestores.GestorFixture;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class CU020 {
	private int idUsuario;
	private int idCompetencia;
	
	private JFrame frame;
	private JTextField nombre;
	private JTextField modalidad;
	private JTextField estado;
	/**
	 * Create the application.
	 */
	public CU020( int idCompetencia, int idUsuario) {
		this.idUsuario=idUsuario;
		this.idCompetencia=idCompetencia;
		
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		CompetenciaDTO competencia=GestorCompetencia.obtenerCompetenciasDTO(CompetenciaDao.getCompetenciaByID(idCompetencia));
		frame = new JFrame();
		frame.setBounds(100, 100, 501, 493);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Ver Competencia");
		frame.getContentPane().setLayout(null);
		
		nombre = new JTextField();
		nombre.setEditable(false);
		nombre.setBounds(73, 11, 152, 20);
		nombre.setText(competencia.getNombre());
		frame.getContentPane().add(nombre);
		nombre.setColumns(10);
		
		modalidad = new JTextField();
		modalidad.setEditable(false);
		modalidad.setBounds(73, 42, 152, 20);
		modalidad.setText(competencia.getModalidad());
		frame.getContentPane().add(modalidad);
		modalidad.setColumns(10);
		
		estado = new JTextField();
		estado.setEditable(false);
		estado.setBounds(73, 73, 152, 20);
		estado.setText(competencia.getEstado());
		frame.getContentPane().add(estado);
		estado.setColumns(10);
		
		JButton btnNewButton = new JButton("Modificar Competencia");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Proximamente");
			}
		});
		btnNewButton.setBounds(307, 64, 168, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Dar de Baja");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Proximamente");
			}
		});
		btnNewButton_1.setBounds(307, 114, 168, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Fixture");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							MostrarFixture window = new MostrarFixture(idCompetencia,idUsuario);
							window.getFrame().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				frame.dispose();	}
			
		});
		
	
		btnNewButton_2.setBounds(307, 167, 168, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Generar Fixture");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cantParticipantes=competencia.getParticipantes().size();
				if(cantParticipantes>=2) {
			
		switch(GestorFixture.generarFixture(CompetenciaDao.getCompetenciaByID(idCompetencia))) {
		case 0:
			JOptionPane.showMessageDialog(null,"Fixture creado con exito!");
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						CU020 window = new CU020(idCompetencia,idUsuario);
						window.getFrame().setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			frame.dispose();	
			break;
		case 1:
			JOptionPane.showMessageDialog(null,"No hay disponibilidad suficiente");
			break;
		case 2:
			JOptionPane.showMessageDialog(null,"El fixture ya existe");
			break;
		case 3:
			JOptionPane.showMessageDialog(null,"Solo fixture para sistemasLiga");
			break;
		}}
		else {
		JOptionPane.showMessageDialog(null,"Cantidad de participantes insuficientes para generar el fixture");	
		}
			
		
		
			}});
		
		
		
		
		btnNewButton_3.setBounds(307, 219, 168, 29);
		frame.getContentPane().add(btnNewButton_3);
		if(competencia.getIdUsuario()!=idUsuario) {
			btnNewButton_3.setEnabled(false);
			
		}
		
		JButton btnNewButton_4 = new JButton("Tabla de Posiciones");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Proximamente");
			}
		});
		btnNewButton_4.setBounds(307, 273, 168, 29);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Mostrar Participantes");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CU008 window = new CU008(competencia.getIdCompetencia(), idUsuario);
							window.getFrame().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				frame.dispose();
			}
		});
		btnNewButton_5.setBounds(307, 326, 168, 29);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Regresar");
		btnNewButton_6.addActionListener(new ActionListener() {
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
		btnNewButton_6.setBounds(373, 420, 102, 23);
		frame.getContentPane().add(btnNewButton_6);
		
		JTextPane txtpnModalidad = new JTextPane();
		txtpnModalidad.setEditable(false);
		txtpnModalidad.setText("Modalidad");
		txtpnModalidad.setBounds(0, 42, 88, 20);
		frame.getContentPane().add(txtpnModalidad);
		
		JTextPane txtpnEstado = new JTextPane();
		txtpnEstado.setEditable(false);
		txtpnEstado.setText("Estado");
		txtpnEstado.setBounds(0, 73, 88, 20);
		frame.getContentPane().add(txtpnEstado);
		
		JTextPane txtpnNombre = new JTextPane();
		txtpnNombre.setEditable(false);
		txtpnNombre.setText("Nombre");
		txtpnNombre.setBounds(0, 11, 88, 20);
		frame.getContentPane().add(txtpnNombre);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 114, 220, 134);
		frame.getContentPane().add(scrollPane);
		
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		StyledDocument doc = textPane.getStyledDocument();
		for(int i=0;i<competencia.getParticipantes().size();i++) {
		try {
		doc.insertString(doc.getLength(),competencia.getParticipantes().get(i)+"\n", null);
		}
		catch (BadLocationException ex) {
			Logger.getLogger(JTextPane.class.getName()).log(Level.SEVERE, null, ex);
		}
		}
		
		
		
			
		scrollPane.setViewportView(textPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 273, 220, 144);
		frame.getContentPane().add(scrollPane_1);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setText("PROXIMOS ENCUENTROS\n");
		StyledDocument doc_1 = textPane_1.getStyledDocument();
		
		
		
		if(competencia.getEstado().compareTo("creada")!=0) {
			FixtureDTO f=GestorFixture.obtenerFixture(idCompetencia);
		for(int i=0;i<f.getRondas().get(0).getEncuentros().size();i++) {
		try {
		doc_1.insertString(doc_1.getLength(),
				f.getRondas().get(0).getEncuentros().get(i).getP1()+ "  vs  " + f.getRondas().get(0).getEncuentros().get(i).getP2()
				+"\n"
				, null);
		}
		catch (BadLocationException ex) {
			Logger.getLogger(JTextPane.class.getName()).log(Level.SEVERE, null, ex);
		}
		}
		
		}
		else {
			try {
				doc_1.insertString(doc_1.getLength(),
						"NO HAY ENCUENTROS DISPONIBLES"
						+"\n"
						, null);
				}
				catch (BadLocationException ex) {
					Logger.getLogger(JTextPane.class.getName()).log(Level.SEVERE, null, ex);
				}
			
		}
		
		scrollPane_1.setViewportView(textPane_1);
		
		
	}
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
