package com.rick.webcoursedesign2022backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;

/**
 * (User)表实体类
 *
 * @author makejava
 * @since 2022-06-29 14:54:09
 */
@SuppressWarnings("serial")
@Component
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class User extends Model<User> implements UserDetails {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String name;

    private String cardNumber;

    @JsonIgnore
    private String password;

    private Integer total;

    private Integer selected;

    private String ist;




    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return cardNumber;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

