package hu.rendszerfejlesztes.konyvtar.model.entity.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {

    private Long id;
    private String username;
    private String password;

}
