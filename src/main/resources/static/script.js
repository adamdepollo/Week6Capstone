/*The following code is used to create a checkbox showing whether a task is complete. 
 * The innerHTML for these elements is generated from a Hibernate query returning the 
 * boolean value for whether the task is complete.
 */
var i;
for (i = 1; i <= document.getElementById('length').innerHTML; i++) {
	var comp = document.getElementById('comp' + i);
	if (comp.innerHTML === 'false') {
		comp.innerHTML = '<label class="checkbox-label"><input type="checkbox" class="form-check-input" id="complete'
				+ i
				+ '" name="complete"><span class="checkbox-custom"></span></label>';
	} else {
		comp.innerHTML = '<label class="checkbox-label"><input type="checkbox" class="form-check-input align-center" id="complete'
				+ i
				+ '" checked name="complete"><span class="checkbox-custom"></span></label>';
	}

	document.getElementById('complete' + i).onchange = function() {
		this.form.submit();
	}
}


//This code is used to create the sort buttons that appear on the tasklist page
$(document).ready(function() {
	$('#dtOrder').DataTable({
		"order" : [ [ 3, "desc" ] ]
	});
	$('.dataTables_length').addClass('bs-select');
});

//This code displays an empty search alert if the user completes a task search that returns nothing
if (document.getElementById('emptySearchAlert').innerHTML !== "") {
	document.getElementById('emptySearchAlert').removeAttribute("style");
}