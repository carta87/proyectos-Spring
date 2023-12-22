// Call the dataTables jQuery plugin
$(document).ready(function() {
});

async  function registrarUsuario(){
  let datos = {};
  datos.nombre = document.getElementById('txtNombre').value;
  datos.apellido = document.getElementById('txtApellido').value;
  datos.email = document.getElementById('txtEmail').value;
  datos.password = document.getElementById('txtPasssword').value;
  let repetirPassword = datos.password = document.getElementById('txtRepetirPassword').value;

  if ( datos.password != repetirPassword ){
  alert("la contraseña que escribiste es diferente");
  return;
  }
  const request = await fetch('usuarios', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  alert("usuario creado exitosamente");
  window.location.href = 'usuarios.html';
}

