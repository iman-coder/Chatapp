package com.chatApp.chatApp.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Users")
public class User {
	@Id 
    private String nickName;
    @Column
    private String fullName;
    @Column
    private Status status;
}
