package db;

import me.merit.entity.UserEntity;
import me.merit.util.TokenUtil;

public class token {
    public static void main(String[] args) {
        String apiKey = "sf93q9)_rf2832QR%#$%Q@ae-rtae";
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiMSIsImV4cCI6MTUzMDkyMzE3NiwiaWF0IjoxNTMwODc5OTc2LCJ1c2VyX251bWJlciI6IjIwMTUzMTA2MzIxNiJ9.-HT4IMTcCq2prFLZZ5OBlDGtaSy6n_uTuC1jgGHE0Zk";
        UserEntity user_ = TokenUtil.verifyToken(token);
        if(user_ == null) {
            System.out.println("auth failed");
        }
        System.out.println(token);
    }
}
