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

import entities.Usuario;
import entities.Categoria;
import entities.Financa;
import service.CategoriaService;
import service.FinancaService;
import service.UsuarioService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

import utils.DadosUsuario;
import utils.Mes;

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
	public ButtonGroup buttonGroup;

	private String tipoFinanca;
	
	private Financa financa;
	private JPanel anoPanel;
	private JComboBox cbAno;

	public Financa getFinanca() {
		return financa;
	}

	public void setFinanca(Financa financa) {
		this.financa = financa;
	}

	public CadastrarFinancaFrame() {
		initComponents("", "");
	}

	public CadastrarFinancaFrame(String tipoFinanca, String cadastro_edicao) {
		setTipoFinanca(tipoFinanca);
		initComponents(tipoFinanca, cadastro_edicao);
	}

	public CadastrarFinancaFrame(String tipoFinanca, String cadastro_edicao, Financa financa) {
		setTipoFinanca(tipoFinanca);
		setFinanca(financa);
		getFinanca().setNome(financa.getNome());
		getFinanca().setMensal_Ocasional(financa.isMensal_Ocasional());
		getFinanca().setTipo(tipoFinanca);
		initComponents(tipoFinanca, cadastro_edicao);
		preencherCampos(financa, financa.getTipo());
	}
	/*
	 * Create the frame.
	 */

	public void initComponents(String tipoFinanca, String cadastro_edicao) {
		if (cadastro_edicao == "Editar") {
			setTitle("Edição de Finança");
			btnCadastrarFinanca = new JButton("Editar");
		} else {
			setTitle("Cadastro de " + tipoFinanca);
			btnCadastrarFinanca = new JButton("Cadastrar");
		}

		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		categoriaPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Categoria",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		categoriaPanel.setBounds(196, 66, 207, 128);
		cadastrofinancaPanel.add(categoriaPanel);

		cbCategoria = new JComboBox<>();
		cbCategoria.setEditable(false);

		atualizarCategorias();

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
		btnEditarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditarCategoriaActionPerformed();
			}
		});
		btnEditarCategoria.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditarCategoria.setBackground(new Color(191, 214, 255));
		botoesPanel.add(btnEditarCategoria);

		if (tipoFinanca.equals("Investimento a Longo Prazo") || tipoFinanca.equals("Fundo para Despesas Ocasionais")) {
			categoriaPanel.setVisible(false);
		}

		tipoPanel = new JPanel();
		tipoPanel.setBounds(8, 205, 177, 70);
		cadastrofinancaPanel.add(tipoPanel);
		tipoPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tipo",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tipoPanel.setLayout(new GridLayout(0, 1, 0, 0));

		rdbtnMensal = new JRadioButton("Mensal");

		rdbtnOcasional = new JRadioButton("Ocasional");

		buttonGroup = new ButtonGroup();

		buttonGroup.add(rdbtnMensal);
		buttonGroup.add(rdbtnOcasional);

		tipoPanel.add(rdbtnMensal);
		tipoPanel.add(rdbtnOcasional);
		rdbtnMensal.setSelected(true);

		rdbtnMensal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cbMes.setEnabled(false);
			}
		});

		rdbtnOcasional.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cbMes.setEnabled(true);
			}
		});

		mesPanel = new JPanel();
		mesPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "M\u00EAs",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		mesPanel.setBounds(8, 286, 177, 70);
		cadastrofinancaPanel.add(mesPanel);
		mesPanel.setLayout(null);

		cbMes = new JComboBox();
		cbMes.setModel(new DefaultComboBoxModel(Mes.values()));
		cbMes.setBounds(16, 20, 143, 30);
		mesPanel.add(cbMes);
		cbMes.setEnabled(false);

		if (tipoFinanca.equals("Fundo para Despesas Ocasionais")) {
			tipoPanel.setVisible(false);
			mesPanel.setVisible(false);
		}

		btnCadastrarFinanca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((!txtNomeFinanca.getText().equals("")) && (!txtValorFinanca.getText().equals(""))) {
					cadastrarFinancaActionPerformed(cadastro_edicao);

				} else {
					JOptionPane.showMessageDialog(null, "Os campo devem estar preenchidos!", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCadastrarFinanca.setBackground(new Color(221, 249, 226));
		btnCadastrarFinanca.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrarFinanca.setBounds(28, 385, 115, 30);

		cadastrofinancaPanel.add(btnCadastrarFinanca);
		
		anoPanel = new JPanel();
		anoPanel.setLayout(null);
		anoPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ano", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		anoPanel.setBounds(10, 124, 175, 70);
		cadastrofinancaPanel.add(anoPanel);
		
		cbAno = new JComboBox();
		cbAno.setModel(new DefaultComboBoxModel(new String[] {"2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033"}));
		cbAno.setSelectedIndex(10);
		cbAno.setBounds(16, 20, 143, 30);
		anoPanel.add(cbAno);
		
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
		String nomeCategoria = JOptionPane.showInputDialog(null, "Digite o nome da nova categoria:",
				"Cadastrar Categoria", JOptionPane.INFORMATION_MESSAGE);
		if (nomeCategoria != null) {
			Categoria categoria = new Categoria(nomeCategoria);
			CategoriaService cService = new CategoriaService();
			try {
				cService.inserirCategoria(categoria);
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
				atualizarCategorias();
			} catch (SQLException | IOException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		} else {
			// Usuário cancelou a operação
			JOptionPane.showMessageDialog(null, "Operação cancelada!");
		}
	}

	public void btnEditarCategoriaActionPerformed() {
		String cSelecionado = (String) cbCategoria.getSelectedItem();
		List<Categoria> categorias = atualizarCategorias();
		CategoriaService cService = new CategoriaService();
		EditarExcluirCategoriaDialog dialog = new EditarExcluirCategoriaDialog(cSelecionado);
		dialog.setLocationRelativeTo(null);
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				String nomeCategoriaE = dialog.getCategoriaEditada();
				if (nomeCategoriaE == null) {

				} else if (nomeCategoriaE.equals("-1")) {
					try {
						int resposta = JOptionPane.showConfirmDialog(null,
								"Deseja realmente excluir essa Categoria?\nCaso exclua, todas as Finanças vinculadas a essa categoria também serão excluidas",
								"Confirmação de Exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
						if (resposta == JOptionPane.YES_OPTION) {
							int id = buscarIdCategoria(categorias, cSelecionado);
							cService.excluirCategoria(id);
							JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
							atualizarCategorias();
						}
					} catch (SQLException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else {
					try {
						int id = buscarIdCategoria(categorias, cSelecionado);
						Categoria cate = new Categoria(id, nomeCategoriaE);
						cService.editarCategoria(cate);
						JOptionPane.showMessageDialog(null, "Editado com sucesso!");
						atualizarCategorias();
					} catch (SQLException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
		dialog.setVisible(true);
	}

	public List<Categoria> atualizarCategorias() {
		CategoriaService cService = new CategoriaService();
		cbCategoria.removeAllItems();

		List<Categoria> categorias;
		try {
			categorias = cService.buscarCategorias();
			for (Categoria categoria : categorias) {
				cbCategoria.addItem(categoria.getNome());
			}
			cbCategoria.revalidate();
			cbCategoria.repaint();
			return categorias;
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int buscarIdCategoria(List<Categoria> categorias, String nome) {

		for (Categoria categoria : categorias) {
			if (categoria.getNome().equals(nome)) {
				return categoria.getId_Categoria();
			}
		}
		return -1;
	}

	public void cadastrarFinancaActionPerformed(String cadastro_edicao) {

		String categoria;
		int id_categoria;
		categoria = (String) cbCategoria.getSelectedItem();
		List<Categoria> categorias = atualizarCategorias();
		DadosUsuario dadosUsuario = DadosUsuario.getInstance();
		FinancaService service = new FinancaService();
		Financa financa = new Financa();

		if (getTipoFinanca().equals("Rendimento") || getTipoFinanca().equals("Despesa")) {

			if (this.rdbtnMensal.isSelected()) {

				financa.setNome(txtNomeFinanca.getText());
				financa.setTotal(Double.parseDouble(txtValorFinanca.getText()));
				financa.setTipo(getTipoFinanca());
				id_categoria = buscarIdCategoria(categorias, categoria);
				financa.setCategoria(new Categoria(id_categoria));
				financa.setMensal_Ocasional(true);
				financa.setAno(Integer.parseInt((String) cbAno.getSelectedItem()));
				
				try {
					financa.setId(service.buscarIdRendimentoDespesaPorNome(dadosUsuario.getId(), financa.getNome(), financa.getMes(), financa.getAno()));
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
				if (cadastro_edicao.equals("Cadastrar")) {
					try {
						service.inserirRedimentoDespesa(financa, dadosUsuario.getId());
						JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
						limparCampos();
					} catch (SQLException | IOException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				} else {
					try {
						if(getFinanca().isMensal_Ocasional() == financa.isMensal_Ocasional()) {
							//Era mensal - virou mensal
							service.editarRendimentoDespesas(financa,getFinanca().getNome());
						}else {
							service.excluirFinanca(getFinanca(), "rendimento_despesa");
							service.inserirRedimentoDespesa(financa, dadosUsuario.getId());
						}
						
						JOptionPane.showMessageDialog(null, "Edição com sucesso!");
						this.dispose();
					} catch (SQLException | IOException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					
				}

			} else {
				financa.setNome(txtNomeFinanca.getText());
				financa.setTotal(Double.parseDouble(txtValorFinanca.getText()));
				financa.setTipo(getTipoFinanca());
				id_categoria = buscarIdCategoria(categorias, categoria);
				financa.setCategoria(new Categoria(id_categoria));
				financa.setMensal_Ocasional(false);
				financa.setMes(cbMes.getSelectedIndex() + 1);
				financa.setAno(Integer.parseInt((String) cbAno.getSelectedItem()));
				
				if (cadastro_edicao == "Cadastrar") {
					try {
						service.inserirRedimentoDespesa(financa, dadosUsuario.getId());
						JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
						limparCampos();
					} catch (SQLException | IOException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					
				}else {
					financa.setId(getFinanca().getId());
					try {
						if(getFinanca().isMensal_Ocasional() == financa.isMensal_Ocasional()) {
							service.editarRendimentoDespesas(financa,"");
						}else {
							service.excluirFinanca(getFinanca(), "rendimento_despesa");
							service.inserirRedimentoDespesa(financa, dadosUsuario.getId());
						}
						
						JOptionPane.showMessageDialog(null, "Edição com sucesso!");
						this.dispose();
					} catch (SQLException | IOException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					
					
				}

			}
		} else if (getTipoFinanca().equals("Investimento a Longo Prazo")) {
			if (this.rdbtnMensal.isSelected()) {

				financa.setNome(txtNomeFinanca.getText());
				financa.setTotal(Double.parseDouble(txtValorFinanca.getText()));
				financa.setTipo(getTipoFinanca());
				financa.setMensal_Ocasional(true);
				financa.setAno(Integer.parseInt((String) cbAno.getSelectedItem()));


				if (cadastro_edicao == "Cadastrar") {
					try {
						service.inserirInvestimento(financa, dadosUsuario.getId());
						JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
						limparCampos();
					} catch (SQLException | IOException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}else {
					//Se for edição de mensal
					try {
						if(getFinanca().isMensal_Ocasional() == financa.isMensal_Ocasional()) {
							service.editarInvestimento(financa, getFinanca().getNome());
						}else {
							service.excluirFinanca(getFinanca(), "investimento");
							service.inserirInvestimento(financa, dadosUsuario.getId());
						}
						
						JOptionPane.showMessageDialog(null, "Edição com sucesso!");
						this.dispose();
					} catch (SQLException | IOException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}
			} else {
				financa.setNome(txtNomeFinanca.getText());
				financa.setTotal(Double.parseDouble(txtValorFinanca.getText()));
				financa.setTipo(getTipoFinanca());
				financa.setMensal_Ocasional(false);
				financa.setMes(cbMes.getSelectedIndex() + 1);
				financa.setAno(Integer.parseInt((String) cbAno.getSelectedItem()));


				if (cadastro_edicao == "Cadastrar") {
					try {
						service.inserirInvestimento(financa, dadosUsuario.getId());
						JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
						limparCampos();
					} catch (SQLException | IOException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}else {
					financa.setId(getFinanca().getId());
					//Se for edição de ocasional					
					try {
						if(getFinanca().isMensal_Ocasional() == financa.isMensal_Ocasional()) {
							service.editarInvestimento(financa, "");
						}else {
							service.excluirFinanca(getFinanca(), "investimento");
							service.inserirInvestimento(financa, dadosUsuario.getId());
						}
						
						JOptionPane.showMessageDialog(null, "Edição com sucesso!");
						this.dispose();
					} catch (SQLException | IOException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}
			}
		} else if (getTipoFinanca().equals("Fundo para Despesas Ocasionais")) {
			financa.setNome(txtNomeFinanca.getText());
			financa.setTotal(Double.parseDouble(txtValorFinanca.getText()));
			financa.setTipo(getTipoFinanca());
			financa.setAno(Integer.parseInt((String) cbAno.getSelectedItem()));

			if (cadastro_edicao == "Cadastrar") {
				try {
					service.inserirFundoParaDespesas(financa, dadosUsuario.getId());
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
					limparCampos();
				} catch (SQLException | IOException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}else {
				try {
					service.editarFundoDespesas(financa, getFinanca().getNome());
					
					JOptionPane.showMessageDialog(null, "Edição com sucesso!");
					this.dispose();
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		}
	}

	public void limparCampos() {
		txtNomeFinanca.setText("");
		txtValorFinanca.setText("");
		rdbtnMensal.setSelected(true);
		txtNomeFinanca.requestFocus();
		cbMes.setEnabled(false);
	}

	public void preencherCampos(Financa financa, String tipo) {
		if((tipo.equals("Despesa")) || (tipo.equals("Rendimento"))) {
			txtNomeFinanca.setText(financa.getNome());
			for(int i = 0; i < cbCategoria.getItemCount();i++) {
				if(cbCategoria.getItemAt(i).equals(financa.getCategoria().getNome())) {
					cbCategoria.setSelectedIndex(i);
				}
			}
			if (financa.isMensal_Ocasional()) {
				rdbtnMensal.setSelected(true);
				txtValorFinanca.setText(String.valueOf(financa.getTotal() / 12));
				cbMes.setEnabled(false);
			} else {
				txtValorFinanca.setText(String.valueOf(financa.getTotal()));
				rdbtnOcasional.setSelected(true);
				cbMes.setEnabled(true);
				cbMes.setSelectedIndex(financa.getMes());
			}
		}else if(tipo.equals("Investimento a Longo Prazo")) {
			txtNomeFinanca.setText(financa.getNome());			
			
			if (financa.isMensal_Ocasional()) {
				rdbtnMensal.setSelected(true);
				txtValorFinanca.setText(String.valueOf(financa.getTotal() / 12));
				cbMes.setEnabled(false);
			} else {
				txtValorFinanca.setText(String.valueOf(financa.getTotal()));
				rdbtnOcasional.setSelected(true);
				cbMes.setEnabled(true);
				cbMes.setSelectedIndex(financa.getMes());
			}
		}else {
			txtNomeFinanca.setText(financa.getNome());
			txtValorFinanca.setText(String.valueOf(financa.getTotal() / 12));
		}
		for(int i = 0; i < cbAno.getItemCount();i++) {
			if(cbAno.getItemAt(i).equals(financa.getAno())) {
				cbAno.setSelectedIndex(i);
			}
		}
	}

	public String getTipoFinanca() {
		return tipoFinanca;
	}

	public void setTipoFinanca(String tipoFinanca) {
		this.tipoFinanca = tipoFinanca;
	}
}
