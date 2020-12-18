package com.multiplex.dao;

import java.util.List;

import com.multiplex.model.Hall;
import com.multiplex.model.Movies;
import com.multiplex.model.Show;
import com.multiplex.model.ShowSeats;
import com.multiplex.model.User;

public interface MultiplexDAO {

		int signUpDAO(User u);
		List<Movies> listMoviesDAO();
		int delMovie(int mid);
		int addMovie(Movies m);
		int editMovie(Movies m);
		Movies getMovie(int mid);
		List<Hall> listHalls();
		int addHall(Hall h);
		int delHall(int hid);
		Hall getHall(int hid);
		int editHall(Hall h);
		List<Show> listShowsDAO();
		int addShow(Show s);
		Show getShow(int sid);
		int editShow(Show s);
		int delShow(int sid);
		User validUser(String s);
		int resetPass(User u);
		int checkCredentials(String name, String pwd);
		List<Show> getMovDet(int mid);
		ShowSeats getNoOfSeats(int sid);
		int updateShowSeats(int s, int g, int p, int sid);
		}
