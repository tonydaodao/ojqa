package org.ojqa.domain.util;
import java.util.List;

/** DTO which contains JOPO list and paging status.
 * @author ybak
 *
 * @param <T>
 */
public class PagedQueryResult<T> {

    private final List<T> results;

    private final boolean more;

    public PagedQueryResult(List<T> pResults, boolean pMore) {
        this.results = pResults;
        this.more = pMore;
    }

    public boolean isMore() {
        return more;
    }

    public List<T> getResults() {
        return results;
    }
}