package tutorial;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class addbook extends ActionSupport {
	 private Pattern p = Pattern.compile("\\?");

	    private List<String> list = new LinkedList<String>();
	    private List<String> list0 = new LinkedList<String>();
	    ServletRequest request = ServletActionContext.getRequest();
	    HttpServletRequest req = (HttpServletRequest) request;
	    HttpSession session = req.getSession();

	    private String title;
	    private String isbn;
	    private String name;
	    private String publisher;
	    private String publishdate;
	    private String price;
	    private String authorid;
	    public String getTitle()  
	    {  
	     return title;  
	    }  
	     
	    public void setTitle(String title)  
	    {  
	     this.title = title;  
	    }  
	    public String getIsbn()  
	    {  
	     return isbn;  
	    }  
	     
	    public void setIsbn(String isbn)  
	    {  
	     this.isbn = isbn;  
	    }  
	    public String getName()  
	    {  
	     return name;  
	    }  
	     
	    public void setName(String name)  
	    {  
	     this.name = name;  
	    }  
	    public String getPublisher()  
	    { 
	     return publisher;  
	    }  
	     
	    public void setPublisher(String publisher)  
	    {  
	     this.publisher = publisher;  
	    }  

	    public String getPublishdate()  
	    {  
	     return publishdate;  
	    }  
	    public void setPublishdate(String publishdate) {
	        this.publishdate = publishdate;
	    }
	    public String getPrice()  
	    {  
	     return price;  
	    }  
	    public void setPrice(String price) {
	        this.price = price;
	    }
	    public String getAuthorid()  
	    {  
	     return authorid;  
	    }  
	    public void setAuthorid(String authorid) {
	        this.authorid = authorid;
	    }
	    
	    
	   public String execute(){
		    if(title==""||isbn==""||name==""||publisher==""||publishdate==""||price=="")
		    	{return "FAILED";}
	        String sql0="select * from Author where Name=?";
	        Matcher m1 = p.matcher(sql0);
	        String sql1 = m1.replaceFirst('"'+name+'"');
	        DBconnect connect = new DBconnect();
	        list=connect.select(sql1);
	        list0=connect.select("select AuthorID from Author");
	        if(list.size()==0){
	            if(list0.size()==0)
	                authorid="1";
	            else
	                authorid=String.valueOf(Integer.parseInt(Collections.max(list0))+1);
	        }
	        else
	            authorid=list.get(0);
	        if(list.size()==0)
	            return "ADD";
	        String sql="insert into Book(ISBN,Title,AuthorID,Publisher,PublishDate,Price) values(?,?,?,?,?,?)";
	        m1 = p.matcher(sql);
	        sql = m1.replaceFirst('"'+isbn+'"');
	        m1 = p.matcher(sql);
	        sql = m1.replaceFirst('"'+title+'"');
	        m1 = p.matcher(sql);
	        sql = m1.replaceFirst('"'+authorid+'"');
	        m1 = p.matcher(sql);
	        sql = m1.replaceFirst('"'+publisher+'"');
	        m1 = p.matcher(sql);
	        sql = m1.replaceFirst('"'+publishdate+'"');
	        m1 = p.matcher(sql);
	        sql = m1.replaceFirst('"'+price+'"');
	        int signal=connect.insert(sql);
	        if(signal==1)
	            return "SUCCESS";
	        else
	            return "FAILED";
	    }
	}

