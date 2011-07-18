(function(jQuery) {

	var uuid = 0;

	jQuery.fn.upload = function(url, data, callback, type) {
		var self = this, inputs, checkbox, checked,
			iframeName = 'jquery_upload' + ++uuid,
			iframe = jQuery('<iframe name="' + iframeName + '" style="position:absolute;top:-9999px" />').appendTo('body'),
			form = '<form target="' + iframeName + '" method="post" enctype="multipart/form-data" />';

		if (jQuery.isFunction(data)) {
			type = callback;
			callback = data;
			data = {};
		}

		checkbox = jQuery('input:checkbox', this);
		checked = jQuery('input:checked', this);
		form = self.wrapAll(form).parent('form').attr('action', url);

		// Make sure radios and checkboxes keep original values
		// (IE resets checkd attributes when appending)
		checkbox.removeAttr('checked');
		checked.attr('checked', true);

		inputs = createInputs(data);
		inputs = inputs ? jQuery(inputs).appendTo(form) : null;

		form.submit(function() {
			iframe.load(function() {
				var data = handleData(this, type),
					checked = jQuery('input:checked', self);

				form.after(self).remove();
				checkbox.removeAttr('checked');
				checked.attr('checked', true);
				if (inputs) {
					inputs.remove();
				}

				setTimeout(function() {
					iframe.remove();
					if (type === 'script') {
						jQuery.globalEval(data);
					}
					if (callback) {
						callback.call(self, data);
					}
				}, 0);
			});
		}).submit();

		return this;
	};

	function createInputs(data) {
		return jQuery.map(param(data), function(param) {
			return '<input type="hidden" name="' + param.name + '" value="' + param.value + '"/>';
		}).join('');
	}

	function param(data) {
		/*
		if (jQuery.isArray(data)) {
			return data;
		}*/
		
		var params = [];

		function add(name, value) {
			params.push({name:name, value:value});
		}

		if (typeof data === 'object') {
			jQuery.each(data, function(name) {
				if (jQuery.isArray(this)) {
					jQuery.each(this, function() {
						add(name, this);
					});
				} else {
					add(name, jQuery.isFunction(this) ? this() : this);
				}
			});
		} else if (typeof data === 'string') {
			jQuery.each(data.split('&'), function() {
				var param = jQuery.map(this.split('='), function(v) {
					return decodeURIComponent(v.replace(/\+/g, ' '));
				});

				add(param[0], param[1]);
			});
		}

		return params;
	}

	function handleData(iframe, type) {
		var data, contents = jQuery(iframe).contents().get(0);

		if (jQuery.isXMLDoc(contents) || contents.XMLDocument) {
			return contents.XMLDocument || contents;
		}
		data = jQuery(contents).find('body').html();

		switch (type) {
			case 'xml':
				data = parseXml(data);
				break;
			case 'json':
				data = window.eval('(' + data + ')');
				break;
		}
		return data;
	}

	function parseXml(text) {
		if (window.DOMParser) {
			return new DOMParser().parseFromString(text, 'application/xml');
		} else {
			var xml = new ActiveXObject('Microsoft.XMLDOM');
			xml.async = false;
			xml.loadXML(text);
			return xml;
		}
	}

})(jQuery);
