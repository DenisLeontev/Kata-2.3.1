package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImp {

    private List<User> user;

    {
        user = new ArrayList<>();
        user.add(new User(1, "Den", 46, "ldb1@mail.ru"));
        user.add(new User(2, "Kat", 37, "ldb2@mail.ru"));
        user.add(new User(3, "Yan", 22, "ldb3@mail.ru"));
        user.add(new User(4, "Masha", 9, "ldb4@mail.ru"));
        user.add(new User(5, "Tom", 3, "ldb5@mail.ru"));
    }

    // метод выводит список юзеров
    public List<User> index() {
        return user;
    }

    // метод выводит юзера по его id
    public User show(int id) {
        return user.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

}

//import hiber.model.User;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.TypedQuery;
//import java.util.List;
//
//@Repository
//public class UserDaoImp implements UserDao {
//
//   @Autowired
//   private SessionFactory sessionFactory;
//
//   @Override
//   public void add(User user) {
//      sessionFactory.getCurrentSession().save(user);
//   }
//
//   @Override
//   @SuppressWarnings("unchecked")
//   public List<User> listUsers() {
//      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
//      return query.getResultList();
//   }
//
//   @Override
//   public User findOwner(String car_model, int car_series) {
//      Query query = sessionFactory.getCurrentSession()
//              .createQuery("FROM User usr LEFT OUTER JOIN FETCH usr.car WHERE usr.car.model =:model AND usr.car.series =:series")
//              .setParameter("model", car_model)
//              .setParameter("series", car_series);
//      return (User) query.getSingleResult();
//   }
//}
