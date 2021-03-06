package org.javers.repository.sql;

import org.javers.common.collections.Optional;
import org.polyjdbc.core.PolyJDBC;
import org.polyjdbc.core.query.SelectQuery;
import org.polyjdbc.core.query.mapper.ObjectMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author bartosz walacik
 */
public class PolyUtil {
    public static List<Long> queryForLongList(SelectQuery query, PolyJDBC poly){
        return poly.queryRunner().queryList(query, new ObjectMapper<Long>() {
            @Override
            public Long createObject(ResultSet resultSet) throws SQLException {
                return resultSet.getLong(1);
            }
        });
    }

    public static Optional<Long> queryForOptionalLong(SelectQuery query, PolyJDBC poly){
        List<Long> result = queryForLongList(query, poly);

        if (result.isEmpty()){
            return Optional.empty();
        }

        return Optional.of(result.get(0));
    }
}
