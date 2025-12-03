const API = "http://localhost:8080/api/v1/partidas";
const tabela = document.getElementById("tabelaPartidas");
const form = document.getElementById("formPartida");

function formatLocalDateTime(value) {
    if(!value) return "";
    // backend sometimes returns "2024-01-01T00:00" or "2024-01-01T00:00:00"
    return value.replace('T', ' ');
}

async function listar() {
    const resp = await fetch(API);
    const dados = await resp.json();
    tabela.innerHTML = "";
    dados.forEach(p => {
        tabela.innerHTML += `
        <tr>
            <td class="border p-2">${p.id}</td>
            <td class="border p-2">${p.dataPartida ? p.dataPartida.replace('T',' ') : ''}</td>
            <td class="border p-2">${p.fase ? (p.fase.id || p.fase) : ""}</td>
            <td class="border p-2">${p.timeCasa ? (p.timeCasa.id || p.timeCasa) : ""}</td>
            <td class="border p-2">${p.timeVisitante ? (p.timeVisitante.id || p.timeVisitante) : ""}</td>
            <td class="border p-2">
                <button onclick="editar(${p.id})" class="bg-yellow-400 px-2 py-1 rounded">Editar</button>
                <button onclick="deletar(${p.id})" class="bg-red-500 text-white px-2 py-1 rounded">Excluir</button>
            </td>
        </tr>`;
    });
}

async function editar(id) {
    const resp = await fetch(`${API}/${id}`);
    const p = await resp.json();
    document.getElementById("partidaId").value = p.id;
    // if backend returns "2024-12-02T20:00:00", convert to datetime-local format "2024-12-02T20:00"
    if (p.dataPartida) {
        let d = p.dataPartida;
        if (d.length > 16) d = d.substring(0,16);
        document.getElementById("dataPartida").value = d;
    } else {
        document.getElementById("dataPartida").value = "";
    }
    document.getElementById("faseId").value = p.fase ? (p.fase.id || p.fase) : "";
    document.getElementById("timeCasaId").value = p.timeCasa ? (p.timeCasa.id || p.timeCasa) : "";
    document.getElementById("timeVisitanteId").value = p.timeVisitante ? (p.timeVisitante.id || p.timeVisitante) : "";
}

async function deletar(id) {
    if(!confirm("Deseja excluir esta partida?")) return;
    await fetch(`${API}/${id}`, { method: "DELETE" });
    listar();
}

form.addEventListener("submit", async (e) => {
    e.preventDefault();
    const id = document.getElementById("partidaId").value;
    const payload = {
        dataPartida: document.getElementById("dataPartida").value ? document.getElementById("dataPartida").value : null,
        fase: document.getElementById("faseId").value ? { id: Number(document.getElementById("faseId").value) } : null,
        timeCasa: document.getElementById("timeCasaId").value ? { id: Number(document.getElementById("timeCasaId").value) } : null,
        timeVisitante: document.getElementById("timeVisitanteId").value ? { id: Number(document.getElementById("timeVisitanteId").value) } : null
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
