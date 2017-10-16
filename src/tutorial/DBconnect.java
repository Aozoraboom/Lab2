package tutorial;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException; 

import java.util.LinkedList;
import java.util.List;

public class DBconnect {
	static private String user = "root";
	static private String password = "19970908";
	private Connection con=null;  
	private PreparedStatement ps = null;  
	private ResultSet rs = null;
	public static Connection getConnection(){
			String URL="jdbc:mysql://localhost:3306/BookDB"; 
		//String URL="jdbc:mysql://acbzvdelcfwu.mysql.sae.sina.com.cn:10192/bookdb"; 
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL,user,password);
			
			}catch(ClassNotFoundException e){
				System.err.println(e.getMessage());
				System.exit(1);
			}catch(SQLException e){
				System.err.println(e.getMessage());
			} return conn;}
	public int insert(String sql)  
	{  
	    int i=0;  
	    /*String sql="insert into author(authorid,name,age,country) values(?,?,?,?)"; 
	    String sql0="insert into book(isbn,title,authorid,publisher,publishdate,price) values(?,?,?,?,?,?)";
	    */
	    Connection cnn=getConnection();  

	    try{  
	        PreparedStatement preStmt =cnn.prepareStatement(sql);  
	        i=preStmt.executeUpdate();  
	    }  
	    catch (SQLException e)  
	    {  
	        e.printStackTrace();  
	    }  
	    return i;//����Ӱ���������1Ϊִ�гɹ�  
	}  
	public int update(String sql)
	{  
	    int i=0;  
	    /*String sql="update author set  authorid=?,name=?,age=?,country=? where authorid=?";//ע��Ҫ��where����  
	    */
	    Connection cnn=getConnection();  
	    try{  
	        PreparedStatement preStmt =cnn.prepareStatement(sql);  
	        i=preStmt.executeUpdate();  
	    }  
	    catch (SQLException e)  
	    {  
	        e.printStackTrace();  
	    }  
	    return i;//����Ӱ���������1Ϊִ�гɹ�  
	}  
	public List<String> select(String sql)
	{  
	    int i;
	    Connection cnn = getConnection();//�˴�Ϊͨ���Լ�д�ķ���getConn()�������
	    List<String> list = new LinkedList<String>();
	    try  
	    {  
	        Statement stmt = cnn.createStatement();  
	        ResultSet rs = stmt.executeQuery(sql);  
	        while(rs.next())  
	        {  
	            for(i = 1;i<=rs.getMetaData().getColumnCount();i++){
	            list.add(rs.getString(i));}
	        }  
	     
	        //���Խ����ҵ���ֵд���࣬Ȼ�󷵻���Ӧ�Ķ���  
	    }  
	    catch (SQLException e)  
	    {  
	        e.printStackTrace();  
	    }  
	    return list;  
	}  
	public int delete(String sql)  
	{  
	    /*String sql = "delete from author where authorid=?"; */ 
	    int i=0;  
	    Connection conn = getConnection();//�˴�Ϊͨ���Լ�д�ķ���getConn()�������  
	    try  
	    {  
	        Statement stmt = conn.createStatement();  
	        i = stmt.executeUpdate(sql);  
	    }  
	    catch (SQLException e)  
	    {  
	        e.printStackTrace();  
	    }  
	    return i;//������ص���1����ִ�гɹ�;  
	}  
	
    private void close() {
        try {
          if (rs != null) {
            rs.close();
          }

          if (ps!= null) {
            ps.close();
          }

          if (con != null) {
            con.close();
          }
        } catch (Exception e) {

        }
      }
}
