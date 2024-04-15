package org.example.dao;

import org.example.dataset.UserDataSet;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UserDAO {
    public static void addUser(Session session, UserDataSet user) {
        session.save(user);
    }

    public static UserDataSet getUserByLogin(Session session, String login) {
        Criteria criteria = session.createCriteria(UserDataSet.class);
        return (UserDataSet) criteria.add(Restrictions.eq("login", login)).uniqueResult();
    }
}
