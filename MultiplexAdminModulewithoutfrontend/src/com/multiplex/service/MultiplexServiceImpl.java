package com.multiplex.service;

import java.util.List;

import com.multiplex.dao.MultiplexDAO;
import com.multiplex.dao.MultiplexDAOImpl;
import com.multiplex.model.Hall;
import com.multiplex.model.Movies;
import com.multiplex.model.Show;
import com.multiplex.model.ShowSeats;
import com.multiplex.model.User;
import com.multiplex.mail.*;

public class MultiplexServiceImpl implements MultiplexService {

	@Override
	public int signUpService(User u) {
		int res=0;
		MultiplexDAOImpl mpl=new MultiplexDAOImpl();
		res=mpl.signUpDAO(u);
		return res;
	}

	@Override
	public List<Movies> listMoviesService() {
		MultiplexDAOImpl mpl=new MultiplexDAOImpl();
		return mpl.listMoviesDAO();
	}

	@Override
	public int delMovieService(int mid) {
		// TODO Auto-generated method stub
		MultiplexDAOImpl mpl=new MultiplexDAOImpl();
		int res=mpl.delMovie(mid);
		return res;
	}

	@Override
	public int addMovieService(Movies m) {
		// TODO Auto-generated method stub
		MultiplexDAOImpl mpl=new MultiplexDAOImpl();
		int res=mpl.addMovie(m);
		return res;
	}

	@Override
	public int editMovieService(Movies m) {
		MultiplexDAOImpl mpl=new MultiplexDAOImpl();
		int res=mpl.editMovie(m);
		return res;
	}

	@Override
	public Movies getOneMovieService(int mid) {
		MultiplexDAOImpl mpl=new MultiplexDAOImpl();
		System.out.println("mid from service"+mid);
		Movies m=mpl.getMovie(mid);
		return m;
		
	}

	@Override
	public List<Hall> listHallsService() {
		// TODO Auto-generated method stub
		MultiplexDAOImpl mpl=new MultiplexDAOImpl();
		return mpl.listHalls();
		
		
	}

	@Override
	public int addHallService(Hall h) {
		MultiplexDAOImpl mpl=new MultiplexDAOImpl();
		int res=mpl.addHall(h);
		return res;
	}

	@Override
	public int delHallService(int hid) {
		MultiplexDAOImpl mpl=new MultiplexDAOImpl();
		int res=mpl.delHall(hid);
		return res;
	}

	@Override
	public Hall getOneHallService(int hid) {
		MultiplexDAOImpl mpl=new MultiplexDAOImpl();
		Hall h=mpl.getHall(hid);
		return h;
		
	}

	@Override
	public int editHallService(Hall h) {
		MultiplexDAOImpl mpl=new MultiplexDAOImpl();
		int res=mpl.editHall(h);
		return res;
	}

	@Override
	public List<Show> listShowssService() {
		MultiplexDAOImpl mpl=new MultiplexDAOImpl();
		return mpl.listShowsDAO();
	}

	@Override
	public int addShowservice(Show s) {
		// TODO Auto-generated method stub
		MultiplexDAOImpl mpl=new MultiplexDAOImpl();
		int res=mpl.addShow(s);
		return res;
	}

	@Override
	public Show getOneShowService(int sid) {
		MultiplexDAOImpl mpl=new MultiplexDAOImpl();
		Show s=mpl.getShow(sid);
		return s;
	}

	@Override
	public int editShowService(Show s) {
		MultiplexDAOImpl mpl=new MultiplexDAOImpl();
		int res=mpl.editShow(s);
		return res;
	}

	@Override
	public int delShowService(int sid) {
		MultiplexDAOImpl mpl=new MultiplexDAOImpl();
		int res=mpl.delShow(sid);
		return res;
	}

	@Override
	public int sendMailService(String s) {
		maii m=new maii();
		int r=m.sendMail(s);
		return r;
	}

	@Override
	public User checkValidUserService(String s) {
		// TODO Auto-generated method stub
		
		MultiplexDAOImpl mpl=new MultiplexDAOImpl();
		return mpl.validUser(s);
		
	}

	@Override
	public int resetPasswordService(User u) {
		// TODO Auto-generated method stub
		MultiplexDAOImpl mpl=new MultiplexDAOImpl();
		return mpl.resetPass(u);
	}

	@Override
	public int checkNamePwd(String name, String pwd) {
		// TODO Auto-generated method stub
		MultiplexDAOImpl mpl=new MultiplexDAOImpl();
		return mpl.checkCredentials(name, pwd);
	}

	@Override
	public List<Show> listMovieShowsService(int mid) {
		// TODO Auto-generated method stub
		MultiplexDAOImpl mpl=new MultiplexDAOImpl();
		return mpl.getMovDet(mid);
	}

	@Override
	public ShowSeats listShowSeatsService(int sid) {
		// TODO Auto-generated method stub
		MultiplexDAOImpl mpl=new MultiplexDAOImpl();
		return mpl.getNoOfSeats(sid);
	}

	@Override
	public int updateShowSeatsService(int s, int g, int p, int sid) {
		// TODO Auto-generated method stub
		MultiplexDAOImpl mpl=new MultiplexDAOImpl();
		return mpl.updateShowSeats(s,g,p,sid);
	}

}
