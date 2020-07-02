package com.spring.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Andreas Koehn on 27.05.2015.
 */
public class PersonDAOImpl implements PersonDAO {

    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<PersonPOJO> getAll() {
        String query = "SELECT * FROM test_table";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<PersonPOJO> personList = new ArrayList<PersonPOJO>();

        List<Map<String, Object>> personRows = jdbcTemplate.queryForList(query);

        for (Map<String, Object> personRow : personRows) {
            PersonPOJO person = new PersonPOJO(String.valueOf(personRow.get("NAME")), String.valueOf(personRow.get("SURNAME")), Integer.parseInt(String.valueOf(personRow.get("AGE"))));
            personList.add(person);
        }

        return personList;
    }
}
