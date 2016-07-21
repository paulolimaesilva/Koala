package gui;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Color;

import action.CadastrarServicoAction;
import action.RemoveServicoAction;
import dao.KoalaDAO;
import pojo.Servico;

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

public class ServicoPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNome;
	private CardLayout card;

	private DefaultTableModel modelo = new DefaultTableModel();
	private JTextField textId;
	private JTable tabelaServicos;

	public CardLayout getCard() {
		return card;
	}

	public Servico getServicoInsert() {
		return new Servico(textNome.getText());
	}
	
	public Servico getServicoFind(){
		return new Servico(Integer.parseInt(textId.getText()), textNome.getText());
	}

	public void limpar() {
		textNome.setText("");
		textId.setText("");
	}

	/**
	 * Create the panel.
	 */
	public ServicoPanel() {
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

		JButton btnCadastrar = new JButton(new CadastrarServicoAction(this));
		btnCadastrar.setToolTipText("Cadastrar");
		btnCadastrar.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		panel_1.add(btnCadastrar, "cell 0 3");

		JButton btnExcluir = new JButton(new RemoveServicoAction(this));
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

		tabelaServicos = new JTable();
		tabelaServicos.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));

		criaTabela();

		JScrollPane barraDeRolagemTabela = new JScrollPane();
		barraDeRolagemTabela.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		barraDeRolagemTabela.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(barraDeRolagemTabela);

		barraDeRolagemTabela.setViewportView(tabelaServicos);

		tabelaServicos.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tabelaServicos.getSelectedRow();
				System.out.println("Linha -- " + linha);
				textId.setText(Integer.toString((int) tabelaServicos.getValueAt(linha, 0)));
				textNome.setText((String) tabelaServicos.getValueAt(linha, 1));
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
		tabelaServicos = new JTable(getModelo());
		tabelaServicos.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		getModelo().addColumn("Id");
		getModelo().addColumn("Nome");
		tabelaServicos.getColumnModel().getColumn(0).setPreferredWidth(10);
		tabelaServicos.getColumnModel().getColumn(1).setPreferredWidth(120);
		preencherTabela(getModelo());

	}

	public void preencherTabela(DefaultTableModel modelo) {

		modelo.setNumRows(0);
		KoalaDAO dao = new KoalaDAO();
		for (Servico s : dao.getServicos()) {
			modelo.addRow(
					new Object[] { s.getIdServico(), s.getNomeServico()});
		}
	}

	protected void valorSelecionado(MouseEvent e) {
		int linha = tabelaServicos.getSelectedRow();
		textId.setText(Integer.toString((int) tabelaServicos.getValueAt(linha, 0)));
		textNome.setText(Integer.toString((int) tabelaServicos.getValueAt(linha, 1)));
	}

	public DefaultTableModel getModelo() {
		return modelo;
	}

	public void setModelo(DefaultTableModel modelo) {
		this.modelo = modelo;
	}

}
