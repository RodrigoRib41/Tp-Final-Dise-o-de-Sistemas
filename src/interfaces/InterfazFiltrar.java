package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import clasesDTO.CompetenciaDTO;
import clasesDTO.ParticipanteDTO;
import gestores.GestorCompetencia;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class InterfazFiltrar {

	private JFrame frmMisCompetencias;
	static int idUsuario;

	
	/**
	 * Create the application.
	 */
	public InterfazFiltrar(int idU) {
		idUsuario=idU;
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmMisCompetencias = new JFrame();
		frmMisCompetencias.setTitle("Mis Competencias");
		frmMisCompetencias.setBounds(100, 100, 370, 327);
		frmMisCompetencias.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMisCompetencias.getContentPane().setLayout(null);
		ArrayList<CompetenciaDTO> competencias;
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
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
					frmMisCompetencias.dispose();
				}
			});
			
		cancelar.setBounds(10, 260, 89, 23);
		frmMisCompetencias.getContentPane().add(cancelar);
		
		JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	               JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 31, 334, 201);
		frmMisCompetencias.getContentPane().add(scrollPane);
	
		competencias=GestorCompetencia.buscarCompetencias("all", "all", "all", "all", idUsuario);
		
		int cantidad=competencias.size(); /*Setear la cantidad de competencias encontradas*/
		int contador=0;
		int agregadoY=0;
		JPanel panelCompetencia = new JPanel();
		 panelCompetencia.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panelCompetencia.setPreferredSize(new Dimension(360, 35*cantidad));
			panelCompetencia.setLayout(null);
		panelCompetencia.setAutoscrolls(true);
		scrollPane.setViewportView(panelCompetencia);
		
		ArrayList<JTextField> nombrecomp=new ArrayList<JTextField>();
		 ArrayList<JButton>  detalle=new ArrayList<JButton>();

		while(cantidad>contador) {
			nombrecomp.add(new JTextField());
			nombrecomp.get(contador).setBounds(10, 10+agregadoY, 125, 20);
			nombrecomp.get(contador).setText(competencias.get(contador).getNombre());
			nombrecomp.get(contador).setEditable(false);
			panelCompetencia.add(nombrecomp.get(contador));
			
			detalle.add(new JButton("Seleccionar")); 
			detalle.get(contador).setBounds(165, 10+agregadoY, 125, 20);
			int contadorAux=contador;
			detalle.get(contador).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(JOptionPane.showConfirmDialog(frmMisCompetencias, "¿Esta seguro que desea continuar?",
			            "Confirmacion", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
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
						frmMisCompetencias.dispose();
			    }
			  }}); 
				
					
				
			
			
			panelCompetencia.add(detalle.get(contador));

			
			agregadoY=agregadoY+30;
			contador++;
		}
		
		JLabel lblNewLabel = new JLabel("Seleccione una competencia:");
		lblNewLabel.setBounds(10, 16, 184, 14);
		frmMisCompetencias.getContentPane().add(lblNewLabel);
		
	}
	
	public JFrame getFrame() {
		return frmMisCompetencias;
	}

	public void setFrame(JFrame frame) {
		this.frmMisCompetencias = frame;
	}
}
