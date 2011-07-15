function isNumber(n) {
	return !isNaN(parseFloat(n)) && isFinite(n);
}

function isEmptyString(text) {
	if ((text.length == 0) || (text.replace(/\s/g,"") == "")) {
		return true;
	} else {
		return false;
	}
}

function isNumberKey(evt)
{
	var e = evt;
	if(window.event){
		var charCode = e.keyCode;
	} else if (e.which) { 
		var charCode = e.which;
	};
	if (charCode > 31 && (charCode < 48 || charCode > 57)){
		return false;	
	}
	return true;
}

function pressMaxLength(obj, maxLen, e)
{
	if (e.keyCode == 8 || e.keyCode == 46 ||
			e.keyCode == 35 ||
			e.keyCode == 36 ||
			e.keyCode == 37 ||
			e.keyCode == 39) {
		return true;
	}
	return (obj.value.length <= maxLen);
}
function isEmpty(text){
	text = jQuery.trim(text);
	return (text == "" || text == null);
}

function dateFormat(text) {
    var datePart = text.match(/\d+/g);
    var day = datePart[0];
    var month = datePart[1];
    var year = datePart[2];
    return month + '/' + day + '/' + year;
}

function isDateGreater(greater, lesser) {
	//convert string to date using MM/dd/yyyy format, js not support dd/MM/yyyy format (T_T)
	var greaterDate = new Date(dateFormat(greater));
	var lesserDate = new Date(dateFormat(lesser));
	return (greaterDate > lesserDate);
}

function inDateRange(compare, from, to) {
	var compareDate = new Date(dateFormat(compare));
	var fromDate = new Date(dateFormat(from));
	var toDate = new Date(dateFormat(to));
	return ((compareDate >= fromDate) && (compareDate <= toDate));
}
