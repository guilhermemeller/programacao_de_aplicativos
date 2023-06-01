package testesGui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class CadastrarFinancaTela extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeFinanca;
	private JTextField txtValorFinanca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarFinancaTela frame = new CadastrarFinancaTela();
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
	public CadastrarFinancaTela() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel cadastrofinancaPanel = new JPanel();
		cadastrofinancaPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		cadastrofinancaPanel.setBounds(10, 11, 414, 441);
		contentPane.add(cadastrofinancaPanel);
		cadastrofinancaPanel.setLayout(null);
		
		JLabel lblNomeFinanca = new JLabel("Nome");
		lblNomeFinanca.setBounds(10, 11, 65, 14);
		cadastrofinancaPanel.add(lblNomeFinanca);
		
		txtNomeFinanca = new JTextField();
		txtNomeFinanca.setBounds(10, 29, 390, 30);
		cadastrofinancaPanel.add(txtNomeFinanca);
		txtNomeFinanca.setColumns(10);
		
		JLabel lblValorFinanca = new JLabel("Valor");
		lblValorFinanca.setBounds(10, 66, 65, 14);
		cadastrofinancaPanel.add(lblValorFinanca);
		
		txtValorFinanca = new JTextField();
		txtValorFinanca.setColumns(10);
		txtValorFinanca.setBounds(10, 84, 175, 30);
		cadastrofinancaPanel.add(txtValorFinanca);
		
		JPanel categoriaPanel = new JPanel();
		categoriaPanel.setLayout(null);
		categoriaPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Categoria", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		categoriaPanel.setBounds(196, 66, 207, 128);
		cadastrofinancaPanel.add(categoriaPanel);
		
		JComboBox cbCategoria = new JComboBox();
		cbCategoria.setBounds(16, 20, 175, 30);
		categoriaPanel.add(cbCategoria);
		
		JPanel botoesPanel = new JPanel();
		botoesPanel.setBounds(16, 57, 175, 63);
		categoriaPanel.add(botoesPanel);
		botoesPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnCadastrarCategoria = new JButton("Cadastrar Categoria");
		btnCadastrarCategoria.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrarCategoria.setBackground(new Color(221, 249, 226));
		botoesPanel.add(btnCadastrarCategoria);
		
		JButton btnEditarCategoria = new JButton("Editar Categoria");
		btnEditarCategoria.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditarCategoria.setBackground(new Color(191, 214, 255));
		botoesPanel.add(btnEditarCategoria);
		
		JPanel tipoPanel = new JPanel();
		tipoPanel.setBounds(10, 124, 177, 70);
		cadastrofinancaPanel.add(tipoPanel);
		tipoPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tipoPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JRadioButton rdbtnMensal = new JRadioButton("Mensal");
		tipoPanel.add(rdbtnMensal);
		
		JRadioButton rdbtnOcasional = new JRadioButton("Ocasional");
		tipoPanel.add(rdbtnOcasional);
		
		JPanel mesPanel = new JPanel();
		mesPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "M\u00EAs", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		mesPanel.setBounds(10, 205, 177, 70);
		cadastrofinancaPanel.add(mesPanel);
		mesPanel.setLayout(null);
		
		JComboBox cbMes = new JComboBox();
		cbMes.setBounds(16, 20, 143, 30);
		mesPanel.add(cbMes);
		
		JButton btnCadastrarFinanca = new JButton("Cadastrar");
		btnCadastrarFinanca.setBackground(new Color(221, 249, 226));
		btnCadastrarFinanca.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrarFinanca.setBounds(28, 385, 115, 30);
		cadastrofinancaPanel.add(btnCadastrarFinanca);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(255, 176, 176));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancelar.setBounds(270, 385, 115, 30);
		cadastrofinancaPanel.add(btnCancelar);
	}
}
