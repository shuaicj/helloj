package shuaicj.hello.persist.mongo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * A java bean representing a user.
 *
 * @author shuaicj 2017/03/04
 */
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Document(collection = "user")
public class User {

    @Id
    private String id;

    @NonNull
    @Indexed(unique = true)
    private String username;

    @NonNull
    private String password;

    private List<String> phones;

    @CreatedDate
    private Date createdTime;

    @LastModifiedDate
    private Date updatedTime;
}
