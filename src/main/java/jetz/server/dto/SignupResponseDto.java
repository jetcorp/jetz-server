package jetz.server.dto;

import java.util.ArrayList;
import java.util.List;
import jetz.server.entity.Authority;
import jetz.server.entity.Zuser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignupResponseDto {
    private String email;
    private String zname;
    private List<Authority> roles = new ArrayList<>();
    private String token;

    public SignupResponseDto(Zuser zuser) {
        this.email = zuser.getEmail();
        this.zname = zuser.getZname();
        this.roles = zuser.getRoles();
    }
}
