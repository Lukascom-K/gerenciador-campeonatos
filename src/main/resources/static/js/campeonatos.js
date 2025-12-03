const API = "http://localhost:8080/api/v1/campeonatos";

const tabela = document.getElementById("tabelaCampeonatos");
const form = document.getElementById("formCampeonato");

async function listar() {
    const resp = await fetch(API);
    const dados = await resp.json();

    tabela.innerHTML = "";

    dados.forEach(c => {
        tabela.innerHTML += `
        <tr>
            <td class="border p-2">${c.id}</td>
            <td class="border p-2">${c.nome}</td>
            <td class="border p-2">${c.ano || ""}</td>
            <td class="border p-2">${c.status || ""}</td>
            <td class="border p-2">${c.dataInicio || ""}</td>
            <td class="border p-2">
                <button onclick="editar(${c.id})" class="bg-yellow-400 px-2 py-1 rounded">Editar</button>
                <button onclick="deletar(${c.id})" class="bg-red-500 text-white px-2 py-1 rounded">Excluir</button>
            </td>
        </tr>
        `;
    });
}

async function editar(id) {
    const resp = await fetch(`${API}/${id}`);
    const c = await resp.json();

    document.getElementById("campeonatoId").value = c.id;
    document.getElementById("nome").value = c.nome;
    document.getElementById("ano").value = c.ano;
    document.getElementById("status").value = c.status;
    document.getElementById("dataInicio").value = c.dataInicio;
}

async function deletar(id) {
    if (!confirm("Deseja excluir?")) return;

    await fetch(`${API}/${id}`, { method: "DELETE" });
    listar();
}

form.addEventListener("submit", async (e) => {
    e.preventDefault();

    const id = document.getElementById("campeonatoId").value;

    const obj = {
        nome: document.getElementById("nome").value,
        ano: Number(document.getElementById("ano").value),
        status: document.getElementById("status").value,
        dataInicio: document.getElementById("dataInicio").value
    };

    if (id === "") {
        await fetch(API, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(obj)
        });
    } else {
        await fetch(`${API}/${id}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(obj)
        });
    }

    form.reset();
    listar();
});

listar();
