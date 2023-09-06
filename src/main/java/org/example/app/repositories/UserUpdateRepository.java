package org.example.app.repositories;

import org.example.app.entity.User;
import org.example.app.utils.Constants;
import org.example.app.utils.HibernateUtil;
import org.example.app.utils.IdChecker;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;

public class UserUpdateRepository {

    public String updateUserData(User user) {
        if (IdChecker.isIdExists(user)) {
            return updateAllUserData(user);
        } else {
            return Constants.ID_NO_EXISTS_MSG;
        }
    }

    public String updateAllUserData(User user) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String hql = "UPDATE User SET userName = :userName, email = :email, password = :password WHERE id = :id";
            MutationQuery query = session.createMutationQuery(hql);
            query.setParameter("userName", user.getUserName());
            query.setParameter("email", user.getEmail());
            query.setParameter("password", user.getPassword());
            query.setParameter("id", user.getId());
            query.executeUpdate();

            transaction.commit();
            return Constants.DATA_UPDATE_MSG;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return e.getMessage();
        }
    }
}