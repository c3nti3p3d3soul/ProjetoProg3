package Visual;

import java.awt.EventQueue;
import Modelos.Usuario;
import Modelos.Contato;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.io.Closeable;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.SystemColor;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;

public class TelaCadastro extends JFrame {

	private JPanel Painel;
	private JTextField TFNome;
	private JTextField TFCPF;
	private JTextField TFend;
	private JTextField TFnum;
	private JTextField TFcep;
	private JTextField TFestado;
	private JTextField TFBairro;
	private JTextField TFCelular;
	private JTextField TFtelefone;
	private JTextField TFEmail;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TelaCadastro() {
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 449, 521);
		Painel = new JPanel();
		Painel.setBackground(new Color(240, 240, 240));
		Painel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(Painel);
		Painel.setLayout(null);

		JPanel PainelTitulo = new JPanel();
		PainelTitulo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		PainelTitulo.setBackground(new Color(60, 179, 113));
		PainelTitulo.setBounds(10, 11, 413, 41);
		Painel.add(PainelTitulo);

		JLabel LBtitulo = new JLabel("Cadastro");
		PainelTitulo.add(LBtitulo);
		LBtitulo.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		LBtitulo.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel LBNome = new JLabel("Nome");
		LBNome.setFont(new Font("Verdana", Font.PLAIN, 15));
		LBNome.setBounds(21, 75, 45, 14);
		Painel.add(LBNome);

		TFNome = new JTextField();
		TFNome.setBounds(76, 74, 151, 20);
		Painel.add(TFNome);
		TFNome.setColumns(10);

		JLabel LBData = new JLabel("Data de Nascimento");
		LBData.setHorizontalAlignment(SwingConstants.CENTER);
		LBData.setFont(new Font("Verdana", Font.PLAIN, 15));
		LBData.setBounds(264, 80, 151, 14);
		Painel.add(LBData);

		TFend = new JTextField();
		TFend.setColumns(10);
		TFend.setBounds(95, 161, 320, 20);
		Painel.add(TFend);

		JLabel LBEndereco = new JLabel("Endereço");
		LBEndereco.setFont(new Font("Verdana", Font.PLAIN, 15));
		LBEndereco.setBounds(20, 160, 80, 19);
		Painel.add(LBEndereco);

		JPanel PainelBasico = new JPanel();
		PainelBasico.setBackground(new Color(211, 211, 211));
		PainelBasico.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		PainelBasico.setBounds(10, 63, 413, 75);
		Painel.add(PainelBasico);
		PainelBasico.setLayout(null);

		JLabel LBCPF = new JLabel("CPF");
		LBCPF.setBounds(10, 39, 45, 14);
		PainelBasico.add(LBCPF);
		LBCPF.setFont(new Font("Verdana", Font.PLAIN, 15));

		TFCPF = new JTextField();
		TFCPF.setBounds(65, 38, 151, 20);
		PainelBasico.add(TFCPF);
		TFCPF.setColumns(10);

		JFormattedTextField FTdataNasc = new JFormattedTextField();
		FTdataNasc.setBounds(255, 38, 148, 20);
		PainelBasico.add(FTdataNasc);

		JPanel Painelend = new JPanel();
		Painelend.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Painelend.setBackground(new Color(211, 211, 211));
		Painelend.setBounds(10, 152, 413, 91);
		Painel.add(Painelend);
		Painelend.setLayout(null);

		JLabel LBnum = new JLabel("Nº");
		LBnum.setFont(new Font("Verdana", Font.PLAIN, 15));
		LBnum.setBounds(336, 34, 28, 19);
		Painelend.add(LBnum);

		TFnum = new JTextField();
		TFnum.setColumns(10);
		TFnum.setBounds(357, 35, 46, 20);
		Painelend.add(TFnum);

		JLabel LBcep = new JLabel("CEP");
		LBcep.setFont(new Font("Verdana", Font.PLAIN, 15));
		LBcep.setBounds(201, 34, 40, 19);
		Painelend.add(LBcep);

		TFcep = new JTextField();
		TFcep.setColumns(10);
		TFcep.setBounds(233, 35, 86, 20);
		Painelend.add(TFcep);

		JLabel LBcidade = new JLabel("Cidade");
		LBcidade.setFont(new Font("Verdana", Font.PLAIN, 15));
		LBcidade.setBounds(10, 64, 80, 19);
		Painelend.add(LBcidade);

		JComboBox CBcidade = new JComboBox();
		CBcidade.setModel(new DefaultComboBoxModel(
				new String[] { "São Paulo", "Rio de Janeiro", "Salvador", "Brasília", "Palmas" }));
		CBcidade.setBounds(85, 64, 93, 22);
		Painelend.add(CBcidade);

		JLabel LBEstado = new JLabel("UF");
		LBEstado.setFont(new Font("Verdana", Font.PLAIN, 15));
		LBEstado.setBounds(183, 64, 28, 19);
		Painelend.add(LBEstado);

		TFestado = new JTextField();
		TFestado.setColumns(10);
		TFestado.setBounds(211, 65, 40, 20);
		Painelend.add(TFestado);

		JLabel LBBairro = new JLabel("Bairro");
		LBBairro.setFont(new Font("Verdana", Font.PLAIN, 15));
		LBBairro.setBounds(10, 38, 46, 14);
		Painelend.add(LBBairro);

		TFBairro = new JTextField();
		TFBairro.setColumns(10);
		TFBairro.setBounds(85, 35, 104, 20);
		Painelend.add(TFBairro);

		JLabel LBComplemento = new JLabel("Comp.");
		LBComplemento.setFont(new Font("Verdana", Font.PLAIN, 15));
		LBComplemento.setBounds(261, 64, 50, 19);
		Painelend.add(LBComplemento);

		JComboBox ComplCB = new JComboBox();
		ComplCB.setModel(new DefaultComboBoxModel(new String[] { "Casa", "Apto.", "Rural" }));
		ComplCB.setBounds(321, 64, 82, 22);
		Painelend.add(ComplCB);

		JPanel PainelContato = new JPanel();
		PainelContato.setLayout(null);
		PainelContato.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		PainelContato.setBackground(new Color(211, 211, 211));
		PainelContato.setBounds(10, 257, 413, 64);
		Painel.add(PainelContato);

		JLabel LBEmail = new JLabel("Email");
		LBEmail.setFont(new Font("Verdana", Font.PLAIN, 15));
		LBEmail.setBounds(10, 7, 69, 20);
		PainelContato.add(LBEmail);

		JLabel LBCelular = new JLabel("Cel");
		LBCelular.setFont(new Font("Verdana", Font.PLAIN, 15));
		LBCelular.setBounds(221, 34, 40, 19);
		PainelContato.add(LBCelular);

		TFCelular = new JTextField();
		TFCelular.setColumns(10);
		TFCelular.setBounds(253, 35, 150, 20);
		PainelContato.add(TFCelular);

		JLabel LBTelefone = new JLabel("Telefone");
		LBTelefone.setFont(new Font("Verdana", Font.PLAIN, 15));
		LBTelefone.setBounds(10, 38, 69, 14);
		PainelContato.add(LBTelefone);

		TFtelefone = new JTextField();
		TFtelefone.setColumns(10);
		TFtelefone.setBounds(85, 35, 125, 20);
		PainelContato.add(TFtelefone);

		TFEmail = new JTextField();
		TFEmail.setColumns(10);
		TFEmail.setBounds(85, 9, 318, 20);
		PainelContato.add(TFEmail);

		JPanel panel_1_1_1_1_2_2 = new JPanel();
		panel_1_1_1_1_2_2.setBackground(new Color(124, 252, 0));
		panel_1_1_1_1_2_2.setBounds(0, 64, 413, 3);
		PainelContato.add(panel_1_1_1_1_2_2);

		JPanel panel_1_1_1_1_1_2 = new JPanel();
		panel_1_1_1_1_1_2.setBackground(new Color(124, 252, 0));
		panel_1_1_1_1_1_2.setBounds(0, 70, 413, 3);
		PainelContato.add(panel_1_1_1_1_1_2);

		JPanel enfeite = new JPanel();
		enfeite.setBorder(new LineBorder(new Color(0, 0, 0)));
		enfeite.setBackground(new Color(124, 252, 0));
		enfeite.setBounds(10, 245, 413, 3);
		Painel.add(enfeite);

		JPanel enfeite2 = new JPanel();
		enfeite2.setBorder(new LineBorder(new Color(0, 0, 0)));
		enfeite2.setBounds(10, 251, 413, 3);
		Painel.add(enfeite2);
		enfeite2.setBackground(new Color(124, 252, 0));

		JPanel enfeite3 = new JPanel();
		enfeite3.setBorder(new LineBorder(new Color(0, 0, 0)));
		enfeite3.setBackground(new Color(124, 252, 0));
		enfeite3.setBounds(10, 146, 413, 3);
		Painel.add(enfeite3);

		JPanel enfeite4 = new JPanel();
		enfeite4.setBorder(new LineBorder(new Color(0, 0, 0)));
		enfeite4.setBackground(new Color(124, 252, 0));
		enfeite4.setBounds(10, 140, 413, 3);
		Painel.add(enfeite4);

		JPanel enfeite5 = new JPanel();
		enfeite5.setBorder(new LineBorder(new Color(0, 0, 0)));
		enfeite5.setBackground(new Color(124, 252, 0));
		enfeite5.setBounds(10, 327, 413, 3);
		Painel.add(enfeite5);
		enfeite5.setLayout(null);

		JPanel enfeite6 = new JPanel();
		enfeite6.setBorder(new LineBorder(new Color(0, 0, 0)));
		enfeite6.setBackground(new Color(124, 252, 0));
		enfeite6.setBounds(10, 321, 413, 3);
		Painel.add(enfeite6);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(211, 211, 211));
		panel.setBounds(10, 333, 413, 138);
		Painel.add(panel);
		panel.setLayout(null);

		JFormattedTextField FTSenha = new JFormattedTextField();
		FTSenha.setBounds(10, 30, 395, 20);
		panel.add(FTSenha);

		JButton BTNCadastrar = new JButton("Cadastrar");
		BTNCadastrar.setBounds(160, 104, 98, 23);
		panel.add(BTNCadastrar);

		JFormattedTextField FTconfirma = new JFormattedTextField();
		FTconfirma.setToolTipText("Corfime sua senha");
		FTconfirma.setBounds(10, 73, 395, 20);
		panel.add(FTconfirma);

		JLabel lblNewLabel = new JLabel("Digite uma senha:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 11, 395, 14);
		panel.add(lblNewLabel);

		JLabel lblConfirme = new JLabel("Confirme");
		lblConfirme.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirme.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblConfirme.setBounds(0, 58, 395, 14);
		panel.add(lblConfirme);
		BTNCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Login L = new Login();
				L.setVisible(true);

				Usuario User = new Usuario();
				Contato Contact = new Contato();

				String nome = TFNome.getText();
				String CPF = TFCPF.getText();
				String Senha = FTSenha.getText();

				String Endereco = TFend.getText();
				String Bairro = TFBairro.getText();
				String NumeroCasa = TFnum.getText();
				String Cep = TFcep.getText();
				String UF = TFestado.getText();
				String cel = TFCelular.getText();
				String telef = TFtelefone.getText();
				String Email = TFEmail.getText();
				String dataNascimento = FTdataNasc.getText();
				String cidade = (String) CBcidade.getSelectedItem();

				User.setNome(nome);
				User.setCPF(CPF);
				User.setSenha(Senha);

//======================//==================//
				Contact.setEndereco(Endereco);
				Contact.setBairro(Bairro);
				Contact.setNumeroCasa(NumeroCasa);
				Contact.setCep(Cep);
				Contact.setUf(UF);
				Contact.setTelefone(telef);
				Contact.setEmail(Email);
				Contact.setDataNascimento(dataNascimento);
				Contact.setCidade(cidade);

				Connection conexao = Controle.Conexao.getConnection();
				boolean inseridoComSucessoCD = User.inserirUsuario(conexao);

				if (inseridoComSucessoCD) {
					// Se inserido com sucesso, limpar os campos e atualizar a tabela
					TFend.setText("");
					TFnum.setText("");
					TFcep.setText("");
					TFestado.setText("");
					TFBairro.setText("");
					TFCelular.setText("");
					TFtelefone.setText("");
					TFEmail.setText("");
					FTdataNasc.setText("");
				} else {
					// Se houver um problema na inserção, mostrar uma mensagem
					JOptionPane.showMessageDialog(null, "Erro ao inserir usuario no banco de dados.");
				}

				boolean insereContato = Contact.inserirContato(conexao);

				if (insereContato) {
					// Se inserido com sucesso, limpar os campos e atualizar a tabela
					TFNome.setText("");
					TFCPF.setText("");
					FTSenha.setText("");

				} else {

					// Se houver um problema na inserção, mostrar uma mensagem
					JOptionPane.showMessageDialog(null, "Erro ao inserir o usuario no banco de dados.");
				}

			}

		});
	}
}
