<?php
$conn = mysqli_connect("localhost","root","","manual");

$sql = "SELECT * FROM TITULOS";

$query = $conn->query($sql);

if ($query){

//    while ($row = $query->fetch_row()){
//        $titulos[] = array_map("utf8_encode",$row);
//    }

    while ($row = $query->fetch_array()){
        $titulos[] = array_map("utf8_encode",$row);
    }

    echo json_encode($titulos);

    $query->close();
}else{
    error_log("Error en la conexión de base de datos");
}
