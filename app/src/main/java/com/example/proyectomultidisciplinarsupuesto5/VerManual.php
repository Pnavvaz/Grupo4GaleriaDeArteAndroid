<?php
$c = mysqli_connect("localhost", "root", "", "manual");

$idTitulo = $_GET ['idTitulo'];

$sql = "SELECT * FROM  textos WHERE idTitulo = '$idTitulo'";

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