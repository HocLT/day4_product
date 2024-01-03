package vn.aptech.dto.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.aptech.dto.ProductDto;

public class ProductDal {
	private Connection connectDb() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/demo";
		return DriverManager.getConnection(url, "root", "");
	}
	
	public List<ProductDto> findAll() {
		List<ProductDto> result = new ArrayList<>();
		try {
			Connection con = connectDb();
			String query = "SELECT id, name, price FROM products";
			PreparedStatement stm = con.prepareStatement(query);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				ProductDto p = new ProductDto();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPrice(rs.getInt(3));
				result.add(p);
			}
			rs.close();
			stm.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean create(ProductDto p) {
		boolean result = false;
		try {
			Connection con = connectDb();
			String query = "INSERT INTO products (name, price) VALUES (?,?)";
			PreparedStatement stm = con.prepareStatement(query);
			// truyền giá trị cho tham số ?
			stm.setString(1, p.getName());
			stm.setInt(2, p.getPrice());
			result = stm.executeUpdate() > 0;
			stm.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
