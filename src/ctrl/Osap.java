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
		resOut.write("\n");										// optional for new line 
		resOut.write("Hello, World!\n");
		
		String clientIP = request.getRemoteAddr();				// client IP
		resOut.write("Client IP: " + clientIP + "\n");
		
		int cPort = request.getLocalPort();						// client port   or  request.getServerPort();[check this one as well]
		resOut.write("Client Port: " + cPort + "\n");
		
		String cProtocol = request.getProtocol();		    	// protocol 
		resOut.write("Client Protocol: " + cProtocol + "\n");
		
		String cMethod = request.getMethod();					// method 
		resOut.write("Client Method: " + cMethod + "\n");
		
		
		String clientQueryString = request.getQueryString();	// querystring   
		String foo = request.getParameter("foo");								// [check this part]
		resOut.write("Query String: " + foo + "=" + clientQueryString + "\n");  // [check this part
		resOut.write("Query Param foo= " + foo + "\n");
		
		String uri = request.getRequestURI().toString(); 		// URI 
		resOut.write("Request URI: " + uri + "\n");
		
		String servletPath = request.getServletPath();			// servlet path 
		resOut.write("Request Servlet Path: " + servletPath + "\n");
		
		ServletContext context = this.getServletContext();
		double principal = Double.parseDouble(this.getServletContext().getInitParameter("principal"));  // check this 
		
		String contextPath = context.getContextPath();
		String realPath = context.getRealPath("Osap");
		
		
		// task D osap Calc fomula
		
		
		
		
		
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
