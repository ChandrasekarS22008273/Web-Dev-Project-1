<?php
$name = $_POST["name"];
$email = $_POST["email"];
$number= $_POST["number"];
$user_name= $_POST["user_name"];
$pw= $_POST["pw"];
$conn = new mysqli("localhost", "root","", "users");
$sql = "INSERT INTO  VALUES('$name','$email','$number','$user_name','$pw')";
if ( $conn->query($sql)=== TRUE)
{
     echo "<h2>New record Inserted successfully</h2>"
;}

else
{ echo "Error: " . $sql . "<br>" . $conn->error;}


$to = $email;
$subject = "My subjec";
$txt = "Hello world!";
$headers = "From: webmaster@example.com" . "\r\n" .
"CC: somebodyelse@example.com";
mail($to,$subject,$txt,$headers);

$conn->close();

?>