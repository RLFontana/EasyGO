package dal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dal.ConnectionFactory;
import model.Cliente;

public class ClienteDao {

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;

	public ClienteDao(){

	}

	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public List<Cliente> getClientes(){
		String sql = "SELECT * FROM cliente LEFT JOIN comanda ON cliente.Codigo=comanda.CodigoCliente";
		List<Cliente> retorno = new ArrayList<Cliente>();
		try{
			connection = getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if(resultSet.next()){
				do{
					retorno.add(new Cliente(resultSet.getInt("Codigo"), resultSet.getString("Nome"), resultSet.getInt("Telefone")));
				}while(resultSet.next());
			}
			return retorno;
		}catch (SQLException e){
			e.printStackTrace();
			return null;
		}finally{
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
