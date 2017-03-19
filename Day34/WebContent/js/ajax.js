/**
 * 创建AJAX对象
 */
function createAjax() {
	//定义一个AJAX对象
	var ajax=null;
	//创建AJAX对象
	try {
		ajax=new actionXObject("microsoft.xmlhttp");
	} catch (e1) {
		try {
			ajax=new XMLHttpRequest();
		} catch (e) {
			window.alert("您的浏览器不支持AJAX请更换浏览器！");
		}
	}
	return ajax;
}