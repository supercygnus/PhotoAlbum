package site.photo.tool;

import java.sql.*;


public class JDBConnection {
	private final String dbDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private final String url="jdbc:sqlserver://localhost;integratedSecurity=true;DatabaseName=db_photo";
	private final String username="";
	private final String password="";
	private Connection conn = null;
	
	public JDBConnection(){
		try{
			Class.forName(dbDriver).newInstance();
		}
		catch(Exception e){
			System.err.println("連接失敗");
		}
	}
	
	public boolean createConnection(){
		try{
			conn=DriverManager.getConnection(url, username, password);
			return true;
		}
		catch(Exception e){
			System.err.println("取得連線失敗");
			return false;
		}
	}
	
	public boolean executeUpdate(String sql){
		
		if(conn==null)
			this.createConnection();
		
		try{
			Statement stmt=conn.createStatement();
			int count=stmt.executeUpdate(sql);
			System.out.println("執行成功,影響的記錄數為:"+count);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	public ResultSet executeQuery(String sql){
		
		ResultSet rs=null;
		if(conn==null)
			this.createConnection();
		try{
			Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=stmt.executeQuery(sql);
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return rs;
	}
	
	public void closeConnection(){
		if(conn!=null){
			try{
				conn.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		conn=null;
	}
	
	public static void main(String[] args){
		//JDBConnection jc=new JDBConnection();
		//System.out.println(jc.createConnection());
		
		try{
			int a=100;
			int b=a/0;
		}
		catch(Exception e){
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally{
			System.out.println("finally");
		}
		System.out.println("end");
	}
}
