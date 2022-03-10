package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;


import clasesDTO.*;
import gestores.GestorFixture;

import javax.swing.JScrollPane;
import javax.swing.JPanel;

public class MostrarFixture {

	private JFrame frame;
    private int idCompetencia;
    private int idUsuario;
    private FixtureDTO fixture;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public MostrarFixture(int idCompetencia,int idUsuario) {
		this.idCompetencia=idCompetencia;
		this.idUsuario=idUsuario;
		
		this.fixture=GestorFixture.obtenerFixture(idCompetencia);
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 572, 386);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 24, 542, 44);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		JComboBox<RondaDTO> comboBox = new JComboBox<RondaDTO>();
		for(RondaDTO r:fixture.getRondas()) {
			
			comboBox.addItem(r);
		}
		comboBox.setSelectedItem(null);
		comboBox.setBounds(137, 7, 120, 22);
		panel.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 542, 200);
		frame.getContentPane().add(scrollPane);
		
		JButton Regresar = new JButton("Regresar");
		Regresar.addActionListener(new ActionListener() {
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
				frame.dispose();
			}
		});
		Regresar.setBounds(10, 309, 89, 23);
		frame.getContentPane().add(Regresar);
		
		class Resultados implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				
		RondaDTO r=(RondaDTO)comboBox.getSelectedItem();	
		int contador=0;
		int cantidad=r.getEncuentros().size();
		int agregadoY=0;
		JPanel panelFixture = new JPanel();
		 panelFixture.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panelFixture.setPreferredSize(new Dimension(360, 40*cantidad));
			panelFixture.setLayout(null);
		panelFixture.setAutoscrolls(true);
		scrollPane.setViewportView(panelFixture);
		
		ArrayList<JTextField> participante1=new ArrayList<JTextField>();
		 ArrayList<JTextField> lugar=new ArrayList<JTextField>();
		 ArrayList<JTextField> participante2=new ArrayList<JTextField>();
		
		 
		 
		while(cantidad>contador) {
			participante2.add(new JTextField());
			participante2.get(contador).setBounds(180, 24+agregadoY, 140, 20);
			
			participante2.get(contador).setEditable(false);
			participante2.get(contador).setText(r.getEncuentros().get(contador).getP1());
			panelFixture.add(participante2.get(contador));
			JLabel vs = new JLabel("VS");
			vs.setBounds(160, 24+agregadoY, 160, 20);
			panelFixture.add(vs);
			JLabel en = new JLabel("EN:");
			en.setBounds(325, 24+agregadoY, 160, 20);
			panelFixture.add(en);
			participante1.add(new JTextField());
			participante1.get(contador).setBounds(15, 24+agregadoY, 140, 20);
			
			participante1.get(contador).setEditable(false);
			participante1.get(contador).setText(r.getEncuentros().get(contador).getP2());
			panelFixture.add(participante1.get(contador));
			
			
			lugar.add(new JTextField());
		   lugar.get(contador).setBounds(349, 24+agregadoY, 140, 20);
			
			lugar.get(contador).setEditable(false);
			lugar.get(contador).setText(r.getEncuentros().get(contador).getL());
			panelFixture.add(lugar.get(contador));
			
			
			
			agregadoY=agregadoY+30;
			contador++;
		}

	
		
		
	}}
		 Resultados aux= new Resultados();
		comboBox.addActionListener(aux);
		
		
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
