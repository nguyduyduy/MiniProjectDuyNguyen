package com.persistence;

import com.models.HoroscopeUser;
import com.utils.ConnectionManager;
import com.utils.CustomCRUDInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO implements CustomCRUDInterface<HoroscopeUser> {

    Connection connection;

    public UserDAO(){

        connection = ConnectionManager.getConnection();

    }
    @Override
    public Integer create(HoroscopeUser horoscopeUser) {

        try {

            String sql = "INSERT INTO horoscopes (userid, username, user_password, firstname, lastname, email, zodiac, mood) VALUES (default, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, horoscopeUser.getUsername());
            pstmt.setString(2, horoscopeUser.getUser_password());
            pstmt.setString(3, horoscopeUser.getFirstname());
            pstmt.setString(4, horoscopeUser.getLastname());
            pstmt.setString(5, horoscopeUser.getEmail());
            pstmt.setString(6, horoscopeUser.getZodiac());
            pstmt.setString(7, horoscopeUser.getMood());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();

            return rs.getInt(1);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public HoroscopeUser read(Integer id) {

        try {
            String sql = "SELECT * FROM horoscopes WHERE userid = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, id);

            HoroscopeUser horoscopeUser = new HoroscopeUser();

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                horoscopeUser.setUserid(rs.getInt("userid"));
                horoscopeUser.setUsername(rs.getString("username"));
                horoscopeUser.setUser_password(rs.getString("user_password"));
                horoscopeUser.setFirstname(rs.getString("firstname"));
                horoscopeUser.setLastname(rs.getString("lastname"));
                horoscopeUser.setEmail(rs.getString("email"));
                horoscopeUser.setZodiac(rs.getString("zodiac"));
                horoscopeUser.setMood(rs.getString("mood"));
            }

            return horoscopeUser;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public HoroscopeUser update(HoroscopeUser horoscopeUser) {

        try {
            String sql = "UPDATE horoscopes SET mood = ? WHERE userid = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);


//            pstmt.setString(1, horoscopeUser.getUser_password());
//            pstmt.setString(2, horoscopeUser.getFirstname());
//            pstmt.setString(3, horoscopeUser.getLastname());
//            pstmt.setString(4, horoscopeUser.getEmail());
//            pstmt.setString(5, horoscopeUser.getZodiac());
            pstmt.setString(1, horoscopeUser.getMood());
            pstmt.setInt(2, horoscopeUser.getUserid());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            while (rs.next()) {

                horoscopeUser.setUserid(rs.getInt("userid"));
                horoscopeUser.setUsername(rs.getString("username"));
                horoscopeUser.setUser_password(rs.getString("user_password"));
                horoscopeUser.setFirstname(rs.getString("firstname"));
                horoscopeUser.setLastname(rs.getString("lastname"));
                horoscopeUser.setEmail(rs.getString("email"));
                horoscopeUser.setZodiac(rs.getString("zodiac"));
                horoscopeUser.setMood(rs.getString("mood"));

            }
            return horoscopeUser;

        }  catch (Exception e){

            }

        return null;
    }

    @Override
    public boolean delete(Integer id) {

        try {
            String sql = "DELETE FROM horoscopes WHERE userid = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, id);

            return pstmt.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public HoroscopeUser loginCurrentUser (String username, String user_password){

        try {
            String sql = "SELECT * FROM horoscopes WHERE username = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            // 1 indicates parameter of question mark, email is what it's taking in
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next() && rs.getString("user_password").equals(user_password)){
                return new HoroscopeUser(rs.getInt("userid"),
                        rs.getString("username"),
                        rs.getString("user_password"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("zodiac"),
                        rs.getString("mood"));
            }


        }catch (Exception e){
            System.out.println("This is the UserDAO " + e.getMessage());
        }
        return null;
    }
}
