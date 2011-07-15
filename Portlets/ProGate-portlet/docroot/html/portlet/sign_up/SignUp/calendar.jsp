
<%@ include file="init.jsp" %>
 <p>
      To save memory, you can use a single (popup) calendar object to manage
      multiple input fields.  The following sample shows you how to do it.
    </p>

    <input size="30" id="f_date1" /><button id="f_btn1">...</button><br />
    <input size="30" id="f_date2" /><button id="f_btn2">...</button><br />

    <input size="30" id="f_date3" /><button id="f_btn3">...</button><br />
    <input size="30" id="f_date4" /><button id="f_btn4">...</button>

    <script type="text/javascript">//<![CDATA[

      var cal = Calendar.setup({
          onSelect: function(cal) { cal.hide() },
          showTime: true
      });
      cal.manageFields("f_btn1", "f_date1", "%Y-%m-%d");
      cal.manageFields("f_btn2", "f_date2", "%b %e, %Y");
      cal.manageFields("f_btn3", "f_date3", "%e %B %Y");
      cal.manageFields("f_btn4", "f_date4", "%A, %e %B, %Y");

    //]]></script>

