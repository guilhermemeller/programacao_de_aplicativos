package gui;

import javax.swing.*;
import service.FinancaService;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.swing.border.TitledBorder;

import entities.Categoria;
import entities.Financa;
import service.CategoriaService;

import javax.swing.border.EtchedBorder;

import utils.DadosUsuario;
import utils.Mes;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class MenuPrincipalFrame extends JFrame {
	private JPanel mainPanel;
	private JTable tableDespesas;
	private JTable tableRendimento;
	private JTable tableInvestimento;
	private JTable tableFundoDespesas;
	private JTable tableResumoMensal;
	private JTable tableRelatorioMensal;
	private JTable tableResumoAnual;
	private JTable tableRelatorioAnual;
	private JMenuBar menuBar;
	private JTabbedPane tpSideMenu;
	private JPanel rendimentoPanel;
	private JPanel topPanelRendimento;
	private JComboBox cbRendimentoMensal;
	private JButton btnPesquisarRendimento;
	private JPanel centerPanelRendimento;
	private JPanel botPanelRendimento;
	private JButton btnCadastrarRendimento;
	private JButton btnEditarRendimento;
	private JButton btnExcluirRendimento;
	private JPanel despesasPanel;
	private JPanel topPanelDespesas;
	private JComboBox cbDespesasMensal;
	private JButton btnPesquisarDespesas;
	private JPanel centerPanelDespesas;
	private JPanel botPanelDespesas;
	private JButton btnEditarDespesas;
	private JButton btnCadastrarDespesas;
	private JButton btnExcluirDespesas;
	private JPanel topPanelInvestimento;
	private JPanel investimentoPanel;
	private JComboBox cbInvestimentoMensal;
	private JButton btnPesquisarInvestimento;
	private JPanel centerPanelInvestimento;
	private JPanel botPanelInvestimento;
	private JButton btnCadastrarInvestimento;
	private JButton btnEditarInvestimento;
	private JButton btnExcluirInvestimento;
	private JPanel despesasocasionaisPanel;
	private JPanel topPanelFundoDespesas;
	private JComboBox cbFundoDespesasMensal;
	private JButton btnPesquisarFundoDespesas;
	private JPanel centerPanelFundoDespesas;
	private JPanel botPanelFundoDespesas;
	private JButton btnCadastrarFundoDespesas;
	private JButton btnEditarFundoDespesas;
	private JButton btnExcluirFundoDespesas;
	private JPanel resumoPanel;
	private JTabbedPane tpResumo;
	private JPanel resumomensalPanel;
	private JPanel topPanelResumomensal;
	private JComboBox cbResumoMensal;
	private JButton btnPesquisarResumoMensal;
	private JPanel centerPanelResumomensal;
	private JPanel resumoanualPanel;
	private JPanel topPanelResumoanual;
	private JComboBox cbResumoAnual;
	private JButton btnPesquisarResumoAnual;
	private JPanel centerPanelResumoanual;
	private JPanel relatorioPanel;
	private JTabbedPane tpRelatorio;
	private JPanel relatoriomensalPanel;
	private JPanel topPanelRelatoriomensal;
	private JComboBox cbRelatorioMensal;
	private JComboBox cbCategoriaMensal;
	private JButton btnPesquisarRelatorioMensal;
	private JPanel centerPanelRelatoriomensal;
	private JPanel botPanelRelatorioMensal;
	private JButton btnGerarRelatorioMensal;
	private JPanel relatorioanualPanel;
	private JPanel topPanelRelatorioanual;
	private JComboBox cbRelatorioAnual;
	private JComboBox cbCategoriaAnual;
	private JButton btnPesquisarRelatorioAnual;
	private JPanel centerPanelRelatorioanual;
	private JPanel botPanelRelatorioAnual;
	private JButton btnGerarRelatorioAnual;
	private JMenu optionsMenu;
	public CadastrarFinancaFrame cadastrarFinanca;
	private JScrollPane scrollPaneRendimento;
	private JScrollPane scrollPaneInvestimento;
	public DadosUsuario dadosUsuario;
	private JScrollPane scrollPaneDespesas;
	private JScrollPane scrollPaneFundoDespesas;
	private JScrollPane scrollPaneResumoMensal;
	private JScrollPane scrollPaneResumoAnual;
	public DefaultTableCellRenderer estiloCelula;
	private JComboBox cbRendimentoAnual;
	private JComboBox cbDespesasAnual;
	private JComboBox cbFundoDespesasAnual;
	private JComboBox cbInvestimentoAnual;
	private JComboBox cbResumoMensalAno;

	public MenuPrincipalFrame() {
		dadosUsuario = DadosUsuario.getInstance();
		estiloCelula();
		initComponents();
		atualizarAnos();
		buscarRendimentoDespesa(1);
	}

	public void estiloCelula() {
		estiloCelula = new DefaultTableCellRenderer();
		estiloCelula.setHorizontalAlignment(SwingConstants.CENTER);

	}

	public void initComponents() {
		setResizable(false);
		// Configurações da janela principal
		setTitle("Sistema de Gestão de Finanças");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);

		// Painel principal
		mainPanel = new JPanel();

		// Barra superior com menu de opções
		menuBar = new JMenuBar();
		optionsMenu = new JMenu("Opções");
		JMenuItem exitMenuItem = new JMenuItem("Sair");
		exitMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Fechar a janela
				dispose();

				// Abrir a tela de Login
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						new LoginCadastroFrame();
					}
				});
			}
		});

		optionsMenu.add(exitMenuItem);
		menuBar.add(optionsMenu);

		setJMenuBar(menuBar);

		// Adicionar o painel principal à janela
		getContentPane().add(mainPanel);
		mainPanel.setLayout(null);

		tpSideMenu = new JTabbedPane(JTabbedPane.TOP);

		tpSideMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
		tpSideMenu.setBounds(10, 11, 764, 517);
		mainPanel.add(tpSideMenu);

		rendimentoPanel = new JPanel();
		rendimentoPanel.setBorder(new TitledBorder(null, "Gerenciamento de Rendimentos", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		tpSideMenu.addTab("Rendimento", null, rendimentoPanel, null);
		rendimentoPanel.setLayout(new BorderLayout(0, 0));

		topPanelRendimento = new JPanel();
		rendimentoPanel.add(topPanelRendimento, BorderLayout.NORTH);
		topPanelRendimento.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 25));

		cbRendimentoMensal = new JComboBox();
		cbRendimentoMensal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbRendimentoMensal.setModel(new DefaultComboBoxModel(Mes.values()));
		topPanelRendimento.add(cbRendimentoMensal);

		btnPesquisarRendimento = new JButton("");
		btnPesquisarRendimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarRendimentoDespesa(1);
			}
		});

		cbRendimentoAnual = new JComboBox();
		cbRendimentoAnual.setFont(new Font("Tahoma", Font.PLAIN, 15));
		topPanelRendimento.add(cbRendimentoAnual);
		btnPesquisarRendimento.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/pesquisar20.png")));
		topPanelRendimento.add(btnPesquisarRendimento);

		centerPanelRendimento = new JPanel();
		centerPanelRendimento.setLayout(null);
		rendimentoPanel.add(centerPanelRendimento, BorderLayout.CENTER);

		tableRendimento = new JTable();
		tableRendimento.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		tableRendimento.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Categoria", "Rendimento", "Mensal", "Ocasional", "Total Ano" }));
		tableRendimento.setBounds(10, 11, 727, 302);

		scrollPaneRendimento = new JScrollPane();
		scrollPaneRendimento.setBounds(10, 11, 727, 302);
		centerPanelRendimento.add(scrollPaneRendimento);

		scrollPaneRendimento.setViewportView(tableRendimento);

		botPanelRendimento = new JPanel();
		rendimentoPanel.add(botPanelRendimento, BorderLayout.SOUTH);
		botPanelRendimento.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 5));

		btnCadastrarRendimento = new JButton("Cadastrar");
		btnCadastrarRendimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCadastrarRendimentoActionPerformed();
			}
		});
		btnCadastrarRendimento.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/cadastrar40.png")));
		btnCadastrarRendimento.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrarRendimento.setBackground(new Color(221, 249, 226));
		botPanelRendimento.add(btnCadastrarRendimento);

		btnEditarRendimento = new JButton("Editar");
		btnEditarRendimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditarRendimentoActionPerformed();
			}
		});
		btnEditarRendimento.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/editar40.png")));
		btnEditarRendimento.setBackground(new Color(191, 214, 255));
		btnEditarRendimento.setFont(new Font("Tahoma", Font.BOLD, 16));
		botPanelRendimento.add(btnEditarRendimento);

		btnExcluirRendimento = new JButton("Excluir");
		btnExcluirRendimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExcluirRendimentoActionPerformed();
			}
		});
		btnExcluirRendimento.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/excluir40.png")));
		btnExcluirRendimento.setBackground(new Color(255, 176, 176));
		btnExcluirRendimento.setFont(new Font("Tahoma", Font.BOLD, 16));
		botPanelRendimento.add(btnExcluirRendimento);

		despesasPanel = new JPanel();
		despesasPanel.setBorder(new TitledBorder(null, "Gerenciamento de Despesas", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		tpSideMenu.addTab("Despesas", null, despesasPanel, null);
		despesasPanel.setLayout(new BorderLayout(0, 0));

		topPanelDespesas = new JPanel();
		despesasPanel.add(topPanelDespesas, BorderLayout.NORTH);
		topPanelDespesas.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 25));

		cbDespesasMensal = new JComboBox();
		cbDespesasMensal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbDespesasMensal.setModel(new DefaultComboBoxModel(Mes.values()));
		topPanelDespesas.add(cbDespesasMensal);

		btnPesquisarDespesas = new JButton("");
		btnPesquisarDespesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarRendimentoDespesa(2);
			}
		});

		cbDespesasAnual = new JComboBox();
		cbDespesasAnual.setFont(new Font("Tahoma", Font.PLAIN, 15));
		topPanelDespesas.add(cbDespesasAnual);
		btnPesquisarDespesas.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/pesquisar20.png")));
		topPanelDespesas.add(btnPesquisarDespesas);

		centerPanelDespesas = new JPanel();
		despesasPanel.add(centerPanelDespesas, BorderLayout.CENTER);
		centerPanelDespesas.setLayout(null);

		tableDespesas = new JTable();
		tableDespesas.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		tableDespesas.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Categoria", "Despesa", "Mensal", "Ocasional", "Total Ano" }));

		tableDespesas.setBounds(10, 11, 727, 302);

		scrollPaneDespesas = new JScrollPane();
		scrollPaneDespesas.setBounds(10, 11, 727, 302);
		centerPanelDespesas.add(scrollPaneDespesas);

		scrollPaneDespesas.setViewportView(tableDespesas);

		botPanelDespesas = new JPanel();
		despesasPanel.add(botPanelDespesas, BorderLayout.SOUTH);
		botPanelDespesas.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 5));

		btnCadastrarDespesas = new JButton("Cadastrar");
		btnCadastrarDespesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCadastrarDespesasActionPerformed();
			}
		});
		btnCadastrarDespesas.setBackground(new Color(221, 249, 226));
		btnCadastrarDespesas.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/cadastrar40.png")));
		btnCadastrarDespesas.setFont(new Font("Tahoma", Font.BOLD, 16));
		botPanelDespesas.add(btnCadastrarDespesas);

		btnEditarDespesas = new JButton("Editar");
		btnEditarDespesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditarDespesasActionPerformed();
			}
		});
		btnEditarDespesas.setBackground(new Color(191, 214, 255));
		btnEditarDespesas.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/editar40.png")));
		btnEditarDespesas.setFont(new Font("Tahoma", Font.BOLD, 16));
		botPanelDespesas.add(btnEditarDespesas);

		btnExcluirDespesas = new JButton("Excluir");
		btnExcluirDespesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExcluirDespesasActionPerformed();
			}
		});
		btnExcluirDespesas.setBackground(new Color(255, 176, 176));
		btnExcluirDespesas.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/excluir40.png")));
		btnExcluirDespesas.setFont(new Font("Tahoma", Font.BOLD, 16));
		botPanelDespesas.add(btnExcluirDespesas);

		investimentoPanel = new JPanel();
		investimentoPanel.setBorder(new TitledBorder(null, "Investimento a Longo Prazo", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		tpSideMenu.addTab("Investimento", null, investimentoPanel, null);
		investimentoPanel.setLayout(new BorderLayout(0, 0));

		topPanelInvestimento = new JPanel();
		investimentoPanel.add(topPanelInvestimento, BorderLayout.NORTH);
		topPanelInvestimento.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 25));

		cbInvestimentoMensal = new JComboBox();
		cbInvestimentoMensal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbInvestimentoMensal.setModel(new DefaultComboBoxModel(Mes.values()));
		topPanelInvestimento.add(cbInvestimentoMensal);

		btnPesquisarInvestimento = new JButton("");
		btnPesquisarInvestimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarInvestimento();
			}
		});

		cbInvestimentoAnual = new JComboBox();
		cbInvestimentoAnual.setFont(new Font("Tahoma", Font.PLAIN, 15));
		topPanelInvestimento.add(cbInvestimentoAnual);
		btnPesquisarInvestimento
				.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/pesquisar20.png")));
		topPanelInvestimento.add(btnPesquisarInvestimento);

		centerPanelInvestimento = new JPanel();
		centerPanelInvestimento.setLayout(null);
		investimentoPanel.add(centerPanelInvestimento, BorderLayout.CENTER);

		tableInvestimento = new JTable();
		tableInvestimento.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		tableInvestimento.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Investimento", "Mensal", "Ocasional", "Total Ano" }));
		tableInvestimento.setBounds(10, 11, 727, 302);

		scrollPaneInvestimento = new JScrollPane();
		scrollPaneInvestimento.setBounds(10, 11, 727, 302);
		centerPanelInvestimento.add(scrollPaneInvestimento);

		scrollPaneInvestimento.setViewportView(tableInvestimento);

		botPanelInvestimento = new JPanel();
		investimentoPanel.add(botPanelInvestimento, BorderLayout.SOUTH);
		botPanelInvestimento.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 5));

		btnCadastrarInvestimento = new JButton("Cadastrar");
		btnCadastrarInvestimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCadastrarInvestimentoActionPerformed();
			}
		});
		btnCadastrarInvestimento.setBackground(new Color(221, 249, 226));
		btnCadastrarInvestimento
				.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/cadastrar40.png")));
		btnCadastrarInvestimento.setFont(new Font("Tahoma", Font.BOLD, 16));
		botPanelInvestimento.add(btnCadastrarInvestimento);

		btnEditarInvestimento = new JButton("Editar");
		btnEditarInvestimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditarInvestimentoActionPerformed();
			}
		});
		btnEditarInvestimento.setBackground(new Color(191, 214, 255));
		btnEditarInvestimento.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/editar40.png")));
		btnEditarInvestimento.setFont(new Font("Tahoma", Font.BOLD, 16));
		botPanelInvestimento.add(btnEditarInvestimento);

		btnExcluirInvestimento = new JButton("Excluir");
		btnExcluirInvestimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExcluirInvestimentoActionPerformed();
			}
		});
		btnExcluirInvestimento.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/excluir40.png")));
		btnExcluirInvestimento.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExcluirInvestimento.setBackground(new Color(255, 176, 176));
		botPanelInvestimento.add(btnExcluirInvestimento);

		despesasocasionaisPanel = new JPanel();
		despesasocasionaisPanel.setBorder(new TitledBorder(null, "Fundo para Despesas Ocasionais", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		tpSideMenu.addTab("Fundo de Despesas", null, despesasocasionaisPanel, null);
		despesasocasionaisPanel.setLayout(new BorderLayout(0, 0));

		topPanelFundoDespesas = new JPanel();
		despesasocasionaisPanel.add(topPanelFundoDespesas, BorderLayout.NORTH);
		topPanelFundoDespesas.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 25));

		cbFundoDespesasMensal = new JComboBox();
		cbFundoDespesasMensal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbFundoDespesasMensal.setModel(new DefaultComboBoxModel(Mes.values()));
		topPanelFundoDespesas.add(cbFundoDespesasMensal);

		cbFundoDespesasAnual = new JComboBox();
		cbFundoDespesasAnual.setFont(new Font("Tahoma", Font.PLAIN, 15));
		topPanelFundoDespesas.add(cbFundoDespesasAnual);

		btnPesquisarFundoDespesas = new JButton("");
		btnPesquisarFundoDespesas
				.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/pesquisar20.png")));
		topPanelFundoDespesas.add(btnPesquisarFundoDespesas);

		btnPesquisarFundoDespesas.setVisible(true);
		cbFundoDespesasMensal.setVisible(true);

		centerPanelFundoDespesas = new JPanel();
		centerPanelFundoDespesas.setLayout(null);
		despesasocasionaisPanel.add(centerPanelFundoDespesas, BorderLayout.CENTER);

		tableFundoDespesas = new JTable();
		tableFundoDespesas.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		tableFundoDespesas.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Fundo Ocasional", "Mensal", "Total Anual" }));
		tableFundoDespesas.setBounds(10, 11, 727, 302);

		scrollPaneFundoDespesas = new JScrollPane();
		scrollPaneFundoDespesas.setBounds(10, 11, 727, 302);
		centerPanelFundoDespesas.add(scrollPaneFundoDespesas);

		scrollPaneFundoDespesas.setViewportView(tableFundoDespesas);

		botPanelFundoDespesas = new JPanel();
		despesasocasionaisPanel.add(botPanelFundoDespesas, BorderLayout.SOUTH);
		botPanelFundoDespesas.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 5));

		btnCadastrarFundoDespesas = new JButton("Cadastrar");
		btnCadastrarFundoDespesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCadastrarFundoDespesasActionPerformed();
			}
		});
		btnCadastrarFundoDespesas
				.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/cadastrar40.png")));
		btnCadastrarFundoDespesas.setBackground(new Color(221, 249, 226));
		btnCadastrarFundoDespesas.setFont(new Font("Tahoma", Font.BOLD, 16));
		botPanelFundoDespesas.add(btnCadastrarFundoDespesas);

		btnEditarFundoDespesas = new JButton("Editar");
		btnEditarFundoDespesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditarFundoDespesasActionPerformed();
			}
		});
		btnEditarFundoDespesas.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/editar40.png")));
		btnEditarFundoDespesas.setBackground(new Color(191, 214, 255));
		btnEditarFundoDespesas.setFont(new Font("Tahoma", Font.BOLD, 16));
		botPanelFundoDespesas.add(btnEditarFundoDespesas);

		btnExcluirFundoDespesas = new JButton("Excluir");
		btnExcluirFundoDespesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExcluirFundoDespesasActionPerformed();
			}
		});
		btnExcluirFundoDespesas.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/excluir40.png")));
		btnExcluirFundoDespesas.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExcluirFundoDespesas.setBackground(new Color(255, 176, 176));
		botPanelFundoDespesas.add(btnExcluirFundoDespesas);

		resumoPanel = new JPanel();
		resumoPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Resumo de contas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tpSideMenu.addTab("Resumo", null, resumoPanel, null);
		resumoPanel.setLayout(null);

		tpResumo = new JTabbedPane(JTabbedPane.LEFT);
		tpResumo.setFont(new Font("Tahoma", Font.BOLD, 15));
		tpResumo.setBounds(10, 21, 739, 452);
		resumoPanel.add(tpResumo);

		resumomensalPanel = new JPanel();
		resumomensalPanel
				.setBorder(new TitledBorder(null, "Resumo Mensal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tpResumo.addTab("Resumo Mensal", null, resumomensalPanel, null);
		resumomensalPanel.setLayout(new BorderLayout(0, 0));

		topPanelResumomensal = new JPanel();
		resumomensalPanel.add(topPanelResumomensal, BorderLayout.NORTH);
		topPanelResumomensal.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 25));

		cbResumoMensal = new JComboBox();
		cbResumoMensal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbResumoMensal.setModel(new DefaultComboBoxModel(Mes.values()));
		topPanelResumomensal.add(cbResumoMensal);

		btnPesquisarResumoMensal = new JButton("");
		btnPesquisarResumoMensal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPesquisarResumoMensalActionPerformed();
			}
		});

		cbResumoMensalAno = new JComboBox();
		cbResumoMensalAno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		topPanelResumomensal.add(cbResumoMensalAno);
		btnPesquisarResumoMensal
				.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/pesquisar20.png")));
		topPanelResumomensal.add(btnPesquisarResumoMensal);

		centerPanelResumomensal = new JPanel();
		centerPanelResumomensal.setLayout(null);

		resumomensalPanel.add(centerPanelResumomensal, BorderLayout.CENTER);

		scrollPaneResumoMensal = new JScrollPane();
		scrollPaneResumoMensal.setBounds(0, 0, 590, 346);

		centerPanelResumomensal.add(scrollPaneResumoMensal);

		tableResumoMensal = new JTable();
		tableResumoMensal.setRowSelectionAllowed(false);
		tableResumoMensal.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		scrollPaneResumoMensal.setViewportView(tableResumoMensal);
		tableResumoMensal
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Descrição", "Total Mensal" }));

		resumoanualPanel = new JPanel();
		resumoanualPanel
				.setBorder(new TitledBorder(null, "Resumo Anual", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tpResumo.addTab("Resumo Anual", null, resumoanualPanel, null);
		resumoanualPanel.setLayout(new BorderLayout(0, 0));

		topPanelResumoanual = new JPanel();
		resumoanualPanel.add(topPanelResumoanual, BorderLayout.NORTH);
		topPanelResumoanual.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 25));

		cbResumoAnual = new JComboBox();
		cbResumoAnual.setFont(new Font("Tahoma", Font.PLAIN, 15));
		topPanelResumoanual.add(cbResumoAnual);

		btnPesquisarResumoAnual = new JButton("");
		btnPesquisarResumoAnual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPesquisarResumoAnualActionPerformed();
			}
		});
		btnPesquisarResumoAnual.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/pesquisar20.png")));
		topPanelResumoanual.add(btnPesquisarResumoAnual);

		relatorioPanel = new JPanel();
		relatorioPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Gera\u00E7\u00E3o de Relat\u00F3rios", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		tpSideMenu.addTab("Relatório", null, relatorioPanel, null);
		relatorioPanel.setLayout(null);

		tpRelatorio = new JTabbedPane(JTabbedPane.LEFT);
		tpRelatorio.setFont(new Font("Tahoma", Font.BOLD, 15));
		tpRelatorio.setBounds(10, 21, 739, 452);
		relatorioPanel.add(tpRelatorio);

		relatoriomensalPanel = new JPanel();
		relatoriomensalPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Relat\u00F3rio Mensal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tpRelatorio.addTab("Relatório Mensal", null, relatoriomensalPanel, null);
		relatoriomensalPanel.setLayout(new BorderLayout(0, 0));

		topPanelRelatoriomensal = new JPanel();
		relatoriomensalPanel.add(topPanelRelatoriomensal, BorderLayout.NORTH);
		topPanelRelatoriomensal.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 25));

		cbRelatorioMensal = new JComboBox();
		cbRelatorioMensal.setModel(new DefaultComboBoxModel(Mes.values()));
		cbRelatorioMensal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		topPanelRelatoriomensal.add(cbRelatorioMensal);

		JComboBox cbRelatorioMensalAno = new JComboBox();
		cbRelatorioMensalAno.setModel(new DefaultComboBoxModel(new String[] { "2023" }));
		cbRelatorioMensalAno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		topPanelRelatoriomensal.add(cbRelatorioMensalAno);

		JCheckBox chckbxRelatorioMensalCategoria = new JCheckBox("Filtrar por Categoria");
		chckbxRelatorioMensalCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxRelatorioMensalCategoria.isSelected()) {
					cbCategoriaMensal.setEnabled(true);
				} else {
					cbCategoriaMensal.setEnabled(false);
				}
			}
		});
		topPanelRelatoriomensal.add(chckbxRelatorioMensalCategoria);

		cbCategoriaMensal = new JComboBox();
		cbCategoriaMensal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		topPanelRelatoriomensal.add(cbCategoriaMensal);
		cbCategoriaMensal.setEnabled(false);

		btnPesquisarRelatorioMensal = new JButton("");
		btnPesquisarRelatorioMensal
				.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/pesquisar20.png")));
		topPanelRelatoriomensal.add(btnPesquisarRelatorioMensal);

		centerPanelRelatoriomensal = new JPanel();
		centerPanelRelatoriomensal.setLayout(null);
		relatoriomensalPanel.add(centerPanelRelatoriomensal, BorderLayout.CENTER);

		tableRelatorioMensal = new JTable();
		tableRelatorioMensal.setBounds(10, 11, 559, 265);
		centerPanelRelatoriomensal.add(tableRelatorioMensal);

		botPanelRelatorioMensal = new JPanel();
		relatoriomensalPanel.add(botPanelRelatorioMensal, BorderLayout.SOUTH);
		botPanelRelatorioMensal.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));

		btnGerarRelatorioMensal = new JButton("Gerar Relatório");
		btnGerarRelatorioMensal.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/relatorio40.png")));
		btnGerarRelatorioMensal.setBackground(new Color(221, 249, 226));
		btnGerarRelatorioMensal.setFont(new Font("Tahoma", Font.BOLD, 16));
		botPanelRelatorioMensal.add(btnGerarRelatorioMensal);

		relatorioanualPanel = new JPanel();
		relatorioanualPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Relat\u00F3rio Anual", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tpRelatorio.addTab("Relatório Anual", null, relatorioanualPanel, null);
		relatorioanualPanel.setLayout(new BorderLayout(0, 0));

		topPanelRelatorioanual = new JPanel();
		relatorioanualPanel.add(topPanelRelatorioanual, BorderLayout.NORTH);
		topPanelRelatorioanual.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 25));

		cbRelatorioAnual = new JComboBox();
		cbRelatorioAnual.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbRelatorioAnual.setModel(new DefaultComboBoxModel(new String[] { "2023" }));
		topPanelRelatorioanual.add(cbRelatorioAnual);

		cbCategoriaAnual = new JComboBox();
		cbCategoriaAnual.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbCategoriaAnual.setEnabled(false);

		atualizarCategorias();

		atualizarAnos();

		JCheckBox chckbxRelatorioAnualCategoria = new JCheckBox("Filtrar por Categoria");
		chckbxRelatorioAnualCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxRelatorioAnualCategoria.isSelected()) {
					cbCategoriaAnual.setEnabled(true);
				} else {
					cbCategoriaAnual.setEnabled(false);
				}
			}
		});
		topPanelRelatorioanual.add(chckbxRelatorioAnualCategoria);
		topPanelRelatorioanual.add(cbCategoriaAnual);

		btnPesquisarRelatorioAnual = new JButton("");
		btnPesquisarRelatorioAnual
				.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/pesquisar20.png")));
		topPanelRelatorioanual.add(btnPesquisarRelatorioAnual);

		centerPanelRelatorioanual = new JPanel();
		centerPanelRelatorioanual.setLayout(null);
		relatorioanualPanel.add(centerPanelRelatorioanual, BorderLayout.CENTER);

		tableRelatorioAnual = new JTable();
		tableRelatorioAnual.setBounds(10, 11, 559, 265);
		centerPanelRelatorioanual.add(tableRelatorioAnual);

		botPanelRelatorioAnual = new JPanel();
		relatorioanualPanel.add(botPanelRelatorioAnual, BorderLayout.SOUTH);
		botPanelRelatorioAnual.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));

		btnGerarRelatorioAnual = new JButton("Gerar Relatório");
		btnGerarRelatorioAnual.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/relatorio40.png")));
		btnGerarRelatorioAnual.setBackground(new Color(221, 249, 226));
		btnGerarRelatorioAnual.setFont(new Font("Tahoma", Font.BOLD, 16));
		botPanelRelatorioAnual.add(btnGerarRelatorioAnual);

		centerPanelResumoanual = new JPanel();
		centerPanelResumoanual.setLayout(null);
		resumoanualPanel.add(centerPanelResumoanual, BorderLayout.CENTER);
		
		scrollPaneResumoAnual = new JScrollPane();
		scrollPaneResumoAnual.setBounds(0, 0, 590, 346);

		centerPanelResumoanual.add(scrollPaneResumoAnual);
		
		tableResumoAnual = new JTable();
		tableResumoAnual.setRowSelectionAllowed(false);
		tableResumoAnual.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		scrollPaneResumoAnual.setViewportView(tableResumoAnual);
		tableResumoAnual
		.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Descrição", "Mensal (x12)", "Ocasional", "Total Anual" }));

		tpSideMenu.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (tpSideMenu.getSelectedIndex() == 0) {
					atualizarAnos();
					buscarRendimentoDespesa(1);
				}
				if (tpSideMenu.getSelectedIndex() == 1) {
					atualizarAnos();
					buscarRendimentoDespesa(2);
				}
				if (tpSideMenu.getSelectedIndex() == 2) {
					atualizarAnos();
					buscarInvestimento();
				}
				if (tpSideMenu.getSelectedIndex() == 3) {
					atualizarAnos();
					buscarFundoDespesas();
				}
				if (tpSideMenu.getSelectedIndex() == 4) {
					if(tpResumo.getSelectedIndex() == 0) {
						atualizarAnos();
						btnPesquisarResumoMensalActionPerformed();
					}
					if(tpResumo.getSelectedIndex() == 1){
						atualizarAnos();
						btnPesquisarResumoAnualActionPerformed();
					}
				}
				if (tpSideMenu.getSelectedIndex() == 5) {
					if(tpRelatorio.getSelectedIndex() == 0) {
						
					}else {
						
					}
				}
			}
		});
		
		tpResumo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(tpResumo.getSelectedIndex() == 0) {
					atualizarAnos();
					btnPesquisarResumoMensalActionPerformed();
				}
				if(tpResumo.getSelectedIndex() == 1){
					atualizarAnos();
					btnPesquisarResumoAnualActionPerformed();
				}
			}
		});

		for (int i = 2; i <= 4; i++) {
			tableRendimento.getColumnModel().getColumn(i).setCellRenderer(estiloCelula);
			tableDespesas.getColumnModel().getColumn(i).setCellRenderer(estiloCelula);
		}
		for (int i = 1; i <= 3; i++) {
			tableInvestimento.getColumnModel().getColumn(i).setCellRenderer(estiloCelula);
		}
		for (int i = 1; i <= 2; i++) {
			tableFundoDespesas.getColumnModel().getColumn(i).setCellRenderer(estiloCelula);
		}

		// Exibir a janela
		setVisible(true);
	}

	public void btnCadastrarRendimentoActionPerformed() {
		cadastrarFinanca = new CadastrarFinancaFrame("Rendimento", "Cadastrar");
		cadastrarFinanca.setLocationRelativeTo(null);
		cadastrarFinanca.setVisible(true);

		cadastrarFinanca.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				atualizarAnos();
				buscarRendimentoDespesa(1);
			}
		});
	}

	public void btnCadastrarDespesasActionPerformed() {
		cadastrarFinanca = new CadastrarFinancaFrame("Despesa", "Cadastrar");
		cadastrarFinanca.setLocationRelativeTo(null);
		cadastrarFinanca.setVisible(true);

		cadastrarFinanca.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				atualizarAnos();
				buscarRendimentoDespesa(2);
			}
		});
	}

	public void btnCadastrarInvestimentoActionPerformed() {
		cadastrarFinanca = new CadastrarFinancaFrame("Investimento a Longo Prazo", "Cadastrar");
		cadastrarFinanca.setLocationRelativeTo(null);
		cadastrarFinanca.setVisible(true);

		cadastrarFinanca.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				atualizarAnos();
				buscarInvestimento();
			}
		});
	}

	public void btnCadastrarFundoDespesasActionPerformed() {
		cadastrarFinanca = new CadastrarFinancaFrame("Fundo para Despesas Ocasionais", "Cadastrar");
		cadastrarFinanca.setLocationRelativeTo(null);
		cadastrarFinanca.setVisible(true);

		cadastrarFinanca.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				atualizarAnos();
				buscarFundoDespesas();
			}
		});
	}

	public void atualizarCategorias() {
		CategoriaService cService = new CategoriaService();
		if (cbCategoriaMensal != null) {
			cbCategoriaMensal.removeAllItems();
		}
		if (cbCategoriaAnual != null) {
			cbCategoriaAnual.removeAllItems();
		}
		List<Categoria> categorias;
		try {
			categorias = cService.buscarCategorias();
			for (Categoria categoria : categorias) {
				cbCategoriaMensal.addItem(categoria.getNome());
				cbCategoriaAnual.addItem(categoria.getNome());
			}
			cbCategoriaMensal.revalidate();
			cbCategoriaMensal.repaint();
			cbCategoriaAnual.revalidate();
			cbCategoriaAnual.repaint();
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void buscarRendimentoDespesa(int type) {
		tableRendimento.setRowHeight(20);
		tableDespesas.setRowHeight(20);

		DefaultTableModel modeloR = (DefaultTableModel) tableRendimento.getModel();
		modeloR.fireTableDataChanged();
		modeloR.setRowCount(0);

		DefaultTableModel modeloD = (DefaultTableModel) tableDespesas.getModel();
		modeloD.fireTableDataChanged();
		modeloD.setRowCount(0);
		List<Financa> financas;
		FinancaService service = new FinancaService();
		if (type == 1) {
			if (cbRendimentoAnual.getSelectedItem() == null) {
				cbRendimentoAnual.addItem(Calendar.getInstance().get(Calendar.YEAR));
			}
				try {
					financas = service.buscarRendimentoDespesaPorUsuario(dadosUsuario.getId(),
							(cbRendimentoMensal.getSelectedIndex() + 1), ((int) cbRendimentoAnual.getSelectedItem()),
							"Rendimento");
					String nomeCategoria = "";
					try {
						CategoriaService catS = new CategoriaService();
						for (int i = 0; i < financas.size(); i++) {
							nomeCategoria = catS.buscarNomeCategoria(financas.get(i).getCategoria().getId_Categoria());
							financas.get(i).getCategoria().setNome(nomeCategoria);
						}

					} catch (SQLException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for (Financa financa : financas) {
						if (financa.isMensal_Ocasional()) {
							modeloR.addRow(new Object[] { financa.getCategoria().getNome(), financa.getNome(),
									"R$ " + financa.getTotal(), "", "R$ " + (financa.getTotal() * 12) });
						} else {
							modeloR.addRow(new Object[] { financa.getCategoria().getNome(), financa.getNome(), "",
									"R$ " + financa.getTotal(), "R$ " + (financa.getTotal()) });
						}
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Erro ao carregar Rendimentos!\n" + e.getMessage(), "ERRO",
							JOptionPane.ERROR_MESSAGE);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Erro ao carregar Rendimentos!\n" + e.getMessage(), "ERRO",
							JOptionPane.ERROR_MESSAGE);
				}
			
		} else {
			if (cbDespesasAnual.getSelectedItem() == null) {
				cbDespesasAnual.addItem(Calendar.getInstance().get(Calendar.YEAR));
			}
				try {
					financas = service.buscarRendimentoDespesaPorUsuario(dadosUsuario.getId(),
							(cbDespesasMensal.getSelectedIndex() + 1), ((int) cbDespesasAnual.getSelectedItem()),
							"Despesa");
					String nomeCategoria = "";
					try {
						CategoriaService catS = new CategoriaService();
						for (int i = 0; i < financas.size(); i++) {
							nomeCategoria = catS.buscarNomeCategoria(financas.get(i).getCategoria().getId_Categoria());
							financas.get(i).getCategoria().setNome(nomeCategoria);
						}

					} catch (SQLException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for (Financa financa : financas) {
						if (financa.isMensal_Ocasional()) {
							modeloD.addRow(new Object[] { financa.getCategoria().getNome(), financa.getNome(),
									"R$ " + financa.getTotal(), "", "R$ " + (financa.getTotal() * 12) });
						} else {
							modeloD.addRow(new Object[] { financa.getCategoria().getNome(), financa.getNome(), "",
									"R$ " + financa.getTotal(), "R$ " + (financa.getTotal()) });
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Erro ao carregar Rendimentos!\n" + e.getMessage(), "ERRO",
							JOptionPane.ERROR_MESSAGE);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Erro ao carregar Rendimentos!\n" + e.getMessage(), "ERRO",
							JOptionPane.ERROR_MESSAGE);
				}
			
		}

	}

	private void buscarInvestimento() {
		tableInvestimento.setRowHeight(20);

		DefaultTableModel modelo = (DefaultTableModel) tableInvestimento.getModel();
		modelo.fireTableDataChanged();
		modelo.setRowCount(0);

		List<Financa> financas;
		FinancaService service = new FinancaService();
		if (cbInvestimentoAnual.getSelectedItem() == null) {
			cbInvestimentoAnual.addItem(Calendar.getInstance().get(Calendar.YEAR));
		}
			try {
				financas = service.buscarInvestimentoPorUsuario(dadosUsuario.getId(),
						(cbInvestimentoMensal.getSelectedIndex() + 1), ((int) cbInvestimentoAnual.getSelectedItem()));
				for (Financa financa : financas) {
					if (financa.isMensal_Ocasional()) {
						modelo.addRow(new Object[] { financa.getNome(), "R$ " + financa.getTotal(), "",
								"R$ " + (financa.getTotal() * 12) });
					} else {
						modelo.addRow(new Object[] { financa.getNome(), "", "R$ " + financa.getTotal(),
								"R$ " + (financa.getTotal()) });
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Erro ao carregar Investimentos!\n" + e.getMessage(), "ERRO",
						JOptionPane.ERROR_MESSAGE);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Erro ao carregar Investimentos!\n" + e.getMessage(), "ERRO",
						JOptionPane.ERROR_MESSAGE);
			}
		
	}

	private void buscarFundoDespesas() {
		tableFundoDespesas.setRowHeight(20);

		DefaultTableModel modelo = (DefaultTableModel) tableFundoDespesas.getModel();
		modelo.fireTableDataChanged();
		modelo.setRowCount(0);

		List<Financa> financas;
		FinancaService service = new FinancaService();
		if (cbFundoDespesasAnual.getSelectedItem() == null) {
				cbFundoDespesasAnual.addItem(Calendar.getInstance().get(Calendar.YEAR));
			
		}
			try {
				financas = service.buscarFundoDespesasPorUsuario(dadosUsuario.getId(),
						(cbFundoDespesasMensal.getSelectedIndex() + 1), ((int) cbFundoDespesasAnual.getSelectedItem()));
				for (Financa financa : financas) {
					modelo.addRow(new Object[] { financa.getNome(), "R$ " + financa.getTotal(),
							"R$ " + (financa.getTotal() * 12) });
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Erro ao carregar Fundo de Despesas Ocasionais!\n" + e.getMessage(),
						"ERRO", JOptionPane.ERROR_MESSAGE);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Erro ao carregar Fundo de Despesas Ocasionais!\n" + e.getMessage(),
						"ERRO", JOptionPane.ERROR_MESSAGE);
			}
		
	}

	public void btnEditarRendimentoActionPerformed() {
		int linhaTabela = tableRendimento.getSelectedRow();
		if (linhaTabela != -1) {
			CategoriaService catService = new CategoriaService();
			FinancaService finService = new FinancaService();

			Financa financa = new Financa();
			String nomeCategoria = (String) tableRendimento.getModel().getValueAt(linhaTabela, 0);

			try {
				Categoria categoria = new Categoria(nomeCategoria,
						catService.buscarIdCategoria((String) tableRendimento.getModel().getValueAt(linhaTabela, 0)));
				String nomeFinanca = (String) tableRendimento.getModel().getValueAt(linhaTabela, 1);
				int id = finService.buscarIdRendimentoDespesaPorNome(dadosUsuario.getId(), nomeFinanca,
						cbRendimentoMensal.getSelectedIndex() + 1, ((int) cbRendimentoAnual.getSelectedItem()));
				financa.setId(id);
				financa.setNome(nomeFinanca);
				financa.setCategoria(categoria);
				if ((tableRendimento.getModel().getValueAt(linhaTabela, 2)).equals("")) {
					financa.setMensal_Ocasional(false);
				} else {
					financa.setMensal_Ocasional(true);
				}
				String valorSelecionado = (String) tableRendimento.getModel().getValueAt(linhaTabela, 4);
				valorSelecionado = valorSelecionado.replace("R$", "").trim();
				Double valorDouble = Double.parseDouble(valorSelecionado);
				financa.setTotal(valorDouble);
				financa.setTipo("Rendimento");
				financa.setMes(cbRendimentoMensal.getSelectedIndex());
				financa.setAno(((int) cbRendimentoAnual.getSelectedItem()));
				CadastrarFinancaFrame editarFinancaFrame = new CadastrarFinancaFrame("Rendimento", "Editar", financa);
				editarFinancaFrame.setLocationRelativeTo(null);
				editarFinancaFrame.setVisible(true);

				editarFinancaFrame.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						buscarRendimentoDespesa(1);
					}
				});
			} catch (SQLException | IOException e) {
				JOptionPane.showMessageDialog(null, "Erro ao editar a finança!\n" + e.getMessage(), "ERRO",
						JOptionPane.ERROR_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(null, "Nenhuma linha da tabela selecionada", "Erro de Edição",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public void btnExcluirRendimentoActionPerformed() {
		int linhaTabela = tableRendimento.getSelectedRow();
		if (linhaTabela != -1) {

			FinancaService finService = new FinancaService();

			Financa financa = new Financa();
			int resposta = 1;
			try {
				String nomeFinanca = (String) tableRendimento.getModel().getValueAt(linhaTabela, 1);
				int id = finService.buscarIdRendimentoDespesaPorNome(dadosUsuario.getId(), nomeFinanca,
						cbRendimentoMensal.getSelectedIndex() + 1, ((int) cbRendimentoAnual.getSelectedItem()));
				financa.setId(id);
				financa.setNome(nomeFinanca);
				financa.setTipo("Rendimento");

				if ((tableRendimento.getModel().getValueAt(linhaTabela, 2)).equals("")) {
					financa.setMensal_Ocasional(false);
					resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir ?",
							"Confirmação de Exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					if (resposta == JOptionPane.YES_OPTION) {
						finService.excluirFinanca(financa, "rendimento_despesa");
					}
				} else {
					financa.setMensal_Ocasional(true);
					resposta = JOptionPane.showConfirmDialog(null,
							"Deseja realmente excluir essa Financa Mensal?\nCaso exclua, ela será apagada de todos os meses!",
							"Confirmação de Exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					if (resposta == JOptionPane.YES_OPTION) {
						finService.excluirFinanca(financa, "rendimento_despesa");
					}
				}

				buscarRendimentoDespesa(1);
			} catch (SQLException | IOException e) {
				JOptionPane.showMessageDialog(null, "Erro ao editar a finança!\n" + e.getMessage(), "ERRO",
						JOptionPane.ERROR_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(null, "Nenhuma linha da tabela selecionada", "Erro de Exclusão",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void btnEditarDespesasActionPerformed() {
		int linhaTabela = tableDespesas.getSelectedRow();
		if (linhaTabela != -1) {
			CategoriaService catService = new CategoriaService();
			FinancaService finService = new FinancaService();

			Financa financa = new Financa();
			String nomeCategoria = (String) tableDespesas.getModel().getValueAt(linhaTabela, 0);

			try {
				Categoria categoria = new Categoria(nomeCategoria,
						catService.buscarIdCategoria((String) tableDespesas.getModel().getValueAt(linhaTabela, 0)));
				String nomeFinanca = (String) tableDespesas.getModel().getValueAt(linhaTabela, 1);
				int id = finService.buscarIdRendimentoDespesaPorNome(dadosUsuario.getId(), nomeFinanca,
						cbDespesasMensal.getSelectedIndex() + 1, ((int) cbDespesasAnual.getSelectedItem()));
				financa.setId(id);
				financa.setNome(nomeFinanca);
				financa.setCategoria(categoria);
				if ((tableDespesas.getModel().getValueAt(linhaTabela, 2)).equals("")) {
					financa.setMensal_Ocasional(false);
				} else {
					financa.setMensal_Ocasional(true);
				}
				String valorSelecionado = (String) tableDespesas.getModel().getValueAt(linhaTabela, 4);
				valorSelecionado = valorSelecionado.replace("R$", "").trim();
				Double valorDouble = Double.parseDouble(valorSelecionado);
				financa.setTotal(valorDouble);
				financa.setTipo("Despesa");
				financa.setMes(cbDespesasMensal.getSelectedIndex());
				financa.setAno(((int) cbDespesasAnual.getSelectedItem()));
				CadastrarFinancaFrame editarFinancaFrame = new CadastrarFinancaFrame("Despesa", "Editar", financa);
				editarFinancaFrame.setLocationRelativeTo(null);
				editarFinancaFrame.setVisible(true);

				editarFinancaFrame.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						buscarRendimentoDespesa(2);
					}
				});
			} catch (SQLException | IOException e) {
				JOptionPane.showMessageDialog(null, "Erro ao editar a finança!\n" + e.getMessage(), "ERRO",
						JOptionPane.ERROR_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(null, "Nenhuma linha da tabela selecionada", "Erro de Edição",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void btnExcluirDespesasActionPerformed() {
		int linhaTabela = tableDespesas.getSelectedRow();
		if (linhaTabela != -1) {

			FinancaService finService = new FinancaService();

			Financa financa = new Financa();
			int resposta = 1;
			try {
				String nomeFinanca = (String) tableDespesas.getModel().getValueAt(linhaTabela, 1);
				int id = finService.buscarIdRendimentoDespesaPorNome(dadosUsuario.getId(), nomeFinanca,
						cbRendimentoMensal.getSelectedIndex() + 1, ((int) cbRendimentoAnual.getSelectedItem()));
				financa.setId(id);
				financa.setNome(nomeFinanca);
				financa.setTipo("Despesa");

				if ((tableDespesas.getModel().getValueAt(linhaTabela, 2)).equals("")) {
					financa.setMensal_Ocasional(false);
					resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?",
							"Confirmação de Exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					if (resposta == JOptionPane.YES_OPTION) {
						finService.excluirFinanca(financa, "rendimento_despesa");
					}
				} else {
					financa.setMensal_Ocasional(true);
					resposta = JOptionPane.showConfirmDialog(null,
							"Deseja realmente excluir essa Financa Mensal?\nCaso exclua, ela será apagada de todos os meses!",
							"Confirmação de Exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					if (resposta == JOptionPane.YES_OPTION) {
						finService.excluirFinanca(financa, "rendimento_despesa");
					}
				}

				buscarRendimentoDespesa(2);
			} catch (SQLException | IOException e) {
				JOptionPane.showMessageDialog(null, "Erro ao excluir a finança!\n" + e.getMessage(), "ERRO",
						JOptionPane.ERROR_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(null, "Nenhuma linha da tabela selecionada", "Erro de Exclusão",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void btnEditarInvestimentoActionPerformed() {
		int linhaTabela = tableInvestimento.getSelectedRow();
		if (linhaTabela != -1) {
			FinancaService finService = new FinancaService();

			Financa financa = new Financa();

			try {
				String nomeFinanca = (String) tableInvestimento.getModel().getValueAt(linhaTabela, 0);
				int id = finService.buscarIdInvestimentoPorNome(dadosUsuario.getId(), nomeFinanca,
						cbInvestimentoMensal.getSelectedIndex() + 1, ((int) cbInvestimentoAnual.getSelectedItem()));
				financa.setId(id);
				financa.setNome(nomeFinanca);
				if ((tableInvestimento.getModel().getValueAt(linhaTabela, 1)).equals("")) {
					financa.setMensal_Ocasional(false);
				} else {
					financa.setMensal_Ocasional(true);
				}

				String valorSelecionado = (String) tableInvestimento.getModel().getValueAt(linhaTabela, 3);
				valorSelecionado = valorSelecionado.replace("R$", "").trim();
				Double valorDouble = Double.parseDouble(valorSelecionado);
				financa.setTotal(valorDouble);
				financa.setTipo("Investimento a Longo Prazo");
				financa.setMes(cbInvestimentoMensal.getSelectedIndex());
				CadastrarFinancaFrame editarFinancaFrame = new CadastrarFinancaFrame("Investimento a Longo Prazo",
						"Editar", financa);
				editarFinancaFrame.setLocationRelativeTo(null);
				editarFinancaFrame.setVisible(true);

				editarFinancaFrame.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						buscarInvestimento();
					}
				});
			} catch (SQLException | IOException e) {
				JOptionPane.showMessageDialog(null, "Erro ao editar a finança!\n" + e.getMessage(), "ERRO",
						JOptionPane.ERROR_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(null, "Nenhuma linha da tabela selecionada", "Erro de Edição",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void btnExcluirInvestimentoActionPerformed() {
		int linhaTabela = tableInvestimento.getSelectedRow();
		if (linhaTabela != -1) {

			FinancaService finService = new FinancaService();

			Financa financa = new Financa();
			int resposta = 1;
			try {
				String nomeFinanca = (String) tableInvestimento.getModel().getValueAt(linhaTabela, 0);
				int id = finService.buscarIdInvestimentoPorNome(dadosUsuario.getId(), nomeFinanca,
						cbRendimentoMensal.getSelectedIndex() + 1, ((int) cbRendimentoAnual.getSelectedItem()));
				financa.setId(id);
				financa.setNome(nomeFinanca);
				financa.setTipo("Investimento a Longo Prazo");

				if ((tableInvestimento.getModel().getValueAt(linhaTabela, 1)).equals("")) {
					financa.setMensal_Ocasional(false);
					resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?",
							"Confirmação de Exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					if (resposta == JOptionPane.YES_OPTION) {
						finService.excluirFinanca(financa, "investimento");
					}
				} else {
					financa.setMensal_Ocasional(true);
					resposta = JOptionPane.showConfirmDialog(null,
							"Deseja realmente excluir essa Financa Mensal?\nCaso exclua, ela será apagada de todos os meses!",
							"Confirmação de Exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					if (resposta == JOptionPane.YES_OPTION) {
						finService.excluirFinanca(financa, "investimento");
					}
				}

				buscarInvestimento();
			} catch (SQLException | IOException e) {
				JOptionPane.showMessageDialog(null, "Erro ao excluir a finança!\n" + e.getMessage(), "ERRO",
						JOptionPane.ERROR_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(null, "Nenhuma linha da tabela selecionada", "Erro de Exclusão",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void btnEditarFundoDespesasActionPerformed() {
		int linhaTabela = tableFundoDespesas.getSelectedRow();
		if (linhaTabela != -1) {
			FinancaService finService = new FinancaService();

			Financa financa = new Financa();

			try {
				String nomeFinanca = (String) tableFundoDespesas.getModel().getValueAt(linhaTabela, 0);
				int id = finService.buscarIdFundoDespesasPorNome(dadosUsuario.getId(), nomeFinanca,
						cbFundoDespesasMensal.getSelectedIndex() + 1, ((int) cbFundoDespesasAnual.getSelectedItem()));
				financa.setId(id);
				financa.setNome(nomeFinanca);

				String valorSelecionado = (String) tableFundoDespesas.getModel().getValueAt(linhaTabela, 2);
				valorSelecionado = valorSelecionado.replace("R$", "").trim();
				Double valorDouble = Double.parseDouble(valorSelecionado);
				financa.setTotal(valorDouble);
				financa.setTipo("Fundo para Despesas Ocasionais");
				CadastrarFinancaFrame editarFinancaFrame = new CadastrarFinancaFrame("Fundo para Despesas Ocasionais",
						"Editar", financa);
				editarFinancaFrame.setLocationRelativeTo(null);
				editarFinancaFrame.setVisible(true);

				editarFinancaFrame.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						buscarFundoDespesas();
					}
				});
			} catch (SQLException | IOException e) {
				JOptionPane.showMessageDialog(null, "Erro ao editar a finança!\n" + e.getMessage(), "ERRO",
						JOptionPane.ERROR_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(null, "Nenhuma linha da tabela selecionada", "Erro de Edição",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void btnExcluirFundoDespesasActionPerformed() {
		int linhaTabela = tableFundoDespesas.getSelectedRow();
		if (linhaTabela != -1) {

			FinancaService finService = new FinancaService();

			Financa financa = new Financa();
			int resposta = 1;
			try {
				String nomeFinanca = (String) tableFundoDespesas.getModel().getValueAt(linhaTabela, 0);
				int id = finService.buscarIdFundoDespesasPorNome(dadosUsuario.getId(), nomeFinanca,
						cbFundoDespesasMensal.getSelectedIndex() + 1, ((int) cbFundoDespesasAnual.getSelectedItem()));
				financa.setId(id);
				financa.setNome(nomeFinanca);
				financa.setTipo("Fundo para Despesas Ocasionais");

				resposta = JOptionPane.showConfirmDialog(null,
						"Deseja realmente excluir essa Financa Mensal?\nCaso exclua, ela será apagada de todos os meses!",
						"Confirmação de Exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (resposta == JOptionPane.YES_OPTION) {
					finService.excluirFinanca(financa, "fundo_despesas");
				}

				buscarFundoDespesas();
			} catch (SQLException | IOException e) {
				JOptionPane.showMessageDialog(null, "Erro ao excluir a finança!\n" + e.getMessage(), "ERRO",
						JOptionPane.ERROR_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(null, "Nenhuma linha da tabela selecionada", "Erro de Exclusão",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void btnPesquisarResumoMensalActionPerformed() {
		FinancaService finService = new FinancaService();
		DefaultTableModel modeloResumoMensal = (DefaultTableModel) tableResumoMensal.getModel();
		modeloResumoMensal.fireTableDataChanged();
		modeloResumoMensal.setRowCount(0);

		tableResumoMensal.getColumnModel().getColumn(1).setCellRenderer(estiloCelula);

		if (cbResumoMensalAno.getSelectedItem() == null) {
			cbResumoMensalAno.addItem(Calendar.getInstance().get(Calendar.YEAR));
		}
			try {
				Double totalMesRendimento = finService.buscarTotalporMes(dadosUsuario.getId(), "rendimento_despesa",
						"Rendimento", cbResumoMensal.getSelectedIndex() + 1,
						((int) cbResumoMensalAno.getSelectedItem()));
				modeloResumoMensal.addRow(new Object[] { "Rendimento", "R$ " + totalMesRendimento });

				Double totalMesInvestimento = finService.buscarTotalporMes(dadosUsuario.getId(), "investimento",
						"Investimento a Longo Prazo", cbResumoMensal.getSelectedIndex() + 1,
						((int) cbResumoMensalAno.getSelectedItem()));
				modeloResumoMensal.addRow(new Object[] { "Investimento a Longo Prazo", "R$ " + totalMesInvestimento });

				Double totalMesFundo = finService.buscarTotalporMes(dadosUsuario.getId(), "fundo_despesas",
						"Fundo para Despesas Ocasionais", cbResumoMensal.getSelectedIndex() + 1,
						((int) cbResumoMensalAno.getSelectedItem()));
				modeloResumoMensal.addRow(new Object[] { "Fundo para Despesas Ocasionais", "R$ " + totalMesFundo });

				Double totalMesDisponivel = (totalMesRendimento - (totalMesFundo + totalMesInvestimento));
				modeloResumoMensal
						.addRow(new Object[] { "<html><b>Valor Total Disponível por Mês para Despesas</b></html>",
								"<html><b> R$ " + totalMesDisponivel + "</b></html>" });

				Double totalMesDespesa = finService.buscarTotalporMes(dadosUsuario.getId(), "rendimento_despesa",
						"Despesa", cbResumoMensal.getSelectedIndex() + 1,
						((int) cbResumoMensalAno.getSelectedItem()));
				modeloResumoMensal
						.addRow(new Object[] { "<html><b>Valor Total das Despesas Orçadas para o Mês</b></html>",
								"<html><b>R$ " + totalMesDespesa + "</b></html>" });

				Double totalFinalMes = (totalMesDisponivel - totalMesDespesa);

				if (totalFinalMes >= 0.0) {
					modeloResumoMensal.addRow(new Object[] { "<html><b>Valor total</b></html>",
							"<html><b><font color=\"green\">R$ " + totalFinalMes + "</font></b></html>" });
				} else {
					modeloResumoMensal.addRow(new Object[] { "<html><b>Valor total</b></html>",
							"<html><b><font color=\"red\">R$ " + totalFinalMes + "</font></b></html>" });
				}

				tableResumoMensal.setRowHeight(30);

			} catch (SQLException | IOException e) {
				JOptionPane.showMessageDialog(null, "Erro ao carregar dados das finanças!\n" + e.getMessage(), "ERRO",
						JOptionPane.ERROR_MESSAGE);
			}
		
	}
	
	public void btnPesquisarResumoAnualActionPerformed() {
		FinancaService finService = new FinancaService();
		DefaultTableModel modeloResumoAnual = (DefaultTableModel) tableResumoAnual.getModel();
		modeloResumoAnual.fireTableDataChanged();
		modeloResumoAnual.setRowCount(0);

		for (int i = 1; i <= 3; i++) {
			tableResumoAnual.getColumnModel().getColumn(i).setCellRenderer(estiloCelula);
		}

		if (cbResumoAnual.getSelectedItem() == null) {
			cbResumoAnual.addItem(Calendar.getInstance().get(Calendar.YEAR));
		}
			try {
				Double totalAnoRendimento = finService.buscarTotalporAno(dadosUsuario.getId(), "rendimento_despesa",
						"Rendimento",((int) cbResumoAnual.getSelectedItem()));
				modeloResumoAnual.addRow(new Object[] { "Rendimento", "R$ " + totalAnoRendimento, "R$ " + totalAnoRendimento, "R$ " + totalAnoRendimento });

				Double totalAnoInvestimento = finService.buscarTotalporAno(dadosUsuario.getId(), "investimento",
						"Investimento a Longo Prazo", ((int) cbResumoAnual.getSelectedItem()));
				modeloResumoAnual.addRow(new Object[] { "Investimento a Longo Prazo", "R$ " + totalAnoInvestimento, "R$ " + totalAnoInvestimento, "R$ " + totalAnoInvestimento });

				Double totalAnoFundo = finService.buscarTotalporAno(dadosUsuario.getId(), "fundo_despesas",
						"Fundo para Despesas Ocasionais", ((int) cbResumoAnual.getSelectedItem()));
				modeloResumoAnual.addRow(new Object[] { "Fundo para Despesas Ocasionais", "R$ " + totalAnoFundo, "", "R$ " + totalAnoFundo });

				Double totalAnoDisponivel = (totalAnoRendimento - (totalAnoFundo + totalAnoInvestimento));
				modeloResumoAnual
						.addRow(new Object[] { "<html><b>Total Disponível para Despesas Durante o Ano</b></html>",
								"", "", "<html><b> R$ " + totalAnoDisponivel + "</b></html>"});

				Double totalAnoDespesaMensal = finService.buscarTotalporAno(dadosUsuario.getId(), "rendimento_despesa",
						"Despesa", ((int) cbResumoAnual.getSelectedItem()));
				modeloResumoAnual
						.addRow(new Object[] { "<html><b>Total das Despesas Mensais Orçadas (12 meses)</b></html>", "","",
								"<html><b>R$ " + totalAnoDespesaMensal + "</b></html>" });
				
				Double totalAnoDespesaOcasional = finService.buscarTotalporAno(dadosUsuario.getId(), "rendimento_despesa",
						"Despesa", ((int) cbResumoAnual.getSelectedItem()));
				modeloResumoAnual
						.addRow(new Object[] { "<html><b>Total das Despesas Ocasionais Orçadas para o Ano</b></html>", "","",
								"<html><b>R$ " + totalAnoDespesaOcasional + "</b></html>" });

				Double totalFinalAno = (totalAnoDisponivel - totalAnoDespesaMensal);

				if (totalFinalAno >= 0.0) {
					modeloResumoAnual.addRow(new Object[] { "<html><b>Valor Total Restante Final do Ano</b></html>","","",
							"<html><b><font color=\"green\">R$ " + totalFinalAno + "</font></b></html>" });
				} else {
					modeloResumoAnual.addRow(new Object[] { "<html><b>Valor Total Restante Final do Ano</b></html>","","",
							"<html><b><font color=\"red\">R$ " + totalFinalAno + "</font></b></html>" });
				}

				tableResumoAnual.setRowHeight(30);
				TableColumn coluna0 = tableResumoAnual.getColumnModel().getColumn(0);
			    coluna0.setPreferredWidth(310);

			} catch (SQLException | IOException e) {
				JOptionPane.showMessageDialog(null, "Erro ao carregar dados das finanças!\n" + e.getMessage(), "ERRO",
						JOptionPane.ERROR_MESSAGE);
			}
		
	}

	public void atualizarAnos() {
		FinancaService service = new FinancaService();
		int[] vetorAnoRendimento;
		int[] vetorAnoDespesas;
		int[] vetorAnoInvestimento;
		int[] vetorAnoFundo;
		int[] vetorAnoResumo;
		try {
			vetorAnoRendimento = service.buscarAnoPorUsuario(dadosUsuario.getId(), "rendimento_despesa", "Rendimento");
			vetorAnoDespesas = service.buscarAnoPorUsuario(dadosUsuario.getId(), "rendimento_despesa", "Despesa");
			vetorAnoInvestimento = service.buscarAnoPorUsuario(dadosUsuario.getId(), "investimento",
					"Investimento a Longo Prazo");
			vetorAnoFundo = service.buscarAnoPorUsuario(dadosUsuario.getId(), "fundo_despesas",
					"Fundo para Despesas Ocasionais");
			if (vetorAnoRendimento.length >= vetorAnoDespesas.length
					&& vetorAnoRendimento.length >= vetorAnoInvestimento.length
					&& vetorAnoRendimento.length >= vetorAnoFundo.length) {
				vetorAnoResumo = vetorAnoRendimento;
			} else if (vetorAnoDespesas.length >= vetorAnoInvestimento.length
					&& vetorAnoDespesas.length >= vetorAnoFundo.length) {
				vetorAnoResumo = vetorAnoDespesas;
			} else if (vetorAnoInvestimento.length >= vetorAnoFundo.length) {
				vetorAnoResumo = vetorAnoInvestimento;
			} else {
				vetorAnoResumo = vetorAnoFundo;
			}
			cbRendimentoAnual.removeAllItems();
			for (int valor : vetorAnoRendimento) {
				cbRendimentoAnual.addItem(valor);
			}
			cbRendimentoAnual.setSelectedItem(Calendar.getInstance().get(Calendar.YEAR));
			cbDespesasAnual.removeAllItems();
			for (int valor : vetorAnoDespesas) {
				cbDespesasAnual.addItem(valor);
			}
			cbDespesasAnual.setSelectedItem(Calendar.getInstance().get(Calendar.YEAR));

			cbInvestimentoAnual.removeAllItems();
			for (int valor : vetorAnoInvestimento) {
				cbInvestimentoAnual.addItem(valor);
			}
			cbInvestimentoAnual.setSelectedItem(Calendar.getInstance().get(Calendar.YEAR));

			cbFundoDespesasAnual.removeAllItems();
			for (int valor : vetorAnoFundo) {
				cbFundoDespesasAnual.addItem(valor);
			}
			cbFundoDespesasAnual.setSelectedItem(Calendar.getInstance().get(Calendar.YEAR));

			cbResumoMensalAno.removeAllItems();
			for (int valor : vetorAnoResumo) {
				cbResumoMensalAno.addItem(valor);
			}
			cbResumoMensalAno.setSelectedItem(Calendar.getInstance().get(Calendar.YEAR));
			
			cbResumoAnual.removeAllItems();
			for (int valor : vetorAnoResumo) {
				cbResumoAnual.addItem(valor);
			}
			cbResumoAnual.setSelectedItem(Calendar.getInstance().get(Calendar.YEAR));
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new LoginCadastroFrame();
			}
		});
	}
}
