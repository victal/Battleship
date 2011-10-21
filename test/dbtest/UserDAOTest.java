package dbtest;

import dominio.UserDAOJpa;
import entities.User;
import exceptions.PreexistingEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import junit.framework.Assert;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author guilherme
 */
public class UserDAOTest {
    
    private Mockery context;
    private EntityManager mockmanage;
    private EntityTransaction transactionmock;
    private UserDAOJpa udao;
    
    @Before
    public void setUp(){
        context = new JUnit4Mockery();
	context.setImposteriser(ClassImposteriser.INSTANCE);
        mockmanage=context.mock(EntityManager.class);	
        transactionmock = context.mock(EntityTransaction.class);
        udao = new UserDAOJpa(mockmanage);
    }
    @Test
    public void testCreate(){
        final User u = new User();
        u.setUsername("user");
        u.setPassword("passwd");
        context.checking(new Expectations(){{
            exactly(2).of(mockmanage).getTransaction();
            will(returnValue(transactionmock));
            oneOf(transactionmock).begin();
            oneOf(transactionmock).commit();
            oneOf(mockmanage).persist(u);
            oneOf(mockmanage).close();
        }});
        try {
            udao.create(u);
        } catch (PreexistingEntityException ex) {
            Assert.fail();
        } catch (Exception ex) {
            Assert.fail();
        }

        
        
    }
    public void testDelete(){
    }
    public void testUpdate(){
    }
    public void testFind(){
    }
    public void testFindById(){
    }
}
