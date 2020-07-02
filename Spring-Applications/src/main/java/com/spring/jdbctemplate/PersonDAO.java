package com.spring.jdbctemplate;

import java.util.List;

/**
 * Created by Andreas Koehn on 27.05.2015.
 */
public interface PersonDAO {

    /**
     * Load all people from the db
     *
     * @return list with people
     */
    public List<PersonPOJO> getAll();
}
