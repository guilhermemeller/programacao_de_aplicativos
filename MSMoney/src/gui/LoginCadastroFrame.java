package gui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginCadastroFrame extends JFrame {
    private JPanel loginPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;

    private JPanel cadastroPanel;
    private JTextField nomeField;
    private JTextField novoUsernameField;
    private JPasswordField novoPasswordField;

    private boolean loginEfetuado;
    private boolean cadastroRealizado;

    public LoginCadastroFrame() {
    	setResizable(false);
        // Configurações da janela principal
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(360, 200);
        setLocationRelativeTo(null);

        // Painel de login
        loginPanel = new JPanel();
        loginPanel.setLayout(new BorderLayout(0, 0));

        // Painel de cadastro
        cadastroPanel = new JPanel();
        cadastroPanel.setLayout(new BorderLayout(0, 0));
        
        JPanel dadoscadastroPanel = new JPanel();
        cadastroPanel.add(dadoscadastroPanel, BorderLayout.CENTER);
                dadoscadastroPanel.setLayout(null);
        
                JLabel nomeLabel = new JLabel("Nome:");
                nomeLabel.setBounds(45, 25, 50, 14);
                dadoscadastroPanel.add(nomeLabel);
                nomeField = new JTextField();
                nomeField.setBounds(88, 22, 206, 20);
                dadoscadastroPanel.add(nomeField);
                nomeField.setColumns(25);
                
                        JLabel novoUsernameLabel = new JLabel("Usuário:");
                        novoUsernameLabel.setBounds(35, 56, 50, 14);
                        dadoscadastroPanel.add(novoUsernameLabel);
                        novoUsernameField = new JTextField();
                        novoUsernameField.setBounds(88, 53, 206, 20);
                        dadoscadastroPanel.add(novoUsernameField);
                        novoUsernameField.setColumns(25);
                        
                                JLabel novoPasswordLabel = new JLabel("Senha:");
                                novoPasswordLabel.setBounds(43, 87, 50, 14);
                                dadoscadastroPanel.add(novoPasswordLabel);
                                novoPasswordField = new JPasswordField();
                                novoPasswordField.setBounds(88, 84, 206, 20);
                                dadoscadastroPanel.add(novoPasswordField);
                                novoPasswordField.setColumns(25);

        // Adicionar os painéis à janela principal
        getContentPane().setLayout(new CardLayout());
        getContentPane().add(loginPanel);
        
        JPanel dadosloginPanel = new JPanel();
        loginPanel.add(dadosloginPanel, BorderLayout.CENTER);
                dadosloginPanel.setLayout(null);
        
                JLabel usernameLabel = new JLabel("Usuário:");
                usernameLabel.setBounds(36, 36, 60, 14);
                dadosloginPanel.add(usernameLabel);
                usernameField = new JTextField();
                usernameField.addKeyListener(new KeyAdapter() {
                	@Override
                	public void keyPressed(KeyEvent evt) {
                		if(evt.getKeyCode() == KeyEvent.VK_ENTER)
                        {
                            logarSistema();
                        }
                	}
                });
                usernameField.setBounds(89, 33, 206, 20);
                dadosloginPanel.add(usernameField);
                usernameField.setColumns(25);
                
                        JLabel passwordLabel = new JLabel("Senha:");
                        passwordLabel.setBounds(44, 80, 60, 14);
                        dadosloginPanel.add(passwordLabel);
                        
                        JLabel label = new JLabel("");
                        label.setBounds(319, 15, 0, 0);
                        dadosloginPanel.add(label);
                        passwordField = new JPasswordField();
                        passwordField.addKeyListener(new KeyAdapter() {
                        	@Override
                        	public void keyPressed(KeyEvent evt) {
                        		if(evt.getKeyCode() == KeyEvent.VK_ENTER)
                                {
                                    logarSistema();
                                }
                        	}
                        });
                        passwordField.setBounds(89, 77, 206, 20);
                        dadosloginPanel.add(passwordField);
                        passwordField.setColumns(25);
                        
                        JLabel label_1 = new JLabel("");
                        label_1.setBounds(277, 40, 0, 0);
                        dadosloginPanel.add(label_1);
        
        JPanel botoesloginPanel = new JPanel();
        loginPanel.add(botoesloginPanel, BorderLayout.SOUTH);
                        botoesloginPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
                
                        JButton loginButton = new JButton("Login");
                        loginButton.setBackground(new Color(221, 249, 226));
                        botoesloginPanel.add(loginButton);
                        loginButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                logarSistema();
                            }
                        });
        
                JButton cadastrarButton = new JButton("Cadastre-se");
                cadastrarButton.setBackground(new Color(191, 214, 255));
                botoesloginPanel.add(cadastrarButton);
                cadastrarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Alternar para a tela de cadastro
                        loginPanel.setVisible(false);
                        cadastroPanel.setVisible(true);
                    }
                });
        getContentPane().add(cadastroPanel);
        
        JPanel botoescadastroPanel = new JPanel();
        cadastroPanel.add(botoescadastroPanel, BorderLayout.SOUTH);
        
                JButton cadastrarUsuarioButton = new JButton("Cadastrar");
                cadastrarUsuarioButton.setBackground(new Color(221, 249, 226));
                botoescadastroPanel.add(cadastrarUsuarioButton);
                
                        JButton voltarButton = new JButton("Voltar");
                        voltarButton.setBackground(new Color(255, 176, 176));
                        botoescadastroPanel.add(voltarButton);
                        voltarButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Voltar para a tela de login
                                cadastroPanel.setVisible(false);
                                loginPanel.setVisible(true);
                            }
                        });
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

    public void logarSistema() {
        // Verificar a autenticação do usuário
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Implemente aqui a lógica de autenticação

        // Exemplo simples de autenticação
        if (username.equals("admin") && password.equals("senha123")) {
            loginEfetuado = true;
            dispose(); // Fechar a janela de login

            // Abrir a tela do menu principal após o login
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new MenuPrincipalFrame();
                }
            });
        } else {
            JOptionPane.showMessageDialog(null, "Usuário ou senha estão incorretos. Por favor, verifique suas informações e tente novamente!\nCaso ainda não possua cadastro pressione o botão \"Cadastre-se\".", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginCadastroFrame();
            }
        });
    }*/
}
