package ImageHoster.service;

import ImageHoster.model.User;
import ImageHoster.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //Call the registerUser() method in the UserRepository class to persist the user record in the database
    public void registerUser(User newUser) {
        userRepository.registerUser(newUser);
    }

    //Since we did not have any user in the database, therefore the user with username 'upgrad' and password 'password' was hard-coded
    //This method returned true if the username was 'upgrad' and password is 'password'
    //But now let us change the implementation of this method
    //This method receives the User type object
    //Calls the checkUser() method in the Repository passing the username and password which checks the username and password in the database
    //The Repository returns User type object if user with entered username and password exists in the database
    //Else returns null
    public User login(User user) {
        User existingUser = userRepository.checkUser(user.getUsername(), user.getPassword());
        if (existingUser != null) {
            return existingUser;
        } else {
            return null;
        }
    }

    public boolean authenticatePassword(String password){
        password=password.toLowerCase();
        boolean containsAlphabet=false;
        boolean containsNumber=false;
        boolean containsSpecialCharacter=false;
        List<Character> alphabets=new ArrayList<>();
        alphabets.add('a');alphabets.add('b');
        alphabets.add('c');alphabets.add('d');
        alphabets.add('e');alphabets.add('f');
        alphabets.add('g');alphabets.add('h');
        alphabets.add('i');alphabets.add('j');
        alphabets.add('k');alphabets.add('l');
        alphabets.add('m');alphabets.add('n');
        alphabets.add('o');alphabets.add('p');
        alphabets.add('q');alphabets.add('r');
        alphabets.add('s');alphabets.add('t');
        alphabets.add('u');alphabets.add('v');
        alphabets.add('w');alphabets.add('x');
        alphabets.add('y');alphabets.add('z');
        List<Character>numbers=new ArrayList<>();
        numbers.add('1');numbers.add('2');
        numbers.add('3');numbers.add('4');
        numbers.add('5');numbers.add('6');
        numbers.add('7');numbers.add('8');
        numbers.add('9');numbers.add('0');
        List<Character> specialCharacters=new ArrayList<>();
        specialCharacters.add('$');
        specialCharacters.add('#');
        specialCharacters.add('@');
        specialCharacters.add('&');
        specialCharacters.add('*');


        for(char c:password.toCharArray()){
            if(alphabets.contains(c)){
                containsAlphabet=true;
                break;
            }
        }
        for(char c:password.toCharArray()){
            if(numbers.contains(c)){
                containsNumber=true;
                break;
            }
        }
        for(char c:password.toCharArray()){
            if(specialCharacters.contains(c)){
                containsSpecialCharacter=true;
                break;
            }
        }

        return containsAlphabet&&containsNumber&&containsSpecialCharacter;



    }

}
