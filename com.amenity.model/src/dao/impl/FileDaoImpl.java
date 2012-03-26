/**
 */
package dao.impl;

import general.File;

import java.util.ArrayList;
import java.util.List;

import dao.DaoPackage;
import dao.FileDao;

import org.eclipse.emf.ecore.EClass;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File Dao</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("rawtypes")
public class FileDaoImpl extends GenericDaoImpl implements FileDao {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FileDaoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DaoPackage.Literals.FILE_DAO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public File getById(String id) {
		session = getSession();
		session.beginTransaction();
		String string = "from " + File.class.getName().toString() + 
				" where objectId = '" + id + "'";
		Query queryRes = session.createQuery(string);
		List<File> resultList = queryRes.list();
		session.close();
		return resultList.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean massInsert(List list, Class<?> class_, Object object) {
		session = getSession();
		Transaction tx = session.beginTransaction();
		try {
			list = (ArrayList<File>) list;
		} catch (Exception e) {
			return false;
		}
		int i = 0;
		for ( File f : (ArrayList<File>) list ) {
			session.save(f);
			if ( i % 1000 == 0 ) {
				session.flush();
				session.clear();
			}
			i++;
		}
		try {
			tx.commit();
			session.close();
			return true;
		} catch ( Exception e ) {
			tx.rollback();
			session.close();
			return false;
		}
	}

} //FileDaoImpl
