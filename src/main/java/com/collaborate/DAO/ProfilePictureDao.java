package com.collaborate.DAO;

import com.collaborate.Model.ProfilePicture;

public interface ProfilePictureDao {
	void saveProfilePicture(ProfilePicture profilePicture);
	ProfilePicture getProfilePicture(String username);
	
}

