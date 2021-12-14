package com.cg.shopping.profileservice.controller;

import com.cg.shopping.profileservice.entity.UserProfile;
import com.cg.shopping.profileservice.service.UserProfileService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/profile")
@AllArgsConstructor
public class ProfileController {
    
    private final UserProfileService userprofileservice ;

    @PostMapping(value = "/createNewCustomer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserProfile> addNewCustomer(@RequestBody UserProfile userProfile) {
        userProfile.setRole("ROLE_USER");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userprofileservice.addNewUserProfile(userProfile));
    }

    @PostMapping(value = "/createNewMerchant", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserProfile> addNewMerchant(@RequestBody UserProfile userProfile) {
        userProfile.setRole("USER_MERCHANT");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userprofileservice.addNewUserProfile(userProfile));
    }


    @PostMapping(value = "/createNewDeliveryProfile", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserProfile> addNewDeliveryProfile(@RequestBody UserProfile userProfile) {
        userProfile.setRole("ROLE_MERCHANT");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userprofileservice.addNewUserProfile(userProfile));
    }
    @GetMapping(value = "/allUserProfiles", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserProfile>> getAllUserProfiles() {
        return ResponseEntity.ok(userprofileservice.getAllUserProfiles());
    }


    @GetMapping(value = "/{profileId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserProfile> getById(@RequestParam (value = "profileId") int profileId ) {
        return ResponseEntity.ok(userprofileservice.getByProfileId(profileId));
    }

    @GetMapping(value = "/mobile/{mobilePhone}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserProfile> getAllByMobilePhone(@RequestParam (value = "mobilePhone") long mobilePhone ) {
        return ResponseEntity.ok(userprofileservice.getByMobileNumber(mobilePhone));
    }

    @GetMapping(value = "/username/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserProfile> getByName(@RequestParam (value = "userName") String userName ) {
        return ResponseEntity.ok(userprofileservice.getByUserName(userName));
    }

    @PutMapping(value = "/updateProfile", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateProfile(@RequestBody UserProfile userProfile) {
    	userprofileservice.updateUserProfile(userProfile);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/delete/{profileId}")
    public ResponseEntity<Void> deleteProfile(@RequestParam(value = "profileId") int profileId) {
    	userprofileservice.deleteUserProfile(profileId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
