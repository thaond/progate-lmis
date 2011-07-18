package larion.progate.cds.service.persistence;

import java.util.List;

import larion.progate.cds.model.Level;
import larion.progate.cds.model.impl.LevelImpl;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class LevelFinderImpl extends BasePersistenceImpl implements LevelFinder {

	public static String GET_EXISTED_LEVEL = "ExistedLevel";

	public List<Level> getExistedLevel(int rootId, String levelName,
			int competencyId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_EXISTED_LEVEL);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("Level", LevelImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(rootId);
			qPos.add(levelName);
			qPos.add(competencyId);
			return (List) query.list();
		} catch (Exception e) {
			System.out.println("ERROR in LevelFinderImpl.getExistedLevel "
					+ e.toString());
			return null;
		}
	}
}