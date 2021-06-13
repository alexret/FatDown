$("body").on('click', '#bBorrarRutina', borrarRutina);

function borrarRutina() {

		var idRutina = $(this).closest("tr") // Finds the closest row <tr>
    		.find("#bBorrarRutina") // Gets a descendent with class="nr"
    		.val();
    	var obj = $(this);

	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});

	var datos = {
		"idRutina": idRutina
	};

	$.ajax({
		url: "/rutina/borrarRutina",
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		data: JSON.stringify(datos),
		type: "POST",
		success: function(response) {

			var filaPreguntaABorrar = $(obj).closest("tr");
			filaPreguntaABorrar.remove();
			document.location.reload(true);
		},
		error: function(xhr, status, error) {

			var alerta =
				"<div class='alert alert-danger' role='alert'>" +
				"Error: No se pudo borrar</div>";

			$('#rutinaError').html(alerta);
		}

	});
}