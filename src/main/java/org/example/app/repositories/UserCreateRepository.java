package org.example.app.repositories;

import org.example.app.entity.User;
import org.example.app.utils.Constants;
import org.example.app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;

public class UserCreateRepository {

    public String createUser(User user) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Транзакція стартує
            transaction = session.beginTransaction();

            String hql = "INSERT INTO User (userName, email, password) " +
                    "VALUES (:userName, :email, :password)";

            MutationQuery query = session.createMutationQuery(hql);
            query.setParameter("userName", user.getUserName());
            query.setParameter("email", user.getEmail());
            query.setParameter("password", user.getPassword());
            query.executeUpdate();

            // Транзакція виконується
            transaction.commit();
            return Constants.DATA_INSERT_MSG;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return e.getMessage();
        }
    }
}