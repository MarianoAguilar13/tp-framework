async function main() {
  console.log("holasssss");

  const container = document.querySelector(".containerClients");

  const arrayClients = await getClientes();

  if (arrayClients) {
    console.log("todos los clientes: ", arrayClients);

    for (const client of arrayClients) {
      const newClient = document.createElement("div");

      newClient.innerHTML = `
      <div class="tableHomeRow">
        <div class="tableHomeRowCelda">
          <p class="tableHomeRowCeldaText">${client.nombre}</p>
        </div>
        <div class="tableHomeRowCelda">
          <p class="tableHomeRowCeldaText">${client.email}</p>
        </div>
        <div class="tableHomeRowCelda">
          <p class="tableHomeRowCeldaText">${client.contrasenia}</p>
        </div>
        <div class="tableHomeRowCelda">
          <p class="tableHomeRowCeldaText">${client.edad}</p>
        </div>
      </div>
`;
      container.appendChild(newClient);
    }
  } else {
    alert("No hay clientes cargados.");
  }
}

async function getClientes() {
  const fetchApi = fetch("apiGetUsuarios", {
    method: "get",

    headers: {
      "content-type": "application/json",
    },
  });

  try {
    const res = await fetchApi;

    const respuesta = await res.json();

    return respuesta;

  } catch (r) {
    console.log("este es el error: ", r);

    return r;
  }
}

main();
