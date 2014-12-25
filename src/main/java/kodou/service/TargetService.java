package kodou.service;

import kodou.model.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.util.ArrayList;
import java.util.List;

public class TargetService implements Service<Site> {

    private static final String CREATE_TABLE = "create table CHECK_RESULT(" +
            "id serial, first_name varchar(255), last_name varchar(255))";

    @Override
    public Site insert(Site object) {
        //todo insert into database
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.h2.Driver.class);
        dataSource.setUsername("sa");
        dataSource.setUrl("jdbc:h2:mem");
        dataSource.setPassword("");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute(CREATE_TABLE);

        return object;
    }

    @Override
    public Site read() {
        return null;
    }

    @Override
    public Site update(Site object) {
        return object;
    }

    @Override
    public void delete(Site object) {

    }

    @Override
    public List<Site> readAll() {
        List<Site> siteList = new ArrayList<>();
        long interval = 50 * 1000;
        siteList.add(new Site("Google", "http://www.google.com", 80, interval));

        return siteList;
    }

}
