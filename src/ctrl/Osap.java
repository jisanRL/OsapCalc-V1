package ctrl;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Osap
 */
@WebServlet("/Osap/*")				// check this part 
public class Osap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Osap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// task 7 (p-2), to respond to the client with a message  
		response.setContentType("text/plain");
		Writer resOut = response.getWriter();
		resOut.write("Hello, World!\n");
		
		String clientIP = request.getRemoteAddr();
		resOut.write("Client IP: " + clientIP + "\n");
		String clientQueryString = request.getQueryString();
		String foo = request.getParameter("foo");
		resOut.write("Query Param foo= " + foo + "\n");
		
		ServletContext context = this.getServletContext();
		double principal = Double.parseDouble(this.getServletContext().getInitParameter("principal"));  // check this 
		
		String contextPath = context.getContextPath();
		String realPath = context.getRealPath("Osap");
		
		System.out.println("Hello, Got a GET request from Osap!");    // task7
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
