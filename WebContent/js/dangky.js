$(document).ready(function() {
	$("#formregis").validate({
		rules:{
			username: "required",
			userpass: "required",
			email: "required",
			fullname: "required",
			address: "required",
			phone: {
				required: true,
				minlength: 11
			}
		},
		messages: {
			username: "Vui lòng nhập tài khoản",
			userpass: "Vui lòng nhập mật khẩu",
			email: "Vui lòng nhập email",
			fullname: "Vui lòng nhập họ tên",
			address: "Vui lòng nhập địa chỉ",
			phone: {
				required: "Vui lòng nhập số điện thoại",
				minlength: "Ngắn thế chém gió à ?? Độ dài 11 số !"
			}
		}
	});
});







