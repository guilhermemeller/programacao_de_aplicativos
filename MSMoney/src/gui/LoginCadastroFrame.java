package gui;

import javax.swing.*;

import entities.Usuario;
import service.UsuarioService;
import utils.DadosUsuario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;

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
	private JPanel dadosloginPanel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel label;
	private JLabel label_1;
	private JPanel botoesloginPanel;
	private JButton loginButton;
	private JButton cadastrarButton;
	private JPanel dadoscadastroPanel;
	private JLabel nomeLabel;
	private JLabel novoUsernameLabel;
	private JLabel novoPasswordLabel;
	private JButton cadastrarUsuarioButton;
	private JButton voltarButton;

	public LoginCadastroFrame() {
		initComponents();
	}

	public boolean isLoginEfetuado() {
		return loginEfetuado;
	}

	public boolean isCadastroRealizado() {
		return cadastroRealizado;
	}

	public void cadastrarUsuario() {
		String nome = nomeField.getText();
		String novoUsername = novoUsernameField.getText();
		String novaSenha = new String(novoPasswordField.getPassword());

		Usuario usuario = new Usuario(novoUsername, novaSenha, nome);
		UsuarioService uService = new UsuarioService();
		try {
			uService.cadastrarUsuario(usuario);
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
			cadastroRealizado = true;
		} catch (SQLException | IOException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}

		// Limpar os campos após o cadastro
		nomeField.setText("");
		novoUsernameField.setText("");
		novoPasswordField.setText("");

		// Alternar para a tela de login após o cadastro
		cadastroPanel.setVisible(false);
		loginPanel.setVisible(true);
	}

	public void logarSistema() {
		String username = usernameField.getText();
		String password = new String(passwordField.getPassword());

		UsuarioService uService = new UsuarioService();

		// Verificar a autenticação do usuário
		try {
			if (uService.verificarLogin(username, password)) {
				loginEfetuado = true;	
				
				uService.atualizarIdUsuario(username, password);
				
				dispose(); // Fechar a janela de login

				// Abrir a tela do menu principal após o login
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						new MenuPrincipalFrame();
					}
				});
			} else {
				JOptionPane.showMessageDialog(null,
						"Usuário ou senha estão incorretos. Por favor, verifique suas informações e tente novamente!\nCaso ainda não possua cadastro pressione o botão \"Cadastre-se\".",
						"Erro", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException | IOException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}

	}
	
	public void initComponents() {
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

		dadoscadastroPanel = new JPanel();
		cadastroPanel.add(dadoscadastroPanel, BorderLayout.CENTER);
		dadoscadastroPanel.setLayout(null);

		nomeLabel = new JLabel("Nome:");
		nomeLabel.setBounds(45, 25, 50, 14);
		dadoscadastroPanel.add(nomeLabel);
		nomeField = new JTextField();
		nomeField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					cadastrarUsuario();
				}
			}
		});
		nomeField.setBounds(88, 22, 206, 20);
		dadoscadastroPanel.add(nomeField);
		nomeField.setColumns(25);

		novoUsernameLabel = new JLabel("Usuário:");
		novoUsernameLabel.setBounds(35, 56, 50, 14);
		dadoscadastroPanel.add(novoUsernameLabel);
		novoUsernameField = new JTextField();
		novoUsernameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					cadastrarUsuario();
				}
			}
		});
		novoUsernameField.setBounds(88, 53, 206, 20);
		dadoscadastroPanel.add(novoUsernameField);
		novoUsernameField.setColumns(25);

		novoPasswordLabel = new JLabel("Senha:");
		novoPasswordLabel.setBounds(43, 87, 50, 14);
		dadoscadastroPanel.add(novoPasswordLabel);
		novoPasswordField = new JPasswordField();
		novoPasswordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					cadastrarUsuario();
				}
			}
		});
		novoPasswordField.setBounds(88, 84, 206, 20);
		dadoscadastroPanel.add(novoPasswordField);
		novoPasswordField.setColumns(25);

		// Adicionar os painéis à janela principal
		getContentPane().setLayout(new CardLayout());
		getContentPane().add(loginPanel);

		dadosloginPanel = new JPanel();
		loginPanel.add(dadosloginPanel, BorderLayout.CENTER);
		dadosloginPanel.setLayout(null);

		usernameLabel = new JLabel("Usuário:");
		usernameLabel.setBounds(36, 36, 60, 14);
		dadosloginPanel.add(usernameLabel);
		usernameField = new JTextField();
		usernameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					logarSistema();
				}
			}
		});
		usernameField.setBounds(89, 33, 206, 20);
		dadosloginPanel.add(usernameField);
		usernameField.setColumns(25);

		passwordLabel = new JLabel("Senha:");
		passwordLabel.setBounds(44, 80, 60, 14);
		dadosloginPanel.add(passwordLabel);

		label = new JLabel("");
		label.setBounds(319, 15, 0, 0);
		dadosloginPanel.add(label);
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					logarSistema();
				}
			}
		});
		passwordField.setBounds(89, 77, 206, 20);
		dadosloginPanel.add(passwordField);
		passwordField.setColumns(25);

		label_1 = new JLabel("");
		label_1.setBounds(277, 40, 0, 0);
		dadosloginPanel.add(label_1);

		botoesloginPanel = new JPanel();
		loginPanel.add(botoesloginPanel, BorderLayout.SOUTH);
		botoesloginPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		loginButton = new JButton("Login");
		loginButton.setBackground(new Color(221, 249, 226));
		botoesloginPanel.add(loginButton);
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				logarSistema();
			}
		});

		cadastrarButton = new JButton("Cadastre-se");
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

		cadastrarUsuarioButton = new JButton("Cadastrar");
		cadastrarUsuarioButton.setBackground(new Color(221, 249, 226));
		botoescadastroPanel.add(cadastrarUsuarioButton);

		voltarButton = new JButton("Voltar");
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
				cadastrarUsuario();
			}
		});

		// Definir a tela de cadastro como oculta inicialmente
		cadastroPanel.setVisible(false);

		// Exibir a janela
		setVisible(true);
	}
}
