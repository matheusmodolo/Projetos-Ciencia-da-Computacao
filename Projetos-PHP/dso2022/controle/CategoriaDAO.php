<?php

require_once 'Conexao.php';

class CategoriaDAO{

    private $conexao;
    private $sql;
    private $resultado;
    private $tabela;

    public function __construct(){
        $conn = new Conexao();
        $this->conexao = $conn->getConexao();
        $this->tabela = "categoria";
    }

    public function cadastrar($dados){
        $this->sql = "insert into $this->tabela (ctg_nome,ctg_descricao) values (:nome,:descricao)";

        $this->resultado = $this->conexao->prepare($this->sql);
        $this->resultado->bindParam(':nome',$dados->getNome());
        $this->resultado->bindParam(':descricao', $dados->getDescricao());

        $this->resultado->execute();

    }

    public function listarDados(){
        $this->sql = "Select * from $this->tabela";

        $this->resultado = $this->conexao->prepare($this->sql);
        $this->resultado->execute();

        return $this->resultado->fetchAll();
    }

}