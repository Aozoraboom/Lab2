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

public class show  extends ActionSupport {
	 private Pattern p = Pattern.compile("\\?");

	   private List<String> list = new LinkedList<String>();
	    private List<String> list0 = new LinkedList<String>();
	    ServletRequest request = ServletActionContext.getRequest();
	    HttpServletRequest req = (HttpServletRequest) request;
	    HttpSession session = req.getSession();
	            private String name;
	            private String title;
	
	      public String getName()  
	      {  
	       return name;  
	      }  
	       
	      public void setName(String name)  
	      {  
	       this.name = name;  
	      }  
	      public String getTitle()  
	      {  
	       return title;  
	      }  
	       
	      public void setTitle(String title)  
	      {  
	       this.title = title;  
	      }  
	       
	 public String execute(){
		 String sql0 ="select * from Author where Name=?";
	        Matcher m1 = p.matcher(sql0);
	        String sql1 = m1.replaceFirst('"'+name+'"');
	        DBconnect connect = new DBconnect();
	        list0=connect.select(sql1);
	        session.setAttribute("list0", list0);
	        String sql2 ="select * from Book where Title=?";
	        Matcher m2 = p.matcher(sql2);
	        String sql3 = m2.replaceFirst('"'+title+'"');
	        list=connect.select(sql3);
	        session.setAttribute("list", list);
	        if(list.size()==0)
	            return "FAILED";
	        else
	            return "SUCCESS";
}
}