package com.jsp.springJpa.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springJpa.Exception.UserNotFoundException;
import com.jsp.springJpa.Utility.ResponseStructure;
import com.jsp.springJpa.entity.User;
import com.jsp.springJpa.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ResponseStructure structure;

    public ResponseEntity<ResponseStructure<User>> save(User user) {
        User user1 = userRepo.save(user);
        structure.setStatus(HttpStatus.CREATED.value());
        structure.setMessage("Created a new data to the records");
        structure.setData(user1);
        return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseStructure<User>> delete(int userId) {
        Optional<User> optional = userRepo.findById(userId);
        if (optional.isPresent()) {
            userRepo.deleteById(userId);
            structure.setStatus(HttpStatus.OK.value());
            structure.setMessage("Data successfully deleted");
            return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
        } else
            throw new UserNotFoundException("No data found to delete with userId = "+userId);
    }

    public ResponseEntity<ResponseStructure<List<User>>> getAllUsers() {
        List<User> list = userRepo.findAll();
        structure.setStatus(HttpStatus.FOUND.value());
        structure.setMessage("Data Found");
        structure.setData(list);
        return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.FOUND);
    }

    public ResponseEntity<ResponseStructure<User>> update(int userId, User user) {
        Optional<User> optional = userRepo.findById(userId);
        if (optional.isPresent()) {
            User existingUser = optional.get();
            existingUser.setUserName(user.getUserName());
            existingUser.setAge(user.getAge());
            User user1 = userRepo.save(existingUser);
            structure.setStatus(HttpStatus.ACCEPTED.value());
            structure.setMessage("Data successfully updated!");
            structure.setData(user1);
            return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.ACCEPTED);
        } else
            throw new UserNotFoundException("Data not found to be updated with userId = "+ userId);
    }

    public ResponseEntity<ResponseStructure<User>> getById(int userId) {
        Optional<User> optional = userRepo.findById(userId);
        if(optional.isPresent()){
            User user = optional.get();
            structure.setStatus(HttpStatus.FOUND.value());
            structure.setMessage("Data found!!");
            structure.setData(user);
            return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
        }else
        throw new UserNotFoundException("No user Found with the id = "+ userId);
    }
}
