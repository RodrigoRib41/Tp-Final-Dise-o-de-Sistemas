package interfaces;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gestores.GestorUsuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal {

	private JFrame frame;
	private JTextField txtEstaLogueadoComo;
	static int idUsuario;
	private JTextField textField;

	/**
	 * Create the application.
	 */
	public Principal(int idU) {
		idUsuario=idU;
		System.out.println(idUsuario);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 493, 381);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Pantalla Princial");
		frame.getContentPane().setLayout(null);
		
		
		txtEstaLogueadoComo = new JTextField();
		txtEstaLogueadoComo.setEditable(false);
		txtEstaLogueadoComo.setText("Esta logueado como:");
		txtEstaLogueadoComo.setBounds(10, 11, 130, 20);
		frame.getContentPane().add(txtEstaLogueadoComo);
		txtEstaLogueadoComo.setColumns(10);
		
		JButton vercompetencia = new JButton("Ver mis Competencias");
		vercompetencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							InterfazFiltrar window = new InterfazFiltrar(idUsuario);
							window.getFrame().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				frame.dispose();
			}
		});
		vercompetencia.setBounds(10, 63, 222, 23);
		frame.getContentPane().add(vercompetencia);
		
		JButton listarcompetencia = new JButton("Listar Competencias Deportivas");
		listarcompetencia.addActionListener(new ActionListener() {
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
		listarcompetencia.setBounds(10, 105, 222, 23);
		frame.getContentPane().add(listarcompetencia);
		
		JButton modificarusuario = new JButton("Modificar Datos de Usuario");
		modificarusuario.setBounds(10, 150, 222, 23);
		modificarusuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Proximamente");
			}
		});
		frame.getContentPane().add(modificarusuario);
		
		JButton dardebajausuario = new JButton("Dar de Baja Usuario");
		dardebajausuario.setBounds(10, 195, 222, 23);
		dardebajausuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Proximamente");
			}
		});
		frame.getContentPane().add(dardebajausuario);
		
		JButton listarlugares = new JButton("Listar Lugares de Realizacion");
		listarlugares.setBounds(10, 241, 222, 23);
		listarlugares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Proximamente");
			}
		});
		frame.getContentPane().add(listarlugares);
		
		JButton cerrar = new JButton("Cerrar Sesion");
		cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(frame, "¿Esta seguro que desea cerrar sesion?",
			            "Confirmacion", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
				frame.setVisible(false);
				JOptionPane.showMessageDialog(null,"Sesion Cerrada");
				Login.main(null);
			}}
		});
		cerrar.setBounds(337, 308, 130, 23);
		frame.getContentPane().add(cerrar);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(142, 11, 325, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText(GestorUsuario.getCorreoByID(idUsuario));
		
	}

	public Window frame() {
		frame.setVisible(true);
		return null;
	}
}
