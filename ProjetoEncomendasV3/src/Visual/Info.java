package Visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.border.LineBorder;

import Controle.Conexao;
import java.sql.Connection;

import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import Modelos.UserInfo;
import Modelos.Usuario;

import java.text.DecimalFormat;
import java.awt.Font;



import Modelos.Contato;
import Modelos.Rastreamento;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
	private JLabel LBrecebeEmail;
    private JLabel LBrecebeTel;
    private JLabel LBrecebeEnd;
    private JLabel LBrecebebairro;
    private JLabel  LBrecebeNum;
    private JLabel LBrecebeCEP;
    private JLabel LBrecebeCidade;
    private JLabel LBrecebeUF;
    private Contato contato;
    
    
    
    
  
	/**
	 * Constructor for the Info class.
	 * 
	 * @param valorTotal      The total value.
	 * @param metodoPagamento The payment method.
	 * @param parcelas        The number of installments.
	 * 
	 * 
	 */


	// Método para buscar e preencher as informações do contato do usuário nos JLabels
    private Connection conexao;
	private JTable TBnome;
	private JTable TBend;

	


	public Info(double valorTotal, String metodoPagamento, int parcelas, Connection conexao,Usuario usuario, Contato contato) {
		this.conexao = Conexao.getConnection();
		this.valorTotal = valorTotal;
		this.metodoPagamento = metodoPagamento;
		this.parcelas = parcelas;
		this.parcelasSelecionadas = parcelasSelecionadas;
		this.usuario = usuario;
		this.conexao = conexao;
		this.contato = contato;

		
		
		setTitle("Confirmar Endereço");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 249, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 233, 327);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel LBinfovalorf = new JLabel("Valor:");
		LBinfovalorf.setFont(new Font("Tahoma", Font.BOLD, 11));
		LBinfovalorf.setBounds(10, 264, 46, 14);
		panel.add(LBinfovalorf);

		JPanel enfeite01 = new JPanel();
		enfeite01.setBorder(new LineBorder(new Color(0, 0, 0)));
		enfeite01.setBackground(new Color(124, 252, 0));
		enfeite01.setBounds(10, 61, 213, 4);
		panel.add(enfeite01);
	 
		String valorTotalFormatado = String.format("%.2f", valorTotal);
		LBvalorfinal = new JLabel(String.valueOf(valorTotalFormatado)); // Definindo o valor total
		LBvalorfinal.setBounds(56, 264, 74, 14);
		panel.add(LBvalorfinal);

		JLabel LBinfoMetodo = new JLabel("Método Pag.:");
		LBinfoMetodo.setFont(new Font("Tahoma", Font.BOLD, 11));
		LBinfoMetodo.setBounds(10, 239, 83, 14);
		panel.add(LBinfoMetodo);

		LBMetodo = new JLabel(metodoPagamento); // Definindo o método de pagamento
		LBMetodo.setBounds(102, 239, 112, 14);
		panel.add(LBMetodo);

		JPanel enfeite01_1 = new JPanel();
		enfeite01_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		enfeite01_1.setBackground(new Color(124, 252, 0));
		enfeite01_1.setBounds(10, 224, 213, 4);
		panel.add(enfeite01_1);
		
		
		
		TBnome = new JTable();
		TBnome.setModel(new DefaultTableModel(
			new Object[][] {
				{"Nome", ""},
                {"CPF", ""}
				
			},
			new String[] {
				"Info", "Dados"
			}
		));
		
		TBnome.setBounds(10, 18, 213, 32);
		panel.add(TBnome);
		
		TBend = new JTable();
		TBend.setBounds(10, 76, 213, 138);
		panel.add(TBend);
	
		JButton BTNcódigo = new JButton("Finalizar");
		BTNcódigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  String codigoRastreamento = Rastreamento.gerarCodigoRastreamento();
	                JOptionPane.showMessageDialog(null, "Código de rastreamento gerado: " + codigoRastreamento);
	                
	                StringSelection stringSelection = new StringSelection(codigoRastreamento);
	                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	                clipboard.setContents(stringSelection, null);
	            }
	        });
		BTNcódigo.setBounds(66, 293, 89, 23);
		panel.add(BTNcódigo);
	
		
	}
}
		
