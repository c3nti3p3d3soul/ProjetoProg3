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
import java.sql.Connection;
import Modelos.Produto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoCadastro extends ProdutoLista {
	ProdutoLista PL = new ProdutoLista();

	private JPanel contentPane;
	private JTextField TFnome;
	private JTextField TFref;
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
		
		JComboBox CBCateg = new JComboBox();
		
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
		CBCateg.setBounds(219, 5, 76, 22);
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
		
		JLabel LBQnt = new JLabel("Quant.");
		LBQnt.setFont(new Font("Tahoma", Font.PLAIN, 11));
		LBQnt.setBounds(468, 5, 34, 14);
		PainelCad.add(LBQnt);
		
		TFQNT = new JTextField();
		TFQNT.setBounds(512, 5, 86, 20);
		PainelCad.add(TFQNT);
		TFQNT.setColumns(10);
		
		JLabel LBPreco = new JLabel("Preço");
		LBPreco.setBounds(608, 5, 32, 15);
		PainelCad.add(LBPreco);
		LBPreco.setFont(new Font("Verdana", Font.PLAIN, 11));
		
		TFPreco = new JTextField();
		TFPreco.setBounds(650, 5, 86, 20);
		PainelCad.add(TFPreco);
		TFPreco.setColumns(10);
		
		JButton BTNCadastrar = new JButton("");
		BTNCadastrar.setBounds(768, 0, 32, 32);
		PainelCad.add(BTNCadastrar);
		BTNCadastrar.setIcon(new ImageIcon("C:\\Users\\Usuário\\eclipse-workspace\\ProjetoEncomendas\\ProjetoEncomendasV2\\src\\Imagens\\save_icon.png"));
		BTNCadastrar.setVerticalAlignment(SwingConstants.BOTTOM);
		BTNCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Produto produto = new Produto();
				 
				String nome = TFnome.getText();
				
				String CBcat = (String) CBCateg.getSelectedItem();
				
				String ref = TFref.getText();
				Integer.parseInt(ref);
			
				
				String quant = TFQNT.getText();
				Integer.parseInt(quant);
				
				String preco = TFPreco.getText();
				Double.parseDouble(preco);
				
				 
				
				DefaultTableModel dados = (DefaultTableModel) TabelaProd.getModel();
				
				
					TFnome.setText("");
					CBCateg.setSelectedItem(e);
					TFref.setText("");
					TFQNT.setText("");
					TFPreco.setText("");
					
				
			
					
		                produto.setReferencia(ref);
		                produto.setNome(nome);
		                produto.setCategoria(CBcat);
		                int quantidade = Integer.parseInt(quant); // Conversão para int
		                produto.setQuantidade(quantidade); // Usar o valor convertido para int
		                double valor = Double.parseDouble(preco); // Conversão para double
		                produto.setPreco(valor); // Usar o valor convertido para double
					
		         
		                try {
		                    // Converter e definir os valores para quantidade e preço
		                    quantidade = Integer.parseInt(quant);
		                   valor = Double.parseDouble(preco);
		                    produto.setQuantidade(quantidade);
		                    produto.setPreco(valor);

		                    // Inserir o produto no banco de dados
		                    Connection conexao = Controle.Conexao.getConnection();
		                    boolean inseridoComSucesso = produto.inserirProdutoNoBanco(conexao);

		                    if (inseridoComSucesso) {
		                        // Se inserido com sucesso, limpar os campos e atualizar a tabela
		                        TFnome.setText("");
		                        CBCateg.setSelectedItem(null);
		                        TFref.setText("");
		                        TFQNT.setText("");
		                        TFPreco.setText("");

		                         dados = (DefaultTableModel) TabelaProd.getModel();
		                        dados.addRow(new String[]{nome, CBcat, ref, quant, preco});
		                    } else {
		                        // Se houver um problema na inserção, mostrar uma mensagem
		                        JOptionPane.showMessageDialog(null, "Erro ao inserir o produto no banco de dados.");
		                    }

		                    conexao.close(); // Fechar a conexão com o banco de dados
		                } catch (NumberFormatException ex) {
		                    JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos para quantidade e preço.");
		                } catch (Exception ex) {
		                    ex.printStackTrace();
		                }
		            }
			
		        });
		         
		     
		BTNCadastrar.setBackground(new Color(255, 255, 255));
		BTNCadastrar.setFont(new Font("Verdana", Font.PLAIN, 11));
		
		JButton BTNAtualizar = new JButton("");
		BTNAtualizar.addActionListener(new ActionListener() {

		
			
			public void actionPerformed(ActionEvent e) {
		
				/*public List<Produto> obterProdutosDoBanco() {
				        List<Produto> produtos = new ArrayList<>();

				        try (Connection conexao = getConnection()) {
				            String query = "SELECT * FROM produtos"; // Consulta SQL para buscar todos os produtos

				            try (PreparedStatement preparedStatement = conexao.prepareStatement(query)) {
				                ResultSet resultado = preparedStatement.executeQuery();

				                while (resultado.next()) {
				                    Produto produto = new Produto();
				                    produto.setNome(resultado.getString("nome"));
				                    produto.setCategoria(resultado.getString("categoria"));
				                    produto.setReferencia(resultado.getInt("referencia"));
				                    // Setar outros atributos do produto...

				                    produtos.add(produto);
				                }
				            }
				        } catch (SQLException e) {
				            e.printStackTrace();
				        }

				        return produtos;
				    
		*/
				
			}	
		}
		);
		BTNAtualizar.setBounds(892, 0, 32, 32);
		PainelCad.add(BTNAtualizar);
		BTNAtualizar.setIcon(new ImageIcon("C:\\Users\\Usuário\\eclipse-workspace\\ProjetoEncomendas\\ProjetoEncomendasV2\\src\\Imagens\\arrow_refresh.png"));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(0, 0, 934, 376);
		contentPane.add(scrollPane);
		
		TabelaProd = new JTable();
		TabelaProd.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Categoria", "Refer\u00EAncia", "Quantidade", "Pre\u00E7o"
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
