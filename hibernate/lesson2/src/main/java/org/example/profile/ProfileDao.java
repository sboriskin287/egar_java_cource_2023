package org.example.profile;

import org.example.profile.dto.ProfileCriteria;
import org.example.profile.entity.Profile;
import org.example.util.EMFSingleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProfileDao {
    private final EntityManagerFactory emf;

    public ProfileDao() {
        emf = EMFSingleton.getEmf();
    }

    public Optional<Profile> findById(Integer id) {
        var em = emf.createEntityManager();
        var profile = em.find(Profile.class, id);
        return Optional.ofNullable(profile);
    }

    @SuppressWarnings("unchecked")
    public List<Profile> findByCriteriaWithQuery(ProfileCriteria search) {
        var em = emf.createEntityManager();
        StringBuilder querySql = new StringBuilder("SELECT p FROM Profile p WHERE ");
        if (search.getId() != null) {
            querySql.append("p.id = :id");
        }
        if (search.getFirstNames() != null) {
            querySql.append("p.firstName IN :firstNames");
        }
        if (search.getLastName() != null) {
            querySql.append("p.lastName = :lastName");
        }
        if (search.getAge() != null) {
            querySql.append("p.age = :age");
        }
        var query = em.createQuery(querySql.toString());
        if (search.getId() != null) {
            query.setParameter("id", search.getId());
        }
        if (search.getFirstNames() != null) {
            query.setParameter("firstNames", search.getFirstNames());
        }
        if (search.getLastName() != null) {
            query.setParameter("lastName", search.getLastName());
        }
        if (search.getAge() != null) {
            query.setParameter("age", search.getAge());
        }
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Profile> findByCriteriaWithNamedQuery(ProfileCriteria search) {
        var em = emf.createEntityManager();
        var query = em.createNamedQuery("search");
        query.setParameter("id", search.getId());
        query.setParameter("firstNames", search.getFirstNames());
        query.setParameter("lastName", search.getLastName());
        query.setParameter("age", search.getAge());
        return query.getResultList();
    }

    public List<Profile> findByCriteria(ProfileCriteria search) {
        var em = emf.createEntityManager();
        var cb = em.getCriteriaBuilder();
        CriteriaQuery<Profile> query = cb.createQuery(Profile.class);
        Root<Profile> root = query.from(Profile.class);
        List<Predicate> conds = new ArrayList<>();
        if (search.getId() != null) {
            conds.add(cb.equal(root.get("id"), search.getId()));
        }
        if (search.getFirstNames() != null) {
            conds.add(cb.in(root.get("firstNames")).value(search.getFirstNames()));
        }
        if (search.getLastName() != null) {
            conds.add(cb.equal(root.get("lastName"), search.getLastName()));
        }
        if (search.getAge() != null) {
            conds.add(cb.equal(root.get("age"), search.getAge()));
        }
        if (search.getFromAgeInclusive() != null) {
            conds.add(cb.greaterThanOrEqualTo(root.get("age"), search.getFromAgeInclusive()));
        }
        if (search.getToAgeExclusive() != null) {
            conds.add(cb.lessThan(root.get("age"), search.getToAgeExclusive()));
        }
        query.where(conds.toArray(new Predicate[0]));
        return em.createQuery(query).getResultList();
    }
}
