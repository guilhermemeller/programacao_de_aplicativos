package testesGui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipalTela extends JFrame {
    private JPanel mainPanel;
    private JPanel sidePanel;
    private JPanel contentPanel;

    public MenuPrincipalTela() {
        // Configurações da janela principal
        setTitle("Menu Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Painel principal
        mainPanel = new JPanel(new BorderLayout());

        // Painel lateral
        sidePanel = new JPanel(new GridLayout(6, 1));

        JButton rendimentoButton = new JButton("Rendimento");
        rendimentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implemente aqui a lógica para exibir a funcionalidade de Rendimento
                JOptionPane.showMessageDialog(null, "Funcionalidade de Rendimento selecionada.");
            }
        });

        JButton despesasButton = new JButton("Despesas");
        despesasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implemente aqui a lógica para exibir a funcionalidade de Despesas
                JOptionPane.showMessageDialog(null, "Funcionalidade de Despesas selecionada.");
            }
        });

        JButton investimentoButton = new JButton("Investimento");
        investimentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implemente aqui a lógica para exibir a funcionalidade de Investimento
                JOptionPane.showMessageDialog(null, "Funcionalidade de Investimento selecionada.");
            }
        });

        JButton fundoButton = new JButton("Fundo de Despesas Ocasionais");
        fundoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implemente aqui a lógica para exibir a funcionalidade de Fundo de Despesas Ocasionais
                JOptionPane.showMessageDialog(null, "Funcionalidade de Fundo de Despesas Ocasionais selecionada.");
            }
        });

        JButton resumoButton = new JButton("Resumo");
        resumoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implemente aqui a lógica para exibir a funcionalidade de Resumo
                JOptionPane.showMessageDialog(null, "Funcionalidade de Resumo selecionada.");
            }
        });

        JButton relatorioButton = new JButton("Relatório");
        relatorioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implemente aqui a lógica para exibir a funcionalidade de Relatório
                JOptionPane.showMessageDialog(null, "Funcionalidade de Relatório selecionada.");
            }
        });

        sidePanel.add(rendimentoButton);
        sidePanel.add(despesasButton);
        sidePanel.add(investimentoButton);
        sidePanel.add(fundoButton);
        sidePanel.add(resumoButton);
        sidePanel.add(relatorioButton);

        // Painel de conteúdo
        contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);

        mainPanel.add(sidePanel, BorderLayout.WEST);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

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
        add(mainPanel);

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

