package gui;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Color;

import action.CadastrarClienteAction;
import action.RemoveClienteAction;
import dao.KoalaDAO;
import pojo.Cliente;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.ScrollPaneConstants;
import java.awt.GridLayout;

public class ClientePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNome;
	private JTextField textTelefone;
	private JTextField textEmail;
	private CardLayout card;

	private DefaultTableModel modelo = new DefaultTableModel();
	private JTextField textId;
	private JTable tabelaClientes;

	public CardLayout getCard() {
		return card;
	}

	public Cliente getClienteInsert() {
		return new Cliente(textNome.getText(), textTelefone.getText(), textEmail.getText());
	}
	
	public Cliente getClienteFind(){
		return new Cliente(Integer.parseInt(textId.getText()), textNome.getText(), textTelefone.getText(),
				textEmail.getText());
	}

	public void limpar() {
		textNome.setText("");
		textTelefone.setText("");
		textEmail.setText("");
		textId.setText("");
	}

	/**
	 * Create the panel.
	 */
	public ClientePanel() {
		setBackground(Color.WHITE);
		setLayout(new MigLayout("", "[300px,grow]",
				"[44px][21px][27px][21px][27px][21px][27px][25px,grow][grow][][][][][][][][][][grow]"));

		JLabel lblCadastroDeCliente = new JLabel("Cadastro de Cliente");
		lblCadastroDeCliente.setFont(new Font("Segoe UI Light", Font.PLAIN, 35));
		add(lblCadastroDeCliente, "cell 0 0,grow");

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		add(lblNome, "cell 0 1,alignx left,aligny top");

		textNome = new JTextField();
		textNome.setBackground(Color.LIGHT_GRAY);
		textNome.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		add(textNome, "cell 0 2,growx,aligny top");
		textNome.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		add(lblTelefone, "cell 0 3,alignx left,aligny top");

		textTelefone = new JTextField();
		textTelefone.setBackground(Color.LIGHT_GRAY);
		textTelefone.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		add(textTelefone, "cell 0 4,growx,aligny top");
		textTelefone.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		add(lblEmail, "flowx,cell 0 5,alignx left,aligny top");

		textEmail = new JTextField();
		textEmail.setBackground(Color.LIGHT_GRAY);
		textEmail.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		add(textEmail, "cell 0 6,growx,aligny top");
		textEmail.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		add(panel_1, "cell 0 7,grow");
		panel_1.setLayout(new MigLayout("", "[grow][][][][][][][][][][][][][][][][][][][]", "[][][][]"));

		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		panel_1.add(lblCdigo, "cell 0 0");

		Box horizontalBox = Box.createHorizontalBox();
		panel_1.add(horizontalBox, "cell 19 0");

		textId = new JTextField();
		textId.setEditable(false);
		textId.setBackground(Color.LIGHT_GRAY);
		textId.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		panel_1.add(textId, "cell 0 1 19 1,growx");
		textId.setColumns(10);

		JButton btnCadastrar = new JButton(new CadastrarClienteAction(this));
		btnCadastrar.setToolTipText("Cadastrar");
		btnCadastrar.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		panel_1.add(btnCadastrar, "cell 0 3");

		JButton btnExcluir = new JButton(new RemoveClienteAction(this));
		btnExcluir.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		panel_1.add(btnExcluir, "cell 2 3");

		JButton btnPesquisar = new JButton();
		btnPesquisar.setText("Pesquisar");
		btnPesquisar.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		panel_1.add(btnPesquisar, "cell 4 3");

		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		panel_1.add(btnEditar, "cell 6 3");

		JPanel panel = new JPanel();
		add(panel, "cell 0 8 1 10,grow");
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		tabelaClientes = new JTable();
		tabelaClientes.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));

		criaTabela();

		JScrollPane barraDeRolagemTabela = new JScrollPane();
		barraDeRolagemTabela.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		barraDeRolagemTabela.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(barraDeRolagemTabela);

		barraDeRolagemTabela.setViewportView(tabelaClientes);

		tabelaClientes.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tabelaClientes.getSelectedRow();
				System.out.println("Linha -- " + linha);
				textId.setText(Integer.toString((int) tabelaClientes.getValueAt(linha, 0)));
				textNome.setText((String) tabelaClientes.getValueAt(linha, 1));
				textTelefone.setText((String) tabelaClientes.getValueAt(linha, 2));
				textEmail.setText((String) tabelaClientes.getValueAt(linha, 3));
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

	}

	private void criaTabela() {
		tabelaClientes = new JTable(getModelo());
		tabelaClientes.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		getModelo().addColumn("Id");
		getModelo().addColumn("Nome");
		getModelo().addColumn("Telefone");
		getModelo().addColumn("Email");
		tabelaClientes.getColumnModel().getColumn(0).setPreferredWidth(10);
		tabelaClientes.getColumnModel().getColumn(1).setPreferredWidth(120);
		tabelaClientes.getColumnModel().getColumn(1).setPreferredWidth(80);
		tabelaClientes.getColumnModel().getColumn(1).setPreferredWidth(120);
		preencherTabela(getModelo());

	}

	public void preencherTabela(DefaultTableModel modelo) {

		modelo.setNumRows(0);
		KoalaDAO dao = new KoalaDAO();
		for (Cliente c : dao.getClientes()) {
			modelo.addRow(
					new Object[] { c.getIdCliente(), c.getNomeCliente(), c.getTelefoneCliente(), c.getEmailCliente() });
		}
	}

	protected void valorSelecionado(MouseEvent e) {
		int linha = tabelaClientes.getSelectedRow();
		textId.setText(Integer.toString((int) tabelaClientes.getValueAt(linha, 0)));
		textNome.setText(Integer.toString((int) tabelaClientes.getValueAt(linha, 1)));
		textTelefone.setText(Integer.toString((int) tabelaClientes.getValueAt(linha, 2)));
		textId.setText(Integer.toString((int) tabelaClientes.getValueAt(linha, 3)));
	}

	public DefaultTableModel getModelo() {
		return modelo;
	}

	public void setModelo(DefaultTableModel modelo) {
		this.modelo = modelo;
	}

}
