package com.example.bl_lab1.service;

import com.example.bl_lab1.model.User;
import com.example.bl_lab1.model.UsersList;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;


@Repository
public class UserDAO {
    
    private static final String PATH_TO_XML = "users.xml";

    public User getUser(String login) throws JAXBException {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }
    
    private List<User> getAllUsers() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(UsersList.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    
        //We had written this file in marshalling example
        UsersList usersList = (UsersList) jaxbUnmarshaller.unmarshal( new File(PATH_TO_XML) );
        return usersList.getUsers();
    }
}
