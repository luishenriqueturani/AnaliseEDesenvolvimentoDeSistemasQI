<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css" />
        <title>Atividade Extra</title>
    </head>
    <body>
        <?php
            echo '<table>';
            for ($i = 1; $i <= 10 ; $i++){
                if($i%2 == 0 ){
                    echo "<tr><td>$i</td></tr>";
                }
            }
            echo '</table>';
            echo '<table>';
            for ($index = 0; $index < 2; $index++) {
                echo '<tr>';
                for ($index1 = 0; $index1 < 5; $index1++) {
                    if($index == 0){
                        if($index1 == 0){
                            echo '<td><img src="img/00'.($index1+1).'.png" alt="Imagem do Bulbasaur"></td>';
                        }else if($index1 == 1){
                            echo '<td><img src="img/00'.($index1+1).'.png" alt="Imagem do Ivysaur"></td>';
                        }else if($index1 == 2){
                            echo '<td><img src="img/00'.($index1+1).'.png" alt="Imagem do Venusaur"></td>';
                        }else if($index1 == 3){
                            echo '<td><img src="img/00'.($index1+1).'.png" alt="Imagem do Charmander"></td>';
                        }else if($index1 == 4){
                            echo '<td><img src="img/00'.($index1+1).'.png" alt="Imagem do Charmeleon"></td>';
                        }
                    } else {
                        if($index1 == 0){
                            echo '<td><img src="img/00'.($index1+6).'.png" alt="Imagem do Charizard"></td>';
                        }else if($index1 == 1){
                            echo '<td><img src="img/00'.($index1+6).'.png" alt="Imagem do Squirtle"></td>';
                        }else if($index1 == 2){
                            echo '<td><img src="img/00'.($index1+6).'.png" alt="Imagem do Wartortle"></td>';
                        }else if($index1 == 3){
                            echo '<td><img src="img/00'.($index1+6).'.png" alt="Imagem do Blastoise"></td>';
                        }else if($index1 == 4){
                            echo '<td><img src="img/0'.($index1+6).'.png" alt="Imagem do Caterpie"></td>';
                        }
                    }
                }
                echo '</tr>';
            }
            echo '</table>';
        ?>
    </body>
</html>
