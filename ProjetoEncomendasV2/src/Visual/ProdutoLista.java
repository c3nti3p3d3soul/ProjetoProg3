package Visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;

public class ProdutoLista extends JFrame {

	private JPanel contentPane;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	JTable TabelaLista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdutoLista frame = new ProdutoLista();
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
	public ProdutoLista() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 755, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		tabbedPane.setBounds(10, 11, 719, 414);
		contentPane.add(tabbedPane);
		
		TabelaLista = new JTable();
		tabbedPane.addTab("Lista", null, TabelaLista, null);
		TabelaLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		TabelaLista.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
	}
}
