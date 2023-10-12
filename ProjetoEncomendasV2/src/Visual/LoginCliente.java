package Visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginCliente extends JFrame {

	private JPanel contentPane;
	private JLabel LBLogin;
	private JTextField TFUser;
	private JTextField TFSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginCliente frame = new LoginCliente();
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
	public LoginCliente() {
		setTitle("Rastreio de Encomendas - Login Usuário");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Usuário\\eclipse-workspace\\ProjetoEncomendas\\ProjetoEncomendasV2\\src\\Imagens\\20512_gtk_goto_first_rtl_icon.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(143, 188, 143));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(125, 11, 375, 389);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel LBTitulo = new JLabel("Rastreio Encomendas");
		LBTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		LBTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		LBTitulo.setBounds(0, 11, 375, 34);
		panel.add(LBTitulo);
		
		LBLogin = new JLabel("CPF");
		LBLogin.setHorizontalAlignment(SwingConstants.CENTER);
		LBLogin.setFont(new Font("Verdana", Font.PLAIN, 18));
		LBLogin.setBounds(0, 72, 375, 23);
		panel.add(LBLogin);
		
		JLabel LBSenha = new JLabel("Senha");
		LBSenha.setHorizontalAlignment(SwingConstants.CENTER);
		LBSenha.setFont(new Font("Verdana", Font.PLAIN, 18));
		LBSenha.setBounds(0, 137, 375, 23);
		panel.add(LBSenha);
		
		TFUser = new JTextField();
		TFUser.setBounds(74, 106, 228, 20);
		panel.add(TFUser);
		TFUser.setColumns(10);
		
		TFSenha = new JTextField();
		TFSenha.setColumns(10);
		TFSenha.setBounds(74, 171, 228, 20);
		panel.add(TFSenha);
		
		JButton BTNLogin = new JButton("Login");
		BTNLogin.setForeground(new Color(0, 0, 0));
		BTNLogin.setBackground(new Color(0, 204, 0));
		BTNLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Principal P = new Principal();
				P.setVisible(true);
				
				
				
			}
		});
		BTNLogin.setBounds(151, 213, 79, 23);
		panel.add(BTNLogin);
		
		JLabel LBInfo = new JLabel("Não possuí um cadastro?");
		LBInfo.setForeground(new Color(0, 51, 255));
		LBInfo.setBounds(10, 275, 355, 14);
		panel.add(LBInfo);
		
		JLabel LBInfo2 = new JLabel("Clique Abaixo");
		LBInfo2.setHorizontalAlignment(SwingConstants.LEFT);
		LBInfo2.setIcon(new ImageIcon("C:\\Users\\Usuário\\eclipse-workspace\\ProjetoEncomendas\\ProjetoEncomendasV2\\src\\Imagens\\baixo24.png"));
		LBInfo2.setForeground(new Color(0, 51, 255));
		LBInfo2.setBounds(10, 294, 119, 34);
		panel.add(LBInfo2);
		
		JButton BTNCadastro = new JButton("Cadastrar");
		BTNCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaCadastro TC = new TelaCadastro();
				TC.setVisible(true);
				
				
			}
		});
		BTNCadastro.setBackground(new Color(0, 204, 0));
		BTNCadastro.setBounds(10, 339, 119, 23);
		panel.add(BTNCadastro);
		
		JLabel LBadmin = new JLabel("Sou Administrador");
		LBadmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				LoginAdmin LA = new LoginAdmin();
				LA.setVisible(true);
				
				
			}
		});
		LBadmin.setHorizontalAlignment(SwingConstants.CENTER);
		LBadmin.setForeground(new Color(0, 51, 255));
		LBadmin.setBounds(261, 344, 104, 34);
		panel.add(LBadmin);
	}
}
