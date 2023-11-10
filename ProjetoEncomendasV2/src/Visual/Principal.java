package Visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Canvas;

public class Principal extends JFrame {

	private JPanel frmProjetoEncomendas;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("ProjetoLCM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 660);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu MenuArquivo = new JMenu("Arquivo");
		menuBar.add(MenuArquivo);
		
		JMenuItem MASalvar = new JMenuItem("Salvar");
		MenuArquivo.add(MASalvar);
		
		JMenuItem MAUser = new JMenuItem("Usuario");
		MenuArquivo.add(MAUser);
		
		JMenuItem MAConf = new JMenuItem("Configurações");
		MenuArquivo.add(MAConf);
		
		JMenu MenuCadastro = new JMenu("Cadastros");
		menuBar.add(MenuCadastro);
		
		JMenu MCProduto = new JMenu("Cadastrar Produto");
		MenuCadastro.add(MCProduto);
		
		JMenuItem MNovoP = new JMenuItem("Novo Produto");
		MNovoP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProdutoCadastro PD = new ProdutoCadastro();
				PD.setVisible(true);
			
			}
		});
		MCProduto.add(MNovoP);
		
		JMenu MCMaterial = new JMenu("Cadastrar Material");
		MenuCadastro.add(MCMaterial);
		
		JMenuItem MCMateria = new JMenuItem("Novo Material");
		MCMaterial.add(MCMateria);
		
		JMenu MenuEstoque = new JMenu("Listas/Estoque");
		menuBar.add(MenuEstoque);
		
		JMenuItem MLEstoqueM = new JMenuItem("Materiais");
		MenuEstoque.add(MLEstoqueM);
		
		JMenuItem MLEstoqueP = new JMenuItem("Produtos");
		MLEstoqueP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProdutoLista PL = new ProdutoLista();
				PL.setVisible(true);
				
			}
		});
		MenuEstoque.add(MLEstoqueP);
		
		JMenuItem MLEstoqueC = new JMenuItem("Catálogo");
		MenuEstoque.add(MLEstoqueC);
		
		JMenu MenuPedidos = new JMenu("Pedidos");
		menuBar.add(MenuPedidos);
		
		JMenuItem MPNovo = new JMenuItem("Novo Pedido");
		MenuPedidos.add(MPNovo);
		
		JMenuItem MPPronto = new JMenuItem("Pedidos Prontos");
		MenuPedidos.add(MPPronto);
		
		JMenu MenuDoc = new JMenu("Relatórios");
		menuBar.add(MenuDoc);
		
		JMenuItem MDocVenda = new JMenuItem("Relatório de Venda");
		MenuDoc.add(MDocVenda);
		frmProjetoEncomendas = new JPanel();
		frmProjetoEncomendas.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(frmProjetoEncomendas);
		frmProjetoEncomendas.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1034, 599);
		frmProjetoEncomendas.add(panel);
		panel.setLayout(null);
		
		
		
		
		
	}
}
