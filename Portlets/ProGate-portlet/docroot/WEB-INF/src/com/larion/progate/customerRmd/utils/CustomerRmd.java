/**
 * Copyright (c) [Year] [Organization] All rights reserved.
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

package com.larion.progate.customerRmd.utils;

/**
 * <p>
 * Your description here
 * </p>
 * 
 * @author (Your name)
 * 
 */
public class CustomerRmd {
	private String customerName;
	private int customerId;
	private int customerType;
	private String customerLogo;
	private String customerWebsite;
	private String customerDescription;
	private String recommenderName;
	private String recommenderRole;
	private String recommenderDescription;
	
	public CustomerRmd(String name, int id, int type, String logo, String website,
						String description, String rmdName, String rmdRole, String rmdDescription) {
		customerName = name;
		customerId = id;
		customerType = type;
		customerLogo = logo;
		if (website.indexOf("://") > -1) {
			customerWebsite = website;
		} else {
			if (website.trim().length() > 0) {
				customerWebsite = "http://" + website;
			} else {
				customerWebsite = "";
			}
		}
		customerDescription = description;
		recommenderName = rmdName;
		recommenderRole = rmdRole;
		recommenderDescription = rmdDescription;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public String getCustomerLogo() {
		return customerLogo;
	}
	
	public int getCustomerType() {
		return customerType;
	}
	
	public String getCustomerWebsite() {
		return customerWebsite;
	}
	
	public String getCustomerDescription() {
		return customerDescription;
	}
	
	public String getRecommenderName() {
		return recommenderName;
	}
	
	public String getRecommenderRole() {
		return recommenderRole;
	}
	
	public String getRecommenderDescription() {
		return recommenderDescription;
	}
}
