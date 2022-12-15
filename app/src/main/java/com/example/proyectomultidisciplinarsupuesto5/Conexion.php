<?php
$hostname = 'localhost';
$database = 'manual';
$username = 'root';
$password = '';

$conexion = new mysqli($hostname, $username, $password, $database);
if ($conexion->connect_errno) {
    echo "El sitio web está experimentado problemas";
}
?>