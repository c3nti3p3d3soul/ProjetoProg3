package Visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

import Controle.Controle;
import Modelos.UserInfo;
import Modelos.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

public class Login extends JFrame {

	private JPanel contentPane;
	private JLabel LBLogin;
	JTextField TFUser;
	JTextField TFSenha;
	

	
	public Login() {
		setTitle("Rastreio de Encomendas - Login Admin");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Usuário\\eclipse-workspace\\ProjetoEncomendas\\ProjetoEncomendasV2\\src\\Imagens\\20512_gtk_goto_first_rtl_icon.png"));
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

		LBLogin = new JLabel("Usuário");
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
				
				String nomeUsuario = TFUser.getText(); // Supondo que TFUser seja o campo de texto do nome de usuário
				String senha = TFSenha.getText();

				Usuario User = Usuario.LogarUsuario(nomeUsuario, senha);
 
				
				
				if (User != null) {
					PrincipalU PU = new PrincipalU();
					PU.setVisible(true);
					JOptionPane.showMessageDialog(null, "Bem-Vindo(a), " + User.getNome());
					dispose();
		
					
				} else {

					JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!");

				}

				if (nomeUsuario.equals("admin") && senha.equals("admin")) {
					// Se o usuário e a senha forem iguais a "admin", abra a tela principal
					Principal P = new Principal();
					P.setVisible(true);
					
					JOptionPane.showMessageDialog(null, "Bem-Vindo Administrador!");

				} else {

				}

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
		LBInfo2.setIcon(new ImageIcon(
				"C:\\Users\\Usuário\\eclipse-workspace\\ProjetoEncomendas\\ProjetoEncomendasV2\\src\\Imagens\\baixo24.png"));
		LBInfo2.setForeground(new Color(0, 51, 255));
		LBInfo2.setBounds(10, 294, 119, 34);
		panel.add(LBInfo2);

		JButton BTNCadastro = new JButton("Cadastrar");
		BTNCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaCadastro TD = new TelaCadastro();
				TD.setVisible(true);

			}
		});
		BTNCadastro.setBackground(new Color(0, 204, 0));
		BTNCadastro.setBounds(10, 339, 119, 23);
		panel.add(BTNCadastro);

	}

	public JTextField getTFUser() {
		return TFUser;
	}

	public void setTFUser(JTextField tFUser) {
		TFUser = tFUser;
	}

	public JTextField getTFSenha() {
		return TFSenha;
	}

	public void setTFSenha(JTextField tFSenha) {
		TFSenha = tFSenha;
	}
}
