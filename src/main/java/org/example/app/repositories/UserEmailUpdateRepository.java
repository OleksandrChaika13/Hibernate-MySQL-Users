package org.example.app.repositories;

import org.example.app.entity.User;
import org.example.app.utils.Constants;
import org.example.app.utils.HibernateUtil;
import org.example.app.utils.IdChecker;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;

public class UserEmailUpdateRepository {

    public String updateUserLogin(User user) {

        if (IdChecker.isIdExists(user)) {
            return updateEmailById(user);
        } else {
            return Constants.ID_NO_EXISTS_MSG;
        }
    }

    private String updateEmailById(User user) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String hql = "UPDATE User SET email = :email WHERE id = :id";
            MutationQuery query = session.createMutationQuery(hql);
            query.setParameter("email", user.getEmail());
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