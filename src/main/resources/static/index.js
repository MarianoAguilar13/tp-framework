function main() {

  const form = document.querySelector(".form");

  form.addEventListener("submit", async (e) => {
    e.preventDefault();

    const nombre = e.target.nombre.value;
    const edad = parseInt(e.target.edad.value, 10);
    const email = e.target.email.value;
    const contrasenia = e.target.contrasenia.value;

    const usuario = {
      nombre: nombre,
      edad: edad,
      email: email,
      contrasenia: contrasenia,
    };

    if (nombre && edad && email && contrasenia) {
      console.log(
        "nombre: ",
        nombre,
        "  email: ",
        email,
        "  edad: ",
        edad,
        "  contrasenia: ",
        contrasenia
      );

     const respuesta = await crearCliente(usuario);


      if (respuesta == 0) {
        alert("El nuevo cliente se ingreso correctamente");
      }else if (respuesta == 1) {
               alert("Error: El cliente ya está registrado");
      }else if (respuesta == 2) {
              alert("Error: El cliente no se pudo cargar, la contraseña debe ser una contraseña valida");
      }else if (respuesta == 3) {
             alert("Error: El cliente no se pudo cargar, el email debe ser un email valido");
      }else if (respuesta == 4) {
             alert("Error: El cliente no se pudo cargar, la edad ingresada debe ser un numero valido");
      }else {
        alert(respuesta);
      }

      const nombreEl = document.getElementById("nombreInput");
      nombreEl.value = "";
      const edadEl = document.getElementById("edadInput");
      edadEl.value = "";
      const emailEl = document.getElementById("emailInput");
      emailEl.value = "";
      const contraseniaEl = document.getElementById("contraseniaInput");
      contraseniaEl.value = "";
    } else {
      alert("Faltaron ingresar datos");
    }
  });
}

async function crearCliente(usuario) {
  console.log("Entro a la funcion crear cliente");

  console.log(usuario);

  console.log("actualizado");

  const fetchApi = fetch('apicreateusuario', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json',
    },

    body: JSON.stringify(usuario)
  });

  try {
    const res = await fetchApi;

    const respuesta = await res.json();

    if (respuesta == "ok") {
      return respuesta;
    } else {
      return respuesta;
    }
  } catch (r) {
    console.log("este es el error: ", r);

    return r;
  }
}

main();
