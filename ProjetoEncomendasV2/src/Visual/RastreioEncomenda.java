package Visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class RastreioEncomenda extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public RastreioEncomenda() {
		setTitle("Rastrear Produto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 604, 106);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel CodRas = new JLabel("Insira seu código de rastreio:");
		CodRas.setFont(new Font("Verdana", Font.PLAIN, 15));
		CodRas.setBounds(10, 50, 228, 25);
		panel.add(CodRas);
		
		textField = new JTextField();
		textField.setBounds(10, 75, 584, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel ola = new JLabel("Olá, ");
		ola.setFont(new Font("Verdana", Font.PLAIN, 15));
		ola.setBounds(10, 11, 34, 14);
		panel.add(ola);
		
		JLabel Nome = new JLabel("");
		Nome.setFont(new Font("Verdana", Font.PLAIN, 15));
		Nome.setBounds(45, 11, 549, 14);
		panel.add(Nome);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(10, 128, 604, 122);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel Local = new JLabel("Localização:");
		Local.setFont(new Font("Verdana", Font.PLAIN, 15));
		Local.setBounds(10, 11, 101, 14);
		panel_1.add(Local);
	}
}
