package com.company;

public class CreateProfile {
    public static StudentProfileDetails createProfile(int studentId, String name, String village,
                                                      String postOffice, String thana, String zilla, String country){
        StudentProfileDetails user = new StudentProfileDetails();
        user.setStudentId(studentId);
        user.setName(name);
        user.address.setVillage(village);
        user.address.setPostOffice(postOffice);
        user.address.setThana(thana);
        user.address.setZilla(zilla);
        user.address.setCountry(country);

        return user;
    }
}
