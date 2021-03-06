package hu.rendszerfejlesztes.konyvtar.model.entity.auth;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import hu.rendszerfejlesztes.konyvtar.model.entity.auth.dto.UserDTO;
import hu.rendszerfejlesztes.konyvtar.model.entity.library.Rating;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, unique = true)
    @NotNull
    private String username;

    private String fullName;

    private String email;

    @NotNull
    private String bCryptHash;

	private boolean active;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Token token;

    @OneToMany(mappedBy = "user")
    private List<Rating> ratings;

    public UserDTO toDto() {
        UserDTO dto = new UserDTO();
        dto.setId(id);
        dto.setUsername(username);
        dto.setFullName(fullName);
        dto.setEmail(email);
        return dto;
    }
    public String getUsername() {
    	return username;
    }
    
    public void setUsername(String username) {
    	this.username = username;
    }
    
    public String getbCryptHash() {
    	return bCryptHash;
    }
    
    public void setbCryptHash(String bCryptHash) {
    	this.bCryptHash = bCryptHash;
    }
    
    public boolean isActive() {
    	return active;
    }
    
    public void setActive(boolean active) {
    	this.active = active;
    }
    
    public Role getRole() {
    	return role;
    }
    
    public void setRole(Role role) {
    	this.role = role;
    }
    
    public Token getToken() {
    	return token;
    }
    
    public void setToken(Token token) {
    	this.token = token;
    }
    
    public Long getId() {
    	return id;
    }
    
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", bCryptHash=" + bCryptHash + ", active=" + active
				+ ", role=" + role + ", token=" + token + "]";
	}

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
