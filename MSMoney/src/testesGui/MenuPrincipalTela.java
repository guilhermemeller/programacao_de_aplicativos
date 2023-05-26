package testesGui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipalTela extends JFrame {
    private JPanel mainPanel;

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
        tpSideMenu.addTab("Rendimento", null, rendimentoPanel, null);
        
        JPanel despesasPanel = new JPanel();
        tpSideMenu.addTab("Despesas", null, despesasPanel, null);
        
        JPanel investimentoPanel = new JPanel();
        tpSideMenu.addTab("Investimento", null, investimentoPanel, null);
        
        JPanel despesasocasionaisPanel = new JPanel();
        tpSideMenu.addTab("Fundo de Despesas", null, despesasocasionaisPanel, null);
        
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

