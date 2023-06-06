package gui;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarFinancaFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeFinanca;
	private JTextField txtValorFinanca;
	private JPanel cadastrofinancaPanel;
	private JLabel lblNomeFinanca;
	private JLabel lblValorFinanca;
	private JPanel categoriaPanel;
	private JComboBox cbCategoria;
	private JPanel botoesPanel;
	private JButton btnCadastrarCategoria;
	private JButton btnEditarCategoria;
	private JRadioButton rdbtnMensal;
	private JRadioButton rdbtnOcasional;
	private JPanel tipoPanel;
	private JPanel mesPanel;
	private JComboBox cbMes;
	private JButton btnCadastrarFinanca;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String tipo = "";
					CadastrarFinancaFrame frame = new CadastrarFinancaFrame(tipo);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	
	public CadastrarFinancaFrame() {
		initComponents("");
	}
	
	public CadastrarFinancaFrame(String tipoFinanca) {
		initComponents(tipoFinanca);
	}
	/*
	  Create the frame.
	 */
	
	public void initComponents(String tipoFinanca) {
		
		setTitle("Cadastro de "+tipoFinanca);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cadastrofinancaPanel = new JPanel();
		cadastrofinancaPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		cadastrofinancaPanel.setBounds(10, 11, 414, 441);
		contentPane.add(cadastrofinancaPanel);
		cadastrofinancaPanel.setLayout(null);
		
		lblNomeFinanca = new JLabel("Nome");
		lblNomeFinanca.setBounds(10, 11, 65, 14);
		cadastrofinancaPanel.add(lblNomeFinanca);
		
		txtNomeFinanca = new JTextField();
		txtNomeFinanca.setBounds(10, 29, 390, 30);
		cadastrofinancaPanel.add(txtNomeFinanca);
		txtNomeFinanca.setColumns(10);
		
		lblValorFinanca = new JLabel("Valor");
		lblValorFinanca.setBounds(10, 66, 65, 14);
		cadastrofinancaPanel.add(lblValorFinanca);
		
		txtValorFinanca = new JTextField();
		txtValorFinanca.setColumns(10);
		txtValorFinanca.setBounds(10, 84, 175, 30);
		cadastrofinancaPanel.add(txtValorFinanca);
		
		categoriaPanel = new JPanel();
		categoriaPanel.setLayout(null);
		categoriaPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Categoria", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		categoriaPanel.setBounds(196, 66, 207, 128);
		cadastrofinancaPanel.add(categoriaPanel);
		
		cbCategoria = new JComboBox();
		cbCategoria.setBounds(16, 20, 175, 30);
		categoriaPanel.add(cbCategoria);
		
		botoesPanel = new JPanel();
		botoesPanel.setBounds(7, 57, 190, 63);
		categoriaPanel.add(botoesPanel);
		botoesPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnCadastrarCategoria = new JButton("Cadastrar nova Categoria");
		btnCadastrarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCadastrarCategoriaActionPerformed();
			}
		});
		btnCadastrarCategoria.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrarCategoria.setBackground(new Color(221, 249, 226));
		botoesPanel.add(btnCadastrarCategoria);
		
		btnEditarCategoria = new JButton("Editar Categoria");
		btnEditarCategoria.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditarCategoria.setBackground(new Color(191, 214, 255));
		botoesPanel.add(btnEditarCategoria);
		
		tipoPanel = new JPanel();
		tipoPanel.setBounds(10, 124, 177, 70);
		cadastrofinancaPanel.add(tipoPanel);
		tipoPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tipoPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		rdbtnMensal = new JRadioButton("Mensal");
		tipoPanel.add(rdbtnMensal);
		
		rdbtnOcasional = new JRadioButton("Ocasional");
		tipoPanel.add(rdbtnOcasional);
		
		mesPanel = new JPanel();
		mesPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "M\u00EAs", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		mesPanel.setBounds(10, 205, 177, 70);
		cadastrofinancaPanel.add(mesPanel);
		mesPanel.setLayout(null);
		
		cbMes = new JComboBox();
		cbMes.setBounds(16, 20, 143, 30);
		mesPanel.add(cbMes);
		
		btnCadastrarFinanca = new JButton("Cadastrar");
		btnCadastrarFinanca.setBackground(new Color(221, 249, 226));
		btnCadastrarFinanca.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrarFinanca.setBounds(28, 385, 115, 30);
		cadastrofinancaPanel.add(btnCadastrarFinanca);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fechar a tela
            	dispose();
            }
        });
		btnCancelar.setBackground(new Color(255, 176, 176));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancelar.setBounds(270, 385, 115, 30);
		cadastrofinancaPanel.add(btnCancelar);
	}
	
	public void btnCadastrarCategoriaActionPerformed() {
		
	}
}
