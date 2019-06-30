package cc.bunnies.pocketsnacks.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private int uid;
    private String username;
    private String password;
}
