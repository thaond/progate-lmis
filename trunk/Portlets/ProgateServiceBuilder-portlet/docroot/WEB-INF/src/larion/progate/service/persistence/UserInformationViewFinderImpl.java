/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package larion.progate.service.persistence;

import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import larion.progate.model.User;
import larion.progate.model.UserInformationView;
import larion.progate.model.impl.UserImpl;
import larion.progate.model.impl.UserInformationViewImpl;
import larion.progate.service.persistence.UserInformationViewFinder;
import larion.progate.service.utils.Constants;

public class UserInformationViewFinderImpl extends BasePersistenceImpl
		implements UserInformationViewFinder {

	@Override
	@SuppressWarnings("unchecked")
	public List<User> findUsersToInvite(int orgId, String searchPhrase)
			throws SystemException {

		try {
			Session session = openSession();

			String sql = "select * from user_ "
					+ "where userid not in ( "
					+ "select user_id from progate_organization_participants "
					+ "where org_id = "
					+ orgId
					+ " and status in (1, 2, 3) and is_current = true) "
					+ "and active_ = true and emailaddress != 'default@liferay.com' "
					+ "and screenname != 'progateadmin' and screenname != 'admin'";

			if (searchPhrase != null && !"".equals(searchPhrase)) {

				sql += "and ( screenname like " + "'%"
						+ searchPhrase.toLowerCase() + "%'"
						+ " or firstname like " + "'%"
						+ searchPhrase.toLowerCase() + "%'"
						+ " or lastname like " + "'%"
						+ searchPhrase.toLowerCase() + "%' )";
			}

			sql += " order by screenname";

			System.out.println("findUsersToInvite sql: " + sql);

			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("User", UserImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);

			List<User> result = query.list();
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<UserInformationView> findOldMembers(int orgId, int roleId,
			String searchPhrase) {
		Session session = null;
		try {
			session = openSession();

			String sql = "SELECT distinct on (org_id, userid, status) * "
					+ "FROM v_user_information WHERE org_id = ? and joining_status = ? ";

			if (roleId != Constants.NONE_FILTER_ROLEID) {
				sql += "and role_id = " + roleId;
			}

			if (searchPhrase != null && !"".equals(searchPhrase)) {
				sql += " and ( screenname like " + "'%"
						+ searchPhrase.toLowerCase() + "%'"
						+ " or firstname like " + "'%"
						+ searchPhrase.toLowerCase() + "%'"
						+ " or lastname like " + "'%"
						+ searchPhrase.toLowerCase() + "%' )";
			}

			sql += " order by org_id, userid, status";

			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("UserInformationView",
					UserInformationViewImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(orgId);
			qPos.add(Constants.ORG_USER_STATUS_LEFT_ORG);

			System.out.println("findOldMembers with orgId =  " + orgId
					+ " - roleId = " + roleId + " - searchPhrase = "
					+ searchPhrase);
			System.out.println("sql: " + sql);

			List<UserInformationView> result = query.list();

			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> findListUsers(int isProactive, int status,
			String searchPhrase) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT * FROM user_ WHERE active_ = true "
					+ "and emailaddress != 'default@liferay.com' and screenname != 'progateadmin' and screenname != 'admin'";

			if (isProactive == 0 || isProactive == 1) {
				sql += " and is_proactive = "
						+ ((isProactive == 1) ? true : false);
			}

			if (status == 0 || status == 1) {
				sql += " and status = " + ((status == 1) ? true : false);
			}

			if (searchPhrase != null && !"".equals(searchPhrase)) {
				sql += " and ( screenname like " + "'%"
						+ searchPhrase.toLowerCase() + "%'"
						+ " or firstname like " + "'%"
						+ searchPhrase.toLowerCase() + "%'"
						+ " or lastname like " + "'%"
						+ searchPhrase.toLowerCase() + "%'"
						+ " or emailaddress like " + "'%"
						+ searchPhrase.toLowerCase() + "%' ) ";
			}

			sql += " order by screenname";

			System.out.println("sql findUser: " + sql);

			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("User", UserImpl.class);

			List<User> result = query.list();

			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<UserInformationView> findUserInformationViewDetail(int userId,
			int roleId, String searchPhrase) throws SystemException {
		Session session = null;
		try {
			session = openSession();

			String sql = "SELECT * "
					+ " FROM v_user_information "
					+ " WHERE org_name != '' and parent_id = 0 and userid = ? and joining_status = 3 ";

			if (roleId != 0) {
				sql = sql + " and roleid = " + roleId;
			}

			if (searchPhrase != null && !"".equals(searchPhrase)) {
				sql = sql + " and search_information like " + "'%"
						+ searchPhrase.toLowerCase() + "%'";
			}

			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("UserInformationView",
					UserInformationViewImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(userId);

			List<UserInformationView> result = query.list();

			System.out.println("findUserInformationViewDetail");
			System.out.println("sql: " + sql);

			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}