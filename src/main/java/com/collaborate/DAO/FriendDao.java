package com.collaborate.DAO;

import java.util.List;

import com.collaborate.Model.Friend;
import com.collaborate.Model.User;

public interface FriendDao {

	List<User> listOfSuggestedUsers(String Username);
	void friendRequest(String fromUsername, String toUsername);
	List<Friend> listOfPendingRequest(String loggedInUsername);
	void updatePendingRequest(String fromId,String toId,char status);
	List<Friend> listOfFriends(String Username);
}