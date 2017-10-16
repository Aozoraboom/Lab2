package tutorial;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class addauthor extends ActionSupport {
	 private Pattern p = Pattern.compile("\\?");
	    ServletRequest request = ServletActionContext.getRequest();
	    HttpServletRequest req = (HttpServletRequest) request;
	    HttpSession session = req.getSession();
  //mmmmmzz
	    private String name;
	    private String age;
	    private String country;
	    private String authorid;
	    public String getName()  
	    {  
	     return name;  
	    }  
	    public void setName(String name) {
	        this.name = name;
	    }
	    public String getAge()  
	    {  
	     return age;  
	    }  
	    public void setAge(String age) {
	        this.age = age;
	    }
	    public String getCountry()  
	    {  
	     return country;  
	    }  
	    public void setCountry(String country) {
	        this.country = country;
	    }
	    public String getAuthorid()  
	    {  
	     return authorid;  
	    }  
	    public void setAuthorid(String authorid) {
	        this.authorid = authorid;
	    }
	
	 public String execute(){
		  if(name==null||age==null||country==null||authorid==null)
			  return "FAILED";
	        String[] sql=new String[5];
	        sql[0]="insert into Author(AuthorID,Name,Age,Country) values(?,?,?,?)";
	        Matcher m1 = p.matcher(sql[0]);
	        sql[1] = m1.replaceFirst('"'+authorid+'"');
	        m1 = p.matcher(sql[1]);
	        sql[2] = m1.replaceFirst('"'+name+'"');
	        m1 = p.matcher(sql[2]);
	        sql[3] = m1.replaceFirst('"'+age+'"');
	        m1 = p.matcher(sql[3]);
	        sql[4] = m1.replaceFirst('"'+country+'"');
	        DBconnect connect = new DBconnect();
	        int signal=connect.insert(sql[4]);
	        if(signal==1){
	                return "SUCCESS";
	        }
	        else
	            return "FAILED";
	    }
}
