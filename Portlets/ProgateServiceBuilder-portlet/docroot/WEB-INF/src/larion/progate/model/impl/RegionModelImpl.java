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

package larion.progate.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import larion.progate.model.Region;
import larion.progate.model.RegionSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="RegionModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class RegionModelImpl extends BaseModelImpl<Region> {
	public static final String TABLE_NAME = "region";
	public static final Object[][] TABLE_COLUMNS = {
			{ "regionid", new Integer(Types.INTEGER) },
			

			{ "name", new Integer(Types.VARCHAR) },
			

			{ "regioncode", new Integer(Types.VARCHAR) },
			

			{ "countryid", new Integer(Types.VARCHAR) },
			

			{ "active_", new Integer(Types.BOOLEAN) }
		};
	public static final String TABLE_SQL_CREATE = "create table region (regionid INTEGER not null primary key,name VARCHAR(75) null,regioncode VARCHAR(75) null,countryid VARCHAR(75) null,active_ BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table region";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.model.Region"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.model.Region"),
			false);

	public static Region toModel(RegionSoap soapModel) {
		Region model = new RegionImpl();

		model.setRegionId(soapModel.getRegionId());
		model.setName(soapModel.getName());
		model.setRegionCode(soapModel.getRegionCode());
		model.setCountryId(soapModel.getCountryId());
		model.setActive(soapModel.getActive());

		return model;
	}

	public static List<Region> toModels(RegionSoap[] soapModels) {
		List<Region> models = new ArrayList<Region>(soapModels.length);

		for (RegionSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.model.Region"));

	public RegionModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _regionId;
	}

	public void setPrimaryKey(Integer pk) {
		setRegionId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _regionId;
	}

	public Integer getRegionId() {
		return _regionId;
	}

	public void setRegionId(Integer regionId) {
		_regionId = regionId;
	}

	public String getName() {
		return GetterUtil.getString(_name);
	}

	public void setName(String name) {
		_name = name;
	}

	public String getRegionCode() {
		return GetterUtil.getString(_regionCode);
	}

	public void setRegionCode(String regionCode) {
		_regionCode = regionCode;
	}

	public String getCountryId() {
		return GetterUtil.getString(_countryId);
	}

	public void setCountryId(String countryId) {
		_countryId = countryId;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public Region toEscapedModel() {
		if (isEscapedModel()) {
			return (Region)this;
		}
		else {
			Region model = new RegionImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setRegionId(getRegionId());
			model.setName(HtmlUtil.escape(getName()));
			model.setRegionCode(HtmlUtil.escape(getRegionCode()));
			model.setCountryId(HtmlUtil.escape(getCountryId()));
			model.setActive(getActive());

			model = (Region)Proxy.newProxyInstance(Region.class.getClassLoader(),
					new Class[] { Region.class }, new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		RegionImpl clone = new RegionImpl();

		clone.setRegionId(getRegionId());
		clone.setName(getName());
		clone.setRegionCode(getRegionCode());
		clone.setCountryId(getCountryId());
		clone.setActive(getActive());

		return clone;
	}

	public int compareTo(Region region) {
		Integer pk = region.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		Region region = null;

		try {
			region = (Region)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = region.getPrimaryKey();

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

		sb.append("{regionId=");
		sb.append(getRegionId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", regionCode=");
		sb.append(getRegionCode());
		sb.append(", countryId=");
		sb.append(getCountryId());
		sb.append(", active=");
		sb.append(getActive());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.Region");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>regionId</column-name><column-value><![CDATA[");
		sb.append(getRegionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionCode</column-name><column-value><![CDATA[");
		sb.append(getRegionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryId</column-name><column-value><![CDATA[");
		sb.append(getCountryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _regionId;
	private String _name;
	private String _regionCode;
	private String _countryId;
	private boolean _active;
}