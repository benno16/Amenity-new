/**
 */
package dao.impl;

import general.Container;
import general.User;

import java.util.List;

import dao.ContainerDao;
import dao.DaoPackage;

import org.eclipse.emf.ecore.EClass;
import org.hibernate.Query;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Container Dao</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ContainerDaoImpl extends GenericDaoImpl implements ContainerDao {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContainerDaoImpl() {
		super();
	}
	
	@Override
	public List<?> getListByOwner(Class<?> class_, User user) {
		session = getSession();
		session.beginTransaction();
		String string = "from " + class_.getName().toString() + 
				" where owner = '" + user.getUserId() + "' and deleted = '0'";
		Query queryRes = session.createQuery(string);
		@SuppressWarnings("unchecked")
		List<Container> resultList = queryRes.list();
		session.close();
		return resultList;
	}
	
	public void delete(Object object) {
		session = getSession();
		session.beginTransaction();
		Container c = (Container) object;
		c.setDeleted(true);
		session.update(c);
		try {
			session.getTransaction().commit();
		} catch ( Exception e ){
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DaoPackage.Literals.CONTAINER_DAO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setOwner(Object user) {
		
		if ( user instanceof User ) {

			session = getSession();
			session.beginTransaction();
			
			User u = (User) user;
			
			session.createQuery("update " + Container.class.getName().toString()+ 
					" set owner = '" + u.getUserId()  + "' where owner is null").executeUpdate() ;
			
			session.getTransaction().commit();
			session.close();
			
		}
		
	}

} //ContainerDaoImpl
