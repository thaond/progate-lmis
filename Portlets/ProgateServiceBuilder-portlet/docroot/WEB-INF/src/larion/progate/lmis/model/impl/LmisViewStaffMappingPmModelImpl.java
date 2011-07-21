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

package larion.progate.lmis.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import larion.progate.lmis.model.LmisViewStaffMappingPm;
import larion.progate.lmis.model.LmisViewStaffMappingPmSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="LmisViewStaffMappingPmModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewStaffMappingPmModelImpl extends BaseModelImpl<LmisViewStaffMappingPm> {
	public static final String TABLE_NAME = "vw_lmis_staff_mapping_pm";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "org_id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "bod_id", new Integer(Types.INTEGER) },
			

			{ "staff_uid", new Integer(Types.INTEGER) },
			

			{ "pm_uid", new Integer(Types.INTEGER) },
			

			{ "staff_code", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table vw_lmis_staff_mapping_pm (id INTEGER not null primary key,org_id INTEGER,root_id INTEGER,bod_id INTEGER,staff_uid INTEGER,pm_uid INTEGER,staff_code VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table vw_lmis_staff_mapping_pm";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.lmis.model.LmisViewStaffMappingPm"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.lmis.model.LmisViewStaffMappingPm"),
			false);

	public static LmisViewStaffMappingPm toModel(
		LmisViewStaffMappingPmSoap soapModel) {
		LmisViewStaffMappingPm model = new LmisViewStaffMappingPmImpl();

		model.setLmisViewStaffMappingPmId(soapModel.getLmisViewStaffMappingPmId());
		model.setOrgId(soapModel.getOrgId());
		model.setRootId(soapModel.getRootId());
		model.setBodId(soapModel.getBodId());
		model.setStaffUID(soapModel.getStaffUID());
		model.setPmUID(soapModel.getPmUID());
		model.setStaffCode(soapModel.getStaffCode());

		return model;
	}

	public static List<LmisViewStaffMappingPm> toModels(
		LmisViewStaffMappingPmSoap[] soapModels) {
		List<LmisViewStaffMappingPm> models = new ArrayList<LmisViewStaffMappingPm>(soapModels.length);

		for (LmisViewStaffMappingPmSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.lmis.model.LmisViewStaffMappingPm"));

	public LmisViewStaffMappingPmModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _lmisViewStaffMappingPmId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisViewStaffMappingPmId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisViewStaffMappingPmId;
	}

	public Integer getLmisViewStaffMappingPmId() {
		return _lmisViewStaffMappingPmId;
	}

	public void setLmisViewStaffMappingPmId(Integer lmisViewStaffMappingPmId) {
		_lmisViewStaffMappingPmId = lmisViewStaffMappingPmId;
	}

	public int getOrgId() {
		return _orgId;
	}

	public void setOrgId(int orgId) {
		_orgId = orgId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getBodId() {
		return _bodId;
	}

	public void setBodId(int bodId) {
		_bodId = bodId;
	}

	public int getStaffUID() {
		return _staffUID;
	}

	public void setStaffUID(int staffUID) {
		_staffUID = staffUID;
	}

	public int getPmUID() {
		return _pmUID;
	}

	public void setPmUID(int pmUID) {
		_pmUID = pmUID;
	}

	public String getStaffCode() {
		return GetterUtil.getString(_staffCode);
	}

	public void setStaffCode(String staffCode) {
		_staffCode = staffCode;
	}

	public LmisViewStaffMappingPm toEscapedModel() {
		if (isEscapedModel()) {
			return (LmisViewStaffMappingPm)this;
		}
		else {
			LmisViewStaffMappingPm model = new LmisViewStaffMappingPmImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setLmisViewStaffMappingPmId(getLmisViewStaffMappingPmId());
			model.setOrgId(getOrgId());
			model.setRootId(getRootId());
			model.setBodId(getBodId());
			model.setStaffUID(getStaffUID());
			model.setPmUID(getPmUID());
			model.setStaffCode(HtmlUtil.escape(getStaffCode()));

			model = (LmisViewStaffMappingPm)Proxy.newProxyInstance(LmisViewStaffMappingPm.class.getClassLoader(),
					new Class[] { LmisViewStaffMappingPm.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisViewStaffMappingPmImpl clone = new LmisViewStaffMappingPmImpl();

		clone.setLmisViewStaffMappingPmId(getLmisViewStaffMappingPmId());
		clone.setOrgId(getOrgId());
		clone.setRootId(getRootId());
		clone.setBodId(getBodId());
		clone.setStaffUID(getStaffUID());
		clone.setPmUID(getPmUID());
		clone.setStaffCode(getStaffCode());

		return clone;
	}

	public int compareTo(LmisViewStaffMappingPm lmisViewStaffMappingPm) {
		Integer pk = lmisViewStaffMappingPm.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisViewStaffMappingPm lmisViewStaffMappingPm = null;

		try {
			lmisViewStaffMappingPm = (LmisViewStaffMappingPm)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisViewStaffMappingPm.getPrimaryKey();

		if (getPrimaryKey().equals(pk)) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("{lmisViewStaffMappingPmId=");
		sb.append(getLmisViewStaffMappingPmId());
		sb.append(", orgId=");
		sb.append(getOrgId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", bodId=");
		sb.append(getBodId());
		sb.append(", staffUID=");
		sb.append(getStaffUID());
		sb.append(", pmUID=");
		sb.append(getPmUID());
		sb.append(", staffCode=");
		sb.append(getStaffCode());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisViewStaffMappingPm");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisViewStaffMappingPmId</column-name><column-value><![CDATA[");
		sb.append(getLmisViewStaffMappingPmId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgId</column-name><column-value><![CDATA[");
		sb.append(getOrgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bodId</column-name><column-value><![CDATA[");
		sb.append(getBodId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>staffUID</column-name><column-value><![CDATA[");
		sb.append(getStaffUID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pmUID</column-name><column-value><![CDATA[");
		sb.append(getPmUID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>staffCode</column-name><column-value><![CDATA[");
		sb.append(getStaffCode());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisViewStaffMappingPmId;
	private int _orgId;
	private int _rootId;
	private int _bodId;
	private int _staffUID;
	private int _pmUID;
	private String _staffCode;
}