<?php

    namespace App\Controller;
    
    use FW\Controller\Action;
    
    class IndexController extends Action{

        public function index(){             
            $this->render('index', 'dashboard');
        }
          
	public function validaAutenticacao() {}
    }
    
?>
