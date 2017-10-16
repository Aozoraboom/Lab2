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

public class searchauthor extends ActionSupport{

private static final long serialVersionUID = 1L;
	private Pattern p = Pattern.compile("\\?");
	 private List<String> list = new LinkedList<String>();
	 private List<String> list0 = new LinkedList<String>();
	    ServletRequest request = ServletActionContext.getRequest();
	    HttpServletRequest req = (HttpServletRequest) request;
	    HttpSession session = req.getSession();
	    private String name=request.getParameter("name");
	    
	    public String getName() {
	        return name;
	    }
	    
	    public void setName(String name) {
	        this.name = name;
	    }
	    
	   public String execute() {
	        String sql0 ="select AuthorID from Author where Name=?";
	        Matcher m1 = p.matcher(sql0);
	        String sql1 = m1.replaceFirst('"'+ name+'"');
	        DBconnect connect = new DBconnect ();
	        list0=connect.select(sql1);
	        if(list0.size() == 0)
	            return "FAILED";
	        String sql2 ="select Title from Book where AuthorID=?";
	        Matcher m2 = p.matcher(sql2);
	        String sql = m2.replaceFirst('"'+list0.get(0)+'"');
	        list=connect.select(sql);
	        session.setAttribute("list", list);
	        session.setAttribute("name",name);
	        if(list.size() == 0)
	            return "FAILED";
	        else
	            return "SUCCESS";
	    }
}



