const API = "http://localhost:8080/api/v1/estatisticas";
const tabela = document.getElementById("tabelaEstatisticas");
const form = document.getElementById("formEstatistica");

async function listar() {
    const resp = await fetch(API);
    const dados = await resp.json();
    tabela.innerHTML = "";
    dados.forEach(e => {
        tabela.innerHTML += `
        <tr>
            <td class="border p-2">${e.id}</td>
            <td class="border p-2">${e.tipo}</td>
            <td class="border p-2">${e.valor || ""}</td>
            <td class="border p-2">${e.jogador ? (e.jogador.id || e.jogador) : ""}</td>
            <td class="border p-2">${e.partida ? (e.partida.id || e.partida) : ""}</td>
            <td class="border p-2">
                <button onclick="editar(${e.id})" class="bg-yellow-400 px-2 py-1 rounded">Editar</button>
                <button onclick="deletar(${e.id})" class="bg-red-500 text-white px-2 py-1 rounded">Excluir</button>
            </td>
        </tr>`;
    });
}

async function editar(id) {
    const resp = await fetch(`${API}/${id}`);
    const e = await resp.json();
    document.getElementById("estatId").value = e.id;
    document.getElementById("tipo").value = e.tipo || "";
    document.getElementById("valor").value = e.valor || "";
    document.getElementById("jogadorId").value = e.jogador ? (e.jogador.id || e.jogador) : "";
    document.getElementById("partidaId").value = e.partida ? (e.partida.id || e.partida) : "";
}

async function deletar(id) {
    if(!confirm("Deseja excluir esta estatística?")) return;
    await fetch(`${API}/${id}`, { method: "DELETE" });
    listar();
}

form.addEventListener("submit", async (e) => {
    e.preventDefault();
    const id = document.getElementById("estatId").value;
    const payload = {
        tipo: document.getElementById("tipo").value || null,
        valor: document.getElementById("valor").value ? Number(document.getElementById("valor").value) : null,
        jogador: document.getElementById("jogadorId").value ? { id: Number(document.getElementById("jogadorId").value) } : null,
        partida: document.getElementById("partidaId").value ? { id: Number(document.getElementById("partidaId").value) } : null
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
