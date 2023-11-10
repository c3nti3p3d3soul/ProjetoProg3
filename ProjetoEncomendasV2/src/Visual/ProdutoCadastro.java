package Visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DropMode;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.ietf.jgss.ChannelBinding;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;

public class ProdutoCadastro extends ProdutoLista {
	ProdutoLista PL = new ProdutoLista();
	
	
	private JPanel contentPane;
	private JTextField TFnome;
	private JTextField TFref;
	private JTextField TFCod;
	private JTextField TFPreco;
	private JTextField TFQNT;
	private JTable TabelaProd;

	/**
	 * Launch the application.
	 */
	

	
	/**
	 * Create the frame.
	 */
	public ProdutoCadastro() {
		
	    
		
		setTitle("Cadastrar Produto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 950, 450);
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel PainelSalvar = new JPanel();
		PainelSalvar.setBackground(new Color(143, 188, 143));
		PainelSalvar.setBounds(0, 0, 934, 33);
		contentPane.add(PainelSalvar);
		PainelSalvar.setLayout(null);
		
		JComboBox CBCateg = new JComboBox();
		
		JButton BTNCadastrar = new JButton("");
		BTNCadastrar.setBounds(10, 0, 32, 32);
		PainelSalvar.add(BTNCadastrar);
		BTNCadastrar.setIcon(new ImageIcon("C:\\Users\\Usuário\\eclipse-workspace\\ProjetoEncomendas\\ProjetoEncomendasV2\\src\\Imagens\\save_icon.png"));
		BTNCadastrar.setVerticalAlignment(SwingConstants.BOTTOM);
		BTNCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = TFnome.getText();
				
				String CBcat = (String) CBCateg.getSelectedItem();
				
				String ref = TFref.getText();
				Integer.parseInt(ref);
				
				String cod = TFCod.getText();
				Integer.parseInt(cod);
				
				String quant = TFQNT.getText();
				Integer.parseInt(quant);
				
				String preco = TFPreco.getText();
				Double.parseDouble(preco);
				
				
				DefaultTableModel dados = (DefaultTableModel) TabelaProd.getModel();
				dados.addRow(new String[] {nome,CBcat,ref,cod, quant, preco});
				
					TFnome.setText("");
					CBCateg.setSelectedItem(e);
					TFref.setText("");
					TFCod.setText("");
					TFQNT.setText("");
					TFPreco.setText("");
					
				
					DefaultTableModel TablePL = (DefaultTableModel) TabelaLista.getModel();
					TablePL.addRow(new String[] {nome,CBcat,ref,cod, quant, preco});
					
					
			
		
			}
		});
		BTNCadastrar.setBackground(new Color(255, 255, 255));
		BTNCadastrar.setFont(new Font("Verdana", Font.PLAIN, 11));
		
		JButton BTNExcluir = new JButton("");
		BTNExcluir.setIcon(new ImageIcon("C:\\Users\\Usuário\\eclipse-workspace\\ProjetoEncomendas\\ProjetoEncomendasV2\\src\\Imagens\\trashcan.png"));
		BTNExcluir.setBounds(66, 0, 32, 32);
		PainelSalvar.add(BTNExcluir);
		
		JPanel PainelCad = new JPanel();
		PainelCad.setBackground(new Color(143, 188, 143));
		PainelCad.setBounds(0, 378, 934, 33);
		contentPane.add(PainelCad);
		PainelCad.setLayout(null);
		
		JLabel LBnome = new JLabel("Nome");
		LBnome.setBounds(10, 5, 33, 15);
		PainelCad.add(LBnome);
		LBnome.setFont(new Font("Verdana", Font.PLAIN, 11));
		
		TFnome = new JTextField();
		TFnome.setBounds(53, 5, 86, 20);
		PainelCad.add(TFnome);
		TFnome.setHorizontalAlignment(SwingConstants.LEFT);
		TFnome.setColumns(10);
		
		JLabel LBCateg = new JLabel("Categoria");
		LBCateg.setBounds(159, 5, 56, 15);
		PainelCad.add(LBCateg);
		LBCateg.setFont(new Font("Verdana", Font.PLAIN, 11));
		
	
		CBCateg.setModel(new DefaultComboBoxModel(new String[] {"Bolsas", "Cintos", "Carteiras", "Facas"}));
		CBCateg.setBounds(219, 4, 76, 22);
		PainelCad.add(CBCateg);
		CBCateg.setBackground(new Color(255, 255, 255));
		
		JLabel LBRef = new JLabel("Referência");
		LBRef.setBounds(305, 5, 61, 15);
		PainelCad.add(LBRef);
		LBRef.setFont(new Font("Verdana", Font.PLAIN, 11));
		
		TFref = new JTextField();
		TFref.setBounds(372, 5, 86, 20);
		PainelCad.add(TFref);
		TFref.setColumns(10);
		
		JLabel LBcod = new JLabel("Código");
		LBcod.setBounds(472, 5, 40, 15);
		PainelCad.add(LBcod);
		LBcod.setFont(new Font("Verdana", Font.PLAIN, 11));
		
		TFCod = new JTextField();
		TFCod.setBounds(522, 5, 86, 20);
		PainelCad.add(TFCod);
		TFCod.setColumns(10);
		
		JLabel LBQnt = new JLabel("Quant.");
		LBQnt.setFont(new Font("Tahoma", Font.PLAIN, 11));
		LBQnt.setBounds(633, 5, 34, 14);
		PainelCad.add(LBQnt);
		
		TFQNT = new JTextField();
		TFQNT.setBounds(677, 5, 86, 20);
		PainelCad.add(TFQNT);
		TFQNT.setColumns(10);
		
		JLabel LBPreco = new JLabel("Preço");
		LBPreco.setBounds(782, 5, 32, 15);
		PainelCad.add(LBPreco);
		LBPreco.setFont(new Font("Verdana", Font.PLAIN, 11));
		
		TFPreco = new JTextField();
		TFPreco.setBounds(826, 5, 86, 20);
		PainelCad.add(TFPreco);
		TFPreco.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(0, 32, 934, 344);
		contentPane.add(scrollPane);
		
		TabelaProd = new JTable();
		TabelaProd.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Categoria", "Refer\u00EAncia", "C\u00F3digo", "Quantidade", "Pre\u00E7o"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(TabelaProd);
	}
}
