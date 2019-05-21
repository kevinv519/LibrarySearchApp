document.querySelector('#searchForm').addEventListener('submit', function(e) {
    let value = document.querySelector('#value').value
    if (value == null || value.trim() == "") {
        alert("No se permiten campos vacíos")
        e.preventDefault()
        return false
    }
})