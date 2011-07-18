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

import larion.progate.model.ProGateJournalArticle;
import larion.progate.model.ProGateJournalArticlePriorities;
import larion.progate.model.ProGateJournalArticleTypes;
import larion.progate.model.ProGateJournalArticleView;
import larion.progate.service.ProGateJournalArticleLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil;
import larion.progate.service.persistence.ProGateJournalArticlePrioritiesUtil;
import larion.progate.service.persistence.ProGateJournalArticleTypesUtil;
import larion.progate.service.persistence.ProGateJournalArticleUtil;
import larion.progate.service.persistence.ProGateJournalArticleViewUtil;

import com.liferay.portlet.journal.model.JournalArticle;

public class JournalArticleTypesUtils {

	public static int getJournalArticleTypesIdByName(String name) {

		int articalId;
		try {
			List<ProGateJournalArticleTypes> articalType = ProGateJournalArticleTypesUtil
					.findByname(name);

			if ((articalType != null) && (articalType.size() > 0)) {
				articalId = articalType.get(0).getPrimaryKey();
			} else {
				articalId = 0;
			}
		} catch (Exception e) {
			// TODO: handle exception
			articalId = -1;
			System.out
					.println("Errors in JournalArticleTypesUtils.getJournalArticleTypesIdByName: "
							+ e.toString());
		}

		return articalId;
	}

	public static List<ProGateJournalArticle> getListArticleByType(int orgId,
			String articleType, String addInfo, int start, int end) {

		List<ProGateJournalArticle> result;
		try {
			List<ProGateJournalArticle> listArticleByOrgId = null;
			listArticleByOrgId = ProGateJournalArticleUtil.findByorgId(Integer
					.toString(orgId));

			int articleTypeId = getJournalArticleTypesIdByName(articleType);

			List<ProGateJournalArticle> listArticleByArtType = ProGateJournalArticleUtil
					.findByarticleTypeEquals(articleTypeId);

			@SuppressWarnings("unchecked")
			List<ProGateJournalArticle> listArticleResult = ListUtils
					.intersection(listArticleByOrgId, listArticleByArtType);
			if (end > listArticleResult.size()) {
				result = listArticleResult.subList(start,
						listArticleResult.size());
			} else {
				result = listArticleResult.subList(start, end);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in JournalArticleTypesUtils.getListArticleByType: "
							+ e.toString());
			result = null;
		}

		return result;
	}

	public static List<ProGateJournalArticle> getListBlogArticles(int userId, String addInfo, int start, int end) {

		List<ProGateJournalArticle> result;
		try {
			List<ProGateJournalArticle> listArticleByOrgId = null;
			listArticleByOrgId = ProGateJournalArticleUtil.findByorgId(Integer
					.toString(-1));

			int articleTypeId = ProGateJournalArticleTypesUtil.findByname("Org_News").get(0).getPrimaryKey();

			List<ProGateJournalArticle> listArticleByArtType = ProGateJournalArticleUtil
					.findByarticleTypeEquals(articleTypeId);

			List<ProGateJournalArticle> listArticleByUserId = ProGateJournalArticleUtil
					.findBycreatedBy(userId);

			@SuppressWarnings("unchecked")
			List<ProGateJournalArticle> listArticleResult = ListUtils
					.intersection(listArticleByOrgId, ListUtils
							.intersection(listArticleByUserId, listArticleByArtType));
			if (end > listArticleResult.size()) {
				result = listArticleResult.subList(start,
						listArticleResult.size());
			} else {
				result = listArticleResult.subList(start, end);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in JournalArticleTypesUtils.getListBlogArticles: "
							+ e.toString());
			result = null;
		}

		return result;
	}

	public static int countArticleByType(int orgId, String articleType,
			String addInfo) {

		int result;
		try {
			List<ProGateJournalArticle> listArticleByOrgId = null;
			listArticleByOrgId = ProGateJournalArticleUtil.findByorgId(Integer
					.toString(orgId));

			// System.out.println("AAAAAAAAAAAAAAAAAA");
			// System.out.println(articleType);
			// System.out.println(getJournalArticleTypesIdByName(articleType));
			// System.out.println("UUUUUUUUUUUUUU");

			List<ProGateJournalArticle> listArticleByArtType = ProGateJournalArticleUtil
					.findByarticleTypeEquals(getJournalArticleTypesIdByName(articleType));

			@SuppressWarnings("unchecked")
			List<ProGateJournalArticle> listArticleResult = ListUtils
					.intersection(listArticleByOrgId, listArticleByArtType);
			if ((listArticleResult != null) && (listArticleResult.size() > 0)) {
				result = listArticleResult.size();
			} else {
				result = 0;
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in JournalArticleTypesUtils.countArticleByType: "
							+ e.toString());
			result = -1;
		}

		return result;
	}

	public static List<ProGateJournalArticle> getListArticleByTypeAndPriority(
			int orgId, String articleType, boolean isHot, String addInfo,
			int start, int end) {

		List<ProGateJournalArticle> result;
		try {
			List<ProGateJournalArticle> listArticleByOrgId = null;
			listArticleByOrgId = ProGateJournalArticleUtil.findByorgId(Integer
					.toString(orgId));

			int articleTypeId = getJournalArticleTypesIdByName(articleType);

			List<ProGateJournalArticle> listArticleByArtType = ProGateJournalArticleUtil
					.findByarticleTypeEquals(articleTypeId);
			int priorityId;
			if (isHot) {
				priorityId = ProGateJournalArticlePrioritiesUtil
						.findByname("Important").get(0).getPrimaryKey();
			} else {
				priorityId = ProGateJournalArticlePrioritiesUtil
						.findByname("Normal").get(0).getPrimaryKey();
			}

			List<ProGateJournalArticle> listArticleByPriority = ProGateJournalArticleUtil
					.findBypriorityEqual(priorityId);

			@SuppressWarnings("unchecked")
			List<ProGateJournalArticle> listArticleResult = ListUtils
					.intersection(ListUtils.intersection(listArticleByOrgId,
							listArticleByArtType), listArticleByPriority);
			if (end > listArticleResult.size()) {
				result = listArticleResult.subList(start,
						listArticleResult.size());
			} else {
				result = listArticleResult.subList(start, end);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in JournalArticleTypesUtils.getListArticleByType: "
							+ e.toString());
			result = null;
		}

		return result;
	}

	public static int countListArticleByTypeAndPriority(int orgId,
			String articleType, boolean isHot, String addInfo) {

		int result = 0;
		try {
			List<ProGateJournalArticle> listArticleByOrgId = null;
			listArticleByOrgId = ProGateJournalArticleUtil.findByorgId(Integer
					.toString(orgId));

			int articleTypeId = getJournalArticleTypesIdByName(articleType);

			List<ProGateJournalArticle> listArticleByArtType = ProGateJournalArticleUtil
					.findByarticleTypeEquals(articleTypeId);
			int priorityId;
			if (isHot) {
				priorityId = ProGateJournalArticlePrioritiesUtil
						.findByname("Important").get(0).getPrimaryKey();
			} else {
				priorityId = ProGateJournalArticlePrioritiesUtil
						.findByname("Normal").get(0).getPrimaryKey();
			}

			List<ProGateJournalArticle> listArticleByPriority = ProGateJournalArticleUtil
					.findBypriorityEqual(priorityId);

			@SuppressWarnings("unchecked")
			List<ProGateJournalArticle> listArticleResult = ListUtils
					.intersection(ListUtils.intersection(listArticleByOrgId,
							listArticleByArtType), listArticleByPriority);
			if (listArticleResult != null) {
				result = listArticleResult.size();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in JournalArticleTypesUtils.countListArticleByTypeAndPriority: "
							+ e.toString());
			result = -1;
		}

		return result;
	}

	public static List<ProGateJournalArticle> getListCertArticles(int orgId,
			String addInfo, int start, int end) {

		List<ProGateJournalArticle> result;
		try {
			List<ProGateJournalArticle> listArticleByOrgId = null;
			listArticleByOrgId = ProGateJournalArticleUtil.findByorgId(Integer
					.toString(orgId));

			int articleTypeId = getJournalArticleTypesIdByName(ProGateJournalArticleTypesUtil
					.findByname("Org_Cert").get(0).getName());

			List<ProGateJournalArticle> listArticleByArtType = ProGateJournalArticleUtil
					.findByarticleTypeEquals(articleTypeId);

			@SuppressWarnings("unchecked")
			List<ProGateJournalArticle> listArticleResult = ListUtils
					.intersection(listArticleByOrgId, listArticleByArtType);
			List<List<Object>> listData = new ArrayList<List<Object>>(
					listArticleResult.size());
			for (ProGateJournalArticle proGateJournalArticle : listArticleResult) {
				List<Object> data1Article = new ArrayList<Object>(2);
				data1Article.add(proGateJournalArticle.getAddInfo());
				data1Article.add(proGateJournalArticle);
			}
			// will write code to sort here

			if (end > listArticleResult.size()) {
				result = listArticleResult.subList(start,
						listArticleResult.size());
			} else {
				result = listArticleResult.subList(start, end);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in JournalArticleTypesUtils.getListCertArticles: "
							+ e.toString());
			result = null;
		}

		return result;
	}

	public static List<ProGateJournalArticle> getListAchievementArticles(
			int orgId, String addInfo, int start, int end) {

		List<ProGateJournalArticle> result;
		try {
			List<ProGateJournalArticle> listArticleByOrgId = null;
			listArticleByOrgId = ProGateJournalArticleUtil.findByorgId(Integer
					.toString(orgId));

			int articleTypeId = getJournalArticleTypesIdByName(ProGateJournalArticleTypesUtil
					.findByname("Org_Achievement").get(0).getName());

			List<ProGateJournalArticle> listArticleByArtType = ProGateJournalArticleUtil
					.findByarticleTypeEquals(articleTypeId);

			@SuppressWarnings("unchecked")
			List<ProGateJournalArticle> listArticleResult = ListUtils
					.intersection(listArticleByOrgId, listArticleByArtType);
			List<List<Object>> listData = new ArrayList<List<Object>>(
					listArticleResult.size());
			for (ProGateJournalArticle proGateJournalArticle : listArticleResult) {
				List<Object> data1Article = new ArrayList<Object>(2);
				data1Article.add(proGateJournalArticle.getAddInfo());
				data1Article.add(proGateJournalArticle);
			}
			// will write code to sort here

			if (end > listArticleResult.size()) {
				result = listArticleResult.subList(start,
						listArticleResult.size());
			} else {
				result = listArticleResult.subList(start, end);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in JournalArticleTypesUtils.getListAchievementArticles: "
							+ e.toString());
			result = null;
		}

		return result;
	}

	public static int countListCertArticles(int orgId, String addInfo) {

		int result = 0;
		try {
			List<ProGateJournalArticle> listArticleByOrgId = null;
			listArticleByOrgId = ProGateJournalArticleUtil.findByorgId(Integer
					.toString(orgId));

			int articleTypeId = getJournalArticleTypesIdByName(ProGateJournalArticleTypesUtil
					.findByname("Org_Cert").get(0).getName());

			List<ProGateJournalArticle> listArticleByArtType = ProGateJournalArticleUtil
					.findByarticleTypeEquals(articleTypeId);

			@SuppressWarnings("unchecked")
			List<ProGateJournalArticle> listArticleResult = ListUtils
					.intersection(listArticleByOrgId, listArticleByArtType);
			result = listArticleResult.size();

		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in JournalArticleTypesUtils.getListArticleByType: "
							+ e.toString());
			result = -1;
		}

		return result;
	}

	public static int countListAchievementArticles(int orgId, String addInfo) {

		int result = 0;
		try {
			List<ProGateJournalArticle> listArticleByOrgId = null;
			listArticleByOrgId = ProGateJournalArticleUtil.findByorgId(Integer
					.toString(orgId));

			int articleTypeId = getJournalArticleTypesIdByName(ProGateJournalArticleTypesUtil
					.findByname("Org_Achievement").get(0).getName());

			List<ProGateJournalArticle> listArticleByArtType = ProGateJournalArticleUtil
					.findByarticleTypeEquals(articleTypeId);

			@SuppressWarnings("unchecked")
			List<ProGateJournalArticle> listArticleResult = ListUtils
					.intersection(listArticleByOrgId, listArticleByArtType);
			result = listArticleResult.size();

		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Errors in JournalArticleTypesUtils.countListAchievementArticles: "
							+ e.toString());
			result = -1;
		}

		return result;
	}
}