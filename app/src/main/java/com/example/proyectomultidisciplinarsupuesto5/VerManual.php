<?php
$c = mysqli_connect("localhost", "root", "", "manual");

$titulo = $_GET ['titulo'];

$sql = "SELECT Textos FROM  textos WHERE idTitulo = (SELECT ID FROM TITULOS WHERE TITULO = '$titulo')";

$query = $c->query($sql);

if ($query) {

    while ($row = $query->fetch_array()) {
        $textos[] = array_map('utf8_encode', $row);
    }
    echo json_encode($textos);

    $query->close();
} else {
    error_log("Debes conectar la base de datos");
}


?>