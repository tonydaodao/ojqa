package org.ojqa.domain.repository.jpa;

import java.util.Date;

import javax.persistence.EntityTransaction;

import org.ojqa.domain.pojo.Comment;
import org.ojqa.domain.pojo.User;
import org.ojqa.domain.repository.CommentRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository of Comment.
 * 
 * @author ybak
 * 
 */
@Repository
public class JPACommentRepositoryImpl extends JPARepositoryImpl<Comment> implements CommentRepository {

    @Override
    public void save(Comment comment) {
        if (comment.getCreateDate() == null) {
            comment.setCreateDate(new Date());
        } else {
            comment.setLastModified(new Date());
        }
        super.save(comment);
        this.logger.error("entered long method");
        uselessLongMethod();
        this.logger.error("finished long method");
    }

    private void uselessLongMethod() {
        for (int i = 0; i < 1000; i++) {
            EntityTransaction transaction =
                    this.jpaTemplate.getEntityManagerFactory().createEntityManager().getTransaction();
            transaction.begin();
            this.jpaTemplate.find(User.class, 1l);
            transaction.rollback();
        }
    }
}
