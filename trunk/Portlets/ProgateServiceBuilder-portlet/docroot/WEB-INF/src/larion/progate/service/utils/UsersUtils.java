/**
 * 
 * @author quann
 *
 */

package larion.progate.service.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.apache.ecs.storage.Array;

import larion.progate.model.Organization;
import larion.progate.model.ProGateJournalArticle;
import larion.progate.model.ProGateJournalArticlePriorities;
import larion.progate.model.ProGateJournalArticleTypes;
import larion.progate.model.ProGateJournalArticleView;
import larion.progate.model.User;
import larion.progate.model.UserInformationView;
import larion.progate.service.ProGateJournalArticleLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil;
import larion.progate.service.persistence.OrganizationUtil;
import larion.progate.service.persistence.ProGateJournalArticlePrioritiesUtil;
import larion.progate.service.persistence.ProGateJournalArticleTypesUtil;
import larion.progate.service.persistence.ProGateJournalArticleUtil;
import larion.progate.service.persistence.ProGateJournalArticleViewUtil;
import larion.progate.service.persistence.UserInformationViewUtil;
import larion.progate.service.persistence.UserUtil;

import com.liferay.portlet.journal.model.JournalArticle;

public class UsersUtils {

	public static List<UserInformationView> getListAllUser() {

		List<UserInformationView> result = new ArrayList<UserInformationView>();
		try {
			List<User> listAllUser = UserUtil.findAll();
//			for (User user : listAllUser) {
//				result.add(UserInformationViewUtil.findByPrimaryKey(user.getPrimaryKey()));
//			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Errors in getListAllUser: "
					+ e.toString());
			result = null;
		}

		return result;
	}

}
