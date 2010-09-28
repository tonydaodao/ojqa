package org.ojqa.domain.repository.jpa;

import org.ojqa.domain.pojo.Comment;
import org.ojqa.domain.repository.CommentRepository;
import org.springframework.context.ApplicationContext;

/**
 * @author ybak
 * 
 */
@SuppressWarnings("deprecation")
public class JPACommentRepositoryImplTest extends BaseJPATest {

    private CommentRepository repository;

    public JPACommentRepositoryImplTest() {
        super();
        ApplicationContext ctx = super.getApplicationContext();
        repository = (CommentRepository) ctx.getBean("commentRepository");
    }

    public void testSave() {
        Comment comment = new Comment();
        comment.setContent("new comment coming!");
        repository.save(comment);
        assertNotNull(comment.getId());
        assertNotNull(comment.getCreateDate());
        comment.setContent("change the content of comment");
        repository.save(comment);
        assertNotNull(comment.getLastModified());
    }
}
