var i;
for (i = 1; i <= document.getElementById('length').innerHTML; i++) {
	var comp = document.getElementById('comp' + i);
	if (comp.innerHTML === 'false') {
		comp.innerHTML = '<label class="checkbox-label"><input type="checkbox" class="form-check-input" id="complete'
				+ i + '" name="complete"><span class="checkbox-custom"></span></label>';
	} else {
		comp.innerHTML = '<label class="checkbox-label"><input type="checkbox" class="form-check-input align-center" id="complete'
				+ i
				+ '" checked name="complete"><span class="checkbox-custom"></span></label>';
	}

	document.getElementById('complete' + i).onchange = function() {
		/*
		 * if (this.getAttribute("checked") === "checked") {
		 * this.removeAttribute("checked"); } else {
		 * this.setAttribute("checked", "checked"); }
		 */
		this.form.submit();
	}
}

$(document).ready(function() {
	$('#dtOrder').DataTable({
		"order" : [ [ 3, "desc" ] ]
	});
	$('.dataTables_length').addClass('bs-select');
});

if (document.getElementById('emptySearchAlert').innerHTML !== "") {
	document.getElementById('emptySearchAlert').removeAttribute("style");
}