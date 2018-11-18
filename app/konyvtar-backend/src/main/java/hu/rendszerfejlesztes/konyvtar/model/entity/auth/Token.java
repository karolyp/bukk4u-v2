package hu.rendszerfejlesztes.konyvtar.model.entity.auth;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID tokenUuid;

    private Date expiresAt;

	public UUID getTokenUuid() {
		return tokenUuid;
	}

	public void setTokenUuid(UUID tokenUuid) {
		this.tokenUuid = tokenUuid;
	}

	public Date getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
	}

}
