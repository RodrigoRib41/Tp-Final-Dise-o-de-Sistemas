package interfaces;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.KeyStroke;

import clasesDTO.ParticipanteDTO;
import gestores.GestorCompetencia;

import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CU009 {

	private JFrame frmDarDeAlta;
	private JTextField nombre;
	private JTextField correo;
	private int idCompetencia;
    private int idUsuario;
	/**
	 * Launch the application.
	 */

	boolean ValidarMail(String email) {
        // Patron para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        Matcher mather = pattern.matcher(email);
        return mather.find();
    }

	/**
	 * Create the application.
	 */
	public CU009(int idCompetencia,int idUsuario) {
		this.idCompetencia=idCompetencia;
		this.idUsuario=idUsuario;

		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frmDarDeAlta = new JFrame();
		frmDarDeAlta.setTitle("Dar de Alta Participante");
		frmDarDeAlta.setBounds(100, 100, 500, 281);
		frmDarDeAlta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDarDeAlta.getContentPane().setLayout(null);
		
		JLabel labelNombre = new JLabel("Nombre Participante(*):");
		labelNombre.setFont(new Font("Arial Black", Font.PLAIN, 14));
		labelNombre.setBounds(10, 36, 200, 39);
		frmDarDeAlta.getContentPane().add(labelNombre);
		
		JLabel labelCorreo = new JLabel("Correo Electronico (*):");
		labelCorreo.setFont(new Font("Arial Black", Font.PLAIN, 14));
		labelCorreo.setBounds(10, 110, 200, 39);
		frmDarDeAlta.getContentPane().add(labelCorreo);
		
		nombre = new JTextField();
		nombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				labelNombre.setForeground(Color.BLACK);
			}
		});
nombre.addKeyListener(new KeyAdapter() {
			
			@SuppressWarnings("deprecation")
			@Override
			
			public void keyTyped(KeyEvent e) {
				InputMap map2 = nombre.getInputMap(JComponent.WHEN_FOCUSED);
			      map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK), "null");
				if(nombre.getText().length() >= 30) {
					e.consume();
					Toolkit.getDefaultToolkit().beep();
				}
			}
			
		});
		nombre.setFont(new Font("Arial", Font.PLAIN, 13));
		nombre.setBounds(220, 47, 174, 20);
		frmDarDeAlta.getContentPane().add(nombre);
		nombre.setColumns(10);
		
		correo = new JTextField();
		correo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				labelCorreo.setForeground(Color.BLACK);
			}
		});
correo.addKeyListener(new KeyAdapter() {
			
			@SuppressWarnings("deprecation")
			@Override
			
			public void keyTyped(KeyEvent e) {
				InputMap map2 = correo.getInputMap(JComponent.WHEN_FOCUSED);
			      map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK), "null");
				if(correo.getText().length() >= 50) {
					e.consume();
					Toolkit.getDefaultToolkit().beep();
				}
			}
			
		});
		correo.setFont(new Font("Arial", Font.PLAIN, 13));
		correo.setColumns(10);
		correo.setBounds(220, 121, 222, 20);
		frmDarDeAlta.getContentPane().add(correo);
		
		JButton btnNewButton = new JButton("Regresar");
		btnNewButton.setBounds(10, 194, 117, 23);
		btnNewButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									CU008 window = new CU008(idCompetencia,idUsuario);
									window.getFrame().setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
						frmDarDeAlta.dispose();
					}
				}
				
				);
		
		
		frmDarDeAlta.getContentPane().add(btnNewButton);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean ok=true;
				boolean correook=true;
				if(nombre.getText().length()==0) {
					ok=false;	
					labelNombre.setForeground(Color.RED);
				}
				if( !ValidarMail(correo.getText())) {
					correook=false;
					labelCorreo.setForeground(Color.RED);
				}
				if(!correook) {
					JOptionPane.showMessageDialog(null,"Su email debe ser de la forma xxxxx\r\n" + 
					"@xxxx." + "xxx");
					}
				if(!ok) {
					JOptionPane.showMessageDialog(null,"Debe Completar Todos los Campos (*)");
					}
				if(GestorCompetencia.verificarNombreParticipante(nombre.getText(), idCompetencia)) {
					JOptionPane.showMessageDialog(null,"Nombre de participante ya existente");
				}
				
				if(correook & ok & !(GestorCompetencia.verificarNombreParticipante(nombre.getText(), idCompetencia))){
					if(JOptionPane.showConfirmDialog(frmDarDeAlta, "¿Esta seguro que desea dar de alta el participante?",
				            "Confirmacion", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
					ParticipanteDTO p=new ParticipanteDTO();
					p.setCorreo(correo.getText());
					p.setNombre(nombre.getText());
					p.setIdCompetencia(idCompetencia);
					
					GestorCompetencia.darDeAltaParticipante(p);
					JOptionPane.showMessageDialog(null,"Participante dado de alta con exito!");
					
					}
					
				}
			}
		});
		btnAceptar.setBounds(357, 194, 117, 23);
		frmDarDeAlta.getContentPane().add(btnAceptar);
	}
	public JFrame getFrame() {
		return frmDarDeAlta;
	}



}
