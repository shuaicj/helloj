package shuaicj.hello.lombok;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * A bean to test lombok.
 *
 * @author shuaicj 2017/03/29
 */
@Getter // Getter and Setter can also applied to fields
@Setter
// @NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor // with final or @NonNull fields, which means (name, birth)
public class LombokPerson {

    @NonNull private String name;
    private final Date birth; // final field has no getter
    private String address;
}
