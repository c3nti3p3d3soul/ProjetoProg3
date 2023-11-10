package Visual;

import java.awt.EventQueue;

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
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.io.Closeable;
import java.awt.event.ActionEvent;

public class TelaCadastro extends JFrame {

	private JPanel Painel;
	private JTextField TFNome;
	private JTextField TFCPF;
	private JTextField TFend;
	private JTextField TFnum;
	private JTextField tfCEP;
	private JTextField TFestado;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public TelaCadastro() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 449, 400);
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
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(252, 39, 151, 20);
		PainelBasico.add(dateChooser);
		
		JPanel Painelend = new JPanel();
		Painelend.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Painelend.setBackground(new Color(211, 211, 211));
		Painelend.setBounds(10, 152, 413, 91);
		Painel.add(Painelend);
		Painelend.setLayout(null);
		
		JLabel LBEndereco_1 = new JLabel("Endereço");
		LBEndereco_1.setBounds(172, 7, 69, 20);
		LBEndereco_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		Painelend.add(LBEndereco_1);
		
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
		
		tfCEP = new JTextField();
		tfCEP.setColumns(10);
		tfCEP.setBounds(233, 35, 86, 20);
		Painelend.add(tfCEP);
		
		JLabel LBcidade = new JLabel("Cidade");
		LBcidade.setFont(new Font("Verdana", Font.PLAIN, 15));
		LBcidade.setBounds(10, 64, 80, 19);
		Painelend.add(LBcidade);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(85, 64, 93, 22);
		Painelend.add(comboBox);
		
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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(85, 35, 104, 20);
		Painelend.add(textField);
		
		JLabel LBComplemento = new JLabel("Comp.");
		LBComplemento.setFont(new Font("Verdana", Font.PLAIN, 15));
		LBComplemento.setBounds(261, 64, 50, 19);
		Painelend.add(LBComplemento);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(321, 64, 82, 22);
		Painelend.add(comboBox_1);
		
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
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(253, 35, 150, 20);
		PainelContato.add(textField_2);
		
		JLabel LBTelefone = new JLabel("Telefone");
		LBTelefone.setFont(new Font("Verdana", Font.PLAIN, 15));
		LBTelefone.setBounds(10, 38, 69, 14);
		PainelContato.add(LBTelefone);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(85, 35, 125, 20);
		PainelContato.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(85, 9, 318, 20);
		PainelContato.add(textField_5);
		
		JPanel panel_1_1_1_1_2_2 = new JPanel();
		panel_1_1_1_1_2_2.setBackground(new Color(124, 252, 0));
		panel_1_1_1_1_2_2.setBounds(0, 64, 413, 3);
		PainelContato.add(panel_1_1_1_1_2_2);
		
		JPanel panel_1_1_1_1_1_2 = new JPanel();
		panel_1_1_1_1_1_2.setBackground(new Color(124, 252, 0));
		panel_1_1_1_1_1_2.setBounds(0, 70, 413, 3);
		PainelContato.add(panel_1_1_1_1_1_2);
		
		JPanel panel_1_1_1_1_2 = new JPanel();
		panel_1_1_1_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1_1_1_2.setBackground(new Color(124, 252, 0));
		panel_1_1_1_1_2.setBounds(10, 245, 413, 3);
		Painel.add(panel_1_1_1_1_2);
		
		JPanel panel_1_1_1_1_1 = new JPanel();
		panel_1_1_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1_1_1_1.setBounds(10, 251, 413, 3);
		Painel.add(panel_1_1_1_1_1);
		panel_1_1_1_1_1.setBackground(new Color(124, 252, 0));
		
		JPanel panel_1_1_1_1_1_1 = new JPanel();
		panel_1_1_1_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1_1_1_1_1.setBackground(new Color(124, 252, 0));
		panel_1_1_1_1_1_1.setBounds(10, 146, 413, 3);
		Painel.add(panel_1_1_1_1_1_1);
		
		JPanel panel_1_1_1_1_2_1 = new JPanel();
		panel_1_1_1_1_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1_1_1_2_1.setBackground(new Color(124, 252, 0));
		panel_1_1_1_1_2_1.setBounds(10, 140, 413, 3);
		Painel.add(panel_1_1_1_1_2_1);
		
		JPanel panel_1_1_1_1_1_3 = new JPanel();
		panel_1_1_1_1_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1_1_1_1_3.setBackground(new Color(124, 252, 0));
		panel_1_1_1_1_1_3.setBounds(10, 327, 413, 3);
		Painel.add(panel_1_1_1_1_1_3);
		panel_1_1_1_1_1_3.setLayout(null);
		
		JPanel panel_1_1_1_1_2_3 = new JPanel();
		panel_1_1_1_1_2_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1_1_1_2_3.setBackground(new Color(124, 252, 0));
		panel_1_1_1_1_2_3.setBounds(10, 321, 413, 3);
		Painel.add(panel_1_1_1_1_2_3);
		
		JButton BTNCadastrar = new JButton("Cadastrar");
		BTNCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				JOptionPane.showMessageDialog(BTNCadastrar, "Cadastrado com Sucesso!" +" "+ "Retornando a página de Login...");
				Login L = new Login();
				L.setVisible(true);
			
				
				
			}
		});
		BTNCadastrar.setBounds(176, 332, 98, 23);
		Painel.add(BTNCadastrar);
	}
}
