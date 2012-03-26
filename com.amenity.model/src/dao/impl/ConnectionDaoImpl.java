/**
 */
package dao.impl;

import java.util.List;

import dao.ConnectionDao;
import dao.DaoPackage;

import general.Connection;
import general.Container;
import general.User;

import org.eclipse.emf.ecore.EClass;
import org.hibernate.Query;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection Dao</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ConnectionDaoImpl extends GenericDaoImpl implements ConnectionDao {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionDaoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DaoPackage.Literals.CONNECTION_DAO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String findMksPassword(User user) {
		session = getSession();
		session.beginTransaction();
		String string = "select \"password\" from \"connection\" c1, " +
				"\"container\" c2 where c1.\"password\" is not null " +
				"and c2.\"ownerid\" = '" + user.getUserId() + "'";

		Query queryRes = session.createSQLQuery(string);
		String resultSet = "";
		if ( queryRes.list().size() > 0 ) 
			resultSet = queryRes.list().get(0).toString();
		System.out.println("Password: " + resultSet );
		session.close();
		return resultSet;
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
	
	@Override
	public List<Connection> getListByOwner(Class<?> class_, User user) {
		session = getSession();
		session.beginTransaction();
		String string = "from " + class_.getName().toString() + " c1, " + 
				Container.class.getName().toString() + " c2 where c2.owner = '" + 
				user.getUserId() + "'";
		Query queryRes = session.createQuery(string);
		@SuppressWarnings("unchecked")
		List<Connection> resultList = queryRes.list();
		session.close();
		return resultList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<Connection> getListByContainer(Container container) {
		session = getSession();
		session.beginTransaction();
		String string = "from " + Connection.class.getName().toString() + 
				" where partOf = '" + container.getContainerId() + "' and deleted = false";
		Query queryRes = session.createQuery(string);
		@SuppressWarnings("unchecked")
		List<Connection> resultList = queryRes.list();
		session.close();
		return resultList;
	}

} //ConnectionDaoImpl
