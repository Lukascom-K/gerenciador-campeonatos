const API = "http://localhost:8080/api/v1/jogadores";
const tabela = document.getElementById("tabelaJogadores");
const form = document.getElementById("formJogador");

async function listar() {
    const resp = await fetch(API);
    const dados = await resp.json();
    tabela.innerHTML = "";
    dados.forEach(j => {
        tabela.innerHTML += `
        <tr>
            <td class="border p-2">${j.id}</td>
            <td class="border p-2">${j.nome}</td>
            <td class="border p-2">${j.numeroCamisa || ""}</td>
            <td class="border p-2">${j.time ? (j.time.id || j.time) : ""}</td>
            <td class="border p-2">
                <button onclick="editar(${j.id})" class="bg-yellow-400 px-2 py-1 rounded">Editar</button>
                <button onclick="deletar(${j.id})" class="bg-red-500 text-white px-2 py-1 rounded">Excluir</button>
            </td>
        </tr>`;
    });
}

async function editar(id) {
    const resp = await fetch(`${API}/${id}`);
    const j = await resp.json();
    document.getElementById("jogadorId").value = j.id;
    document.getElementById("nome").value = j.nome || "";
    document.getElementById("numeroCamisa").value = j.numeroCamisa || "";
    document.getElementById("timeId").value = j.time ? (j.time.id || j.time) : "";
}

async function deletar(id) {
    if(!confirm("Deseja excluir este jogador?")) return;
    await fetch(`${API}/${id}`, { method: "DELETE" });
    listar();
}

form.addEventListener("submit", async (e) => {
    e.preventDefault();
    const id = document.getElementById("jogadorId").value;
    const payload = {
        nome: document.getElementById("nome").value || null,
        numeroCamisa: document.getElementById("numeroCamisa").value ? Number(document.getElementById("numeroCamisa").value) : null,
        time: document.getElementById("timeId").value ? { id: Number(document.getElementById("timeId").value) } : null
    };
    if(id === "") {
        await fetch(API, { method: "POST", headers: {'Content-Type':'application/json'}, body: JSON.stringify(payload) });
    } else {
        await fetch(`${API}/${id}`, { method: "PUT", headers: {'Content-Type':'application/json'}, body: JSON.stringify(payload) });
    }
    form.reset();
    listar();
});

listar();
