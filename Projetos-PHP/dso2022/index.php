<?php   
    include 'controle/CategoriaDAO.php';
    $dao = new CategoriaDAO();
    $dados = $dao->listarDados();
?>

<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE-edge">
        <meta http-equiv="Content-Language" content="ptBR">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta name="viewport" content="width=device-width, inicial-scale=1, maximum-scale=1, user-scalabel=no, shrink-to-fit=no">

        <title>CRUD - MODELO</title>
    </head>
    <body>
        <h2>Exemplo de CRUD</h2>
        <h2>Cadastro de categorias</h2>
        <form action="cadastrarCategoria.php" method="POST">
            <label>Nome da Categoria</label>
            <input type="text" name="nome" id="nome" placeholder="Escreva o nome da Categoria">
            <br/>
            <label>Descrição</label><br/>
            <textarea name="descricao" id="descricao" placeholder="Escreva a Descrição da Categoria"></textarea>
            <br/>
            <input type="submit" value="Gravar">
        </form>

        <br/><br/><br/><br/>
        <h1>Listagem de dados da Tabela</h1>
        <?php if(count($dados)==0){ ?>
            <h3>Nenhum dado encontrado</h3>
        <?php }else{ ?>
            <table>
                <thead>
                    <tr>
                        <td>ID</td>
                        <td>Nome</td>
                        <td>Descrição</td>
                        <td>Ações</td>
                    </tr>
                </thead>
                <tbody>
                    <?php foreach($dados as $dado){ ?>
                        <tr>
                            <td><?php echo $dado['ctg_id']; ?></td>
                            <td><?php echo $dado['ctg_nome']; ?></td>
                            <td><?php echo $dado['ctg_descricao']; ?></td>
                            <td>
                                <a href="editarCategoria.php?id=<?php echo $dado['ctg_id']; ?>" >Editar</a>
                                <a href="excluirCategoria.php?id=<?php echo $dado['ctg_id']; ?>" >Excluir</a>
                            </td>
                        </tr>
                    <?php } ?>

                </tbody>

            </table>



        <?php } ?>
    </body>
</html>