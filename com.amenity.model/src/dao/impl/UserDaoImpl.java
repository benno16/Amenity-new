/**
 */
package dao.impl;

import java.util.Date;
import java.util.List;

import dao.DaoPackage;
import dao.UserDao;

import general.User;

import org.eclipse.emf.ecore.EClass;
import org.hibernate.Query;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Dao</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class UserDaoImpl extends GenericDaoImpl implements UserDao {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UserDaoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DaoPackage.Literals.USER_DAO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public User findByUsername(User user) {
		session = getSession();
		session.beginTransaction();
		Query queryRes = session.createQuery("from " + 
				User.class.getName().toString() + 
				" u where u.username='" + user.getUsername() + "'");
		List<User> users = queryRes.list();
		session.close();
		if ( users == null || users.size() == 0 ) {
			return null;
		}else if ( users.size() == 1) {
			update(users.get(0));
			return user = users.get(0);
		} else {
			System.out.println("multiple entries found");
			return null;
		} 
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public User getById(String id) {
		session = getSession();
		session.beginTransaction();
		Query queryRes = session.createQuery("from " + 
				User.class.getName().toString() + 
				" u where u.userId='" + id + "'");
		List<User> users = queryRes.list();
		session.close();
		if ( users == null || users.size() == 0 ) {
			return null;
		}else if ( users.size() == 1) {
			update(users.get(0));
			return users.get(0);
		} else {
			System.out.println("multiple entries found");
			return null;
		}
	}

	@Override
	public void create(Object object) {
		User searchRes = findByUsername( (User) object);
		if (  searchRes != null ){
			searchRes.setTimesUsed(searchRes.getTimesUsed() + 1);
			searchRes.setLastUsed(new Date());
			object = searchRes;
		} 
		session = getSession();
		session.beginTransaction();
		session.save(object);
		session.getTransaction().commit();
		session.close();
	}
	
	@Override
	public void update(Object object) {
		session = getSession();
		session.beginTransaction();
		User u = (User) object;
		session.update(u);
		session.beginTransaction().commit();
		session.close();
	}

} //UserDaoImpl
