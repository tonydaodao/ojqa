/**
 * 
 */
package org.ojqa.domain.repository.jpa;

import java.util.Date;
import java.util.List;

import org.ojqa.domain.pojo.User;
import org.ojqa.domain.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ybak
 * 
 */
@Transactional
public class JPAUserRepositoryImpl extends JPARepositoryImpl<User> implements UserRepository {

    @Override
    public void save(User entity) {
        if (entity.getId() == null) {
            entity.setCreateTime(new Date());
        }
        super.save(entity);
    }

    @SuppressWarnings("unchecked")
    public User getByName(String pName) {
        List<User> result = getJpaTemplate().find("select u from User u where u.name = ?", pName);
        if (result.size() == 0)
            return null;
        return result.get(0);
    }

}
