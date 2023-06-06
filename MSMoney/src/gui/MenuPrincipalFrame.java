package gui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

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
    private JComboBox cbRendimento;
    private JButton btnPesquisarRendimento;
    private JPanel centerPanelRendimento;
    private JPanel botPanelRendimento;
    private JButton btnCadastrarRendimento;
    private JButton btnEditarRendimento;
    private JButton btnExcluirRendimento;
    private JPanel despesasPanel;
    private JPanel topPanelDespesas;
    private JComboBox cbDespesas;
    private JButton btnPesquisarDespesas;
    private JPanel centerPanelDespesas;
    private JPanel botPanelDespesas;
    private JButton btnEditarDespesas;
    private JButton btnCadastrarDespesas;
    private JButton btnExcluirDespesas;
    private JPanel topPanelInvestimento;
    private JPanel investimentoPanel;
    private JComboBox cbInvestimento;
    private JButton btnPesquisarInvestimento;
    private JPanel centerPanelInvestimento;
    private JPanel botPanelInvestimento;
    private JButton btnCadastrarInvestimento;
    private JButton btnEditarInvestimento;
    private JButton btnExcluirInvestimento;
    private JPanel despesasocasionaisPanel;
    private JPanel topPanelFundoDespesas;
    private JComboBox cbFundoDespesas;
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

    public MenuPrincipalFrame() {
    	initComponents();
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
        rendimentoPanel.setBorder(new TitledBorder(null, "Gerenciamento de Rendimentos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        tpSideMenu.addTab("Rendimento", null, rendimentoPanel, null);
        rendimentoPanel.setLayout(new BorderLayout(0, 0));
        
        topPanelRendimento = new JPanel();
        rendimentoPanel.add(topPanelRendimento, BorderLayout.NORTH);
        topPanelRendimento.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 25));
        
        cbRendimento = new JComboBox();
        cbRendimento.setFont(new Font("Tahoma", Font.PLAIN, 15));
        cbRendimento.setModel(new DefaultComboBoxModel(new String[] {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
        topPanelRendimento.add(cbRendimento);
        
        btnPesquisarRendimento = new JButton("");
        btnPesquisarRendimento.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/pesquisar20.png")));
        topPanelRendimento.add(btnPesquisarRendimento);
        
        centerPanelRendimento = new JPanel();
        centerPanelRendimento.setLayout(null);
        rendimentoPanel.add(centerPanelRendimento, BorderLayout.CENTER);
        
        tableRendimento = new JTable();
        tableRendimento.setBounds(10, 11, 727, 302);
        centerPanelRendimento.add(tableRendimento);
        
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
        btnEditarRendimento.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/editar40.png")));
        btnEditarRendimento.setBackground(new Color(191, 214, 255));
        btnEditarRendimento.setFont(new Font("Tahoma", Font.BOLD, 16));
        botPanelRendimento.add(btnEditarRendimento);
        
        btnExcluirRendimento = new JButton("Excluir");
        btnExcluirRendimento.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/excluir40.png")));
        btnExcluirRendimento.setBackground(new Color(255, 176, 176));
        btnExcluirRendimento.setFont(new Font("Tahoma", Font.BOLD, 16));
        botPanelRendimento.add(btnExcluirRendimento);
        
        despesasPanel = new JPanel();
        despesasPanel.setBorder(new TitledBorder(null, "Gerenciamento de Despesas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        tpSideMenu.addTab("Despesas", null, despesasPanel, null);
        despesasPanel.setLayout(new BorderLayout(0, 0));
        
        topPanelDespesas = new JPanel();
        despesasPanel.add(topPanelDespesas, BorderLayout.NORTH);
        topPanelDespesas.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 25));
        
        cbDespesas = new JComboBox();
        cbDespesas.setFont(new Font("Tahoma", Font.PLAIN, 15));
        cbDespesas.setModel(new DefaultComboBoxModel(new String[] {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
        topPanelDespesas.add(cbDespesas);
        
        btnPesquisarDespesas = new JButton("");
        btnPesquisarDespesas.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/pesquisar20.png")));
        topPanelDespesas.add(btnPesquisarDespesas);
        
        centerPanelDespesas = new JPanel();
        despesasPanel.add(centerPanelDespesas, BorderLayout.CENTER);
        centerPanelDespesas.setLayout(null);
        
        tableDespesas = new JTable();
        tableDespesas.setBounds(10, 11, 727, 302);
        centerPanelDespesas.add(tableDespesas);
        
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
        btnEditarDespesas.setBackground(new Color(191, 214, 255));
        btnEditarDespesas.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/editar40.png")));
        btnEditarDespesas.setFont(new Font("Tahoma", Font.BOLD, 16));
        botPanelDespesas.add(btnEditarDespesas);
        
        btnExcluirDespesas = new JButton("Excluir");
        btnExcluirDespesas.setBackground(new Color(255, 176, 176));
        btnExcluirDespesas.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/excluir40.png")));
        btnExcluirDespesas.setFont(new Font("Tahoma", Font.BOLD, 16));
        botPanelDespesas.add(btnExcluirDespesas);
        
        investimentoPanel = new JPanel();
        investimentoPanel.setBorder(new TitledBorder(null, "Investimento a Longo Prazo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        tpSideMenu.addTab("Investimento", null, investimentoPanel, null);
        investimentoPanel.setLayout(new BorderLayout(0, 0));
        
        topPanelInvestimento = new JPanel();
        investimentoPanel.add(topPanelInvestimento, BorderLayout.NORTH);
        topPanelInvestimento.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 25));
        
        cbInvestimento = new JComboBox();
        cbInvestimento.setFont(new Font("Tahoma", Font.PLAIN, 15));
        cbInvestimento.setModel(new DefaultComboBoxModel(new String[] {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
        topPanelInvestimento.add(cbInvestimento);
        
        btnPesquisarInvestimento = new JButton("");
        btnPesquisarInvestimento.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/pesquisar20.png")));
        topPanelInvestimento.add(btnPesquisarInvestimento);
        
        centerPanelInvestimento = new JPanel();
        centerPanelInvestimento.setLayout(null);
        investimentoPanel.add(centerPanelInvestimento, BorderLayout.CENTER);
        
        tableInvestimento = new JTable();
        tableInvestimento.setBounds(10, 11, 727, 302);
        centerPanelInvestimento.add(tableInvestimento);
        
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
        btnCadastrarInvestimento.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/cadastrar40.png")));
        btnCadastrarInvestimento.setFont(new Font("Tahoma", Font.BOLD, 16));
        botPanelInvestimento.add(btnCadastrarInvestimento);
        
        btnEditarInvestimento = new JButton("Editar");
        btnEditarInvestimento.setBackground(new Color(191, 214, 255));
        btnEditarInvestimento.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/editar40.png")));
        btnEditarInvestimento.setFont(new Font("Tahoma", Font.BOLD, 16));
        botPanelInvestimento.add(btnEditarInvestimento);
        
        btnExcluirInvestimento = new JButton("Excluir");
        btnExcluirInvestimento.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/excluir40.png")));
        btnExcluirInvestimento.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnExcluirInvestimento.setBackground(new Color(255, 176, 176));
        botPanelInvestimento.add(btnExcluirInvestimento);
        
        despesasocasionaisPanel = new JPanel();
        despesasocasionaisPanel.setBorder(new TitledBorder(null, "Fundo para Despesas Ocasionais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        tpSideMenu.addTab("Fundo de Despesas", null, despesasocasionaisPanel, null);
        despesasocasionaisPanel.setLayout(new BorderLayout(0, 0));
        
        topPanelFundoDespesas = new JPanel();
        despesasocasionaisPanel.add(topPanelFundoDespesas, BorderLayout.NORTH);
        topPanelFundoDespesas.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 25));
        
        cbFundoDespesas = new JComboBox();
        cbFundoDespesas.setFont(new Font("Tahoma", Font.PLAIN, 15));
        cbFundoDespesas.setModel(new DefaultComboBoxModel(new String[] {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
        topPanelFundoDespesas.add(cbFundoDespesas);
        
        btnPesquisarFundoDespesas = new JButton("");
        btnPesquisarFundoDespesas.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/pesquisar20.png")));
        topPanelFundoDespesas.add(btnPesquisarFundoDespesas);
        
        centerPanelFundoDespesas = new JPanel();
        centerPanelFundoDespesas.setLayout(null);
        despesasocasionaisPanel.add(centerPanelFundoDespesas, BorderLayout.CENTER);
        
        tableFundoDespesas = new JTable();
        tableFundoDespesas.setBounds(10, 11, 727, 302);
        centerPanelFundoDespesas.add(tableFundoDespesas);
        
        botPanelFundoDespesas = new JPanel();
        despesasocasionaisPanel.add(botPanelFundoDespesas, BorderLayout.SOUTH);
        botPanelFundoDespesas.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 5));
        
        btnCadastrarFundoDespesas = new JButton("Cadastrar");
        btnCadastrarFundoDespesas.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnCadastrarFundoDespesasActionPerformed();
        	}
        });
        btnCadastrarFundoDespesas.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/cadastrar40.png")));
        btnCadastrarFundoDespesas.setBackground(new Color(221, 249, 226));
        btnCadastrarFundoDespesas.setFont(new Font("Tahoma", Font.BOLD, 16));
        botPanelFundoDespesas.add(btnCadastrarFundoDespesas);
        
        btnEditarFundoDespesas = new JButton("Editar");
        btnEditarFundoDespesas.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/editar40.png")));
        btnEditarFundoDespesas.setBackground(new Color(191, 214, 255));
        btnEditarFundoDespesas.setFont(new Font("Tahoma", Font.BOLD, 16));
        botPanelFundoDespesas.add(btnEditarFundoDespesas);
        
        btnExcluirFundoDespesas = new JButton("Excluir");
        btnExcluirFundoDespesas.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/excluir40.png")));
        btnExcluirFundoDespesas.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnExcluirFundoDespesas.setBackground(new Color(255, 176, 176));
        botPanelFundoDespesas.add(btnExcluirFundoDespesas);
        
        resumoPanel = new JPanel();
        resumoPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Resumo de contas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        tpSideMenu.addTab("Resumo", null, resumoPanel, null);
        resumoPanel.setLayout(null);
        
        tpResumo = new JTabbedPane(JTabbedPane.LEFT);
        tpResumo.setFont(new Font("Tahoma", Font.BOLD, 15));
        tpResumo.setBounds(10, 21, 739, 452);
        resumoPanel.add(tpResumo);
        
        resumomensalPanel = new JPanel();
        resumomensalPanel.setBorder(new TitledBorder(null, "Resumo Mensal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        tpResumo.addTab("Resumo Mensal", null, resumomensalPanel, null);
        resumomensalPanel.setLayout(new BorderLayout(0, 0));
        
        topPanelResumomensal = new JPanel();
        resumomensalPanel.add(topPanelResumomensal, BorderLayout.NORTH);
        topPanelResumomensal.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 25));
        
        cbResumoMensal = new JComboBox();
        cbResumoMensal.setFont(new Font("Tahoma", Font.PLAIN, 15));
        cbResumoMensal.setModel(new DefaultComboBoxModel(new String[] {"Janeiro", "Fevereiro", "Março", "Abril", "Março", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
        topPanelResumomensal.add(cbResumoMensal);
        
        btnPesquisarResumoMensal = new JButton("");
        btnPesquisarResumoMensal.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/pesquisar20.png")));
        topPanelResumomensal.add(btnPesquisarResumoMensal);
        
        centerPanelResumomensal = new JPanel();
        centerPanelResumomensal.setLayout(null);
        resumomensalPanel.add(centerPanelResumomensal, BorderLayout.CENTER);
        
        tableResumoMensal = new JTable();
        tableResumoMensal.setBounds(10, 11, 570, 324);
        centerPanelResumomensal.add(tableResumoMensal);
        
        resumoanualPanel = new JPanel();
        resumoanualPanel.setBorder(new TitledBorder(null, "Resumo Anual", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        tpResumo.addTab("Resumo Anual", null, resumoanualPanel, null);
        resumoanualPanel.setLayout(new BorderLayout(0, 0));
        
        topPanelResumoanual = new JPanel();
        resumoanualPanel.add(topPanelResumoanual, BorderLayout.NORTH);
        topPanelResumoanual.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 25));
        
        cbResumoAnual = new JComboBox();
        cbResumoAnual.setFont(new Font("Tahoma", Font.PLAIN, 15));
        cbResumoAnual.setModel(new DefaultComboBoxModel(new String[] {"2023"}));
        topPanelResumoanual.add(cbResumoAnual);
        
        btnPesquisarResumoAnual = new JButton("");
        btnPesquisarResumoAnual.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/pesquisar20.png")));
        topPanelResumoanual.add(btnPesquisarResumoAnual);
        
        relatorioPanel = new JPanel();
        relatorioPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Gera\u00E7\u00E3o de Relat\u00F3rios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        tpSideMenu.addTab("Relatório", null, relatorioPanel, null);
        relatorioPanel.setLayout(null);
        
        tpRelatorio = new JTabbedPane(JTabbedPane.LEFT);
        tpRelatorio.setFont(new Font("Tahoma", Font.BOLD, 15));
        tpRelatorio.setBounds(10, 21, 739, 452);
        relatorioPanel.add(tpRelatorio);
        
        relatoriomensalPanel = new JPanel();
        relatoriomensalPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Relat\u00F3rio Mensal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        tpRelatorio.addTab("Relatório Mensal", null, relatoriomensalPanel, null);
        relatoriomensalPanel.setLayout(new BorderLayout(0, 0));
        
        topPanelRelatoriomensal = new JPanel();
        relatoriomensalPanel.add(topPanelRelatoriomensal, BorderLayout.NORTH);
        topPanelRelatoriomensal.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 25));
        
        cbRelatorioMensal = new JComboBox();
        cbRelatorioMensal.setModel(new DefaultComboBoxModel(new String[] {"Janeiro"}));
        cbRelatorioMensal.setFont(new Font("Tahoma", Font.PLAIN, 15));
        topPanelRelatoriomensal.add(cbRelatorioMensal);
        
        cbCategoriaMensal = new JComboBox();
        cbCategoriaMensal.setFont(new Font("Tahoma", Font.PLAIN, 15));
        cbCategoriaMensal.setModel(new DefaultComboBoxModel(new String[] {"Salário", "Automóvel"}));
        topPanelRelatoriomensal.add(cbCategoriaMensal);
        
        btnPesquisarRelatorioMensal = new JButton("");
        btnPesquisarRelatorioMensal.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/pesquisar20.png")));
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
        relatorioanualPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Relat\u00F3rio Anual", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        tpRelatorio.addTab("Relatório Anual", null, relatorioanualPanel, null);
        relatorioanualPanel.setLayout(new BorderLayout(0, 0));
        
        topPanelRelatorioanual = new JPanel();
        relatorioanualPanel.add(topPanelRelatorioanual, BorderLayout.NORTH);
        topPanelRelatorioanual.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 25));
        
        cbRelatorioAnual = new JComboBox();
        cbRelatorioAnual.setFont(new Font("Tahoma", Font.PLAIN, 15));
        cbRelatorioAnual.setModel(new DefaultComboBoxModel(new String[] {"2023"}));
        topPanelRelatorioanual.add(cbRelatorioAnual);
        
        cbCategoriaAnual = new JComboBox();
        cbCategoriaAnual.setModel(new DefaultComboBoxModel(new String[] {"Salário", "Automóvel"}));
        cbCategoriaAnual.setFont(new Font("Tahoma", Font.PLAIN, 15));
        topPanelRelatorioanual.add(cbCategoriaAnual);
        
        btnPesquisarRelatorioAnual = new JButton("");
        btnPesquisarRelatorioAnual.setIcon(new ImageIcon(MenuPrincipalFrame.class.getResource("/images/pesquisar20.png")));
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
        
        tableResumoAnual = new JTable();
        tableResumoAnual.setBounds(10, 11, 570, 324);
        centerPanelResumoanual.add(tableResumoAnual);

        // Exibir a janela
        setVisible(true);
    }
    
    public void btnCadastrarRendimentoActionPerformed() {
    		cadastrarFinanca = new CadastrarFinancaFrame("Rendimento");
    		cadastrarFinanca.setLocationRelativeTo(null);
    		cadastrarFinanca.setVisible(true);
    }
    
    public void btnCadastrarDespesasActionPerformed() {
		cadastrarFinanca = new CadastrarFinancaFrame("Despesa");
		cadastrarFinanca.setLocationRelativeTo(null);
		cadastrarFinanca.setVisible(true);
    }
    
    public void btnCadastrarInvestimentoActionPerformed() {
		cadastrarFinanca = new CadastrarFinancaFrame("Investimento a Longo Prazo");
		cadastrarFinanca.setLocationRelativeTo(null);
		cadastrarFinanca.setVisible(true);
    }
    
    public void btnCadastrarFundoDespesasActionPerformed() {
		cadastrarFinanca = new CadastrarFinancaFrame("Fundo para Despesas Ocasionais");
		cadastrarFinanca.setLocationRelativeTo(null);
		cadastrarFinanca.setVisible(true);
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

