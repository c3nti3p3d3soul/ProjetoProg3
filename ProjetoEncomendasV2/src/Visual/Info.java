package Visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.sql.Connection;
import Modelos.UserInfo;
import Modelos.Usuario;

import java.text.DecimalFormat;
import java.awt.Font;
import java.sql.Connection;

import Modelos.Contato;
public class Info extends JFrame {

	private JPanel contentPane;
	private double valorTotal;
	private String metodoPagamento;
	private int parcelas;
	private JLabel LBvalorfinal;
	private JLabel LBMetodo;
	private String parcelasSelecionadas;
	private JLabel LBparcelas;
	private JLabel LBinfoNome;
	private JLabel LBinfoCPF;
	private Usuario usuario;
	/**
	 * Constructor for the Info class.
	 * 
	 * @param valorTotal      The total value.
	 * @param metodoPagamento The payment method.
	 * @param parcelas        The number of installments.
	 * 
	 * 
	 */

	
	// Método para configurar as informações do usuário na tela


	public Info(double valorTotal, String metodoPagamento, int parcelas) {
		this.valorTotal = valorTotal;
		this.metodoPagamento = metodoPagamento;
		this.parcelas = parcelas;
		this.parcelasSelecionadas = parcelasSelecionadas;
		this.usuario = usuario;

		setTitle("Confirmar Endereço");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 249, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 233, 361);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel LBinfoNome = new JLabel("Nome:");
		LBinfoNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		LBinfoNome.setBounds(10, 11, 36, 14);
		panel.add(LBinfoNome);

		JLabel LBinfoCPF = new JLabel("CPF:");
		LBinfoCPF.setFont(new Font("Tahoma", Font.BOLD, 11));
		LBinfoCPF.setBounds(10, 36, 36, 14);
		panel.add(LBinfoCPF);

		JLabel LBinfovalorf = new JLabel("Valor:");
		LBinfovalorf.setFont(new Font("Tahoma", Font.BOLD, 11));
		LBinfovalorf.setBounds(10, 336, 46, 14);
		panel.add(LBinfovalorf);

		JPanel enfeite01 = new JPanel();
		enfeite01.setBorder(new LineBorder(new Color(0, 0, 0)));
		enfeite01.setBackground(new Color(124, 252, 0));
		enfeite01.setBounds(10, 61, 213, 4);
		panel.add(enfeite01);
	 
		String valorTotalFormatado = String.format("%.2f", valorTotal);
		LBvalorfinal = new JLabel(String.valueOf(valorTotalFormatado)); // Definindo o valor total
		LBvalorfinal.setBounds(54, 336, 74, 14);
		panel.add(LBvalorfinal);

		JLabel LBinfoMetodo = new JLabel("Método Pag.:");
		LBinfoMetodo.setFont(new Font("Tahoma", Font.BOLD, 11));
		LBinfoMetodo.setBounds(10, 311, 83, 14);
		panel.add(LBinfoMetodo);

		LBMetodo = new JLabel(metodoPagamento); // Definindo o método de pagamento
		LBMetodo.setBounds(92, 311, 112, 14);
		panel.add(LBMetodo);

		JLabel LBinfoEmail = new JLabel("Email:");
		LBinfoEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		LBinfoEmail.setBounds(10, 78, 46, 14);
		panel.add(LBinfoEmail);

		JLabel LBinfoTelefone = new JLabel("Tel:");
		LBinfoTelefone.setFont(new Font("Tahoma", Font.BOLD, 11));
		LBinfoTelefone.setBounds(10, 103, 36, 14);
		panel.add(LBinfoTelefone);

		JLabel LBinfoEnd = new JLabel("Endereço:");
		LBinfoEnd.setFont(new Font("Tahoma", Font.BOLD, 11));
		LBinfoEnd.setBounds(10, 124, 56, 14);
		panel.add(LBinfoEnd);

		JLabel LBinfoBairro = new JLabel("Bairro:");
		LBinfoBairro.setFont(new Font("Tahoma", Font.BOLD, 11));
		LBinfoBairro.setBounds(10, 149, 46, 14);
		panel.add(LBinfoBairro);

		JLabel LBinfoCasa = new JLabel("Num:");
		LBinfoCasa.setFont(new Font("Tahoma", Font.BOLD, 11));
		LBinfoCasa.setBounds(131, 149, 36, 14);
		panel.add(LBinfoCasa);

		JLabel LBinfoCEP = new JLabel("CEP:");
		LBinfoCEP.setFont(new Font("Tahoma", Font.BOLD, 11));
		LBinfoCEP.setBounds(10, 174, 46, 14);
		panel.add(LBinfoCEP);

		JLabel LBinfoCidade = new JLabel("Cidade:");
		LBinfoCidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		LBinfoCidade.setBounds(10, 199, 46, 14);
		panel.add(LBinfoCidade);

		JLabel LBinfoUF = new JLabel("UF:");
		LBinfoUF.setFont(new Font("Tahoma", Font.BOLD, 11));
		LBinfoUF.setBounds(131, 199, 27, 14);
		panel.add(LBinfoUF);

		JLabel LBrecebeEmail = new JLabel("");
		LBrecebeEmail.setBounds(64, 78, 150, 14);
		panel.add(LBrecebeEmail);

		JLabel LBrecebeTel = new JLabel("");
		LBrecebeTel.setBounds(64, 103, 150, 14);
		panel.add(LBrecebeTel);

		JLabel LBrecebeEnd = new JLabel("");
		LBrecebeEnd.setBounds(64, 124, 140, 14);
		panel.add(LBrecebeEnd);

		JLabel LBrecebebairro = new JLabel("");
		LBrecebebairro.setBounds(66, 149, 68, 14);
		panel.add(LBrecebebairro);

		JLabel LBrecebeNum = new JLabel("");
		LBrecebeNum.setBounds(177, 149, 46, 14);
		panel.add(LBrecebeNum);

		JLabel LBrecebeCEP = new JLabel("");
		LBrecebeCEP.setBounds(66, 174, 46, 14);
		panel.add(LBrecebeCEP);

		JLabel LBrecebeCidade = new JLabel("");
		LBrecebeCidade.setBounds(66, 199, 46, 14);
		panel.add(LBrecebeCidade);

		JLabel LBrecebeUF = new JLabel("");
		LBrecebeUF.setBounds(177, 199, 46, 14);
		panel.add(LBrecebeUF);

		JPanel enfeite01_1 = new JPanel();
		enfeite01_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		enfeite01_1.setBackground(new Color(124, 252, 0));
		enfeite01_1.setBounds(10, 224, 213, 4);
		panel.add(enfeite01_1);

		JLabel LBrecebeNome = new JLabel("");
		LBrecebeNome.setBounds(56, 11, 167, 14);
		panel.add(LBrecebeNome);

		JLabel LBrecebeCPF = new JLabel("");
		LBrecebeCPF.setBounds(56, 36, 167, 14);
		panel.add(LBrecebeCPF);

	
		 UserInfo userInfo = UserInfo.getInstance();
	        String nomeUsuario = userInfo.getNomeUsuario();

	        // Verificando se o nome do usuário foi definido
	        if (nomeUsuario != null && !nomeUsuario.isEmpty()) {
	            LBrecebeNome.setText(nomeUsuario);
	           
	            // Você pode adicionar mais campos aqui para exibir outras informações do usuário, se necessário
	        }
	        
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Info frame = new Info(100.0, "Cartão de Crédito", 2); // Exemplo de valores
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
