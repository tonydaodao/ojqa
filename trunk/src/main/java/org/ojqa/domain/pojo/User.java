package org.ojqa.domain.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * @author ybak
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User extends IdEntity {
    /**
     * Name of User.
     */
    private String name;
    /**
     * Password of User.
     */
    private String password;
    /**
     * ConfirmPassword of User will not be persistented.
     */
    private String confirmPassword;
    /**
     * Created time of User.
     */
    private Date createTime;

    /**
     * Get password of User.
     * 
     * @return password.
     */
    @Column(nullable = false)
    public final String getPassword() {
        return password;
    }

    /**
     * Get password of user.
     * 
     * @param pPassword
     *            password
     */
    public final void setPassword(final String pPassword) {
        this.password = pPassword;
    }

    /**
     * get confirmPassword, from form for validation usage.
     * 
     * @return confirmed password.
     */
    @Transient
    public final String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * set confirmed password.
     * 
     * @param pConfirmPassword
     *            confirmed password.
     */
    public final void setConfirmPassword(final String pConfirmPassword) {
        this.confirmPassword = pConfirmPassword;
    }

    /**
     * Get Name of User.
     * 
     * @return name
     */
    @Column(nullable = false, unique = true)
    public final String getName() {
        return name;
    }

    /**
     * Set the name of user.
     * 
     * @param pName
     *            name
     */
    public final void setName(final String pName) {
        this.name = pName;
    }

    /**
     * Getter method.
     * 
     * @return create time
     */
    @Column(name = "create_time")
    public final Date getCreateTime() {
        return createTime;
    }

    /**
     * Setter.
     * 
     * @param pCreateTime
     *            create time
     */
    public final void setCreateTime(final Date pCreateTime) {
        this.createTime = pCreateTime;
    }

    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;
        result =
                prime * result
                        + ((createTime == null) ? 0 : createTime.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result =
                prime * result + ((password == null) ? 0 : password.hashCode());
        return result;
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (createTime == null) {
            if (other.createTime != null) {
                return false;
            }
        } else if (!createTime.equals(other.createTime)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (password == null) {
            if (other.password != null) {
                return false;
            }
        } else if (!password.equals(other.password)) {
            return false;
        }
        return true;
    }

}
