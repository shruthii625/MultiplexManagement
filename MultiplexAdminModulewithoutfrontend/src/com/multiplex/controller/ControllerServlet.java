package com.multiplex.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.multiplex.model.Hall;
import com.multiplex.model.Movies;
import com.multiplex.model.Show;
import com.multiplex.model.ShowSeats;
import com.multiplex.model.User;
import com.multiplex.service.MultiplexServiceImpl;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet(urlPatterns={"*.do","*.doo"})
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/login.do")) {
		    System.out.println("login");
			String name=request.getParameter("uname");
			String pwd=request.getParameter("pwd");
		 if (name.length() == 0 || pwd.length() == 0) {
			 request.setAttribute("errorString", "Please enter name and password!");
			 RequestDispatcher dispatcher 
             = this.getServletContext().getRequestDispatcher("/WEB-INF/views/signIn.jsp");

     dispatcher.forward(request, response);
	        } 
		 
		 else if(name.equals("admin") && pwd.contentEquals("admin")){
			 HttpSession session = request.getSession(true);
			 session.setAttribute("validadmin","yes");
			 RequestDispatcher dispatcher 
             = this.getServletContext().getRequestDispatcher("/WEB-INF/views/adminMenu.jsp");
			 
     dispatcher.forward(request, response);
		 }
		 else {
			 HttpSession session = request.getSession(true);
			 session.setAttribute("validuser","yes");
			 session.setAttribute("validadmin","no");

			 MultiplexServiceImpl mpl=new MultiplexServiceImpl();
			 int r=mpl.checkNamePwd(name,pwd);
			 if(r==1) {
				 
					List<Movies>mov=mpl.listMoviesService();
					request.setAttribute("movielist", mov);
			 RequestDispatcher dispatcher 
             = this.getServletContext().getRequestDispatcher("/WEB-INF/views/userMenu.jsp");

     dispatcher.forward(request, response);
			 }
			 else {
				 System.out.println("invalid user");
				 RequestDispatcher dispatcher 
	             = this.getServletContext().getRequestDispatcher("/WEB-INF/views/signUp.jsp");

	     dispatcher.forward(request, response);
			 }
		 }
		}
		
		else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/") || request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/signshow.do")) {
			System.out.println("in post");
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/signUp.jsp");
			rd.forward(request,response);
			
	}
		else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/bookmov.doo")) {
			MultiplexServiceImpl mpl=new MultiplexServiceImpl();
			
			List<Show> show=mpl.listMovieShowsService(Integer.parseInt(request.getParameter("mid")));
			request.setAttribute("showlist", show);
			System.out.println(show);
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/userShow.jsp");
			rd.forward(request,response);
		
		}
		else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/selectedshow.doo")) {
			MultiplexServiceImpl mpl=new MultiplexServiceImpl();
			ShowSeats s=mpl.listShowSeatsService(Integer.parseInt(request.getParameter("sel")));
			request.setAttribute("showseatsobj", s);
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/userBook.jsp");
			rd.forward(request,response);
		
		}
		
		else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/bookfinal.doo")) {
			MultiplexServiceImpl mpl=new MultiplexServiceImpl();
			ShowSeats s1=mpl.listShowSeatsService(Integer.parseInt(request.getParameter("id")));
			int s=Integer.parseInt(request.getParameter("sseat"));
			int g=Integer.parseInt(request.getParameter("gseat"));
			int p=Integer.parseInt(request.getParameter("pseat"));
			
			int res=mpl.updateShowSeatsService(s1.getSseats()-s,s1.getGseats()-g,s1.getPseats()-p,s1.getShowId());
			int price=s*200+g*300+p*400;
			request.setAttribute("price", price);
		}
		
		else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/home.do")) {
			String success=null;
	
			String name=request.getParameter("uname");
			String pwd=request.getParameter("pwd");
			String email=request.getParameter("email");
			if(name.length()==0 || pwd.length()==0 || email.length()==0 || request.getParameter("phone").length()==0) {
				request.setAttribute("errorString", "Please enter all details!");
				 RequestDispatcher dispatcher 
	             = this.getServletContext().getRequestDispatcher("/WEB-INF/views/signUp.jsp");

	     dispatcher.forward(request, response);
			}
			long phone=Long.parseLong(request.getParameter("phone"));
			
			//long userid=(long)this.getServletContext().getAttribute("userid");
			//userid+=1;
			User u=new User();
			u.setUserName(name);
			u.setPassword(pwd);
			u.setEmail(email);
			u.setContactNo(phone);
			//u.setUserId(userid);
			MultiplexServiceImpl mpl=new MultiplexServiceImpl();
			int r=mpl.signUpService(u);
			if(r==1) {
				request.setAttribute("success", "Thank You! Log in to book tickets!");
				RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/signUp.jsp");
				rd.forward(request,response);
			}
			else {
				PrintWriter pw=response.getWriter();
				pw.append("Error");
			}
		}
		else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/loginpage.do")) {
			 RequestDispatcher dispatcher 
             = this.getServletContext().getRequestDispatcher("/WEB-INF/views/signIn.jsp");
			 dispatcher.forward(request,response);
		}
		else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/movies.do")){
			System.out.println("movies.do");
			MultiplexServiceImpl mpl=new MultiplexServiceImpl();
			List<Movies>mov=mpl.listMoviesService();
			request.setAttribute("movielist", mov);
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/showMovies.jsp");
			rd.forward(request,response);
			
		}
		else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/listmov.do")) {
			 HttpSession session = request.getSession();
			 String s=(String) session.getAttribute("valid");
			 
			System.out.println("listmov.do");
			request.setAttribute("addistrue","no");
			RequestDispatcher rd=request.getRequestDispatcher("movies.do");
			rd.forward(request,response);
		}
		else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/addmov.do")) {
			request.setAttribute("addistrue","yes");
			RequestDispatcher rd=request.getRequestDispatcher("movies.do");
			rd.forward(request,response);
		}
		else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/addhall.do")) {
			request.setAttribute("addistrue","yes");
			RequestDispatcher rd=request.getRequestDispatcher("listallhalls.do");
			rd.forward(request,response);
		}
		else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/justlisthall.do")) {
			request.setAttribute("addistrue","no");
			RequestDispatcher rd=request.getRequestDispatcher("listallhalls.do");
			rd.forward(request,response);
		}
		else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/listallhalls.do")) {
			System.out.println("listallhalls.do");
			MultiplexServiceImpl mpl=new MultiplexServiceImpl();
			List<Hall> halls=mpl.listHallsService();
			request.setAttribute("halllist", halls);
			System.out.println("HALLS+=="+halls);
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/Halls.jsp");
			rd.forward(request,response);
		}
		else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/addhalltotab.do")) {
			MultiplexServiceImpl mpl=new MultiplexServiceImpl();
			Hall h=new Hall();
			h.setHallName(request.getParameter("addname"));
			h.setStandardNum(Integer.parseInt(request.getParameter("addstan")));
			h.setGoldNum(Integer.parseInt(request.getParameter("addgold")));
			h.setPremiumNum(Integer.parseInt(request.getParameter("addprem")));
			int r=mpl.addHallService(h);
			if(r!=0) {
				
			response.sendRedirect("justlisthall.do");
			
		}
			else {
				PrintWriter p=response.getWriter();
				p.append("Error");
			}
		}
		else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/addmovtotab.do")) {
			MultiplexServiceImpl mpl=new MultiplexServiceImpl();
			Movies m=new Movies();
			m.setMovieName(request.getParameter("addname"));
			m.setMovieDetails(request.getParameter("adddesc"));
			m.setMovieGenre(request.getParameter("addgen"));
			int r=mpl.addMovieService(m);
			if(r!=0) {
				
			response.sendRedirect("listmov.do");
			
		}
			else {
				PrintWriter p=response.getWriter();
				p.append("Error");
			}
		}
		else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/delmovie.do")) {
			MultiplexServiceImpl mpl=new MultiplexServiceImpl();
			String s=request.getParameter("movietobedel");
			System.out.println("Deleting"+Integer.parseInt(s));
			int res=mpl.delMovieService(Integer.parseInt(s));
			if(res!=0) {
			RequestDispatcher rd=request.getRequestDispatcher("listmov.do");
			rd.forward(request,response);
			}
			else {
				PrintWriter pw=response.getWriter();
				pw.append("Some error");
			}
		}
		else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/logout.do")) {
			HttpSession session=request.getSession();

			session.removeAttribute("valid");
			HttpServletResponse res=(HttpServletResponse) response;
			 res.sendRedirect("/MultiplexAdminModulewithoutfrontend/");
		}
		else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/editmovie.do")) {
			
				String s=request.getParameter("movietobeedited");
				System.out.println("EDITID="+Integer.parseInt(s));
				MultiplexServiceImpl mpl=new MultiplexServiceImpl();
				Movies m=new Movies();
				m=mpl.getOneMovieService(Integer.parseInt(s));
				System.out.println("MOvie"+m.getMovieID());
				request.setAttribute("Editthis", m);
				RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/Edit.jsp");
				rd.forward(request,response);
				
		}
		else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/edithall.do")) {
			
			String s=request.getParameter("halltobeedited");
			System.out.println("hallEDITID="+Integer.parseInt(s));
			MultiplexServiceImpl mpl=new MultiplexServiceImpl();
			Hall h=new Hall();
			h=mpl.getOneHallService(Integer.parseInt(s));
			
			request.setAttribute("Editthis", h);
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/EditHall.jsp");
			rd.forward(request,response);
			
	}
		
		else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/edittodb.do")) {
			Movies m=new Movies();
			System.out.println("MNAME+"+request.getParameter("editmname"));
			m.setMovieName(request.getParameter("editmname"));
			m.setMovieDetails(request.getParameter("editmdet"));
			m.setMovieGenre(request.getParameter("editmgen"));
			//System.out.println(request.getParameter("editid"));
			m.setMovieID(Integer.parseInt(request.getParameter("editid")));
			System.out.println("M from edoit to db"+m);
			MultiplexServiceImpl mpl=new MultiplexServiceImpl();
			int r=mpl.editMovieService(m);
			if(r!=0) {
				RequestDispatcher rd=request.getRequestDispatcher("listmov.do");
				rd.forward(request, response);
			}
		}
		else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/edithalltodb.do")) {
			Hall h=new Hall();
			h.setHallName(request.getParameter("edithname"));
			h.setHallId(Integer.parseInt(request.getParameter("editid")));
			h.setStandardNum(Integer.parseInt(request.getParameter("editsnum")));
			h.setPremiumNum(Integer.parseInt(request.getParameter("editpnum")));
			h.setGoldNum(Integer.parseInt(request.getParameter("editgnum")));
			
			MultiplexServiceImpl mpl=new MultiplexServiceImpl();
			int r=mpl.editHallService(h);
			if(r!=0) {
				RequestDispatcher rd=request.getRequestDispatcher("justlisthall.do");
				rd.forward(request, response);
			}
		}
		else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/delhall.do")) {
			MultiplexServiceImpl mpl=new MultiplexServiceImpl();
			String s=request.getParameter("halltobedel");
			System.out.println("Deleting"+Integer.parseInt(s));
			int res=mpl.delHallService(Integer.parseInt(s));
			if(res!=0) {
			RequestDispatcher rd=request.getRequestDispatcher("justlisthall.do");
			rd.forward(request,response);
			}
			else {
				PrintWriter pw=response.getWriter();
				pw.append("Some error");
			}
		}
		else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/listshows.do")) {
			
			MultiplexServiceImpl mpl=new MultiplexServiceImpl();
			List<Show> show=mpl.listShowssService();
			request.setAttribute("showlist", show);
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/showShows.jsp");
			rd.forward(request,response);
		}
		else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/addshow.do")) {
			request.setAttribute("addistrue","yes");
			MultiplexServiceImpl mpl=new MultiplexServiceImpl();
			List<Movies>mov=mpl.listMoviesService();
			List<Hall> halls=mpl.listHallsService();
			request.setAttribute("halllist", halls);
			request.setAttribute("movielist", mov);
			RequestDispatcher rd=request.getRequestDispatcher("listshows.do");
			rd.forward(request,response);
		}
		else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/addshowtotab.do")) {
			MultiplexServiceImpl mpl=new MultiplexServiceImpl();
			Show s=new Show();
			s.setMid(Integer.parseInt(request.getParameter("movieshow")));
			s.setHid(Integer.parseInt(request.getParameter("hallshow")));
			s.setStarttime(request.getParameter("stime"));
			s.setEndtime(request.getParameter("etime"));
			s.setDate(request.getParameter("sdate"));
			int r=mpl.addShowservice(s);
			if(r!=0) {
				
			response.sendRedirect("listshows.do");
			
		}
			else {
				PrintWriter p=response.getWriter();
				p.append("Error");
			}
			
		}
	else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/editshow.do")) {
			
			
			MultiplexServiceImpl mpl=new MultiplexServiceImpl();
			Show s=new Show();
			s=mpl.getOneShowService(Integer.parseInt(request.getParameter("showtobeedited")));
			List<Movies>mov=mpl.listMoviesService();
			List<Hall> halls=mpl.listHallsService();
			request.setAttribute("halllist", halls);
			request.setAttribute("movielist", mov);
			request.setAttribute("Editthis",s);
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/EditShow.jsp");
			rd.forward(request,response);
			
	}
	else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/editshowtotab.do")) {
		Show s=new Show();
		s.setShowId(Integer.parseInt(request.getParameter("sidd")));
		s.setMid(Integer.parseInt(request.getParameter("movieshow")));
		s.setStarttime(request.getParameter("stime"));
		s.setEndtime(request.getParameter("etime"));
		s.setHid(Integer.parseInt(request.getParameter("hallshow")));
		s.setDate(request.getParameter("sdate"));
		
		MultiplexServiceImpl mpl=new MultiplexServiceImpl();
		int r=mpl.editShowService(s);
		if(r!=0) {
			RequestDispatcher rd=request.getRequestDispatcher("listshows.do");
			rd.forward(request, response);
		}
		
	}	
	else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/delshow.do")) {
		MultiplexServiceImpl mpl=new MultiplexServiceImpl();
		String s=request.getParameter("showtobedel");
		int res=mpl.delShowService(Integer.parseInt(s));
		if(res!=0) {
		RequestDispatcher rd=request.getRequestDispatcher("listshows.do");
		rd.forward(request,response);
		}
		else {
			PrintWriter pw=response.getWriter();
			pw.append("Some error");
		}
	}
	else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/forgot.do")) {
		request.setAttribute("invalidmail", "nu");
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/ForgotMail.jsp");
		rd.forward(request,response);
	}
	else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/sendmail.do")) {
		MultiplexServiceImpl mpl=new MultiplexServiceImpl();
		PrintWriter pw=response.getWriter();
		String s=request.getParameter("mailsend");
		User u=new User();
		u=mpl.checkValidUserService(s);
		ServletContext context=getServletContext();  
		if(u!=null) {
			context.setAttribute("userinfo",u);
		int res=mpl.sendMailService(s);
		
		if(res!=0) {
			System.out.println("res==="+res);
			context.setAttribute("CODE",res);  
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/EnterCode.jsp");
			rd.forward(request,response);
		}
		else {
			request.setAttribute("invalidmail", "yes");
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/ForgotMail.jsp");
			rd.forward(request,response);		}
	}
		else {
			request.setAttribute("invalidmail", "yes");
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/ForgotMail.jsp");
			rd.forward(request,response);
		}
		}
	else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/checkcode.do")) {
		System.out.println("whyyyy");
		ServletContext context=getServletContext();  
		int n=(int)context.getAttribute("CODE"); 
		context.removeAttribute("CODE");
		if(Integer.parseInt(request.getParameter("code"))==n) {
			
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/ResetPassword.jsp");
			rd.forward(request,response);
		}
		else {
			
			request.setAttribute("wrongcode", "yes");
			System.out.println(context.getAttribute("userinfo"));
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/EnterCode.jsp");
			rd.forward(request,response);
		}
	}
	else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/resendcode.do")) {
		User u= new User();
		ServletContext context=getServletContext(); 
		u=(User)context.getAttribute("userinfo");
		System.out.println("U+"+u);
		String m = u.getEmail();
		PrintWriter pw= response.getWriter();
		MultiplexServiceImpl mpl=new MultiplexServiceImpl();
		System.out.println("mailll===="+m);
		int res=mpl.sendMailService(m);
		if(res!=0) {
			context.setAttribute("CODE",res);  
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/EnterCode.jsp");
			rd.forward(request,response);
		}
		else {
			pw.append("fail");
		}
		
	}
	else if(request.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/reset.do")) {
		ServletContext context=getServletContext();  
		
		User us=new User();
		us=(User)context.getAttribute("userinfo");
		//us.setUserId(uid);
		us.setPassword(request.getParameter("pwd"));
		MultiplexServiceImpl mpl=new MultiplexServiceImpl();
		
		int r=mpl.resetPasswordService(us);
		if(r!=0) {
		
			request.setAttribute("SUCCESS", "PASSWORD RESET SUCCESSFUL!!!");
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/signIn.jsp");
			rd.forward(request,response);
		}
	}
	}
}
	







