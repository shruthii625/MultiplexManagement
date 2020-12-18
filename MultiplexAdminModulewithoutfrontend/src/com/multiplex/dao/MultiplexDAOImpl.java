package com.multiplex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.multiplex.model.Hall;
import com.multiplex.model.Movies;
import com.multiplex.model.Show;
import com.multiplex.model.ShowSeats;
import com.multiplex.model.User;
import com.multiplex.utils.ConnectionUtils;

public class MultiplexDAOImpl implements MultiplexDAO {

	@Override
	public int signUpDAO(User u) {
		int result=0;
		try {
			Connection con=ConnectionUtils.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into usersmul values(user_seq.nextval,?,?,?,?)");
			
			ps.setString(1,u.getUserName());
			ps.setString(2,u.getPassword());
			ps.setString(3,u.getEmail());
			ps.setLong(4,u.getContactNo());
			result = ps.executeUpdate();
			ps.close();
			con.close();

			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Movies> listMoviesDAO() {
		// TODO Auto-generated method stub
		
		List<Movies> mov=null;
		try {
			Connection con=ConnectionUtils.getConnection();
			String q="select * from movies";
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery(q);
			System.out.println("jjiiiiio");
			System.out.println(rs);
			if(rs!=null) {mov=new ArrayList<Movies>();}
			while(rs.next()) {
				Movies m=new Movies();
				
				m.setMovieID(rs.getInt(1));
				m.setMovieName(rs.getString(2));
				m.setMovieDetails(rs.getString(3));
				m.setMovieGenre(rs.getString(4));
				System.out.println(m);
				mov.add(m);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return mov;
	}

	@Override
	public int delMovie(int mid) {
		// TODO Auto-generated method stub
		int res=0;
		try {
			Connection con=ConnectionUtils.getConnection();
			String q="delete from movies where movid=?";
			System.out.println("Query is "+q);
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(1, mid);
			res=ps.executeUpdate();
			ps.close();
			con.close();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("returning "+res);
		return res;
	}

	@Override
	public int addMovie(Movies m) {
		int res=0;
		try {
			Connection con=ConnectionUtils.getConnection();
			String q="insert into movies values(mov_seq.nextval,?,?,?)";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1,m.getMovieName());
			ps.setString(2,m.getMovieDetails());
			ps.setString(3,m.getMovieGenre());
			res=ps.executeUpdate();
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int editMovie(Movies m) {
		// TODO Auto-generated method stub
		int r=0;
		try {
			Connection con=ConnectionUtils.getConnection();
			String q="update movies set moviename=?, moviedesc=?, moviegen=? where movid=?";
			PreparedStatement ps=con.prepareStatement(q);
			System.out.println("DAO gnere"+m.getMovieGenre());
			ps.setString(1,m.getMovieName());
			ps.setString(2,m.getMovieDetails());
			ps.setString(3,m.getMovieGenre());
			ps.setInt(4, m.getMovieID());
			r=ps.executeUpdate();
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return r;
	}

	@Override 
	public Movies getMovie(int mid) {
		// TODO Auto-generated method stub
		Movies m=new Movies();
		try {
			Connection con=ConnectionUtils.getConnection();
			String q="select * from movies where movid=?";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(1, mid);
			ResultSet rs=ps.executeQuery();
			rs.next();
			m.setMovieID(rs.getInt(1));
			m.setMovieName(rs.getString(2));
			m.setMovieDetails(rs.getString(3));
			m.setMovieGenre(rs.getString(4));
			System.out.println("m="+m);
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public List<Hall> listHalls() {
		List<Hall> mov=null;
		try {
			Connection con=ConnectionUtils.getConnection();
			String q="select * from halls";
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery(q);
			if(rs!=null) {mov=new ArrayList<Hall>();}
			while(rs.next()) {
				Hall h=new Hall();
				
				h.setHallId(rs.getInt(1));
				h.setHallName(rs.getString(2));
				h.setStandardNum(rs.getInt(3));
				h.setGoldNum(rs.getInt(4));
				h.setPremiumNum(rs.getInt(5));
				mov.add(h);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return mov;
	}

	@Override
	public int addHall(Hall h) {
		int res=0;
		try {
			Connection con=ConnectionUtils.getConnection();
			String q="insert into halls values(hall_seq.nextval,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1,h.getHallName());
			ps.setInt(2,h.getStandardNum());
			ps.setInt(3,h.getGoldNum());
			ps.setInt(4,h.getPremiumNum());
			res=ps.executeUpdate();
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int delHall(int hid) {
		int res=0;
		try {
			Connection con=ConnectionUtils.getConnection();
			String q="delete from halls where hallid=?";
			System.out.println("Query is "+q);
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(1, hid);
			res=ps.executeUpdate();
			ps.close();
			con.close();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("returning "+res);
		return res;
	}

	@Override
	public Hall getHall(int hid) {
		Hall h=new Hall();
		try {
			Connection con=ConnectionUtils.getConnection();
			String q="select * from halls where hallid=?";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(1, hid);
			ResultSet rs=ps.executeQuery();
			rs.next();
			h.setHallId(rs.getInt(1));
			h.setHallName(rs.getString(2));
			h.setStandardNum(rs.getInt(3));
			h.setGoldNum(rs.getInt(4));
			h.setPremiumNum(rs.getInt(5));
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return h;
	}

	@Override
	public int editHall(Hall h) {
		int r=0;
		try {
			Connection con=ConnectionUtils.getConnection();
			String q="update halls set hallName=?, sseat=?,gseat=?,pseat=? where hallid=?";
			PreparedStatement ps=con.prepareStatement(q);
		
			ps.setString(1,h.getHallName());
			ps.setInt(2,h.getStandardNum());
			ps.setInt(3,h.getGoldNum());
			ps.setInt(4, h.getPremiumNum());
			
			ps.setInt(5, h.getHallId());
			r=ps.executeUpdate();
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return r;
	}

	@Override
	public List<Show> listShowsDAO() {
		List<Show> show=null;
		try {
			Connection con=ConnectionUtils.getConnection();
			String q="select s.showid,m.moviename, h.hallname, s.starttime,s.endtime,s.showdate from shows s, movies m, halls h where s.movid=m.movid and s.hallid=h.hallid";
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery(q);
			if(rs!=null) {show=new ArrayList<Show>();}
			while(rs.next()) {
				Show S= new Show();
				S.setShowId(rs.getInt(1));
				S.setMname(rs.getString(2));
				S.setHname(rs.getString(3));
				S.setStarttime(rs.getString(4));
				S.setEndtime(rs.getString(5));
				S.setDate(rs.getString(6));
				show.add(S);
			} 
			s.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
  return show;
}

	@Override
	public int addShow(Show s) {
		int res=0;
		try {
			Connection con=ConnectionUtils.getConnection();
			String q="insert into shows values(show_seq.nextval,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(1,s.getMid());
			ps.setInt(2,s.getHid());
			ps.setString(3,s.getStarttime());
			ps.setString(4,s.getEndtime());
			ps.setString(5,s.getDate());
			
			
			res=ps.executeUpdate();
			Hall h= getHall(s.getHid());
			q="select max(showid) from shows";
			Statement ss=con.createStatement();
			ResultSet rs=ss.executeQuery(q);
			rs.next();
			int sid=rs.getInt(1);
			q="insert into showseats values(?,?,?,?)";
			ps=con.prepareStatement(q);
			ps.setInt(1,sid );
			ps.setInt(2, h.getStandardNum() );
			ps.setInt(3,h.getGoldNum());
			ps.setInt(4, h.getPremiumNum());
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public Show getShow(int sid) {
		Show s=new Show();
		try {
			Connection con=ConnectionUtils.getConnection();
			String q="select * from shows where showid=?";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(1, sid);
			ResultSet rs=ps.executeQuery();
			rs.next();
			s.setShowId(rs.getInt(1));
			s.setMid(rs.getInt(2));
			s.setHid(rs.getInt(3));
			s.setStarttime(rs.getString(4));
			s.setEndtime(rs.getString(5));
			s.setDate(rs.getString(6));
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public int editShow(Show s) {
		int r=0;
		try {
			Connection con=ConnectionUtils.getConnection();
			String q="update shows set movid=?, hallid=?,starttime=?,endtime=?, showdate=? where showid=?";
			PreparedStatement ps=con.prepareStatement(q);
		
		
			ps.setInt(1,s.getMid());
			ps.setInt(2,s.getHid());
			ps.setString(3,s.getStarttime());
			ps.setString(4, s.getEndtime());
			
			ps.setString(5, s.getDate());
			ps.setInt(6, s.getShowId());
			r=ps.executeUpdate();
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return r;
	}

	@Override
	public int delShow(int sid) {
		// TODO Auto-generated method stub
		int res=0;
		try {
			Connection con=ConnectionUtils.getConnection();
			String q="delete from shows where showid=?";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(1, sid);
			res=ps.executeUpdate();
			ps.close();
			con.close();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("returning "+res);
		return res;
	}

	@Override
	public User validUser(String s) {
		// TODO Auto-generated method stub
		User u=new User();
		
		try {
			Connection con=ConnectionUtils.getConnection();
			String q="select * from usersmul where umail=?";
			PreparedStatement p=con.prepareStatement(q);
			p.setString(1, s);
			ResultSet rs=p.executeQuery();
			if(rs!=null) {
				 rs.next();
				 u.setUserId(rs.getInt(1));
				 System.out.println(rs.getString(4));
				 u.setEmail(rs.getString(4));
				 return u;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public int resetPass(User u) {
		int r=0;
		try {
			Connection con=ConnectionUtils.getConnection();
			String q="update usersmul set upwd=? where userid=?";
			PreparedStatement ps=con.prepareStatement(q);
		
		
			ps.setString(1,u.getPassword());
			ps.setLong(2,u.getUserId());
			
			r=ps.executeUpdate();
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return r;
	}

	@Override
	public int checkCredentials(String name, String pwd) {
		// TODO Auto-generated method stub
		
		try {
			Connection con=ConnectionUtils.getConnection();
			String q="select * from usersmul where uname=? and upwd=?";
			PreparedStatement ps=con.prepareStatement(q);
		
		
			ps.setString(1,name);
			ps.setString(2,pwd);
			ResultSet rs=ps.executeQuery();
			if(rs!=null) {
				 rs.next();
				 System.out.println(rs.getInt(1));
				 System.out.println(rs.getString(2));
				 System.out.println(rs.getString(3));
				return 1;
			}
			
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return 0;
	}

	@Override
	public List<Show> getMovDet(int mid) {
		// TODO Auto-generated method stub
		List<Show> show=null;
		try {
			Connection con=ConnectionUtils.getConnection();
			String q="select s.showid,m.moviename, h.hallname, s.starttime,s.endtime,s.showdate from shows s, movies m, halls h where m.movid=s.movid and h.hallid=s.hallid and s.movid=?";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(1,mid);
			
			ResultSet rs=ps.executeQuery();
			if(rs!=null) {show=new ArrayList<Show>();}
			while(rs.next()) {
				Show S= new Show();
				S.setShowId(rs.getInt(1));
				S.setMname(rs.getString(2));
				S.setHname(rs.getString(3));
				S.setStarttime(rs.getString(4));
				S.setEndtime(rs.getString(5));
				S.setDate(rs.getString(6));
				show.add(S);
			} 
			ps.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
  return show;

		
	}

	@Override
	public ShowSeats getNoOfSeats(int sid) {
		ShowSeats s=new ShowSeats();
		try {
			Connection con=ConnectionUtils.getConnection();
			String q="select * from showseats where showid=?";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(1,sid);
			ResultSet rs=ps.executeQuery();
			rs.next();
			s.setShowId(sid);
			s.setSseats(rs.getInt(2));
			s.setGseats(rs.getInt(3));
			s.setPseats(rs.getInt(4));
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public int updateShowSeats(int s, int g, int p, int sid) {
		int r=0;
		try {
			Connection con=ConnectionUtils.getConnection();
			String q="update showseats set sseat=?, gseat=?, pseat=? where showid=?";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(1, s);
			ps.setInt(2, g);
			ps.setInt(3, p);
			ps.setInt(4, sid);
			r=ps.executeUpdate();
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return r;
	}

}
