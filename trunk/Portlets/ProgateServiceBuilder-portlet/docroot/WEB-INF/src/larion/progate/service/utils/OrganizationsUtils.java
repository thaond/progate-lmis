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
import larion.progate.service.ProGateJournalArticleLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil;
import larion.progate.service.persistence.OrganizationUtil;
import larion.progate.service.persistence.ProGateJournalArticlePrioritiesUtil;
import larion.progate.service.persistence.ProGateJournalArticleTypesUtil;
import larion.progate.service.persistence.ProGateJournalArticleUtil;
import larion.progate.service.persistence.ProGateJournalArticleViewUtil;

import com.liferay.portlet.journal.model.JournalArticle;

public class OrganizationsUtils {

	public static int[] getListRelationOrgId(int currentOrgId, int parentOrgId) {

		int[] result = new int[5];
		try {
			// return CURRENTORGID, PARENTID, BODID, ROOTID
			
			
			Organization parentObj = OrganizationUtil.findByPrimaryKey(parentOrgId);
			int rootId = parentObj.getRootId();
			Organization org = OrganizationUtil.findByPrimaryKey(currentOrgId);
			int bodId;
			if (rootId == parentOrgId) {
				bodId = currentOrgId;
			} else {
				bodId = parentObj.getBodId();
			}
			int level = 0;
			
			try {
				level = parentObj.getLevel();
			} catch (Exception e) {
				System.out.println("Org level is null");
			}
			

			result[0] = currentOrgId;
			result[1] = parentOrgId;
			result[2] = bodId;
			result[3] = rootId;
			result[4] = level + 1;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Errors in getListRelationOrgId: "
					+ e.toString());
			result = null;
		}

		return result;
	}

	public static boolean updateOrgLevel(Organization org) {
		try {
			int startLevel = 0;
			int orgIdTemp = org.getPrimaryKey();
			int rootId = org.getRootId();
			do {
				startLevel++;
				orgIdTemp = getParentOrgId(orgIdTemp);
				if (orgIdTemp == 0 || startLevel > 10) {
					break;
				}

			} while (orgIdTemp != rootId);
			org.setLevel(startLevel);
			OrganizationUtil.update(org, false);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Errors in updateOrgLevel: " + e.toString());
			return false;
		}
	}
	
	public static int getMaxLevel(int rootId) {
		try {
			int startLevel = 0;
			List<Organization> listOrg = OrganizationUtil.findByrootId(rootId);
			if (listOrg.size() > 0) {
				startLevel = listOrg.get(0).getLevel();
				for (Organization organization : listOrg) {
					if (organization.getLevel() > startLevel) {
						startLevel = organization.getLevel();
					}
				}
			}
			
			return startLevel;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Errors in getMaxLevel: " + e.toString());
			return 0;
		}
	}

	public static int getParentOrgId(int currentOrgId) {

		int result = 0;
		try {
			if (currentOrgId != 0) {
				Organization org = OrganizationUtil
						.findByPrimaryKey(currentOrgId);
				return org.getOrgParent();
			} else {
				return 0;
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Errors in getParentOrgId: " + e.toString());
			result = 0;
		}

		return result;
	}
}