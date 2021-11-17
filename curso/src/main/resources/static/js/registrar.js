// Call the dataTables jQuery plugin
$(document).ready(function() {
    //on ready
});

async function registrarUsuario(){

  let datos = {};
  datos.nombre = document.getElementById('txtNombre').value;
  datos.apellido = document.getElementById('txtApellido').value;
  datos.telefono = document.getElementById('txtTelefono').value;
  datos.email = document.getElementById('txtEmail').value;
  datos.password = document.getElementById('txtPassword').value;

  let repetirPassword = document.getElementById('txtRepetirPassword').value;

  if(repetirPassword != datos.password){
    alert('La contraseña ingresada no coincide.');
    return;
  }

  const peticion = await fetch('api/usuarios', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });

  alert('La cuenta ha sido creada con éxito.');
  window.location.href('logueo.html');
}