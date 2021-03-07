package com.company;

public class CreateProfile {
    public static UserProfileDetails createProfile(String userName, String password, String fullName,
                                                   String phone, String email, String village, String postOffice,
                                                   String thana, String district, String zipCode,
                                                   String education, String workExperience,
                                                   String hobby, String favouriteColor, String favouriteFood){
        UserProfileDetails user = new UserProfileDetails();
        user.setUserName(userName);
        user.setPassword(password);
        user.setFullName(fullName);
        user.setPhone(phone);
        user.setEmail(email);
        user.address.setVillage(village);
        user.address.setPostOffice(postOffice);
        user.address.setThana(thana);
        user.address.setDistrict(district);
        user.address.setZipCode(zipCode);
        user.userExperience.setEducation(education);
        user.userExperience.setWorkExperience(workExperience);
        user.userDetails.setHobby(hobby);
        user.userDetails.setFavouriteColor(favouriteColor);
        user.userDetails.setFavouriteFood(favouriteFood);

        return user;
    }
}
