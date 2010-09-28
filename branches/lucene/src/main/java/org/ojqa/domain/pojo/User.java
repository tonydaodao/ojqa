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
    public String getPassword() {
        return this.password;
    }

    /**
     * Get password of user.
     * 
     * @param pPassword
     *            password
     */
    public void setPassword(final String pPassword) {
        this.password = pPassword;
    }

    /**
     * get confirmPassword, from form for validation usage.
     * 
     * @return confirmed password.
     */
    @Transient
    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    /**
     * set confirmed password.
     * 
     * @param pConfirmPassword
     *            confirmed password.
     */
    public void setConfirmPassword(final String pConfirmPassword) {
        this.confirmPassword = pConfirmPassword;
    }

    /**
     * Get Name of User.
     * 
     * @return name
     */
    @Column(nullable = false, unique = true)
    public String getName() {
        return this.name;
    }

    /**
     * Set the name of user.
     * 
     * @param pName
     *            name
     */
    public void setName(final String pName) {
        this.name = pName;
    }

    /**
     * Getter method.
     * 
     * @return create time
     */
    @Column(name = "create_time")
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * Setter.
     * 
     * @param pCreateTime
     *            create time
     */
    public void setCreateTime(final Date pCreateTime) {
        this.createTime = pCreateTime;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.createTime == null) ? 0 : this.createTime.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.password == null) ? 0 : this.password.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.createTime == null) {
            if (other.createTime != null) {
                return false;
            }
        } else if (!this.createTime.equals(other.createTime)) {
            return false;
        }
        if (this.name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!this.name.equals(other.name)) {
            return false;
        }
        if (this.password == null) {
            if (other.password != null) {
                return false;
            }
        } else if (!this.password.equals(other.password)) {
            return false;
        }
        return true;
    }

}
