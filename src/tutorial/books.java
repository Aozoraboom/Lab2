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

public class books  extends ActionSupport {

	   private List<String> list = new LinkedList<String>();
	    private List<String> list0 = new LinkedList<String>();

	    ServletRequest request = ServletActionContext.getRequest();
	    HttpServletRequest req = (HttpServletRequest) request;
	    HttpSession session = req.getSession();

	 public String execute(){
		 String sql0 ="select * from Author";
	        DBconnect connect = new DBconnect();
	        list0=connect.select(sql0);
	        session.setAttribute("list0", list0);
	        String sql2 ="select * from Book";
	        list=connect.select(sql2);
	        session.setAttribute("list", list);
	        return "SUCCESS";
}
}
