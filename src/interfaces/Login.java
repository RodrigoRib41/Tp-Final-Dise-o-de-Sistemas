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
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
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

public class Login extends JFrame {
	private static final long serialVersionUID = 1L;

	private static JFrame frame;
	private static JTextField usuario;
	private static JTextField contrasenia;
	static int idUsuario;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					Login.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		inicialize();
	}


	public static void inicialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Inicio de Sesion");

		

		
		JLabel etiqUsuario = new JLabel("Ingrese Usuario ");
		etiqUsuario.setBounds(80, 150, 197, 19);
		
		JLabel etiqContra = new JLabel("Ingrese Contraseña ");
		etiqContra.setBounds(80, 180, 197, 14);
		
		usuario = new JTextField();
		usuario.setBounds(250, 150, 167, 20);
		
		
		contrasenia = new JTextField();
		contrasenia.setBounds(250, 180, 167, 20);
		

		JButton buttonAceptar = new JButton("Aceptar");
		buttonAceptar.setBounds(368, 540, 89, 23);
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				idUsuario=GestorUsuario.verificarUsuario(usuario.getText(), contrasenia.getText());
			 if(idUsuario>0){	
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
			 else {
				 JOptionPane.showMessageDialog(null,"Usuario o Contrasenia incorrectos");
			 }
			}
	   });
		JButton buttonCancelar = new JButton("Salir");
		buttonCancelar.setBounds(10, 540, 89, 23);
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		JButton buttonRegistrarse = new JButton("Registrar");
		buttonRegistrarse.setBounds(180, 390, 100, 23);
		buttonRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Proximamente");
			}
		});
		JLabel etiqRegistro = new JLabel("Si no cuenta con un usuario por favor registrese");
		etiqRegistro.setBounds(100, 350, 297, 19);
		JLabel etiqRegistro1 = new JLabel("	 haciendo click en el boton registrar ");
		etiqRegistro1.setBounds(140, 370, 297, 19);
	
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(etiqUsuario);
		frame.getContentPane().add(etiqContra);
		frame.getContentPane().add(usuario);
		frame.getContentPane().add(contrasenia);
		frame.getContentPane().add(buttonAceptar);
		frame.getContentPane().add(buttonCancelar);
		frame.getContentPane().add(buttonRegistrarse);
		frame.getContentPane().add(etiqRegistro);
		frame.getContentPane().add(etiqRegistro1);
	


	}

}