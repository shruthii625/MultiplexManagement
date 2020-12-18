package com.multiplex.service;

import java.util.List;

import com.multiplex.model.Hall;
import com.multiplex.model.Movies;
import com.multiplex.model.Show;
import com.multiplex.model.ShowSeats;
import com.multiplex.model.User;

public interface MultiplexService {

	int signUpService(User u);
	List <Movies> listMoviesService();
	int delMovieService(int mid);
	int addMovieService(Movies m);
	int editMovieService(Movies m);
	Movies getOneMovieService(int mid);
	List<Hall> listHallsService();
	int addHallService(Hall h);
	int delHallService(int hid);
	Hall getOneHallService(int hid);
	int editHallService(Hall h);
	List<Show> listShowssService();
	int addShowservice(Show s);
	Show getOneShowService(int sid);
	int editShowService(Show s);
	int delShowService(int sid);
	int sendMailService(String s);
	User checkValidUserService(String s);
	int resetPasswordService(User u);
	int checkNamePwd(String name,String pwd);
	List<Show> listMovieShowsService(int mid);
	ShowSeats listShowSeatsService(int sid);
	int updateShowSeatsService(int s, int g, int p, int sid);
}
