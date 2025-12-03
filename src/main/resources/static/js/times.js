const API = "http://localhost:8080/api/v1/times";

const tabela = document.getElementById("tabelaTimes");
const form = document.getElementById("formTime");

async function listar() {
    const resp = await fetch(API);
    const dados = await resp.json();

    tabela.innerHTML = "";

    dados.forEach(t => {
        tabela.innerHTML += `
        <tr>
            <td class="border p-2">${t.id}</td>
            <td class="border p-2">${t.nome}</td>
            <td class="border p-2">${t.cidade || ""}</td>
            <td class="border p-2">
                <button onclick="editar(${t.id})" class="bg-yellow-400 px-2 py-1 rounded">Editar</button>
                <button onclick="deletar(${t.id})" class="bg-red-500 text-white px-2 py-1 rounded">Excluir</button>
            </td>
        </tr>
        `;
    });
}

async function editar(id) {
    const resp = await fetch(`${API}/${id}`);
    const t = await resp.json();

    document.getElementById("timeId").value = t.id;
    document.getElementById("nome").value = t.nome;
    document.getElementById("cidade").value = t.cidade;
}

async function deletar(id) {
    if (!confirm("Deseja excluir?")) return;

    await fetch(`${API}/${id}`, { method: "DELETE" });
    listar();
}

form.addEventListener("submit", async (e) => {
    e.preventDefault();

    const id = document.getElementById("timeId").value;

    const obj = {
        nome: document.getElementById("nome").value,
        cidade: document.getElementById("cidade").value
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
