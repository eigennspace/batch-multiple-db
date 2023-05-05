package id.harist.batchingmultipledb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * @author : github.com/eigennspace
 * @since : Fri 05/05/2023 19:29
 * @Project : batching-multiple-db
 * @Created_by : IdeaU
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class People {

    private Long id;
    private String email;
    private String name;
}
