package com.uniyaz.core.dao;


import com.uniyaz.core.domain.AnketKisi;
import com.uniyaz.core.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.List;


public class AnketKisiDao {

    private Object AnketKisi;

    public void saveAnketKisi(AnketKisi anketKisi) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(AnketKisi);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveAnketKisi(List<AnketKisi> anketKisiList) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            for (AnketKisi anketKisi : anketKisiList) {
                session.merge(anketKisi);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<AnketKisi> findAByIdCriteria(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Criteria criteria = session.createCriteria(AnketKisi.class);
            criteria.add(Restrictions.eq("id", id));
            return criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<AnketKisi> findAllHql() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            String hql =
                    "Select     anketKisi " +
                    "From       AnketKisi anketKisi " +
                    "Left Join Fetch anketKisi.anket anket " +
                    "Left Join Fetch anketKisi.kisi kisi ";
            Query query = session.createQuery(hql);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<AnketKisi> findAllByAnketId(long anketId) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            String hql =
                    "Select     anketKisi " +
                    "From       AnketKisi anketKisi " +
                    "Left Join Fetch anketKisi.anket anket " +
                    "Left Join Fetch anketKisi.kisi kisi " +
                    "where      anket.id = :anketiId ";
            Query query = session.createQuery(hql);
            query.setParameter("anketId", anketId);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<AnketKisi> findAllByKisiId(long kisiId) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            String hql =
                    "Select     anketKisi " +
                            "From       AnketKisi anketKisi " +
                            "Left Join Fetch anketKisi.anket anket " +
                            "Left Join Fetch anketKisi.kisi kisi " +
                            "where      kisi.id = :kisiiId ";
            Query query = session.createQuery(hql);
            query.setParameter("kisiId", kisiId);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}