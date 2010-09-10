package org.ojqa.domain.repository;

import org.ojqa.domain.pojo.User;

/**Interface of UserRepository.
 * @author ybak
 *
 */
public interface UserRepository extends Repository<User>{

    User getByName(String pName);
    

}
