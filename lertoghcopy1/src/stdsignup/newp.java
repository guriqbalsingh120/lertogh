package stdsignup;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myconnection.connection;

/**
 * Servlet implementation class newp
 */
@WebServlet("/newp")
public class newp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		

		response.setContentType("text/html");
		String pass = request.getParameter("passn");
		
		HttpSession ss = request.getSession();
		 String email = (String)ss.getAttribute("femail").toString();
		 
		 try
		 {
		 connection cn = new connection();
		    cn.ps = cn.myconn().prepareStatement("update student set pass1=? where email=?");
		    cn.ps.setString(1, pass);
		    cn.ps.setString(2, email) ;
		    cn.ps.executeUpdate();
		    ss.invalidate();
		   response.sendRedirect("index.jsp");
		       
		    	   
		    
		 }
		 catch(Exception a)
		 {
			 a.printStackTrace();
	}
	}

}
