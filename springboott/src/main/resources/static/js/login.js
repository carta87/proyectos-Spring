// Call the dataTables jQuery plugin
$(document).ready(function() {
});

async  function iciarSeccion(){
  let datos = {};
  datos.email = document.getElementById('txtEmail').value;
  datos.password = document.getElementById('txtPasssword').value;

  const request = await fetch('login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  const respuesta = await request.text();

  if(respuesta =="OK"){
    window.location.href = 'usuarios.html';
  }else {
    alert("las credenciales son incorectas. por favor intente nuevamente")
  }
}

