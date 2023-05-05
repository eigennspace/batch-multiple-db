package id.harist.batchingmultipledb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * @author : github.com/eigennspace
 * @since : Fri 05/05/2023 19:31
 * @Project : batching-multiple-db
 * @Created_by : IdeaU
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeopleDto {
    private String email;
    private String name;
}
