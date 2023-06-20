package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarExcluirCategoriaDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JPanel buttonPane;
    private JButton btnEditar;
    private JButton btnVoltar;
    private JButton btnExcluir;
    private JTextField txtNomeCategoria;
    private JLabel lblNome;
    private JLabel lblIcon;

    private String categoriaEditada;

    public EditarExcluirCategoriaDialog(String cSelect) {
        initComponents(cSelect);
    }

    public void initComponents(String cSelect) {
        setTitle("Editar ou Excluir Categoria");
        setBounds(100, 100, 380, 150);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            ImageIcon icon = (ImageIcon) UIManager.getIcon("OptionPane.warningIcon");
            lblIcon = new JLabel("", icon, JLabel.CENTER);
            lblIcon.setBounds(0, 0, 46, 46);
            contentPanel.add(lblIcon);
        }
        {
            lblNome = new JLabel("Digite o novo nome da categoria:");
            lblNome.setBounds(50, 14, 204, 14);
            contentPanel.add(lblNome);
        }
        {
            txtNomeCategoria = new JTextField();
            txtNomeCategoria.setText(cSelect);
            txtNomeCategoria.setBounds(50, 34, 270, 20);
            contentPanel.add(txtNomeCategoria);
            txtNomeCategoria.setColumns(20);
        }
        {
            buttonPane = new JPanel();
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
            {
                btnEditar = new JButton("Editar Categoria");
                btnEditar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnEditarActionPerformed();
                    }
                });
                buttonPane.add(btnEditar);
                getRootPane().setDefaultButton(btnEditar);
            }
            {
                btnVoltar = new JButton("Voltar");
                btnVoltar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
                buttonPane.add(btnVoltar);
            }
            {
                btnExcluir = new JButton("Excluir Categoria");
                btnExcluir.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		btnExcluirActionPerformed();
                	}
                });
                buttonPane.add(btnExcluir);
            }
        }
    }

    private void btnEditarActionPerformed() {
        if(!txtNomeCategoria.getText().equals("")) {
        	categoriaEditada = txtNomeCategoria.getText();
        	this.dispose();
        }else {
        	JOptionPane.showMessageDialog(txtNomeCategoria, "O campo deve estar preenchido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void btnExcluirActionPerformed() {
        categoriaEditada = "-1";
        this.dispose();
    }

    public String getCategoriaEditada() {
        return categoriaEditada;
    }
}