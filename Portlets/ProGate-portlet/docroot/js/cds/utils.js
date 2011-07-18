function pad(number, length) { //them so 0 vao truoc chu so
    var str = '' + number;
    while (str.length < length) {
        str = '0' + str;
    }
    return str;
}

function getCurrentDate(){ //tra ve ngay dang dd/MM/yyyy
	var d = new Date();
	var curr_date = d.getDate();
	var curr_month = d.getMonth();
	curr_month++;
	var curr_year = d.getFullYear();
	
	var date = pad(curr_date,2) + "/" + pad(curr_month,2) + "/" + curr_year;
	return date;
}

function getCurrentHour(){ //tra ve gio phut dang HH:mm
	var d = new Date();
	var curr_hour = d.getHours();
	var curr_min = d.getMinutes();
	
	var hour = pad(curr_hour,2) + ":" + pad(curr_min,2);
	return hour;
}