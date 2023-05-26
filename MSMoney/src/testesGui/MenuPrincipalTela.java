package testesGui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.TitledBorder;

public class MenuPrincipalTela extends JFrame {
    private JPanel mainPanel;
    private JTable tableDespesas;
    private JTable tableRendimento;
    private JTable tableInvestimento;
    private JTable tableFundoDespesas;

    public MenuPrincipalTela() {
    	setResizable(false);
        // Configurações da janela principal
        setTitle("Menu Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLocationRelativeTo(null);

        // Painel principal
        mainPanel = new JPanel();

        // Barra superior com menu de opções
        JMenuBar menuBar = new JMenuBar();
        JMenu optionsMenu = new JMenu("Opções");
        JMenuItem exitMenuItem = new JMenuItem("Sair");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fechar o programa
                System.exit(0);
            }
        });

        optionsMenu.add(exitMenuItem);
        menuBar.add(optionsMenu);

        setJMenuBar(menuBar);

        // Adicionar o painel principal à janela
        getContentPane().add(mainPanel);
        mainPanel.setLayout(null);
        
        JTabbedPane tpSideMenu = new JTabbedPane(JTabbedPane.TOP);
        tpSideMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
        tpSideMenu.setBounds(10, 11, 964, 717);
        mainPanel.add(tpSideMenu);
        
        JPanel rendimentoPanel = new JPanel();
        rendimentoPanel.setBorder(new TitledBorder(null, "Gerenciamento de Rendimentos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        tpSideMenu.addTab("Rendimento", null, rendimentoPanel, null);
        rendimentoPanel.setLayout(new BorderLayout(0, 0));
        
        JPanel topPanelRendimento = new JPanel();
        rendimentoPanel.add(topPanelRendimento, BorderLayout.NORTH);
        topPanelRendimento.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 25));
        
        JComboBox cbRendimento = new JComboBox();
        cbRendimento.setModel(new DefaultComboBoxModel(new String[] {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
        topPanelRendimento.add(cbRendimento);
        
        JButton btnPesquisarRendimento = new JButton("Pesquisar");
        topPanelRendimento.add(btnPesquisarRendimento);
        
        JPanel centerPanelRendimento = new JPanel();
        centerPanelRendimento.setLayout(null);
        rendimentoPanel.add(centerPanelRendimento, BorderLayout.CENTER);
        
        tableRendimento = new JTable();
        tableRendimento.setBounds(10, 11, 939, 550);
        centerPanelRendimento.add(tableRendimento);
        
        JPanel botPanelRendimento = new JPanel();
        rendimentoPanel.add(botPanelRendimento, BorderLayout.SOUTH);
        botPanelRendimento.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 5));
        
        JButton btnCadastrarRendimento = new JButton("Cadastrar");
        botPanelRendimento.add(btnCadastrarRendimento);
        
        JButton btnEditarRendimento = new JButton("Editar");
        botPanelRendimento.add(btnEditarRendimento);
        
        JButton btnExcluirRendimento = new JButton("Excluir");
        botPanelRendimento.add(btnExcluirRendimento);
        
        JPanel despesasPanel = new JPanel();
        despesasPanel.setBorder(new TitledBorder(null, "Gerenciamento de Despesas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        tpSideMenu.addTab("Despesas", null, despesasPanel, null);
        despesasPanel.setLayout(new BorderLayout(0, 0));
        
        JPanel topPanelDespesas = new JPanel();
        despesasPanel.add(topPanelDespesas, BorderLayout.NORTH);
        topPanelDespesas.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 25));
        
        JComboBox cbDespesas = new JComboBox();
        cbDespesas.setModel(new DefaultComboBoxModel(new String[] {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
        topPanelDespesas.add(cbDespesas);
        
        JButton btnPesquisarDespesas = new JButton("Pesquisar");
        topPanelDespesas.add(btnPesquisarDespesas);
        
        JPanel centerPanelDespesas = new JPanel();
        despesasPanel.add(centerPanelDespesas, BorderLayout.CENTER);
        centerPanelDespesas.setLayout(null);
        
        tableDespesas = new JTable();
        tableDespesas.setBounds(10, 11, 939, 550);
        centerPanelDespesas.add(tableDespesas);
        
        JPanel botPanelDespesas = new JPanel();
        despesasPanel.add(botPanelDespesas, BorderLayout.SOUTH);
        botPanelDespesas.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 5));
        
        JButton btnCadastrarDespesas = new JButton("Cadastrar");
        botPanelDespesas.add(btnCadastrarDespesas);
        
        JButton btnEditarDespesas = new JButton("Editar");
        botPanelDespesas.add(btnEditarDespesas);
        
        JButton btnExcluirDespesas = new JButton("Excluir");
        botPanelDespesas.add(btnExcluirDespesas);
        
        JPanel investimentoPanel = new JPanel();
        investimentoPanel.setBorder(new TitledBorder(null, "Investimento a Longo Prazo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        tpSideMenu.addTab("Investimento", null, investimentoPanel, null);
        investimentoPanel.setLayout(new BorderLayout(0, 0));
        
        JPanel topPanelInvestimento = new JPanel();
        investimentoPanel.add(topPanelInvestimento, BorderLayout.NORTH);
        topPanelInvestimento.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 25));
        
        JComboBox cbInvestimento = new JComboBox();
        cbInvestimento.setModel(new DefaultComboBoxModel(new String[] {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
        topPanelInvestimento.add(cbInvestimento);
        
        JButton btnPesquisarInvestimento = new JButton("Pesquisar");
        topPanelInvestimento.add(btnPesquisarInvestimento);
        
        JPanel centerPanelInvestimento = new JPanel();
        centerPanelInvestimento.setLayout(null);
        investimentoPanel.add(centerPanelInvestimento, BorderLayout.CENTER);
        
        tableInvestimento = new JTable();
        tableInvestimento.setBounds(10, 11, 939, 550);
        centerPanelInvestimento.add(tableInvestimento);
        
        JPanel botPanelInvestimento = new JPanel();
        investimentoPanel.add(botPanelInvestimento, BorderLayout.SOUTH);
        botPanelInvestimento.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 5));
        
        JButton btnCadastrarInvestimento = new JButton("Cadastrar");
        botPanelInvestimento.add(btnCadastrarInvestimento);
        
        JButton btnEditarInvestimento = new JButton("Editar");
        botPanelInvestimento.add(btnEditarInvestimento);
        
        JButton btnExcluirInvestimento = new JButton("Excluir");
        botPanelInvestimento.add(btnExcluirInvestimento);
        
        JPanel despesasocasionaisPanel = new JPanel();
        despesasocasionaisPanel.setBorder(new TitledBorder(null, "Fundo para Despesas Ocasionais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        tpSideMenu.addTab("Fundo de Despesas", null, despesasocasionaisPanel, null);
        despesasocasionaisPanel.setLayout(new BorderLayout(0, 0));
        
        JPanel topPanelFundoDespesas = new JPanel();
        despesasocasionaisPanel.add(topPanelFundoDespesas, BorderLayout.NORTH);
        topPanelFundoDespesas.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 25));
        
        JComboBox cbFundoDespesas = new JComboBox();
        cbFundoDespesas.setModel(new DefaultComboBoxModel(new String[] {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
        topPanelFundoDespesas.add(cbFundoDespesas);
        
        JButton btnPesquisarFundoDespesas = new JButton("Pesquisar");
        topPanelFundoDespesas.add(btnPesquisarFundoDespesas);
        
        JPanel centerPanelFundoDespesas = new JPanel();
        centerPanelFundoDespesas.setLayout(null);
        despesasocasionaisPanel.add(centerPanelFundoDespesas, BorderLayout.CENTER);
        
        tableFundoDespesas = new JTable();
        tableFundoDespesas.setBounds(10, 11, 939, 550);
        centerPanelFundoDespesas.add(tableFundoDespesas);
        
        JPanel botPanelFundoDespesas = new JPanel();
        despesasocasionaisPanel.add(botPanelFundoDespesas, BorderLayout.SOUTH);
        botPanelFundoDespesas.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 5));
        
        JButton btnCadastrarFundoDespesas = new JButton("Cadastrar");
        botPanelFundoDespesas.add(btnCadastrarFundoDespesas);
        
        JButton btnEditarFundoDespesas = new JButton("Editar");
        botPanelFundoDespesas.add(btnEditarFundoDespesas);
        
        JButton btnExcluirFundoDespesas = new JButton("Excluir");
        botPanelFundoDespesas.add(btnExcluirFundoDespesas);
        
        JPanel resumoPanel = new JPanel();
        tpSideMenu.addTab("Resumo", null, resumoPanel, null);
        
        JPanel relatorioPanel = new JPanel();
        tpSideMenu.addTab("Relatório", null, relatorioPanel, null);

        // Exibir a janela
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Criar uma instância da tela de login
                LoginCadastroTela loginTela = new LoginCadastroTela();
                loginTela.setVisible(true);

                // Esperar até que o login seja efetuado ou um cadastro seja realizado
                while (!loginTela.isLoginEfetuado() && !loginTela.isCadastroRealizado()) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // Se o login for efetuado ou um cadastro for realizado, exibir a tela do menu principal
                if (loginTela.isLoginEfetuado() || loginTela.isCadastroRealizado()) {
                    new MenuPrincipalTela();
                }
            }
        });
    }
}

