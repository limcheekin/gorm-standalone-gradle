import grails.orm.bootstrap.*
import grails.persistence.*
import org.springframework.jdbc.datasource.DriverManagerDataSource

// https://grails.github.io/grails-data-mapping/api/grails/orm/bootstrap/HibernateDatastoreSpringInitializer.html
init = new HibernateDatastoreSpringInitializer(Person)
def dataSource = new DriverManagerDataSource("jdbc:mysql://localhost/test", 'root', '')
init.configureForDataSource(dataSource) 

Person.withTransaction {
	println "Total people = " + Person.count()
}

@Entity
class Person {
    String name
    static constraints = {
        name blank:false
    }
}