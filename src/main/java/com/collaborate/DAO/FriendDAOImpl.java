package com.collaborate.DAO;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaborate.Model.Friend;
import com.collaborate.Model.User;

@Repository
public class FriendDAOImpl implements FriendDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public List<User> listOfSuggestedUsers(String username) 
	{
		
		Session session=sessionFactory.openSession();
		SQLQuery sqlQuery=session.createSQLQuery("select * from users where username in " 
							 					+"(select username from users where username!=? "
												+"minus "
												+"(select fromId from friend_batch19 where toId=?"
												+"union "
												+"select toId from friend_batch19 where fromId=? ))");
		sqlQuery.setString(0, username);
		sqlQuery.setString(1, username);
		sqlQuery.setString(2, username);
		sqlQuery.addEntity(User.class);
		List<User> suggestedUsersList=sqlQuery.list();
		session.close();
		return suggestedUsersList;
		
	}
	
	public void friendRequest(String fromUsername, String toUsername){
		Session session=sessionFactory.openSession();
		Friend friend=new Friend();
		friend.setFromId(fromUsername);
		friend.setToId(toUsername);
		friend.setStatus('p');
		session.save(friend);
		session.flush();
		session.close();
	}

	
	public List<Friend> listOfPendingRequest(String toUsername)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where toId=? and status=?");
		query.setString(0, toUsername);
		query.setCharacter(1, 'p');
		List<Friend> pendingRequests=query.list();
		session.close();
		return pendingRequests;
	}

	public void updatePendingRequest(String fromId, String toId, char status) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("update Friend set status=? where fromId = ? and toId=? ");
		query.setCharacter(0, FromId);
		query.setString(1, ToId);
		query.setString(2, Status);
		query.executeUpdate();
		session.flush();
		session.close();
	}
 
	public List<Friend> listOfFriends(String Username)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where(fromId=? or toId=?) and status=?");
		query.setString(0, Username);
		query.setString(1, Username);
		query.setCharacter(2, 'A');
		List<Friend> friends=query.list();
		session.close();
		return friends;
	}
	
}