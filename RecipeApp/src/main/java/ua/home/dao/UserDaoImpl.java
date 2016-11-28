package ua.home.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.home.exception.UserNotFoundException;
import ua.home.model.Recipe;
import ua.home.model.User;
import ua.home.utils.ConnectionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager manager;


    @Override
    @Transactional
    public User addUser(User user) {
        if(user == null){
            return null;
        }
        manager.persist(user);
        return user;
    }

    @Override
    @Transactional
    public User removeUser(User user) {
        User res = null;
        if(user == null){
            return res;
        }
        res = manager.find(User.class, user);
        return res;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        Query query = manager.createNamedQuery("getAllUsers");
        List<User> usersList = query.getResultList();
        return usersList;
    }

    @Override
    public User updateUser(User userUp) {
       /* User res = null;
        for (User user : getAllUsers()) {
            if(user.getLogin().equals(userUp.getLogin())){
                user = userUp;
                res = user;
                break;
            }
        }
        return res;*/
        /*manager.getTransaction().begin();
        manager.getTransaction().commit();*/
        return userUp;
    }

    @Override
    public User findUser(String login) {
        User res = null;
        List<User> userList = getAllUsers();
        for (User user : userList) {
            if(user.getLogin().equals(login)){
                res = user;
                break;
            }
        }
        return res;
    }

    @Override
    @Transactional
    public User findUserById(int id) {
        User res = null;
        res = manager.find(User.class, id);
        return res;
    }
}
