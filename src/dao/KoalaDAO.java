package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Cliente;
import pojo.Servico;

public class KoalaDAO {

	private Connection db;
	private Statement statement;
	private PreparedStatement st;
	private ResultSet rs;
	private Cliente cliente;
	private Servico servico;

	public void conecta() throws Exception {
		Class.forName("org.sqlite.JDBC");
		db = DriverManager.getConnection("jdbc:sqlite:bdKoala.db");
		setStatement(db.createStatement());
		db.setAutoCommit(false);
		db.setAutoCommit(true);

	}

	public void desconecta() {
		try {
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void insertCliente(Cliente cliente) {
		String cmd = "INSERT INTO cliente (nomeCliente, telefoneCliente, emailCliente) VALUES (?, ?, ?)";

		db = null;
		st = null;

		try {
			conecta();

			st = db.prepareStatement(cmd);

			st.setString(1, cliente.getNomeCliente());
			st.setString(2, cliente.getTelefoneCliente());
			st.setString(3, cliente.getEmailCliente());
			int r = st.executeUpdate();

			if (r != 1) {
				throw new RuntimeException("Erro ao inserir Cliente!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		desconecta();
	}

	public void refreshCliente(Cliente cliente) {
		String cmd = "UPDATE Cliente SET nomeCliente=?, telefoneCliente=?, emailCliente=? WHERE idCliente=?";

		db = null;
		st = null;

		try {
			conecta();

			st = db.prepareStatement(cmd);

			st.setString(1, cliente.getNomeCliente());
			st.setString(2, cliente.getTelefoneCliente());
			st.setString(3, cliente.getEmailCliente());
			st.setInt(5, cliente.getIdCliente());
			int r = st.executeUpdate();

			if (r != 1) {
				throw new RuntimeException("Erro ao atualizar Cliente!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		desconecta();
	}

	public void deleteCliente(int idcliente) {
		String cmd = "DELETE FROM Cliente WHERE idCliente=?";

		db = null;
		st = null;

		try {
			conecta();

			st = db.prepareStatement(cmd);

			st.setInt(1, idcliente);
			int r = st.executeUpdate();
			
			if (r != 1) {
				throw new RuntimeException("Erro ao atualizar Cliente!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		desconecta();
	}
	
	public void deleteServico(int idServico) {
		String cmd = "DELETE FROM Servicos WHERE idServico=?";

		db = null;
		st = null;

		try {
			conecta();

			st = db.prepareStatement(cmd);

			st.setInt(1, idServico);
			int r = st.executeUpdate();
			
			if (r != 1) {
				throw new RuntimeException("Erro ao atualizar Cliente!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		desconecta();
	}

	// public Cliente findClienteByID(int idCliente) {
	// String cmd = "SELECT*FROM CONTATO WHERE idCliente=?";
	//
	// db = null;
	// st = null;
	// rs = null;
	// cliente = null;
	//
	// try {
	// conecta();
	//
	// st = db.prepareStatement(cmd);
	//
	// st.setInt(1, cliente.getIdCliente());
	// int r = st.executeUpdate();
	//
	// while (rs.next()) {
	// cliente.setIdCliente(rs.getInt("id"));
	// cliente.setNomeCliente(rs.getString("nome"));
	// cliente.setTelefoneCliente(rs.getString("telefone"));
	// cliente.setEmailCliente(rs.getString("email"));
	// }
	//
	// if (r != 1) {
	// throw new RuntimeException("Erro ao atualizar Cliente!");
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// desconecta();
	//
	// return cliente;
	// }

//	public ArrayList<Cliente> getCliente() {
//		String cmd = "SELECT*FROM cliente";
//
//		db = null;
//		st = null;
//		rs = null;
//		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
//
//		try {
//			conecta();
//
//			st = db.prepareStatement(cmd);
//
//			st.setInt(1, cliente.getIdCliente());
//			int r = st.executeUpdate();
//			
//
//			while (rs.next()) {
//				Cliente cliente = new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("telefone"), rs.getString("email"));
//				
//				clientes.add(cliente);
//			}
//
//			if (r != 1) {
//				throw new RuntimeException("Erro ao buscar Clientes!");
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		desconecta();
//
//		return clientes;
//	}

	public void insertServico(Servico servico) {
		String cmd = "INSERT INTO servicos (nomeServico) VALUES (?)";

		db = null;
		st = null;

		try {
			conecta();

			st = db.prepareStatement(cmd);
			st.setString(1, servico.getNomeServico());
			int r = st.executeUpdate();

			if (r != 1) {
				throw new RuntimeException("Erro ao inserir Servico!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		desconecta();
	}

	public List<Cliente> getClientes() {
		String cmd = "SELECT * FROM Cliente";

		db = null;
		st = null;
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			conecta();

			st = db.prepareStatement(cmd);
			rs = st.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente(rs.getInt("idCliente"), rs.getString("nomeCLiente"),
						rs.getString("telefoneCliente"), rs.getString("emailCliente"));
				clientes.add(cliente);
			}
			desconecta();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientes;
	}
	
	public List<Cliente> getClientesOrderNome() {
		String cmd = "SELECT * FROM Cliente order by nomeCliente";

		db = null;
		st = null;
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			conecta();

			st = db.prepareStatement(cmd);
			rs = st.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente(rs.getInt("idCliente"), rs.getString("nomeCLiente"),
						rs.getString("telefoneCliente"), rs.getString("emailCliente"));
				clientes.add(cliente);
			}
			desconecta();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientes;
	}
	
	
	public List<Servico> getServicos() {
		String cmd = "SELECT * FROM servicos";

		db = null;
		st = null;
		ArrayList<Servico> servicos = new ArrayList<Servico>();
		try {
			conecta();

			st = db.prepareStatement(cmd);
			rs = st.executeQuery();

			while (rs.next()) {
				Servico servico = new Servico(rs.getInt("idServico"), rs.getString("nomeServico"));
				servicos.add(servico);
			}
			desconecta();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return servicos;
	}

	public List<Servico> getServicosOrderNome() {
		String cmd = "SELECT * FROM servicos ORDER BY nomeServico";

		db = null;
		st = null;
		ArrayList<Servico> servicos = new ArrayList<Servico>();
		try {
			conecta();

			st = db.prepareStatement(cmd);
			rs = st.executeQuery();

			while (rs.next()) {
				Servico servico = new Servico(rs.getInt("idServico"), rs.getString("nomeServico"));
				servicos.add(servico);
			}
			desconecta();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return servicos;
	}

//	public List<Cliente> getClientesByNome(String nome) {
//		String cmd = "SELECT * FROM Cliente where nomeCliente=?";
//
//		db = null;
//		st = null;
//		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
//		try {
//			conecta();
//
//			st = db.prepareStatement(cmd);
//			st.setString(1, nome);
//			int r = st.executeUpdate();
//
//			while (rs.next()) {
//				Cliente cliente = new Cliente(rs.getInt("idCliente"), rs.getString("nomeCLiente"),
//						rs.getString("telefoneCliente"), rs.getString("emailCliente"), rs.getBoolean("ativoCliente"));
//				clientes.add(cliente);
//			}
//			if (r != 1) {
//				throw new RuntimeException("Erro ao buscar clientes por nome!");
//			}
//			desconecta();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return clientes;
//	}
//
//	public List<Cliente> getClientesByFull(String nome, String telefone, String email) {
//		String cmd = "SELECT * FROM Cliente where nomeCliente=?";
//
//		db = null;
//		st = null;
//		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
//		try {
//			conecta();
//
//			st = db.prepareStatement(cmd);
//			st.setString(1, nome);
//			int r = st.executeUpdate();
//
//			while (rs.next()) {
//				Cliente cliente = new Cliente(rs.getInt("idCliente"), rs.getString("nomeCLiente"),
//						rs.getString("telefoneCliente"), rs.getString("emailCliente"), rs.getBoolean("ativoCliente"));
//				clientes.add(cliente);
//			}
//			if (r != 1) {
//				throw new RuntimeException("Erro ao buscar clientes por nome!");
//			}
//			desconecta();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return clientes;
//	}
//
//	public Cliente getClientesById(String idString) {
//		String cmd = "SELECT * FROM Cliente where idCliente=?";
//
//		int id = Integer.parseInt(idString);
//
//		db = null;
//		st = null;
//
//		try {
//			conecta();
//
//			st = db.prepareStatement(cmd);
//			st.setInt(1, id);
//			int r = st.executeUpdate();
//
//			Cliente cliente = new Cliente(rs.getInt("idCliente"), rs.getString("nomeCLiente"),
//					rs.getString("telefoneCliente"), rs.getString("emailCliente"), rs.getBoolean("ativoCliente"));
//
//			if (r != 1) {
//				throw new RuntimeException("Erro ao buscar clientes por código!");
//			}
//			desconecta();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return cliente;
//	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}
}
