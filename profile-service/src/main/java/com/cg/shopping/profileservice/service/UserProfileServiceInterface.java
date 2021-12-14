package com.cg.shopping.profileservice.service;

import java.util.List;

import com.cg.shopping.profileservice.entity.UserProfile;

public interface UserProfileServiceInterface {
	
	
	  public UserProfile addNewUserProfile(UserProfile userProfile);
	  public List<UserProfile> getAllUserProfiles();
	   public UserProfile getByProfileId(int profileId);
	   public UserProfile getByMobileNumber(long mobileNumber);
	   public UserProfile getByUserName(String fullName);
	   public void updateUserProfile(UserProfile userProfile);
	   public void deleteUserProfile(int profileId);
	   public int getNextId();

}
