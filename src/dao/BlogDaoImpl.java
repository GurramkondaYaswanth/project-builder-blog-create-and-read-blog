package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Blog;
import utility.ConnectionManager;

public class BlogDaoImpl implements BlogDaoInterface{

	@Override
	public void insertBlog(Blog blog) throws SQLException {
		// TODO Auto-generated method stub
		String BlogInsertion = "insert into BLOGS(	BLOD_ID,BLOG_TITLE,BLOG_DESCRIPTION) VALUES (?,?,?)";

		Connection c = null;
		c = ConnectionManager.getConnection();
		//access the string
		PreparedStatement ps = c.prepareStatement(BlogInsertion);
		ps.setInt(1, blog.getBlogId());
		ps.setString(2,blog.getBlogTitle());
		ps.setString(3,blog.getBlogDescription());
		
	}

	@Override
	public List selectAllBlogs() throws SQLException {
		// TODO Auto-generated method stub
		List<Blog> list=new ArrayList<Blog>();
		
			Connection con = ConnectionManager.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM BLOGS");
			while(rs.next())
			{
				int id= rs.getInt(1);
				String name=rs.getString(2);
				String description =rs.getString(3);
				LocalDate date= LocalDate.now();
				Blog blog = new Blog(id,name,description,date);
				
				list.add(blog);
			}
			
			return list;
			
		}
}