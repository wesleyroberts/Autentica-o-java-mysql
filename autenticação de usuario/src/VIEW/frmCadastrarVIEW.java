package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.CadastrarDAO;
import DTO.CadastrarDTO;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmCadastrarVIEW extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSenha;
	private JButton btnVoltar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCadastrarVIEW frame = new frmCadastrarVIEW();
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
	public frmCadastrarVIEW() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Nome");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 34, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		txtNome = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, txtNome, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtNome, -51, SpringLayout.EAST, contentPane);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtNome, -9, SpringLayout.NORTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 93, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_1);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome, senha;
				nome= txtNome.getText();
				senha= txtSenha.getText();
			CadastrarDTO	objusuariodto = new CadastrarDTO();	
			objusuariodto.setNome_cadastro(nome);
			objusuariodto.setSenha_cadastro(senha);
			
			CadastrarDAO objcadastardao=new CadastrarDAO();
			objcadastardao.cadastrarUsuario(objusuariodto);
			
			
			
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnCadastrar, 159, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnCadastrar, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(btnCadastrar);
		
		txtSenha = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtSenha, 6, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtSenha, 0, SpringLayout.WEST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtSenha, 373, SpringLayout.WEST, contentPane);
		txtSenha.setColumns(10);
		contentPane.add(txtSenha);
		
		btnVoltar = new JButton("voltar para Login");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLoginView objfrmloginview = new frmLoginView();
				objfrmloginview.setVisible(true);
				dispose();
				
			}
		});
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnVoltar, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnVoltar, -10, SpringLayout.EAST, contentPane);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel_2 = new JLabel("TELA DE CADASTRO");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 158, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_2);
	}
	
		
}
