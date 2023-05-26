package testesGui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginCadastroTela extends JFrame {
    private JPanel loginPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;

    private JPanel cadastroPanel;
    private JTextField nomeField;
    private JTextField novoUsernameField;
    private JPasswordField novoPasswordField;

    private boolean loginEfetuado;
    private boolean cadastroRealizado;

    public LoginCadastroTela() {
    	setResizable(false);
        // Configurações da janela principal
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        // Painel de login
        loginPanel = new JPanel();

        JLabel usernameLabel = new JLabel("Usuário:");
        usernameField = new JTextField();
        usernameField.setColumns(25);

        JLabel passwordLabel = new JLabel("Senha:");
        passwordField = new JPasswordField();
        passwordField.setColumns(25);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verificar a autenticação do usuário
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Implemente aqui a lógica de autenticação

                // Exemplo simples de autenticação
                if (username.equals("admin") && password.equals("senha123")) {
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
                    loginEfetuado = true;
                    dispose(); // Fechar a janela de login

                    // Abrir a tela do menu principal após o login
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new MenuPrincipalTela();
                        }
                    });
                } else {
                    JOptionPane.showMessageDialog(null, "Login falhou. Tente novamente!");
                }
            }
        });

        JButton cadastrarButton = new JButton("Cadastre-se");
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Alternar para a tela de cadastro
                loginPanel.setVisible(false);
                cadastroPanel.setVisible(true);
            }
        });
        loginPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        loginPanel.add(cadastrarButton);

        // Painel de cadastro
        cadastroPanel = new JPanel();

        JLabel nomeLabel = new JLabel("Nome:");
        nomeField = new JTextField();
        nomeField.setColumns(25);

        JLabel novoUsernameLabel = new JLabel("Novo Usuário:");
        novoUsernameField = new JTextField();
        novoUsernameField.setColumns(25);

        JLabel novoPasswordLabel = new JLabel("Nova Senha:");
        novoPasswordField = new JPasswordField();
        novoPasswordField.setColumns(25);

        JButton cadastrarUsuarioButton = new JButton("Cadastrar");
        cadastrarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implemente aqui a lógica de cadastro do usuário
                String nome = nomeField.getText();
                String novoUsername = novoUsernameField.getText();
                String novaSenha = new String(novoPasswordField.getPassword());

                // Exemplo simples de cadastro
                // Você pode adicionar sua lógica de armazenamento de dados aqui

                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                cadastroRealizado = true;

                // Limpar os campos após o cadastro
                nomeField.setText("");
                novoUsernameField.setText("");
                novoPasswordField.setText("");

                // Alternar para a tela de login após o cadastro
                cadastroPanel.setVisible(false);
                loginPanel.setVisible(true);
            }
        });

        JButton voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Voltar para a tela de login
                cadastroPanel.setVisible(false);
                loginPanel.setVisible(true);
            }
        });
        cadastroPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        cadastroPanel.add(nomeLabel);
        cadastroPanel.add(nomeField);
        cadastroPanel.add(novoUsernameLabel);
        cadastroPanel.add(novoUsernameField);
        cadastroPanel.add(novoPasswordLabel);
        cadastroPanel.add(novoPasswordField);
        cadastroPanel.add(cadastrarUsuarioButton);
        cadastroPanel.add(voltarButton);

        // Adicionar os painéis à janela principal
        getContentPane().setLayout(new CardLayout());
        getContentPane().add(loginPanel);
        getContentPane().add(cadastroPanel);

        // Definir a tela de cadastro como oculta inicialmente
        cadastroPanel.setVisible(false);

        // Exibir a janela
        setVisible(true);
    }

    public boolean isLoginEfetuado() {
        return loginEfetuado;
    }

    public boolean isCadastroRealizado() {
        return cadastroRealizado;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginCadastroTela();
            }
        });
    }
}
