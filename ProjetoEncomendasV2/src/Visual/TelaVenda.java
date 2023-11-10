package Visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaVenda extends JFrame {

	private JPanel contentPane;
	private JTable TabelaEscolher;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVenda frame = new TelaVenda();
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
	public TelaVenda() {
		setTitle("Carrinho");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(32, 178, 170));
		panel.setBounds(0, 0, 624, 35);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel Carrinho = new JLabel("Carrinho");
		Carrinho.setHorizontalAlignment(SwingConstants.CENTER);
		Carrinho.setFont(new Font("Verdana", Font.PLAIN, 20));
		Carrinho.setBounds(0, 0, 624, 35);
		panel.add(Carrinho);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(32, 178, 170));
		panel_1.setBounds(0, 420, 624, 41);
		contentPane.add(panel_1);
		
		JButton btnNewButton = new JButton("Continuar a compra");
		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.setBounds(444, 11, 170, 23);
		panel_1.add(btnNewButton);
		
		JPanel panel_1_1_1_1_2_1 = new JPanel();
		panel_1_1_1_1_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1_1_1_2_1.setBackground(new Color(124, 252, 0));
		panel_1_1_1_1_2_1.setBounds(10, 43, 604, 3);
		contentPane.add(panel_1_1_1_1_2_1);
		panel_1_1_1_1_2_1.setLayout(null);
		
		JPanel panel_1_1_1_1_2_1_1 = new JPanel();
		panel_1_1_1_1_2_1_1.setLayout(null);
		panel_1_1_1_1_2_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1_1_1_2_1_1.setBackground(new Color(124, 252, 0));
		panel_1_1_1_1_2_1_1.setBounds(10, 223, 604, 3);
		contentPane.add(panel_1_1_1_1_2_1_1);
		
		TabelaEscolher = new JTable();
		TabelaEscolher.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Produto", "Ref.", "Categoria", "Quantidade/Estoque", "Preco"
			}
		));
		TabelaEscolher.getColumnModel().getColumn(3).setPreferredWidth(111);
		TabelaEscolher.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		TabelaEscolher.setBounds(10, 51, 604, 165);
		contentPane.add(TabelaEscolher);
		
		JPanel Pagamento = new JPanel();
		Pagamento.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Pagamento.setBounds(433, 237, 181, 173);
		contentPane.add(Pagamento);
		Pagamento.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pagamento");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 181, 25);
		Pagamento.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Total:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 148, 46, 14);
		Pagamento.add(lblNewLabel_1);
		
		JLabel Precototal = new JLabel("R$");
		Precototal.setFont(new Font("Verdana", Font.PLAIN, 15));
		Precototal.setHorizontalAlignment(SwingConstants.CENTER);
		Precototal.setBounds(66, 150, 105, 14);
		Pagamento.add(Precototal);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Á vista()", "Crédito Parcelado", "1x de", "2x de", "3x de"}));
		comboBox.setBounds(10, 36, 161, 22);
		Pagamento.add(comboBox);
		
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBounds(10, 237, 413, 172);
		contentPane.add(table);
	}
}
