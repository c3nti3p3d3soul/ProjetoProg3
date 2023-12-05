package Visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class RastreioEncomenda extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RastreioEncomenda frame = new RastreioEncomenda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RastreioEncomenda() {
		setTitle("Rastrear Produto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)		);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Cod = new JPanel();
		Cod.setBorder((Border) new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Cod.setBounds(10, 11, 604, 106);
		contentPane.add(Cod);
		Cod.setLayout(null);
		
		JLabel LBola = new JLabel("Olá,");
		LBola.setFont(new Font("Dialog", Font.PLAIN, 14));
		LBola.setBounds(10, 11, 67, 28);
		Cod.add(LBola);
		
		JLabel Digite = new JLabel("Digite o código de Rastreio:");
		Digite.setFont(new Font("Dialog", Font.PLAIN, 14));
		Digite.setBounds(10, 50, 177, 28);
		Cod.add(Digite);
		
		textField = new JTextField();
		textField.setBounds(10, 75, 584, 20);
		Cod.add(textField);
		textField.setColumns(10);
		
		JLabel LBusuario = new JLabel("");
		LBusuario.setFont(new Font("Dialog", Font.PLAIN, 14));
		LBusuario.setBounds(38, 11, 556, 28);
		Cod.add(LBusuario);
			
		JPanel Local = new JPanel();
		Local.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Local.setBounds(10, 128, 604, 122);
		contentPane.add(Local);
		Local.setLayout(null);
		
		JLabel L = new JLabel("Local:");
		L.setBounds(10, 11, 57, 14);
		Local.add(L);
		
		JLabel LBlocalatual = new JLabel("");
		LBlocalatual.setBounds(91, 11, 46, 14);
		Local.add(LBlocalatual);
		
		JLabel D = new JLabel("Destino:");
		D.setBounds(10, 48, 46, 14);
		Local.add(D);
		
		JLabel LBdestino = new JLabel("");
		LBdestino.setBounds(91, 48, 46, 14);
		Local.add(LBdestino);
		

		
	}
}