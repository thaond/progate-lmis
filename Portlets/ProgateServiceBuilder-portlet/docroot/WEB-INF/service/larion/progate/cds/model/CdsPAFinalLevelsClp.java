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

package larion.progate.cds.model;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * <a href="CdsPAFinalLevelsClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPAFinalLevelsClp extends BaseModelImpl<CdsPAFinalLevels>
	implements CdsPAFinalLevels {
	public CdsPAFinalLevelsClp() {
	}

	public Integer getPrimaryKey() {
		return _CdsPAFinalLevelsId;
	}

	public void setPrimaryKey(Integer pk) {
		setCdsPAFinalLevelsId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _CdsPAFinalLevelsId;
	}

	public Integer getCdsPAFinalLevelsId() {
		return _CdsPAFinalLevelsId;
	}

	public void setCdsPAFinalLevelsId(Integer CdsPAFinalLevelsId) {
		_CdsPAFinalLevelsId = CdsPAFinalLevelsId;
	}

	public int getPaId() {
		return _paId;
	}

	public void setPaId(int paId) {
		_paId = paId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public int getLevelId() {
		return _levelId;
	}

	public void setLevelId(int levelId) {
		_levelId = levelId;
	}

	public int getTotalLevelPoint() {
		return _totalLevelPoint;
	}

	public void setTotalLevelPoint(int totalLevelPoint) {
		_totalLevelPoint = totalLevelPoint;
	}

	public boolean getIsPassed() {
		return _isPassed;
	}

	public boolean isIsPassed() {
		return _isPassed;
	}

	public void setIsPassed(boolean isPassed) {
		_isPassed = isPassed;
	}

	public CdsPAFinalLevels toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			CdsPAFinalLevels model = new CdsPAFinalLevelsClp();

			model.setEscapedModel(true);

			model.setCdsPAFinalLevelsId(getCdsPAFinalLevelsId());
			model.setPaId(getPaId());
			model.setRootId(getRootId());
			model.setUserId(getUserId());
			model.setLevelId(getLevelId());
			model.setTotalLevelPoint(getTotalLevelPoint());
			model.setIsPassed(getIsPassed());

			model = (CdsPAFinalLevels)Proxy.newProxyInstance(CdsPAFinalLevels.class.getClassLoader(),
					new Class[] { CdsPAFinalLevels.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		CdsPAFinalLevelsClp clone = new CdsPAFinalLevelsClp();

		clone.setCdsPAFinalLevelsId(getCdsPAFinalLevelsId());
		clone.setPaId(getPaId());
		clone.setRootId(getRootId());
		clone.setUserId(getUserId());
		clone.setLevelId(getLevelId());
		clone.setTotalLevelPoint(getTotalLevelPoint());
		clone.setIsPassed(getIsPassed());

		return clone;
	}

	public int compareTo(CdsPAFinalLevels cdsPAFinalLevels) {
		Integer pk = cdsPAFinalLevels.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CdsPAFinalLevelsClp cdsPAFinalLevels = null;

		try {
			cdsPAFinalLevels = (CdsPAFinalLevelsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = cdsPAFinalLevels.getPrimaryKey();

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

		sb.append("{CdsPAFinalLevelsId=");
		sb.append(getCdsPAFinalLevelsId());
		sb.append(", paId=");
		sb.append(getPaId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", levelId=");
		sb.append(getLevelId());
		sb.append(", totalLevelPoint=");
		sb.append(getTotalLevelPoint());
		sb.append(", isPassed=");
		sb.append(getIsPassed());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.cds.model.CdsPAFinalLevels");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>CdsPAFinalLevelsId</column-name><column-value><![CDATA[");
		sb.append(getCdsPAFinalLevelsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paId</column-name><column-value><![CDATA[");
		sb.append(getPaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>levelId</column-name><column-value><![CDATA[");
		sb.append(getLevelId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalLevelPoint</column-name><column-value><![CDATA[");
		sb.append(getTotalLevelPoint());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isPassed</column-name><column-value><![CDATA[");
		sb.append(getIsPassed());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _CdsPAFinalLevelsId;
	private int _paId;
	private int _rootId;
	private int _userId;
	private int _levelId;
	private int _totalLevelPoint;
	private boolean _isPassed;
}