package larion.progate.service.persistence;

import java.util.List;

import larion.progate.model.User;
import larion.progate.model.impl.UserImpl;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class UserFinderImpl extends BasePersistenceImpl implements UserFinder {

	public static String GET_USER_IN_COMPANY = "UserInCompany";
	
	public List<User> getUserInCompany(int rootId) throws SystemException,
			PortalException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_USER_IN_COMPANY);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("User", UserImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(rootId);
			return (List) query.list();
		} catch (Exception e) {
			System.out.println("ERROR in UserFinderImpl.getUserInCompany "
					+ e.toString());
			return null;
		}
	}
}