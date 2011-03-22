package org.ojqa.domain.repository.jpa;

import java.util.Date;
import java.util.UUID;

import org.ojqa.domain.pojo.Comment;
import org.ojqa.domain.pojo.Question;
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
        uselessLongMethod();
    }

    private void uselessLongMethod() {
        Question question = new Question("test question", "tag", "context", new Date());
        this.jpaTemplate.persist(question);
        for (int i = 0; i < 1000; i++) {
            // EntityTransaction transaction =
            // this.jpaTemplate.getEntityManagerFactory().createEntityManager().getTransaction();
            // transaction.begin();
            question.setBody(UUID.randomUUID().toString());
            // transaction.commit();
        }
    }
}
