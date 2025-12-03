const API = "http://localhost:8080/api/v1/fases";
const tabela = document.getElementById("tabelaFases");
const form = document.getElementById("formFase");

async function listar() {
    const resp = await fetch(API);
    const dados = await resp.json();
    tabela.innerHTML = "";
    dados.forEach(f => {
        tabela.innerHTML += `
        <tr>
            <td class="border p-2">${f.id}</td>
            <td class="border p-2">${f.nome}</td>
            <td class="border p-2">${f.campeonato ? (f.campeonato.id || f.campeonato) : ""}</td>
            <td class="border p-2">
                <button onclick="editar(${f.id})" class="bg-yellow-400 px-2 py-1 rounded">Editar</button>
                <button onclick="deletar(${f.id})" class="bg-red-500 text-white px-2 py-1 rounded">Excluir</button>
            </td>
        </tr>`;
    });
}

async function editar(id) {
    const resp = await fetch(`${API}/${id}`);
    const f = await resp.json();
    document.getElementById("faseId").value = f.id;
    document.getElementById("nome").value = f.nome || "";
    document.getElementById("campeonatoId").value = f.campeonato ? (f.campeonato.id || f.campeonato) : "";
}

async function deletar(id) {
    if(!confirm("Deseja excluir esta fase?")) return;
    await fetch(`${API}/${id}`, { method: "DELETE" });
    listar();
}

form.addEventListener("submit", async (e) => {
    e.preventDefault();
    const id = document.getElementById("faseId").value;
    const payload = {
        nome: document.getElementById("nome").value || null,
        campeonato: document.getElementById("campeonatoId").value ? { id: Number(document.getElementById("campeonatoId").value) } : null
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
