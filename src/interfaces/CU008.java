package interfaces;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import clasesDAO.CompetenciaDao;
import clasesDTO.CompetenciaDTO;
import clasesDTO.ParticipanteDTO;
import gestores.GestorCompetencia;
import gestores.GestorParticipante;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CU008 {

	private JFrame frmListarParticipantes;

	/**
	 * Launch the application.
	 */
	private int idCompetencia;
    private int idUsuario;
	/**
	 * Create the application.
	 */
	public CU008(int idCompetencia,int idUsuario) {
		this.idCompetencia=idCompetencia;
		this.idUsuario=idUsuario;
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		CompetenciaDTO competencia=GestorCompetencia.obtenerCompetenciasDTO(CompetenciaDao.getCompetenciaByID(idCompetencia));
		ArrayList<ParticipanteDTO> participantes=GestorParticipante.obtenerParticipanteDTO(CompetenciaDao.obtenerParticipanteByIDCompetencia(idCompetencia));
		frmListarParticipantes = new JFrame();
		frmListarParticipantes.setTitle("Listar Participantes");
		frmListarParticipantes.setBounds(100, 100, 458, 370);
		frmListarParticipantes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmListarParticipantes.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Dar de Baja Parcipante");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Proximamente");
			}
		});
		btnNewButton.setBounds(10, 219, 199, 23);
		frmListarParticipantes.getContentPane().add(btnNewButton);
	
		
		JButton btnNewButton_1 = new JButton("Modificar Participante");
		btnNewButton_1.setBounds(10, 253, 199, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Proximamente");
			}
		});
		frmListarParticipantes.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Dar de Alta Nuevo Participante");
		
		btnNewButton_2.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									CU009 window = new CU009(idCompetencia,idUsuario);
									window.getFrame().setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
						frmListarParticipantes.dispose();
					}
				}
				
				
				
				);
		System.out.println(idUsuario);
		if(competencia.getIdUsuario()!=idUsuario) {
			btnNewButton_2.setEnabled(false);
			
		}
		
		
		btnNewButton_2.setBounds(10, 185, 199, 23);
		frmListarParticipantes.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Regresar");
		btnNewButton_3.setBounds(343, 302, 89, 23);
		btnNewButton_3.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
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
						frmListarParticipantes.dispose();
					}
				}
				
				
				);
		
		
		frmListarParticipantes.getContentPane().add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 426, 163);
		frmListarParticipantes.getContentPane().add(scrollPane);
		
		int cantidad=participantes.size(); /*Setear la cantidad de participantes encontrados en la competencia*/
		int contador=0;
		int agregadoY=0;
		JPanel panelParticipantes = new JPanel();
		 panelParticipantes.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panelParticipantes.setPreferredSize(new Dimension(360, 35*cantidad));
			panelParticipantes.setLayout(null);
		panelParticipantes.setAutoscrolls(true);
		scrollPane.setViewportView(panelParticipantes);
		ArrayList<JLabel> labelNombre=new ArrayList<JLabel>();
		ArrayList<JLabel> labelCorreo=new ArrayList<JLabel>();
		
		
		ArrayList<JTextField> nombre2=new ArrayList<JTextField>();
		 ArrayList<JTextField> correo2=new ArrayList<JTextField>();
		
		 
		 
		labelNombre.add(new JLabel("Nombre"));
		labelCorreo.add(new JLabel("Correo Electronico"));

		labelNombre.get(contador).setBounds(10, 11, 85, 14);
		panelParticipantes.add(labelNombre.get(contador));
		labelCorreo.get(contador).setBounds(160, 11, 240, 14);
		panelParticipantes.add(labelCorreo.get(contador));
		
		while(cantidad>contador) {
			nombre2.add(new JTextField());
			nombre2.get(contador).setBounds(10, 41+agregadoY, 125, 20);
			
			
			nombre2.get(contador).setEditable(false);
			nombre2.get(contador).setText(participantes.get(contador).getNombre());
			panelParticipantes.add(nombre2.get(contador));

			correo2.add(new JTextField());
			correo2.get(contador).setBounds(160, 41+agregadoY, 240, 20);
			
			correo2.get(contador).setEditable(false);
			correo2.get(contador).setText(participantes.get(contador).getCorreo());
			panelParticipantes.add(correo2.get(contador));
			
			agregadoY=agregadoY+30;
			contador++;
		}
		
		
	}
	public JFrame getFrame() {
		return frmListarParticipantes;
	}

}
