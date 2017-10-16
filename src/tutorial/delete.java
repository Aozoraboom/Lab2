package tutorial;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class delete extends ActionSupport{
	 private Pattern p = Pattern.compile("\\?");

	    ServletRequest request = ServletActionContext.getRequest();
	    HttpServletRequest req = (HttpServletRequest) request;
	    HttpSession session = req.getSession();
	    private String isbn;
	    public String getIsbn()  
	      {  
	       return isbn;  
	      }  
	       
	      public void setIsbn(String isbn)  
	      {  
	       this.isbn = isbn;  
	      }  
	 public String execute(){
	        String sql0 ="delete from Book where ISBN=?";
	        Matcher m1 = p.matcher(sql0);
	        String sql1 = m1.replaceFirst('"'+isbn+'"');
	        DBconnect connect = new DBconnect();
	        int signal=connect.delete(sql1);
	        if(signal==1)
	            return "SUCCESS";
	        else
	            return "FAILED";
	    }
}
