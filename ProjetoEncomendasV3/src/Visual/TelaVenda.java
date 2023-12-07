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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controle.Conexao;
import Modelos.Contato;
import Modelos.Produto;
import Modelos.Usuario;
import java.sql.Connection;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaVenda extends JFrame {

	Produto produto = new Produto();
	private Usuario usuario;
	private JTextField TFUser;
	private JTextField TFSenha;
	private JLabel Precototal;
	double precoUnitario;
	 private JLabel LBparcelas;

	private JPanel contentPane;
	private JTable TabelaEscolher;
	private JTable Itens;
	
	private JLabel LBrecebeNome;
    private JLabel LBrecebeCPF;

	private String metodoPagamentoSelecionado = "";
	private int parcelasSelecionadas = 1;
	
	private Usuario usuarioLogado; 

	
	


	

	private void adicionarProdutoAoCarrinho(Object[] produtoSelecionado) {
		DefaultTableModel model = (DefaultTableModel) Itens.getModel();

		boolean jaAdicionado = false;
		int linhaExistente = -1;
		for (int i = 0; i < model.getRowCount(); i++) {
			if (model.getValueAt(i, 1).equals(produtoSelecionado[1])) {
				jaAdicionado = true;
				linhaExistente = i;
				break;
			}
		}

		if (!jaAdicionado) {
			int quantidadeEstoque = Integer.parseInt(produtoSelecionado[3].toString());
			if (quantidadeEstoque > 0) {
				Object[] produtoParaTabela = { produtoSelecionado[0], produtoSelecionado[1], produtoSelecionado[2], 1,
						produtoSelecionado[4] }; 
				model.addRow(produtoParaTabela);
			}

		} else {
			int quantidadeAtual = Integer.parseInt(model.getValueAt(linhaExistente, 3).toString());
			int quantidadeEstoque = Integer.parseInt(produtoSelecionado[3].toString());

			if (quantidadeAtual < quantidadeEstoque) {
				model.setValueAt(quantidadeAtual + 1, linhaExistente, 3);
			} else {
				JOptionPane.showMessageDialog(null, "Não há quantidade disponível em estoque para este produto.");
			}
		}

		// Adiciona valor ao valor total ao lado da tabela
		double valorTotal = 0.0;
		for (int i = 0; i < model.getRowCount(); i++) {
			double precoUnitario = Double.parseDouble(model.getValueAt(i, 4).toString());
			int quantidade = Integer.parseInt(model.getValueAt(i, 3).toString());
			valorTotal += precoUnitario * quantidade;
		}

		Precototal.setText(String.valueOf(valorTotal));
	}

	private void calcularValorTotal() {
		double valorTotal = 0.0;

		DefaultTableModel model = (DefaultTableModel) Itens.getModel();
		for (int i = 0; i < model.getRowCount(); i++) {
			double precoUnitario = Double.parseDouble(model.getValueAt(i, 4).toString());
			int quantidade = Integer.parseInt(model.getValueAt(i, 3).toString());
			valorTotal += precoUnitario * quantidade;
		}

		if (metodoPagamentoSelecionado.equals("Crédito Parcelado")) {
			valorTotal *= 1.1; // Aplica uma taxa de 10% para pagamento parcelado

			valorTotal /= parcelasSelecionadas; // Divide o valor total pelo número de parcelas
			
			LBparcelas.setText(String.valueOf(parcelasSelecionadas));
		}

		// Define o valor total no JLabel Precototal
		Precototal.setText(String.valueOf(valorTotal));

	}

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

	private void preencherTabelaProdutos() {
		// Recupera os produtos do banco de dados
		List<Produto> produtos = produto.buscarProdutosDoBanco();

		// Preenche a tabela com os produtos obtidos
		DefaultTableModel model = (DefaultTableModel) TabelaEscolher.getModel();

		for (Produto p : produtos) {
			Object[] row = { p.getNome(), p.getReferencia(), p.getCategoria(), p.getQuantidade(), p.getPreco() };
			model.addRow(row);
		}
	}

	/**
	 * Create the frame.
	 */
	public TelaVenda() {

		setTitle("Carrinho");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		LBparcelas = new JLabel();
		
		TabelaEscolher = new JTable();
		TabelaEscolher.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int linhaSelecionada = TabelaEscolher.getSelectedRow();
				if (linhaSelecionada != -1) {
					Object[] produtoSelecionado = new Object[5];
					for (int i = 0; i < 5; i++) {
						produtoSelecionado[i] = TabelaEscolher.getValueAt(linhaSelecionada, i);
					}
					adicionarProdutoAoCarrinho(produtoSelecionado);
				}

			}
		});

		TabelaEscolher.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Produto", "Ref.", "Categoria", "Quantidade/Estoque", "Preco" }));
		TabelaEscolher.getColumnModel().getColumn(3).setPreferredWidth(111);
		TabelaEscolher.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		TabelaEscolher.setBounds(10, 54, 604, 161);
		contentPane.add(TabelaEscolher);

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

		preencherTabelaProdutos();

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

		Precototal = new JLabel();
		Precototal.setFont(new Font("Verdana", Font.PLAIN, 15));
		Precototal.setHorizontalAlignment(SwingConstants.CENTER);
		Precototal.setBounds(66, 148, 73, 14);
		Pagamento.add(Precototal);

		JComboBox CBmetodo = new JComboBox();
		CBmetodo.setModel(new DefaultComboBoxModel(new String[] { "Á vista()", "Crédito Parcelado" }));
		CBmetodo.setBounds(10, 36, 161, 22);
		Pagamento.add(CBmetodo);

		JComboBox Parcelas = new JComboBox();
		Parcelas.setModel(new DefaultComboBoxModel(
				new String[] { "1x", "2x", "3x", "4x", "5x", "6x", "7x", "8x", "9x", "10x", "12x" }));
		Parcelas.setBounds(10, 69, 161, 22);
		Pagamento.add(Parcelas);
		

		CBmetodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				metodoPagamentoSelecionado = (String) CBmetodo.getSelectedItem();
				calcularValorTotal();
			}
		});

		Parcelas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String parcelaSelecionada = (String) Parcelas.getSelectedItem();
				parcelasSelecionadas = Integer.parseInt(parcelaSelecionada.substring(0, 1));
				calcularValorTotal();
				LBparcelas.setText(parcelaSelecionada);
				
			}
		});
		Contato contato = new Contato();

		JButton BTNcontinuar = new JButton("Continuar a compra");
		BTNcontinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double valorTotal = Double.parseDouble(Precototal.getText());
				Connection conexao = Conexao.getConnection();
				Info info = new Info(valorTotal, metodoPagamentoSelecionado, parcelasSelecionadas, conexao, usuario, contato);
				info.setVisible(true);
			
			
			}
		});

		BTNcontinuar.setBackground(new Color(255, 255, 0));
		BTNcontinuar.setBounds(444, 11, 170, 23);
		panel_1.add(BTNcontinuar);

		Itens = new JTable();
		Itens.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Produto", "Quantidade", "Ref.", "Categoria", "Preco" }));
		Itens.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Itens.setBounds(10, 237, 413, 172);
		contentPane.add(Itens);

		// Adicione este código no construtor da sua classe TelaVenda, depois de
		// inicializar a tabela 'Itens':
		Itens.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linhaSelecionada = Itens.getSelectedRow();
				if (linhaSelecionada != -1) {
					DefaultTableModel model = (DefaultTableModel) Itens.getModel();
					double valorRemovido = Double.parseDouble(model.getValueAt(linhaSelecionada, 3).toString());
					model.removeRow(linhaSelecionada);

					// Atualiza o valor total, subtraindo o valor do item removido
					double valorTotal = Double.parseDouble(Precototal.getText()) - valorRemovido;
					Precototal.setText(String.valueOf(valorTotal));
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 604, 155);
		contentPane.add(scrollPane);
	}
}
