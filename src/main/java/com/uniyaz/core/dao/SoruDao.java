package com.uniyaz.core.dao;

import com.uniyaz.core.domain.Soru;
import com.uniyaz.core.dto.SoruDto;
import com.uniyaz.core.dto.SoruDtoNative;
import com.uniyaz.core.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import java.util.List;

public class SoruDao {

    public void saveSoru(Soru soru){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(soru);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Soru> findAByIdCriteria(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Criteria criteria = session.createCriteria(Soru.class);
            criteria.add(Restrictions.eq("id", id));
            return criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Soru> findAllHql() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            String hql =
                    "Select     soruAlias " +
                            "From       Soru soruAlias ";
            Query query = session.createQuery(hql);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<SoruDto> findAllHqlAliasToBean() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            String hql =
                    "Select     soruAlias.id, soruAlias.soruyaz " +
                            "From       Soru soruAlias ";
            Query query = session.createQuery(hql);
            query.setResultTransformer(Transformers.aliasToBean(SoruDto.class));
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<SoruDtoNative> findAllNative() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            NativeQuery sqlQuery = session.createSQLQuery("SELECT * FROM SORU");
            Query query = sqlQuery.setResultTransformer(Transformers.aliasToBean(SoruDtoNative.class));
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
