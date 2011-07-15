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

package larion.progate.cds.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModel;

import larion.progate.cds.model.CdsCdpClp;
import larion.progate.cds.model.CdsCompetencyStatisticalReportClp;
import larion.progate.cds.model.CdsEvaluationPeriodsClp;
import larion.progate.cds.model.CdsLevelStatisticalReportClp;
import larion.progate.cds.model.CdsMinimumRequirementLevelsClp;
import larion.progate.cds.model.CdsMinimumRequirementsClp;
import larion.progate.cds.model.CdsPACompetenciesClp;
import larion.progate.cds.model.CdsPAFinalClp;
import larion.progate.cds.model.CdsPAFinalCompeteniesClp;
import larion.progate.cds.model.CdsPAFinalLevelsClp;
import larion.progate.cds.model.CdsPAFinalSlotsClp;
import larion.progate.cds.model.CdsPALevelsClp;
import larion.progate.cds.model.CdsPASlotsClp;
import larion.progate.cds.model.CdsPerformanceAppraisalSlotCommentsClp;
import larion.progate.cds.model.CdsPerformanceAppraisalSlotRatingClp;
import larion.progate.cds.model.CdsPerformanceAppraisalsClp;
import larion.progate.cds.model.CdsPointsClp;
import larion.progate.cds.model.CdsSlotStatisticalReportClp;
import larion.progate.cds.model.CdsTitleCompetenciesClp;
import larion.progate.cds.model.CdsTitleMinimumRequirementsClp;
import larion.progate.cds.model.CdsTitlesClp;
import larion.progate.cds.model.CompetencyClp;
import larion.progate.cds.model.LevelClp;
import larion.progate.cds.model.SlotClp;
import larion.progate.cds.model.ViewEmployeesInProjectsClp;
import larion.progate.cds.model.ViewEmployeesSlotsRatingClp;
import larion.progate.cds.model.ViewFinalCompetenciesClp;
import larion.progate.cds.model.ViewFinalLevelsClp;
import larion.progate.cds.model.ViewFinalSlotsClp;
import larion.progate.cds.model.ViewFinalTitlesClp;
import larion.progate.cds.model.ViewListTitleCompetenciesClp;
import larion.progate.cds.model.ViewListTitleMinimumRequirementsClp;
import larion.progate.cds.model.ViewPerformanceAppraisalLevelsClp;
import larion.progate.cds.model.ViewPerformanceAppraisalSlotsClp;
import larion.progate.cds.model.ViewSlotInformationClp;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="ClpSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ClpSerializer {
	public static final String SERVLET_CONTEXT_NAME = "ProgateServiceBuilder-portlet";

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(CompetencyClp.class.getName())) {
			CompetencyClp oldCplModel = (CompetencyClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.CompetencyImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setCompetencyId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getCompetencyId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value2 = oldCplModel.getName();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value3 = oldCplModel.getDescription();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setNumberOrder",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getNumberOrder());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setCreatedBy",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getCreatedBy());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setCreatedAt",
							new Class[] { Date.class });

					Date value6 = oldCplModel.getCreatedAt();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setUpdatedBy",
							new Class[] { Integer.TYPE });

					Integer value7 = new Integer(oldCplModel.getUpdatedBy());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setUpdatedAt",
							new Class[] { Date.class });

					Date value8 = oldCplModel.getUpdatedAt();

					method8.invoke(newModel, value8);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(LevelClp.class.getName())) {
			LevelClp oldCplModel = (LevelClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.LevelImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value0 = new Integer(oldCplModel.getRootId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setLevelId",
							new Class[] { Integer.class });

					Integer value1 = oldCplModel.getLevelId();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setCompetencyId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getCompetencyId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value3 = oldCplModel.getName();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value4 = oldCplModel.getDescription();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setNumberOrder",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getNumberOrder());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setAliasName",
							new Class[] { String.class });

					String value6 = oldCplModel.getAliasName();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setCreatedBy",
							new Class[] { Integer.TYPE });

					Integer value7 = new Integer(oldCplModel.getCreatedBy());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setCreatedAt",
							new Class[] { Date.class });

					Date value8 = oldCplModel.getCreatedAt();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setUpdatedBy",
							new Class[] { Integer.TYPE });

					Integer value9 = new Integer(oldCplModel.getUpdatedBy());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setUpdatedAt",
							new Class[] { Date.class });

					Date value10 = oldCplModel.getUpdatedAt();

					method10.invoke(newModel, value10);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(SlotClp.class.getName())) {
			SlotClp oldCplModel = (SlotClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.SlotImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value0 = new Integer(oldCplModel.getRootId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setSlotId",
							new Class[] { Integer.class });

					Integer value1 = oldCplModel.getSlotId();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setLevelId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getLevelId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value3 = oldCplModel.getName();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value4 = oldCplModel.getDescription();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setNumberOrder",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getNumberOrder());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setAliasName",
							new Class[] { String.class });

					String value6 = oldCplModel.getAliasName();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setCreatedBy",
							new Class[] { Integer.TYPE });

					Integer value7 = new Integer(oldCplModel.getCreatedBy());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setCreatedAt",
							new Class[] { Date.class });

					Date value8 = oldCplModel.getCreatedAt();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setUpdatedBy",
							new Class[] { Integer.TYPE });

					Integer value9 = new Integer(oldCplModel.getUpdatedBy());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setUpdatedAt",
							new Class[] { Date.class });

					Date value10 = oldCplModel.getUpdatedAt();

					method10.invoke(newModel, value10);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(CdsPointsClp.class.getName())) {
			CdsPointsClp oldCplModel = (CdsPointsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.CdsPointsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setPointId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getPointId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setPointName",
							new Class[] { String.class });

					String value2 = oldCplModel.getPointName();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setPointValue",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getPointValue());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value4 = oldCplModel.getDescription();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setCreatedBy",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getCreatedBy());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setCreatedAt",
							new Class[] { Date.class });

					Date value6 = oldCplModel.getCreatedAt();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setUpdatedBy",
							new Class[] { Integer.TYPE });

					Integer value7 = new Integer(oldCplModel.getUpdatedBy());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setUpdatedAt",
							new Class[] { Date.class });

					Date value8 = oldCplModel.getUpdatedAt();

					method8.invoke(newModel, value8);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(CdsEvaluationPeriodsClp.class.getName())) {
			CdsEvaluationPeriodsClp oldCplModel = (CdsEvaluationPeriodsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.CdsEvaluationPeriodsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setCdsEvaluationPeriodsId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getCdsEvaluationPeriodsId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value2 = oldCplModel.getName();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setFromDate",
							new Class[] { Date.class });

					Date value3 = oldCplModel.getFromDate();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setToDate",
							new Class[] { Date.class });

					Date value4 = oldCplModel.getToDate();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setStartDate",
							new Class[] { Date.class });

					Date value5 = oldCplModel.getStartDate();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setEndDate",
							new Class[] { Date.class });

					Date value6 = oldCplModel.getEndDate();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setStatus",
							new Class[] { Integer.TYPE });

					Integer value7 = new Integer(oldCplModel.getStatus());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setCreatedBy",
							new Class[] { Integer.TYPE });

					Integer value8 = new Integer(oldCplModel.getCreatedBy());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setCreatedAt",
							new Class[] { Date.class });

					Date value9 = oldCplModel.getCreatedAt();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setUpdatedBy",
							new Class[] { Integer.TYPE });

					Integer value10 = new Integer(oldCplModel.getUpdatedBy());

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setUpdatedAt",
							new Class[] { Date.class });

					Date value11 = oldCplModel.getUpdatedAt();

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setIsModified",
							new Class[] { Boolean.TYPE });

					Boolean value12 = new Boolean(oldCplModel.getIsModified());

					method12.invoke(newModel, value12);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(CdsTitlesClp.class.getName())) {
			CdsTitlesClp oldCplModel = (CdsTitlesClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.CdsTitlesImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setCdsTitleId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getCdsTitleId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value2 = oldCplModel.getName();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setAbbreviation",
							new Class[] { String.class });

					String value3 = oldCplModel.getAbbreviation();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setNumberOrder",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getNumberOrder());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setCreatedBy",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getCreatedBy());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setCreatedAt",
							new Class[] { Date.class });

					Date value6 = oldCplModel.getCreatedAt();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setUpdatedBy",
							new Class[] { Integer.TYPE });

					Integer value7 = new Integer(oldCplModel.getUpdatedBy());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setUpdatedAt",
							new Class[] { Date.class });

					Date value8 = oldCplModel.getUpdatedAt();

					method8.invoke(newModel, value8);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(CdsTitleCompetenciesClp.class.getName())) {
			CdsTitleCompetenciesClp oldCplModel = (CdsTitleCompetenciesClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.CdsTitleCompetenciesImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setCdsTitleCompetenciesId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getCdsTitleCompetenciesId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setCdsTitleId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getCdsTitleId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setCompetencyId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getCompetencyId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setPointHash",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getPointHash());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setPointValue",
							new Class[] { String.class });

					String value4 = oldCplModel.getPointValue();

					method4.invoke(newModel, value4);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(CdsMinimumRequirementsClp.class.getName())) {
			CdsMinimumRequirementsClp oldCplModel = (CdsMinimumRequirementsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.CdsMinimumRequirementsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setMinimumRequirementId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getMinimumRequirementId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value2 = oldCplModel.getName();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value3 = oldCplModel.getDescription();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setNumberOrder",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getNumberOrder());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setCreatedBy",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getCreatedBy());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setCreatedAt",
							new Class[] { Date.class });

					Date value6 = oldCplModel.getCreatedAt();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setUpdatedBy",
							new Class[] { Integer.TYPE });

					Integer value7 = new Integer(oldCplModel.getUpdatedBy());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setUpdatedAt",
							new Class[] { Date.class });

					Date value8 = oldCplModel.getUpdatedAt();

					method8.invoke(newModel, value8);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					CdsTitleMinimumRequirementsClp.class.getName())) {
			CdsTitleMinimumRequirementsClp oldCplModel = (CdsTitleMinimumRequirementsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.CdsTitleMinimumRequirementsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setCdsTitleMinimumRequirementsId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getCdsTitleMinimumRequirementsId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setTitleId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getTitleId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setMinimumRequirementId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getMinimumRequirementId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setMinimumRequirementLevelId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getMinimumRequirementLevelId());

					method3.invoke(newModel, value3);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					CdsMinimumRequirementLevelsClp.class.getName())) {
			CdsMinimumRequirementLevelsClp oldCplModel = (CdsMinimumRequirementLevelsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.CdsMinimumRequirementLevelsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setMinimumRequirementLevelId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getMinimumRequirementLevelId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setMinimumRequirementId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getMinimumRequirementId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value2 = oldCplModel.getName();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value3 = oldCplModel.getDescription();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setNumberOrder",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getNumberOrder());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setCreatedBy",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getCreatedBy());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setCreatedAt",
							new Class[] { Date.class });

					Date value6 = oldCplModel.getCreatedAt();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setUpdatedBy",
							new Class[] { Integer.TYPE });

					Integer value7 = new Integer(oldCplModel.getUpdatedBy());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setUpdatedAt",
							new Class[] { Date.class });

					Date value8 = oldCplModel.getUpdatedAt();

					method8.invoke(newModel, value8);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					ViewListTitleCompetenciesClp.class.getName())) {
			ViewListTitleCompetenciesClp oldCplModel = (ViewListTitleCompetenciesClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.ViewListTitleCompetenciesImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setId",
							new Class[] { String.class });

					String value0 = oldCplModel.getId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setTitleId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getTitleId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRootId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setTitleName",
							new Class[] { String.class });

					String value3 = oldCplModel.getTitleName();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setAbbreviation",
							new Class[] { String.class });

					String value4 = oldCplModel.getAbbreviation();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setCompetencyId",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getCompetencyId());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setCompetencyName",
							new Class[] { String.class });

					String value6 = oldCplModel.getCompetencyName();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setCompetencyNumberOrder",
							new Class[] { Integer.TYPE });

					Integer value7 = new Integer(oldCplModel.getCompetencyNumberOrder());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setPointHash",
							new Class[] { Integer.TYPE });

					Integer value8 = new Integer(oldCplModel.getPointHash());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setPointValue",
							new Class[] { String.class });

					String value9 = oldCplModel.getPointValue();

					method9.invoke(newModel, value9);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					ViewListTitleMinimumRequirementsClp.class.getName())) {
			ViewListTitleMinimumRequirementsClp oldCplModel = (ViewListTitleMinimumRequirementsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.ViewListTitleMinimumRequirementsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setId",
							new Class[] { String.class });

					String value0 = oldCplModel.getId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setTitleId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getTitleId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRootId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setTitleName",
							new Class[] { String.class });

					String value3 = oldCplModel.getTitleName();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setAbbreviation",
							new Class[] { String.class });

					String value4 = oldCplModel.getAbbreviation();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setMinimumRequirementId",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getMinimumRequirementId());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setMinimumRequirementName",
							new Class[] { String.class });

					String value6 = oldCplModel.getMinimumRequirementName();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setMinimumRequirementNumberOrder",
							new Class[] { Integer.TYPE });

					Integer value7 = new Integer(oldCplModel.getMinimumRequirementNumberOrder());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setLevelId",
							new Class[] { Integer.TYPE });

					Integer value8 = new Integer(oldCplModel.getLevelId());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setLevel",
							new Class[] { String.class });

					String value9 = oldCplModel.getLevel();

					method9.invoke(newModel, value9);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(CdsPAFinalCompeteniesClp.class.getName())) {
			CdsPAFinalCompeteniesClp oldCplModel = (CdsPAFinalCompeteniesClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.CdsPAFinalCompeteniesImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setCdsPAFinalCompeteniesId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getCdsPAFinalCompeteniesId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setPaId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getPaId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRootId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getUserId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setCompetencyId",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getCompetencyId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setLevelRankingHash",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getLevelRankingHash());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setLevelRankingValue",
							new Class[] { String.class });

					String value6 = oldCplModel.getLevelRankingValue();

					method6.invoke(newModel, value6);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(CdsPAFinalLevelsClp.class.getName())) {
			CdsPAFinalLevelsClp oldCplModel = (CdsPAFinalLevelsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.CdsPAFinalLevelsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setCdsPAFinalLevelsId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getCdsPAFinalLevelsId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setPaId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getPaId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRootId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getUserId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setLevelId",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getLevelId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setTotalLevelPoint",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getTotalLevelPoint());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setIsPassed",
							new Class[] { Boolean.TYPE });

					Boolean value6 = new Boolean(oldCplModel.getIsPassed());

					method6.invoke(newModel, value6);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(CdsPAFinalSlotsClp.class.getName())) {
			CdsPAFinalSlotsClp oldCplModel = (CdsPAFinalSlotsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.CdsPAFinalSlotsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setCdsPAFinalSlotsId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getCdsPAFinalSlotsId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setPaId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getPaId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRootId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getUserId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setSlotId",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getSlotId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setRatingStatus",
							new Class[] { Boolean.TYPE });

					Boolean value5 = new Boolean(oldCplModel.getRatingStatus());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setPointName",
							new Class[] { String.class });

					String value6 = oldCplModel.getPointName();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setMaxPointName",
							new Class[] { String.class });

					String value7 = oldCplModel.getMaxPointName();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setPointValue",
							new Class[] { Integer.TYPE });

					Integer value8 = new Integer(oldCplModel.getPointValue());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setMaxPointValue",
							new Class[] { Integer.TYPE });

					Integer value9 = new Integer(oldCplModel.getMaxPointValue());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setIsPassed",
							new Class[] { Boolean.TYPE });

					Boolean value10 = new Boolean(oldCplModel.getIsPassed());

					method10.invoke(newModel, value10);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ViewFinalCompetenciesClp.class.getName())) {
			ViewFinalCompetenciesClp oldCplModel = (ViewFinalCompetenciesClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.ViewFinalCompetenciesImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setCompetencyId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getCompetencyId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value2 = oldCplModel.getName();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getUserId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setLevelRankingHash",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getLevelRankingHash());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setLevelRankingValue",
							new Class[] { String.class });

					String value5 = oldCplModel.getLevelRankingValue();

					method5.invoke(newModel, value5);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ViewFinalLevelsClp.class.getName())) {
			ViewFinalLevelsClp oldCplModel = (ViewFinalLevelsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.ViewFinalLevelsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLevelId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLevelId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setCompetencyId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getCompetencyId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRootId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value3 = oldCplModel.getName();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getUserId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setTotalLevelPoint",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getTotalLevelPoint());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setIsPassed",
							new Class[] { Boolean.TYPE });

					Boolean value6 = new Boolean(oldCplModel.getIsPassed());

					method6.invoke(newModel, value6);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ViewFinalSlotsClp.class.getName())) {
			ViewFinalSlotsClp oldCplModel = (ViewFinalSlotsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.ViewFinalSlotsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setSlotId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getSlotId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setLevelId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getLevelId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRootId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value3 = oldCplModel.getName();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value4 = oldCplModel.getDescription();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getUserId());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setRatingStatus",
							new Class[] { Boolean.TYPE });

					Boolean value6 = new Boolean(oldCplModel.getRatingStatus());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setPointName",
							new Class[] { String.class });

					String value7 = oldCplModel.getPointName();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setMaxPointName",
							new Class[] { String.class });

					String value8 = oldCplModel.getMaxPointName();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setPointValue",
							new Class[] { Integer.TYPE });

					Integer value9 = new Integer(oldCplModel.getPointValue());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setMaxPointValue",
							new Class[] { Integer.TYPE });

					Integer value10 = new Integer(oldCplModel.getMaxPointValue());

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setIsPassed",
							new Class[] { Boolean.TYPE });

					Boolean value11 = new Boolean(oldCplModel.getIsPassed());

					method11.invoke(newModel, value11);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ViewFinalTitlesClp.class.getName())) {
			ViewFinalTitlesClp oldCplModel = (ViewFinalTitlesClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.ViewFinalTitlesImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setViewFinalTitlesId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getViewFinalTitlesId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getUserId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setTitleId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getTitleId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setTitleName",
							new Class[] { String.class });

					String value4 = oldCplModel.getTitleName();

					method4.invoke(newModel, value4);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ViewSlotInformationClp.class.getName())) {
			ViewSlotInformationClp oldCplModel = (ViewSlotInformationClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.ViewSlotInformationImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setViewSlotInformationId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getViewSlotInformationId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getUserId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setSlotId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getSlotId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setPointName",
							new Class[] { String.class });

					String value4 = oldCplModel.getPointName();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setMaxPointName",
							new Class[] { String.class });

					String value5 = oldCplModel.getMaxPointName();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setIsPassed",
							new Class[] { Boolean.TYPE });

					Boolean value6 = new Boolean(oldCplModel.getIsPassed());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setPeriodName",
							new Class[] { String.class });

					String value7 = oldCplModel.getPeriodName();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setFromDate",
							new Class[] { Date.class });

					Date value8 = oldCplModel.getFromDate();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setToDate",
							new Class[] { Date.class });

					Date value9 = oldCplModel.getToDate();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setPmName",
							new Class[] { String.class });

					String value10 = oldCplModel.getPmName();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setOrgName",
							new Class[] { String.class });

					String value11 = oldCplModel.getOrgName();

					method11.invoke(newModel, value11);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(CdsPASlotsClp.class.getName())) {
			CdsPASlotsClp oldCplModel = (CdsPASlotsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.CdsPASlotsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setCdsPASlotsId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getCdsPASlotsId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setPaId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getPaId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRootId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setPeriodId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getPeriodId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getUserId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setSlotId",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getSlotId());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setPmUid",
							new Class[] { Integer.TYPE });

					Integer value6 = new Integer(oldCplModel.getPmUid());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setBodUid",
							new Class[] { Integer.TYPE });

					Integer value7 = new Integer(oldCplModel.getBodUid());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setRatingOrgId",
							new Class[] { Integer.TYPE });

					Integer value8 = new Integer(oldCplModel.getRatingOrgId());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setRatingStatus",
							new Class[] { Integer.TYPE });

					Integer value9 = new Integer(oldCplModel.getRatingStatus());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setRatingStatusPm",
							new Class[] { Integer.TYPE });

					Integer value10 = new Integer(oldCplModel.getRatingStatusPm());

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setRatingStatusBod",
							new Class[] { Integer.TYPE });

					Integer value11 = new Integer(oldCplModel.getRatingStatusBod());

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setPointName",
							new Class[] { String.class });

					String value12 = oldCplModel.getPointName();

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setMaxPointName",
							new Class[] { String.class });

					String value13 = oldCplModel.getMaxPointName();

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setPointValue",
							new Class[] { Integer.TYPE });

					Integer value14 = new Integer(oldCplModel.getPointValue());

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setMaxPointValue",
							new Class[] { Integer.TYPE });

					Integer value15 = new Integer(oldCplModel.getMaxPointValue());

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setIsPassed",
							new Class[] { Boolean.TYPE });

					Boolean value16 = new Boolean(oldCplModel.getIsPassed());

					method16.invoke(newModel, value16);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(CdsPALevelsClp.class.getName())) {
			CdsPALevelsClp oldCplModel = (CdsPALevelsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.CdsPALevelsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setCdsPALevelsId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getCdsPALevelsId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setPaId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getPaId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRootId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setPeriodId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getPeriodId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getUserId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setLevelId",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getLevelId());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setTotalLevelPoint",
							new Class[] { Integer.TYPE });

					Integer value6 = new Integer(oldCplModel.getTotalLevelPoint());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setIsPassed",
							new Class[] { Boolean.TYPE });

					Boolean value7 = new Boolean(oldCplModel.getIsPassed());

					method7.invoke(newModel, value7);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(CdsPACompetenciesClp.class.getName())) {
			CdsPACompetenciesClp oldCplModel = (CdsPACompetenciesClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.CdsPACompetenciesImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setCdsPACompetenciesId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getCdsPACompetenciesId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setPaId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getPaId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRootId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setPeriodId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getPeriodId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getUserId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setCompetencyId",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getCompetencyId());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setLevelRankingHash",
							new Class[] { Integer.TYPE });

					Integer value6 = new Integer(oldCplModel.getLevelRankingHash());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setLevelRankingValue",
							new Class[] { String.class });

					String value7 = oldCplModel.getLevelRankingValue();

					method7.invoke(newModel, value7);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					ViewPerformanceAppraisalLevelsClp.class.getName())) {
			ViewPerformanceAppraisalLevelsClp oldCplModel = (ViewPerformanceAppraisalLevelsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.ViewPerformanceAppraisalLevelsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setId",
							new Class[] { String.class });

					String value0 = oldCplModel.getId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setLevelId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getLevelId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setNumberOrder",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getNumberOrder());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setCompetencyId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getCompetencyId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getRootId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setLevelName",
							new Class[] { String.class });

					String value5 = oldCplModel.getLevelName();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setPaId",
							new Class[] { Integer.TYPE });

					Integer value6 = new Integer(oldCplModel.getPaId());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value7 = new Integer(oldCplModel.getUserId());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setPeriodId",
							new Class[] { Integer.TYPE });

					Integer value8 = new Integer(oldCplModel.getPeriodId());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setTotalLevelPoint",
							new Class[] { Integer.TYPE });

					Integer value9 = new Integer(oldCplModel.getTotalLevelPoint());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setIsPassed",
							new Class[] { Boolean.TYPE });

					Boolean value10 = new Boolean(oldCplModel.getIsPassed());

					method10.invoke(newModel, value10);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					ViewPerformanceAppraisalSlotsClp.class.getName())) {
			ViewPerformanceAppraisalSlotsClp oldCplModel = (ViewPerformanceAppraisalSlotsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.ViewPerformanceAppraisalSlotsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setId",
							new Class[] { String.class });

					String value0 = oldCplModel.getId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setSlotId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getSlotId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setLevelId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getLevelId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setCompetencyId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getCompetencyId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getRootId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setSlotName",
							new Class[] { String.class });

					String value5 = oldCplModel.getSlotName();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setAliasName",
							new Class[] { String.class });

					String value6 = oldCplModel.getAliasName();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value7 = oldCplModel.getDescription();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setPaId",
							new Class[] { Integer.TYPE });

					Integer value8 = new Integer(oldCplModel.getPaId());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setSlotNumberOrder",
							new Class[] { Integer.TYPE });

					Integer value9 = new Integer(oldCplModel.getSlotNumberOrder());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setLevelNumberOrder",
							new Class[] { Integer.TYPE });

					Integer value10 = new Integer(oldCplModel.getLevelNumberOrder());

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setCompetencyNumberOrder",
							new Class[] { Integer.TYPE });

					Integer value11 = new Integer(oldCplModel.getCompetencyNumberOrder());

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value12 = new Integer(oldCplModel.getUserId());

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setPeriodId",
							new Class[] { Integer.TYPE });

					Integer value13 = new Integer(oldCplModel.getPeriodId());

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setPeriodName",
							new Class[] { String.class });

					String value14 = oldCplModel.getPeriodName();

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setFromDate",
							new Class[] { Date.class });

					Date value15 = oldCplModel.getFromDate();

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setToDate",
							new Class[] { Date.class });

					Date value16 = oldCplModel.getToDate();

					method16.invoke(newModel, value16);

					Method method17 = newModelClass.getMethod("setBodUid",
							new Class[] { Integer.TYPE });

					Integer value17 = new Integer(oldCplModel.getBodUid());

					method17.invoke(newModel, value17);

					Method method18 = newModelClass.getMethod("setPmUid",
							new Class[] { Integer.TYPE });

					Integer value18 = new Integer(oldCplModel.getPmUid());

					method18.invoke(newModel, value18);

					Method method19 = newModelClass.getMethod("setRatingOrgId",
							new Class[] { Integer.TYPE });

					Integer value19 = new Integer(oldCplModel.getRatingOrgId());

					method19.invoke(newModel, value19);

					Method method20 = newModelClass.getMethod("setRatingStatus",
							new Class[] { Integer.TYPE });

					Integer value20 = new Integer(oldCplModel.getRatingStatus());

					method20.invoke(newModel, value20);

					Method method21 = newModelClass.getMethod("setRatingStatusBod",
							new Class[] { Integer.TYPE });

					Integer value21 = new Integer(oldCplModel.getRatingStatusBod());

					method21.invoke(newModel, value21);

					Method method22 = newModelClass.getMethod("setRatingStatusPm",
							new Class[] { Integer.TYPE });

					Integer value22 = new Integer(oldCplModel.getRatingStatusPm());

					method22.invoke(newModel, value22);

					Method method23 = newModelClass.getMethod("setPointName",
							new Class[] { String.class });

					String value23 = oldCplModel.getPointName();

					method23.invoke(newModel, value23);

					Method method24 = newModelClass.getMethod("setMaxPointName",
							new Class[] { String.class });

					String value24 = oldCplModel.getMaxPointName();

					method24.invoke(newModel, value24);

					Method method25 = newModelClass.getMethod("setPointValue",
							new Class[] { Integer.TYPE });

					Integer value25 = new Integer(oldCplModel.getPointValue());

					method25.invoke(newModel, value25);

					Method method26 = newModelClass.getMethod("setMaxPointValue",
							new Class[] { Integer.TYPE });

					Integer value26 = new Integer(oldCplModel.getMaxPointValue());

					method26.invoke(newModel, value26);

					Method method27 = newModelClass.getMethod("setIsPassed",
							new Class[] { Boolean.TYPE });

					Boolean value27 = new Boolean(oldCplModel.getIsPassed());

					method27.invoke(newModel, value27);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					CdsPerformanceAppraisalSlotRatingClp.class.getName())) {
			CdsPerformanceAppraisalSlotRatingClp oldCplModel = (CdsPerformanceAppraisalSlotRatingClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.CdsPerformanceAppraisalSlotRatingImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setCdsPerformanceAppraisalSlotRatingId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getCdsPerformanceAppraisalSlotRatingId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setPaId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getPaId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRootId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setPeriodId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getPeriodId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getUserId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setSlotId",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getSlotId());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setRatingBy",
							new Class[] { Integer.TYPE });

					Integer value6 = new Integer(oldCplModel.getRatingBy());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setRatingAt",
							new Class[] { Date.class });

					Date value7 = oldCplModel.getRatingAt();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setRatingStatus",
							new Class[] { Boolean.TYPE });

					Boolean value8 = new Boolean(oldCplModel.getRatingStatus());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setUserType",
							new Class[] { Integer.TYPE });

					Integer value9 = new Integer(oldCplModel.getUserType());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setPointName",
							new Class[] { String.class });

					String value10 = oldCplModel.getPointName();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setPointValue",
							new Class[] { Integer.TYPE });

					Integer value11 = new Integer(oldCplModel.getPointValue());

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setRatingOrgId",
							new Class[] { Integer.TYPE });

					Integer value12 = new Integer(oldCplModel.getRatingOrgId());

					method12.invoke(newModel, value12);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					CdsPerformanceAppraisalSlotCommentsClp.class.getName())) {
			CdsPerformanceAppraisalSlotCommentsClp oldCplModel = (CdsPerformanceAppraisalSlotCommentsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.CdsPerformanceAppraisalSlotCommentsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setCdsPerformanceAppraisalSlotCommentsId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getCdsPerformanceAppraisalSlotCommentsId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setPaId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getPaId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRootId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setPeriodId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getPeriodId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getUserId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setSlotId",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getSlotId());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setCommentBy",
							new Class[] { Integer.TYPE });

					Integer value6 = new Integer(oldCplModel.getCommentBy());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setCommentAt",
							new Class[] { Date.class });

					Date value7 = oldCplModel.getCommentAt();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setCommentContent",
							new Class[] { String.class });

					String value8 = oldCplModel.getCommentContent();

					method8.invoke(newModel, value8);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					CdsPerformanceAppraisalsClp.class.getName())) {
			CdsPerformanceAppraisalsClp oldCplModel = (CdsPerformanceAppraisalsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.CdsPerformanceAppraisalsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setCdsPerformanceAppraisalsId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getCdsPerformanceAppraisalsId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setPeriodId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getPeriodId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getUserId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setTitleId",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getTitleId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setRatingStatus",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getRatingStatus());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setRatingStatusPm",
							new Class[] { Integer.TYPE });

					Integer value6 = new Integer(oldCplModel.getRatingStatusPm());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setRatingStatusBod",
							new Class[] { Integer.TYPE });

					Integer value7 = new Integer(oldCplModel.getRatingStatusBod());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setIsLocked",
							new Class[] { Boolean.TYPE });

					Boolean value8 = new Boolean(oldCplModel.getIsLocked());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setPmList",
							new Class[] { String.class });

					String value9 = oldCplModel.getPmList();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setOrgList",
							new Class[] { String.class });

					String value10 = oldCplModel.getOrgList();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setBodList",
							new Class[] { String.class });

					String value11 = oldCplModel.getBodList();

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setIsTitleUp",
							new Class[] { Boolean.TYPE });

					Boolean value12 = new Boolean(oldCplModel.getIsTitleUp());

					method12.invoke(newModel, value12);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ViewEmployeesInProjectsClp.class.getName())) {
			ViewEmployeesInProjectsClp oldCplModel = (ViewEmployeesInProjectsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.ViewEmployeesInProjectsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setId",
							new Class[] { String.class });

					String value0 = oldCplModel.getId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getUserId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setFirstName",
							new Class[] { String.class });

					String value3 = oldCplModel.getFirstName();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setMiddleName",
							new Class[] { String.class });

					String value4 = oldCplModel.getMiddleName();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setLastName",
							new Class[] { String.class });

					String value5 = oldCplModel.getLastName();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setPosition",
							new Class[] { String.class });

					String value6 = oldCplModel.getPosition();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setTitleAbbreviation",
							new Class[] { String.class });

					String value7 = oldCplModel.getTitleAbbreviation();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setTitleName",
							new Class[] { String.class });

					String value8 = oldCplModel.getTitleName();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setOrgId",
							new Class[] { Integer.TYPE });

					Integer value9 = new Integer(oldCplModel.getOrgId());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setOrgList",
							new Class[] { String.class });

					String value10 = oldCplModel.getOrgList();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setPmList",
							new Class[] { String.class });

					String value11 = oldCplModel.getPmList();

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setPeriodId",
							new Class[] { Integer.TYPE });

					Integer value12 = new Integer(oldCplModel.getPeriodId());

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setPeriodName",
							new Class[] { String.class });

					String value13 = oldCplModel.getPeriodName();

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setFromDate",
							new Class[] { Date.class });

					Date value14 = oldCplModel.getFromDate();

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setToDate",
							new Class[] { Date.class });

					Date value15 = oldCplModel.getToDate();

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setPeriodStatus",
							new Class[] { Integer.TYPE });

					Integer value16 = new Integer(oldCplModel.getPeriodStatus());

					method16.invoke(newModel, value16);

					Method method17 = newModelClass.getMethod("setRatingStatus",
							new Class[] { Integer.TYPE });

					Integer value17 = new Integer(oldCplModel.getRatingStatus());

					method17.invoke(newModel, value17);

					Method method18 = newModelClass.getMethod("setRatingStatusPm",
							new Class[] { Integer.TYPE });

					Integer value18 = new Integer(oldCplModel.getRatingStatusPm());

					method18.invoke(newModel, value18);

					Method method19 = newModelClass.getMethod("setRatingStatusBod",
							new Class[] { Integer.TYPE });

					Integer value19 = new Integer(oldCplModel.getRatingStatusBod());

					method19.invoke(newModel, value19);

					Method method20 = newModelClass.getMethod("setIsActive",
							new Class[] { Boolean.TYPE });

					Boolean value20 = new Boolean(oldCplModel.getIsActive());

					method20.invoke(newModel, value20);

					Method method21 = newModelClass.getMethod("setIsRemoved",
							new Class[] { Boolean.TYPE });

					Boolean value21 = new Boolean(oldCplModel.getIsRemoved());

					method21.invoke(newModel, value21);

					Method method22 = newModelClass.getMethod("setIsLocked",
							new Class[] { Boolean.TYPE });

					Boolean value22 = new Boolean(oldCplModel.getIsLocked());

					method22.invoke(newModel, value22);

					Method method23 = newModelClass.getMethod("setBeginTime",
							new Class[] { Date.class });

					Date value23 = oldCplModel.getBeginTime();

					method23.invoke(newModel, value23);

					Method method24 = newModelClass.getMethod("setEndTime",
							new Class[] { Date.class });

					Date value24 = oldCplModel.getEndTime();

					method24.invoke(newModel, value24);

					Method method25 = newModelClass.getMethod("setIsTitleUp",
							new Class[] { Boolean.TYPE });

					Boolean value25 = new Boolean(oldCplModel.getIsTitleUp());

					method25.invoke(newModel, value25);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					ViewEmployeesSlotsRatingClp.class.getName())) {
			ViewEmployeesSlotsRatingClp oldCplModel = (ViewEmployeesSlotsRatingClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.ViewEmployeesSlotsRatingImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setId",
							new Class[] { String.class });

					String value0 = oldCplModel.getId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setAliasName",
							new Class[] { String.class });

					String value1 = oldCplModel.getAliasName();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value2 = oldCplModel.getDescription();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setNumberOrder",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getNumberOrder());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getUserId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setPeriodId",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getPeriodId());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setPeriodName",
							new Class[] { String.class });

					String value6 = oldCplModel.getPeriodName();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setFromDate",
							new Class[] { Date.class });

					Date value7 = oldCplModel.getFromDate();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setToDate",
							new Class[] { Date.class });

					Date value8 = oldCplModel.getToDate();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setRatingOrgId",
							new Class[] { Integer.TYPE });

					Integer value9 = new Integer(oldCplModel.getRatingOrgId());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setRatingStatus",
							new Class[] { Integer.TYPE });

					Integer value10 = new Integer(oldCplModel.getRatingStatus());

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setRatingStatusBod",
							new Class[] { Integer.TYPE });

					Integer value11 = new Integer(oldCplModel.getRatingStatusBod());

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setRatingStatusPm",
							new Class[] { Integer.TYPE });

					Integer value12 = new Integer(oldCplModel.getRatingStatusPm());

					method12.invoke(newModel, value12);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					CdsSlotStatisticalReportClp.class.getName())) {
			CdsSlotStatisticalReportClp oldCplModel = (CdsSlotStatisticalReportClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.CdsSlotStatisticalReportImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setSlotId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getSlotId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setLevelId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getLevelId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value3 = oldCplModel.getName();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value4 = oldCplModel.getDescription();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setPeriodId",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getPeriodId());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value6 = new Integer(oldCplModel.getUserId());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setPmId",
							new Class[] { Integer.TYPE });

					Integer value7 = new Integer(oldCplModel.getPmId());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setFirstName",
							new Class[] { String.class });

					String value8 = oldCplModel.getFirstName();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setLastName",
							new Class[] { String.class });

					String value9 = oldCplModel.getLastName();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setRatingStatusPm",
							new Class[] { Integer.TYPE });

					Integer value10 = new Integer(oldCplModel.getRatingStatusPm());

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setRatingStatusBod",
							new Class[] { Integer.TYPE });

					Integer value11 = new Integer(oldCplModel.getRatingStatusBod());

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setPointName",
							new Class[] { String.class });

					String value12 = oldCplModel.getPointName();

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setPointValue",
							new Class[] { Integer.TYPE });

					Integer value13 = new Integer(oldCplModel.getPointValue());

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setMaxPointName",
							new Class[] { String.class });

					String value14 = oldCplModel.getMaxPointName();

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setMaxPointValue",
							new Class[] { Integer.TYPE });

					Integer value15 = new Integer(oldCplModel.getMaxPointValue());

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setToDate",
							new Class[] { Date.class });

					Date value16 = oldCplModel.getToDate();

					method16.invoke(newModel, value16);

					Method method17 = newModelClass.getMethod("setStatus",
							new Class[] { Integer.TYPE });

					Integer value17 = new Integer(oldCplModel.getStatus());

					method17.invoke(newModel, value17);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					CdsLevelStatisticalReportClp.class.getName())) {
			CdsLevelStatisticalReportClp oldCplModel = (CdsLevelStatisticalReportClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.CdsLevelStatisticalReportImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setLevelId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getLevelId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setCompetencyId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getCompetencyId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value3 = oldCplModel.getName();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setPeriodId",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getPeriodId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getUserId());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setTotalLevelPoint",
							new Class[] { Integer.TYPE });

					Integer value6 = new Integer(oldCplModel.getTotalLevelPoint());

					method6.invoke(newModel, value6);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					CdsCompetencyStatisticalReportClp.class.getName())) {
			CdsCompetencyStatisticalReportClp oldCplModel = (CdsCompetencyStatisticalReportClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.CdsCompetencyStatisticalReportImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setCompetencyId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getCompetencyId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value2 = oldCplModel.getName();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setPeriodId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getPeriodId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getUserId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setLevelRankingHash",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getLevelRankingHash());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setLevelRankingValue",
							new Class[] { String.class });

					String value6 = oldCplModel.getLevelRankingValue();

					method6.invoke(newModel, value6);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(CdsCdpClp.class.getName())) {
			CdsCdpClp oldCplModel = (CdsCdpClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.CdsCdpImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setCdsCdpId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getCdsCdpId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setPeriodId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getPeriodId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getUserId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setWrittenBy",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getWrittenBy());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setWrittenAt",
							new Class[] { Date.class });

					Date value5 = oldCplModel.getWrittenAt();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setWrittenContent",
							new Class[] { String.class });

					String value6 = oldCplModel.getWrittenContent();

					method6.invoke(newModel, value6);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(CdsPAFinalClp.class.getName())) {
			CdsPAFinalClp oldCplModel = (CdsPAFinalClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.cds.model.impl.CdsPAFinalImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setCdsPAFinalId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getCdsPAFinalId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getRootId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getUserId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setCdsTitleId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getCdsTitleId());

					method3.invoke(newModel, value3);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel) {
			return translateInput((BaseModel)obj);
		}
		else if (obj instanceof List) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.CompetencyImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					CompetencyClp newModel = new CompetencyClp();

					Method method0 = oldModelClass.getMethod("getCompetencyId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setCompetencyId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getName");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setName(value2);

					Method method3 = oldModelClass.getMethod("getDescription");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value3);

					Method method4 = oldModelClass.getMethod("getNumberOrder");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setNumberOrder(value4.intValue());

					Method method5 = oldModelClass.getMethod("getCreatedBy");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setCreatedBy(value5.intValue());

					Method method6 = oldModelClass.getMethod("getCreatedAt");

					Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

					newModel.setCreatedAt(value6);

					Method method7 = oldModelClass.getMethod("getUpdatedBy");

					Integer value7 = (Integer)method7.invoke(oldModel,
							(Object[])null);

					newModel.setUpdatedBy(value7.intValue());

					Method method8 = oldModelClass.getMethod("getUpdatedAt");

					Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

					newModel.setUpdatedAt(value8);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals("larion.progate.cds.model.impl.LevelImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					LevelClp newModel = new LevelClp();

					Method method0 = oldModelClass.getMethod("getRootId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value0.intValue());

					Method method1 = oldModelClass.getMethod("getLevelId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setLevelId(value1);

					Method method2 = oldModelClass.getMethod("getCompetencyId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setCompetencyId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getName");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setName(value3);

					Method method4 = oldModelClass.getMethod("getDescription");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value4);

					Method method5 = oldModelClass.getMethod("getNumberOrder");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setNumberOrder(value5.intValue());

					Method method6 = oldModelClass.getMethod("getAliasName");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setAliasName(value6);

					Method method7 = oldModelClass.getMethod("getCreatedBy");

					Integer value7 = (Integer)method7.invoke(oldModel,
							(Object[])null);

					newModel.setCreatedBy(value7.intValue());

					Method method8 = oldModelClass.getMethod("getCreatedAt");

					Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

					newModel.setCreatedAt(value8);

					Method method9 = oldModelClass.getMethod("getUpdatedBy");

					Integer value9 = (Integer)method9.invoke(oldModel,
							(Object[])null);

					newModel.setUpdatedBy(value9.intValue());

					Method method10 = oldModelClass.getMethod("getUpdatedAt");

					Date value10 = (Date)method10.invoke(oldModel,
							(Object[])null);

					newModel.setUpdatedAt(value10);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals("larion.progate.cds.model.impl.SlotImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					SlotClp newModel = new SlotClp();

					Method method0 = oldModelClass.getMethod("getRootId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value0.intValue());

					Method method1 = oldModelClass.getMethod("getSlotId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setSlotId(value1);

					Method method2 = oldModelClass.getMethod("getLevelId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setLevelId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getName");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setName(value3);

					Method method4 = oldModelClass.getMethod("getDescription");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value4);

					Method method5 = oldModelClass.getMethod("getNumberOrder");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setNumberOrder(value5.intValue());

					Method method6 = oldModelClass.getMethod("getAliasName");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setAliasName(value6);

					Method method7 = oldModelClass.getMethod("getCreatedBy");

					Integer value7 = (Integer)method7.invoke(oldModel,
							(Object[])null);

					newModel.setCreatedBy(value7.intValue());

					Method method8 = oldModelClass.getMethod("getCreatedAt");

					Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

					newModel.setCreatedAt(value8);

					Method method9 = oldModelClass.getMethod("getUpdatedBy");

					Integer value9 = (Integer)method9.invoke(oldModel,
							(Object[])null);

					newModel.setUpdatedBy(value9.intValue());

					Method method10 = oldModelClass.getMethod("getUpdatedAt");

					Date value10 = (Date)method10.invoke(oldModel,
							(Object[])null);

					newModel.setUpdatedAt(value10);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.CdsPointsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					CdsPointsClp newModel = new CdsPointsClp();

					Method method0 = oldModelClass.getMethod("getPointId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setPointId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getPointName");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setPointName(value2);

					Method method3 = oldModelClass.getMethod("getPointValue");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setPointValue(value3.intValue());

					Method method4 = oldModelClass.getMethod("getDescription");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value4);

					Method method5 = oldModelClass.getMethod("getCreatedBy");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setCreatedBy(value5.intValue());

					Method method6 = oldModelClass.getMethod("getCreatedAt");

					Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

					newModel.setCreatedAt(value6);

					Method method7 = oldModelClass.getMethod("getUpdatedBy");

					Integer value7 = (Integer)method7.invoke(oldModel,
							(Object[])null);

					newModel.setUpdatedBy(value7.intValue());

					Method method8 = oldModelClass.getMethod("getUpdatedAt");

					Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

					newModel.setUpdatedAt(value8);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.CdsEvaluationPeriodsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					CdsEvaluationPeriodsClp newModel = new CdsEvaluationPeriodsClp();

					Method method0 = oldModelClass.getMethod(
							"getCdsEvaluationPeriodsId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setCdsEvaluationPeriodsId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getName");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setName(value2);

					Method method3 = oldModelClass.getMethod("getFromDate");

					Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

					newModel.setFromDate(value3);

					Method method4 = oldModelClass.getMethod("getToDate");

					Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

					newModel.setToDate(value4);

					Method method5 = oldModelClass.getMethod("getStartDate");

					Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

					newModel.setStartDate(value5);

					Method method6 = oldModelClass.getMethod("getEndDate");

					Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

					newModel.setEndDate(value6);

					Method method7 = oldModelClass.getMethod("getStatus");

					Integer value7 = (Integer)method7.invoke(oldModel,
							(Object[])null);

					newModel.setStatus(value7.intValue());

					Method method8 = oldModelClass.getMethod("getCreatedBy");

					Integer value8 = (Integer)method8.invoke(oldModel,
							(Object[])null);

					newModel.setCreatedBy(value8.intValue());

					Method method9 = oldModelClass.getMethod("getCreatedAt");

					Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

					newModel.setCreatedAt(value9);

					Method method10 = oldModelClass.getMethod("getUpdatedBy");

					Integer value10 = (Integer)method10.invoke(oldModel,
							(Object[])null);

					newModel.setUpdatedBy(value10.intValue());

					Method method11 = oldModelClass.getMethod("getUpdatedAt");

					Date value11 = (Date)method11.invoke(oldModel,
							(Object[])null);

					newModel.setUpdatedAt(value11);

					Method method12 = oldModelClass.getMethod("getIsModified");

					Boolean value12 = (Boolean)method12.invoke(oldModel,
							(Object[])null);

					newModel.setIsModified(value12.booleanValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.CdsTitlesImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					CdsTitlesClp newModel = new CdsTitlesClp();

					Method method0 = oldModelClass.getMethod("getCdsTitleId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setCdsTitleId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getName");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setName(value2);

					Method method3 = oldModelClass.getMethod("getAbbreviation");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setAbbreviation(value3);

					Method method4 = oldModelClass.getMethod("getNumberOrder");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setNumberOrder(value4.intValue());

					Method method5 = oldModelClass.getMethod("getCreatedBy");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setCreatedBy(value5.intValue());

					Method method6 = oldModelClass.getMethod("getCreatedAt");

					Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

					newModel.setCreatedAt(value6);

					Method method7 = oldModelClass.getMethod("getUpdatedBy");

					Integer value7 = (Integer)method7.invoke(oldModel,
							(Object[])null);

					newModel.setUpdatedBy(value7.intValue());

					Method method8 = oldModelClass.getMethod("getUpdatedAt");

					Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

					newModel.setUpdatedAt(value8);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.CdsTitleCompetenciesImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					CdsTitleCompetenciesClp newModel = new CdsTitleCompetenciesClp();

					Method method0 = oldModelClass.getMethod(
							"getCdsTitleCompetenciesId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setCdsTitleCompetenciesId(value0);

					Method method1 = oldModelClass.getMethod("getCdsTitleId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setCdsTitleId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getCompetencyId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setCompetencyId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getPointHash");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setPointHash(value3.intValue());

					Method method4 = oldModelClass.getMethod("getPointValue");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setPointValue(value4);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.CdsMinimumRequirementsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					CdsMinimumRequirementsClp newModel = new CdsMinimumRequirementsClp();

					Method method0 = oldModelClass.getMethod(
							"getMinimumRequirementId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setMinimumRequirementId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getName");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setName(value2);

					Method method3 = oldModelClass.getMethod("getDescription");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value3);

					Method method4 = oldModelClass.getMethod("getNumberOrder");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setNumberOrder(value4.intValue());

					Method method5 = oldModelClass.getMethod("getCreatedBy");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setCreatedBy(value5.intValue());

					Method method6 = oldModelClass.getMethod("getCreatedAt");

					Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

					newModel.setCreatedAt(value6);

					Method method7 = oldModelClass.getMethod("getUpdatedBy");

					Integer value7 = (Integer)method7.invoke(oldModel,
							(Object[])null);

					newModel.setUpdatedBy(value7.intValue());

					Method method8 = oldModelClass.getMethod("getUpdatedAt");

					Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

					newModel.setUpdatedAt(value8);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.CdsTitleMinimumRequirementsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					CdsTitleMinimumRequirementsClp newModel = new CdsTitleMinimumRequirementsClp();

					Method method0 = oldModelClass.getMethod(
							"getCdsTitleMinimumRequirementsId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setCdsTitleMinimumRequirementsId(value0);

					Method method1 = oldModelClass.getMethod("getTitleId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setTitleId(value1.intValue());

					Method method2 = oldModelClass.getMethod(
							"getMinimumRequirementId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setMinimumRequirementId(value2.intValue());

					Method method3 = oldModelClass.getMethod(
							"getMinimumRequirementLevelId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setMinimumRequirementLevelId(value3.intValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.CdsMinimumRequirementLevelsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					CdsMinimumRequirementLevelsClp newModel = new CdsMinimumRequirementLevelsClp();

					Method method0 = oldModelClass.getMethod(
							"getMinimumRequirementLevelId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setMinimumRequirementLevelId(value0);

					Method method1 = oldModelClass.getMethod(
							"getMinimumRequirementId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setMinimumRequirementId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getName");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setName(value2);

					Method method3 = oldModelClass.getMethod("getDescription");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value3);

					Method method4 = oldModelClass.getMethod("getNumberOrder");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setNumberOrder(value4.intValue());

					Method method5 = oldModelClass.getMethod("getCreatedBy");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setCreatedBy(value5.intValue());

					Method method6 = oldModelClass.getMethod("getCreatedAt");

					Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

					newModel.setCreatedAt(value6);

					Method method7 = oldModelClass.getMethod("getUpdatedBy");

					Integer value7 = (Integer)method7.invoke(oldModel,
							(Object[])null);

					newModel.setUpdatedBy(value7.intValue());

					Method method8 = oldModelClass.getMethod("getUpdatedAt");

					Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

					newModel.setUpdatedAt(value8);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.ViewListTitleCompetenciesImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ViewListTitleCompetenciesClp newModel = new ViewListTitleCompetenciesClp();

					Method method0 = oldModelClass.getMethod("getId");

					String value0 = (String)method0.invoke(oldModel,
							(Object[])null);

					newModel.setId(value0);

					Method method1 = oldModelClass.getMethod("getTitleId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setTitleId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRootId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getTitleName");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setTitleName(value3);

					Method method4 = oldModelClass.getMethod("getAbbreviation");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setAbbreviation(value4);

					Method method5 = oldModelClass.getMethod("getCompetencyId");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setCompetencyId(value5.intValue());

					Method method6 = oldModelClass.getMethod(
							"getCompetencyName");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setCompetencyName(value6);

					Method method7 = oldModelClass.getMethod(
							"getCompetencyNumberOrder");

					Integer value7 = (Integer)method7.invoke(oldModel,
							(Object[])null);

					newModel.setCompetencyNumberOrder(value7.intValue());

					Method method8 = oldModelClass.getMethod("getPointHash");

					Integer value8 = (Integer)method8.invoke(oldModel,
							(Object[])null);

					newModel.setPointHash(value8.intValue());

					Method method9 = oldModelClass.getMethod("getPointValue");

					String value9 = (String)method9.invoke(oldModel,
							(Object[])null);

					newModel.setPointValue(value9);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.ViewListTitleMinimumRequirementsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ViewListTitleMinimumRequirementsClp newModel = new ViewListTitleMinimumRequirementsClp();

					Method method0 = oldModelClass.getMethod("getId");

					String value0 = (String)method0.invoke(oldModel,
							(Object[])null);

					newModel.setId(value0);

					Method method1 = oldModelClass.getMethod("getTitleId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setTitleId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRootId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getTitleName");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setTitleName(value3);

					Method method4 = oldModelClass.getMethod("getAbbreviation");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setAbbreviation(value4);

					Method method5 = oldModelClass.getMethod(
							"getMinimumRequirementId");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setMinimumRequirementId(value5.intValue());

					Method method6 = oldModelClass.getMethod(
							"getMinimumRequirementName");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setMinimumRequirementName(value6);

					Method method7 = oldModelClass.getMethod(
							"getMinimumRequirementNumberOrder");

					Integer value7 = (Integer)method7.invoke(oldModel,
							(Object[])null);

					newModel.setMinimumRequirementNumberOrder(value7.intValue());

					Method method8 = oldModelClass.getMethod("getLevelId");

					Integer value8 = (Integer)method8.invoke(oldModel,
							(Object[])null);

					newModel.setLevelId(value8.intValue());

					Method method9 = oldModelClass.getMethod("getLevel");

					String value9 = (String)method9.invoke(oldModel,
							(Object[])null);

					newModel.setLevel(value9);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.CdsPAFinalCompeteniesImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					CdsPAFinalCompeteniesClp newModel = new CdsPAFinalCompeteniesClp();

					Method method0 = oldModelClass.getMethod(
							"getCdsPAFinalCompeteniesId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setCdsPAFinalCompeteniesId(value0);

					Method method1 = oldModelClass.getMethod("getPaId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setPaId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRootId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getUserId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getCompetencyId");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setCompetencyId(value4.intValue());

					Method method5 = oldModelClass.getMethod(
							"getLevelRankingHash");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setLevelRankingHash(value5.intValue());

					Method method6 = oldModelClass.getMethod(
							"getLevelRankingValue");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setLevelRankingValue(value6);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.CdsPAFinalLevelsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					CdsPAFinalLevelsClp newModel = new CdsPAFinalLevelsClp();

					Method method0 = oldModelClass.getMethod(
							"getCdsPAFinalLevelsId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setCdsPAFinalLevelsId(value0);

					Method method1 = oldModelClass.getMethod("getPaId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setPaId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRootId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getUserId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getLevelId");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setLevelId(value4.intValue());

					Method method5 = oldModelClass.getMethod(
							"getTotalLevelPoint");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setTotalLevelPoint(value5.intValue());

					Method method6 = oldModelClass.getMethod("getIsPassed");

					Boolean value6 = (Boolean)method6.invoke(oldModel,
							(Object[])null);

					newModel.setIsPassed(value6.booleanValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.CdsPAFinalSlotsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					CdsPAFinalSlotsClp newModel = new CdsPAFinalSlotsClp();

					Method method0 = oldModelClass.getMethod(
							"getCdsPAFinalSlotsId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setCdsPAFinalSlotsId(value0);

					Method method1 = oldModelClass.getMethod("getPaId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setPaId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRootId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getUserId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getSlotId");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setSlotId(value4.intValue());

					Method method5 = oldModelClass.getMethod("getRatingStatus");

					Boolean value5 = (Boolean)method5.invoke(oldModel,
							(Object[])null);

					newModel.setRatingStatus(value5.booleanValue());

					Method method6 = oldModelClass.getMethod("getPointName");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setPointName(value6);

					Method method7 = oldModelClass.getMethod("getMaxPointName");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setMaxPointName(value7);

					Method method8 = oldModelClass.getMethod("getPointValue");

					Integer value8 = (Integer)method8.invoke(oldModel,
							(Object[])null);

					newModel.setPointValue(value8.intValue());

					Method method9 = oldModelClass.getMethod("getMaxPointValue");

					Integer value9 = (Integer)method9.invoke(oldModel,
							(Object[])null);

					newModel.setMaxPointValue(value9.intValue());

					Method method10 = oldModelClass.getMethod("getIsPassed");

					Boolean value10 = (Boolean)method10.invoke(oldModel,
							(Object[])null);

					newModel.setIsPassed(value10.booleanValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.ViewFinalCompetenciesImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ViewFinalCompetenciesClp newModel = new ViewFinalCompetenciesClp();

					Method method0 = oldModelClass.getMethod("getCompetencyId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setCompetencyId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getName");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setName(value2);

					Method method3 = oldModelClass.getMethod("getUserId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value3.intValue());

					Method method4 = oldModelClass.getMethod(
							"getLevelRankingHash");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setLevelRankingHash(value4.intValue());

					Method method5 = oldModelClass.getMethod(
							"getLevelRankingValue");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setLevelRankingValue(value5);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.ViewFinalLevelsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ViewFinalLevelsClp newModel = new ViewFinalLevelsClp();

					Method method0 = oldModelClass.getMethod("getLevelId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLevelId(value0);

					Method method1 = oldModelClass.getMethod("getCompetencyId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setCompetencyId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRootId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getName");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setName(value3);

					Method method4 = oldModelClass.getMethod("getUserId");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value4.intValue());

					Method method5 = oldModelClass.getMethod(
							"getTotalLevelPoint");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setTotalLevelPoint(value5.intValue());

					Method method6 = oldModelClass.getMethod("getIsPassed");

					Boolean value6 = (Boolean)method6.invoke(oldModel,
							(Object[])null);

					newModel.setIsPassed(value6.booleanValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.ViewFinalSlotsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ViewFinalSlotsClp newModel = new ViewFinalSlotsClp();

					Method method0 = oldModelClass.getMethod("getSlotId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setSlotId(value0);

					Method method1 = oldModelClass.getMethod("getLevelId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setLevelId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRootId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getName");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setName(value3);

					Method method4 = oldModelClass.getMethod("getDescription");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value4);

					Method method5 = oldModelClass.getMethod("getUserId");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value5.intValue());

					Method method6 = oldModelClass.getMethod("getRatingStatus");

					Boolean value6 = (Boolean)method6.invoke(oldModel,
							(Object[])null);

					newModel.setRatingStatus(value6.booleanValue());

					Method method7 = oldModelClass.getMethod("getPointName");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setPointName(value7);

					Method method8 = oldModelClass.getMethod("getMaxPointName");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setMaxPointName(value8);

					Method method9 = oldModelClass.getMethod("getPointValue");

					Integer value9 = (Integer)method9.invoke(oldModel,
							(Object[])null);

					newModel.setPointValue(value9.intValue());

					Method method10 = oldModelClass.getMethod(
							"getMaxPointValue");

					Integer value10 = (Integer)method10.invoke(oldModel,
							(Object[])null);

					newModel.setMaxPointValue(value10.intValue());

					Method method11 = oldModelClass.getMethod("getIsPassed");

					Boolean value11 = (Boolean)method11.invoke(oldModel,
							(Object[])null);

					newModel.setIsPassed(value11.booleanValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.ViewFinalTitlesImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ViewFinalTitlesClp newModel = new ViewFinalTitlesClp();

					Method method0 = oldModelClass.getMethod(
							"getViewFinalTitlesId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setViewFinalTitlesId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getUserId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getTitleId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setTitleId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getTitleName");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setTitleName(value4);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.ViewSlotInformationImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ViewSlotInformationClp newModel = new ViewSlotInformationClp();

					Method method0 = oldModelClass.getMethod(
							"getViewSlotInformationId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setViewSlotInformationId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getUserId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getSlotId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setSlotId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getPointName");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setPointName(value4);

					Method method5 = oldModelClass.getMethod("getMaxPointName");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setMaxPointName(value5);

					Method method6 = oldModelClass.getMethod("getIsPassed");

					Boolean value6 = (Boolean)method6.invoke(oldModel,
							(Object[])null);

					newModel.setIsPassed(value6.booleanValue());

					Method method7 = oldModelClass.getMethod("getPeriodName");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setPeriodName(value7);

					Method method8 = oldModelClass.getMethod("getFromDate");

					Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

					newModel.setFromDate(value8);

					Method method9 = oldModelClass.getMethod("getToDate");

					Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

					newModel.setToDate(value9);

					Method method10 = oldModelClass.getMethod("getPmName");

					String value10 = (String)method10.invoke(oldModel,
							(Object[])null);

					newModel.setPmName(value10);

					Method method11 = oldModelClass.getMethod("getOrgName");

					String value11 = (String)method11.invoke(oldModel,
							(Object[])null);

					newModel.setOrgName(value11);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.CdsPASlotsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					CdsPASlotsClp newModel = new CdsPASlotsClp();

					Method method0 = oldModelClass.getMethod("getCdsPASlotsId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setCdsPASlotsId(value0);

					Method method1 = oldModelClass.getMethod("getPaId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setPaId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRootId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getPeriodId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setPeriodId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getUserId");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value4.intValue());

					Method method5 = oldModelClass.getMethod("getSlotId");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setSlotId(value5.intValue());

					Method method6 = oldModelClass.getMethod("getPmUid");

					Integer value6 = (Integer)method6.invoke(oldModel,
							(Object[])null);

					newModel.setPmUid(value6.intValue());

					Method method7 = oldModelClass.getMethod("getBodUid");

					Integer value7 = (Integer)method7.invoke(oldModel,
							(Object[])null);

					newModel.setBodUid(value7.intValue());

					Method method8 = oldModelClass.getMethod("getRatingOrgId");

					Integer value8 = (Integer)method8.invoke(oldModel,
							(Object[])null);

					newModel.setRatingOrgId(value8.intValue());

					Method method9 = oldModelClass.getMethod("getRatingStatus");

					Integer value9 = (Integer)method9.invoke(oldModel,
							(Object[])null);

					newModel.setRatingStatus(value9.intValue());

					Method method10 = oldModelClass.getMethod(
							"getRatingStatusPm");

					Integer value10 = (Integer)method10.invoke(oldModel,
							(Object[])null);

					newModel.setRatingStatusPm(value10.intValue());

					Method method11 = oldModelClass.getMethod(
							"getRatingStatusBod");

					Integer value11 = (Integer)method11.invoke(oldModel,
							(Object[])null);

					newModel.setRatingStatusBod(value11.intValue());

					Method method12 = oldModelClass.getMethod("getPointName");

					String value12 = (String)method12.invoke(oldModel,
							(Object[])null);

					newModel.setPointName(value12);

					Method method13 = oldModelClass.getMethod("getMaxPointName");

					String value13 = (String)method13.invoke(oldModel,
							(Object[])null);

					newModel.setMaxPointName(value13);

					Method method14 = oldModelClass.getMethod("getPointValue");

					Integer value14 = (Integer)method14.invoke(oldModel,
							(Object[])null);

					newModel.setPointValue(value14.intValue());

					Method method15 = oldModelClass.getMethod(
							"getMaxPointValue");

					Integer value15 = (Integer)method15.invoke(oldModel,
							(Object[])null);

					newModel.setMaxPointValue(value15.intValue());

					Method method16 = oldModelClass.getMethod("getIsPassed");

					Boolean value16 = (Boolean)method16.invoke(oldModel,
							(Object[])null);

					newModel.setIsPassed(value16.booleanValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.CdsPALevelsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					CdsPALevelsClp newModel = new CdsPALevelsClp();

					Method method0 = oldModelClass.getMethod("getCdsPALevelsId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setCdsPALevelsId(value0);

					Method method1 = oldModelClass.getMethod("getPaId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setPaId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRootId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getPeriodId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setPeriodId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getUserId");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value4.intValue());

					Method method5 = oldModelClass.getMethod("getLevelId");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setLevelId(value5.intValue());

					Method method6 = oldModelClass.getMethod(
							"getTotalLevelPoint");

					Integer value6 = (Integer)method6.invoke(oldModel,
							(Object[])null);

					newModel.setTotalLevelPoint(value6.intValue());

					Method method7 = oldModelClass.getMethod("getIsPassed");

					Boolean value7 = (Boolean)method7.invoke(oldModel,
							(Object[])null);

					newModel.setIsPassed(value7.booleanValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.CdsPACompetenciesImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					CdsPACompetenciesClp newModel = new CdsPACompetenciesClp();

					Method method0 = oldModelClass.getMethod(
							"getCdsPACompetenciesId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setCdsPACompetenciesId(value0);

					Method method1 = oldModelClass.getMethod("getPaId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setPaId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRootId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getPeriodId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setPeriodId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getUserId");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value4.intValue());

					Method method5 = oldModelClass.getMethod("getCompetencyId");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setCompetencyId(value5.intValue());

					Method method6 = oldModelClass.getMethod(
							"getLevelRankingHash");

					Integer value6 = (Integer)method6.invoke(oldModel,
							(Object[])null);

					newModel.setLevelRankingHash(value6.intValue());

					Method method7 = oldModelClass.getMethod(
							"getLevelRankingValue");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setLevelRankingValue(value7);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.ViewPerformanceAppraisalLevelsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ViewPerformanceAppraisalLevelsClp newModel = new ViewPerformanceAppraisalLevelsClp();

					Method method0 = oldModelClass.getMethod("getId");

					String value0 = (String)method0.invoke(oldModel,
							(Object[])null);

					newModel.setId(value0);

					Method method1 = oldModelClass.getMethod("getLevelId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setLevelId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getNumberOrder");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setNumberOrder(value2.intValue());

					Method method3 = oldModelClass.getMethod("getCompetencyId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setCompetencyId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getRootId");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value4.intValue());

					Method method5 = oldModelClass.getMethod("getLevelName");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setLevelName(value5);

					Method method6 = oldModelClass.getMethod("getPaId");

					Integer value6 = (Integer)method6.invoke(oldModel,
							(Object[])null);

					newModel.setPaId(value6.intValue());

					Method method7 = oldModelClass.getMethod("getUserId");

					Integer value7 = (Integer)method7.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value7.intValue());

					Method method8 = oldModelClass.getMethod("getPeriodId");

					Integer value8 = (Integer)method8.invoke(oldModel,
							(Object[])null);

					newModel.setPeriodId(value8.intValue());

					Method method9 = oldModelClass.getMethod(
							"getTotalLevelPoint");

					Integer value9 = (Integer)method9.invoke(oldModel,
							(Object[])null);

					newModel.setTotalLevelPoint(value9.intValue());

					Method method10 = oldModelClass.getMethod("getIsPassed");

					Boolean value10 = (Boolean)method10.invoke(oldModel,
							(Object[])null);

					newModel.setIsPassed(value10.booleanValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.ViewPerformanceAppraisalSlotsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ViewPerformanceAppraisalSlotsClp newModel = new ViewPerformanceAppraisalSlotsClp();

					Method method0 = oldModelClass.getMethod("getId");

					String value0 = (String)method0.invoke(oldModel,
							(Object[])null);

					newModel.setId(value0);

					Method method1 = oldModelClass.getMethod("getSlotId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setSlotId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getLevelId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setLevelId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getCompetencyId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setCompetencyId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getRootId");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value4.intValue());

					Method method5 = oldModelClass.getMethod("getSlotName");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setSlotName(value5);

					Method method6 = oldModelClass.getMethod("getAliasName");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setAliasName(value6);

					Method method7 = oldModelClass.getMethod("getDescription");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value7);

					Method method8 = oldModelClass.getMethod("getPaId");

					Integer value8 = (Integer)method8.invoke(oldModel,
							(Object[])null);

					newModel.setPaId(value8.intValue());

					Method method9 = oldModelClass.getMethod(
							"getSlotNumberOrder");

					Integer value9 = (Integer)method9.invoke(oldModel,
							(Object[])null);

					newModel.setSlotNumberOrder(value9.intValue());

					Method method10 = oldModelClass.getMethod(
							"getLevelNumberOrder");

					Integer value10 = (Integer)method10.invoke(oldModel,
							(Object[])null);

					newModel.setLevelNumberOrder(value10.intValue());

					Method method11 = oldModelClass.getMethod(
							"getCompetencyNumberOrder");

					Integer value11 = (Integer)method11.invoke(oldModel,
							(Object[])null);

					newModel.setCompetencyNumberOrder(value11.intValue());

					Method method12 = oldModelClass.getMethod("getUserId");

					Integer value12 = (Integer)method12.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value12.intValue());

					Method method13 = oldModelClass.getMethod("getPeriodId");

					Integer value13 = (Integer)method13.invoke(oldModel,
							(Object[])null);

					newModel.setPeriodId(value13.intValue());

					Method method14 = oldModelClass.getMethod("getPeriodName");

					String value14 = (String)method14.invoke(oldModel,
							(Object[])null);

					newModel.setPeriodName(value14);

					Method method15 = oldModelClass.getMethod("getFromDate");

					Date value15 = (Date)method15.invoke(oldModel,
							(Object[])null);

					newModel.setFromDate(value15);

					Method method16 = oldModelClass.getMethod("getToDate");

					Date value16 = (Date)method16.invoke(oldModel,
							(Object[])null);

					newModel.setToDate(value16);

					Method method17 = oldModelClass.getMethod("getBodUid");

					Integer value17 = (Integer)method17.invoke(oldModel,
							(Object[])null);

					newModel.setBodUid(value17.intValue());

					Method method18 = oldModelClass.getMethod("getPmUid");

					Integer value18 = (Integer)method18.invoke(oldModel,
							(Object[])null);

					newModel.setPmUid(value18.intValue());

					Method method19 = oldModelClass.getMethod("getRatingOrgId");

					Integer value19 = (Integer)method19.invoke(oldModel,
							(Object[])null);

					newModel.setRatingOrgId(value19.intValue());

					Method method20 = oldModelClass.getMethod("getRatingStatus");

					Integer value20 = (Integer)method20.invoke(oldModel,
							(Object[])null);

					newModel.setRatingStatus(value20.intValue());

					Method method21 = oldModelClass.getMethod(
							"getRatingStatusBod");

					Integer value21 = (Integer)method21.invoke(oldModel,
							(Object[])null);

					newModel.setRatingStatusBod(value21.intValue());

					Method method22 = oldModelClass.getMethod(
							"getRatingStatusPm");

					Integer value22 = (Integer)method22.invoke(oldModel,
							(Object[])null);

					newModel.setRatingStatusPm(value22.intValue());

					Method method23 = oldModelClass.getMethod("getPointName");

					String value23 = (String)method23.invoke(oldModel,
							(Object[])null);

					newModel.setPointName(value23);

					Method method24 = oldModelClass.getMethod("getMaxPointName");

					String value24 = (String)method24.invoke(oldModel,
							(Object[])null);

					newModel.setMaxPointName(value24);

					Method method25 = oldModelClass.getMethod("getPointValue");

					Integer value25 = (Integer)method25.invoke(oldModel,
							(Object[])null);

					newModel.setPointValue(value25.intValue());

					Method method26 = oldModelClass.getMethod(
							"getMaxPointValue");

					Integer value26 = (Integer)method26.invoke(oldModel,
							(Object[])null);

					newModel.setMaxPointValue(value26.intValue());

					Method method27 = oldModelClass.getMethod("getIsPassed");

					Boolean value27 = (Boolean)method27.invoke(oldModel,
							(Object[])null);

					newModel.setIsPassed(value27.booleanValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.CdsPerformanceAppraisalSlotRatingImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					CdsPerformanceAppraisalSlotRatingClp newModel = new CdsPerformanceAppraisalSlotRatingClp();

					Method method0 = oldModelClass.getMethod(
							"getCdsPerformanceAppraisalSlotRatingId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setCdsPerformanceAppraisalSlotRatingId(value0);

					Method method1 = oldModelClass.getMethod("getPaId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setPaId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRootId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getPeriodId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setPeriodId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getUserId");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value4.intValue());

					Method method5 = oldModelClass.getMethod("getSlotId");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setSlotId(value5.intValue());

					Method method6 = oldModelClass.getMethod("getRatingBy");

					Integer value6 = (Integer)method6.invoke(oldModel,
							(Object[])null);

					newModel.setRatingBy(value6.intValue());

					Method method7 = oldModelClass.getMethod("getRatingAt");

					Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

					newModel.setRatingAt(value7);

					Method method8 = oldModelClass.getMethod("getRatingStatus");

					Boolean value8 = (Boolean)method8.invoke(oldModel,
							(Object[])null);

					newModel.setRatingStatus(value8.booleanValue());

					Method method9 = oldModelClass.getMethod("getUserType");

					Integer value9 = (Integer)method9.invoke(oldModel,
							(Object[])null);

					newModel.setUserType(value9.intValue());

					Method method10 = oldModelClass.getMethod("getPointName");

					String value10 = (String)method10.invoke(oldModel,
							(Object[])null);

					newModel.setPointName(value10);

					Method method11 = oldModelClass.getMethod("getPointValue");

					Integer value11 = (Integer)method11.invoke(oldModel,
							(Object[])null);

					newModel.setPointValue(value11.intValue());

					Method method12 = oldModelClass.getMethod("getRatingOrgId");

					Integer value12 = (Integer)method12.invoke(oldModel,
							(Object[])null);

					newModel.setRatingOrgId(value12.intValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.CdsPerformanceAppraisalSlotCommentsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					CdsPerformanceAppraisalSlotCommentsClp newModel = new CdsPerformanceAppraisalSlotCommentsClp();

					Method method0 = oldModelClass.getMethod(
							"getCdsPerformanceAppraisalSlotCommentsId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setCdsPerformanceAppraisalSlotCommentsId(value0);

					Method method1 = oldModelClass.getMethod("getPaId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setPaId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRootId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getPeriodId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setPeriodId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getUserId");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value4.intValue());

					Method method5 = oldModelClass.getMethod("getSlotId");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setSlotId(value5.intValue());

					Method method6 = oldModelClass.getMethod("getCommentBy");

					Integer value6 = (Integer)method6.invoke(oldModel,
							(Object[])null);

					newModel.setCommentBy(value6.intValue());

					Method method7 = oldModelClass.getMethod("getCommentAt");

					Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

					newModel.setCommentAt(value7);

					Method method8 = oldModelClass.getMethod(
							"getCommentContent");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setCommentContent(value8);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.CdsPerformanceAppraisalsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					CdsPerformanceAppraisalsClp newModel = new CdsPerformanceAppraisalsClp();

					Method method0 = oldModelClass.getMethod(
							"getCdsPerformanceAppraisalsId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setCdsPerformanceAppraisalsId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getPeriodId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setPeriodId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getUserId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getTitleId");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setTitleId(value4.intValue());

					Method method5 = oldModelClass.getMethod("getRatingStatus");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setRatingStatus(value5.intValue());

					Method method6 = oldModelClass.getMethod(
							"getRatingStatusPm");

					Integer value6 = (Integer)method6.invoke(oldModel,
							(Object[])null);

					newModel.setRatingStatusPm(value6.intValue());

					Method method7 = oldModelClass.getMethod(
							"getRatingStatusBod");

					Integer value7 = (Integer)method7.invoke(oldModel,
							(Object[])null);

					newModel.setRatingStatusBod(value7.intValue());

					Method method8 = oldModelClass.getMethod("getIsLocked");

					Boolean value8 = (Boolean)method8.invoke(oldModel,
							(Object[])null);

					newModel.setIsLocked(value8.booleanValue());

					Method method9 = oldModelClass.getMethod("getPmList");

					String value9 = (String)method9.invoke(oldModel,
							(Object[])null);

					newModel.setPmList(value9);

					Method method10 = oldModelClass.getMethod("getOrgList");

					String value10 = (String)method10.invoke(oldModel,
							(Object[])null);

					newModel.setOrgList(value10);

					Method method11 = oldModelClass.getMethod("getBodList");

					String value11 = (String)method11.invoke(oldModel,
							(Object[])null);

					newModel.setBodList(value11);

					Method method12 = oldModelClass.getMethod("getIsTitleUp");

					Boolean value12 = (Boolean)method12.invoke(oldModel,
							(Object[])null);

					newModel.setIsTitleUp(value12.booleanValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.ViewEmployeesInProjectsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ViewEmployeesInProjectsClp newModel = new ViewEmployeesInProjectsClp();

					Method method0 = oldModelClass.getMethod("getId");

					String value0 = (String)method0.invoke(oldModel,
							(Object[])null);

					newModel.setId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getUserId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getFirstName");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setFirstName(value3);

					Method method4 = oldModelClass.getMethod("getMiddleName");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setMiddleName(value4);

					Method method5 = oldModelClass.getMethod("getLastName");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setLastName(value5);

					Method method6 = oldModelClass.getMethod("getPosition");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setPosition(value6);

					Method method7 = oldModelClass.getMethod(
							"getTitleAbbreviation");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setTitleAbbreviation(value7);

					Method method8 = oldModelClass.getMethod("getTitleName");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setTitleName(value8);

					Method method9 = oldModelClass.getMethod("getOrgId");

					Integer value9 = (Integer)method9.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value9.intValue());

					Method method10 = oldModelClass.getMethod("getOrgList");

					String value10 = (String)method10.invoke(oldModel,
							(Object[])null);

					newModel.setOrgList(value10);

					Method method11 = oldModelClass.getMethod("getPmList");

					String value11 = (String)method11.invoke(oldModel,
							(Object[])null);

					newModel.setPmList(value11);

					Method method12 = oldModelClass.getMethod("getPeriodId");

					Integer value12 = (Integer)method12.invoke(oldModel,
							(Object[])null);

					newModel.setPeriodId(value12.intValue());

					Method method13 = oldModelClass.getMethod("getPeriodName");

					String value13 = (String)method13.invoke(oldModel,
							(Object[])null);

					newModel.setPeriodName(value13);

					Method method14 = oldModelClass.getMethod("getFromDate");

					Date value14 = (Date)method14.invoke(oldModel,
							(Object[])null);

					newModel.setFromDate(value14);

					Method method15 = oldModelClass.getMethod("getToDate");

					Date value15 = (Date)method15.invoke(oldModel,
							(Object[])null);

					newModel.setToDate(value15);

					Method method16 = oldModelClass.getMethod("getPeriodStatus");

					Integer value16 = (Integer)method16.invoke(oldModel,
							(Object[])null);

					newModel.setPeriodStatus(value16.intValue());

					Method method17 = oldModelClass.getMethod("getRatingStatus");

					Integer value17 = (Integer)method17.invoke(oldModel,
							(Object[])null);

					newModel.setRatingStatus(value17.intValue());

					Method method18 = oldModelClass.getMethod(
							"getRatingStatusPm");

					Integer value18 = (Integer)method18.invoke(oldModel,
							(Object[])null);

					newModel.setRatingStatusPm(value18.intValue());

					Method method19 = oldModelClass.getMethod(
							"getRatingStatusBod");

					Integer value19 = (Integer)method19.invoke(oldModel,
							(Object[])null);

					newModel.setRatingStatusBod(value19.intValue());

					Method method20 = oldModelClass.getMethod("getIsActive");

					Boolean value20 = (Boolean)method20.invoke(oldModel,
							(Object[])null);

					newModel.setIsActive(value20.booleanValue());

					Method method21 = oldModelClass.getMethod("getIsRemoved");

					Boolean value21 = (Boolean)method21.invoke(oldModel,
							(Object[])null);

					newModel.setIsRemoved(value21.booleanValue());

					Method method22 = oldModelClass.getMethod("getIsLocked");

					Boolean value22 = (Boolean)method22.invoke(oldModel,
							(Object[])null);

					newModel.setIsLocked(value22.booleanValue());

					Method method23 = oldModelClass.getMethod("getBeginTime");

					Date value23 = (Date)method23.invoke(oldModel,
							(Object[])null);

					newModel.setBeginTime(value23);

					Method method24 = oldModelClass.getMethod("getEndTime");

					Date value24 = (Date)method24.invoke(oldModel,
							(Object[])null);

					newModel.setEndTime(value24);

					Method method25 = oldModelClass.getMethod("getIsTitleUp");

					Boolean value25 = (Boolean)method25.invoke(oldModel,
							(Object[])null);

					newModel.setIsTitleUp(value25.booleanValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.ViewEmployeesSlotsRatingImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ViewEmployeesSlotsRatingClp newModel = new ViewEmployeesSlotsRatingClp();

					Method method0 = oldModelClass.getMethod("getId");

					String value0 = (String)method0.invoke(oldModel,
							(Object[])null);

					newModel.setId(value0);

					Method method1 = oldModelClass.getMethod("getAliasName");

					String value1 = (String)method1.invoke(oldModel,
							(Object[])null);

					newModel.setAliasName(value1);

					Method method2 = oldModelClass.getMethod("getDescription");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value2);

					Method method3 = oldModelClass.getMethod("getNumberOrder");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setNumberOrder(value3.intValue());

					Method method4 = oldModelClass.getMethod("getUserId");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value4.intValue());

					Method method5 = oldModelClass.getMethod("getPeriodId");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setPeriodId(value5.intValue());

					Method method6 = oldModelClass.getMethod("getPeriodName");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setPeriodName(value6);

					Method method7 = oldModelClass.getMethod("getFromDate");

					Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

					newModel.setFromDate(value7);

					Method method8 = oldModelClass.getMethod("getToDate");

					Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

					newModel.setToDate(value8);

					Method method9 = oldModelClass.getMethod("getRatingOrgId");

					Integer value9 = (Integer)method9.invoke(oldModel,
							(Object[])null);

					newModel.setRatingOrgId(value9.intValue());

					Method method10 = oldModelClass.getMethod("getRatingStatus");

					Integer value10 = (Integer)method10.invoke(oldModel,
							(Object[])null);

					newModel.setRatingStatus(value10.intValue());

					Method method11 = oldModelClass.getMethod(
							"getRatingStatusBod");

					Integer value11 = (Integer)method11.invoke(oldModel,
							(Object[])null);

					newModel.setRatingStatusBod(value11.intValue());

					Method method12 = oldModelClass.getMethod(
							"getRatingStatusPm");

					Integer value12 = (Integer)method12.invoke(oldModel,
							(Object[])null);

					newModel.setRatingStatusPm(value12.intValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.CdsSlotStatisticalReportImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					CdsSlotStatisticalReportClp newModel = new CdsSlotStatisticalReportClp();

					Method method0 = oldModelClass.getMethod("getSlotId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setSlotId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getLevelId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setLevelId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getName");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setName(value3);

					Method method4 = oldModelClass.getMethod("getDescription");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value4);

					Method method5 = oldModelClass.getMethod("getPeriodId");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setPeriodId(value5.intValue());

					Method method6 = oldModelClass.getMethod("getUserId");

					Integer value6 = (Integer)method6.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value6.intValue());

					Method method7 = oldModelClass.getMethod("getPmId");

					Integer value7 = (Integer)method7.invoke(oldModel,
							(Object[])null);

					newModel.setPmId(value7.intValue());

					Method method8 = oldModelClass.getMethod("getFirstName");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setFirstName(value8);

					Method method9 = oldModelClass.getMethod("getLastName");

					String value9 = (String)method9.invoke(oldModel,
							(Object[])null);

					newModel.setLastName(value9);

					Method method10 = oldModelClass.getMethod(
							"getRatingStatusPm");

					Integer value10 = (Integer)method10.invoke(oldModel,
							(Object[])null);

					newModel.setRatingStatusPm(value10.intValue());

					Method method11 = oldModelClass.getMethod(
							"getRatingStatusBod");

					Integer value11 = (Integer)method11.invoke(oldModel,
							(Object[])null);

					newModel.setRatingStatusBod(value11.intValue());

					Method method12 = oldModelClass.getMethod("getPointName");

					String value12 = (String)method12.invoke(oldModel,
							(Object[])null);

					newModel.setPointName(value12);

					Method method13 = oldModelClass.getMethod("getPointValue");

					Integer value13 = (Integer)method13.invoke(oldModel,
							(Object[])null);

					newModel.setPointValue(value13.intValue());

					Method method14 = oldModelClass.getMethod("getMaxPointName");

					String value14 = (String)method14.invoke(oldModel,
							(Object[])null);

					newModel.setMaxPointName(value14);

					Method method15 = oldModelClass.getMethod(
							"getMaxPointValue");

					Integer value15 = (Integer)method15.invoke(oldModel,
							(Object[])null);

					newModel.setMaxPointValue(value15.intValue());

					Method method16 = oldModelClass.getMethod("getToDate");

					Date value16 = (Date)method16.invoke(oldModel,
							(Object[])null);

					newModel.setToDate(value16);

					Method method17 = oldModelClass.getMethod("getStatus");

					Integer value17 = (Integer)method17.invoke(oldModel,
							(Object[])null);

					newModel.setStatus(value17.intValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.CdsLevelStatisticalReportImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					CdsLevelStatisticalReportClp newModel = new CdsLevelStatisticalReportClp();

					Method method0 = oldModelClass.getMethod("getLevelId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setLevelId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getCompetencyId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setCompetencyId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getName");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setName(value3);

					Method method4 = oldModelClass.getMethod("getPeriodId");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setPeriodId(value4.intValue());

					Method method5 = oldModelClass.getMethod("getUserId");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value5.intValue());

					Method method6 = oldModelClass.getMethod(
							"getTotalLevelPoint");

					Integer value6 = (Integer)method6.invoke(oldModel,
							(Object[])null);

					newModel.setTotalLevelPoint(value6.intValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.CdsCompetencyStatisticalReportImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					CdsCompetencyStatisticalReportClp newModel = new CdsCompetencyStatisticalReportClp();

					Method method0 = oldModelClass.getMethod("getCompetencyId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setCompetencyId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getName");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setName(value2);

					Method method3 = oldModelClass.getMethod("getPeriodId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setPeriodId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getUserId");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value4.intValue());

					Method method5 = oldModelClass.getMethod(
							"getLevelRankingHash");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setLevelRankingHash(value5.intValue());

					Method method6 = oldModelClass.getMethod(
							"getLevelRankingValue");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setLevelRankingValue(value6);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals("larion.progate.cds.model.impl.CdsCdpImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					CdsCdpClp newModel = new CdsCdpClp();

					Method method0 = oldModelClass.getMethod("getCdsCdpId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setCdsCdpId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getPeriodId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setPeriodId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getUserId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getWrittenBy");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setWrittenBy(value4.intValue());

					Method method5 = oldModelClass.getMethod("getWrittenAt");

					Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

					newModel.setWrittenAt(value5);

					Method method6 = oldModelClass.getMethod(
							"getWrittenContent");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setWrittenContent(value6);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.cds.model.impl.CdsPAFinalImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					CdsPAFinalClp newModel = new CdsPAFinalClp();

					Method method0 = oldModelClass.getMethod("getCdsPAFinalId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setCdsPAFinalId(value0);

					Method method1 = oldModelClass.getMethod("getRootId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getUserId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getCdsTitleId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setCdsTitleId(value3.intValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel) {
			return translateOutput((BaseModel)obj);
		}
		else if (obj instanceof List) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
}