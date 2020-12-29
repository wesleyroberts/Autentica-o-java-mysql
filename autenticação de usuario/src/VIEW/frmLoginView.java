package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.UsuarioDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import DTO.UsuarioDTO;
import javax.swing.JPasswordField;
import java.awt.Button;
public class frmLoginView extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLoginView frame = new frmLoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmLoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel txtNomeUsuario = new JLabel("Nome de Usu\u00E1rio");
		sl_contentPane.putConstraint(SpringLayout.WEST, txtNomeUsuario, 15, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtNomeUsuario, -184, SpringLayout.SOUTH, contentPane);
		contentPane.add(txtNomeUsuario);
		
		txtUsuario = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtUsuario, 6, SpringLayout.SOUTH, txtNomeUsuario);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtUsuario, 0, SpringLayout.WEST, txtNomeUsuario);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtUsuario, -56, SpringLayout.EAST, contentPane);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel txtSenhaUsuario = new JLabel("Senha de Usu\u00E1rio");
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtSenhaUsuario, 6, SpringLayout.SOUTH, txtUsuario);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtSenhaUsuario, 0, SpringLayout.WEST, txtNomeUsuario);
		contentPane.add(txtSenhaUsuario);
		
		JButton btnEntrar = new JButton("Entrar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnEntrar, 32, SpringLayout.SOUTH, txtSenhaUsuario);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			Logar();		
								
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnEntrar, 0, SpringLayout.WEST, txtNomeUsuario);
		contentPane.add(btnEntrar);
		
		txtSenha = new JPasswordField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtSenha, 6, SpringLayout.SOUTH, txtSenhaUsuario);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtSenha, 0, SpringLayout.WEST, txtNomeUsuario);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtSenha, 403, SpringLayout.WEST, contentPane);
		contentPane.add(txtSenha);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnCadastrar, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnCadastrar, -10, SpringLayout.EAST, contentPane);
		contentPane.add(btnCadastrar);
		
		JLabel lblNewLabel = new JLabel("criar conta");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 4, SpringLayout.NORTH, btnCadastrar);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -6, SpringLayout.WEST, btnCadastrar);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("TELA DE LOGIN");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 188, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1);
	}
	
	// METODO 
	
	private void Logar() {
		try {
			String nome_usuario,senha_usuario;
			nome_usuario= txtUsuario.getText();
			senha_usuario= txtSenha.getText();
			/// criação do objeto
			UsuarioDTO objusuariodto= new UsuarioDTO();
			objusuariodto.setNome_usuario(nome_usuario);
			objusuariodto.setSenha_usuario(senha_usuario);
			
			UsuarioDAO objusuariodao= new UsuarioDAO();
			ResultSet rsusariodao = objusuariodao.autencicacaoUsuario(objusuariodto);
			
			if( rsusariodao.next()) {
				// chamar tela que quero abrir
				frmPrincipalVIEW objfrmprincipalview = new frmPrincipalVIEW();
				objfrmprincipalview.setVisible(true);
				dispose();
				}else {
				//enviar mensagem dizendo incorreto
				JOptionPane.showMessageDialog(null,"Usuário e Senha Inválida");
			}
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null,"FRMLOGINVIEW"+ erro);
		}
	}
		private void Cadastro() {
			frmCadastrarVIEW objfrmcadastrarview = new frmCadastrarVIEW();
			objfrmcadastrarview.setVisible(true);
			dispose();
		
	}
	}
	

