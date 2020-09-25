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
@WebServlet("/Osap/*")						// * means -> all url with osap 
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
		resOut.write("Query String: " + clientQueryString + "\n");  // [check this part
		resOut.write("Query Param foo= " + foo + "\n");
		
		String uri = request.getRequestURI().toString(); 		// URI 
		resOut.write("Request URI: " + uri + "\n");
		
		//
		
		String servletPath = request.getServletPath();			// servlet path [this reads the web.xml file]
		resOut.write("Request Servlet Path: " + servletPath + "\n");
		
		ServletContext context = this.getServletContext();
		resOut.write("---Application info---\n");
		
		String appName = this.getServletContext().getInitParameter("applicationName");					// application name
		resOut.write("Application Name= " + appName + "\n");
		
		String applicant = this.getServletContext().getInitParameter("applicantName");					// applicant Name
		resOut.write("Applicant Name= " + applicant + "\n");
		
		// input from web.xml [this are the built-in/hard-coded values]
		double principal = Double.parseDouble(this.getServletContext().getInitParameter("principal"));  // this reads the web.xml file and returns the parameter value of the param-name
		double interest = Double.parseDouble(this.getServletContext().getInitParameter("interest"));
		double period =  Double.parseDouble(this.getServletContext().getInitParameter("period"));
		
		// input from query String [these are the user input values]
		double sPrincipal = Double.parseDouble(request.getParameter("principal"));
		double sPeriod = Double.parseDouble(request.getParameter("period"));
		double dInterest = Double.parseDouble(request.getParameter("interest"));
		
//		resOut.write("Principal= " + principal + "\n");     // fix this 

		String contextPath = context.getContextPath();
		resOut.write("Context Path= " + contextPath + "\n");
		
		String realPath = context.getRealPath("Osap");
		resOut.write("Real Path= " + realPath + "\n");
		
		if (principal == 0 || this.getServletContext().getInitParameter("principal") == null) {
			principal = sPrincipal;
		}
		if (interest == 0 || this.getServletContext().getInitParameter("interest") == null) {
			interest = dInterest;
		}
		if (period == 0 || request.getParameter("period") == null) {
			period = sPeriod;
		}

		// task D osap monthly payments, make parameters period, interest in web.xml 		
		resOut.write("Based on Principal = " + sPrincipal);
		resOut.write(" period=" + sPeriod);
		resOut.write(" Interest=" + dInterest +"\n");
		
		
		// the formula for osap calculation 	[fix this formula ]
		double calc = (((dInterest/100) / 12) * sPrincipal) / (1 - Math.pow(1 + ((dInterest/100) / 12), -sPeriod));  
		resOut.write("Monthly payments: " + calc);

//		(dinterest/12) * sprincipal 
//		-----------------------------
//		1 - ((1 + (dinterest/12))^(-speriod))
		
		
		
		// task E : save session 
		request.getSession().setAttribute("sPrincipal", principal);   // see this in details 
		request.getSession().setAttribute("dInterest", interest);
		request.getSession().setAttribute("sPeriod", period);
		
		
//		debugs 
		System.out.println("principal " + principal);
		System.out.println("period " + period);
		System.out.println("interest " + interest);
		System.out.println("calc: " + calc);
		System.out.println("------------------------------------------");
		System.out.println("sprincipal = " + sPrincipal);
		System.out.println("speriod = " + sPeriod);
		System.out.println("dinterest = " + dInterest);
		System.out.println("calc = " + calc);
		
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
