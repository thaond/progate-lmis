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
import com.liferay.portal.model.impl.BaseModelImpl;

import larion.progate.lmis.model.LmisViewStaffMapping;
import larion.progate.lmis.model.LmisViewStaffMappingSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="LmisViewStaffMappingModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewStaffMappingModelImpl extends BaseModelImpl<LmisViewStaffMapping> {
	public static final String TABLE_NAME = "vw_staff_mapping";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "org_id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "bod_id", new Integer(Types.INTEGER) },
			

			{ "staff_uid", new Integer(Types.INTEGER) },
			

			{ "pm_uid", new Integer(Types.INTEGER) },
			

			{ "bod_uid", new Integer(Types.INTEGER) }
		};
	public static final String TABLE_SQL_CREATE = "create table vw_staff_mapping (id INTEGER not null primary key,org_id INTEGER,root_id INTEGER,bod_id INTEGER,staff_uid INTEGER,pm_uid INTEGER,bod_uid INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table vw_staff_mapping";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.lmis.model.LmisViewStaffMapping"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.lmis.model.LmisViewStaffMapping"),
			false);

	public static LmisViewStaffMapping toModel(
		LmisViewStaffMappingSoap soapModel) {
		LmisViewStaffMapping model = new LmisViewStaffMappingImpl();

		model.setLmisViewStaffMappingId(soapModel.getLmisViewStaffMappingId());
		model.setOrgId(soapModel.getOrgId());
		model.setRootId(soapModel.getRootId());
		model.setBodId(soapModel.getBodId());
		model.setStaffUID(soapModel.getStaffUID());
		model.setPmUID(soapModel.getPmUID());
		model.setBodUID(soapModel.getBodUID());

		return model;
	}

	public static List<LmisViewStaffMapping> toModels(
		LmisViewStaffMappingSoap[] soapModels) {
		List<LmisViewStaffMapping> models = new ArrayList<LmisViewStaffMapping>(soapModels.length);

		for (LmisViewStaffMappingSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.lmis.model.LmisViewStaffMapping"));

	public LmisViewStaffMappingModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _lmisViewStaffMappingId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisViewStaffMappingId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisViewStaffMappingId;
	}

	public Integer getLmisViewStaffMappingId() {
		return _lmisViewStaffMappingId;
	}

	public void setLmisViewStaffMappingId(Integer lmisViewStaffMappingId) {
		_lmisViewStaffMappingId = lmisViewStaffMappingId;
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

	public int getBodUID() {
		return _bodUID;
	}

	public void setBodUID(int bodUID) {
		_bodUID = bodUID;
	}

	public LmisViewStaffMapping toEscapedModel() {
		if (isEscapedModel()) {
			return (LmisViewStaffMapping)this;
		}
		else {
			LmisViewStaffMapping model = new LmisViewStaffMappingImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setLmisViewStaffMappingId(getLmisViewStaffMappingId());
			model.setOrgId(getOrgId());
			model.setRootId(getRootId());
			model.setBodId(getBodId());
			model.setStaffUID(getStaffUID());
			model.setPmUID(getPmUID());
			model.setBodUID(getBodUID());

			model = (LmisViewStaffMapping)Proxy.newProxyInstance(LmisViewStaffMapping.class.getClassLoader(),
					new Class[] { LmisViewStaffMapping.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisViewStaffMappingImpl clone = new LmisViewStaffMappingImpl();

		clone.setLmisViewStaffMappingId(getLmisViewStaffMappingId());
		clone.setOrgId(getOrgId());
		clone.setRootId(getRootId());
		clone.setBodId(getBodId());
		clone.setStaffUID(getStaffUID());
		clone.setPmUID(getPmUID());
		clone.setBodUID(getBodUID());

		return clone;
	}

	public int compareTo(LmisViewStaffMapping lmisViewStaffMapping) {
		Integer pk = lmisViewStaffMapping.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisViewStaffMapping lmisViewStaffMapping = null;

		try {
			lmisViewStaffMapping = (LmisViewStaffMapping)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisViewStaffMapping.getPrimaryKey();

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

		sb.append("{lmisViewStaffMappingId=");
		sb.append(getLmisViewStaffMappingId());
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
		sb.append(", bodUID=");
		sb.append(getBodUID());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisViewStaffMapping");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisViewStaffMappingId</column-name><column-value><![CDATA[");
		sb.append(getLmisViewStaffMappingId());
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
			"<column><column-name>bodUID</column-name><column-value><![CDATA[");
		sb.append(getBodUID());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisViewStaffMappingId;
	private int _orgId;
	private int _rootId;
	private int _bodId;
	private int _staffUID;
	private int _pmUID;
	private int _bodUID;
}