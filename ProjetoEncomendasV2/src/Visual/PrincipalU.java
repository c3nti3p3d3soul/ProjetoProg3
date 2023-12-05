package Visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import Modelos.Usuario;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PrincipalU extends JFrame {
	
	
	private Usuario usuarioLogado;

    // Método para definir o usuário logado
    public void setUsuarioLogado(Usuario usuario) {
        this.usuarioLogado = usuario;
    }

	private JPanel contentPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalU frame = new PrincipalU();
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
	public PrincipalU() {
		setTitle("Compre seus produtos aqui!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBounds(0, 0, 624, 461);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(new Color(47, 79, 79));
		panel_1.setForeground(new Color(144, 238, 144));
		panel_1.setBounds(0, 0, 198, 461);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBackground(new Color(144, 238, 144));
		panel_2.setBounds(0, 106, 198, 50);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel LBcomprar = new JLabel(" Comprar");
		LBcomprar.setHorizontalAlignment(SwingConstants.LEFT);
		LBcomprar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Login L = new Login();
				
				String nomeUsuario = L.TFUser.getText(); 
				String senha = L.TFSenha.getText();

			        // Aqui você busca o usuário no banco de dados ou onde estiver armazenado
			        Usuario usuarioLogado = Usuario.buscarUsuario(nomeUsuario, senha);

			        // Define o usuário logado na tela principal
			        setUsuarioLogado(usuarioLogado);

			        // Criação da TelaVenda com o usuário logado
			        TelaVenda TV = new TelaVenda();
			        TV.setVisible(true);
			        
			      
			    }
			});

				
				
	
		LBcomprar.setFont(new Font("Verdana", Font.BOLD, 20));
		LBcomprar.setIcon(new ImageIcon("C:\\Users\\Usuário\\eclipse-workspace\\ProjetoEncomendas\\ProjetoEncomendasV2\\src\\Imagens\\32.png"));
		LBcomprar.setBounds(0, 0, 198, 50);
		panel_2.add(LBcomprar);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2_1.setBackground(new Color(144, 238, 144));
		panel_2_1.setForeground(new Color(47, 79, 79));
		panel_2_1.setBounds(0, 167, 198, 50);
		panel_1.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JLabel LBpedido = new JLabel(" Pedidos");
		LBpedido.setHorizontalAlignment(SwingConstants.LEFT);
		LBpedido.setFont(new Font("Verdana", Font.BOLD, 20));
		LBpedido.setIcon(new ImageIcon("C:\\Users\\Usuário\\eclipse-workspace\\ProjetoEncomendas\\ProjetoEncomendasV2\\src\\Imagens\\8679521_truck_fill_icon.png"));
		LBpedido.setBounds(0, 0, 198, 50);
		panel_2_1.add(LBpedido);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2_2.setBackground(new Color(144, 238, 144));
		panel_2_2.setBounds(0, 228, 198, 50);
		panel_1.add(panel_2_2);
		panel_2_2.setLayout(null);
		
		JLabel LBRastreio = new JLabel("Rastrear");
		LBRastreio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				RastreioEncomenda RE = new RastreioEncomenda();
				RE.setVisible(true);
				
				
				
			}
		});
		LBRastreio.setHorizontalAlignment(SwingConstants.LEFT);
		LBRastreio.setIcon(new ImageIcon("C:\\Users\\Usuário\\eclipse-workspace\\ProjetoEncomendas\\ProjetoEncomendasV2\\src\\Imagens\\2849827_pointer_map_location_place_multimedia_icon.png"));
		LBRastreio.setFont(new Font("Verdana", Font.BOLD, 20));
		LBRastreio.setBounds(0, 0, 198, 50);
		panel_2_2.add(LBRastreio);
		
		JPanel panel_2_3 = new JPanel();
		panel_2_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2_3.setBackground(new Color(144, 238, 144));
		panel_2_3.setBounds(0, 289, 198, 50);
		panel_1.add(panel_2_3);
		panel_2_3.setLayout(null);
		
		JPanel panel_2_4 = new JPanel();
		panel_2_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2_4.setBackground(new Color(205, 92, 92));
		panel_2_4.setBounds(0, 350, 198, 50);
		panel_1.add(panel_2_4);
		panel_2_4.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fechar");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				mouseExit(null, EXIT_ON_CLOSE, ABORT);
				
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 0, 198, 50);
		panel_2_4.add(lblNewLabel);
		
		JLabel LBtitle1 = new JLabel("Rastreio");
		LBtitle1.setForeground(new Color(255, 255, 255));
		LBtitle1.setFont(new Font("Verdana", Font.BOLD, 20));
		LBtitle1.setHorizontalAlignment(SwingConstants.CENTER);
		LBtitle1.setBounds(0, 0, 198, 37);
		panel_1.add(LBtitle1);
		
		JLabel LBtitle2 = new JLabel("de");
		LBtitle2.setForeground(new Color(255, 255, 255));
		LBtitle2.setFont(new Font("Verdana", Font.BOLD, 20));
		LBtitle2.setHorizontalAlignment(SwingConstants.CENTER);
		LBtitle2.setBounds(0, 25, 198, 37);
		panel_1.add(LBtitle2);
		
		JLabel LBtitle3 = new JLabel("Encomendas");
		LBtitle3.setForeground(new Color(255, 255, 255));
		LBtitle3.setFont(new Font("Verdana", Font.BOLD, 20));
		LBtitle3.setHorizontalAlignment(SwingConstants.CENTER);
		LBtitle3.setBounds(0, 48, 198, 39);
		panel_1.add(LBtitle3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(208, 0, 410, 461);
		panel.add(panel_3);
	}
}
