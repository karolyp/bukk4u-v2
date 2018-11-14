package hu.rendszerfejlesztes.konyvtar.model.entity.auth;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import hu.rendszerfejlesztes.konyvtar.model.entity.auth.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, unique = true)
    @NotNull
    private String username;

    @NotNull
    private String bCryptHash;


	private boolean active;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "token_uuid")
    private Token token;

    public UserDTO toDto() {
        return new UserDTO(id, username, null);
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
}
