const API = "http://localhost:8080/api/v1/inscricoes";
const tabela = document.getElementById("tabelaInscricoes");
const form = document.getElementById("formInscricao");

async function listar() {
    const resp = await fetch(API);
    const dados = await resp.json();
    tabela.innerHTML = "";
    dados.forEach(i => {
        tabela.innerHTML += `
        <tr>
            <td class="border p-2">${i.id}</td>
            <td class="border p-2">${i.dataInscricao || ""}</td>
            <td class="border p-2">${i.campeonato ? (i.campeonato.id || i.campeonato) : ""}</td>
            <td class="border p-2">${i.time ? (i.time.id || i.time) : ""}</td>
            <td class="border p-2">
                <button onclick="editar(${i.id})" class="bg-yellow-400 px-2 py-1 rounded">Editar</button>
                <button onclick="deletar(${i.id})" class="bg-red-500 text-white px-2 py-1 rounded">Excluir</button>
            </td>
        </tr>`;
    });
}

async function editar(id) {
    const resp = await fetch(`${API}/${id}`);
    const i = await resp.json();
    document.getElementById("inscricaoId").value = i.id;
    document.getElementById("dataInscricao").value = i.dataInscricao || "";
    document.getElementById("campeonatoId").value = i.campeonato ? (i.campeonato.id || i.campeonato) : "";
    document.getElementById("timeId").value = i.time ? (i.time.id || i.time) : "";
}

async function deletar(id) {
    if(!confirm("Deseja excluir esta inscrição?")) return;
    await fetch(`${API}/${id}`, { method: "DELETE" });
    listar();
}

form.addEventListener("submit", async (e) => {
    e.preventDefault();
    const id = document.getElementById("inscricaoId").value;
    const payload = {
        dataInscricao: document.getElementById("dataInscricao").value || null,
        campeonato: document.getElementById("campeonatoId").value ? { id: Number(document.getElementById("campeonatoId").value) } : null,
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
