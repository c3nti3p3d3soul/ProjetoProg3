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
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;

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
		setBounds(100, 100, 1050, 631);
		frmProjetoEncomendas = new JPanel();
		frmProjetoEncomendas.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(frmProjetoEncomendas);
		frmProjetoEncomendas.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(0, 16, 1, 1);
		frmProjetoEncomendas.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1034, 16);
		frmProjetoEncomendas.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1034, 17);
		panel_2.add(menuBar);
		
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
		
		JMenuItem MPRastreio = new JMenuItem("Rastrear Produto");
		MPRastreio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RastreioEncomenda RE = new RastreioEncomenda();
				RE.setVisible(true);
				
				
			}
		});
		MenuPedidos.add(MPRastreio);
		
		JMenu MenuDoc = new JMenu("Relatórios");
		menuBar.add(MenuDoc);
		
		JMenuItem MDocVenda = new JMenuItem("Relatório de Venda");
		MenuDoc.add(MDocVenda);
		
		
		
		
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
