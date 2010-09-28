package org.ojqa.domain.repository.jpa;

import java.util.Date;

import org.ojqa.domain.pojo.Comment;
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
    }

}
