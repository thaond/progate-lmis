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

package larion.progate.cds.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

import larion.progate.cds.model.Level;
import larion.progate.cds.model.Slot;
import larion.progate.cds.service.LevelLocalServiceUtil;
import larion.progate.cds.service.base.SlotLocalServiceBaseImpl;
import larion.progate.cds.service.persistence.SlotFinderUtil;
import larion.progate.cds.service.persistence.SlotUtil;
import larion.progate.cds.service.utils.Constants;

/**
 * <a href="SlotLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class SlotLocalServiceImpl extends SlotLocalServiceBaseImpl {
	//delete slot
	public boolean deleteCdsSlot(int slotId) throws PortalException, SystemException{
		try {
			//SET NUMBER ORDER
			Slot slot=getSlot(slotId);
			int numberOrder=slot.getNumberOrder();
			//Lay ra danh sach slot thuoc level chua slot can xoa
			List<Slot> slotList=getSlotListByLevelId(slot.getLevelId());
			int numberSlot=slotList.size();
			deleteSlot(slotId);
			for(int i=numberOrder;i<numberSlot;i++)
			{
				Slot slot1=slotList.get(i);
				int newnumber=slot1.getNumberOrder()-1;
				slot1.setNumberOrder(newnumber);
				Slot slot2=updateSlot(slot1);
			}
			//END SET NUMBER ORDER
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	//add slot
	public boolean addCdsSlot(int levelId, String name, int numberOrder, String description, int createdBy) throws PortalException, SystemException{
		try {
			Slot slot=createSlot(null);
			slot.setLevelId(levelId);
			slot.setName(name);
			if(numberOrder<=0)
				numberOrder=1;
			//SET NUMBER ORDER
			List<Slot> slotList=getSlotListByLevelId(levelId);
			int numberSlot=slotList.size();
			//neu numberOrder lon hon so slot thi numberOrder=so slot+1
			if(numberOrder>numberSlot)
				numberOrder=numberSlot+1;
			//neu numberOrder=so slot thi slot cuoi cung co numberOrder tang 1
			else if(numberOrder==numberSlot)
			{
				Slot slot1=slotList.get(numberSlot-1);
				slot1.setNumberOrder(numberOrder+1);
				Slot slot2=updateSlot(slot1);
			}
			else
			{	//numberOrder<numberSlot; numberOrder=5; numberSlot=10;
				//slotList: i=4;i<10;
				//lay ra slot thu 5, set lai numberOrder cua no=6
				for(int i=numberOrder-1;i<numberSlot;)
				{
					Slot slot3=slotList.get(i);
					i=i+1;
					slot3.setNumberOrder(i+1);
					Slot slot4=updateSlot(slot3);
				}
			}
			//
			slot.setNumberOrder(numberOrder);
			//END SET NUMBER ORDER
			slot.setDescription(description);
			slot.setCreatedBy(createdBy);
			//Set rootId tu level dua xuong
			Level level=LevelLocalServiceUtil.getLevel(levelId);
			slot.setRootId(level.getRootId());
			//Lay ra aliasName cua level
			String aliasLevel=level.getAliasName();
			//
			StringBuilder alias=new StringBuilder();
			alias.append(aliasLevel);
			alias.append(" - ");
			alias.append(name);
			slot.setAliasName(alias.toString());
			//Lay ra ngay hien tai lam ngay tao slot
			Date date=new Date();
			date = DateUtils.addHours(date, Constants.UTC_HOURS);//Gio lay ra bi cham 7 tieng nen phai cong them
			slot.setCreatedAt(date);
			Slot s=addSlot(slot);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	//Ham update slot
	public boolean updateCdsSlot(int slotId, String name, int numberOrder, String description, int updateBy) throws PortalException, SystemException{
		try {
			Slot slot=getSlot(slotId);
			slot.setName(name);
			slot.setDescription(description);
			slot.setUpdatedBy(updateBy);
			if(numberOrder<=0)
				numberOrder=1;
			//SET NUMBER ORDER
			//Lay ra numberOrder cua slot dang update
			int index=slot.getNumberOrder();
			List<Slot> slotList=getSlotListByLevelId(slot.getLevelId());
			int numberSlot=slotList.size();
			
			//neu numberOrder moi < numberOrder cu thi slot tu numberOrder moi
			//den slot nho hon numberOrder cu tang them 1
			//vi du 1<3: (slot 2 co numberOrder=3)
			if(numberOrder<index)
			{
				slot.setNumberOrder(numberOrder);
				for(int i=numberOrder-1;i<index-1;)
				{	//slot 0 dang co numberOrder=1 tang len 2
					Slot slot1=slotList.get(i);
					i=i+1;
					slot1.setNumberOrder(i+1);
					Slot slot2=updateSlot(slot1);
				}
			}
			//neu numberOrder moi > numberOrder cu va <= numberSlot
			//thi tu slot co numerOrder > numberOrder cu 1dv
			//den slot co numberOrder=numberOrder moi deu giam 1
			//--index=5 la slot 4 vay slot lon hon 1 la slot index
			//--slot co numberOrder=6 la slot thu 5
			else if((numberOrder>index))
			{
				if(numberOrder>numberSlot)
					numberOrder=numberSlot;
				slot.setNumberOrder(numberOrder);
				for(int i=index;i<numberOrder;i++)
				{	//slot thu 5 co numberOrder=6 giam 1 la 5
					Slot slot3=slotList.get(i);
					slot3.setNumberOrder(i);
					Slot slot4=updateSlot(slot3);
				}
			}
			//END SET NUMBER ORDER
			//Lay ra aliasName cua level chua slot dang update
			Level level=LevelLocalServiceUtil.getLevel(slot.getLevelId());
			String aliasLevel=level.getAliasName();
			//
			StringBuilder alias=new StringBuilder();
			alias.append(aliasLevel);
			alias.append(" - ");
			alias.append(name);
			slot.setAliasName(alias.toString());
			//Lay ra ngay hien tai lam ngay update slot
			Date date=new Date();
			date = DateUtils.addHours(date, Constants.UTC_HOURS);//Gio lay ra bi cham 7 tieng nen phai cong them
			slot.setUpdatedAt(date);
			Slot s=updateSlot(slot);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	//Lay ra danh sach slot co levelId=levelId truyen vao
	public List<Slot> getSlotListByLevelId(int levelId) throws PortalException, SystemException{
		List<Slot> slotList=SlotUtil.findBylevelId(levelId);
		return slotList;
	}
	//Lay ra danh sach slot dua vao slotName
	public List<Slot> getSlotListBySlotName(String slotName) throws PortalException, SystemException{
		List<Slot> slotList=SlotUtil.findByname(slotName);
		return slotList;
	}
	//Kiem tra trung ten slot
	public boolean checkSlotName (int rootId, String slotName, int levelId)
			throws SystemException, PortalException {
		try {
			List<Slot> slot = SlotFinderUtil.getExistedSlot(rootId, slotName,
					levelId);
			if (slot == null)
				slot = new ArrayList<Slot>();
			if (slot.size() != 0)
				return true; //Da ton tai
			else
				return false; //Chua ton tai
		} catch (Exception e) {
			System.out.println("ERROR in SlotLocalServiceImpl.checkSlotName " + e.toString());
			return true;
		}
	}
}