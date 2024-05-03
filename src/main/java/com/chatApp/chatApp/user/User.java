package com.chatApp.chatApp.user;

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
    private String fullName;
    private Status status;
}
