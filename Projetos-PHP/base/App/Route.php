<?php    
    namespace App;
    
    use FW\Init\Boostrap;
    
    class Route extends Boostrap{
     
        public function initRoutes(){
                       
            $routes['home'] = array(
                'route' => '/',
                'controller' => 'IndexController',
                'action' => 'index'
            );
            
            $routes['error-404'] = array(
                'route' => '/error404',
                'controller' => 'ErrorController',
                'action' => 'error404'
            );
                                  
            $this->setRoutes($routes);
            
        }

    }
    
?>