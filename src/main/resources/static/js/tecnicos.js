const API = "http://localhost:8080/api/v1/tecnicos";
const tabela = document.getElementById("tabelaTecnicos");
const form = document.getElementById("formTecnico");

async function listar() {
    const resp = await fetch(API);
    const dados = await resp.json();
    tabela.innerHTML = "";
    dados.forEach(t => {
        tabela.innerHTML += `
        <tr>
            <td class="border p-2">${t.id}</td>
            <td class="border p-2">${t.nome}</td>
            <td class="border p-2">${t.idade || ""}</td>
            <td class="border p-2">${t.time ? (t.time.id || t.time) : ""}</td>
            <td class="border p-2">
                <button onclick="editar(${t.id})" class="bg-yellow-400 px-2 py-1 rounded">Editar</button>
                <button onclick="deletar(${t.id})" class="bg-red-500 text-white px-2 py-1 rounded">Excluir</button>
            </td>
        </tr>`;
    });
}

async function editar(id) {
    const resp = await fetch(`${API}/${id}`);
    const t = await resp.json();
    document.getElementById("tecnicoId").value = t.id;
    document.getElementById("nome").value = t.nome || "";
    document.getElementById("idade").value = t.idade || "";
    document.getElementById("timeId").value = t.time ? (t.time.id || t.time) : "";
}

async function deletar(id) {
    if(!confirm("Deseja excluir este técnico?")) return;
    await fetch(`${API}/${id}`, { method: "DELETE" });
    listar();
}

form.addEventListener("submit", async (e) => {
    e.preventDefault();
    const id = document.getElementById("tecnicoId").value;
    const payload = {
        nome: document.getElementById("nome").value || null,
        idade: document.getElementById("idade").value ? Number(document.getElementById("idade").value) : null,
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
