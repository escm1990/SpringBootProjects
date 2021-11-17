// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarUsuarios();
  $('#usuarios').DataTable();
});

async function cargarUsuarios(){

  const peticion = await fetch('api/usuarios', {
    method: 'GET',
    headers: getHeaders(),
  });
  const usuarios = await peticion.json();

  let listadoUsuarios = '';

  for(let usuario of usuarios){
    let btn_eliminar = '<a href="#" onclick="eliminarUsuario('+usuario.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
    let usuarioFila = '<tr><td>'+usuario.id+'</td><td>'+usuario.nombre+' '+usuario.apellido+'</td><td>'+usuario.email+'</td><td>'+usuario.telefono+'</td><td>'+btn_eliminar+'</td></tr>';
    listadoUsuarios += usuarioFila;
  }

  document.querySelector("#usuarios tbody").outerHTML = listadoUsuarios;

}

function getHeaders(){
    return {
             'Accept': 'application/json',
             'Content-Type': 'application/json',
             'Autorization': localStorage.token
           }
}

async function eliminarUsuario(id){

    if(!confirm('¿Desea eliminar este usuario?')){
        return;
    }

    const peticion = await fetch('api/usuario/'+id, {
                method: 'DELETE',
                headers: getHeaders(),
              });

        location.reload()
}